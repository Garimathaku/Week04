package com.week4.day_5.regex;

import java.util.regex.*;

public class ValidateAnIPAddress {
    public static boolean isValidIPv4(String ip) {
        // Regular expression for IPv4 validation
        String pattern = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}"
                + "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])$";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(ip);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] ipAddresses = {
                "192.168.1.1", "255.255.255.255", "0.0.0.0",
                "256.100.100.100", "192.168.1", "192.168.300.1", "abc.def.gha.bcd"
        };

        for (String ip : ipAddresses) {
            System.out.println(ip + " -> " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}

