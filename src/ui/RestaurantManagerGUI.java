package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.swing.Timer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Employee;
import model.Restaurant;
import model.User;

public class RestaurantManagerGUI implements Initializable{
	
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
    private PasswordField LOGNpassPswrdField;
    
    @FXML
    private TableView<Employee> EMPMENUtable;

    @FXML
    private TableColumn<Employee, String> EMPMENUnamesCol;

    @FXML
    private TableColumn<Employee, String> EMPMENUlastNamesCol;

    @FXML
    private TableColumn<Employee, Integer> EMPMENUidCol;

    @FXML
    private TableColumn<Employee, Integer> EMPMENUdelivOrdCol;
    
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private BorderPane welcomePane;
    
    private Restaurant restaurant;
    
    private Stage mainStage;
    
    private Stage popupStage;
    
    public RestaurantManagerGUI(Restaurant restaurant) {
    	this.restaurant = restaurant;
    	restaurant.addUser("Admin", "123", "Nombre", "Apellido", 0, 0);
    }
    
    
    
    public void goToLogin(ActionEvent event) throws IOException {
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	Scene E = new Scene(addLogin);
    	mainStage.setScene(E);
    	
    }
    
    @FXML
    public void createUser(ActionEvent event) throws IOException {
	    if(!SIGNINpassTxtField.getText().equals("") && !SIGNINusernameTxtField.getText().equals("") && !SIGNINfirstNamesTxtField.getText().equals("") && 
	    		!SIGNINlastNamesTxtField.getText().equals("") && !SIGNINidTxtField.getText().equals("")) {	
    		
	    	//ANOTALO AHI HOMBRE. VERIFICAR QUE NO HAYA USER REPETIDO. VERFICIAR ID QUE SEA NUMERO
	    	
	    	String username = SIGNINpassTxtField.getText();
	    	String password = SIGNINusernameTxtField.getText();
	    	String names = SIGNINfirstNamesTxtField.getText();
	    	String lastNames = SIGNINlastNamesTxtField.getText();
	    	int ID = Integer.parseInt(SIGNINidTxtField.getText());
	    	int amountOrder = 0;
	    	
	    	restaurant.addUser(username, password, names, lastNames, ID, amountOrder);
	    	
	    	Alert alert= new Alert(AlertType.INFORMATION);
	    	alert.setTitle("User created");
			alert.setContentText("The user was created succesfuly.");
			alert.show();
	    	

	    }
	    
	    else {
	    	Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Complete the information!");
			alertWarnings.setHeaderText("The information has not been completed.");
			alertWarnings.setContentText("You have not filled all the fields for the information. Please, do it.");
			alertWarnings.show();
			
	    }
    	
    	
    	
    }
    
    @FXML
    public void goToSignin(ActionEvent event) throws IOException{
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Signin.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	
    	Scene e = new Scene(root);
    	
    	mainStage.setScene(e);
    	
    	
    }
    

    @FXML
    public void signUp(ActionEvent event) throws IOException{
    	ArrayList<User> usersAux = restaurant.getUsers();
    	
    	String username = LOGNusernameTxtField.getText();
    	String password = LOGNpassPswrdField.getText();
    	
    	Alert alertWarnings = new Alert(AlertType.WARNING);
    	
    	if (!username.equals("") && !password.equals("") && usersAux.size()!=0) {
    		for (int i = 0; i < usersAux.size(); i++) {
    			if(username.equalsIgnoreCase(usersAux.get(i).getName()) && password.equals(usersAux.get(i).getPassword())) {
    				goToMain();
    				
    			}
    			
    			else {
    				alertWarnings.setTitle("Problems with the given infomation!");
    				alertWarnings.setHeaderText("The username or the password is wrong");
    				alertWarnings.setContentText("The username or the password you wrote is wrong");
    				alertWarnings.show();
    			}
    		}
		}
		
		else{
			alertWarnings.setTitle("PROBLEMS");
			alertWarnings.setHeaderText("The information has not been completed or there is not created users");
			alertWarnings.setContentText("You have not filled all the fields for the information. Please, do it.");
			alertWarnings.show();
			
		}
    }
    
    @FXML
    private Label MAINlocalUserLabel;

    @FXML
    private Label MAINcurrentTimeLabel;
    
    public void goToMain() throws IOException{
    	FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
    	mainLoader.setController(this);
    	Parent addMain = mainLoader.load();
    	Scene E = new Scene(addMain);
    	mainStage.setScene(E);
    }
    

    @FXML
    void MAINopenCLMENU(ActionEvent event) {

    }

    @FXML
    public void MAINopenEMPMENU(ActionEvent event) throws IOException {
    	FXMLLoader empLoader = new FXMLLoader(getClass().getResource("EmployeeManager.fxml"));
    	empLoader.setController(this);
    	Parent addMain = empLoader.load();
    	mainPane.getChildren().setAll(addMain);
    	//TRABAJO DE YULUKA HCAER QUE ESA VAINA HAGA RESIZE
    	//INICIALIZAR LA TABLE VIEW CON LOS EMPLEAOS
    }

    @FXML
    void MAINopenUSERMENU(ActionEvent event) throws IOException {
    	FXMLLoader empLoader = new FXMLLoader(getClass().getResource("UserManager.fxml"));
    	empLoader.setController(this);
    	Parent addMain = empLoader.load();
    	mainPane.getChildren().setAll(addMain);
    }
    
    @FXML
    void EMPMENUaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEmployeeWindow.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	popupStage = new Stage();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	popupStage.show();
    	mainStage.hide();
    }

    @FXML
    void EMPMENUdbackBttn(ActionEvent event) {
    	
    
    }

    @FXML
    void EMPMENUdeleteBttn(ActionEvent event) {

    }

    @FXML
    void EMPMENUdisableBttn(ActionEvent event) {

    }

    @FXML
    void EMPMENUeditBttn(ActionEvent event) {

    }
    
    @FXML
    private TextField ADDEMPnamesTxtField;

    @FXML
    private TextField ADDEMPlastNamesTxtField;

    @FXML
    private TextField ADDEMPidTxtField;

    @FXML
    void ADDEMPaddBttn(ActionEvent event) {
    	String names = ADDEMPnamesTxtField.getText();
    	String lastNames = ADDEMPlastNamesTxtField.getText();
    	String id = ADDEMPidTxtField.getText();
    }

    @FXML
    void ADDEMPbackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void start() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	mainStage = new Stage();
    	Scene e = new Scene(root);
    	mainStage.setScene(e);
    	mainStage.show();
	}
  
}
