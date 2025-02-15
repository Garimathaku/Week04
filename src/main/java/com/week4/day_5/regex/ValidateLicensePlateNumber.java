package com.week4.day_5.regex;

public class ValidateLicensePlateNumber {
    //method to check if the license number is valid or not
    public static boolean  isValidLicenseNumber(String number) {
        String pattern = "^[A-Z]{2}[0-9]{4}$";
        return number.matches(pattern);

    }
    //main method
       public static void main(String[]args){
           String[]licenseNumber={"AB1234","A12345","MN5678"};
           for(String number:licenseNumber){
               System.out.println("LicenseNumber"+ ": "+(isValidLicenseNumber(number)? "Valid" : "Invalid") );
           }

    }
}
