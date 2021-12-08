# Welcome to the code discussion!

This is a simple guessing game where the objective is to find out what number the computer is thinking about. This
little challenge focuses on starting discussions around code quality, refactoring etc. rather than being a
complex programming test.

## Objective

1. Clone the repository .
2. Run the code and try out the application.
3. Look through the code, change the code, take notes.
4. During a video call, walk us through the code and suggest improvements.

__Suggested areas of discussion__

## Game section

- Try implementing a multiplayer feature where two players takes turn guessing the correct number
- If two players use exactly 3 guesses each to find the correct number their score will be the same. Implement another factor for scoring the players
- Would you refactor or rewrite the game if you get new requirements that for example the game should be about guessing
  cities or colors? How ?
- How would you improve the UI?
- How can you make the game harder or easier to win?

## MySQL section

- Insert a new column in 'user' table which will contain the user's numbers
- Create a new table 'userDetails' which will contain user data added from /addUserData API (see HomeController
  commented method). This table will contain user name, user age, user address. In order to fulfill this, you will have
  to create a model, a service and a repository

## Controller section (for the purpose of this section you may use Postman for testing)

- Create an API that will get details of a specific user by id
- Create an API that will insert a new user

## Instructions for Java

__Requirements__

A working installation of [Java JDK8](https://openjdk.java.net/) with [Maven](https://maven.org/).

__Setup__

1. Clone the repo to your local drive (the folder you will be working with is `java`).
2. Import as Maven project using [IntelliJ](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/). Or
   just use your favorite editor.
3. This project contains MySQL tasks too, in order to be able to work on, you need to setup a local MySQL instance.
4. After creating a MySQL local database, change the configuration from application properties with your configurations
   spring.datasource.url=jdbc:mysql://localhost:3306/yourDatabaseName?createDatabaseIfNotExist=true&serverTimezone=UTC
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword


__The code__

The program entry point is `codereview.CodeReviewApplication`
in `/src/main/java/com/example/codereview/CodeReviewApplication`

__Run the code__
Run this application `CodeReviewApplication -> run`.
