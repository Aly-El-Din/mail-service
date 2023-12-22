package com.mailserver.controller;

import com.mailserver.model.User;
import com.mailserver.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user/login")
    public boolean logIn(@RequestParam String email,@RequestParam String password){
        User user = userService.getUserByEmail(email.toLowerCase());
        return user != null && user.getPassword().equalsIgnoreCase(password);
    }

    @GetMapping("/user")
    public List<User>getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }


}
