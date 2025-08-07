package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO;

public class OrderEditUseCase {

    private OrderDAOGateway dao;

    public OrderEditUseCase() {
        this.dao = new MockDBOrderDAO(); // có thể thay DI sau
    }

    public void execute(OrderViewModel viewModel) {
        Order order = OrderFactory.create(viewModel);
        double shippingCost = order.calculateShippingCost();

        OrderDTO dto = new OrderDTO(
        viewModel.orderId,
        viewModel.totalAmount,
        viewModel.orderType,
        viewModel.extraFee,
        shippingCost
    );
        dao.update(dto); // cập nhật dữ liệu trong DB
    }
}
