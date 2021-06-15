package com.logicbig.example.redissonExamples;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;


import java.io.IOException;



public class MapExamples {
    RedissonClient redisson = Redisson.create();

    public static void mainnn(String[] args) throws IOException {
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        RMap<String, Integer> map = redisson.getMap("myMap");
       /* map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        boolean contains = map.containsKey("a");
        System.out.println("contains=" + contains);


        Integer value = map.get("c");
        System.out.println("value=" + value);

        Integer updatedValue = map.addAndGet("a", 32);//Add value to existing value like sum operator
        System.out.println("updatedValue=" + updatedValue);

        Integer valueSize = map.valueSize("c");
        System.out.println("valueSize=" + valueSize);
*/

        int b = map.valueSize("a");
        System.out.println("b value size=" + b);


        /*

        Set<String> keys = new HashSet<String>();
        keys.add("a");
        keys.add("b");
        keys.add("c");
        Map<String, Integer> mapSlice = map.getAll(keys);

        // use read* methods to fetch all objects
        Set<String> allKeys = map.readAllKeySet();
        Collection<Integer> allValues = map.readAllValues();
        Set<Map.Entry<String, Integer>> allEntries = map.readAllEntrySet();

        // use fast* methods when previous value is not required
        boolean isNewKey = map.fastPut("a", 100);
        boolean isNewKeyPut = map.fastPutIfAbsent("d", 33);
        long removedAmount = map.fastRemove("b");
*/

        redisson.shutdown();
    }

   /* public static void main(String[] args) {
        SortedMap<String, Object> map = new TreeMap<>();

        map.put("category", "one");
        map.put("subCategory", "two");

        System.out.println(map.toString());
    }*/

  /*  public static void main(String[] args) {

        RedissonClient redisson = Redisson.create();

        RLocalCachedMap<String, Object> map = redisson.getLocalCachedMap("Hotels", LocalCachedMapOptions.defaults());

        long l = System.currentTimeMillis();
        map.clear();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

        //  map.clearLoc
    }
*/

    public static void main(String[] args) {
        MapExamples mapExamples = new MapExamples();
        String key = "shiroSession:{_id=RAqaozlKoWHRmeSAmEqxs8vra3YIde8plI3nU7SyOUBBvrF0wCj3w7yjHdkxY7u7}";

        //mapExamples.addInMap(key);

        mapExamples.removeFromMap(key);
    }

    public void addInMap(String key) {

        RMapCache<String, Object> rMapCache = redisson.getMapCache("ourMap", StringCodec.INSTANCE, MapOptions.defaults());

        //redisson.getMapCache("ourMap", JsonJacksonCodec.INSTANCE, MapOptions.defaults());
        //String key = "shiroSession:{_id=RAqaozlKoWHRmeSAmEqxs8vra3YIde8plI3nU7SyOUBBvrF0wCj3w7yjHdkxY7u7}";

        String value = "{\"name\":\"karthik\"}";

        rMapCache.put(key, value);

        Object valueOfObj = rMapCache.get(key);

        System.out.println("valueOfObj=" + valueOfObj);
    }


    public void removeFromMap(String key) {
        RMapCache<String, Object> rMapCache = redisson.getMapCache("ourMap", StringCodec.INSTANCE, MapOptions.defaults());

        Object remove = rMapCache.remove(key);

        System.out.println("remove=" + remove);
    }
}




