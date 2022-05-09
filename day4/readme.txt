Global Exception Handling
=========================

- @RestControllerAdvice
- @ExceptionHandler

======================================
Bean Validation
===============

- @Valid
- @Size, @Min, @Max, @NotNull, @Email, @Past, @PastOrPresent, @FutureOrPresent, @Positive

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>

=======================================
OpenAPI Doc (Swagger API Doc)
=============================
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-ui</artifactId>
	<version>1.6.8</version>
</dependency>

http://localhost:8080/swagger-ui/index.html
http://localhost:8080/v3/api-docs

======================================
DTO to Entity Mapping
=====================
<dependency>
	<groupId>org.modelmapper</groupId>
	<artifactId>modelmapper</artifactId>
	<version>0.7.4</version>
</dependency>

=========================================