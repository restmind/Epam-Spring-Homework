# Spring_4 Web MVC Homework

#### Required:
1.	Migrate core business logic related functionality from Servlet-based application to Spring MVC adapting the old project to the correct package structure, naming conventions, etc.:
    -   get rid of all JSP views (now your service will be consuming and populating only JSON text format)
    -	make your service RESTful (don't implement HATEOAS logic for now. It will be accomplished in the scope of future lectures)
    -   the best approach is to start from the scratch and create an empty Spring Boot project using the 'Spring Initializr'.
    -	avoid code copypaste from the old project, unless it relates to the business logic.
    -   the Spring Boot Actuator must be present in the new project.
    -   you could use ‘Postman’ or any other tool to make HTTP calls to your server.
    
2.	Add a logging interceptor to the new 'interceptor' package that will handle all requests and write a log with the user's session id.

3.	Create DTO classes and use them at the controller level.

4.	Add basic validation to DTO classes:
    -	use standard set of hibernate validator annotations.
    -	use different validation groups in combination with **@Validated** annotation.
    
5.	Add logging to all layers of the application.

6.	Configure the ***‘/info’*** endpoint of Actuator.

Optional (would be a great plus):
1. Use any of available open source mapping tool in order to remap from business classes to DTO and vice versa (BeanUtils, MapStruct, etc.)
2. Create custom validation annotations using ConstraintValidatoror. Samples:
    -	check whether there is a user in the database with such username during registration. If so, throw an error.
    -	make a class level validation annotation that will check whether 2 passwords (‘password’ and ‘repeatPassword’ fields) are the same during registration. If not, throw an error.
3. Add multilingual support for exception messages configuring the ‘MessageSource’ bean - https://www.baeldung.com/spring-custom-validation-message-source



# Poject Details
## Car Rental

The system has a list of cars for which it is necessary to implement:
    -   choice by brand
    -   selection by quality class
    -   sorting by rental price
    -   sort by name

And have all the CRUD operations for the car. Add users who will own those cars
