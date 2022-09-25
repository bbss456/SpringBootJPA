package com.example.ecommerce.controller;


import com.example.ecommerce.Dto.ImgPathDTO;
import com.example.ecommerce.domain.Item;
import com.example.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Controller
public class itemcontroller {

    @Autowired
    ItemService itemService ;


    @GetMapping("/itemregister")
    public String itemregister(Model model) {

        return "item/itemregist.html";
    }

    /**
     * 상품 디테일 확인. 실무 에선 requestDTO , responseDTP 만들어서 할 것.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/item/detail/{id}")
    public String itemdetail(@PathVariable("id") String id ,Model model) {
        model.addAttribute("id", id);
        Item item = itemService.findItemone(Long.parseLong(id));

        String[] imgpathArr = item.getImgpath().split("@");

        List<ImgPathDTO> ImgPathList  = new ArrayList<>();

        for(String imgPath : imgpathArr) {
           ImgPathDTO imgPathDTO = new ImgPathDTO() ;
            imgPathDTO.setImagePath(imgPath);
           ImgPathList.add(imgPathDTO);
        }

        model.addAttribute("ItemImgPath", ImgPathList);
        model.addAttribute("ImgSize", ImgPathList.size());
        model.addAttribute("ItemInfo", item);

        return "item/detail.html";
    }
}
