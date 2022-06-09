package com.example.ecommerce.Repository;


import com.example.ecommerce.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public  String save(Member member){
        em.persist(member);
        return  member.getId();
    }

    public Member find(String id){
        return em.find(Member.class, id);
    }

}