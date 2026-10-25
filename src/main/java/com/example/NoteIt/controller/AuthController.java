package com.example.NoteIt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.NoteIt.dto.RegisterRequest;
import com.example.NoteIt.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
    // attributes

    private final UserService userService;

    // methods

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // shows the login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // shows the empty registration form
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    // handles the registration form
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registerRequest") RegisterRequest request,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.register(request);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }

        return "redirect:/login?registered";
    }
}