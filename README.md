# spring-mongo-svc
Spring web services project developed using Java 1.8 new features, configured for MongoDB (document) NoSQL database.
Research proof of concept `Java` web services project with `Spring`, `REST` and `MongoDB` based on `Maven`. It uses default database of `MongoDB` i.e. *`test`*. The service is designed to interact with a MongoDB model with association beteween `School` and `Student` entities. The standard `CRUD` operations have been implemented.

## Technologies Used
* Java 8
* Spring 4
* Maven 3
* MongoDB 

## Requirements
* `MongoDB` on your system and should be started
* `Java 8`
* `Maven 3.x`
* `REST` client: You can use any `REST` client out there. I am using [POSTMAN] (https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en) plugin for Chrome.

## How to Run
```
It is a REST based project and there is no UI for it.
So you need to test in some REST client. 
Simply deploy application on your local server and access using REST client
```

## REST URL hits
* **Fetch all schools**: `GET http://localhost:8080/spring-mongo`
* **Insert dummy data**: `POST http://localhost:8080/spring-mongo`
* **Update school**: `PUT http://localhost:8080/spring-mongo/{school_id}`. This will only update schools name to `British International`
* **Fetch a school by its id**: `GET http://localhost:8080/spring-mongo/{school_id}`
* **Delete a school by its id**: `DELETE http://localhost:8080/spring-mongo/{school_id}`
* **Delete all schools**: `DELETE http://localhost:8080/spring-mongo`

## Major components and version
* Java 1.8 (jdk-8u112-windows-x64)
* Tomcat 3.2.2 (pivotal-tc-server-developer-3.2.2.RELEASE)
* Maven (apache-maven-3.3.9)
* Groovy (apache-groovy-sdk-2.4.7)
* Spring 4.3.4 (spring-4.3.4.RELEASE)
* STS 3.8.3 (sts-3.8.3.RELEASE)

## MongoDB details:
* version-> 3.4.0 (mongodb-win32-x86_64-enterprise-windows-64-3.4.0)
* dir-> db.mount.mongo.config
* dir-> db.mount.mongo.data
* dir-> db.mount.mongo.logs

## Structure:

* WEB-INF
* WEB-INF\classes
* WEB-INF\lib
* WEB-INF\resources

## Lib files:

* bson-3.0.4.jar
* com.sun.jersey.jersey-server-1.4.0.jar
* jackson-annotations-2.7.1.jar
* jackson-core-2.7.0.jar
* jackson-databind-2.7.1.jar
* jackson-dataformat-xml-2.7.1.jar
* jackson-module-jaxb-annotations-2.7.1.jar
* javax.servlet-api-3.1.0.jar
* javax.ws.rs-api-2.0.1.jar
* jersey-core-1.19.2.jar
* junit-4.12.jar
* log4j-api-2.1.jar
* log4j-core-2.1.jar
* mongo-java-driver-3.0.4.jar
* org-apache-commons-logging.jar
* slf4j-api.jar
* spring-aop-4.3.4.RELEASE.jar
* spring-aspects-4.3.4.RELEASE.jar
* spring-beans-4.3.4.RELEASE.jar
* spring-context-4.3.4.RELEASE.jar
* spring-context-support-4.3.4.RELEASE.jar
* spring-core-4.3.4.RELEASE.jar
* spring-data-commons-core-1.4.1.RELEASE.jar
* spring-data-jpa-1.10.5.RELEASE.jar
* spring-data-mongodb-1.9.5.RELEASE.jar
* spring-expression-4.3.4.RELEASE.jar
* spring-instrument-4.3.4.RELEASE.jar
* spring-instrument-tomcat-4.3.4.RELEASE.jar
* spring-jdbc-4.3.4.RELEASE.jar
* spring-orm-4.3.4.RELEASE.jar
* spring-web-4.3.4.RELEASE.jar
* spring-webmvc-4.3.4.RELEASE.jar
* stax2-api-3.1.4.jar

## Resources:

* application.properties
* database.properties



