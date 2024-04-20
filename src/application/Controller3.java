package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller3 {
	int customerID;
    int nProducts;
    Product[] products;
    int productCount = 0;
    Cart cart = new Cart(); 

    @FXML
    Label label;
    @FXML
    Button add;
    @FXML
    ImageView smartphone;
    @FXML
    ImageView tshirt;
    @FXML
    ImageView oop;
    @FXML
    RadioButton rButton1;
    @FXML
    RadioButton rButton2;
    @FXML
    RadioButton rButton3;
    @FXML
    ToggleGroup productToggleGroup;

    @FXML
    public void initialize() {
        add.setDisable(true);
    }
 
    public void setNProducts(int customerID,int nProducts) {
        this.nProducts = nProducts;
        this.products = new Product[nProducts];
        this.customerID = customerID;
        this.cart = new Cart(customerID, nProducts, products);
    }

    @FXML
    public void handleRadioButtonAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) productToggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            add.setDisable(false);
        }
    }

    @FXML
    public void addToCart(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) productToggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            int productChoice = Integer.parseInt(selectedRadioButton.getId().substring(7));
            if (productCount < nProducts) {
                switch (productChoice) {
                    case 1:
                        products[productCount] = new ElectronicProduct(1, "Smartphone", 599.99f, "Samsung", 1);
                        break;
                    case 2:
                        products[productCount] = new ClothingProduct(2, "T-Shirt", 19.99f, "Medium", "Cotton");
                        break;
                    case 3:
                        products[productCount] = new BookProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");
                        break;
                }
                cart.addProduct(products[productCount]);
                if (productCount == nProducts - 1) {
                    switchToScene4(); 
                }
                productCount++;
            } 
        }
        add.setDisable(true);
    }


    @FXML
    private void switchToScene4() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));
            Parent root = loader.load();

            Controller4 controller4 = loader.getController();
            controller4.setCart(cart); 

            Stage stage = (Stage) add.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
