import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ComponentScan("org.course.code")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
