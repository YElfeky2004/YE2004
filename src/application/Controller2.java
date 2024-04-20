package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Controller2 {

	@FXML
	Label label;
	@FXML
	Label label2;
	@FXML
	Button button;
	@FXML
	TextField nProductsField;
	private String name;
	private int customerID;
	int nProducts;
	void setAll(int customerID, String name){
		this.customerID=customerID;
		this.name=name;
		label2.setText("Hello,"+name);
	}
	
	public void goToShop(ActionEvent event) {
		try {nProducts = Integer.parseInt(nProductsField.getText().trim());
		if (nProducts <= 0) {
            throw new IllegalArgumentException("The number of products must be a positve integer");
        }
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
        Parent root = loader.load();
        
        Controller3 controller3 = loader.getController();
        controller3.setNProducts(customerID,nProducts);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
		}
		catch (NumberFormatException e) {
	        label.setText("Please enter a positive integer");
	    }
		catch (IllegalArgumentException e) {
	        label.setText(e.getMessage());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
