package com.week4.day6.reflection.advanced;


import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is serving.");
    }
}

class Client {
    @Inject
    private Service service;

    public void callService() {
        service.serve();
    }
}

public class DependencyInjectionusingReflection {

    public static void injectDependencies(Object object) throws Exception {
        // Get all fields of the class
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                // Get the type of the field
                Class<?> fieldType = field.getType();

                // Create an instance of the field's type
                Object dependency = fieldType.getDeclaredConstructor().newInstance();

                // Set the field value with the created dependency
                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        injectDependencies(client);
        client.callService();
    }
}

