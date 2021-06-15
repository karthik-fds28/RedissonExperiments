package com.logicbig.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.logicbig.example.dto.AppSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.redisson.api.RMap;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class QueryCollectionExample2<T> {

    // Class<T> clazz;

   /* public QueryCollectionExample2(Class<T> clazz) {
        this.clazz = clazz;
    }*/

    public QueryCollectionExample2() {
    }

    //@SuppressWarnings("serial")
   /* private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {
    };*/
    private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {
    };

    // @SuppressWarnings("unchecked")
    public MongoCollection<T> getCollection(MongoDatabase mongoDatabase,
                                            String collectionName) throws Exception {

        System.out.println("type=" + typeToken.getRawType());
        return (MongoCollection<T>) mongoDatabase.getCollection(collectionName, typeToken.getRawType());
        //return (MongoCollection<T>) mongoDatabase.getCollection(collectionName, clazz);
    }

    /*public void getTheGenericTypeOfTheClass() {

        // System.out.println("type=" + typeToken.getRawType());

//        Class classType = typeToken.getRawType();
        //getClass();

        System.out.println(typeToken.getClass());

        Class classType = typeToken.getClass();

        System.out.println(classType + ", " + classType.getGenericSuperclass());

        ParameterizedType t =
                (ParameterizedType) classType.getGenericSuperclass();

        System.out.println(t.getOwnerType() + ", " + t.getRawType() + ", " +
                Arrays.toString(t.getActualTypeArguments()));


        System.out.println("typeToken=" + typeToken.getType());
        //  String s = Arrays.toString();

        Type[] actualTypeArguments = t.getActualTypeArguments();

        System.out.println("actualTypeArguments=" + actualTypeArguments);

        Type actualTypeArgument = actualTypeArguments[0];

        System.out.println("actualTypeArgument=" + actualTypeArgument);

        Class<? extends Type> aClass = actualTypeArgument.getClass();

        final String json = "[\"one\", \"two\"]";
        T genericOne = new Gson().fromJson(json, typeToken.getType());

        System.out.println("genericOne=" + genericOne);

    }*/

    public T testTheObjectWithGson() throws IOException {

        //Class classType = typeToken.getRawType();

        //  System.out.println(classType);
/*

        Class classType = typeToken.getClass();

        System.out.println(classType + ", " + classType.getGenericSuperclass());

        ParameterizedType t =
                (ParameterizedType) classType.getGenericSuperclass();

        System.out.println(t.getOwnerType() + ", " + t.getRawType() + ", " +
                Arrays.toString(t.getActualTypeArguments()));


        System.out.println("typeToken=" + typeToken.getType());
        //  String s = Arrays.toString();

        Type[] actualTypeArguments = t.getActualTypeArguments();

        System.out.println("actualTypeArguments=" + actualTypeArguments);

        Type actualTypeArgument = actualTypeArguments[0];

        System.out.println("actualTypeArgument=" + actualTypeArgument);

        Class<? extends Type> aClass = actualTypeArgument.getClass();

        System.out.println("aClass=" + aClass);
*/

       /* String json = "\n" +
                "\n" +
                "{\n" +
                "    \"GLOBAL_SESSION_TIMEOUT\": 15,\n" +
                "    \"NAME\":\"Karthik\"\n" +
                "}";*/


        String json = "{\"category\":\"AUTHENTICATION\",\"subCategory\":\"SETTINGS\",\"displayName\":\"Authentication Settings\"," +
                "\"properties\":{\"CREATE_USER_WITH_UNIQUE_MAIL_ID\":false,\"NODE_ENCRYPTED_PASSWORD\":\"cHphamxWbEh5UVpPMjhtWHhpa3ZaQQ==\"," +
                "\"GLOBAL_SESSION_TIMEOUT\":15,\"LOGIN_ORDER\":[\"LOCAL\",\"LDAP\",\"TACACS\",\"RADIUS\"]," +
                "\"CREATE_USER_ON_AUTHORIZATION_FAILURE\":true,\"BIRTHRIGHT\":{\"birthRightEnabled\":false}},\"_id\":\"5\"}";

        System.out.println(typeToken.getRawType());
        System.out.println(typeToken.getType());
        //T genericOne = (T) new Gson().fromJson(json, typeToken.getRawType());


        ObjectMapper objectMapper = new ObjectMapper();

        T object = (T) objectMapper.readValue(json, typeToken.getRawType());
        return object;

    }

}
