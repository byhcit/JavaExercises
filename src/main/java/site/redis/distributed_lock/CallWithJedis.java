package site.redis.distributed_lock;

import redis.clients.jedis.Jedis;

public interface CallWithJedis {
    void call(Jedis jedis);
}
