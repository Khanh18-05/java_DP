package business;

public class RegularOrder extends Order {
    public RegularOrder(String orderId, double totalAmount) {
        super(orderId, totalAmount);
    }

    @Override
    public double calculateShippingCost() {
        return 5.0;
    }
}
