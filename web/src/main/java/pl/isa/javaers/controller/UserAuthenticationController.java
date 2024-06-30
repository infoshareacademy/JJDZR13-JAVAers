package pl.isa.javaers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.isa.javaers.model.User;
import pl.isa.javaers.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserAuthenticationController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;


    public UserAuthenticationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.loadUserByUsername(user.getUsername()).isEnabled()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> optionalUser = userService.findByUsername(user.getUsername());
        if (optionalUser.isPresent() && passwordEncoder.matches(user.getPassword(), optionalUser.get().getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}
