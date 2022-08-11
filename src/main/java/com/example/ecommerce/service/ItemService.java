package com.example.ecommerce.service;

import com.example.ecommerce.Repository.ItemRepository;
import com.example.ecommerce.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {
    @Autowired
    private  final  ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //아이템 등록
    @Transactional
    public Long registration(Item item){
        itemRepository.save(item);
        return item.getId();
    }
    @Transactional(readOnly = true)
    //전체 검색
    public List<Item> findItems(Item item){ return itemRepository.findAll();}

    @Transactional(readOnly = true)
    //이름 검색
    public List<Item> findItemone(Item item) {return itemRepository.findByName(item.getName());}

    //마지막 ID값 얻기
    public Long getLastId() {
        return itemRepository.getLastId();
    }

    public String FileSave(MultipartHttpServletRequest req,String dirpath) throws IOException {
        try {
            String fileNameList = req.getParameter("fileNameList"); //파일 key 이름 가져오기.
            String[] ArryFileList = fileNameList.split("@");
            /* 파일 저장 */
            String ImgpathArry = "";
            int count = 0;
            for (String Filepath : ArryFileList ) {
                MultipartFile file = req.getFile(Filepath);
                String filename = file.getOriginalFilename();
                ImgpathArry += dirpath+ File.separator+filename ;
                if(count != ArryFileList.length-1 ){
                    ImgpathArry += "@";
                }
                count +=1;
                File f1 = new File( dirpath+File.separator +filename);
                file.transferTo(f1);
            }
        return ImgpathArry;
        }catch (Exception e){
            return "Fail";
        }

    }


}
