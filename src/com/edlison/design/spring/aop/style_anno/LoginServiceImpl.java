package com.edlison.design.spring.aop.style_anno;

/**
 * LoginServiceImpl
 *
 * @Author Edlison
 * @Date 2/2/21 23:40
 */

public class LoginServiceImpl implements LoginService{

    @Override
    public void login() {
        System.out.println("现在进行登陆操作");
    }

    @Override
    public void logout() {
        System.out.println("现在进行推出操作");
    }
}
