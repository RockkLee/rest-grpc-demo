package idv.sheng.domain.event;

import idv.sheng.domain.common.event.DomainEvent;
import idv.sheng.domain.entity.Greeting;
import idv.sheng.domain.valueobject.ServerType;
import lombok.Getter;

@Getter
public class GreetingEvent implements DomainEvent<Greeting> {
    private final String userName;
    private final ServerType recipient;
    private final String msg;

    public GreetingEvent(Greeting entity) {
        this.userName = entity.getUserName();
        this.recipient = entity.getRecipient();
        this.msg = entity.getMsg();
    }
}
