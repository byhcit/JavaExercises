package site.redis.Transaction;

import cn.hutool.core.util.StrUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import site.redis.Redis;

import java.util.List;

public class TransactionTest {
    public static void main(String[] args) {
        new Redis().execute(jedis -> {
            new TransactionTest().saveMoney(jedis, "lihua", 1000);
        });
    }

    public Integer saveMoney(Jedis jedis, String userId, Integer money) {
        while (true) {
            jedis.watch(userId);
            int v = 0;
            if (StrUtil.isBlank(jedis.get(userId))) {
                v = money;
            } else {
                v = Integer.parseInt(jedis.get(userId)) + money;
            }
            Transaction tx = jedis.multi();
            tx.set(userId, String.valueOf(v));
            List<Object> exec = tx.exec();
            if (exec != null) {
                break;
            }
        }
        return Integer.parseInt(jedis.get(userId));
    }
}
