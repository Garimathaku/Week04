package com.week4.day_5.regex;

import java.util.regex.*;
import java.util.*;

public class ExtractLinksFromWebPage {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Regex pattern to match URLs
        String pattern = "https?://(www\\.)?([a-zA-Z0-9.-]+)";

        // Compile regex pattern
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        // Store extracted links in a list
        List<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group());
        }

        // Print extracted links
        System.out.println(String.join(", ", links));
    }
}

