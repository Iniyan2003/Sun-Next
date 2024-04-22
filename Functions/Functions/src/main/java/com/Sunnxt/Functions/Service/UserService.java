package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.User;
import com.Sunnxt.Functions.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
