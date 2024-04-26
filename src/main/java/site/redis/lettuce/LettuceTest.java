package site.redis.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceTest {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://123456@192.168.19.129");
        StatefulRedisConnection<String, String> connect = redisClient.connect();
        RedisCommands<String, String> sync = connect.sync();
        sync.set("name","lihua");
        String name = sync.get("name");
        System.out.println("name = " + name);
    }
}
