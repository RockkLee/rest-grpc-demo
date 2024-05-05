package idv.sheng.app.port.input.service;

import idv.sheng.app.dto.MsgDto;

public interface GreetingService {
    MsgDto greet(String userName, int recipient, String message);

    String respGreeting(String userName, int recipient, String message);
}
