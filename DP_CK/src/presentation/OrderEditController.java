package presentation;

import business.OrderEditUseCase;
import business.OrderViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderEditController {

    @FXML private TextField orderIdField;
    @FXML private TextField totalAmountField;
    @FXML private ComboBox<String> orderTypeComboBox;
    @FXML private TextField extraFeeField;

    private OrderEditUseCase useCase;

    public OrderEditController() {
        this.useCase = new OrderEditUseCase();
    }

    @FXML
    public void onUpdateOrder() {
        try {
            String orderId = orderIdField.getText();
            double totalAmount = Double.parseDouble(totalAmountField.getText());
            String type = orderTypeComboBox.getValue();
            double extraFee = extraFeeField.getText().isEmpty() ? 0.0 : Double.parseDouble(extraFeeField.getText());

            OrderViewModel viewModel = new OrderViewModel(orderId, totalAmount, type, extraFee);
            useCase.execute(viewModel);

            showAlert("Success", "Order updated successfully!");
        } catch (Exception e) {
            showAlert("Error", "Invalid input: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
