package org.example.processor;

import org.example.advice.UserServiceAdvice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Proxy;

public class MockBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
//        System.out.println("MockBeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
//        System.out.println("MockBeanPostProcessor.postProcessAfterInitialization");
        UserServiceAdvice advice = applicationContext.getBean(UserServiceAdvice.class);
        if (bean.getClass().getPackage().getName().equals("org.example.service.impl")){
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                advice.before();
                Object result = method.invoke(bean, args);
                advice.after();
                return result;
            });
        }
        return bean;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
