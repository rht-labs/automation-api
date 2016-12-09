# Automation API Server

A simple application to store data that enables Red Hat Open Innovation Labs to automate deployment infrastructure and applications. This application was defined use Swagger. https://github.com/rht-labs/api-design.


Built with 

- Spring Boot
- Spring Cloud Kubernetes 
- Postgres
- JPA
- Flyway
- Swagger Code Generation.

# Usage

This application has two maven profiles that switch the way persistence works

1. The `default` profile which connects the app to postgres. You can run this profile with *either* of the following commands:
  * `mvn spring-boot:run` or
  * `mvn clean install && java -jar target/automation-api.jar`

2. The `local` profile which connects to an in memory hsqldb. You can run this profile with *either* of the following commands:
  * `mvn spring-boot:run -D local` or
  * `mvn clean install -D local && java -jar -Dspring.profiles.active=hsql automation-api.jar`
 
