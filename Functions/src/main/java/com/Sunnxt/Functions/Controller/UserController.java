package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.DTO.UserDTO;
import com.Sunnxt.Functions.Entity.User;
import com.Sunnxt.Functions.LoginRequest;
import com.Sunnxt.Functions.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @PostMapping("/createPrimaryAdmin")
    public String createPrimaryAdmin(@RequestBody User user) {
        return "Primary Admin account created successfully!";
    }

    @PostMapping("/createEmployee")
    public User createEmployee(@RequestParam int userId, @RequestBody User user) {
        return userService.createEmployee(userId, user);
    }

    @PostMapping("/createChannel_Admin")
    public User createChannel_Admin(@RequestParam int userId, @RequestBody User user) {
        return userService.createChannel_Admin(userId, user);
    }

    @PostMapping("/createAdmin")
    public User createAdmin(@RequestParam int userId, @RequestBody User user) {
        return userService.createAdmin(userId, user);
    }

    @PostMapping("/userLogin")
    public String userLogin(@RequestBody User loginUser)
    {
        return userService.login(loginUser.getUserEmail(), loginUser.getPassword());
    }



    @PostMapping("/otherLogin")
    public String otherLogin(@RequestBody User loginUser)
    {
        return userService.otherLogin(loginUser.getUserEmail(), loginUser.getPassword());
    }


    @PostMapping("/logout")
    public String logout(@RequestBody User logoutUser) {
        return userService.logout(logoutUser.getUserId());
    }

    @GetMapping("/getLoggedInUsers")
    public Map<Integer, String> getLoggedInUsers()
    {
        return userService.getLoggedInUsers();
    }

    @GetMapping("/getUserLogins")
    public Map<Integer, String> getUserLogins()
    {
        return userService.getUserLogins();
    }

    @GetMapping("/getAdminLogins")
    public Map<Integer, String> getAdminLogins()
    {
        return userService.getAdminLogins();
    }

    @GetMapping("/getEmployeeLogins")
    public Map<Integer, String> getEmployeeLogins()
    {
        return userService.getEmployeeLogins();
    }

    @GetMapping("/getChannel_AdminLogins")
    public Map<Integer, String> getChannel_AdminLogins()
    {
        return userService.getChannel_AdminLogins();
    }


    /*@GetMapping("/users/{userId}")
    public List<User> getAllUsers(@PathVariable("userId") int userId) {
        return userService.getAllUsers(userId);
    }

    @GetMapping("/usersbyID/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }*/

    @GetMapping("/users/{userId}")
    public List<UserDTO> getAllUsers(@PathVariable("userId") int userId) {
        return userService.getAllUsers(userId);
    }

    @GetMapping("/usersbyID/{userId}")
    public UserDTO getUserById(@PathVariable("userId") int userId) {
        return userService.getUserByID(userId);
    }


    @PutMapping("updateProfile/{userId}")
    public User updateProfile (@PathVariable("userId") int userId, @RequestBody User user)
    {
        return userService.updateProfile(userId, user);
    }

    

    public static class PasswordResetRequest {
        public String userEmail;
        public String newPassword;
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordResetRequest request) {
        return userService.resetPassword(request.userEmail, request.newPassword);
    }


    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUserById(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            userService.deleteUserById(userId);
            return "User with ID " + userId + " deleted successfully!";
        } else {
            return "User with ID " + userId + " not found.";
        }
    }
}