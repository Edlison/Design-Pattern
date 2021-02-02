package com.edlison.design.spring.aop.style_anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Config
 *
 * @Author Edlison
 * @Date 2/2/21 23:05
 */
@Configuration
@EnableAspectJAutoProxy
public class AnnoAOPConfig {

    @Bean
    public LogAnno logAnno() {
        return new LogAnno();
    }

    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl();
    }
}
