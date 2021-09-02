package com.java.transientExample;

import java.io.*;

class Test implements Serializable {
    // Normal variables
    int i = 10, j = 20;

    // Transient variables
    transient int k = 30;

    // Use of transient has no impact here
    transient static int l = 40;
    transient final int m = 50;

    public static void main(String[] args) throws Exception {
        StringBuilder
        Test input = new Test();

        // serialization
        FileOutputStream fos = new FileOutputStream("/home/oem/KarthikFragmadata/abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);

        // de-serialization
        FileInputStream fis = new FileInputStream("/home/oem/KarthikFragmadata/abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Test output = (Test) ois.readObject();
        System.out.println("i = " + output.i);
        System.out.println("j = " + output.j);
        System.out.println("k = " + output.k);
        System.out.println("l = " + output.l);
        System.out.println("m = " + output.m);
    }

}