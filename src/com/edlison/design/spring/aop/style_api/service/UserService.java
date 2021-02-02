package com.edlison.design.spring.aop.style_api.service;

import org.springframework.stereotype.Component;

/**
 * UserService
 *
 * @Author Edlison
 * @Date 2/2/21 21:48
 */
@Component
public interface UserService {
    void add();
    void delete();
    void update();
    void query();
}
