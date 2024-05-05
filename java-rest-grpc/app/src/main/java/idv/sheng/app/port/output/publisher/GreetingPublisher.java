package idv.sheng.app.port.output.publisher;

import idv.sheng.app.dto.grpc.GreetingGrpcResp;
import idv.sheng.domain.event.GreetingEvent;

public interface GreetingPublisher extends GrpcPublisher<GreetingEvent, GreetingGrpcResp> {
    @Override
    GreetingGrpcResp publish(GreetingEvent event);
}
