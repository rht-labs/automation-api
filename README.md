# Automation API Server

A simple application to store data that enables Red Hat Open Innovation Labs to automate deployment infrastructure and applications. This application was defined use Swagger. https://github.com/rht-labs/api-design.


Built with

- Spring Boot
- Spring Cloud Kubernetes
- Postgres
- JPA
- Swagger Code Generation.

# Usage

This application has two maven profiles that switch the way persistence works

1. The `default` profile which connects the app to postgres. You can run this profile with *either* of the following commands:
  * `mvn spring-boot:run` or
  * `mvn clean install && java -jar target/automation-api.jar`

2. The `local` profile which connects to an in memory hsqldb. You can run this profile with *either* of the following commands:
  * `mvn spring-boot:run -D hsql` or
  * `mvn clean install -D hsql && java -jar -Dspring.profiles.active=hsql target/automation-api.jar`
 
 # Testing
 
 For simplicity, this codebase is maintained in a single maven module and thus unit and integration tests are separated out using the maven phases. Anything using spring (e.g. for data or MVC or just plain on dependency injection) is considered integration.  
 
 ## Running Tests
Unit test are run via [surefire](https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html), their classes are post fixed with `Test` and bound to maven phase `test`. Integration tests are run via [failsafe](https://maven.apache.org/surefire/maven-failsafe-plugin/integration-test-mojo.html), their classes are post fixed with `IT` and bound to maven phase `integration-test`.