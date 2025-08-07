package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    public void onAddOrder(ActionEvent event) {
        openWindow("/presentation/OrderAddUI.fxml", "Add Order");
    }

    @FXML
    public void onEditOrder(ActionEvent event) {
        openWindow("/presentation/OrderEditUI.fxml", "Edit Order");
    }

    @FXML
    public void onViewOrders(ActionEvent event) {
        openWindow("/presentation/OrderListUI.fxml", "View Orders");
    }

    @FXML
    public void onDeleteOrder(ActionEvent event) {
        openWindow("/presentation/OrderDeleteUI.fxml", "Delete Order");
    }

    @FXML
    public void onSearchOrder(ActionEvent event) {
        openWindow("/presentation/OrderSearchUI.fxml", "Search Order");
    }

    @FXML
    public void onCountOrders(ActionEvent event) {
        openWindow("/presentation/OrderCountUI.fxml", "Order Type Counts");
    }

    @FXML
    public void onHighShippingOrders(ActionEvent event) {
        openWindow("/presentation/OrderHighShippingUI.fxml", "High Shipping Orders");
    }

    @FXML
    public void onAvgInternational(ActionEvent event) {
        openWindow("/presentation/AverageInternationalUI.fxml", "Average International Orders");
    }

    @FXML
    public void onExit(ActionEvent event) {
        System.exit(0);
    }

    private void openWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
