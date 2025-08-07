package business;

public class InternationalOrder extends Order {
    private double customsFee;

    public InternationalOrder(String orderId, double totalAmount, double customsFee) {
        super(orderId, totalAmount);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateShippingCost() {
        return 10.0 + customsFee;
    }
}
