package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.model.User;
import org.smartinrubio.spring5webapp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
    public String submitRegistrationForm(@RequestPart("profilePicture") byte[] profilePicture,
                                         @Valid User user,
                                         Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        User savedUser = userRepository.save(user);
        return "redirect:/user/" + savedUser.getFirstName().toLowerCase();
    }

    @GetMapping("/{name}")
    public String getUserByName(@PathVariable("name") String name, Model model) {
        model.addAttribute(userRepository.findByName(name));
        return "user";
    }
}
