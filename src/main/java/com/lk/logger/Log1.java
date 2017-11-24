package com.lk.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log1 {
    
    public static void main(String args[]) {
        
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("logger test");
        
    }

}
