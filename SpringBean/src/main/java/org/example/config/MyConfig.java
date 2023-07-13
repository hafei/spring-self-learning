package org.example.config;

import org.example.bean.JavaBean;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig implements BeanNameAware {
    @Bean
    public JavaBean javaBean(){
        JavaBean javaBean = new JavaBean();
        javaBean.setName("javaBean");
        return javaBean;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("MyConfig.setBeanName: " + name);
    }
}
