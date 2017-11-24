package com.lk.JDBCpractice;

import java.util.Scanner;

public class abc {
    public static void main(String args[]) {
        int[] num = new int[10];
        String[] letter = new String[10];
        String[] result = new String[20];
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1");
        for(i = 0; i < 3; i++) {
            num[i] = scanner.nextInt();
        }
        
        
        //scanner.nextLine();
        i = 0;
        //Scanner scanner1 = new Scanner(System.in);
        System.out.println("1");
        for(i = 0; i < 3; i++) {
            letter[i] = scanner.next();
        }
        
        
        int k = 0;
        for(i = 0; i < 3; i++) {
            for(int j = 0; j < num[i]; j++) {
                result[k++] = letter[i];
            }
        }
        
        for(i = 0; i < k; i++) {
            System.out.print(result[i] + " ");
        }
        
    }
    
    

}


