package persistence;

import business.OrderDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDBOrderDAO implements OrderDAOGateway {

    private static final Map<String, OrderDTO> database = new HashMap<>();

    @Override
    public void save(OrderDTO order) {
        database.put(order.orderId, order);
        System.out.println("Saved order to MockDB: " + order.orderId);
    }

    @Override
    public void update(OrderDTO order) {
        if (database.containsKey(order.orderId)) {
            database.put(order.orderId, order);
            System.out.println("Updated order in MockDB: " + order.orderId);
        } else {
            System.out.println("Cannot update: Order ID not found → " + order.orderId);
        }
    }

    @Override
    public void delete(String orderId) {
        if (database.containsKey(orderId)) {
            database.remove(orderId);
            System.out.println("Deleted order: " + orderId);
        } else {
            System.out.println("Order not found: " + orderId);
        }
    }

    @Override
    public List<OrderDTO> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public OrderDTO findById(String orderId) {
        return database.get(orderId); // null nếu không tìm thấy
    }


    // Optional: dùng để xem toàn bộ đơn hàng
    public static void printAllOrders() {
        System.out.println("---- All Orders in MockDB ----");
        for (OrderDTO o : database.values()) {
            System.out.println("ID: " + o.orderId + ", Total: $" + o.totalAmount + ", Shipping: $" + o.shippingCost);
        }
    }

}
