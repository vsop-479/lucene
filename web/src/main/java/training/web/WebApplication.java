package training.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import training.service.lucene.LuceneService;

@SpringBootApplication
@ComponentScan({"training.service","training.web", "training.util"})
public class WebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(WebApplication.class, args);
    }

}
