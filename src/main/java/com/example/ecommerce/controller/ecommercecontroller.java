package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ecommercecontroller {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", "hello!!");
        return "home.html";
    }

    @GetMapping("/membersave")
    public String membersave(Model model) {
        model.addAttribute("data", "hello!!");
        return "member/membersave.html";
    }
}
