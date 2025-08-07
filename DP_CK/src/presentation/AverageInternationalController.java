package presentation;

import business.AverageInternationalOrderUseCase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AverageInternationalController {

    @FXML private Label resultLabel;

    private final AverageInternationalOrderUseCase useCase = new AverageInternationalOrderUseCase();

    @FXML
    public void initialize() {
        double avg = useCase.execute();
        resultLabel.setText(String.format("Trung bình tổng giá trị: $%.2f", avg));
    }
}
