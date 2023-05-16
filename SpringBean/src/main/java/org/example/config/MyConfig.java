package org.example.config;

import org.example.bean.JavaBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public JavaBean javaBean(){
        JavaBean javaBean = new JavaBean();
        javaBean.setName("javaBean");
        return javaBean;
    }
}
