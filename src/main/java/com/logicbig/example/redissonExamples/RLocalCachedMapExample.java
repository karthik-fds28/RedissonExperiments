package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;

public class RLocalCachedMapExample {

    public static void main(String[] args) {

        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        // RLocalCachedMap<Object, String> map =
        String json = "{ \"name\": \"Marriot\",\n" +
                "    \"pricePerNight\": 130,\n" +
                "    \"address\": {\n" +
                "        \"city\": \"Paris\",\n" +
                "        \"country\": \"France\"\n" +
                "    },\n" +
                "    \"reviews\": [{\n" +
                "        \"userName\": \"John\",\n" +
                "        \"rating\": 8,\n" +
                "        \"approved\": false\n" +
                "    }, {\n" +
                "        \"userName\": \"Mary\",\n" +
                "        \"rating\": 7,\n" +
                "        \"approved\": true\n" +
                "    }]\n" +
                "}";

        RLocalCachedMap<Object, String> map = redisson.getLocalCachedMap("rlocalcachemap", LocalCachedMapOptions.defaults());

        map.put("key1", json);

        String key1Value = map.get("key1");

        System.out.println("key1Value" + key1Value);
    }

}
