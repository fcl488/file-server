package com.fcl.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_file")
public class FilePo {
    private Integer id;
    private String fileName;
    private String filePath;
    private String fileNickName;
}
