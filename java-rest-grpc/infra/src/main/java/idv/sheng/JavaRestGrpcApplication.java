package idv.sheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("idv.sheng.*")
public class JavaRestGrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRestGrpcApplication.class, args);
    }

}
