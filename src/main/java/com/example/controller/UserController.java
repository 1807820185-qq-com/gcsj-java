package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.lang.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：example
 * @since 2023-01-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        Page<User> page=new Page<>();
        User user=new User();
        user.setId(1L);
        List<User> list= userService.list(new QueryWrapper<>(user));

        return Result.succ(list);
    }
    //"通过用户ID获取用户信息"
    @RequestMapping("/getUserinfoById/{id}")
    public Result getUserinfoById(@PathVariable("id") Integer id){
        try {
            User user = userService.queryUserinfoById(id);
            user.setPassword(null);
            return Result.succ(user);
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
    }

}
