package site.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import site.redis.Redis;

public class RateLimiter {
    private Jedis jedis;

    public RateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isAllowed(String user, String action, int period, int maxCount) {
        // 数据使用 zset 保存，首先生成一个 key
        String key = user + "-" + action;
        // 获取当前时间戳
        long nowTime = System.currentTimeMillis();
        // 建立管道
        Pipeline pipelined = jedis.pipelined();
        pipelined.multi();
        // 将当前操作存储下来
        pipelined.zadd(key, nowTime, String.valueOf(nowTime));
        // 移出时间窗之外的数据
        pipelined.zremrangeByScore(key, 0, nowTime - period * 1000);
        // 统计剩下的key
        Response<Long> response = pipelined.zcard(key);
        // 关闭管道
        pipelined.exec();
        pipelined.close();
        // 比较时间窗内的操作数
        return response.get() <= maxCount;
    }

    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.execute(j -> {
            RateLimiter rateLimiter = new RateLimiter(j);
            try {

                for (int i = 0; i < 20; i++) {
                    System.out.println(i + ">>>" + rateLimiter.isAllowed("lihua", "publish", 5, 3));
                    if (i % 5 == 0) {
                        Thread.sleep(1000);
                    }
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
