package com.lk.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientXML {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Greeting greeting = (Greeting)context.getBean("greetingImpl");
        greeting.sayHello("Jack");
        Apology apology = (Apology)greeting;
        apology.saySorry("Jack");
//        greeting.goodMorning("Jack");
//        greeting.goodNight("Jack");
    }

}
