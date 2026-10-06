package com.example.userregistration.controller;

import com.example.userregistration.model.User;
import com.example.userregistration.service.UserService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/register";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        String message = userService.registerUser(user);

        if (message.equals("Email already registered")) {

            model.addAttribute("error", message);

            return "register";
        }

        model.addAttribute("success", message);

        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {

        model.addAttribute("email", "");
        model.addAttribute("password", "");

        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @ModelAttribute("email") String email,
            @ModelAttribute("password") String password,
            Model model) {

        boolean validLogin =
                userService.loginUser(email, password);

        if (validLogin) {
            model.addAttribute(
                    "message",
                    "Login successful"
            );

            return "welcome";
        }

        model.addAttribute(
                "error",
                "Invalid email or password"
        );

        return "login";
    }
}