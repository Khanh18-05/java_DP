package business;

public class OrderDTO {
    public String orderId;
    public double totalAmount;
    public String type;
    public double extraFee;

    public double shippingCost; // ✅ THÊM DÒNG NÀY

    public OrderDTO(String orderId, double totalAmount, String type, double extraFee, double shippingCost) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.type = type;
        this.extraFee = extraFee;
        this.shippingCost = shippingCost; // ✅ GÁN GIÁ TRỊ
    }
}
