package idv.sheng.infra.rest;

import idv.sheng.app.port.input.service.GreetingService;
import idv.sheng.domain.valueobject.ServerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingApi {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greet")
    public String greetPython(String userName, int recipient, String msg) {
        return greetingService.greet(userName, recipient, msg)
                .getMsg();

    }
}
