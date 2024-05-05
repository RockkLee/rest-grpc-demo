package idv.sheng.domain.entity;

import idv.sheng.domain.valueobject.ServerType;
import idv.sheng.domain.valueobject.GreetingId;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@Getter
public class Greeting {
    private final GreetingId greetingId;
    private final String userName;
    private final ServerType recipient;
    private String msg;

    public Greeting(String userName, ServerType recipient, String msg) {
        this.greetingId = new GreetingId(UUID.randomUUID());
        this.userName = userName;
        this.recipient = recipient;
        this.msg = msg;
    }

    public void doCoreBusinessLogic() {
        this.msg = String.format("""
                Hello server %s, this is client Java.
                Greet you from %s.
                Massage: %s
                """, recipient, userName, msg);
    }
}
