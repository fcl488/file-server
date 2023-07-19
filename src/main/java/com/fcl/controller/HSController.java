package com.fcl.controller;

import com.fcl.entity.CommonResult;
import com.fcl.entity.DTO.AddFileDataDTO;
import com.fcl.entity.LayuiPage;
import com.fcl.entity.pojo.FilePo;
import com.fcl.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 恋活控制器
 */

@Controller
@RequestMapping("/HS")
public class HSController {

    @Resource
    private FileService fileService;

    @GetMapping("/list")
    @ResponseBody
    public CommonResult getFileList(LayuiPage layuiPage) {
        return fileService.getFileList(layuiPage);
    }

    @PostMapping("/add")
    @ResponseBody
    public CommonResult addFileData(@RequestBody AddFileDataDTO dto) {
        return fileService.addFileData(dto);
    }

    @GetMapping("/download/{id}")
    public void download(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        FilePo filePo = fileService.getById(id);
        FileInputStream fileInputStream =
                new FileInputStream(filePo.getFilePath() +
                        System.getProperty("file.separator") + filePo.getFileName());
        response.reset();
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition",
                "attachment; filename=" + URLEncoder
                        .encode(filePo.getFileName(), "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public CommonResult deleteCard(@PathVariable Integer id) {
        return fileService.deleteCard(id);
    }
}
