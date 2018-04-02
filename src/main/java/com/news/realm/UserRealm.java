package com.news.realm;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.news.entity.Admin;
import com.news.service.AdminService;

public class UserRealm extends AuthorizingRealm {
    
    @Autowired
    private AdminService userService;
    
    @Override
    public String getName() {
        return "customRealm";
    }
    
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名称
        String username = (String) token.getPrincipal();
        Admin user = userService.findByUsername(username);
        if (user == null) {
            // 用户名不存在抛出异常
            System.out.println("认证：当前登录的用户不存在");
            throw new UnknownAccountException();
        }
        String pwd = user.getPassword();
        return new SimpleAuthenticationInfo(user, pwd, getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection princ) {
        return null;
    }
}