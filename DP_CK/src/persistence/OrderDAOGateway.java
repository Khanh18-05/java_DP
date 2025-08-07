package persistence;

import java.util.List;

import business.OrderDTO;

public interface OrderDAOGateway {
    void save(OrderDTO order);
    void update(OrderDTO order);
    void delete(String orderId); // 👈 thêm dòng này
    List<OrderDTO> findAll();
    OrderDTO findById(String orderId);

}

