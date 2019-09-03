package training.web.commandLine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import training.service.lucene.LuceneService;
import training.util.redis.RedisUtil;

/**
 * SpringApplication.run构造applicationContext之后，会调用Runner.run。
 * 也可以通过代码，在main中applicationContext.getBean调用。
 * 多个Runner时，使用order指定顺序，小的先执行。
 * 相似功能：ApplicationRunner。
 */
@Component
@Order(value = 1)
public class BootstrapRunner implements CommandLineRunner {
    @Autowired
    private LuceneService luceneService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(String... args) throws Exception {
        redisUtil.get("aaa");
    }
}
