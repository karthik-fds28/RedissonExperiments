package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.RSet;
import org.redisson.api.RSetMultimap;
import org.redisson.api.RedissonClient;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SetMultimapExamples {

    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        RSetMultimap<String, Integer> multimap = redisson.getSetMultimap("myMultimap");
        multimap.put("1", 1);
        multimap.put("1", 2);
        multimap.put("1", 3);
        multimap.put("2", 5);
        multimap.put("2", 6);
        multimap.put("4", 7);

        RSet<Integer> values1 = multimap.get("1");
        System.out.println(values1);
        RSet<Integer> values2 = multimap.get("2");
        System.out.println(values2);

        /*
        boolean hasEntry = multimap.containsEntry("1", 3);
        Set<Map.Entry<String, Integer>> entries = multimap.entries();
        Collection<Integer> values = multimap.values();

        boolean isRemoved = multimap.remove("1", 3);
        Set<Integer> removedValues = multimap.removeAll("1");

        Collection<? extends Integer> newValues = Arrays.asList(5, 6, 7, 8, 9);
        boolean isNewKey = multimap.putAll("5", newValues);

        Set<Integer> oldValues = multimap.replaceValues("2", newValues);
        Set<Integer> allValues = multimap.getAll("2");
        */

        redisson.shutdown();
    }

}
