package site.redis.jedis;

import redis.clients.jedis.Jedis;

public class MyJedis {
    public static void main(String[] args) {
        // 使用默认端口 6379，不需要配置端口
        Jedis jedis = new Jedis("192.168.19.129",6379);
        jedis.auth("123456");
        // 测试是否连接成功
        String ping = jedis.ping();
        System.out.println("ping = " + ping);

    }
}
