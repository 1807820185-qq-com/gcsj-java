package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2022-10-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User queryUserinfoById(long id) {

        return this.getById(id);
    }
}
