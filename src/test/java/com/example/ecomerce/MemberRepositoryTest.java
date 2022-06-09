package com.example.ecomerce;

import com.example.shop.ShopApplication ;
import com.example.ecommerce.Repository.MemberRepository;
import com.example.ecommerce.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes =ShopApplication.class )
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setName("membeccr2A");

        //when
        String saveID = memberRepository.save(member);
        Member findMember = memberRepository.find(saveID);
        //then
        assertThat(findMember.getId(), equalTo(member.getId()));
        assertThat(findMember.getName(), equalTo(member.getName()));


    }

}
