package site.redis.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.dynamic.RedisCommandFactory;

import java.util.List;

public class LettuceThrottleTest {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://123456@192.168.19.129");
        StatefulRedisConnection<String, String> connect = redisClient.connect();
        RedisCommandFactory factory = new RedisCommandFactory(connect);
        RedisCommandInterface commands = factory.getCommands(RedisCommandInterface.class);
        List<Object> list = commands.throttle("lihua-hub", 10L, 10L, 60L, 1L);
        System.out.println("list = " + list);
    }
}
