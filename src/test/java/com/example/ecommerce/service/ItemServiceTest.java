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

        item.setName("TestItem");
        item.setItemCount(2123);
        item.setRegdata(new Date());
        item.setImgpath("c:/test");
        item.setContent("테스트 상품입니다.");

        //when
        Long item_id = itemService.registration(item);

        //then
        System.out.println("item_id: " + item_id);
    }
}