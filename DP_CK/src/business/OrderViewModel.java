package business;

public class OrderViewModel {
    public String orderId;
    public double totalAmount;
    public String orderType;
    public double extraFee; // Là rushFee hoặc customsFee tùy loại

    public OrderViewModel(String orderId, double totalAmount, String orderType, double extraFee) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderType = orderType;
        this.extraFee = extraFee;
    }
}
