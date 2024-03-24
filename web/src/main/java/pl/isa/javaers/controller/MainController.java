package pl.isa.javaers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    String welcome(Model model) {
        model.addAttribute("content","_welcome");
        return "index";
    }
    @GetMapping("/alerts")
    String listaAlertów(Model model) {
        model.addAttribute("content", "_alertsList");
        return "index";
    }
}
