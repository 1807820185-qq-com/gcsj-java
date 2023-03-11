package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.lang.Result;
import com.example.entity.Article;
import com.example.entity.Comment;
import com.example.entity.LoadFile;
import com.example.service.LoadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-02-03
 */
@RestController
@RequestMapping("/load-file")
public class LoadFileController {
    @Autowired
    LoadFileService loadFileService;

    @PostMapping("getFileList")
    public Result getFileList(){
        try {
            LambdaQueryWrapper<LoadFile> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.orderByDesc(LoadFile::getCreateTime);
            List<LoadFile> res=loadFileService.list(lambdaQueryWrapper);
            return Result.succ(res);
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
    }

}
