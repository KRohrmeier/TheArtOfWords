# Journal

[Time Log](src/main/resources/TimeLog.md)

Oh, there'll be words, alright. I may have opinions. You've been warned.

## February 19

Yes, all the annotations we used were javax.persistence annotations, except the one that wasn't - @GenericGenerator, which had me confused. But that is why IntelliJ underlined it in red angry squiggles, because it is a Hibernate annotation.

Also know that removing (senstitive) files from Git using `git filter-branch` does just that, which means by extension that it will remove the file from your working directory and it will be *gone*. Like, if you wanted it just not on your github account, then you should save that sensitive file elsewhere because it will indeed be removed. [Reference](https://help.github.com/articles/removing-sensitive-data-from-a-repository/)

We can leave the dialect tag off if we deploy to Tomcat, apparently because:
      Hibernate can determine the correct dialect to use automatically, but in order to do this, it needs a live connection to the database.
      
However, this does not seem to allow us to run in debug mode.
