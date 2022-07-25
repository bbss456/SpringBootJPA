package com.example.ecommerce.service;


import com.example.ecommerce.Repository.MemberRepository;
import com.example.ecommerce.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */
    @Transactional
    public String  join(Member member){
        vaildateDuplicateMember(member);
        memberRepository.save(member);
        return member.getMember_id();
    }

    private void vaildateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findById(member.getMember_id());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    //회원 전체 조회
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Member findOne(String memberID){
        return memberRepository.findOne(memberID);
    }
    
    //로그인 체크 확인
    @Transactional(readOnly = true)
    public Member logincheck(HashMap<String, Object> map){
        String id = (String) map.get("id");
        String pwd = (String) map.get("pwd");
        return memberRepository.logincheck(id, pwd);
    }
}
