package idv.sheng.app.adapter.input.service;

import idv.sheng.app.dto.MsgDto;
import idv.sheng.app.dto.grpc.GreetingGrpcResp;
import idv.sheng.app.port.input.service.GreetingService;
import idv.sheng.app.port.output.publisher.GreetingPublisher;
import idv.sheng.domain.entity.Greeting;
import idv.sheng.domain.event.GreetingEvent;
import idv.sheng.domain.valueobject.ServerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingServiceImpl implements GreetingService {
    @Autowired
    private GreetingPublisher greetingPublisher;

    @Override
    public MsgDto greet(String userName, int recipient, String message) {
        Greeting greeting = GreetingServiceImpl.DomainMapper.toEntity(userName, ServerType.of(recipient), message);
        greeting.doCoreBusinessLogic();

        //TODO: Store the entity "Greeting" with the status "NEW" in the database through "GreetingRepository".
        //Greeting.status: "NEW", "RECEIVED_REPLY"
        GreetingGrpcResp resp = greetingPublisher.publish(new GreetingEvent(greeting));

        return new MsgDto(200, "Greeting success: " + resp.getMsg());
    }

    @Override
    public String respGreeting(String userName, int recipient, String message) {
        //TODO: Add a new entity named "Reply", and store "Reply" with the status "NEW" in the database through "ReplyRepository".
        //Reply.status: "NEW", "REPLIED"
        return "not finished yet";
    }

    public static class DomainMapper {
        public static Greeting toEntity(String userName, ServerType serverType, String message) {
            return new Greeting(userName, serverType, message);
        }
    }
}
