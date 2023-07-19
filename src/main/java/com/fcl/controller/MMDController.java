package com.fcl.controller;

import com.fcl.entity.CommonResult;
import com.fcl.enums.FilePathEnum;
import com.fcl.utils.FileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * mmd控制器
 */

@Controller
@RequestMapping("/mmd")
@Slf4j
public class MMDController {

    @PostMapping("/upload")
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile multipartFile) {
        String filePath = FilePathEnum.MMD.getFilePath();
        try {
            log.info("上传文件");
            FileUpload.fileUpload(multipartFile, filePath, multipartFile.getOriginalFilename());
            log.info(multipartFile.getOriginalFilename() + " ====> 上传完毕");
            return CommonResult.SUCCESS();
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.FAIL();
        }
    }
}
