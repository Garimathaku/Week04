package com.week4.day4;

import java.util.Scanner;

public class FinallyBlockExecution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //take input from the user
        System.out.println("Enter Two integer");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        try{
            int c=n1/n2;
            System.out.println("division of "+n1+" and "+n2+" is "+c);
        }
        catch(ArithmeticException ex){
            ex.printStackTrace();
            System.out.println("Arithmatic exception handled");

        }
        //finally block
        finally {
            System.out.println("It will execute always");
        }

    }
}

