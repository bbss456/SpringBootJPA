package com.example.ecommerce.controller;

import com.example.ecommerce.domain.Address;
import com.example.ecommerce.domain.Member;
import com.example.ecommerce.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;

@Controller
public class ecommercecontroller {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", "hello!!");
        return "home.html";
    }

    @GetMapping("/membersave")
    public String membersave(Model model) {
               return "member/membersave.html";
    }

    @PostMapping("/post-membersave")
    public String Postmembersave(@RequestParam("id") String id, @RequestParam("name") String name,
                                 @RequestParam("pwd") String pwd, @RequestParam("email") String email,
                                 @RequestParam("year") String year,@RequestParam("month") String month,
                                 @RequestParam("day") String day,@RequestParam("phone") String phone,
                                 @RequestParam("city") String city,@RequestParam("street") String street,
                                 @RequestParam("zipcode") String zipcode, Model model) throws Exception {
        System.out.println("-------------------Post 요청-------------");
        Member member = new Member();


        String birthday = year +"-" + month + "-" + day;

        member.setMember_id(id);
        member.setName(name);
        member.setEmail(email);
        member.setPwd(pwd);
        member.setPhone(phone);
        member.setBirthday(birthday);
        member.setRegdata(new Date());
        member.setAddress(new Address(city, street, zipcode));
        String result = memberService.join(member);

        return "home.html";
    }


    @PostMapping("/login")
    public String login(@RequestBody HashMap<String, Object> map, Model model) {
        System.out.println(" controller" + map);
        Member member = memberService.logincheck(map);
        return "home.html";
    }


}
