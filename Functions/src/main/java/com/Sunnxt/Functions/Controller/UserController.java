package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.User;
import com.Sunnxt.Functions.LoginRequest;
import com.Sunnxt.Functions.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createAccount")
    public String createUserAccount(@RequestBody User user) {
        userService.saveUser(user);
        return "Account created successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByUserEmail(loginRequest.getUserEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid email or password";
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
