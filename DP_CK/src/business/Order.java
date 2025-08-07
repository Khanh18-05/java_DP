package business;

public abstract class Order {
    protected String orderId;
    protected double totalAmount;

    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public abstract double calculateShippingCost();
}
