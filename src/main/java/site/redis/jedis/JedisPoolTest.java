package site.redis.jedis;

import redis.clients.jedis.JedisPool;
import site.redis.Redis;

public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool("192.168.19.129");
        // 法一
//        Jedis jedis = null;
//        jedis = pool.getResource();
//        jedis.auth("123456");
//        try {
//            String ping = jedis.ping("你好");
//            System.out.println("ping = " + ping);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
        // 法二
//        try(Jedis jedis = pool.getResource()){
//            jedis.auth("123456");
//            String ping = jedis.ping();
//            System.out.println("ping = " + ping);
//        }
        // 法三
        Redis redis = new Redis();
        redis.execute(jedis -> {
//            jedis.auth("123456");
            System.out.println("jedis.ping() = " + jedis.ping());
        });
    }
}
