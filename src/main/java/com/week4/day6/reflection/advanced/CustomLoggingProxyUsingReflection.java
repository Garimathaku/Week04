package com.week4.day6.reflection.advanced;


import java.lang.reflect.*;

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}

class CustomLoggingProxyUsingReflection  {
    public static Greeting createLoggingProxy(Greeting target) {
        return (Greeting) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    // Log method name before executing
                    System.out.println("Executing method: " + method.getName());
                    return method.invoke(target, args);
                });
    }

    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyGreeting = createLoggingProxy(greeting);

        // Call method on proxy
        proxyGreeting.sayHello("John");
    }
}

