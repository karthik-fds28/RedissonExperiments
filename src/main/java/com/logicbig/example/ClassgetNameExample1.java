package com.logicbig.example;

import java.util.ArrayList;
import java.util.List;

public class ClassgetNameExample1 {

    public static void main(String[] args) {
        ClassgetNameExample1 obj = new ClassgetNameExample1();
        Class Class1 = obj.getClass();
        String nm = Class1.getName();
        System.out.println(" The Class Name = " + nm);
        System.out.println(" The Class Name = " + obj.toString());

        List<ClassgetNameExample1> obj2 = new ArrayList();
        Class Class2 = obj2.getClass();
        String nm2 = Class2.getName();
        System.out.println(" The Class Name2 = " + nm2);
      //  Object
    }

}
