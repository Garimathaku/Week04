package com.week4.day6.annotation.exercise;


class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature");
    }

    void newFeature() {
        System.out.println("This is a new feature");
    }
}

// Main class
public class DeprecatedExample{
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}

