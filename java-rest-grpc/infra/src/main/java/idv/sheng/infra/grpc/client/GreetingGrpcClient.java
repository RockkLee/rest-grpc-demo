package idv.sheng.infra.grpc.client;

import idv.sheng.infra.grpc.GreetingGrpc;
import idv.sheng.infra.grpc.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class GreetingGrpcClient extends GrpcClient<GreetingGrpc.Req,GreetingGrpc.Resp> {
    public GreetingGrpcClient(GrpcClientType clientType) {
        super(clientType);
    }

    @Override
    public GreetingGrpc.Resp runStub(GreetingGrpc.Req req) {
        return wrapStub(() -> this.getStub().greet(req));
    }
}
