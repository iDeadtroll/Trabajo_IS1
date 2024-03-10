package barranquillo;

public class OrderContexStrategy {
    private OrderStrategy orderStrategy;

    public void setStrategy(OrderStrategy orderStrategy) {
        this.orderStrategy = orderStrategy;
    }

    public void orderRunner(String dni) {
        orderStrategy.iniciar(dni);
    }
}
