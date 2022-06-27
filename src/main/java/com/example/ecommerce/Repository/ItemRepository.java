package com.example.ecommerce.Repository;


import com.example.ecommerce.domain.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private final EntityManager em;

    public ItemRepository(EntityManager em) {
        this.em = em;
    }

    //아이템 저장
    public void save(Item item){em.persist(item);}

    //검색
    public List<Item> findAll() {
        return em.createQuery("select i from item i", Item.class).getResultList();
    }

    //이름 검색
    public List<Item> findByName(String name){
        return em.createQuery("select i from Item i where i.name =:name", Item.class).setParameter("name",name)
                .getResultList();
    }

}
