package com.krohrmeier.entity;

import com.krohrmeier.entity.Book;

import java.util.List;

/**
 * The class to represent a User of the Art of Words application.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String genres;
    private List<Book> library;

    /**
     * Gets id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets first name.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     * @param firstName the first name
     */
    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets genres.
     * @return the genres
     */
    public String getGenres() {
        return genres;
    }

    /**
     * Sets genres.
     * @param genres the genres
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }


    /**
     * Gets library.
     * @return the library
     */
    public List<Book> getLibrary() {
        return library;
    }

    /**
     * Sets library.
     * @param library the library
     */
    public void setLibrary(List<Book> library) {
        this.library = library;
    }

    /**
     * Adds a book.
     * @param book the book
     */
    public void addToLibrary (Book book) {
        library.add(book);
    }

    /**
     * Removes a book.
     * @param book the book
     */
    public void removeFromLibrary (Book book) {
        library.remove(book);
    }
}
