package com.example.ecommerce.Repository;


import com.example.ecommerce.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {


    private final EntityManager em;

    //회원 저장
    public void save(Member member){
        em.persist(member);
    }

    //ID 찾기 및 중복 확인
    public List<Member>  findById(String id){
        return em.createQuery("select m from Member m where m.member_id =:id ", Member.class)
                .setParameter("id", id )
                .getResultList();
    }

    //회원 검색
    public Member findOne(String id ){
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }



    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name =:name", Member.class).setParameter("id",name)
                .getResultList();
    }

    //로그인 확인
    public Member logincheck(String id, String pwd){
        return em.createQuery("select m from Member m where m.member_id = ?1 and m.pwd = ?2", Member.class)
                .setParameter(1, id )
                .setParameter(2, pwd)
                .getSingleResult();
    }

    public List<Member> findMemberItem(String id){
        return em.createQuery("select distinct m from Member m " +
                "join fetch m.orders " +
                "where m.member_id =:id", Member.class)
                .setParameter("id", id )
                .getResultList();
    }

}
