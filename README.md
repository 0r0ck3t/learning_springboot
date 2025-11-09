# learning_springboot
A repository documenting my learning journey with Spring Boot.
This project is a hands-on exercise in building a modern REST API with Spring Boot.

What was accomplished:

Project Setup: Initialized a new Maven project from start.spring.io with Spring Web, Spring Data JPA, and the H2 Database dependencies.

Basic REST Controller: Built a Controller to handle basic web requests, map a "home" page (/), and use @RequestParam to make a dynamic endpoint.

JSON API: Created a DTO (Greeting.java) to automatically serialize Java objects into JSON responses.

Service Layer: Refactored the business logic into a @Service class, demonstrating Dependency Injection using @Autowired on the constructor.

Database Model: Created a User @Entity to model a database table.

Database Repository: Built a UserRepository interface extending JpaRepository to get full, free-of-charge database methods.

Full CRUD API: Built a UserController that implements all four CRUD operations:

CREATE: @PostMapping with @RequestBody to save new users.

READ: @GetMapping for finding all users and a @PathVariable to find one user by ID.

UPDATE: @PutMapping to modify an existing user.

DELETE: @DeleteMapping to remove a user by ID.

Error Handling: Used ResponseEntity to return proper HTTP status codes (like 404 Not Found) from the API.
