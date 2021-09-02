package com.java.volatileAndSynchronized;

import java.util.Date;

public class VolatileTest {

    boolean flag = true;

    public void m1() {
        System.out.println("public void m1()="+new Date());
        Runnable r1 = () -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        };

        Runnable r2 = () -> {
            while (flag) {
                System.out.print(".");
            }

        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.m1();
    }

}
