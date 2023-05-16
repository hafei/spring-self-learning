package org.example.advice;

public class UserServiceAdvice {
    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }
    public void afterReturning(){
        System.out.println("afterReturning");
    }
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
    public void around(){
        System.out.println("around");
    }
}
