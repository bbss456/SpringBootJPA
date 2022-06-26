package com.example.ecommerce.service;

import com.example.ecommerce.Repository.MemberRepository;
import com.example.ecommerce.domain.Address;
import com.example.ecommerce.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberrepository;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setMember_id("bbsds4dd456333");
        member.setName("황현수");
        member.setEmail("bbss67117@gmail.com");
        member.setPwd("Passwd");
        member.setPhone("010-3078-1207");
        member.setRegdata(new Date());
        member.setAddress(new Address("인천 ", "간석동", "1606호"));
        //when
        String saveId = memberService.join(member);
        //then
        assertEquals(member, memberrepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setMember_id("bbss7");
        member1.setName("황현수");
        member1.setEmail("bbss67117@gmail.com");
        member1.setPwd("Passwd");
        member1.setPhone("010-3078-1207");


        Member member2 = new Member();
        member2.setMember_id("bbs4567778");
        member2.setName("황현수");
        member2.setEmail("bbss67117@gmail.com");
        member2.setPwd("Passwd");
        member2.setPhone("010-3078-1207");

        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }
        //then
        fail("예외가 발생해야 한다.");
    }

    @Test
    public List<Member> 회원정보조회() throws Exception {
         return memberService.findMembers();
    }
}