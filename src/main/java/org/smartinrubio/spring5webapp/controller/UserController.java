package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.model.User;
import org.smartinrubio.spring5webapp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registerForm";
    }

    @PostMapping("/register")
    public String submitRegistrationForm(@Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }
        
        userRepository.save(user);
        return "redirect:/user/" + user.getFirstName().toLowerCase();
    }
}
