# Journal

[Time Log](other/TimeLog.md)

Oh, there'll be words, alright. I may have opinions. You've been warned.

## February 19

Yes, all the annotations we used were javax.persistence annotations, except the one that wasn't - @GenericGenerator, which had me confused. But that is why IntelliJ underlined it in red angry squiggles, because it is a Hibernate annotation.

Also know that removing (senstitive) files from Git using `git filter-branch` does just that, which means by extension that it will remove the file from your working directory and it will be *gone*. Like, if you wanted it just not on your github account, then you should save that sensitive file elsewhere because it will indeed be removed. [Reference](https://help.github.com/articles/removing-sensitive-data-from-a-repository/)

We can leave the dialect tag off if we deploy to Tomcat, apparently because:
      Hibernate can determine the correct dialect to use automatically, but in order to do this, it needs a live connection to the database.
      
However, this does not seem to allow us to run in debug mode.

## February 24

Git does not seem to want to import Week 4's exercise. Over two hours
and it's still thinking about that last 1% before finishing the import.
In the mean time, I'm working on the project. I was hoping to go through
the Hibernate exercise once with the provided code, and then on my own
in the project. Perhaps it will only be in the project.

This has brought me to the realization that I don't know how we configured /
created the data source in IntelliJ. Wish GitHub repos were searchable.

## March 09

Hours of debugging led to realization that the pom.xml file needs to have 
a correct dependency version for `<artifactId>mysql-connector-java</artifactId>`. 
Because if that's wrong you might not be able to connect to your database 
and perform your tests. Now I know. And so do you.

I also know how to create a stack overflow error. Essentially, it is an 
endless loop of mirrored references. Decide beforehand in which class 
you want your references to be shown - in the 