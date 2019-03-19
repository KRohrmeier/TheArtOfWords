package com.krohrmeier.persistence;

import com.krohrmeier.entity.Book;
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
        database.runSQL("cleandb_user.sql");
    }

    /**
     * Verifies get by id succeeds.
     */
    @Test
    void getByIdSuccess() {
        User actualUser = (User)genericDao.getById(1);
        User expectedUser = new User("Coraline Ada", "Ehmke", "Ada", "all_the_books", "cehmke@madisoncollege.edu", "sci-fi,weird,fantasy,nature,philosophy");
        assertTrue(actualUser.equalsWithoutId(expectedUser));
    }

    /**
     * Verifies get all succeeds.
     */
    @Test
    void getAllSuccess() {
        int expectedLength = 7;
        List<User> actualList = genericDao.getAll();
        int actualLength = actualList.size();
        assertTrue(expectedLength == actualLength);
    }

    /**
     * Verifies update succeeds.
     */
    @Test
    void updateSuccess() {
        String newEmail = "ArtOfWords@gmail.com";
        User userToUpdate = (User) genericDao.getById(1);
        userToUpdate.setEmail(newEmail);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) genericDao.getById(1);
        assertEquals(newEmail, retrievedUser.getEmail());
    }

    /**
     * Verifies insert of user succeeds.
     */
    @Test
    void insertSuccess() {
        User userToInsert = new User("Ada", "Lovelace", "AdaLove", "all_the_books", "love@peacemail.com", "science,nature,electronics");
        int newUsersId = genericDao.insert(userToInsert);
        assertEquals(8, newUsersId);
        assertTrue(userToInsert.equalsWithoutId(genericDao.getById(newUsersId)));
    }

    /**
     * Verifies insert user with library succeeds.
     */
    @Test
    void insertWithLitSuccess() {
        User newUser = new User("Ada", "Lovelace", "AdaLove", "all_the_books", "love@peacemail.com", "science,nature,electronics");
        Set<Book> newLibrary = new HashSet<>();

        newLibrary.add("My Book", "Some Author", "isbn", 2019);
    }

    /**
     * Verifies delete succeeds.
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }

    /**
     * Verifies delete user associated library succeeds.
     */
    @Test
    void deleteUserAssociatedLitSuccess() {}


    /**
     * Verifies get by property equal succeeds.
     */
    @Test
    void getByPropertyEqualSuccess() {
        String firstName = "Caetano";
        int expectedLength = 2;
        List<User> retrievedUsers = genericDao.getByPropertyEqual("firstName", firstName);
        assertEquals(expectedLength, retrievedUsers.size());
        assertEquals(3, retrievedUsers.get(0).getId());
        assertEquals(7, retrievedUsers.get(1).getId());
        assertEquals("Rodriguez", retrievedUsers.get(0).getLastName());
        assertEquals("Lopez", retrievedUsers.get(1).getLastName());
    }

    /**
     * Verifies get by property like succeeds.
     */
    @Test
    void getByPropertyLikeSuccess() {
        String phraseToCheckFor = ".de";
        int expectedLength = 2;
        List<User> retrievedUsers = genericDao.getByPropertyLike("email", phraseToCheckFor);
        assertEquals(expectedLength, retrievedUsers.size());
        assertEquals("mueller@buecher.de", retrievedUsers.get(0).getEmail());
        assertEquals("lolo@buecher.de", retrievedUsers.get(1).getEmail());
    }
}