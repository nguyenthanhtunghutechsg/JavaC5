package com.hutech.tests3.Repositories;

import com.hutech.tests3.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.username=?1")
    User findByUsername(String username);
    @Query("select u.countFail from User u where u.username=?1")
    int countFailByUsername(String username);
    @Query("select u from User u where u.email=?1")
    User findByEmail(String email);
    @Query("select u from User u where u.tokenResetPassword=?1")
    User findByToken(String token);
}