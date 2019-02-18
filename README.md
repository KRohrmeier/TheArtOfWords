# The Art Of Words

My individual project for Madison College's Enterprise Java Class,
Spring semester 2019.

## Problem Statement

Readers and authors alike need various ways to enjoy, appreciate, and
analyze literary works.

Readers like to explore and appreciate their favorite reads - beyond
reviewing books or talking about their favorite characters and scenes,
readers might create and share fan art. This application will allow
people to easily create a word-oriented fan art to enjoy and to share.

Writers also benefit from new ways of looking at their literary works.
Word art can allow writers to analyze their work for language use and
frequency. As with anything, having a new perspective on something
we're in the middle of can be incredibly informative and useful.
For those writers who would like a visual representation of their
work for publicity reasons, this application
would allow them to easily create and use word art derived from
their own work to liven up blog posts, create a vibrant background
on a website or business card, or even create swag (book bags, posters, etc)
in conjunction with print-on-demand websites.

And last, but not least, word art can simply be a visual way to enjoy a
story or poem.

### Project Technologies/Techniques

Please note: __the following are *in progress* and anticipated but may change!__
Changes will be reflected here when/if applicable.

* Security/Authentication
  * Admin: can save and display word art to own account and to public site
  * User: can save word art to their own accounts
  * All: anyone can view admin-created word art (no login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for the word art
* ORM Framework
  * *TBD*
* Dependency Management
  * Maven
* Web Services consumed using Java
  * *TBD*
* CSS
  * self-made, or Bootstrap
* Data Validation
  * built-in CSS front-end validation (or inherent Bootstrap validations)
  * *TBD* (possibly Explore Hibernate's validation)
* Logging
  * Configurable logging using Log4J2
    * In production, only errors will be logged, but debug-level logging can be turned on to facilitate trouble-shooting
* Hosting
  * AWS
* Independent Research Topic/s

  * *TBD* (but the following are likely:)
  * CI tools in AWS
  * API
  * Hibernate Validation
  * Hibernate Search
  * Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage
* IDE: IntelliJ IDEA

### Design

*forthcoming*

* [User Stories](User_Stories.md)
* [Screen Design](Wireframes.md)
* [Application Flow](#.md)
* [Database Design](#.png)

### [Project Plan](src/main/resources/TimeLog.md)

### [Development Journal](DevelopmentJournal.md)
