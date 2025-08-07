package business;

public class OrderFactory {
    public static Order create(OrderViewModel vm) {
        switch (vm.orderType.toLowerCase()) {
            case "regular":
                return new RegularOrder(vm.orderId, vm.totalAmount);
            case "express":
                return new ExpressOrder(vm.orderId, vm.totalAmount, vm.extraFee);
            case "international":
                return new InternationalOrder(vm.orderId, vm.totalAmount, vm.extraFee);
            default:
                throw new IllegalArgumentException("Unknown order type: " + vm.orderType);
        }
    }
}
