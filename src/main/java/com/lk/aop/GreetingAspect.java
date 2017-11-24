package com.lk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class GreetingAspect {
    
    @Around("execution(* com.lk.aop.GreetingImpl.sayHello(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        
        before();
        Object result = pjp.proceed();
        after();
        return result;
        
    }
    
    @DeclareParents(value = "com.lk.aop.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;
    
      private void before() {
      System.out.println("Before:Aspect");
    }
    
    private void after() {
      System.out.println("After:Aspect");
    }

}
