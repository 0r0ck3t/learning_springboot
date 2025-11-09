# learning_springboot
A simple Spring Boot REST API demonstrating full CRUD operations for a User entity using Spring Data JPA and an H2 in-memory database.

How to Run This Project:
Prerequisites
Java 21 (or newer)

Git:

1. Clone the Repository
Open your terminal and clone this repository to your local machine:
git clone https://github.com/your-username/your-repository-name.git
cd your-repository-name

2. Run the Application
This project uses the Maven Wrapper, so you don't need to install Maven. In your terminal, from the root of the project folder, run the following command to start the web server:
./mvnw spring-boot:run
The server will start on http://localhost:8080. Keep this terminal window open.

3. Test the API
While the server is running, you must open a new, separate terminal window to send requests.

Here are the curl commands to test the full CRUD functionality:
3.1. CREATE a new user:
curl -X POST http://localhost:8080/users/add \
-H "Content-Type: application/json" \
-d '{"name":"example", "email":"example@example.com"}'

3.2. READ all users:
curl http://localhost:8080/users/all

3.3 READ a single user (ID 1):
curl http://localhost:8080/users/1

3.4. UPDATE a user (ID 1):
curl -X PUT http://localhost:8080/users/1 \
-H "Content-Type: application/json" \
-d '{"name":"new example", "email":"new-email@example.com"}'

3.5. DELETE a user (ID 1):
curl -X DELETE http://localhost:8080/users/1

3.6. Verify deletion (READ all):
curl http://localhost:8080/users/all
