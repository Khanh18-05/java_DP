package presentation;

import business.OrderDTO;
import business.OrderSearchUseCase;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderSearchController {

    @FXML private TextField orderIdField;
    @FXML private Label resultLabel;

    private final OrderSearchUseCase useCase = new OrderSearchUseCase();

    @FXML
    public void onSearch() {
        String orderId = orderIdField.getText();
        if (orderId.isEmpty()) {
            resultLabel.setText("Please enter an order ID.");
            return;
        }

        OrderDTO dto = useCase.execute(orderId);
        if (dto != null) {
            resultLabel.setText(
                "Order ID: " + dto.orderId +
                "\nTotal: $" + dto.totalAmount +
                "\nShipping: $" + dto.shippingCost
            );
        } else {
            resultLabel.setText("Order not found.");
        }
    }
}
