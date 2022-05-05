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