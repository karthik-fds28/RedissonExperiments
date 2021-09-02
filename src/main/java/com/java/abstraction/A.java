package com.java.abstraction;

public abstract class A {

    int q = 20;

    abstract void m1(int x, double y);

    abstract void m2(String name);

  //  abstract void m4();

     static void m3() {
        System.out.println("IN ABSTRACT CLASS PRIVATE METHOD");
    }

}