package com.fcl.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUpload {
    public static void fileUpload(MultipartFile multipartFile, String filePath, String fileName) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        File file1 = new File(filePath + System.getProperty("file.separator") + fileName);
        multipartFile.transferTo(file1);
    }
}
