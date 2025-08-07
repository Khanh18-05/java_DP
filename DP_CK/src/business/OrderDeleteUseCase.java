package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO;

public class OrderDeleteUseCase {

    private OrderDAOGateway dao;

    public OrderDeleteUseCase() {
        this.dao = new MockDBOrderDAO();
    }

    public void execute(String orderId) {
        dao.delete(orderId);
    }
}
