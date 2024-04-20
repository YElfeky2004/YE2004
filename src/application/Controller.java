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
public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Label myLabel;
	@FXML
	private TextField TField1;
	@FXML
	private TextField TField2;
	@FXML
	private TextField TField3;
	@FXML
	private Button button;
	int customerID;
	String name;
	String address;
	public void submit(ActionEvent event) {
	    try {
	        customerID = Integer.parseInt(TField2.getText().trim());
	        if (customerID <= 0) {
	            throw new IllegalArgumentException("Customer ID must be a positive integer.");
	        }
	        name = TField1.getText();
	        address = TField3.getText();
	        Customer customer = new Customer(customerID,name,address);
	        
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
	        root=loader.load();
	        Controller2 scene2 = loader.getController();
	        scene2.setAll(customer.getCID(), customer.getname());
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        
	        
	    } catch (NumberFormatException e) {
	        myLabel.setText("Please enter a valid Customer ID.");
	    } catch (IllegalArgumentException e) {
	        myLabel.setText(e.getMessage());
	    } catch (IOException e) {
	        e.printStackTrace(); 
	    }
	}

	
	public void switchToScene1(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}



