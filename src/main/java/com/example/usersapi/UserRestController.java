package com.example.usersapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private UserService userService;

    public UserRestController (UserService userService){
        this.userService = userService;
    }

    @PostMapping ("/users")
    public User createUser (@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping ("/users")
    public List<User> getUsers (){
        return userService.getUserList();
    }
    @DeleteMapping("/users")
    public void deleteUsers (){
         userService.deleteUsers();
    }
    @PutMapping ("/user/{id}")
    public User updateUser (@PathVariable String id, @RequestBody User user) throws Exception {
        return userService.updateUser(id, user);
    }
    @GetMapping ("/users/{id}")
    public User getUser (@PathVariable String id) throws Exception {
        return userService.getUser(id);
    }
    @DeleteMapping ("/users/{id}")
    public void deleteUser (@PathVariable String id) throws Exception {
        userService.deleteUser(id);
    }




}
