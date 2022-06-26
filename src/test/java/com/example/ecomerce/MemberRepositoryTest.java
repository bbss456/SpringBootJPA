package com.example.ecomerce;

import com.example.ShopApplication;
import com.example.ecommerce.Repository.MemberRepository;
import com.example.ecommerce.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes =ShopApplication.class )
class MemberRepositoryTest {


    @Autowired
    private MemberRepository MemberRepository;


    @Test

    public void testMember () throws Exception{

        //Given
        Member member = new Member();
        member.setMember_id("bbss456");
        member.setName("황현수");
        member.setPwd("1234");
        member.setEmail("bbss67117@gmail.com");



//        assertThat(findMember.getId(),equalTo(member.getId())) ;
//        assertThat(findMember.getUsername(),equalTo(member.getUsername())) ;
    }

}
