package org.example.zacodirartem2.controller;

import lombok.AllArgsConstructor;
import org.example.zacodirartem2.entity.UserEntity;
import org.example.zacodirartem2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@AllArgsConstructor
public class RegController {
    UserService userService;

    @GetMapping("/registration")
        public String registration(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
        }

        @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") UserEntity userEntity, Model model) {
        userService.save(userEntity);
        return "redirect:/login";
        }
}
