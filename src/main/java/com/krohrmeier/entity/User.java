package com.krohrmeier.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * The class to represent a User of the Art of Words application.
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<Literature> library;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = false, fetch = FetchType.EAGER)
//    private Set<Role> roles;

    private String password;
    private String email;
    private String genres;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param password  the password
     * @param email     the email
     * @param genres    the genres
     */
    public User(String firstName, String lastName, String userName, String password, String email, String genres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.genres = genres;
    }

    /**
     * Gets an id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets an id.
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
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


    //TODO put roles and library back in once they are created and "hooked up" - test User alone first
    /**
     * Gets roles.
     *
     * @return roles the user roles
     */
//    public Set<Role> getRoles() {
//        return roles;
//    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    //TODO this is a restricted function - ensure it is accessible only to admin roles - week 7 stuff will help
    /**
     * Adds a role.
     * @param role the role to add
     */
//    public void addToRoles (Role role) {
//        roles.add(role);
//    }

    /**
     * Removes a role.
     * @param role the role to remove
     */
//    public void removeFromRoles (Role role) {
//        roles.remove(role);
//    }

    /**
     * Gets library.
     * @return the library
     */
//    public Set<Literature> getLibrary() {
//        return library;
//    }

    /**
     * Sets library.
     * @param library the library
     */
//    public void setLibrary(Set<Literature> library) {
//        this.library = library;
//    }

    /**
     * Adds a book.
     * @param lit the work of literature
     */
//    public void addToLibrary (Literature lit) {
//        library.add(lit);
//    }

    /**
     * Removes a book.
     * @param lit the work of literature
     */
//    public void removeFromLibrary (Literature lit) {
//        library.remove(lit);
//    }


    public boolean equalsWithoutId(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                userName.equals(user.userName) &&
                password.equals(user.password) &&
                email.equals(user.email) &&
                genres.equals(user.genres);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                userName.equals(user.userName) &&
                password.equals(user.password) &&
                email.equals(user.email) &&
                genres.equals(user.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, email, genres);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
//                ", roles=" + roles +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}



//    CREATE TABLE `user` (
//        `id` int(11) NOT NULL AUTO_INCREMENT,
//        `first_name` varchar(25) NOT NULL,
//        `last_name` varchar(25) NULL,
//        `user_name` varchar(25) NOT NULL UNIQUE,
//        'password' varchar(225) NOT NULL,
//        'email' varchar(50) NOT NULL,
//        'genres' varchar(100) NULL,
//        PRIMARY KEY (`id`),
//        UNIQUE KEY `user_id_uindex` (`id`)
//        );