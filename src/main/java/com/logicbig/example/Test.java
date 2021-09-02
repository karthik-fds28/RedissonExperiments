package com.logicbig.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.logicbig.example.dto.Review;
import com.mongodb.DBObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Test<T> {

    public Test() {

    }

    public final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {
    };
/*
    private final Class<T> type;

    public Test(Class<T> type) {
        this.type = type;
    }*/
/*
    private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) { };
    private final Type type = typeToken.getType(); // or getRawType() to return Class<? super T>
*/

  /*  public Type getType() {
        return type;
    }*/

    public static void main(String[] args) throws IOException {
        Test<Review> test = new Test<>();
      /*  //Review.class
        //  System.out.println(test.getType());
        Review execute = test.execute(test);

        System.out.println("execute=" + execute);
*/
        test.exe();
    }


    public void exe() throws IOException {
        String json = " {\n" +
                "            \"address\":{\n" +
                "            \"city\":\"Bucharest\",\n" +
                "                    \"country\":\"Romania\"\n" +
                "        }\n" +
                "        }";
       /* {
            "address":{
            "city":"Bucharest",
                    "country":"Romania"
        }
        }*/
        //    DBObject dbObject;

        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(json, Map.class);
        /*DBObject dbObject1 = objectMapper.readValue(json, DBObject.class);

        Map map = dbObject1.toMap();
*/
        Object address = map.get("address");

        Map map2 = (Map) address;

        Object city = map2.get("city");

        System.out.println("city=" + city);
    }

    public T execute(Test<T> test) throws IOException {

        String json = "{\"userName\": \"John\",\n" +
                "        \"rating\": 8,\n" +
                "        \"approved\": false\n" +
                "    }, {\n" +
                "     ";

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(" typeToken.getClass()=" + typeToken.getClass());
        T object = (T) objectMapper.readValue(json, typeToken.getClass());


        System.out.println("object=" + object);

        return object;

    /*
        // T generic =(T) objectMapper.readValue(json, Review.class);
    T t = new T();
    t.getClass();
    */

        //new TypeReference<T>() {}
        //   System.out.println("object=" + object);

     /*   //new TypeReference<List<POJO>>() { }//Object object =
        Review review = (Review) object;

*/
       /* Review review = (Review) object;

        System.out.println("review=" + review);

        System.out.println(test.getType());
*/
        // System.out.println(object.getClass());
    }


    public void t1(){

        List<String> list=new ArrayList<>();

        list.stream();

    }

}
