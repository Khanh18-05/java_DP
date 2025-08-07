package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO;

public class OrderSearchUseCase {

    private final OrderDAOGateway dao;

    public OrderSearchUseCase() {
        this.dao = new MockDBOrderDAO();
    }

    public OrderDTO execute(String orderId) {
        return dao.findById(orderId); // có thể null
    }
}
