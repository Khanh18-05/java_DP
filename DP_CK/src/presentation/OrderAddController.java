package presentation;

import business.OrderAddUseCase;
import business.OrderViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderAddController {

    @FXML private TextField orderIdField;
    @FXML private TextField totalAmountField;
    @FXML private ComboBox<String> orderTypeComboBox;
    @FXML private TextField extraFeeField;

    private OrderAddUseCase useCase;

    public OrderAddController() {
        // Inject UseCase (tạm thời hardcode, sau có thể DI)
        this.useCase = new OrderAddUseCase();
    }

    @FXML
    public void onAddOrder() {
        try {
            String orderId = orderIdField.getText();
            double totalAmount = Double.parseDouble(totalAmountField.getText());
            String type = orderTypeComboBox.getValue();
            double extraFee = extraFeeField.getText().isEmpty() ? 0.0 : Double.parseDouble(extraFeeField.getText());

            OrderViewModel viewModel = new OrderViewModel(orderId, totalAmount, type, extraFee);
            useCase.execute(viewModel);

            showAlert("Success", "Order added successfully!");
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
