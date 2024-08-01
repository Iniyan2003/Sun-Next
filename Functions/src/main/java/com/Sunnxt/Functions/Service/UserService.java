package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.DTO.UserDTO;
import com.Sunnxt.Functions.Entity.User;
import com.Sunnxt.Functions.Enum.Usertype;
import com.Sunnxt.Functions.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

/*
    public User saveUser(User user){
        return userRepository.save(user);
    }
*/

    private Map<Integer, String> loggedInUsers = new HashMap<>();
    private Map<Integer, String> EmployeeLogins = new HashMap<>();
    private Map<Integer, String> AdminLogins = new HashMap<>();
    private Map<Integer, String> UserLogins = new HashMap<>();
    private Map<Integer, String> Channel_AdminLogins = new HashMap<>();

    public User createPrimaryAdmin(User user) {

        if (user.getUsertype()== Usertype.ADMIN) {

            User savedPrimaryAdmin = userRepository.save(user);
            System.out.println("Primary Admin's Profile saved: " + savedPrimaryAdmin);

            return savedPrimaryAdmin;
        } else {
            throw new IllegalArgumentException("Primary Admin creation is only allowed for UserType.ADMIN");
        }
    }
    public User createUser(User user) {

        if (user.getUsertype()== Usertype.USER) {

            User savedUser = userRepository.save(user);
            System.out.println("User Profile saved: " + savedUser);

            return savedUser;
        } else {
            throw new IllegalArgumentException("Account creation is only allowed for UserType.USER");
        }
    }

    public User createEmployee(int userId, User user) {

        if (AdminLogins.containsKey(userId)) {

            user.setUsertype(Usertype.EMPLOYEE);
            User savedEmployee = userRepository.save(user);
            System.out.println("Employee Profile saved: " + savedEmployee);

            return savedEmployee;
        } else {
            throw new IllegalArgumentException("Employee Account creation is only allowed for UserType.EMPLOYEE");
        }
    }

    public User createChannel_Admin(int userId, User user) {

        if (AdminLogins.containsKey(userId)) {

            user.setUsertype(Usertype.CHANNEL_ADMIN);
            User savedChannel_Admin = userRepository.save(user);
            System.out.println("Channel Admin Profile saved: " + savedChannel_Admin);

            return savedChannel_Admin;
        } else {
            throw new IllegalArgumentException("Channel Admin Account creation is only allowed for UserType.CHANNEL_ADMIN");
        }
    }

    public User createAdmin(int userId, User user) {

        if (AdminLogins.containsKey(userId)) {

            user.setUsertype(Usertype.ADMIN);
            User savedAdmin = userRepository.save(user);
            System.out.println("Admin Profile saved: " + savedAdmin);

            return savedAdmin;
        } else {
            throw new IllegalArgumentException("Admin Account creation is only allowed for UserType.ADMIN");
        }
    }

    public String login(String email, String password) {
        User user = userRepository.findByUserEmail(email);
        if (user != null && user.getPassword().equals(password) && user.getUsertype() == Usertype.USER) {
            int userId = user.getUserId();
            UserLogins.put(userId, email);
            loggedInUsers.put(userId, email);
            return "Login successful!";
        } else {
            return "Only users can login , Check your data";
        }
    }

    public String otherLogin(String email, String password) {
        User user = userRepository.findByUserEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            Usertype usertype = user.getUsertype();
            int userId = user.getUserId();
            switch (usertype) {
                case ADMIN:
                    AdminLogins.put(userId, email);
                    break;
                case EMPLOYEE:
                    EmployeeLogins.put(userId, email);
                    break;
                case CHANNEL_ADMIN:
                    Channel_AdminLogins.put(userId, email);
                    break;
                default:
                    return "Invalid profile type for this login";
            }
            loggedInUsers.put(userId, email);
            return usertype + " Login successful!";
        } else {
            return "Invalid email or password for other login";
        }
    }

    public String logout(int userId) {
        if (loggedInUsers.containsKey(userId)) {
            loggedInUsers.remove(userId);
            AdminLogins.remove(userId);
            EmployeeLogins.remove(userId);
            Channel_AdminLogins.remove(userId);
            return "Logout successful!";
        } else {
            return "User is not logged in";
        }
    }

    public User updateProfile(int userId, User user)
    {
        if (loggedInUsers.containsKey(userId))
        {
            User user1 = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with UserID:" + userId));
            user1.setUserName(user.getUserName());
            user1.setUserEmail(user.getUserEmail());
            user1.setUserContact(user.getUserContact());

            return userRepository.save(user1);
        }
        else
        {
            System.out.println("User must be logged in to update profile");
            throw new IllegalStateException("User not logged in");
        }
    }

    public String resetPassword(String UserEmail, String newPassword) {
        User user = userRepository.findByUserEmail(UserEmail);

        if (user == null) {
            throw new RuntimeException("User with email " + UserEmail + " not found!");
        }

        if (!loggedInUsers.containsKey(user.getUserId())) {
            throw new IllegalStateException("User not logged in");
        }

        user.setPassword(newPassword);
        userRepository.save(user);
        return "Password reset successful!";
    }

    public Map<Integer, String> getLoggedInUsers()
    {
        return new HashMap<>(loggedInUsers);
    }

    public Map<Integer, String> getAdminLogins()
    {
        return new HashMap<>(AdminLogins);
    }

    public Map<Integer, String> getEmployeeLogins()
    {
        return new HashMap<>(EmployeeLogins);
    }

    public Map<Integer, String> getChannel_AdminLogins()
    {
        return new HashMap<>(Channel_AdminLogins);
    }

    public Map<Integer, String> getUserLogins()
    {
        return new HashMap<>(UserLogins);
    }

    public boolean isUserLoggedIn(int userId) {
        return loggedInUsers.containsKey(userId);
    }
    public boolean isEmployeeLoggedIn(int userId) {
        return loggedInUsers.containsKey(userId) && EmployeeLogins.containsKey(userId);
    }

    public boolean isChannelAdminLoggedIn(int userId) {
        return loggedInUsers.containsKey(userId) && Channel_AdminLogins.containsKey(userId);
    }

    public boolean isAdminLoggedIn(int userId)
    {
        return loggedInUsers.containsKey(userId) && AdminLogins.containsKey(userId);
    }

    public boolean isEmpChannelAdmin(int userId) {
        return loggedInUsers.containsKey(userId) && (EmployeeLogins.containsKey(userId) || Channel_AdminLogins.containsKey(userId) || (AdminLogins.containsKey(userId)));
    }

    public boolean isEmpChannel(int userId) {
        return loggedInUsers.containsKey(userId) && (EmployeeLogins.containsKey(userId) || Channel_AdminLogins.containsKey(userId));
    }

