package com.logicbig.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.logicbig.example.dto.Address;
import com.logicbig.example.dto.Hotel;
import com.logicbig.example.dto.Review;
import com.mongodb.client.*;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;

public class InsertDocumentExample {

    //RedisCacheConfig redisCacheConfig=new RedisCacheConfig();

    public static void main(String[] args) throws JsonProcessingException {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("my-database");
        //A collection is equivalent to RDBMS table
        MongoCollection<Document> collection = database.getCollection("test-collection");

        //we can covert object to document and then can be inserted


        //inserting a document
     /*   Document doc = new Document()
                .append("name", "Joe")
                .append("dept", "IT")
                .append("phone", "111-111-111");
        collection.insertOne(doc);*/

        Document documentObj = getObj();
        Object id1 = documentObj.get("_id");

        System.out.println("idOfObject before="+id1);
        collection.insertOne(documentObj);
        Object id = documentObj.get("_id");

        System.out.println("idOfObject="+id);
        System.out.println("document="+documentObj);

        ObjectMapper objectMapper=new ObjectMapper();

        String s = objectMapper.writeValueAsString(documentObj);

        System.out.println("s="+s);
    }



    public static Document getObj() {
        Hotel hotel = formObject();
        Gson gson = new Gson();
        String json = gson.toJson(hotel);
        Document doc = Document.parse(json);
        return doc;
    }


    public static Hotel formObject() {

        List<Review> reviewList = new ArrayList<>();

        //String userName, int rating, boolean approved)
        Review review1 = new Review("plainMongoTestUser",
                1, true);
        Review review2 = new Review("dupMongoTestUser",
                2, false);

        reviewList.add(review1);
        reviewList.add(review2);

        //String city,String country
        Address address = new Address("mumbai", "india");

        //String name, int pricePerNight, Address address, List<Review> reviews
        Hotel hotel = new Hotel("MongoTest", 1000, address, reviewList);

        return hotel;
    }

}