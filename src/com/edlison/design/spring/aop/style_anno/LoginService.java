package com.edlison.design.spring.aop.style_anno;

import org.springframework.stereotype.Component;

/**
 * LoginService
 *
 * @Author Edlison
 * @Date 2/2/21 23:40
 */
@Component
public interface LoginService {
    void login();
    void logout();
}
