package site.redis.distributed_lock;

public class HyperLogLog {
    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.execute(jedis -> {
            for (int i = 0; i < 1000; i++) {
                jedis.pfadd("uv", "u" + i, "u" + (i + 1));
            }
            long uv = jedis.pfcount("uv");
            System.out.println("uv = " + uv);
        });
    }
}
