package site.redis.scan;

import site.redis.Redis;

public class ScanTest {
    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.execute(jedis -> {
            for (int i = 0; i < 10000; i++) {
                jedis.set("k" + i, "v" + i);
            }
        });
    }
}
