package com.logicbig.example;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.codec.SnappyCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

public class RedisCacheConfig {

    public static RedissonClient getRedissonClient() {


        Config config = new Config();
        //config.setCodec(new JsonJacksonCodec());
        //config.setCodec(new SnappyCodec());
       // config.setCodec(StringCodec.INSTANCE);
        //SingleServerConfig singleServerConfig=new SingleServerConfig();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        //config.useClusterServers().addNodeAddress("redis://127.0.0.1:7004", "redis://127.0.0.1:7001");
        System.out.println("creating radisson client");
        return Redisson.create(config);
    }


}
