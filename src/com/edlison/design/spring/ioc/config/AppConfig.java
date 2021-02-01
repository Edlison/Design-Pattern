package com.edlison.design.spring.ioc.config;

import com.edlison.design.spring.ioc.pojo.Card;
import com.edlison.design.spring.ioc.pojo.People;
import com.edlison.design.spring.ioc.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * AppConfig
 *
 * @Author Edlison
 * @Date 2/1/21 15:31
 */
@Configuration
@ComponentScan("com.edlison.design.spring.ioc.pojo")
@Import(AppConfigPlus.class)
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Student getStu() {
        return new Student();
    }

    @Bean
    public Card card() {
        return new Card();
    }

    @Autowired
    public Student student;
}
