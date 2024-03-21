package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.Bottle;
import de.uniba.dsam.group.project.models.Crate;
import de.uniba.dsam.group.project.models.User;
import de.uniba.dsam.group.project.repos.BottleRepository;
import de.uniba.dsam.group.project.services.CrateService;
import de.uniba.dsam.group.project.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private  UserService userService;
    @Autowired
    private BottleRepository bottleRepository;
    @Autowired
    private  CrateService crateService;
    @Autowired
    private PasswordEncoder passwordEncoder;







    @GetMapping("/")
    public String viewHome(Model model) {
        List<Bottle> bottles = bottleRepository.findAll();
        model.addAttribute("bottles", bottles);

        List<Crate> crates = crateService.getAllCrates();
        model.addAttribute("crates", crates);

        return "home";
    }


    @GetMapping("/login")
    public String viewLogin(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@Valid User newUser, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        User existingUser = userService.getUserByUserName(newUser.getUserName());
        if (existingUser != null) {
            redirectAttributes.addFlashAttribute("message", "Username already exists.");
            return "redirect:/register";
        }

        userService.createUser(newUser);
        redirectAttributes.addFlashAttribute("message", "User successfully registered!");
        return "redirect:/login";
    }

}

