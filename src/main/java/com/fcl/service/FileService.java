package com.fcl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fcl.entity.CommonResult;
import com.fcl.entity.DTO.AddFileDataDTO;
import com.fcl.entity.LayuiPage;
import com.fcl.entity.pojo.FilePo;

public interface FileService extends IService<FilePo> {
    CommonResult getFileList(LayuiPage layuiPage);
    CommonResult addFileData(AddFileDataDTO dto);
    CommonResult deleteCard(Integer id);
}
