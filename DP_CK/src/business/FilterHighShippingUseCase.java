package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO;

import java.util.List;
import java.util.stream.Collectors;

public class FilterHighShippingUseCase {

    private final OrderDAOGateway dao;

    public FilterHighShippingUseCase() {
        this.dao = new MockDBOrderDAO();
    }

    public List<OrderDTO> execute() {
        return dao.findAll()
                  .stream()
                  .filter(dto -> dto.shippingCost >= 15.0)
                  .collect(Collectors.toList());
    }
}
