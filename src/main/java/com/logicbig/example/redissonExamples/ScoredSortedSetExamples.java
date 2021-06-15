package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ScoredSortedSetExamples {

    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        RScoredSortedSet<String> set = redisson.getScoredSortedSet("mySortedSet");
      /*  set.add(10, "1");
        set.add(20, "2");
        set.add(30, "3");


        for (String string : set) {
            // iteration through bulk loaded values
            System.out.println("setElement=" + string);
        }*/

        Integer addAndGetRankValue = set.addAndGetRank(33, "4");
        System.out.println("addAndGetRankValue=" + addAndGetRankValue);

/*

        Map<String, Double> newValues = new HashMap<>();
        newValues.put("4", 40D);
        newValues.put("5", 50D);
        newValues.put("6", 60D);
        long newValuesAmount = set.addAll(newValues);

        Double scoreResult = set.addScore("2", 10);
        set.contains("4");
        set.containsAll(Arrays.asList("3", "4", "5"));

        String firstValue = set.first();
        String lastValue = set.last();

        String polledFirst = set.pollFirst();// It will remove the element from set
        String polledLast = set.pollLast();// It will remove the element from set

        // use read method to fetch all objects
        Collection<String> allValues = set.readAll();
*/

        redisson.shutdown();
    }
}
