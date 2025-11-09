package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Import this to get all annotations
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional; // Import this


@RestController
@RequestMapping("/users")
public class UserController
{
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    
    //create a new user
    @PostMapping("/add")
    public User createUser(@RequestBody User newUser)
    {
        return userRepository.save(newUser); //save the new user to the database
    }

    //get all users
    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        return userRepository.findAll(); //return all users from the database
    }

    //read a single user searched by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        Optional<User> user = userRepository.findById(id); //indById() returns an "Optional", which is a container that might or might not have a User in it.
        
        if(user.isPresent())
        {
            return ResponseEntity.ok(user.get()); //200 ok and the user
        }
        else
        {
            return ResponseEntity.notFound().build(); //error 404 not found
        }
    }

    //Update a user by id
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails)
    {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent())
        {
            User existingUser = optionalUser.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            //save the updated user
            return ResponseEntity.ok(userRepository.save(existingUser));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete a user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent())
        {
            userRepository.delete(user.get());
            return ResponseEntity.ok().build(); // 200 ok
        }
        else
        {
            return ResponseEntity.notFound().build(); //404 error not found
        }
    }
}
