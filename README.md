# Spring Data JDBC Example

This example project uses
* Spring Data JDBC
* Flyway
* H2DB


Initially I wanted to build a small project to manage some of my collections of MP3 music and audio dramas. I wanted to
try a bit of Spring Data JDBC because I just recently read some articles about it. Having some experience with
JPA/Hibernate, it was a good little experience to learn about the basic differences. As I decided to continue my initial
project with JPA I think this might still be a nice little example of how to use Spring Data JDBC with Kotlin.

Use
```shell 
./gradlew.bat bootRun
```
to run the project. This will create the H2DB, run the Flyway migration and runs some commands against the repositories.

