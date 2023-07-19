package com.fcl.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fcl.entity.CommonResult;
import com.fcl.entity.DTO.AddFileDataDTO;
import com.fcl.entity.LayuiPage;
import com.fcl.entity.pojo.FilePo;
import com.fcl.enums.FilePathEnum;
import com.fcl.mapper.FilePoMapper;
import com.fcl.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FileServiceImpl extends ServiceImpl<FilePoMapper, FilePo> implements FileService {

    @Resource
    private FilePoMapper filePoMapper;

    @Override
    public CommonResult getFileList(LayuiPage layuiPage) {
        log.info("搜索卡片");
        Page<FilePo> filePage = new Page<>(layuiPage.getPage(), layuiPage.getLimit());
        Page<FilePo> page = this.page(filePage);
        return CommonResult.SUCCESS(page.getRecords());
    }

    @Override
    public CommonResult addFileData(AddFileDataDTO dto) {
        FilePo filePo = new FilePo();
        filePo.setFileName(dto.getFileName());
        filePo.setFilePath(FilePathEnum.LH.getFilePath());
        filePo.setFileNickName(dto.getFileNickName());
        filePoMapper.insert(filePo);
        return CommonResult.SUCCESS();
    }

    @Override
    public CommonResult deleteCard(Integer id) {
        this.removeById(id);
        return CommonResult.SUCCESS();
    }
}
