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

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        if (user != null) {
            // Update the fields of the existing user with the new data
            // Assuming all fields can be updated, modify accordingly if not
            user.setUserName(updatedUser.getUserName());
            user.setUserContact(updatedUser.getUserContact());
            user.setUserCountry(updatedUser.getUserCountry());
            // Update other fields similarly

            userService.saveUser(user);
            return "User updated successfully!";
        } else {
            return "User with ID " + id + " not found.";
        }
    }


    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUserById(id);
            return "User with ID " + id + " deleted successfully!";
        } else {
            return "User with ID " + id + " not found.";
        }
    }

}
