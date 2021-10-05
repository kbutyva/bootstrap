package com.kopiko.springboot.bootstrap.controllers;

import com.kopiko.springboot.bootstrap.models.User;
import com.kopiko.springboot.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String pageForUser(Principal principal, Model model) {
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("email", user.getEmail());
        model.addAttribute("rolesOfUser", user.getAuthorities());
        return "user/show";
    }
}
