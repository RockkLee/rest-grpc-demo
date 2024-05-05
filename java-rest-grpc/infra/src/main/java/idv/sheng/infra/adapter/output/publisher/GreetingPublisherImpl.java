package idv.sheng.infra.adapter.output.publisher;

import idv.sheng.app.dto.grpc.GreetingGrpcResp;
import idv.sheng.app.port.output.publisher.GreetingPublisher;
import idv.sheng.domain.event.GreetingEvent;
import idv.sheng.infra.grpc.GreetingGrpc;
import idv.sheng.infra.grpc.client.GreetingGrpcClient;
import idv.sheng.infra.grpc.client.GrpcClientType;
import org.springframework.stereotype.Component;

@Component
public class GreetingPublisherImpl implements GreetingPublisher {
    @Override
    public GreetingGrpcResp publish(GreetingEvent event) {
        GreetingGrpcClient client = new GreetingGrpcClient(GrpcClientType.TO_GOLANG);
        GreetingGrpc.Resp resp = client.runStub(
                GreetingGrpc.Req.newBuilder()
                        .setMsg(event.getMsg())
                        .setRecipient(GreetingGrpc.ServerType.valueOf(event.getRecipient().getCode()))
                        .build()
        );

        return GreetingGrpcResp.builder()
                .msg(resp.getMsg())
                .build();
    }
}
