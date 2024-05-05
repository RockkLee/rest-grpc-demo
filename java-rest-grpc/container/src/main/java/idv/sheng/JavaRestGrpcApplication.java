package idv.sheng;

import idv.sheng.infra.grpc.server.GreetingGrpcImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("idv.sheng.*")
public class JavaRestGrpcApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(JavaRestGrpcApplication.class, args);

        //start gRPC server
        io.grpc.Server server = io.grpc.ServerBuilder.forPort(8080)
                .addService(new GreetingGrpcImpl())
                .build();
        server.start();
        server.awaitTermination();
    }

}
