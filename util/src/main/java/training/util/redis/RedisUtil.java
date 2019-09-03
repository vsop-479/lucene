package training.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil{
    private static final String SCRIPT = new StringBuilder()
            .append("local i = tonumber(ARGV[1])\n")
            .append("local res = {}\n")
            .append("local length = redis.call('llen',KEYS[1])\n")
            .append("if length < i then i = length end\n")
            .append("if i > 0 then\n")
            .append("    res = redis.call('lrange', KEYS[1], -i, -1)\n")
            .append("    i=i+1\n")
            .append("    redis.call('ltrim', KEYS[1], 0, -i)\n")
            .append("end\n")
            .append("return res\n").toString();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }
}
