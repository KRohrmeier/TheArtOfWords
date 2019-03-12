package com.krohrmeier.entity;

public class Literature {

}
//    CREATE TABLE `literature` (
//        `id` int(11) NOT NULL AUTO_INCREMENT,
//        `title` varchar(70) DEFAULT NULL,
//        `author_id` int(11) DEFAULT NULL,
//        `isbn` varchar(25) DEFAULT NULL,
//        `publication_year` int(11) DEFAULT NULL,
//        PRIMARY KEY (`id`),
//        UNIQUE KEY `book_id_uindex` (`id`),
//        UNIQUE KEY `book_isbn_uindex` (`isbn`),
//        KEY `book_author_id_fk` (`author_id`),
//        CONSTRAINT `literature_author_id_fk` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
//        )