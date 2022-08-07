package com.example.ecommerce.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class itemapicontroller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/api/itemregister")
    public String itemregister(Model model, MultipartHttpServletRequest req)  {
        String value = req.getParameter("name");
        System.out.println(value);
        MultipartFile file = req.getFile("file_0");
        System.out.println(file.getName());

        return "item/itemregist.html";
    }
}
