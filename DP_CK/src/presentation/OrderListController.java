package presentation;

import business.OrderDTO;
import business.OrderListUseCase;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderListController {

    @FXML private TableView<OrderDTO> orderTable;
    @FXML private TableColumn<OrderDTO, String> idCol;
    @FXML private TableColumn<OrderDTO, Double> amountCol;
    @FXML private TableColumn<OrderDTO, Double> shipCol;

    private final OrderListUseCase useCase = new OrderListUseCase();

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().orderId));
        amountCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().totalAmount).asObject());
        shipCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().shippingCost).asObject());

        orderTable.setItems(FXCollections.observableArrayList(useCase.execute()));
    }
}
