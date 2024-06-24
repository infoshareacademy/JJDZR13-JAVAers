package pl.isa.javaers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.isa.javaers.dto.UserRegDTO;
import pl.isa.javaers.model.User;
import pl.isa.javaers.repository.UserRepository;

@Controller
public class AuthController {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userReg", new UserRegDTO());
        return "/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userReg") UserRegDTO userRegDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if (!userRegDTO.getPassword1().equals(userRegDTO.getPassword2())) {
            model.addAttribute("passwordError", "Hasła nie są zgodne");
            return "register";
        }

        User existingUser = userRepository.findByUsername(userRegDTO.getUsername());
        if (existingUser != null) {
            model.addAttribute("usernameError", "Użytkownik o takim adresie email już istnieje");
            return "/register";
        }

        User user = new User();
        user.setUsername(userRegDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegDTO.getPassword1()));
        userRepository.save(user);

        return "redirect:/";
    }
}

