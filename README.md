# RESTful API application using Spring Boot + JAX-RS + Hibernate for Multi-Tenancy 
This is a working application implementing a RESTful API in a multi-tenant architecture using:
- Spring Boot
- JAX-RS and Jersey implementation
- Hibernate to implement multi-tenancy

## General notes
Multi-tenancy is implemented using a _separate schema_ approach. The API endpoint defines a GET request to a _product_ object: the tenant identifier is contained inside HTTP header called 'X-TENANT-ID'. 

Run 'mvn spring-boot:run' to start the application and test it using [Postman] (https://www.getpostman.com/) using a GET request 
to http://localhost:8080/product, setting the X-TENANT-ID header to 'tenant_1' or 'tenant_2' to select the database schema.
