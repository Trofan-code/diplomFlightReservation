package com.trofan.flightreservation.controllers;


import com.trofan.flightreservation.entities.User;
import com.trofan.flightreservation.repos.UserRepository;
import com.trofan.flightreservation.services.SecurityService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final BCryptPasswordEncoder encoder;

    @PostMapping(value = "/registerUser")
    @ApiOperation("Registration with email and password")
    public String register(@RequestBody User user) {
        log.info("Inside register()" + user);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User successfully registered";

    }

    @PostMapping(value = "/login")
    @ApiOperation("Login with email and password")
    public Boolean login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return securityService.login(email, password);
    }
}
