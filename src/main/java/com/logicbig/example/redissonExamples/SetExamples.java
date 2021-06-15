package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;

import java.util.Arrays;
import java.util.Set;

public class SetExamples {

    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        RSet<String> set = redisson.getSet("mySet");
        set.add("1");
        set.add("2");
        set.add("3");


        boolean contains = set.contains("1");
        System.out.println("contains=" + contains);

        for (String string : set) {
            // iteration through bulk loaded values
            System.out.println("setValue" + string);

        }

/*

        boolean removedValue = set.remove("1");
        System.out.println("removedValue=" + removedValue);

        set.removeAll(Arrays.asList("1", "2", "3"));
        boolean b = set.containsAll(Arrays.asList("4", "1", "0"));

        System.out.println("containsAll=" + b);

        String randomRemovedValue = set.removeRandom();
        String randomValue = set.random();

        RSet<String> secondsSet = redisson.getSet("mySecondsSet");
        secondsSet.add("4");
        secondsSet.add("5");

        // union with "mySecondsSet" and write it
        set.union(secondsSet.getName());
        // union with "mySecondsSet" without change of set
        set.readUnion(secondsSet.getName());

        // diff with "mySecondsSet" and write it
        set.diff(secondsSet.getName());
        // diff with "mySecondsSet" without change of set
        set.readDiff(secondsSet.getName());

        // intersect with "mySecondsSet" and write it
        set.intersection(secondsSet.getName());
        // intersect with "mySecondsSet" without change of set
        set.readIntersection(secondsSet.getName());

        Set<String> allValues = set.readAll();

*/

        redisson.shutdown();
    }
}
