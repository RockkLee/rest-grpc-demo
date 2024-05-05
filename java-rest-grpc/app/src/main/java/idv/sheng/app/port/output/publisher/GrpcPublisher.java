package idv.sheng.app.port.output.publisher;

interface GrpcPublisher<T, R> {
    R publish(T t);
}
