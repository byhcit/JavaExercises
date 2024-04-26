package site.redis.distributed_lock;

import cn.hutool.core.util.StrUtil;
import redis.clients.jedis.params.SetParams;

public class LockTest {
    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.execute(jedis -> {
            //操作一:获取锁跟设置过期时间是两个操作,多线程不能保证原子性
//            Long setnx = jedis.setnx("k1", "v1");
//            if (setnx == 1) {
//                // 没人占位
//                // 给锁加一个过期时间,防止应用在运行过程中抛出异常导致锁无法及时得到释放
//                jedis.expire("k1",5);
//                jedis.setnx("name", "lihua");
//                String name = jedis.get("name");
//                System.out.println("name = " + name);
//                jedis.del("k1");
//            } else {
//                //有人占位,停止/暂缓操作
//            }
            //操作二:
            String set = jedis.set("k1", "v1", new SetParams().nx().ex(5));
            if (StrUtil.isNotBlank(set)&&"OK".equalsIgnoreCase(set)){
                jedis.expire("k1", 5);
                //没人占位
                jedis.set("name", "lihua");
                String name = jedis.get("name");
                System.out.println(name);
                jedis.del("k1");//释放资源
            }
        });
    }
}
