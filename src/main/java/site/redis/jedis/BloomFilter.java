package site.redis.jedis;

import io.rebloom.client.Client;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

public class BloomFilter {
    public static void main(String[] args) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig<>();
        config.setMaxIdle(300);
        config.setMaxTotal(1000);
        config.setMaxWaitMillis(30000);
        config.setTestOnBorrow(true);
        JedisPool pool = new JedisPool(config, "192.168.19.129", 6379, 30000, "123456");
        Client client = new Client(pool);
        for (int i = 0; i < 10000; i++) {
            client.add("myname", "lihua-" + i);
        }
        boolean myname = client.exists("myname", "lihua-99999");
        System.out.println("myname = " + myname);

    }
}
