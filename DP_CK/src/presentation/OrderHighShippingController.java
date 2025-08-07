package presentation;

import business.FilterHighShippingUseCase;
import business.OrderDTO;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class OrderHighShippingController {

    @FXML private ListView<String> orderListView;

    private final FilterHighShippingUseCase useCase = new FilterHighShippingUseCase();

    @FXML
    public void initialize() {
        for (OrderDTO dto : useCase.execute()) {
            String info = String.format("ID: %s | Total: %.2f | Ship: %.2f", dto.orderId, dto.totalAmount, dto.shippingCost);
            orderListView.getItems().add(info);
        }
    }
}
