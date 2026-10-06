package com.example.userregistration.service;

import com.example.userregistration.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public String registerUser(User user) {

        for (User existingUser : users) {

            if (existingUser.getEmail()
                    .equalsIgnoreCase(user.getEmail())) {

                return "Email already registered";
            }
        }

        String encodedPassword =
                passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        users.add(user);

        return "Registration successful";
    }

    public boolean loginUser(String email, String password) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)
                    && passwordEncoder.matches(
                            password,
                            user.getPassword())) {

                return true;
            }
        }

        return false;
    }
}