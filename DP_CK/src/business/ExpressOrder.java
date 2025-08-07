package business;

public class ExpressOrder extends Order {
    private double rushFee;

    public ExpressOrder(String orderId, double totalAmount, double rushFee) {
        super(orderId, totalAmount);
        this.rushFee = rushFee;
    }

    @Override
    public double calculateShippingCost() {
        return 5.0 + rushFee;
    }
}
