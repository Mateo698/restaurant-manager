package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Client;
import model.Employee;
import model.Ingredient;
import model.Product;
import model.Restaurant;
import model.Type;
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
    private TableColumn<Employee, String> EMPMENUidCol;

    @FXML
    private TableColumn<Employee, Integer> EMPMENUdelivOrdCol;
    
    @FXML
    private TableView<User> USERMENUtable;

    @FXML
    private TableColumn<User, String> USERMANusernameCol;

    @FXML
    private TableColumn<User, String> USERMANnamesCol;

    @FXML
    private TableColumn<User, String> USERMANlastNamesCol;

    @FXML
    private TableColumn<User, String> USERMANidCol;
    
    @FXML
    private BorderPane MAINmainPane;
    
    @FXML
    private BorderPane welcomePane;
    
    @FXML
    private Label MAINlocalUserLabel;

    @FXML
    private Label MAINcurrentTimeLabel;
    
    @FXML
    private TextField ADDEMPnamesTxtField;

    @FXML
    private TextField ADDEMPlastNamesTxtField;

    @FXML
    private TextField ADDEMPidTxtField;
    
    @FXML
    private Label ADDEMPstatusLabel;

    @FXML
    private TextField ADDUSERusernameTxField;

    @FXML
    private PasswordField ADDUSERpasswordTxtField;

    @FXML
    private TextField ADDUSERnamesTxtField;

    @FXML
    private TextField ADDUSERlastNamesTxtFIeld;

    @FXML
    private TextField ADDUSERidTxtField;

    @FXML
    private TableView<Client> CLMENUtable;

    @FXML
    private TableColumn<Client, String> CLMENUnameCol;
    
    @FXML
    private TableColumn<Client, String> CLMENUlastNAmesCol;

    @FXML
    private TableColumn<Client, String> CLMENUidCol;

    @FXML
    private TableColumn<Client, String> CLMENUaddressCol;

    @FXML
    private TableColumn<Client, String> CLMENUphoneNumberCol;

    @FXML
    private TableColumn<Client, String> CLMENUfootnoteCol;
    
    @FXML
    private TableView<Type> TYPEMENUtable;
        
    @FXML
    private TableColumn<Type, String> TYPEMANnameCol;

    @FXML
    private Button TYPEMENUaddBttn;

    @FXML
    private Button TYPEMENUeditBttn;

    @FXML
    private Button TYPEMENUdeleteBttn;

    @FXML
    private Button TYPEMENUdisableBttn;

    @FXML
    private Button TYPEMENUbackBttn;
    
    @FXML
    private TableView<Ingredient> INGRMENUtable;

    @FXML
    private TableColumn<Ingredient, String> INGRMANnameCol;

    @FXML
    private Button INGRMENUaddBttn;

    @FXML
    private Button INGRMENUeditBttn;
    
    @FXML
    private TableView<Product> PRODUCTMENUtable;
    
    @FXML
    private TableColumn<Product, String> PRODUCTMANnameCol;

    @FXML
    private TableColumn<Product, String> PRODUCTMANsizeCol;

    @FXML
    private TableColumn<Product, String> PRODUCTMANpriceCol;

    @FXML
    private TableColumn<Product, String> PRODUCTMANamountCol;

    @FXML
    private TableColumn<Product, String> PRODUCTMANingredientCol;

    @FXML
    private TableColumn<Product, String> PRODUCTMANtypeCol;
    
    @FXML
    private TextField EDITUSERusernameTxtField;

    @FXML
    private TextField EDITUSERpasswordTxtField;

    @FXML
    private TextField EDITUSERnamesTxtField;

    @FXML
    private TextField EDITUSERlastNamesTxtFIled;

    @FXML
    private TextField EDITUSERidTxtField;
    
    private User localUser;
    
    private Restaurant restaurant;
    
    private Stage mainStage;
    
    private Stage popupStage;
    
    public RestaurantManagerGUI(Restaurant restaurant) {
    	this.restaurant = restaurant;
    	try {
			restaurant.loadData();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }
    
    public void showLogin() throws IOException{
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	Scene E = new Scene(addLogin);
    	mainStage.setScene(E);

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
	    	
	    	String username = SIGNINusernameTxtField.getText();
	    	String password = SIGNINpassTxtField.getText();
	    	String names = SIGNINfirstNamesTxtField.getText();
	    	String lastNames = SIGNINlastNamesTxtField.getText();
	    	String ID = SIGNINidTxtField.getText();
	    	int amountOrder = 0;
	    	
	    	restaurant.addUser(username, password, names, lastNames, ID, amountOrder);
	    	restaurant.saveData();
	    	SIGNINpassTxtField.setText("");
	    	SIGNINusernameTxtField.setText("");
	    	SIGNINfirstNamesTxtField.setText("");
	    	SIGNINlastNamesTxtField.setText("");
	    	SIGNINidTxtField.setText("");
	    	
	    	Alert alert= new Alert(AlertType.INFORMATION);
	    	alert.setTitle("User created");
			alert.setContentText("The user was created succesfuly.");
			alert.show();
	    	
			showLogin();

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
    		boolean found = false;
    		for (int i = 0; i < usersAux.size() && !false; i++) {
    			if(username.equalsIgnoreCase(usersAux.get(i).getUsername()) && password.equals(usersAux.get(i).getPassword())) {
    				localUser=usersAux.get(i);
    				found = true;
    			}
    		}
    		if(found) {
    			goToMain();
    		}
    		else{
    			alertWarnings.setTitle("Problems with the given infomation!");
				alertWarnings.setHeaderText("The username or the password is wrong");
				alertWarnings.setContentText("The username or the password you wrote is wrong");
				alertWarnings.show();
    		}
		}
		
		else{
			alertWarnings.setTitle("PROBLEMS");
			alertWarnings.setHeaderText("The information has not been completed or there is not created users");
			alertWarnings.setContentText("You have not filled all the fields for the information. Please, do it.");
			alertWarnings.show();
			
		}
    }

    public void goToMain() throws IOException{
    	FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
    	mainLoader.setController(this);
    	Parent addMain = mainLoader.load();
    	Scene E = new Scene(addMain);
    	mainStage.setScene(E);
    	MAINlocalUserLabel.setText(localUser.getUsername());
    	FXMLLoader mP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	mP.setController(this);
    	Parent addMainPane = mP.load();
    	MAINmainPane.getChildren().setAll(addMainPane);
    }
    

    @FXML
    public void MAINopenCLMENU(ActionEvent event) throws IOException {
    	FXMLLoader clLoader = new FXMLLoader(getClass().getResource("ClientsManager.fxml"));
    	clLoader.setController(this);
    	Parent addMain = clLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	CLinitializeTableView();
    }
    
    public void CLinitializeTableView() {
    	ObservableList<Client> observableList;
    	observableList = FXCollections.observableArrayList(restaurant.getClients());
    	
		CLMENUnameCol.setCellValueFactory(new PropertyValueFactory<Client,String>("name")); 
		CLMENUlastNAmesCol.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName"));
		CLMENUidCol.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
		CLMENUphoneNumberCol.setCellValueFactory(new PropertyValueFactory<Client,String>("phoneNumber"));
		CLMENUaddressCol.setCellValueFactory(new PropertyValueFactory<Client,String>("address"));
		CLMENUfootnoteCol.setCellValueFactory(new PropertyValueFactory<Client,String>("footNote"));
		CLMENUtable.setItems(observableList);
    }

    @FXML
    public void MAINopenEMPMENU(ActionEvent event) throws IOException {
    	FXMLLoader empLoader = new FXMLLoader(getClass().getResource("EmployeeManager.fxml"));
    	empLoader.setController(this);
    	Parent addMain = empLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	EMPinitializeTableView();
    	
    }
    
    public void EMPinitializeTableView() {
    	ObservableList<Employee> EMPobservableList;
    	EMPobservableList = FXCollections.observableArrayList(restaurant.getEmployees());
    	
    	EMPMENUnamesCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("names"));
    	EMPMENUnamesCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastNames"));
    	EMPMENUnamesCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
    	EMPMENUnamesCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("amountOrder"));
    	EMPMENUnamesCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("status"));
    	EMPMENUtable.setItems(EMPobservableList);
    	
    }

    @FXML
    public void MAINopenUSERMENU(ActionEvent event) throws IOException {
    	FXMLLoader usrLoader = new FXMLLoader(getClass().getResource("UserManager.fxml"));
    	usrLoader.setController(this);
    	Parent addMain = usrLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	USERinitializeTableView();
    	restaurant.saveData();
    }
    
    public void USERinitializeTableView() {
    	ObservableList<User> USRobservableList;
    	USRobservableList = FXCollections.observableArrayList(restaurant.getUsers());
    	
    	USERMANusernameCol.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
    	USERMANnamesCol.setCellValueFactory(new PropertyValueFactory<User,String>("names"));
    	USERMANlastNamesCol.setCellValueFactory(new PropertyValueFactory<User,String>("lastNames"));
    	USERMANidCol.setCellValueFactory(new PropertyValueFactory<User,String>("id"));
    	USERMENUtable.setItems(USRobservableList);
    	
    }
    
    @FXML
    void MAINopenREPORT(ActionEvent event) {
    	
    }
    

    @FXML
    void MAINopenORDERMANAGER(ActionEvent event) {

    }
    
    public void ORDERinitializeTableView() {
    	
    }

    @FXML
    public void MAINopenINGR(ActionEvent event) throws IOException {
    	FXMLLoader ingrLoader = new FXMLLoader(getClass().getResource("IngredientManager.fxml"));
    	ingrLoader.setController(this);
    	Parent addMain = ingrLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	INGRinitializeTableView();
    }
    
    public void INGRinitializeTableView() {
    	ObservableList<Ingredient> INGRobservableList;
    	INGRobservableList = FXCollections.observableArrayList(restaurant.getIngredients());
    	
    	INGRMANnameCol.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
    	INGRMENUtable.setItems(INGRobservableList);
    	
    }
    
    @FXML
    public void INGRMENUaddBttn(ActionEvent event) {

    }
    
    @FXML
    public void INGRMENUeditBttn(ActionEvent event) {

    }
    
    @FXML
    public void INGRMENUbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    public void INGRMENUdeleteBttn(ActionEvent event) {

    }

    @FXML
    public void INGRMENUdisableBttn(ActionEvent event) {

    }

    @FXML
    public void INGRMENUselectedIngr(MouseEvent event) {

    }    
    
    @FXML
    public void MAINopenPRODUCTS(ActionEvent event) throws IOException {
    	FXMLLoader productLoader = new FXMLLoader(getClass().getResource("ProductManager.fxml"));
    	productLoader.setController(this);
    	Parent addMain = productLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	PRODUCTinitializeTableView();
    }
    
    public void PRODUCTinitializeTableView() {
    	ObservableList<Product> PRODUCTobservableList;
    	PRODUCTobservableList = FXCollections.observableArrayList(restaurant.getProducts());
    	
    	PRODUCTMANnameCol.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
    	PRODUCTMANsizeCol.setCellValueFactory(new PropertyValueFactory<Product,String>("size"));
    	PRODUCTMANpriceCol.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));
    	PRODUCTMANamountCol.setCellValueFactory(new PropertyValueFactory<Product,String>("amountOrdered"));
    	PRODUCTMANingredientCol.setCellValueFactory(new PropertyValueFactory<Product,String>("ingredients"));
    	PRODUCTMANtypeCol.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
    	PRODUCTMENUtable.setItems(PRODUCTobservableList);
    	
    }
    
    @FXML
    public void PRODUCTMENUaddBttn(ActionEvent event) {

    }

    @FXML
    public void PRODUCTMENUbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    }

    @FXML
    public void PRODUCTMENUdeleteBttn(ActionEvent event) {

    }

    @FXML
    public void PRODUCTMENUdisableBttn(ActionEvent event) {

    }

    @FXML
    public void PRODUCTMENUeditBttn(ActionEvent event) {

    }

    @FXML
    public void MAINopenTYPES(ActionEvent event) throws IOException {
    	FXMLLoader typsLoader = new FXMLLoader(getClass().getResource("TypeManager.fxml"));
    	typsLoader.setController(this);
    	Parent addMain = typsLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	TYPEinitializeTableView();
    }
 
    public void TYPEinitializeTableView() {
    	ObservableList<Type> TYPEobservableList;
    	TYPEobservableList = FXCollections.observableArrayList(restaurant.getTypes());
    	
    	TYPEMANnameCol.setCellValueFactory(new PropertyValueFactory<Type,String>("name"));
    	TYPEMENUtable.setItems(TYPEobservableList);
    	
    }
    
    @FXML
    public void TYPEMENUaddBttn(ActionEvent event) {

    }

    @FXML
    public void TYPEMENUbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    }

    @FXML
    public void TYPEMENUdeleteBttn(ActionEvent event) {

    }

    @FXML
    public void TYPEMENUdisableBttn(ActionEvent event) {

    }

    @FXML
    public void TYPEMENUeditBttn(ActionEvent event) {

    }
    
    @FXML
    public void MAINlogout(ActionEvent event) throws IOException{
    	showLogin();
    
    }
    
    
    @FXML
    public void EMPMENUaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEmployeeWindow.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	popupStage = new Stage();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	popupStage.show();
    	popupStage.setResizable(false);
    	mainStage.hide();
    }

    @FXML
    public void EMPMENUdbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    public void EMPMENUdeleteBttn(ActionEvent event) {
    	Employee auxEmployee = EMPMENUtable.getSelectionModel().getSelectedItem();
    	if(auxEmployee != null) {
    		if(auxEmployee.getNames().equals(localUser.getNames())) {
    			Alert alertWarnings = new Alert(AlertType.WARNING);
    	    	alertWarnings.setTitle("Error");
    			alertWarnings.setHeaderText("You selected a local user");
    			alertWarnings.setContentText("You can't delete a user that is using the program right now.");
    			alertWarnings.show();
    		}
    		else {
    			boolean leave = false;
        		for(int i=0;i<restaurant.getEmployees().size() && !leave;i++) {
        			if(restaurant.getEmployees().get(i).getNames().equals(auxEmployee.getNames())) {
        				restaurant.deleteEmployee(i);
        				leave = true;
        			}
        		}
        		EMPMENUtable.refresh();
    		}
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("No user selected");
			alertWarnings.setHeaderText("You haven't selected a user to delete.");
			alertWarnings.setContentText("Please select a user to use the delete button.");
			alertWarnings.show();
    	}
    }

    @FXML
    public void EMPMENUdisableBttn(ActionEvent event) {
    	Employee auxEmployee = EMPMENUtable.getSelectionModel().getSelectedItem();
    	if(auxEmployee != null) {
    		if(auxEmployee.getNames().equals(localUser.getNames())) {
    			Alert alertWarnings = new Alert(AlertType.WARNING);
    	    	alertWarnings.setTitle("Error");
    			alertWarnings.setHeaderText("You selected a local user");
    			alertWarnings.setContentText("You can't disable a user that is using the program right now.");
    			alertWarnings.show();
    		}
    		else {
    			boolean leave = false;
        		for(int i=0;i<restaurant.getEmployees().size() && !leave;i++) {
        			if(restaurant.getEmployees().get(i).getNames().equals(auxEmployee.getNames())) {
        				restaurant.disableEmployee(i);
        				leave = true;
        			}
        		}
        		EMPMENUtable.refresh();
    		}
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("No user selected");
			alertWarnings.setHeaderText("You haven't selected a user to disable.");
			alertWarnings.setContentText("Please select a user to use the delete button.");
			alertWarnings.show();
    	}
    }

    @FXML
    public void EMPMENUeditBttn(ActionEvent event) {

    }

    @FXML
    public void ADDEMPaddBttn(ActionEvent event) {
    	String names = ADDEMPnamesTxtField.getText();
    	String lastNames = ADDEMPlastNamesTxtField.getText();
    	String id = ADDEMPidTxtField.getText();


    	boolean idIsAllNumber = true;
    	boolean repeatedId = false;
    	for(int i=0; i<id.length();i++) {
    		if(id.charAt(i) > 57 || id.charAt(i) < 48) {
    			idIsAllNumber = false;
    		}
    	}
    	if(names.isEmpty()) {
    		ADDEMPstatusLabel.setText("There are fields empty");
    		ADDEMPstatusLabel.setVisible(true);
    	}
    	else {
    		if(lastNames.isEmpty()) {
    			ADDEMPstatusLabel.setText("There are fields empty");
    			ADDEMPstatusLabel.setVisible(true);
    		}
    		else {
    			if(idIsAllNumber && !id.isEmpty()) {
    				
    				for(int i=0;i<restaurant.getEmployees().size();i++) {
    					if(restaurant.getEmployees().get(i).getId().equals(id)) {
    						repeatedId = true;
    					}
    				}
    				if(!repeatedId) {
    					
    					restaurant.addEmployee(names, lastNames, id, 0);
    					ADDEMPstatusLabel.setText("Added new employee succesfully");
    	    			ADDEMPstatusLabel.setVisible(true);
    	    			ADDEMPidTxtField.setText("");
    	    			ADDEMPlastNamesTxtField.setText("");
    	    			ADDEMPnamesTxtField.setText("");
    	    			
    				}
    				else {
    					ADDEMPstatusLabel.setText("There is already a user with that ID");
    	    			ADDEMPstatusLabel.setVisible(true);
    				}
    			}
    			else {
    				ADDEMPstatusLabel.setText("Please type numbers only in the ID field");
        			ADDEMPstatusLabel.setVisible(true);
    			}
    		}
    	}

    }


    @FXML
    public void ADDEMPbackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }

    @FXML
    public void USERMENUaddBttn(ActionEvent event) {
    	
    }

    @FXML
    public void USERMENUbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    public void USERMENUdeleteBttn(ActionEvent event) {
    	int index = USERMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteUser(index);
    	USERMENUtable.refresh();
    }

    @FXML
    public void USERMENUdisableBttn(ActionEvent event) {

    }

    @FXML
    public void USERMENUeditBttn(ActionEvent event) {
    	User auxEmployee = USERMENUtable.getSelectionModel().getSelectedItem();
    	
    }
    
    @FXML
    public void ADDUSERaddBttn(ActionEvent event) {
    	
    }

    @FXML
    public void ADDUSERbackBttn(ActionEvent event) {
    	
    }
    
    @FXML
    void USERselectedUser(MouseEvent event) throws IOException {
    	if(event.getClickCount() == 2) {
    		User auxUser = USERMENUtable.getSelectionModel().getSelectedItem();
    		if(auxUser.getUsername().equals(localUser.getUsername())) {
    			Alert alertWarnings = new Alert(AlertType.WARNING);
    	    	alertWarnings.setTitle("Error");
    			alertWarnings.setHeaderText("You selected a local user");
    			alertWarnings.setContentText("You can't edit a user that is using the program right now.");
    			alertWarnings.show();
    		}
    		else {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditUserWindow.fxml"));
    			loader.setController(this);
    			Parent root = loader.load();
    			Scene e = new Scene(root);
    			popupStage = new Stage();
    			popupStage.setScene(e);
    			EDITUSERusernameTxtField.setText(auxUser.getUsername());
    			EDITUSERpasswordTxtField.setText(auxUser.getPassword());
    			EDITUSERnamesTxtField.setText(auxUser.getNames());
    			EDITUSERlastNamesTxtFIled.setText(auxUser.getLastNames());
    			String x = auxUser.getId() + "";
    			EDITUSERidTxtField.setText(x);
    			popupStage.show();
    			popupStage.setResizable(false);
    			mainStage.hide();
    		}
    	}
    }
    
    @FXML
    void EDITUSERcancelBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }

    @FXML
    void EDITUSERdoneBttn(ActionEvent event) throws IOException {
    	int index = USERMENUtable.getSelectionModel().getSelectedIndex();
    	int x = USERMENUtable.getSelectionModel().getSelectedItem().getAmountOrder();
    	String newUsername = EDITUSERusernameTxtField.getText();
    	String newPass = EDITUSERpasswordTxtField.getText();
    	String newNames = EDITUSERnamesTxtField.getText();
    	String lastNames = EDITUSERlastNamesTxtFIled.getText();
    	String id = EDITUSERidTxtField.getText();
    	restaurant.updateUser(index, newUsername, newPass, newNames, lastNames, id, x);
    	popupStage.close();
    	mainStage.show();
    	USERMENUtable.refresh();
    	restaurant.saveData();
    }

    @FXML
    public void CLMENUaddBttn(ActionEvent event) {

    }
    
    

    @FXML
    public void CLMENUbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    public void CLMENUdeletBttn(ActionEvent event) {

    }

    @FXML
    public void CLMENUdisableBttn(ActionEvent event) {

    }

    @FXML
    public void CLMENUeditBttn(ActionEvent event) {

    }

    @FXML
    public void CLMENUselectedClient(MouseEvent event) {

    }
    
    @FXML
    public void TYPEMENUselectedType(MouseEvent event) {

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
    	restaurant.saveData();
	}
  
}
