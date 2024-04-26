package site.redis.distributed_lock;

import redis.clients.jedis.params.SetParams;

import java.util.Arrays;
import java.util.UUID;

public class LuaTest {
    public static void main(String[] args) {
        Redis redis = new Redis();
        for (int i = 0; i < 2; i++) {
            redis.execute(jedis -> {
                // 先获取一个随机字符串
                String value = UUID.randomUUID().toString();
                // 获取锁
               String k1 = jedis.set("k1",value,new SetParams().nx().ex(5));
                // 判断是否成功拿到锁
                if (k1 != null && "OK".equalsIgnoreCase(k1)){
                    // 业务操作
                    jedis.set("site","www.hwali.site");
                    String site = jedis.get("site");
                    System.out.println("site = " + site);
                    // 释放锁
                    jedis.evalsha("b8059ba43af6ffe8bed3db65bac35d452f8115d8",
                            Arrays.asList("k1"),Arrays.asList(value));
                } else {
                    System.out.println("没拿到锁");
                }
            });
        }
    }
}
