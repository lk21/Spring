package com.lk.logger;

import org.apache.log4j.Logger;  

/** 
 * Created by li on 2015/5/24. 
 */  
  
public class LoggerTest {  
    private static Logger logger = Logger.getLogger(Object.class);  
  
    public static void main(String[] args) {  
        logger.debug("Hello World!");  
        logger.info("Hello this is an info message");
    }  
}  
