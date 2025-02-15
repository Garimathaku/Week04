package com.week4.day_5.regex;

public class ValidateUsername {
    public static boolean isValidUsername(String username){
        String pattern= "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(pattern);

    }
    //main method
    public static void main(String[]args){
        String[]usernames={"user_123","123user","us","valid_99","user_name"};

        for(String username: usernames){
            System.out.println(username +": "+(isValidUsername(username)?"valid" : "Invalid"));
        }
    }
}
