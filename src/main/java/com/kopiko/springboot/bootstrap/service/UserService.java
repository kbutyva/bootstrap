package com.kopiko.springboot.bootstrap.service;

import com.kopiko.springboot.bootstrap.models.Role;
import com.kopiko.springboot.bootstrap.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll();

    void save(User user);

    User findById(int id);

    void deleteById(int id);

    User getUserByUsername(String username);

    List<Role> findAllRoles();
}
