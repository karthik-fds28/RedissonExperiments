package com.logicbig.example.appviewxTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicbig.example.RedisCacheConfig;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.codec.TypedJsonJacksonCodec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class LogConfigurationTest {

    RedissonClient redisson = RedisCacheConfig.getRedissonClient();
    // JsonJacksonCodec.INSTANCE
    TypedJsonJacksonCodec typedJsonJacksonCodec = new TypedJsonJacksonCodec(LogForwardingAppSettings.class);
    RLocalCachedMap<String, Object> rmap = redisson.getLocalCachedMap("testMap1", JsonJacksonCodec.INSTANCE, LocalCachedMapOptions.defaults());
    RLocalCachedMap<String, Object> rmap1 = redisson.getLocalCachedMap("testMap1", JsonJacksonCodec.INSTANCE, LocalCachedMapOptions.defaults());
    //JsonJacksonCodec.INSTANCE
    //RLocalCachedMap<String, Object> rmap2 = redisson.getLocalCachedMap("testMap1", JsonJacksonCodec.INSTANCE, LocalCachedMapOptions.defaults());
    //JsonJacksonCodec
    //TypedJsonJacksonCodec

    static String collectionName = "userAvx";

    ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, InterruptedException {

        LogConfigurationTest logConfigurationTest = new LogConfigurationTest();

        String logConfigurationString = "{\n" +
                "    \n" +
                "        \"category\": \"LOGFORWARDING\",\n" +
                "        \"subCategory\": \"LOGFORWARDING\",\n" +
                "        \"displayName\": \"Log forwarding\",\n" +
                "        \"properties\": {\n" +
                "            \"LOGFW_PROPERTIES\": [\n" +
                "                {\n" +
                "                    \"LOG_NAME\": \"TCP\",\n" +
                "                    \"LOG_SERVER\": \"192.168.142.185\",\n" +
                "                    \"LOG_PORT\": \"5555\",\n" +
                "                    \"LOG_PROTOCOL\": \"TCP\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"LOG_NAME\": \"UDP\",\n" +
                "                    \"LOG_SERVER\": \"192.168.142.185\",\n" +
                "                    \"LOG_PORT\": \"5454\",\n" +
                "                    \"LOG_PROTOCOL\": \"UDP\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"LOG_NAME\": \"vignesh-test\",\n" +
                "                    \"LOG_SERVER\": \"192.168.142.164\",\n" +
                "                    \"LOG_PORT\": \"5414\",\n" +
                "                    \"LOG_PROTOCOL\": \"TCP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"lastModifiedTime\": 1623432445071,\n" +
                "        \"retryIntervalTime\": 0,\n" +
                "        \"retryEnabled\": false,\n" +
                "        \"logFormat\": \"CEF\",\n" +
                "        \"_id\": \"12\"\n" +
                "\n" +
                "}";


        ObjectMapper objectMapper = new ObjectMapper();
        //LogForwardingAppSettings logForwardingAppSettings = objectMapper.readValue(logConfigurationString, LogForwardingAppSettings.class);

        LogForwardingAppSettings logForwardingAppSettings = JsonParser.getParser().convertToBean(logConfigurationString, LogForwardingAppSettings.class);

        String s = JsonParser.getParser().convertToJson(logForwardingAppSettings);

        //System.out.println("before storing into redis=" + s);

        logConfigurationTest.saveItInRedis(logForwardingAppSettings);

        Thread.sleep(1000);

        LogForwardingAppSettings theValueFromRedis1 = logConfigurationTest.getTheValueFromRedis();

        Map<String, Object> properties = theValueFromRedis1.getProperties();

        System.out.println("before manipulation properties=" + properties);

        //theValueFromRedis1.setProperties(null);

        //theValueFromRedis1.setProperties(Collections.singletonMap("LOGFW_PROPERTIES", propertiesInList));
        ArrayList logfw_propertiesList = (ArrayList) theValueFromRedis1.getProperties().get("LOGFW_PROPERTIES");
        List<ArrayList> list = new ArrayList<>();

        ArrayList list2 = new ArrayList<>();

        list2.add(logfw_propertiesList);
        list.add(list2);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("LOGFW_PROPERTIES", list);
        theValueFromRedis1.setProperties(hashMap);

        LogForwardingAppSettings theValueFromRedis = logConfigurationTest.getTheValueFromRedis();

        System.out.println("After the manupulation properties  hence effected 1=" + theValueFromRedis.getProperties());

        /*
        logForwardingAppSettings=AppSettings [category=LOGFORWARDING, subCategory=LOGFORWARDING]
        before manipulation properties={LOGFW_PROPERTIES=[{LOG_NAME=TCP, LOG_SERVER=192.168.142.185, LOG_PORT=5555, LOG_PROTOCOL=TCP}, {LOG_NAME=UDP, LOG_SERVER=192.168.142.185, LOG_PORT=5454, LOG_PROTOCOL=UDP}, {LOG_NAME=vignesh-test, LOG_SERVER=192.168.142.164, LOG_PORT=5414, LOG_PROTOCOL=TCP}]}
        logForwardingAppSettings=AppSettings [category=LOGFORWARDING, subCategory=LOGFORWARDING]
        //BECAUSE OF THE RLOCAL CACHE MAP DATA HAS BEEN CHANGED
        After the manupulation properties  hence effected 1={LOGFW_PROPERTIES=[[[{LOG_NAME=TCP, LOG_SERVER=192.168.142.185, LOG_PORT=5555, LOG_PROTOCOL=TCP}, {LOG_NAME=UDP, LOG_SERVER=192.168.142.185, LOG_PORT=5454, LOG_PROTOCOL=UDP}, {LOG_NAME=vignesh-test, LOG_SERVER=192.168.142.164, LOG_PORT=5414, LOG_PROTOCOL=TCP}]]]}
        logForwardingAppSettings=AppSettings [category=LOGFORWARDING, subCategory=LOGFORWARDING]
        */


        LogForwardingAppSettings theValueFromRedis2 = logConfigurationTest.getTheValueFromRedis();

       /* System.out.println("After the manupulation properties 2=" + theValueFromRedis2.getProperties());

        String outputString1 = JsonParser.getParser().convertToJson(theValueFromRedis1);*/
        //objectMapper.writeValueAsString(theValueFromRedis1);

        //  System.out.println("After storing into json=" + outputString1);

        logConfigurationTest.redisson.shutdown();
        /*
        logConfigurationTest.saveItInRedis(logForwardingAppSettings);

        Thread.sleep(1000);
     *//*
        LogForwardingAppSettings theValueFromRedis = logConfigurationTest.getTheValueFromRedis();

        String outputString = objectMapper.writeValueAsString(theValueFromRedis);


        System.out.println("output login forward app settings=" + outputString);
    *//*
         *//*   System.out.println("<<start deletion>>");
        Thread.sleep(1000 * 20);*//*

        //logConfigurationTest.getRLocalCachedMap(collectionName).clearLocalCache();

        //Thread.sleep(1000 * 30);

        //logConfigurationTest.getRLocalCachedMap(collectionName).fastRemoveAsync("logForwarding");

        //Thread.sleep(1000 * 20);

        LogForwardingAppSettings theValueFromRedis1 = logConfigurationTest.getTheValueFromRedis();

        String outputString1 = objectMapper.writeValueAsString(theValueFromRedis1);

        System.out.println("output login forward app settings22=" + outputString1);

        logConfigurationTest.redisson.shutdown();
    */
    }

    public static void main99(String[] args) throws InterruptedException, JsonProcessingException {
        LogConfigurationTest logConfigurationTest = new LogConfigurationTest();
        ArrayList<String> arr = new ArrayList<>();

        arr.add("abchjkiuytrf");
        arr.add("defmnbvcsert");

        //String[] strArray = {"str1", "str2"};

        //rmap
        logConfigurationTest.rmap1.putAsync("zyxwvArrayList", arr);

        Thread.sleep(1000);

        ArrayList outputArrayList = (ArrayList) logConfigurationTest.rmap1.get("zyxwvArrayList");

        for (Object obj : outputArrayList) {
            System.out.println("=" + obj.getClass());
        }

        System.out.println("outputof ararylist=" + logConfigurationTest.objectMapper.writeValueAsString(outputArrayList));
        logConfigurationTest.redisson.shutdown();
    }


  /*  public static void main3333(String[] args) throws InterruptedException, JsonProcessingException {
        LogConfigurationTest logConfigurationTest = new LogConfigurationTest();
        LinkedHashMap<String, ArrayList<HashMap<String, String>>> linkedHashMap = new LinkedHashMap<>();

        HashMap hashMap = new HashMap();

        hashMap.put("LOG_NAME", "TCP");
        hashMap.put("LOG_SERVER", "192.168.142.185");
        hashMap.put("LOG_PORT", "5555");
        hashMap.put("LOG_PROTOCOL", "TCP");

        HashMap hashMap2 = new HashMap();
        hashMap2.put("LOG_NAME", "TCP");
        hashMap2.put("LOG_SERVER", "192.168.142.185");
        hashMap2.put("LOG_PORT", "5544");
        hashMap2.put("LOG_PROTOCOL", "UDP");

        ArrayList arrayList = new ArrayList();
        arrayList.add(hashMap);
        arrayList.add(hashMap2);

        linkedHashMap.put("LOGFW_PROPERTIES", arrayList);

        logConfigurationTest.saveItInRedis(linkedHashMap);

        Thread.sleep(1000);

        //LogForwardingAppSettings theValueFromRedis1 = logConfigurationTest.getTheValueFromRedis();

        LinkedHashMap<String, ArrayList<HashMap<String, String>>> theValueFromRedis = logConfigurationTest.getTheValueFromRedis();

        String outputString1 = logConfigurationTest.objectMapper.writeValueAsString(theValueFromRedis);

        System.out.println("output login forward app settings22=" + outputString1);

        logConfigurationTest.redisson.shutdown();
    }*/

    public void saveItInRedis(LogForwardingAppSettings logForwardingAppSettings) {
        rmap.fastPutAsync("logForwardingWithJsonParser", logForwardingAppSettings);
        //getRLocalCachedMap(collectionName).fastPutAsync("logForwarding", logForwardingAppSettings);
    }

    /* public void saveItInRedis(LinkedHashMap<String, ArrayList<HashMap<String, String>>> linkedHashMap) throws JsonProcessingException {
         //String jsonString = objectMapper.writeValueAsString(linkedHashMap);
         rmap.fastPutAsync("logForwarding", linkedHashMap);
        // rmap.fastPutAsync("logForwarding", jsonString);
         //getRLocalCachedMap(collectionName).fastPutAsync("logForwarding", logForwardingAppSettings);
     }
 */

    public LogForwardingAppSettings getTheValueFromRedis() throws IOException {

        //Object logForwardingWithJsonParser = rmap.get("logForwardingWithJsonParser");
        /*Class<?> aClass = logForwardingWithJsonParser.getClass();
        System.out.println("class=" + aClass.getName());
        System.out.println("redis data priniting=" + rmap.get("logForwardingWithJsonParser"));
        String json = JsonParser.getParser().convertToJson(logForwardingWithJsonParser);

        System.out.println("output json=" + json);
        LogForwardingAppSettings logForwardingAppSettings = JsonParser.getParser().convertToBean(json, LogForwardingAppSettings.class);
        System.out.println("output logForwardingAppSettings=" + logForwardingAppSettings);
        //LogForwardingAppSettings logForwardingAppSettings = (LogForwardingAppSettings) rmap.get("logForwardingWithJsonParser");
        //LogForwardingAppSettings logForwardingAppSettings = (LogForwardingAppSettings) getRLocalCachedMap(collectionName).get("logForwarding");
        */
        LogForwardingAppSettings logForwardingAppSettings = (LogForwardingAppSettings) rmap.get("logForwardingWithJsonParser");
        System.out.println("logForwardingAppSettings=" + logForwardingAppSettings);
        return logForwardingAppSettings;
    }

   /* private final TypeToken<LinkedHashMap<String, ArrayList<HashMap<String, String>>>> typeToken = new TypeToken<LinkedHashMap<String, ArrayList<HashMap<String, String>>>>() {
    };

    public LinkedHashMap<String, ArrayList<HashMap<String, String>>> getTheValueFromRedis() throws JsonProcessingException {
        LinkedHashMap<String, ArrayList<HashMap<String, String>>> linkedHashMap = (LinkedHashMap<String, ArrayList<HashMap<String, String>>>) rmap.get("logForwarding");
       // String json = (String) rmap.get("logForwarding");
        //LinkedHashMap<String, ArrayList<HashMap<String, String>>> linkedHashMap = (LinkedHashMap<String, ArrayList<HashMap<String, String>>>) objectMapper.readValue(json, typeToken.getRawType());
        //LogForwardingAppSettings logForwardingAppSettings = (LogForwardingAppSettings) getRLocalCachedMap(collectionName).get("logForwarding");
        //System.out.println("linkedHashMap=" + linkedHashMap);
        return linkedHashMap;
    }
*/

    ////############

    private Map<String, RLocalCachedMap<String, Object>> rLocalCachedMap = new HashMap<>();


    public RLocalCachedMap<String, Object> getRLocalCachedMap(String collectionName) {
        return rLocalCachedMap.computeIfAbsent(collectionName, new Function<String, RLocalCachedMap<String, Object>>() {
            @Override
            public RLocalCachedMap<String, Object> apply(String name) {
                return LogConfigurationTest.this.createRLocalCachedMap(collectionName);
            }
        });
    }

    private RLocalCachedMap<String, Object> createRLocalCachedMap(String collectionName) {
        return redisson.getLocalCachedMap(collectionName, JsonJacksonCodec.INSTANCE, LocalCachedMapOptions.defaults());
    }
}