//    public User findByUserEmail(String userEmail) {
//        return userRepository.findByUserEmail(userEmail);
//    }
//
//    public User getUserByEmail(String email) {
//        return userRepository.findByUserEmail(email);
//    }

    /*public List<User> getAllUsers(int userId) {
        if (AdminLogins.containsKey(userId)) {
            return userRepository.findAll();
        }

        else {
            return null;
        }
    }*/

    public User getUserById(int userId) {
        if (UserLogins.containsKey(userId)) {
            Optional<User> optionalUser = userRepository.findById(userId);
            return optionalUser.orElse(null);
        }

        else {
            return null;
        }
    }

    public String deleteUserById(int userId) {
        if (UserLogins.containsKey(userId)) {
            userRepository.deleteById(userId);
            return "User deleted successfully!";
        }

        else {
            return "User must be loggedin to delete his user ID!";
        }
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getUserContact(),
                user.getUserCountry(),
                user.getUserState(),
                user.getUserAge(),
                user.getUserGender(),
                user.getUserEmail(),
                "********",  // Masked password
                user.getRegistrationTime(),
                user.getUsertype()
        );
        return userDTO;
    }

    public List<UserDTO> getAllUsers(int userId) {
        if (AdminLogins.containsKey(userId)) {
            List<User> users = userRepository.findAll();
            return users.stream().map(this::convertToDTO).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public UserDTO getUserByID(int userId) {
        if (UserLogins.containsKey(userId)) {
            Optional<User> optionalUser = userRepository.findById(userId);
            return optionalUser.map(this::convertToDTO).orElse(null);
        } else {
            return null;
        }
    }
}
