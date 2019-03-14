package com.krohrmeier.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets an entity by id
     *
     * @param id the entity's id
     * @return the entity
     */
    public <T>T getById(int id) {
        logger.info("In getById() using id {}", id);
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Save or update an entity
     *
     * @param entity the entity to save or update
     */
    public void saveOrUpdate(T entity) {
        logger.info("In saveOrUpdate() w/ entity {}", entity);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Insert a new entity
     *
     * @param entity, the entity
     * @return id, the id of the newly inserted entity
     */
    public int insert(T entity) {
        logger.info("In insert() w/ entity {}", entity);
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        logger.info("In insert(), id = {}", id);
        return id;
    }

    /**
     * Delete the entity
     *
     * @param entity, the entity to be removed
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all entities from db
     *
     * @return all entities selected according to parameters given
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> entities = session.createQuery(query).getResultList();

        logger.info("In the DAO's getAll() method - list of ALL entities: " + entities);
        session.close();
        return entities;
    }

    /**
     * Get entity by property (exact match)
     * sample: getByPropertyEqual("lastName", "Perez")
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        logger.info("Searching for entity with {} = {}", propertyName, value);
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery(query).getResultList();

        session.close();
        return entities;
    }

    /**
     * Get entity by property (like)
     * sample: getByPropertyLike("lastname", "C")
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        logger.info("Searching for entity with {} = {}", propertyName, value);
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery(query).getResultList();

        session.close();
        return entities;
    }

}
