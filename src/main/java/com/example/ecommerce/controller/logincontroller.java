package com.example.ecommerce.controller;

import com.example.ecommerce.domain.Address;
import com.example.ecommerce.domain.Member;
import com.example.ecommerce.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class logincontroller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
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

    /*Fomr 으로 작성하여 일일이 Param으로 받음 */
    @PostMapping("/post-membersave")
    public String Postmembersave(@RequestParam("id") String id, @RequestParam("name") String name,
                                 @RequestParam("pwd") String pwd, @RequestParam("email") String email,
                                 @RequestParam("year") String year,@RequestParam("month") String month,
                                 @RequestParam("day") String day,@RequestParam("phone") String phone,
                                 @RequestParam("city") String city,@RequestParam("street") String street,
                                 @RequestParam("zipcode") String zipcode, Model model) throws Exception {
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
        System.out.println(result);
        /*
        if( result == null ){
            return "home.html";
        }
        */
        return "home.html";
    }
    @GetMapping("/logout")
    public RedirectView logout(Model model, HttpSession session) throws Exception {
        session.invalidate();

        return new RedirectView("/");
    }
}
