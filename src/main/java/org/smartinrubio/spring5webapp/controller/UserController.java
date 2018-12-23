package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.model.User;
import org.smartinrubio.spring5webapp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String userForm() {
        return "registerForm";
    }

    @PostMapping("/register")
    public String userSubmit(@RequestPart("profilePicture") MultipartFile profilePicture,
                             @Valid User user,
                             Errors errors,
                             RedirectAttributes model) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        LOGGER.info("Upload: " + profilePicture.getName());

        User savedUser = userRepository.save(user);

        model.addAttribute("firstName", savedUser.getFirstName().toLowerCase());
        model.addFlashAttribute("user", savedUser);
        return "redirect:/user/{firstName}";
    }

    @GetMapping("/{name}")
    public String getUserByName(@PathVariable("name") String name, Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute(userRepository.findByName(name));
        }
        return "user";
    }
}
