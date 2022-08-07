package com.example.ecommerce.controller;


import com.example.ecommerce.domain.Member;
import com.example.ecommerce.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class loginapicontroller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MemberService memberService;

    /**
     * 로그인 확인
     * @param map
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/login")
    public HashMap<String, String> login(@RequestBody HashMap<String, Object> map, HttpSession session , Model model) {
        System.out.println(" controller" + map);
        HashMap<String, String> result = new HashMap<String, String>();
        Member member = memberService.logincheck(map);
        if (member != null) {
            result.put("result", "Success");
            System.out.println(member.getMember_id() + "," + member.getName());
            session.setAttribute("SID", member.getMember_id());
            session.setAttribute("Name", member.getName());
            return result;
        } else {
            result.put("result", "fail");
            return result;
        }
    }
}
