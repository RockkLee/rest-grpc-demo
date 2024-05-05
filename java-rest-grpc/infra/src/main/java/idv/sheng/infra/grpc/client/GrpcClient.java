package idv.sheng.infra.grpc.client;

import idv.sheng.infra.grpc.GreetingGrpc;
import idv.sheng.infra.grpc.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
@EqualsAndHashCode
public abstract class GrpcClient<T,R> {
    private final GreetingServiceGrpc.GreetingServiceBlockingStub stub;
    private final ManagedChannel channel;
    public GrpcClient(GrpcClientType clientType) {
        channel = ManagedChannelBuilder
                .forAddress(clientType.getHost(), clientType.getPort())
                .usePlaintext()
                .build();
        stub = GreetingServiceGrpc.newBlockingStub(channel);
    }

    public R wrapStub(Supplier<R> supplier) {
        if (channel == null || channel.isShutdown())
            throw new RuntimeException("channel is shutdown");
        if (stub == null)
            throw new RuntimeException("stub is null");

        R resp = supplier.get();

        channel.shutdown();
        return resp;
    }

    /**
     * Plz use wrapStub in the implementation of this method
     * @param req
     * @return
     */
    public abstract R runStub(T req);
}
