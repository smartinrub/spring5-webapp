package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.model.User;
import org.smartinrubio.spring5webapp.repository.UserRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String userForm() {
        return "registerForm";
    }

    @PostMapping("/register")
    public String userSubmit(@Valid User user,
                             Errors errors,
                             RedirectAttributes model) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        User savedUser = userRepository.save(user);

        model.addAttribute("firstName", savedUser.getFirstName().toLowerCase());
        model.addFlashAttribute("user", savedUser);
        return "redirect:/user/details/{firstName}";
    }

    @GetMapping("/details/{name}")
    public String getUserByName(@PathVariable("name") String name, Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute(userRepository.findByName(name));
        }
        return "user";
    }
}
