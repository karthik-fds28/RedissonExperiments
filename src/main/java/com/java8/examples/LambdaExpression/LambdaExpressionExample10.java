package com.java8.examples.LambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionExample10 {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();

        //Adding Products
        list.add(new Product(1, "HP Laptop", 25000f));
        list.add(new Product(3, "Keyboard", 300f));
        list.add(new Product(2, "Dell Mouse", 150f));

        System.out.println("Sorting on the basis of name...");

        // implementing lambda expression
        Collections.sort(list, (p1, p2) -> p1.name.compareTo(p2.name));
        for (Product p : list) {
            System.out.println(p.id + " " + p.name + " " + p.price);
        }

        /*Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o, Object t1) {

            }
        }*/

    }


}
