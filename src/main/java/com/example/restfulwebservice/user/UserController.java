package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserDAOService service;

    public UserController(UserDAOService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // GET /users/1 or /users/10 -> String -> int 매핑된다.
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return  service.findOne(id);
    }

    @PostMapping("/users")
    public  void createUser(@RequestBody User user) {
        User savedUser = service.save(user);
    }
}
