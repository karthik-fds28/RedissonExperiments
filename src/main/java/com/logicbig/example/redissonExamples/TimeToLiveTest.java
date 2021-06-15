package com.logicbig.example.redissonExamples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicbig.example.RedisCacheConfig;
import org.redisson.Redisson;
import org.redisson.api.*;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

//import static org.assertj.core.api.Assertions.assertThat;
public class TimeToLiveTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        // connects to 127.0.0.1:6379 by default
        // RedissonClient redisson = Redisson.create();
        RedissonClient redisson = RedisCacheConfig.getRedissonClient();


     /*   LocalCachedMapOptions options = LocalCachedMapOptions.defaults()
                //.cacheSize(10000)
                .cacheSize(5)
                //.evictionPolicy(LocalCachedMapOptions.EvictionPolicy.LRU)
                //.evictionPolicy(LocalCachedMapOptions.EvictionPolicy.LFU)
                //SOFT
                .evictionPolicy(LocalCachedMapOptions.EvictionPolicy.WEAK)
                .maxIdle(3, TimeUnit.SECONDS)
                .timeToLive(5, TimeUnit.SECONDS);
     */

        // MapOptions

        //RLocalCachedMap<String, Integer> cachedMap = redisson.getLocalCachedMap("myMap", options);
        //RLocalCachedMap<String, Integer> cachedMap = redisson.getLocalCachedMap("myMap", LocalCachedMapOptions.defaults());
        RMapCache<String, String> cachedMap = redisson.getMapCache("myMap");

        String json = "{\"category\":\"AUTHENTICATION\",\"subCategory\":\"SETTINGS\",\"displayName\":\"Authentication Settings\"," +
                "\"properties\":{\"CREATE_USER_WITH_UNIQUE_MAIL_ID\":false,\"NODE_ENCRYPTED_PASSWORD\":\"cHphamxWbEh5UVpPMjhtWHhpa3ZaQQ==\"," +
                "\"GLOBAL_SESSION_TIMEOUT\":\"5\",\"LOGIN_ORDER\":[\"LOCAL\",\"LDAP\",\"TACACS\",\"RADIUS\"],\"CREATE_USER_ON_AUTHORIZATION_FAILURE\":false," +
                "\"BIRTHRIGHT\":{\"birthRightEnabled\":true,\"usergroup\":[\"admin usergroup\"]}},\"_id\":\"5\"}";

        System.out.println("json=" + json);

        cachedMap.put("K", String.valueOf(11), 45, TimeUnit.SECONDS, 10, TimeUnit.SECONDS);

        cachedMap.put("L", json, 45, TimeUnit.SECONDS, 30, TimeUnit.SECONDS);
        System.out.println(new Date());
        Thread.sleep(1000 * 10);

        System.out.println("10 seconds completed check K removed or not...");

        String l = cachedMap.get("L");
        //achedMap.containsKey("L");
        System.out.println(l);
        System.out.println(new Date());
        Thread.sleep(1000 * 30);

        System.out.println("5 seconds left for LLLLLLLLL to revove L entry..................");

        String l1 = cachedMap.get("L");

        System.out.println(new Date());

        System.out.println("l1="+l1);

        Thread.sleep(1000 * 5);

        cachedMap.get("L");
        System.out.println(new Date());
        Thread.sleep(1000 * 3);

        System.out.println("5 seconds completed check L REMOVED OR NOT");
        System.out.println(new Date());
        Thread.sleep(1000 * 30);

    /*    Thread.sleep(1000 * 5);

        System.out.println("5 seconds completed check L REMOVED OR NOT");

        Thread.sleep(1000 * 10);

        System.out.println("if extended it should be removed here 45 seconds completed...");

        Thread.sleep(1000 * 40);
*/
        /* cachedMap.put("K", String.valueOf(11));

        cachedMap.put("L", json);

        ObjectMapper objectMapper = new ObjectMapper();
        String k = cachedMap.get("L");
        System.out.println("cached=" + k);
        Map<String, String> map = objectMapper.readValue(k, Map.class);


        System.out.println("map=" + map);*/

        /*cachedMap.put("a", 1);
        cachedMap.put("b", 2);
        cachedMap.put("c", 3);
        cachedMap.put("d", 4);
        cachedMap.put("e", 5);
        cachedMap.put("f", 6); */

     /*   System.out.println("Before sleep cachedMap=" + cachedMap.size());

        //Thread.sleep(1000 * 60);

        System.out.println("size of the map after sleep=" + cachedMap.size());

*/
        System.out.println("size of the cache map==" + cachedMap.size());
    /*
        System.out.println("After sleep cachedMap=" + cachedMap.size());

        boolean contains = cachedMap.containsKey("a");

        System.out.println("contains=" + contains);
     */
        /*
        boolean contains = cachedMap.containsKey("a");

        Integer value = cachedMap.get("c");
        Integer updatedValue = cachedMap.addAndGet("a", 32);

        Integer valueSize = cachedMap.valueSize("c");

        Set<String> keys = new HashSet<String>();
        keys.add("a");
        keys.add("b");
        keys.add("c");
        Map<String, Integer> mapSlice = cachedMap.getAll(keys);

        // use read* methods to fetch all objects
        Set<String> allKeys = cachedMap.readAllKeySet();
        Collection<Integer> allValues = cachedMap.readAllValues();
        Set<Map.Entry<String, Integer>> allEntries = cachedMap.readAllEntrySet();

        // use fast* methods when previous value is not required
        boolean isNewKey = cachedMap.fastPut("a", 100);
        boolean isNewKeyPut = cachedMap.fastPutIfAbsent("d", 33);
        long removedAmount = cachedMap.fastRemove("b");

*/

        redisson.shutdown();
    }

/*
    public static void main(String[] args) {
        testLFU();
    }*/

   /* public static void testLFU() {
        RedissonClient redisson = Redisson.create();
        RLocalCachedMap<String, Integer> map = redisson.getLocalCachedMap("test",
                LocalCachedMapOptions.<String, Integer>defaults().
                        evictionPolicy(LocalCachedMapOptions.EvictionPolicy.LFU).
                        cacheSize(5));
        Map<String, Integer> cache = map.readAllMap();
        //map.getCachedMap();

        map.put("12", 1);
        map.put("14", 2);
        map.put("15", 3);
        map.put("16", 4);
        map.put("17", 5);
        map.put("18", 6);
        map.put("23", 7);
        map.put("24", 8);
        map.put("25", 9);

       // Thread.sleep();

        System.out.println("map=" + map.size());
*//*
        assertThat(cache.size()).isEqualTo(5);
        assertThat(map.size()).isEqualTo(6);
        assertThat(map.keySet()).containsOnly("12", "14", "15", "16", "17", "18");
        assertThat(map.values()).containsOnly(1, 2, 3, 4, 5, 6);*//*
    }*/
}
