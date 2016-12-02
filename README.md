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

1. The `default` profile which connects the app to mysql using kubernetes service discovery
  * `mvn spring-boot:run` or `java --jar automation-api.jar`

2. The `local` profile which connects to an in memory hsqldb and disables the mysql service discovery
  * `mvn spring-boot:run -D local` or `java --jar automation-api.jar -D local`