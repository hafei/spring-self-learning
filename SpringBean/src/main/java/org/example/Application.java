package org.example;

import org.example.bean.AnnotationBean;
import org.example.bean.JavaBean;
import org.example.bean.XmlBean;
import org.example.config.AnnotationConfig;
import org.example.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // this is the xml based spring bean configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        XmlBean xmlBean = (XmlBean) context.getBean("xmlBean");
        System.out.println(xmlBean.getName());

        // this is the java config based spring bean configuration
        ApplicationContext context1 = new AnnotationConfigApplicationContext(MyConfig.class);
        JavaBean javaBean = (JavaBean) context1.getBean(JavaBean.class);
        System.out.println(javaBean.getName());

        // this is the annotation based spring bean configuration
        // there are three ways to do this
        // first way
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        AnnotationBean annotationBean = (AnnotationBean) context2.getBean(AnnotationBean.class);
        System.out.println(annotationBean.getName());

        // second way
//        ApplicationContext context3 = new AnnotationConfigApplicationContext("com.example");
//        AnnotationBean annotationBean1 = (AnnotationBean) context3.getBean(AnnotationBean.class);
//        System.out.println(annotationBean1.getName());

        // third way
//        AnnotationConfigApplicationContext context4 = new AnnotationConfigApplicationContext();
//        context4.register(AnnotationConfig.class);
//        context4.refresh();
    }
}
