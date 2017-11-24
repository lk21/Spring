package com.lk.aop;

public class ApologyImpl implements Apology{

    @Override
    public void saySorry(String name) {
        // TODO Auto-generated method stub
        System.out.println("Sorry!" + name);
    }

}
