package com.lk.JDBCpractice;

import java.util.Scanner;

public class Input {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if(scanner.hasNextInt()) {
                int a = scanner.nextInt();
                System.out.println(a);
                
            }
            if(scanner.hasNext()) {
                String b = scanner.next();
                System.out.println(b);
                
            }
        }
        
        
        
        
        
        
    }
    
    

}


