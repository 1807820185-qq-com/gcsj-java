package com.example.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {

        JwtToken jwtToken=(JwtToken) Token;

        String userId=jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user=userService.getById(Long.valueOf(userId));
        if(user==null){
            throw new UnknownAccountException("账户不存在");
        }
        if(user.getStatus()==-1){
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile=new AccountProfile();
        BeanUtil.copyProperties(user,profile);

        System.out.println("--------------------");

        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }


}
