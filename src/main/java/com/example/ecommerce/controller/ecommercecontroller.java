package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ecommercecontroller {

    @GetMapping("hello1")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "layout/membersave.html";
    }

}
