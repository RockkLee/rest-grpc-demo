package idv.sheng.infra.grpc.server;

import idv.sheng.app.port.input.service.GreetingService;
import idv.sheng.infra.grpc.GreetingServiceGrpc;

public class GreetingGrpcImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    //TODO: Not sure if the class "GreetingGrpcImpl" can be injected into spring container for using "@Autowired"
    private GreetingService greetingService;

    @Override
    public void greet(idv.sheng.infra.grpc.GreetingGrpc.Req request,
                      io.grpc.stub.StreamObserver<idv.sheng.infra.grpc.GreetingGrpc.Resp> responseObserver) {
        //TODO: Get the bean from Spring container to use greetingService in this method

        String msg = String.format("Hello, %s!", request.getMsg());
        idv.sheng.infra.grpc.GreetingGrpc.Resp response = idv.sheng.infra.grpc.GreetingGrpc.Resp.newBuilder()
                .setMsg(msg).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
