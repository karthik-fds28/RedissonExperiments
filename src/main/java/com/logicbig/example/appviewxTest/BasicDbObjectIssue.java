package com.logicbig.example.appviewxTest;

import com.logicbig.example.RedisCacheConfig;
import com.mongodb.BasicDBObject;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;


public class BasicDbObjectIssue {

    RedissonClient redisson = RedisCacheConfig.getRedissonClient();

    RMapCache<String, Object> rmap = redisson.getMapCache("basicDbObjectIssue", JsonJacksonCodec.INSTANCE, LocalCachedMapOptions.defaults());

    public static void main(String[] args) {

        BasicDbObjectIssue basicDbObjectIssue = new BasicDbObjectIssue();

        basicDbObjectIssue.basicDbObjectTest();

    }


    public void basicDbObjectTest() {

        BasicDBObject query = new BasicDBObject();
        //objectId oid = ObjectId.massageToObjectId(id);
        query.put("_id", "1234-asdf-467");
        query.put("name", "karthik");
        query.put("designation", "senior software engineer");

        System.out.println("output");
        rmap.put("test1", query);

        Object test1 = rmap.get("test1");

        System.out.println("input=" + test1);
    }
}
