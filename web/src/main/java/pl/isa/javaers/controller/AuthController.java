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
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userReg") UserRegDTO userRegDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if(userRegDTO.getUsername().length() < 5) { model
                .addAttribute("messageTitle", "Błąd przy próbie rejestracji użytkownika")
                .addAttribute("messageContent","Nazwa użytkownika nie może być krótsza niż 5 znaków");
            return "message";
        }
        if(userRegDTO.getPassword1().length() < 8) { model
                .addAttribute("messageTitle", "Błąd przy próbie rejestracji użytkownika")
                .addAttribute("messageContent","Hasło nie może być krótsze niż 8 znaków");
            return "message";
        }
        if (!userRegDTO.getPassword1().equals(userRegDTO.getPassword2())) { model
                .addAttribute("messageTitle", "Błąd przy próbie rejestracji użytkownika")
                .addAttribute("messageContent","Hasła nie są zgodne (a powinny).");
            return "message";
        }

        User existingUser = userRepository.findByUsername(userRegDTO.getUsername());
        if (existingUser != null) { model
                .addAttribute("messageTitle", "Błąd przy próbie rejestracji użytkownika")
                .addAttribute("messageContent","Użytkownik o takim loginie już istnieje, proszę ustalić inny.");
            return "message";
        }


        User user = new User();
        user.setUsername(userRegDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegDTO.getPassword1()));
        userRepository.save(user);
        model.addAttribute("messageTitle", "Użytkownik " + userRegDTO.getUsername() + " został zarejestrowany.")
                .addAttribute("messageContent","Proszę się zalogować aby korzystać z pełni możliwości aplikacji.");
        return "message";
    }
}

