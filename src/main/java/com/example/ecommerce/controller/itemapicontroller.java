package com.example.ecommerce.controller;


import com.example.ecommerce.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class itemapicontroller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/api/itemregister")
    public String itemregister(Model model,
                               @RequestPart(required = false) List<MultipartFile> files,
                               @RequestPart Item item) {
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalfileName = file.getOriginalFilename();
            logger.info("file name = "+file.getOriginalFilename());
        }

        return "item/itemregist.html";
    }
}
