package com.java8.examples.MethodReferences;

public class MethodReference {

    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }

    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = () -> saySomething();
        Sayable sayable1 = MethodReference::saySomething;
        //System.out.println("printed");
        /*Sayable sayable = new Sayable() {
            @Override
            public void say() {
                saySomething();
            }
        };*/

        sayable.say();
        System.out.println("****");
        // Calling interface method
        sayable1.say();

    }

}
