package com.example.ecommerce.controller;

import com.example.ecommerce.domain.Item;
import com.example.ecommerce.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)

class itemcontrollerTest {

    @Autowired
    ItemService itemService;

    @Test
    void  itemdetail () {
        //given

        String id = "25";

        //whem
        Item item = itemService.findItemone(Long.parseLong(id));
        System.out.println(item.getImgpath());
        List<String> ImgPathList  = Arrays.stream(item.getImgpath().split("@")).collect(Collectors.toList());
        ImgPathList.stream().forEach(e->System.out.println(e));

    }

}