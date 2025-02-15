package com.week4.day_5.regex;

public class ReplaceAndModifyStrings {
    public static void main(String[] args) {
        String input = "This   is  an   example    with  multiple    spaces.";

        // Replace multiple spaces with a single space
        String output = input.replaceAll("\\s+", " ");

        // Print result
        System.out.println(output);
    }
}

