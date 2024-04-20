package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller5 {
    @FXML
    private Label orderLabel;

    public void setOrderInfo(String orderInfo) {
        orderLabel.setText(orderInfo);
    }
}
