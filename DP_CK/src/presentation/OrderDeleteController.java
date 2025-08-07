package presentation;

import business.OrderDeleteUseCase;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderDeleteController {

    @FXML private TextField orderIdField;

    private OrderDeleteUseCase useCase;

    public OrderDeleteController() {
        this.useCase = new OrderDeleteUseCase();
    }

    @FXML
    public void onDeleteOrder() {
        String orderId = orderIdField.getText();
        if (orderId.isEmpty()) {
            showAlert("Error", "Order ID is required.");
            return;
        }

        useCase.execute(orderId);
        showAlert("Success", "Order deleted (if it existed).");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
