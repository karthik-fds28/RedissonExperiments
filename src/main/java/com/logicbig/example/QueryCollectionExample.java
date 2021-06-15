package com.logicbig.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicbig.example.dto.AppSettings;
import com.logicbig.example.dto.FormatCheck;
import com.logicbig.example.dto.Hotel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertManyOptions;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.redisson.api.MapOptions;
import org.redisson.api.RMap;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.api.map.MapLoader;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryCollectionExample {

    String id = "602a1e2189bb7535230f2fb3";

    String databaseName = "HotelDb";

    String collectionName = "Hotels";


    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

    MongoDatabase database = mongoClient.getDatabase(databaseName);

    MongoCollection<Document> collection = database.getCollection(collectionName);

    /*public static void main(String[] args) throws Exception {

        //     execute();

        QueryCollectionExample queryCollectionExample = new QueryCollectionExample();
        //    queryCollectionExample.executeTest();
        //queryCollectionExample.insertOneInMongoDb();

        //queryCollectionExample.updateOneInMongoDb();

        //queryCollectionExample.upsertInMongoDb();

        queryCollectionExample.insertManyInMongoDb();
    }*/

    public static void main(String[] args) throws IOException {
        //QueryCollectionExample2<List<String>>   queryCollectionExample2=new QueryCollectionExample2<List<String>>(){};

        // QueryCollectionExample2<List<String>> queryCollectionExample2 = new QueryCollectionExample2<>();

      /*  QueryCollectionExample2<FormatCheck> queryCollectionExample2 = new QueryCollectionExample2<FormatCheck>() {
        };
*/



        //  queryCollectionExample2.getTheGenericTypeOfTheClass();

      /*  AppSettings appSettings = queryCollectionExample2.
                testTheObjectWithGson();

        System.out.println("appSettings" + appSettings);*/
/*
        QueryCollectionExample2<AppSettings> queryCollectionExample2 = new QueryCollectionExample2<AppSettings>(){};

        AppSettings appSettings = queryCollectionExample2.
                testTheObjectWithGson();

        System.out.println("appSettings" + appSettings);*/



    }

/*
        Class classType = queryCollectionExample2.getClass();

        String canonicalName = classType.getCanonicalName();



        //TypeVariable[] typeParameters = classType.getTypeParameters();

        System.out.println("canonicalName="+canonicalName);

        System.out.println(classType + ", " + classType.getGenericSuperclass());

        ParameterizedType t =
                (ParameterizedType) classType.getGenericSuperclass();

        System.out.println(t.getOwnerType() + ", " + t.getRawType() + ", " +
                Arrays.toString(t.getActualTypeArguments()));*//*

    }
*/

/*

    public static void main(String[] args) {

        //testCache(MongoCollection<Document> collection, Object id, String collectionName);

    }
*/

/*
    public void execute() throws JsonProcessingException {


        String id = "602a1e2189bb7535230f2fb3";

        String databaseName = "HotelDb";

        String collectionName = "Hotels";
*/
/*

    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        System.out.println("Mongo client created="+mongoClient);
    //MongoDatabase database = mongoClient.getDatabase("my-database");

    MongoDatabase database = mongoClient.getDatabase(databaseName);
        System.out.println("database="+database);
    //MongoCollection<Document> collection = database.getCollection("test-collection");

    MongoCollection<Document> collection = database.getCollection(collectionName);
        System.out.println("collection="+collection);
*/


    //     testRetrievingOfCache(collectionName, id, collection);

     /*   //query collection
        //finding all
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            System.out.println(document.toString());
        }*/
/*

        RMapCache<Object, Document> hotels = null;

        // for (int i = 0; i < 2; i++) {
        hotels = testCache(collection, id, collectionName);
        //   }

*/


    /*    RMap<Object, Document> hotels = null;

        // for (int i = 0; i < 2; i++) {
        hotels = testCache(collection, id, collectionName);
        //   }


        Document document = hotels.get(id);


        System.out.println("result document=" + document);*/




  /*  public static RMapCache<Object, Document> testCache(MongoCollection<Document> collection, Object id, String collectionName) {

        RedissonClient redisClient = RedisCacheConfig.getRedissonClient();

        MapLoader<Object, Document> mapLoader = new MapLoader<Object, Document>() {
            @Override
            public Document load(Object key) {
                System.out.println("Fetching getById from database for {} " + key);
                try {
                    System.out.println("executing inside load..");
                    //return collection.find(idEq(id)).first();
                    System.out.println("id value=" + id.toString());
                    Document resultDocFromMongo = collection.find(new BasicDBObject("_id", new ObjectId("602a1e2189bb7535230f2fb3"))).first();

                    System.out.println("resultDocFromMongo=" + resultDocFromMongo);
                    // new BasicDBObject("_id", id.toString())
                } catch (Exception e) {
                    System.out.println("Error While Getting data : " + e);
                }
                return null;
            }

            @Override
            public Iterable<Object> loadAllKeys() {
                return null;
            }
        };

        MapOptions<Object, Document> options = MapOptions.<Object, Document>defaults()
                .writeMode(MapOptions.WriteMode.WRITE_THROUGH)
                .loader(mapLoader);
       // RMapCache<Object, Document> map = redisClient.getMapCache(collectionName, options);
        RMapCache<Object, Document> map = redisClient.getMapCache(collectionName, options);
        System.out.println("RMapCache=" + map.size());
        return map;
    }
*/

    public static RMap<Object, Document> testCache(MongoCollection<Document> collection, Object id, String collectionName) {

        RedissonClient redisClient = RedisCacheConfig.getRedissonClient();
        MapLoader<Object, Document> mapLoader = new MapLoader<Object, Document>() {
            @Override
            public Document load(Object key) {
                System.out.println("Fetching getById from database for {} " + key);
                try {
                    System.out.println("executing inside load..");
                    //return collection.find(idEq(id)).first();
                    System.out.println("id value=" + id.toString());
                    Document resultDocFromMongo = collection.find(new BasicDBObject("_id", new ObjectId("602a1e2189bb7535230f2fb3"))).first();

                    System.out.println("resultDocFromMongo=" + resultDocFromMongo);
                    // new BasicDBObject("_id", id.toString())
                } catch (Exception e) {
                    System.out.println("Error While Getting data : " + e);
                }
                return null;
            }

            @Override
            public Iterable<Object> loadAllKeys() {
                return null;
            }
        };

        MapOptions<Object, Document> options = MapOptions.<Object, Document>defaults()
                // .writeMode(MapOptions.WriteMode.WRITE_THROUGH)
                .loader(mapLoader);
        // RMapCache<Object, Document> map = redisClient.getMapCache(collectionName, options);
        RMap<Object, Document> map = redisClient.getMap(collectionName, options);
        System.out.println("RMap size=" + map.size());
        Document id1 = map.get("_id");
        System.out.println("id1=" + id1);

       /* RMap<Object, String> map = redisClient.getMap(collectionName);

        System.out.println("RMapSize=" + map.size());

        String s = map.get(id);

        System.out.println("s=" + s);
       */

        return map;
    }
/*

    public static String testRetrievingOfCache(String mapNameSpace, String id, MongoCollection<Document> collection) throws JsonProcessingException {

        RedissonClient redisClient = RedisCacheConfig.getRedissonClient();

        RMap<Object, String> map = redisClient.getMap(mapNameSpace);

        System.out.println("RMapSize=" + map.size());

        String initialResult = map.get(id);

        System.out.println("initialResultFromRedis=" + initialResult);

        if (initialResult == null) {
            collection.find(new BasicDBObject("_id", new ObjectId(id))).first();
            //Document resultDocFromMongo =
                    System.out.println("received the object from mongo=" + resultDocFromMongo);

            if (resultDocFromMongo != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                String stringOfJsonObject = objectMapper.writeValueAsString(resultDocFromMongo);

                System.out.println("stringOfJsonObject=" + stringOfJsonObject);

                map.put(id, stringOfJsonObject);
                return map.get(id);
            } else {
                return null;
            }

        } else {
            return initialResult;
        }

    }
*/
/*
    public static BasicDBObject idEq(Object value) {
        if (ObjectId.isValid(value.toString())) {
            return new BasicDBObject("_id", new ObjectId(value.toString()));
        }
        return new BasicDBObject("_id", value);
    }*/

    public void executeTest() throws Exception {

        QueryCollectionExample2<Document> queryCollectionExample2 = new QueryCollectionExample2<Document>();
        //QueryCollectionExample2<Document> queryCollectionExample2 = new QueryCollectionExample2<Document>(Document.class);

        //MongoCollection<Document> collection = queryCollectionExample2.getCollection(database, collectionName);

        MongoCollection<Document> collection = queryCollectionExample2.getCollection(database, collectionName);

        System.out.println("collection=" + collection.countDocuments());
        Document first = collection.find().first();

        System.out.println("first=" + first);
    }


    public void insertOneInMongoDb() {


        com.mongodb.client.result.InsertOneResult insertOneResult = collection.insertOne(new Document());

        System.out.println("insertOneResult=" + insertOneResult);
    }

    public void updateOneInMongoDb() {

        Object id = "604ef69ab7ece25972241580";
        System.out.println("id=" + id);
        Document document = new Document().append("name", "kaarrtthhiikk").append("pricePerNight", "11111");
        if (ObjectId.isValid(id.toString())) {
            System.out.println("id is an object started..");
            //return eq("_id", new ObjectId(value.toString()));
            BasicDBObject id1 = new BasicDBObject("_id", new ObjectId(id.toString()));

            UpdateResult updateResult = collection.updateOne(id1, new Document("$set", document));

            System.out.println("updateResult=" + updateResult);
            return;
        }


        BasicDBObject id1 = new BasicDBObject("_id", id);
        UpdateResult updateResult = collection.updateOne(id1, new Document("$set", document));
        System.out.println("updateResult=" + updateResult);
    }

    public void upsertInMongoDb() {

        Document document = new Document().append("pricePerNight", "12345").append("age", "26");

        BasicDBObject condition = new BasicDBObject("name", "manikanta");
        if (ObjectId.isValid(id.toString())) {
            System.out.println("id is an object started..");

            //   UpdateResult updateResult = collection.updateOne(condition, new Document("$set", document), new UpdateOptions().upsert(true));
            UpdateResult updateResult = collection.replaceOne(condition, document,
                    new ReplaceOptions().upsert(true));
            System.out.println("updateResult=" + updateResult);

            return;
        }

        //UpdateResult updateResult = collection.updateOne(condition, new Document("$set", document), new UpdateOptions().upsert(true));
        UpdateResult updateResult = collection.replaceOne(condition, document,
                new ReplaceOptions().upsert(true));

        System.out.println("updateResult=" + updateResult);
    }

    public void insertManyInMongoDb() {

        Document document1 = new Document("name", "Ram").append("age", 26).append("city", "Hyderabad");
        Document document2 = new Document("name", "Lakshman").append("age", 25).append("city", "vijayawada");
        Document document3 = new Document("name", "Hanuman").append("age", 24).append("city", "eluru");

        List<Document> list = Arrays.asList(document1, document2, document3);
        System.out.println("before insertion=" + list);
        InsertManyResult insertManyResult = collection.insertMany(list);
        System.out.println("insertManyResult=" + insertManyResult);

        System.out.println(list);
    }

}
