package org.example.zacodirartem2.controller;

import lombok.AllArgsConstructor;
import org.example.zacodirartem2.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MainController {
     UserService userService;


    @GetMapping("/")
    public String maiin(Model model) {
        model.addAttribute("users", userService.getAll());
        return "maiin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}

