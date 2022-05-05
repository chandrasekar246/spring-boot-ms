Spring Data JPA
===============

- Provides repository support for the Java Persistence API (JPA) 
- Eases development of applications that need to access JPA data sources
- CrudRepository interface extends Repository interface
	- save, findById, findAll, count, delete, existsById
- Persistence technology-specific abstractions, such as JpaRepository or MongoRepository extends CrudRepository and expose the capabilities of the underlying persistence technology in addition to generic.
- PagingAndSortingRepository interface extends extends CrudRepository
	- adds additional methods to ease paginated access to entities
	- findAll(Sort sort), findAll(Pageable pageable)
- Supports query methods. E.g. findByLastName
- In addition to query methods, query derivation for both count and delete queries is available. E.g. countByLastName, deleteByLastName
- @NoRepositoryBean: to avoid creating repository proxies
- @Entity - Domain class for JpaRepository
- @Document - Domain class for MongoRepository
- Annotation-driven configuration of base packages
	- @EnableJpaRepositories(basePackages = ""), @EnableMongoRepositories(basePackages = "")
- Query Creation
	- find..By, exists..By, And, Or, Between, LessThan, GreaterThan, Like, IgnoreCase, AllIgnoreCase, OrderBy, Asc, Desc
- Property Expressions
	- x.address.ZipCode -> findByAddressZipCode(zipcode)
- Sort and Pageable expect non-null values - use Sort.unsorted() and Pageable.unpaged()
- Page and Slice
	- Page knows about the total number of elements and pages available
	- As Page might be expensive, you can instead return a Slice. 
	- Slice knows only about whether a next Slice is available, which might be sufficient when walking through a larger result set.

http://localhost:8080/employee

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

=========================================