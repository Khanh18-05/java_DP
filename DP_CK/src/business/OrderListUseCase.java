package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO;

import java.util.List;

public class OrderListUseCase {

    private OrderDAOGateway dao;

    public OrderListUseCase() {
        this.dao = new MockDBOrderDAO(); // DI có thể thay
    }

    public List<OrderDTO> execute() {
        return dao.findAll();
    }
}
