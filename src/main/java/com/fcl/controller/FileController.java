package com.fcl.controller;

import com.fcl.entity.vo.FileListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class FileController {

    @GetMapping("/list")
    public FileListVO getFileList() {

        return null;
    }
}
