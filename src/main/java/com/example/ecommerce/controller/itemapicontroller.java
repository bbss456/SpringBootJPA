package com.example.ecommerce.controller;


import com.example.ecommerce.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class itemapicontroller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${external.imgpath}")
    private static String imgpath;

    @Autowired
    ItemService itemService ;

    @PostMapping("/api/itemregister")
    public String itemregister(Model model, MultipartHttpServletRequest req) throws IOException {

        //마지막 itemOID 값 얻기.
        Long  lastoid =itemService.getLastId() +1;
        String lastodiStr = lastoid.toString();

        File directoryPath = new File(imgpath+lastodiStr); // 디렉토리 파일존재 여부 확인.
        
        Path dirpath = Paths.get(imgpath+lastodiStr); //디렉토리 생성

        /*디렉토리 없을 때 생성 */
        if (!directoryPath.isDirectory()){
            Files.createDirectory(dirpath);
        }

        /*
        String value = req.getParameter("name");
        System.out.println(value);
        MultipartFile file = req.getFile("file_0");
        System.out.println(file.getName());
        String filename = file.getOriginalFilename();
        File f1 = new File( imgpath +filename);
        file.transferTo(f1);
        */
        return "item/itemregist.html";
    }
}
