package com.yha.demos.shiroDemo.myRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author www
 * @Description: 自定义仅支持UsernamePasswordToken的Realm实现
 * @create 2017/10/9
 */
public class MyUsernamePasswordRealm implements Realm {

    @Override
    public String getName() {

        return "myUsernamePasswordRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); //获得用户名
        String password = new String((char[]) authenticationToken.getCredentials()); //获得密码
        //示例使用默认的用户名和密码进行验证
        if (!"zhang".equals(username)){
            throw new UnknownAccountException(); //用户名错误
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException(); //密码错误
        }

        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    @Test
    public void testMyUsernamePasswordReal(){
        login("classpath:myRealm1.ini");
        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection collection = subject.getPrincipals();

        Assert.assertEquals(1, collection.asList().size());
    }


    private void login(String configFile) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        subject.login(token);
    }
}
