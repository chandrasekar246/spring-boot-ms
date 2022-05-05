Sample App
==========

GET - http://localhost:8080/employee
GET - http://localhost:8080/employee/1
POST - http://localhost:8080/employee
	{
		"id": 4,
		"name": "Chandra",
		"experience": 10,
		"department": "LOGISTICS"
	}
DELETE - http://localhost:8080/employee/4

=========================================
Actuator
========
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

http://localhost:8080/actuator

management.endpoints.web.base-path=/my-actuator

management.endpoints.web.exposure.include=*

http://localhost:8080/my-actuator/metrics/disk.free

=========================================
Deploy war in external server
=============================

<packaging>war</packaging>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
		</exclusion>
	</exclusions>
</dependency>
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<scope>provided</scope>
</dependency>

- Extend SpringBootServletInitializer and override configure(SpringApplicationBuilder builder)

- mvn clean package

http://localhost:8080/external-server/

NOTE: Won't work with Tomcat 10 (https://github.com/spring-projects/spring-boot/issues/22414)

=========================================