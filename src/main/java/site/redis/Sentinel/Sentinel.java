package site.redis.Sentinel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class Sentinel {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxWaitMillis(1000);
        String master = "mymaster";
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.19.129:26379");
        JedisSentinelPool sentinelPool = new JedisSentinelPool(master, sentinels, config, "123456");
        Jedis jedis = null;
        while (true) {
            try {
                jedis = sentinelPool.getResource();
                String k1 = jedis.get("k1");
                System.out.println("k1 = " + k1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
