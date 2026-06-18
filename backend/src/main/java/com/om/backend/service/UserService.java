package com.om.backend.service;

import com.om.backend.model.User;
import com.om.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.om.backend.security.jwt.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {

    if (userRepository.findByUsername(user.getUsername()).isPresent()) {
        throw new RuntimeException("Username already exists");
    }

    if (user.getRole() == null) {
        user.setRole("USER");
    }

    user.setPassword(
        passwordEncoder.encode(
                user.getPassword()
        )
    );

    return userRepository.save(user);
}

    public String login(
        String username,
        String password
    ) {

    User user = userRepository
            .findByUsername(username)
            .orElseThrow(() ->
                    new RuntimeException(
                            "User not found"
                    )
            );

    if (!passwordEncoder.matches(
            password,
            user.getPassword()
    )) {
        throw new RuntimeException(
                "Invalid password"
        );
    }

    return JwtUtil.generateToken(username);
}
}