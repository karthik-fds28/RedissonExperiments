package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExamples {

    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        RList<String> list = redisson.getList("myList");
     /*   list.add("1");
        list.add("2");
        list.add("3");

        list.contains("1");

        String valueAtIndex = list.get(3);
        System.out.println(valueAtIndex);

        for (String string : list) {
            // iteration through bulk loaded values
            System.out.println(string);
        }*/

/*
        boolean removedValue = list.remove("1");
        list.removeAll(Arrays.asList("1", "2", "3"));
        list.containsAll(Arrays.asList("4", "1", "0"));

        List<String> secondList = new ArrayList<>();
        secondList.add("4");
        secondList.add("5");
        list.addAll(secondList);

        // fetch all objects
        List<String> allValues = list.readAll();
*/
        int i = list.addAfter("3", "7");

        int i1 = list.addBefore("4", "6");


        // use fast* methods when previous value is not required

        list.fastSet(1, "6");
        list.fastRemove(3);


        redisson.shutdown();
    }

}
