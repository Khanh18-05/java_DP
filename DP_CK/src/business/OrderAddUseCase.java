package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO; // tạm thời dùng mock

public class OrderAddUseCase {
    private OrderDAOGateway dao;

    public OrderAddUseCase() {
        this.dao = new MockDBOrderDAO();  // sau sẽ DI
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

        dao.save(dto);  // chuyển sang tầng persistence
    }
}
