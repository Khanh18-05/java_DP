package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO;

import java.util.List;

public class AverageInternationalOrderUseCase {

    private final OrderDAOGateway dao;

    public AverageInternationalOrderUseCase() {
        this.dao = new MockDBOrderDAO();
    }

    public double execute() {
        List<OrderDTO> orders = dao.findAll();

        double total = 0.0;
        int count = 0;

        for (OrderDTO dto : orders) {
            if ("international".equalsIgnoreCase(dto.type)) {
                total += dto.totalAmount;
                count++;
            }
        }

        return count == 0 ? 0.0 : total / count;
    }
}
