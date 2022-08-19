package com.example.ecommerce.controller;


import com.example.ecommerce.domain.Item;
import com.example.ecommerce.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class itemapicontroller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Value("${external.imgpath:@null}")
    private String imgpath;


    @Autowired
    ItemService itemService ;

    @PostMapping("/api/itemregister")
    public ResponseEntity<Map<String,String>> itemregister(Model model, MultipartHttpServletRequest req) throws IOException {

        //마지막 itemOID 값 얻기.
        Long  lastoid =itemService.getLastId() +1;
        String lastodiStr = lastoid.toString();
        System.out.println("------------imgpath-->"+ imgpath);


        File directoryPath = new File(imgpath+lastodiStr); // 디렉토리 파일존재 여부 확인.
        
        Path dirpath = Paths.get(imgpath+lastodiStr); //디렉토리 생성
        
        /*디렉토리 없을 때 생성 */
        if (!directoryPath.isDirectory()){
            Files.createDirectory(dirpath);
        }

        String fileNameList = req.getParameter("fileNameList"); //파일 key 이름 가져오기.
        String[] ArryFileList = fileNameList.split("@");
        String ImgpathArry=itemService.FileSave(req, dirpath.toString());

        System.out.println("___________>IMGpathArry" + ImgpathArry);

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
        Long GetId =itemService.registration(item);

        Map <String,String> datamap = new HashMap<String,String>();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        if(GetId == null) {
            datamap.put("result","실패");
        }else{
            datamap.put("result","성공"); }

        return new ResponseEntity<>(datamap,headers, HttpStatus.OK);
    }
}
