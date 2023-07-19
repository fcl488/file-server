package com.fcl.enums;

import lombok.Getter;

@Getter
public enum FilePathEnum {

    LH("D:\\HS"),
    MMD("D:\\mmd");

    private String filePath;

    FilePathEnum(String filePath) {
        this.filePath = filePath;
    }
}
