package com.week4.day4;


public class ExceptionPropagationInMethods  {


    public static void method1() {
        int result = 10 / 0;
    }

    //  Calls method1()
    public static void method2() {
        method1();
    }
    //main method
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main"); // Handles exception from method1()
        }
    }
}



