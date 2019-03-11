package com.krohrmeier.persistence;

import com.krohrmeier.entity.Literature;
import com.krohrmeier.entity.User;
import com.krohrmeier.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 */
class LiteratureDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;

    /**
     * Sets up before each test
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Literature.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Literature
     */
    @Test
    void getByIdSuccess() {}

    /**
     * Verify successful insert of a Literature
     */
    @Test
    void insertSuccess() {}

    /**
     * Verify successful update of a Literature
     */
    @Test
    void updateSuccess() {}

    /**
     * Verify successful delete of a Literature
     */
    @Test
    void deleteSuccess() {}

    /**
     * Verify successful retrieval of all Books
     */
    @Test
    void getAllSuccess() {}

    /**
     * Verify get by property equal succeeds
     */
    @Test
    void getByPropertyEqualSuccess() {}

    /**
     * Verify get by property like succeeds
     */
    @Test
    void getByPropertyLikeSuccess() {}
}