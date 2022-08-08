package com.example.ecommerce.service;

import com.example.ecommerce.Repository.ItemRepository;
import com.example.ecommerce.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {
    @Autowired
    private  final  ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //아이템 등록
    @Transactional
    public Long registration(Item item){
        itemRepository.save(item);
        return item.getId();
    }
    @Transactional(readOnly = true)
    //전체 검색
    public List<Item> findItems(Item item){ return itemRepository.findAll();}

    @Transactional(readOnly = true)
    //이름 검색
    public List<Item> findItemone(Item item) {return itemRepository.findByName(item.getName());}

    //마지막 ID값 얻기
    public Long getLastId() {
        return itemRepository.getLastId();
    }

}
