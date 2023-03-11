package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2022-10-06
 */
public interface UserService extends IService<User> {
    /**
     * 通过用户id获取用户信息
     * @param id
     * @return
     */
    User queryUserinfoById(long id);

}
