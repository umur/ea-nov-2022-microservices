package lab6.product.interfaces;

public interface ProductRabbitConsumer {
    void bindToProductQueue(String payload);
}
