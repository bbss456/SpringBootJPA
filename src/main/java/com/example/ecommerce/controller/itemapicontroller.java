package com.example.ecommerce.controller;


import com.example.ecommerce.domain.Item;
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
import java.util.Date;

@RestController
public class itemapicontroller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Value("${external.imgpath}")
    private String imgpath;


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

        String fileNameList = req.getParameter("fileNameList"); //파일 key 이름 가져오기.
        String[] ArryFileList = fileNameList.split("@");
        String ImgpathArry=itemService.FileSave(req, dirpath.toString());
        /* 파일 저장 */
        /*
        String ImgpathArry = "";
        int count = 0;
        for (String Filepath : ArryFileList ) {
            MultipartFile file = req.getFile(Filepath);
            String filename = file.getOriginalFilename();
            ImgpathArry += dirpath.toString()+File.separator+filename ;
            if(count != ArryFileList.length ){
                ImgpathArry += "@";
            }
            File f1 = new File( dirpath.toString()+File.separator +filename);
            file.transferTo(f1);
        }
          */
        /* item DB저장하기 */

        Item item = new Item();
        String name = req.getParameter("name");
        item.setName(name);//상품 이름
        int Itemcount = Integer.parseInt(req.getParameter("itemscount").replace(",",""));
        item.setItemCount(Itemcount); //수량
        int Price = Integer.parseInt(req.getParameter("price").replace(",",""));
        item.setPrice(Price); //가격
        String category = req.getParameter("category");
        item.setCategory(category);//카테고리
        item.setRegdata(new Date()); //등록 날짜
        item.setImgpath(ImgpathArry); // 이미지 경로
        String content = req.getParameter("content");
        item.setContent(content); //상품 내용
        itemService.registration(item);


        return "item/itemregist.html";
    }
}
