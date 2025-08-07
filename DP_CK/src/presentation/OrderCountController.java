package presentation;

import business.OrderCountUseCase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Map;

public class OrderCountController {

    @FXML private Label regularLabel;
    @FXML private Label expressLabel;
    @FXML private Label internationalLabel;

    private final OrderCountUseCase useCase = new OrderCountUseCase();

    @FXML
    public void initialize() {
        Map<String, Integer> result = useCase.execute();

        regularLabel.setText("Regular Orders: " + result.get("regular"));
        expressLabel.setText("Express Orders: " + result.get("express"));
        internationalLabel.setText("International Orders: " + result.get("international"));
    }
}
