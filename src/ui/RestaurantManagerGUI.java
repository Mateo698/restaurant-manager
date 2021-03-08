package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Restaurant;

public class RestaurantManagerGUI {
	

    @FXML
    private TextField LOGNusernameTxtField;

    @FXML
    private TextField LOGINpassTxtField;

    @FXML
    private Button LOGINlogInButton;

    @FXML
    private Button LOGINsignInBttn;
    
    @FXML
    private BorderPane welcomePane;
    
    private Restaurant r;
    
    public RestaurantManagerGUI(Restaurant R) {
    	r = R;
    }
    
    public void loadLogin() throws IOException {
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	welcomePane.getChildren().setAll(addLogin);
    }
	
}
