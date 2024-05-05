package idv.sheng.infra.grpc.client;

import lombok.Getter;

@Getter
public enum GrpcClientType {
    TO_GOLANG("localhost", 50051),
    TO_PYTHON("localhost", 50052);
    private final String host;
    private final int port;

    GrpcClientType(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
