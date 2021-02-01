package com.edlison.design.spring.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Role
 *
 * @Author Edlison
 * @Date 2/1/21 14:46
 */
@Component
@Scope("prototype")
public class Role {

    @Value("admin")
    private String role_name;

    public String getRole_name() {
        return role_name;
    }
}
