package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.Reply;
import com.example.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-24
 */
@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    /**
     * 保存用户的回复
     */
    @PutMapping("/saveUserReply")
    public Result saveUserReply(@RequestBody Reply reply){
        try {
            replyService.saveUserReply(reply);
            return Result.succ("回复评论成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

}
