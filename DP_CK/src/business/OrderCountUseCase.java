package business;

import persistence.OrderDAOGateway;
import persistence.MockDBOrderDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderCountUseCase {

    private final OrderDAOGateway dao;

    public OrderCountUseCase() {
        this.dao = new MockDBOrderDAO();
    }

    public Map<String, Integer> execute() {
        List<OrderDTO> orders = dao.findAll();

        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("regular", 0);
        countMap.put("express", 0);
        countMap.put("international", 0);

        for (OrderDTO dto : orders) {
            String type = detectOrderType(dto);
            countMap.put(type, countMap.get(type) + 1);
        }

        return countMap;
    }

    private String detectOrderType(OrderDTO dto) {
        // Giả định đơn giản: dựa vào shippingCost
        if (dto.shippingCost == 5.0) return "regular";
        else if (dto.shippingCost > 5.0 && dto.shippingCost < 10.0 + 0.01) return "express";
        else return "international";
    }
}
