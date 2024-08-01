package com.Sunnxt.Functions.Repository;

import com.Sunnxt.Functions.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserEmail(String userEmail);
//
//    User findByEmail(String userEmail);
}
