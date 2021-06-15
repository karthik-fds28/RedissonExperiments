package com.logicbig.example;

import org.redisson.Redisson;
import org.redisson.api.RSet;
import org.redisson.api.RSetCache;
import org.redisson.api.RedissonClient;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SetCacheExamples {


    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = RedisCacheConfig.getRedissonClient();

        //Redisson.create();

        RSetCache<String> setCache = redisson.getSetCache("mySetCache");

        // with ttl = 20 seconds
        boolean isAdded = setCache.add("1", 20, TimeUnit.SECONDS);
        // store value permanently
        setCache.add("2");

        setCache.contains("1");

        for (String string : setCache) {
            // iteration through bulk loaded values
        }
/*
        boolean removedValue = setCache.remove("1");
        setCache.removeAll(Arrays.asList("1", "2", "3"));
        setCache.containsAll(Arrays.asList("4", "1", "0"));*/

        RSet<String> secondsSet = redisson.getSet("mySecondsSet");
        secondsSet.add("4");
        secondsSet.add("5");

        Set<String> allValues = secondsSet.readAll();

        redisson.shutdown();
    }
}
