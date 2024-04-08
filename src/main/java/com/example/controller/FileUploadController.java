package com.example.controller;


import com.example.pojo.Result;
import com.example.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件的内容存储在本地磁盘上
        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
//        file.transferTo(new File("/Users/hughdavis/Computer_Project/fast-news法司新闻/fast-news/files/"+filename));
        String url = AliOssUtil.upLoadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
