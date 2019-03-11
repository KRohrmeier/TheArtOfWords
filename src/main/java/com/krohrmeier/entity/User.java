package com.krohrmeier.entity;

import java.util.List;
import java.util.Set;

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
    private Set<Literature> library;

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
    public Set<Literature> getLibrary() {
        return library;
    }

    /**
     * Sets library.
     * @param library the library
     */
    public void setLibrary(Set<Literature> library) {
        this.library = library;
    }

    /**
     * Adds a book.
     * @param lit the work of literature
     */
    public void addToLibrary (Literature lit) {
        library.add(lit);
    }

    /**
     * Removes a book.
     * @param lit the work of literature
     */
    public void removeFromLibrary (Literature lit) {
        library.remove(lit);
    }
}
//    CREATE TABLE `user` (
//        `id` int(11) NOT NULL AUTO_INCREMENT,
//        `first_name` varchar(25) NOT NULL,
//        `last_name` varchar(25) NOT NULL,
//        'password' varchar(225) NOT NULL,
//        'email' varchar(50) NOT NULL,
//        'genres' varchar(100) NULL,
//        PRIMARY KEY (`id`),
//        UNIQUE KEY `author_id_uindex` (`id`)
//        )