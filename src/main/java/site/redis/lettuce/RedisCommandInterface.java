package site.redis.lettuce;


import io.lettuce.core.dynamic.Commands;
import io.lettuce.core.dynamic.annotation.Command;

import java.util.List;

public interface RedisCommandInterface extends Commands {
    @Command("CL.THROTTLE ?0 ?1 ?2 ?3 ?4")
    List<Object> throttle(String key,Long init,Long count,Long period,Long quota);
}
