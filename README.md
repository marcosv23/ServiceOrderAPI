#  :pushpin: Service Order API :computer: :earth_asia:

 Service Order API for [Fatec](https://www.fatecsaocaetano.edu.br/).

## :interrobang: For what is this app?
 This backend solution is to solve a real use case enterprise,
 which 'll uses this app to perform service orders, view status, change its status.
 
 This backend has been Developed with Spring boot, JPA, Jakarta Bean Validations,
 and other tools, to deliver the desired result
 
 Service Order API was one working for the **Distributed Systems Subject**
 
 
![diagram](https://user-images.githubusercontent.com/63258483/114637645-3acac600-9ca0-11eb-97c4-3b26cb895a0b.png)

## Requirements to run :heavy_check_mark::running:
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally :running:

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `src/main/java/api/ServiceOrderApiApplication.java` class from your chosen IDE.

A workaround running is to using [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell

mvn spring-boot:run

```

Or else: 

```shell

mvn clean package

```
and:


```shell

 java -jar  target/ServiceOrderApi-0.0.1-SNAPSHOT.jar

```

