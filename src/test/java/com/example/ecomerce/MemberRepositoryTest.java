package com.example.ecomerce;

import com.example.ShopApplication;
import com.example.ecommerce.Repository.MemberRepository;
import com.example.ecommerce.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes =ShopApplication.class )
class MemberRepositoryTest {


    @Autowired
    private MemberRepository MemberRepository;


    @Test

    public void testMember () throws Exception{

        //Given
        Member member = new Member();
        member.setName("Test");
        member.setEmail("test@test");
        member.setMember_id("Tes3t2");
        LocalDate now = LocalDate.now();
        System.out.println(now);
        member.setRegdata(now);

        //when
       Long saveID =MemberRepository.save(member);
//    //then
//        assertThat(findMember.getId(),equalTo(member.getId())) ;
//        assertThat(findMember.getUsername(),equalTo(member.getUsername())) ;
    }

}
