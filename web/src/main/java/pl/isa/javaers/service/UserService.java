package pl.isa.javaers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.isa.javaers.model.User;
import pl.isa.javaers.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Username Not Found Exception"));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
