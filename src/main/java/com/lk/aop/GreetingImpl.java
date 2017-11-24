package com.lk.aop;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting{
    
    @Override
    public void sayHello(String name) {
//        before();
        System.out.println("Hello!" + name);
//        after();
//        throw new RuntimeException("Error");
    }
    
//    private void before() {
//        System.out.println("Before");
//    }
//    
//    private void after() {
//        System.out.println("After");
//    }
    public void goodMorning(String name) {
        System.out.println("Good Morning!" + name);
    }
    
    public void goodNight(String name) {
        System.out.println("Good Night!" + name);
    }

}
