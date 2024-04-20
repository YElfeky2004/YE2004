package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller4 {
    private Cart cart;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private Label label;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    public void initialize() {
        if (label != null) {
            label.setText("Would you like to place the Order?");
            label.setStyle("-fx-font-size: 24px;");
        } else {
            System.err.println("Error: Label is not properly initialized.");
        }
    }

    @FXML
    private void handleYesButton() {
        cart.placeOrder();
        switchToScene5();
    }

    @FXML
    private void handleNoButton() {
    	switchToScene6(cart);
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

            Stage stage = (Stage) yesButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    
    private void switchToScene6(Cart cart) {
    	//i put cart Cart cuz it makes a compiler error go away.
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene6.fxml"));
            Controller6 controller6 = new Controller6();
            controller6.setCart(cart); 
            loader.setController(controller6);
            Parent root = loader.load();

            Stage stage = (Stage) noButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
