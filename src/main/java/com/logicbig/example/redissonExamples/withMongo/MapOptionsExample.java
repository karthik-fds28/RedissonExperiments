package com.logicbig.example.redissonExamples.withMongo;

import com.logicbig.example.RedisCacheConfig;
import com.mongodb.BasicDBObject;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.redisson.api.MapOptions;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.api.map.MapLoader;

import java.util.Arrays;
import java.util.List;

public class MapOptionsExample {

    String id = "602a1e2189bb7535230f2fb3";

  /*  String databaseName = "HotelDb";

    String collectionName = "Hotels";*/

    String databaseName = "test";

    String collectionName = "student";


    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

    MongoDatabase database = mongoClient.getDatabase(databaseName);

    MongoCollection<Document> collection = database.getCollection(collectionName);


    public static void main(String[] args) {
        MapOptionsExample mapOptionsExample = new MapOptionsExample();

        mapOptionsExample.mainDup();
    }

    public void mainDup() {

        //collection.find(new BasicDBObject("_id", new ObjectId("602a1e2189bb7535230f2fb3"))).first();
/*
        Document document = new Document();
        document.append("name", "karthik");

        Document document1 = new Document();
        document1.append("name", "manikanta");

        Document document2 = new Document();
        document2.append("name", "fragma");

        List<Document> documentList = Arrays.asList(document, document1, document2);
        System.out.println("documentList=" + documentList);

        collection.insertMany(documentList);*/


/*
        BulkWriteResult result = collection.bulkWrite(Arrays.asList(
                new InsertOneModel<>(new Document("_id", 4)),
                new InsertOneModel<>(new Document("_id", 5)),
                new InsertOneModel<>(new Document("_id", 6)),
                new UpdateOneModel<>(new Document("_id", 1),
                        new Document("$set", new Document("x", 2))),
                new DeleteOneModel<>(new Document("_id", 2)),
                new ReplaceOneModel<>(new Document("_id", 3),
                        new Document("_id", 3).append("x", 4)))).await().indefinitely();
*/

    /*    List<WriteModel<?>> writeModels = Arrays.asList(
                new InsertOneModel<>(new Document("_id", 4)),
                new InsertOneModel<>(new Document("_id", 5)),
                new InsertOneModel<>(new Document("_id", 6)),
                new UpdateOneModel<>(new Document("_id", 1),
                        new Document("$set", new Document("x", 2))),
                new DeleteOneModel<>(new Document("_id", 2)),
                new ReplaceOneModel<>(new Document("_id", 3),
                        new Document("_id", 3).append("x", 4)));

        for(WriteModel<?> writeModel:writeModels){

            writeModel
        }
*/
        /*assertThat(result.getDeletedCount()).isEqualTo(0);
        assertThat(result.getInsertedCount()).isEqualTo(3);*/
    }



/*

    public static void main(String[] args) {

        */
/*MapOptionsExample mapOptionsExample = new MapOptionsExample();
        mapOptionsExample.testCache(mapOptionsExample.collection, mapOptionsExample.id, mapOptionsExample.collectionName);
       *//*


        System.out.println(Long.valueOf("15"));
    }
*/






/*
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
        System.out.println("id1 document=" + id1);

       */
/* RMap<Object, String> map = redisClient.getMap(collectionName);

        System.out.println("RMapSize=" + map.size());

        String s = map.get(id);

        System.out.println("s=" + s);
       *//*


        return map;
    }
*/

}
