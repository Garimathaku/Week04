package com.week4.day_5.regex;

public class ValidateHexColorCode {
    //method to check if the license number is valid or not
    public static boolean  isValidHexColorCode(String code) {
        String pattern = "^#[0-9A-Fa-f]{6}$";
        return code.matches(pattern);

    }
    //main method
    public static void main(String[]args){
        String[]hexColorCode={"#FFA500","#ff4500","#123"};
        for(String code:hexColorCode){
            System.out.println("Hex Color Code"+ ": "+(isValidHexColorCode(code)? "Valid" : "Invalid") );
        }

    }
}
