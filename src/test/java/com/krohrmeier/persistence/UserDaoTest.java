package com.krohrmeier.persistence;

import com.krohrmeier.entity.User;
import com.krohrmeier.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The type User dao test.
 */
public class UserDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;

    /**
     * Sets up before each test
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies get by id succeeds.
     */
    @Test
    void getByIdSuccess() {
        User actualUser = (User)genericDao.getById(1);
        User expectedUser = new User("Kat", "Rohrmeier", "kat", "all_the_books", "kkohler@madisoncollege.edu", "sci-fi,weird,fantasy,nature,philosophy");
        assertTrue(actualUser.equalsWithoutId(expectedUser));
    }

    /**
     * Verifies get all succeeds.
     */
    @Test
    void getAllSuccess() {
        int expectedLength = 5;
        List<User> actualList = genericDao.getAll();
        int actualLength = actualList.size();
        assertTrue(expectedLength == actualLength);
    }

    /**
     * Verifies update succeeds.
     */
    @Test
    void updateSuccess() {}

    /**
     * Verifies insert succeeds.
     */
    @Test
    void insertSuccess() {}

    /**
     * Verifies delete succeeds.
     */
    @Test
    void deleteSuccess() {}

    /**
     * Verifies delete user associated library succeeds.
     */
    @Test
    void deleteUserAssociatedLitSuccess() {}

    /**
     * Verifies insert with library succeeds.
     */
    @Test
    void insertWithLitSuccess() {}

    /**
     * Verifies get by property equal succeeds.
     */
    @Test
    void getByPropertyEqualSuccess() {}

    /**
     * Verifies get by property like succeeds.
     */
    @Test
    void getByPropertyLikeSuccess() {}
}