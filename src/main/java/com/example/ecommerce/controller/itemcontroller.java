package com.example.ecommerce.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class itemcontroller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/itemregister")
    public String itemregister(Model model) {

        return "item/itemregist.html";
    }
}
