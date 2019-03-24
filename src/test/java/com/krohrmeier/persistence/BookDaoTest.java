package com.krohrmeier.persistence;

import com.krohrmeier.entity.Book;
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
class BookDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;

    /**
     * Sets up before each test
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Book.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb_book.sql");
    }

    /**
     * Verify successful retrieval of a book
     */
    @Test
    void getByIdSuccess() {
        //User user = new User("Coraline Ada", "Ehmke", "MEhmke", "all_the_books", "cehmke@madisoncollege.edu", "sci-fi,weird,fantasy,nature,philosophy");
        Book expectedBook = new Book(6,"Red Spikes", "Margo Lanagan", "978-0-375-84304-4", 2006);
        Book actualBook = (Book) genericDao.getById(6);
        logger.info("BookDaoTest - getByIdSuccess: actual book = {}", actualBook);
        assertTrue(expectedBook.equals(actualBook));
    }

    /**
     * Verify successful insert of a book
     */
    @Test
    void insertSuccess() {
        Book bookToInsert = new Book("Morning In the Burned House", "Margaret Atwood", "0-395-82521-0", 1995);
        int expectedId = 8;
        int actualId = genericDao.insert(bookToInsert);
        assertEquals(expectedId, actualId);
        assertTrue(bookToInsert.equalsWithoutId(genericDao.getById(actualId)));
    }

    /**
     * Verify successful update of a book
     */
    @Test
    void updateSuccess() {
        String newTitle = "J";
        Book bookToUpdate = (Book) genericDao.getById(5);
        bookToUpdate.setTitle(newTitle);
        genericDao.saveOrUpdate(bookToUpdate);
        assertEquals(newTitle, ((Book) genericDao.getById(5)).getTitle());
    }

    /**
     * Verify successful delete of a book
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }

    /**
     * Verify successful retrieval of all Books
     */
    @Test
    void getAllSuccess() {
        int expectedLength = 7;
        List<Book> retrievedBooks = genericDao.getAll();
        int actualLength = retrievedBooks.size();
        assertEquals(expectedLength, actualLength);
    }

    /**
     * Verify get by property equal succeeds
     */
    @Test
    void getByPropertyEqualSuccess() {
        int expectedLength = 2;
        List<Book> returnedBooks = genericDao.getByPropertyEqual("publicationYear", "2013");
        int actualLength = returnedBooks.size();
        assertEquals(expectedLength, actualLength);
    }

    /**
     * Verify get by property like succeeds
     */
    @Test
    void getByPropertyLikeSuccess() {
        int expectedLength = 2;
        List<Book> returnedBooks = genericDao.getByPropertyLike("author", "so");
        int actualLength = returnedBooks.size();
        assertEquals(expectedLength, actualLength);
    }
}