package com.lk.proxy;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;  
import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy; 


public class CGLibProxy implements MethodInterceptor{
    
    //-----------------单例模式---------------------//
    private static CGLibProxy instance = new CGLibProxy();
    
    private CGLibProxy() {
        
    }
    
    public static CGLibProxy getInstance() {
        return instance;
    }
    
    //---------------------------------------------//
    
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }
    
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) 
    throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }
    
    private void before() {
        System.out.println("Before");
    }
    
    private void after() {
        System.out.println("After");
    }
    
    //---------------示例------------------//
    public static void main(String[] args) {
        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("Jack");
    }

    

    

}
