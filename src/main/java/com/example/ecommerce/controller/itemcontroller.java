package com.example.ecommerce.controller;


import com.example.ecommerce.domain.Item;
import com.example.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class itemcontroller {

    @Autowired
    ItemService itemService ;


    @GetMapping("/itemregister")
    public String itemregister(Model model) {

        return "item/itemregist.html";
    }

    @GetMapping("/item/detail/{id}")
    public String itemdetail(@PathVariable("id") String id ,Model model) {
        model.addAttribute("id", id);
        List<Item> item = itemService.findItemone(id);
        item.stream().forEach(System.out::println);

        return "item/detail.html";
    }
}
