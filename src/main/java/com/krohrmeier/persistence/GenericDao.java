package com.krohrmeier.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

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



    /**
     * Delete the entity
     *
     * @param entity, the entity to be removed
     */



    /**
     * Gets all entities from db
     *
     * @return all entities selected according to parameters given
     */


    /**
     * Get entity by property (exact match)
     * sample: getByPropertyEqual("lastName", "Perez")
     */


    /**
     * Get entity by property (like)
     * sample: getByPropertyLike("lastname", "C")
     */

}
