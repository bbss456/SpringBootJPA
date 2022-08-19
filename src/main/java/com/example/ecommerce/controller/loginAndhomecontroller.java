package com.example.ecommerce.controller;

import com.example.ecommerce.domain.Address;
import com.example.ecommerce.domain.Item;
import com.example.ecommerce.domain.Member;
import com.example.ecommerce.service.ItemService;
import com.example.ecommerce.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class loginAndhomecontroller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MemberService memberService;

    @Autowired
    ItemService itemService;

    @Value("${external.imgpath:@null}")
    private String imgpath;

    @GetMapping("/")
    public String home(Model model) {
        Item item = new Item();
        List<Item> itemList = itemService.findItems(item);
        ArrayList<String> ImgLogo = new ArrayList<String>();
        model.addAttribute("itemList" ,itemList);
        return "home.html";
    }

    @GetMapping("/membersave")
    public String membersave(Model model) {
               return "member/membersave.html";
    }

    /*Fomr 으로 작성하여 일일이 Param으로 받음 */
    @PostMapping("/post-membersave")
    public RedirectView Postmembersave(@RequestParam("id") String id, @RequestParam("name") String name,
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
        System.out.println(member);
        String result = memberService.join(member);
        System.out.println(result);
        /*
        if( result == null ){
            return "home.html";
        }
        */
        return new RedirectView("/");
    }
    @GetMapping("/logout")
    public RedirectView logout(Model model, HttpSession session) throws Exception {
        session.invalidate();

        return new RedirectView("/");
    }
}
