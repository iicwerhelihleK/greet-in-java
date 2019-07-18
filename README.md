# greet_in_java

[![Build Status](https://travis-ci.org/ODeeKula/greet-in-java.svg?branch=master)](https://travis-ci.org/ODeeKula/greet-in-java)


Create a Java console app that can greet users in three or more different languages. The app should keep count of how many times a user have been greeted. And a count of how many different users has been greeted.

The app should prompt the user to enter a command.

Valid commands are:

> greet followed by the name and the language the user is to be greeted in,
> greeted should display a list of all users that has been greeted and how many time each user has been greeted,
> greeted followed by a username returns how many times that username have been greeted,
> counter returns a count of how many unique users has been greeted,
clear deletes of all users greeted and the reset the greet counter to 0,
clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,
exit exits the application,
help shows a user an overview of all possible commands.
Your program should:

be able to greet a user in at least three different languages,
have a default language it greet users if now language is specified,
keep count of how many times a specific username is greeted - ignore case differences.
Notify the user of invalid commands.

Use:

use the java.util.Scanner class to read user commands from the console,
maven,
TDD with JUnit run your tests with Maven - test your Classes well.
