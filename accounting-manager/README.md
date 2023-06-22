# Accounting Manager
A Accounting Manager Service within the Community Workspace for Small Communities with Spring Boot 3.0.7, JDK 17 & Maven.

Accounting Manager service runs on 8081 port.

## Table of Contents

1. [How to Contribute](#how-to-contribute)
2. [Credits](#credits)
3. [Requirements](#requirements)
4. [Coding Standards](#coding-standards)
5. [Version Control Standards](#version-control-standards)
6. [Running the Application Locally](#running-the-application-locally)
7. [Running the Application in Docker](#running-the-application-in-docker)
8. [Run Actuator](#run-actuator)
9. [Extra Notes](#extra-notes)
10. [Copyright](#copyright)

## How to Contribute

For the contributor covenant to this project, please check the Code of Conduct file.

[![Contributor Covenant][contributor-covenant-badge]](CODE_OF_CONDUCT.md)

## Credits

Please check the [Contributors List](CONTRIBUTORS.md) to see who makes this open-source alive.

## Requirements

For building and running the application belows are required;

- [Spring Boot 3.0.7][spring-boot-version]
- [JDK 17][java-version]
- [Maven 3.8.x or above][maven-version]
- Eureka Server
- [Flyway DB Migration][flyway-db-migration]
- Spring Boot Actuator

## Coding Standards

Below coding standards should be followed within the project;

- Javadoc should be written for each class & method. @author, @since annotations should be added while adding or updating the javadoc
- General code structure should be followed while adding or refactoring classes.

## Version Control Standards

Version control standards should be followed within the project according to the [main README][main-readme-file-location] file.

## Running the Application Locally

Application can be run with [AccountingManagerApplication][accounting-manager-main-class] class.

Alternatively you can use the [Spring Boot Maven plugin][spring-boot-maven-plugin] like so:

```shell
mvn clean install
mvn spring-boot:run
```

Local & development configuration properties are stored under [Accounting Manager Configuration Properties][accounting-manager-configuration-properties].

## Running the Application in Docker

Application can be run in Docker. [Dockerfile](Dockerfile) in the project root folder is the configuration file for Docker build.

```shell
mvn clean package
docker build -t service-discovery .
docker run -p 6969:6969 --name AccountingServiceAccountingManager accounting-manager
```

## Run Actuator

[Spring Boot Actuator][spring-boot-actuator] can be reached from [local url for Actuator][local-actuator].

Only health and caches endpoints are enabled by default. Configuration can be updated within the "actuator" section of the related application.properties file. 

## Extra Notes

* The module can be booted with Spring Cloud Config Server or directly within the application. In order to boot the project within itself, enable the properties in application.properties file and disable bootstrap.properties file.

## Copyright

GNU General Public License v3.0
Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.

[evren-tan-github]: https://github.com/evrentan
[spring-boot-version]: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Release-Notes
[java-version]: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
[maven-version]: https://maven.apache.org/docs/history.html
[contributor-covenant-badge]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg
[accounting-workspace-github]: https://github.com/evrentan/accounting-workspace
[accounting-manager-main-class]: src/main/java/evrentan/accounting/accountingmanager/spring/spring/AccountingManagerApplication.java
[spring-boot-maven-plugin]: https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/
[spring-boot-actuator]: https://spring.io/guides/gs/actuator-service/
[local-actuator]: http://localhost:8081/actuator
[main-readme-file-location]: https://github.com/evrentan/accounting-workspace/blob/staging/README.md
[accounting-manager-configuration-properties]: src/main/resources/application.properties
[flyway-db-migration]: https://flywaydb.org/