package idv.sheng.infra.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingApi {
    @GetMapping("/hello/python")
    public String helloPython() {
        return "Todo: The grpc-client feature is not ready yet.";
    }

    @GetMapping("/hello/golang")
    public String helloGo() {
        return "Todo: The grpc-client feature is not ready yet.";
    }
}
