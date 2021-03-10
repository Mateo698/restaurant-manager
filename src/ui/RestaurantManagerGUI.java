package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Restaurant;

public class RestaurantManagerGUI {
	
	@FXML
    private TextField SIGNINfirstNamesTxtField;

    @FXML
    private TextField SIGNINlastNamesTxtField;

    @FXML
    private TextField SIGNINidTxtField;

    @FXML
    private TextField SIGNINusernameTxtField;

    @FXML
    private PasswordField SIGNINpassTxtField;
	    
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
    
    private Restaurant restaurant;
    
    public RestaurantManagerGUI(Restaurant restaurant) {
    	this.restaurant = restaurant;
    	
    }
    
    public void showLogin() throws IOException {
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	welcomePane.getChildren().setAll(addLogin);
    	
    }
    
    public void goToLogin(ActionEvent event) throws IOException {
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	welcomePane.getChildren().setAll(addLogin);
    	
    }
    
    @FXML
    public void goToSignin(ActionEvent event) throws IOException{
    	FXMLLoader signinLoader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
    	signinLoader.setController(this);
    	Parent addSignIn = signinLoader.load();
    	welcomePane.getChildren().setAll(addSignIn);
    	
    }

}
