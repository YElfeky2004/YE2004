package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller6 {

    private Cart cart;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private ListView<String> productList;

    @FXML
    private Button confirmButton;

    @FXML
    private Button emptyCartButton;

    @FXML
    public void initialize() {
        for (Product product : cart.getproducts()) {
            productList.getItems().add(product.getname());
        }
    }

    @FXML
    private void handleConfirmButton(ActionEvent event) {
        int selectedIndex = productList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < cart.getproducts().length) {
            cart.removeProduct(cart.getproducts(), selectedIndex);
        }
        cart.placeOrder();
        switchToScene5();
    }

    @FXML
    private void handleEmptyCartButton(ActionEvent event) {
        switchToScene7();
    }

    @FXML
    private void switchToScene5() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene5.fxml"));
            Parent root = loader.load();

            Controller5 controller5 = loader.getController();
            if (controller5 != null) {
                controller5.setOrderInfo(cart.orderInfo);
            } else {
                System.err.println("Error: Controller5 is null.");
            }

            Stage stage = (Stage) confirmButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToScene7() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene7.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) emptyCartButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
