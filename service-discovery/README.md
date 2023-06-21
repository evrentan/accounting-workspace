# Service Discovery
Service Discovery is an application working as a service discovery within the Accounting Workspace microservice architecture based modules.

Service Discovery module runs on 6969 port and can be reached from the link: http://localhost:6969/

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

- [Spring Boot 3.0.0][spring-boot-version]
- [JDK 17][java-version]
- [Maven 3.8.x or above][maven-version]
- Eureka Server
- Spring Cloud Config Server
- Spring Boot Actuator

## Coding Standards

Below coding standards should be followed within the project;

- Javadoc should be written for each class & method. @author, @since annotations should be added while adding or updating the javadoc
- General code structure should be followed while adding or refactoring classes.

## Version Control Standards

Version control standards should be followed within the project according to the [main README][main-readme-file-location] file.

## Running the Application Locally

Application can be run with [ServiceDiscoveryApplication][service-discovery-main-class] class.

Alternatively you can use the [Spring Boot Maven plugin][spring-boot-maven-plugin] like so:

```shell
mvn clean install
mvn spring-boot:run
```

Local & development configuration properties are stored under [Service Discovery Configuration Properties][service-discovery-configuration-properties]. For example, you can update your discovery server information from the related file.

## Running the Application in Docker

Application can be run in Docker. [Dockerfile](Dockerfile) in the project root folder is the configuration file for Docker build.

```shell
mvn clean install
docker build -t service-discovery:1.0.0 .
docker run -p 6969:6969 --name AccountingServiceDiscoveryService service-discovery:1.0.0
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
[service-discovery-main-class]: src/main/java/evrentan/accounting/servicediscovery/spring/spring/ServiceDiscoveryApplication.java
[spring-boot-maven-plugin]: https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/
[spring-boot-actuator]: https://spring.io/guides/gs/actuator-service/
[local-actuator]: http://localhost:6969/actuator
[main-readme-file-location]: https://github.com/evrentan/accounting-workspace/blob/staging/README.md
[service-discovery-configuration-properties]: src/main/resources/application.properties