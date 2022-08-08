package com.example.ecommerce.service;

import com.example.ecommerce.Repository.ItemRepository;
import com.example.ecommerce.domain.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    @Rollback(value = false)
    @Transactional(readOnly = false)
    public void 아이템등록() throws Exception {
        //given
        Item item = new Item();

        item.setName("TestI2tem");
        item.setItemCount(2123);
        item.setRegdata(new Date());
        item.setImgpath("c:/test");
        item.setContent("테스트 2상품입니다.");

        //when
        Long item_id = itemService.registration(item);

        //then
        System.out.println("item_id: " + item_id);
    }

    @Test
    @Rollback(value = false)
    @Transactional(readOnly = true)
    public void 마지막번호조회() throws Exception {

        String imgpath ="C:\\Study_hwang\\SideProjectImg";
        //when
        Long item_id = itemService.getLastId() +1;
        //then
        System.out.println("item_id: " + item_id);

        String lastodiStr = item_id.toString();

        File directoryPath = new File(imgpath+File.separator +lastodiStr); // 디렉토리 파일존재 여부 확인.

        Path dirpath = Paths.get(imgpath+File.separator +lastodiStr); //디렉토리 생성

        String newPath = imgpath+File.separator +lastodiStr;
        System.out.println(newPath);
        /*디렉토리 없을 때 생성 */
        if (!directoryPath.isDirectory()){
            Files.createDirectory(dirpath);
        }

    }
    
    
    
    
    
}