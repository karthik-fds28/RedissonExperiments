package com.logicbig.example.redissonExamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.logicbig.example.RedisCacheConfig;
import com.logicbig.example.dto.Review;
import org.bson.types.Binary;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.AvroJacksonCodec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.codec.SmileJacksonCodec;
import org.redisson.codec.SnappyCodec;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestExamples {

    RedissonClient redisson = RedisCacheConfig.getRedissonClient();
    RLocalCachedMap<Object, Object> testMap = redisson.getLocalCachedMap("testMap1", LocalCachedMapOptions.defaults());

    RLocalCachedMap<Object, Object> testMap2 = redisson.getLocalCachedMap("testMap2", LocalCachedMapOptions.defaults());

    LocalCachedMapOptions options = LocalCachedMapOptions.defaults()
            .evictionPolicy(LocalCachedMapOptions.EvictionPolicy.LFU)
            .timeToLive(48, TimeUnit.MINUTES)
            .maxIdle(24, TimeUnit.MINUTES)
            .cacheSize(1000);

    /*public static void main(String[] args) throws InterruptedException {
        TestExamples testExamples = new TestExamples();
        testExamples.maindup();

        Thread.sleep(1000 * 30);
        testExamples.testStateOfCacheMap();


        testExamples.maindup2();
        Thread.sleep(1000 * 30);
        testExamples.testStateOfCacheMap2();

        testExamples.redisson.shutdown();
    }*/


    public void maindup() {

        System.out.println("<<<<<<<<<<< maindup >>>>>>>>>>>>>");

        //Redisson.create();
        ///String userName, int rati ng, boolean approved
        Review review = new Review("karthikkk", 4, true);


        String key = review.getUserName() + review.getRating() + review.isApproved();
        testMap.put(key, review);

        System.out.println("testMap=" + testMap);

        System.out.println("testMap size=" + testMap.size());

        System.out.println("reference of testMap=" + testMap);

      /*  testMap.clear();

        System.out.println("testMap size after the clear command=" + testMap.size());

        System.out.println("reference of testMap after clear command=" + testMap);*/
    }

    public void testStateOfCacheMap() {

        System.out.println("<<<<<<<< testStateOfCacheMap >>>>>>>>>>>>>");
        //System.out.println("get all=" + testMap.entrySet());
        System.out.println("output test=" + testMap.get("karthik"));
        //Set<Object> objects = testMap.keySet();
        //System.out.println("key set=" + objects);
        System.out.println("size of test map=" + testMap.size());
    }


    public void maindup2() {

        System.out.println("<<<<<<<<<<< maindup2 >>>>>>>>>>>>>");

        //Redisson.create();
        ///String userName, int rati ng, boolean approved
        Review review = new Review("karthikkk", 4, true);


        String key = review.getUserName() + review.getRating() + review.isApproved();
        testMap2.put(key, review);

        System.out.println("testMap=" + testMap2);

        System.out.println("testMap size=" + testMap2.size());

        System.out.println("reference of testMap=" + testMap2);

     /*   testMap2.clear();

        System.out.println("testMap size after the clear command=" + testMap2.size());

        System.out.println("reference of testMap after clear command=" + testMap2);*/
    }

    public void testStateOfCacheMap2() {
        System.out.println("<<<<<<<<<<< testStateOfCacheMap2  >>>>>>>>");
        //System.out.println("get all=" + testMap.entrySet());
        System.out.println("output test=" + testMap2.get("karthik"));
        //Set<Object> objects = testMap.keySet();
        //System.out.println("key set=" + objects);
        System.out.println("size of test map=" + testMap2.size());
    }

/*
    public static void maindddd(String[] args) throws IOException {

        testConvertionFromObjectToGeneric();

    }


    public static void testConvertionFromObjectToGeneric() throws IOException {

        Review review = new Review("karthik", 4, true);
        Review review1 = new Review("manikanta", 5, false);

        List<Review> reviewList = Arrays.asList(review, review1);
        //Class<? extends Review> aClass = review.getClass();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = objectMapper.writeValueAsString(reviewList);

        //Class aClass1 = objectMapper.readValue(jsonInput, aClass);

        */
/*TypeReference typeReference = new TypeReference<Review[]>() {
        };
*//*


     */
/*TypeReference typeReference = new TypeReference<List<Review>>() {
        };

        Type type = typeReference.getType();

        JavaType javaType = TypeFactory.defaultInstance().constructType(type);

        Class<?> rawClass = javaType.getRawClass();

        List<Review> listOFReviews = (List<Review>) objectMapper.readValue(jsonInput, rawClass);*//*


        //Class<?> rawClass = Review.class;

        TypeReference typeReference = new TypeReference<List<Class<?>>>() {
        };

        Type type = typeReference.getType();

        JavaType javaType = TypeFactory.defaultInstance().constructType(type);

        Class<?> rawClass = javaType.getRawClass();

        List<Review> listOFReviews = (List<Review>) objectMapper.readValue(jsonInput, rawClass);

        System.out.println("listOFReviews=" + listOFReviews);


        */
/*TypeVariable<? extends Class<?>>[] typeParameters = rawClass.getTypeParameters();
        //Class<?>[] classes = rawClass.getClasses();
        Class<? extends TypeVariable[]> aClass = typeParameters.getClass();
        TypeVariable[] typeVariable = objectMapper.readValue(jsonInput, aClass);
        Review[] lisReview = (Review[]) typeVariable;*//*


        //System.out.println("lisReview=" + lisReview);

        //List<Review> listOFReviews = (List<Review>) objectMapper.readValue(jsonInput, typeReference);
        //List<Review> listOFReviews = (List<Review>) objectMapper.readValue(jsonInput, typeReference.getClass());

        //  System.out.println(listOFReviews);
    }
*/

    public static void main(String[] args) throws InterruptedException {

        TestExamples testExamples = new TestExamples();
        testExamples.testBuckets();
        //testExamples.testList();
        //testExamples.testFields();
    }

    public void testFields() {

       /* RSet<Object> name = redisson.getSet("name");
        boolean karthik = name.add("karthik");
        //String name1 = name.getName();
        Set<Object> objects = name.readAll();
        // System.out.println("name1=" + name1);
        System.out.println("objects=" + objects);*/

        RBucket<String> bucket = redisson.getBucket("stringJson");

        long start = System.currentTimeMillis();
        // bucket.set("Rommel is the object value");
        bucket.set("[\"java.util.ArrayList\",[{\"@class\":\"com.logicbig.example.dto.Review\",\"approved\":true,\"rating\":4,\"userName\":\"karthik\"},{\"@class\":\"com.logicbig.example.dto.Review\",\"approved\":false,\"rating\":5,\"userName\":\"manikanta\"}]]");
        System.out.println("set=" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        String objValue = bucket.get();
        System.out.println("get=" + (System.currentTimeMillis() - start));

        System.out.println("The object value is: " + objValue);

        /*RMap<String, String> map = redisson.getMap("theMap");
        map.put("mapKey", "Risa is map value");*/

       /* String mapValue = map.get("mapKey");
        System.out.println("The map value is: " + mapValue);*/

        redisson.shutdown();
    }

    public void testBuckets() throws InterruptedException {

        //Review review = new Review("karthik", 4, true);
        String reviewRequest = "karthik_manikanasdfadfasd";
        String value = "abcdefgfij";

        //"[\"java.util.ArrayList\",[{\"@class\":\"com.logicbig.example.dto.Review\",\"approved\":true,\"rating\":4,\"userName\":\"karthik\"},{\"@class\":\"com.logicbig.example.dto.Review\",\"approved\":false,\"rating\":5,\"userName\":\"manikanta\"}]]";
        //Review review1 = new Review("manikanta", 5, false);
        //new SnappyCodec()
        //JsonJacksonCodec.INSTANCE
        //AvroJacksonCodec.INSTANCE
        //SmileJacksonCodec.INSTANCE

        RLocalCachedMap<Object, Object> map = redisson.getLocalCachedMap("testMap3", StringCodec.INSTANCE, LocalCachedMapOptions.defaults());
        map.put("test", System.currentTimeMillis());
        map.clear();
        //RMapCache<Object, Object> map = redisson.getMapCache("testMap", JsonJacksonCodec.INSTANCE, MapOptions.defaults());
        loopTest3(map, reviewRequest, value);

        redisson.shutdown();
    }

    public void loopTest(RLocalCachedMap<Object, Object> map, String reviewRequest, String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("loop number=" + i);
            long fastPutTestMilliSec = fastPutTest(map, reviewRequest + "_" + i + "fastPutTest", value, i);
            System.out.println("fastPutTestMilliSec insertion time=" + fastPutTestMilliSec);

            long putAsyncTestMilliSec = putAsyncTest(map, reviewRequest + "_" + i + "putAsyncTest", value, i);
            System.out.println("putAsyncTestMilliSec insertion time=" + putAsyncTestMilliSec);

            long fastPutAsyncTestMilliSec = fastPutAsyncTest(map, reviewRequest + "_" + i + "fastPutAsyncTest", value, i);
            System.out.println("fastPutAsyncTestMilliSec insertion time=" + fastPutAsyncTestMilliSec);
        }
    }

    public void loopTest2(RLocalCachedMap<Object, Object> map, String reviewRequest, String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("loop number=" + i);
            long fastPutTestMilliSec = fastPutTest(map, reviewRequest + "_" + i + "fastPutTest", value, i);
            System.out.print("fastPutTestMilliSec insertion time=" + fastPutTestMilliSec + ", ");

            long putAsyncTestMilliSec = putAsyncTest(map, reviewRequest + "_" + i + "putAsyncTest", value, i);
            System.out.print("putAsyncTestMilliSec insertion time=" + putAsyncTestMilliSec + ", ");

            long fastPutAsyncTestMilliSec = fastPutAsyncTest(map, reviewRequest + "_" + i + "fastPutAsyncTest", value, i);
            System.out.print("fastPutAsyncTestMilliSec insertion time=" + fastPutAsyncTestMilliSec);
        }
    }

    public void loopTest3(RLocalCachedMap<Object, Object> map, String reviewRequest, String value) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("loop number=" + i);
            long fastPutTestMilliSec = fastPutTest(map, reviewRequest + "_" + "fastPutTest", value, i);
            System.out.print("fastPutTestMilliSec insertion time=" + fastPutTestMilliSec + ", ");

            long putAsyncTestMilliSec = putAsyncTest(map, reviewRequest + "_" + "putAsyncTest", value, i);
            System.out.print("putAsyncTestMilliSec insertion time=" + putAsyncTestMilliSec + ", ");

            long fastPutAsyncTestMilliSec = fastPutAsyncTest(map, reviewRequest + "_" + "fastPutAsyncTest", value, i);
            System.out.print("fastPutAsyncTestMilliSec insertion time=" + fastPutAsyncTestMilliSec);
        }
    }

    public long fastPutTest(RLocalCachedMap<Object, Object> map, String reviewRequest, String value, int i) {
       /* System.out.println("<<<<<<<<fastPutTest>>>>>>>>>>>>");
        System.out.println("loop number=" + i + 1);*/
        long start = System.currentTimeMillis();
        map.fastPut(reviewRequest, value);
        long getMs = (System.currentTimeMillis() - start);
//        System.out.println("put=" + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();

        Object get = map.get(reviewRequest);

//        System.out.println("get=" + (System.currentTimeMillis() - start));

//        System.out.println("<<<<<<<<fastPutTest END>>>>>>>>>>>>");
        return getMs;
    }

    public long putAsyncTest(RLocalCachedMap<Object, Object> map, String reviewRequest, String value, int i) {
       /* System.out.println("<<<<<<<<putAsyncTest>>>>>>>>>>>>");
        System.out.println("loop number=" + i + 1);*/
        long start = System.currentTimeMillis();
        map.fastPut(reviewRequest, value);
//        System.out.println("put=" + (System.currentTimeMillis() - start));
        long getMs = (System.currentTimeMillis() - start);
        start = System.currentTimeMillis();

        Object get = map.get(reviewRequest);

       /* System.out.println("get=" + (System.currentTimeMillis() - start));
        System.out.println("<<<<<<<<putAsyncTest END>>>>>>>>>>>>");
*/
        return getMs;
    }


    public long fastPutAsyncTest(RLocalCachedMap<Object, Object> map, String reviewRequest, String value, int i) {
       /* System.out.println("<<<<<<<<putAsyncTest>>>>>>>>>>>>");
        System.out.println("loop number=" + i + 1);*/
        long start = System.currentTimeMillis();
        map.fastPutAsync(reviewRequest, value);
//        System.out.println("put=" + (System.currentTimeMillis() - start));
        long getMs = (System.currentTimeMillis() - start);
        start = System.currentTimeMillis();

        Object get = map.get(reviewRequest);

       /* System.out.println("get=" + (System.currentTimeMillis() - start));
        System.out.println("<<<<<<<<putAsyncTest END>>>>>>>>>>>>");
*/
        return getMs;
    }


    public void testList() {
        Review review = new Review("karthik", 4, true);
        Review review1 = new Review("manikanta", 5, false);

        List<Review> reviewList = new ArrayList<>();

        reviewList.add(review);
        reviewList.add(review1);

        RLocalCachedMap<Object, Object> testMap = redisson.getLocalCachedMap("testMap", LocalCachedMapOptions.defaults());

        //RMapCache<Object, Object> testMap = redisson.getMapCache("testMap", LocalCachedMapOptions.defaults());

        testMap.put(review.getUserName() + "_" + review1.getUserName(), reviewList);

       /* List<Review> output = (List<Review>) testMap.get(review.getUserName() + "_" + review1.getUserName());
        System.out.println(output);*/

        testMap.put("testLong", 234);

        Object testLong = testMap.get("testLong");
        System.out.println("testLong=" + testLong);

    }

  /*  public static void main(String[] args) {

        org.bson.types.Binary binary = new Binary("testOne".getBytes());

        System.out.println(binary);

        Object object=binary;


        System.out.println(object);



    }*/


    /*public static void main(String[] args) {

        testSet();

    }*/

    public static void testSet() {

        String collectionName = "appSettings";
        String[] columnNames = {"category", "subCategory"};

        Set<String> columnsSet = new TreeSet<>(Arrays.asList(columnNames));
        System.out.println("columnsSet=" + columnsSet);
        String cacheKey = getCacheKey(collectionName, columnsSet);
        //appSettings:[category, subCategory]
        System.out.println("cacheKey=" + cacheKey);

    }


    public static String getCacheKey(String collectionName, Set<String> columnsSet) {

        StringBuilder cacheTemplateKey = new StringBuilder(collectionName);
        cacheTemplateKey.append(":");
        cacheTemplateKey.append(columnsSet.toString());
        return cacheTemplateKey.toString();
    }

}
