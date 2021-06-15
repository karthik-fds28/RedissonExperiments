package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.RSortedSet;
import org.redisson.api.RedissonClient;

import java.util.Arrays;
import java.util.Comparator;

public class SortedSetExamples {

    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        //TODO: INSIDE IT IS USING LIST ONLY BUT BY USING RSORTEDSET THE ADVANTAGE TO SORT THE ELEMENTS BY IMPLIMENTING THE COMPARATOR

        RSortedSet<String> sortedSet = redisson.getSortedSet("myPlainSortedSet");
        sortedSet.add("1");
        sortedSet.add("10");
        sortedSet.add("2");
        sortedSet.add("13");
        sortedSet.add("3");



        /*for (String string : sortedSet) {
            // iteration through bulk loaded values
            System.out.println("sring=" + string);
        }

*/


        String firstValue = sortedSet.first();
        String lastValue = sortedSet.last();

     /*   boolean removedValue = sortedSet.remove("1");
        sortedSet.removeAll(Arrays.asList("1", "2", "3"));
        sortedSet.containsAll(Arrays.asList("4", "1", "0"));*/
        redisson.shutdown();
    }
}
