package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.BaseProduct;
import model.Client;
import model.DateClass;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.Product;
import model.Restaurant;
import model.Size;
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
    private TableView<BaseProduct> BASEPRODUCTMENUtable;
    
    @FXML
    private TableColumn<BaseProduct, String> BASEPRODUCTMANnameCol;

    @FXML
    private TableColumn<BaseProduct, String> BASEPRODUCTMANingredientCol;

    @FXML
    private TableColumn<BaseProduct, String> BASEPRODUCTMANtypeCol;
    
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

    @FXML
    private TableView<Order> ORDERMANtable;

    @FXML
    private TableColumn<Order, Integer> ORDERMANcodeCol;

    @FXML
    private TableColumn<Order, String> ORDERMANstatusCol;

    @FXML
    private TableColumn<Order, String> ORDERMANfootnoteCol;

    @FXML
    private TableColumn<Order, String> ORDERMANdateCol;

    @FXML
    private TableColumn<Order, String> ORDERMANclientCol;

    @FXML
    private TableColumn<Order, String> ORDERMANempCol;

    @FXML
    private TableView<Product> PROMANtable;

    @FXML
    private TableColumn<Product, String> PROMANnameCol;

    @FXML
    private TableColumn<Product, Double> PROMANpriceCol;

    @FXML
    private TableColumn<Product, String> PROMANsizeCol;

    @FXML
    private TableColumn<Product, String> PROMANbaseProcol;
    
    @FXML
    private TextField ADDPROnameTxtField;

    @FXML
    private TextField ADDPROpriceTxtField;
    
    @FXML
    private TextField ADDINGnameTxtField;

    @FXML
    private ComboBox<Size> ADDPROsizeCB;

    @FXML
    private ComboBox<BaseProduct> ADDPRObaseProCB;
    
    @FXML
    private TextField EDITINGnameTxtField;
    
    @FXML
    private TextField EMPREPORTfromTxtFIeld;

    @FXML
    private TextField EMPREPORTtoTxtField;
    
    @FXML
    private TextField ORDERREPORTfromTxtFIeld;

    @FXML
    private TextField ORDERREPORTtoTxtField;
    
    @FXML
    private TextField PROREPORTfromTxtFIeld;

    @FXML
    private TextField PROREPORTtoTxtField;
    
    @FXML
    private TextField ADDBASEPROnameTxtField;

    @FXML
    private ComboBox<Type> ADDBASEPROtypeCB;

    @FXML
    private ComboBox<Ingredient> ADDBASEPROingredientCB;

    @FXML
    private TableView<Ingredient> ADDBASEPROingTable;
    
    @FXML
    private TableColumn<Ingredient, String> ADDBASEPROingCol;
    
    @FXML
    private TextField EDITBASEPROnameTxtField;

    @FXML
    private ComboBox<Type> EDITBASEPROtypeCB;

    @FXML
    private ComboBox<Ingredient> EDITBASEPROingredientCB;

    @FXML
    private TableView<Ingredient> EDITBASEPROingTable;

    @FXML
    private TableColumn<Ingredient, String> EDITBASEPROingCol;
    
    @FXML
    private TextField ADDTYPEnameTxtField;
    
    @FXML
    private TextField EDITTYPEnameTxtField;
    
    @FXML
    private TextField EDITEMPnamesTxtField;

    @FXML
    private TextField EDITEMPlastNamesTxtField;

    @FXML
    private TextField EDITEMPidTxtField;
    
    @FXML
    private TextField ADDCLnameTxtField;

    @FXML
    private TextField ADDCLlastNameTxtFIeld;

    @FXML
    private TextField ADDCLidTxtField;

    @FXML
    private TextField ADDCLaddressTxtField;

    @FXML
    private TextField ADDCLphoneTxtField;

    @FXML
    private TextArea ADDCLfootnoteTxt;
    
    @FXML
    private TextField EDITCLnameTxtField;

    @FXML
    private TextField EDITCLlastNameTxtFIeld;

    @FXML
    private TextField EDITCLidTxtField;

    @FXML
    private TextField EDITCLaddressTxtField;

    @FXML
    private TextField EDITCLphoneTxtField;

    @FXML
    private TextArea EDITCLfootnoteTxt;
    
    @FXML
    private ComboBox<Client> ADDORDclientCB;

    @FXML
    private ComboBox<Product> ADDORDproductCB;

    @FXML
    private TextField ADDORDquantityTXtField;

    @FXML
    private ComboBox<Employee> ADDORDdeliverEmployee;

    @FXML
    private Label ADDORDdateLabel;

    @FXML
    private Label ADDORDcodeLabel;

    @FXML
    private TableView<Product> ADDORDproductsTable;

    @FXML
    private TableColumn<Product, String> ADDORDproductsCol;

    @FXML
    private TableView<Integer> ADDORDquantityTable;

    @FXML
    private TableColumn<Integer, Integer> ADDORDquantityCol;
    
    private ArrayList<Product> ADDORDproList;
    
    private ArrayList<Integer> ADDORDquantityList;
    
    private ArrayList<Ingredient> ADDBASEPROlist;
    
    @FXML
    private ComboBox<Client> EDITORDclientCB;

    @FXML
    private ComboBox<Product> EDITORDproductCB;

    @FXML
    private TextField EDITORDquantityTXtField;

    @FXML
    private ComboBox<Employee> EDITORDdeliverEmployeeCB;

    @FXML
    private Label EDITORDdateLabel;

    @FXML
    private Label EDITORDcodeLabel;
    
    @FXML
    private TextField EDITORDstatusTxt;
    
    @FXML
    private TableView<Product> EDITORDproductsTable;

    @FXML
    private TableColumn<Product, String> EDITORDproductsCol;

    @FXML
    private TableView<Integer> EDITORDquantityTable;

    @FXML
    private TableColumn<Integer, Integer> EDITORDquantityCol;
    
    private ArrayList<Product> EDITORDproList;
    
    private ArrayList<Integer> EDITORDquantityList;

    @FXML
    private TextField SEARCHCLnameTxtField;

    @FXML
    private TableView<Client> SEARCHCLtableView;

    @FXML
    private TableColumn<Client, String> SEARCHCLnamesCol;

    @FXML
    private TableColumn<Client, String> SEARCHCLlastnamesCol;

    @FXML
    private TableColumn<Client, String> SEARCHCLidCol;

    @FXML
    private TableColumn<Client, String> SEARCHCLaddressCol;

    @FXML
    private TableColumn<Client, String> SEARCHCLphonenumberCol;

    @FXML
    private TableColumn<Client, String> SEARCHCLfootnoteCol;
    
    private ArrayList<Client> SEARCHCLclientsList;
    
    private User localUser;
    
    private Restaurant restaurant;
    
    private Stage mainStage;
    
    private Stage popupStage;
    
    public RestaurantManagerGUI(Restaurant restaurant) {
    	this.restaurant = restaurant;
    	try {
			restaurant.loadData();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
    	ADDBASEPROlist = new ArrayList<>();
    	ADDORDproList = new ArrayList<Product>();
    	ADDORDquantityList = new ArrayList<Integer>();
    	SEARCHCLclientsList = new ArrayList<Client>();
    	popupStage = new Stage();
    }
    
    public void showLogin() throws IOException{
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	Scene E = new Scene(addLogin);
    	mainStage.setScene(E);
    	restaurant.saveData();

    }
    
    public void goToLogin(ActionEvent event) throws IOException {
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	Scene E = new Scene(addLogin);
    	mainStage.setScene(E);
    	restaurant.saveData();
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

	    	
	    	restaurant.addUser(username, password, names, lastNames, ID);
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
			restaurant.saveData();
	    }
	    
	    else {
	    	Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Complete the information!");
			alertWarnings.setHeaderText("The information has not been completed.");
			alertWarnings.setContentText("You have not filled all the fields for the information. Please, do it.");
			alertWarnings.show();
			restaurant.saveData();
	    }
    	
    	
    	
    }
    
    @FXML
    public void goToSignin(ActionEvent event) throws IOException{
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Signin.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	
    	Scene e = new Scene(root);
    	
    	mainStage.setScene(e);
    	
    	restaurant.saveData();
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
    	restaurant.saveData();
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
    	restaurant.saveData();
    }
    

    @FXML
    public void MAINopenCLMENU(ActionEvent event) throws IOException {
    	FXMLLoader clLoader = new FXMLLoader(getClass().getResource("ClientsManager.fxml"));
    	clLoader.setController(this);
    	Parent addMain = clLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	CLinitializeTableView();
    	restaurant.saveData();
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
    	restaurant.saveData();
    }
    
    public void EMPinitializeTableView() {
    	ObservableList<Employee> EMPobservableList;
    	EMPobservableList = FXCollections.observableArrayList(restaurant.getEmployees());
    	
    	EMPMENUnamesCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("names"));
    	EMPMENUlastNamesCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastNames"));
    	EMPMENUidCol.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
    	EMPMENUdelivOrdCol.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("amountOrder"));
    	EMPMENUtable.setItems(EMPobservableList);
  
    }

    @FXML
    public void MAINopenUSERMENU(ActionEvent event) throws IOException {
    	FXMLLoader usrLoader = new FXMLLoader(getClass().getResource("UserManager.fxml"));
    	usrLoader.setController(this);
    	Parent addMain = usrLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	restaurant.saveData();
    	USERinitializeTableView();
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
    public void MAINopenREPORTEMP(ActionEvent event) throws IOException {
    	FXMLLoader usrLoader = new FXMLLoader(getClass().getResource("EmplooyeReport.fxml"));
    	usrLoader.setController(this);
    	Parent addMain = usrLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now);
    	EMPREPORTfromTxtFIeld.setText("00:00-"+date);
    	EMPREPORTtoTxtField.setText("23:59-"+date);
    	restaurant.saveData();
    }
    
    @FXML
    public void EMPREPORTbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	restaurant.saveData();
    }

    @FXML
    public void EMPREPORTgenerateReport(ActionEvent event) throws FileNotFoundException {
    	String from = EMPREPORTfromTxtFIeld.getText();
    	String to = EMPREPORTtoTxtField.getText();
    	if(from.equals("") || to.equals("")) {
    		String[] parts1 = from.split("-");
    		String[] parts2 = to.split("-");
    		ArrayList<Employee> reportEmp = restaurant.generateReport(parts1,parts2);
    		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    		FileChooser fc = new FileChooser();
    		fc.getExtensionFilters().add(extFilter);
        	File f = fc.showSaveDialog(mainStage);
        	restaurant.exportData(f, reportEmp);
        	EMPREPORTfromTxtFIeld.setText("");
			EMPREPORTtoTxtField.setText("");
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Wrong input");
			alertWarnings.setContentText("Please type a correct time and date.");
			alertWarnings.show();
			EMPREPORTfromTxtFIeld.setText("");
			EMPREPORTtoTxtField.setText("");
    	}
    	
    }
    
    @FXML
    public void MAINopenREPORTORDER(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("OrderReport.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	MAINmainPane.getChildren().setAll(root);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now);
    	ORDERREPORTfromTxtFIeld.setText("00:00-"+date);
    	ORDERREPORTtoTxtField.setText("29:59-"+date);
    	restaurant.saveData();
    }
    
    @FXML
    public void ORDERREPORTbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	MAINmainPane.getChildren().setAll(root);
    	restaurant.saveData();
    }

    @FXML
    public void ORDERREPORTgenerateReport(ActionEvent event) throws FileNotFoundException {
    	String from = ORDERREPORTfromTxtFIeld.getText();
    	String to = ORDERREPORTtoTxtField.getText();
    	if(from.equals("") || to.equals("")) {
    		String[] parts1 = from.split("-");
    		String[] parts2 = to.split("-");
    		ArrayList<Order> reportOrd = restaurant.generateOrderReport(parts1,parts2);
    		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    		FileChooser fc = new FileChooser();
    		fc.getExtensionFilters().add(extFilter);
        	File f = fc.showSaveDialog(mainStage);
        	restaurant.exportOrderData(f, reportOrd);
        	ORDERREPORTfromTxtFIeld.setText("");
        	ORDERREPORTtoTxtField.setText("");
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Wrong input");
			alertWarnings.setContentText("Please type a correct time and date.");
			alertWarnings.show();
			ORDERREPORTfromTxtFIeld.setText("");
        	ORDERREPORTtoTxtField.setText("");
    	}
    }
    
    @FXML
    public void MAINopenREPORTPRO(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("ProductsReport.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	MAINmainPane.getChildren().setAll(root);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now);
    	ORDERREPORTfromTxtFIeld.setText("00:00-"+date);
    	ORDERREPORTtoTxtField.setText("29:59-"+date);
    	restaurant.saveData();
    }
    
    @FXML
    public void PROREPORTbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	MAINmainPane.getChildren().setAll(root);
    	restaurant.saveData();
    }

    @FXML
    public void PROREPORTgenerateReport(ActionEvent event) throws FileNotFoundException {
    	String from = PROREPORTfromTxtFIeld.getText();
    	String to = PROREPORTtoTxtField.getText();
    	if(from.equals("") || to.equals("")) {
    		String[] parts1 = from.split("-");
    		String[] parts2 = to.split("-");
    		ArrayList<Product> reportPro = restaurant.generateProductsReport(parts1,parts2);
    		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    		FileChooser fc = new FileChooser();
    		fc.getExtensionFilters().add(extFilter);
        	File f = fc.showSaveDialog(mainStage);
        	restaurant.exportProductsData(f, reportPro);
        	PROREPORTfromTxtFIeld.setText("");
        	PROREPORTtoTxtField.setText("");
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Wrong input");
			alertWarnings.setContentText("Please type a correct time and date.");
			alertWarnings.show();
			PROREPORTfromTxtFIeld.setText("");
        	PROREPORTtoTxtField.setText("");
    	}
    }
    

    @FXML
    public void MAINopenORDERMANAGER(ActionEvent event) throws IOException {
    	FXMLLoader orderLoader = new FXMLLoader(getClass().getResource("OrderManager.fxml"));
    	orderLoader.setController(this);
    	Parent addMain = orderLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	ORDERinitializeTableView();
    	restaurant.saveData();
    }
    
    public void ORDERinitializeTableView() {
    	ObservableList<Order> USRobservableList;
    	USRobservableList = FXCollections.observableArrayList(restaurant.getOrders());
    	
    	ORDERMANcodeCol.setCellValueFactory(new PropertyValueFactory<Order,Integer>("username"));
    	ORDERMANstatusCol.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
    	ORDERMANfootnoteCol.setCellValueFactory(new PropertyValueFactory<Order,String>("footnote"));
    	ORDERMANdateCol.setCellValueFactory(new PropertyValueFactory<Order,String>("stringTime"));
    	ORDERMANclientCol.setCellValueFactory(new PropertyValueFactory<Order,String>("stringClient"));
    	ORDERMANempCol.setCellValueFactory(new PropertyValueFactory<Order,String>("stringEmployee"));
    	ORDERMANstatusCol.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
    	ORDERMANtable.setItems(USRobservableList);
    }
    

    @FXML
    public void MAINopenPRODUCTS(ActionEvent event) throws IOException {
    	FXMLLoader proLoader = new FXMLLoader(getClass().getResource("ProductManager.fxml"));
    	proLoader.setController(this);
    	Parent addMain = proLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	PROMANinitializeTable();
    	restaurant.saveData();
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
    public void INGRMENUaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader x = new FXMLLoader(getClass().getResource("AddIngredientWindow.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	popupStage.show();
    	mainStage.hide();
    	restaurant.saveData();
    }
    
    @FXML
    void ADDINGaddBttn(ActionEvent event) throws IOException {
    	if(!ADDINGnameTxtField.getText().equals("")) {
    		boolean found = false;
        	for(int i=0;i<restaurant.getIngredients().size() && !found;i++) {
        		if(ADDINGnameTxtField.getText().equals(restaurant.getIngredients().get(i).getName())) {
        			found = true;
        		}
        	}
        	if(!found) {
        		restaurant.addIngredient(ADDINGnameTxtField.getText());
        		popupStage.close();
            	mainStage.show();
            	INGRinitializeTableView();
        	}
        	else {
        		Alert alertWarnings = new Alert(AlertType.WARNING);
    	    	alertWarnings.setTitle("Error");
    			alertWarnings.setHeaderText("Repeated ingredient");
    			alertWarnings.setContentText("There is already a ingredient with that name.");
    			alertWarnings.show();
        	}
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Empty field");
			alertWarnings.setContentText("Please fill all the fields.");
			alertWarnings.show();
    	}
    	restaurant.saveData();
    }

    @FXML
    void ADDINGcancelBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }
    
    
    @FXML
    public void INGRMENUbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    public void INGRMENUdeleteBttn(ActionEvent event) throws IOException {
    	int index = INGRMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteIngredient(index);
    	INGRinitializeTableView();
    	restaurant.saveData();
    }

    @FXML
    public void INGRMENUdisableBttn(ActionEvent event) {
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @FXML
    public void INGRMENUselectedIngr(MouseEvent event) throws IOException {
    	Ingredient auxIng = INGRMENUtable.getSelectionModel().getSelectedItem();
    	if(event.getClickCount() == 2) {
    		FXMLLoader x = new FXMLLoader(getClass().getResource("EditIngredientWindow.fxml"));
    		x.setController(this);
    		Parent root = x.load();
    		Scene e = new Scene(root);
    		popupStage.setScene(e);
    		mainStage.hide();
    		EDITINGnameTxtField.setText(auxIng.getName());
    		popupStage.show();
    	}
    	restaurant.saveData();
    }
    
    @FXML
    void EDITINGaddBttn(ActionEvent event) throws IOException {
    	int index = INGRMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.updateIngredient(index,EDITINGnameTxtField.getText());
    	popupStage.close();
    	mainStage.show();
    	INGRinitializeTableView();
    	restaurant.saveData();
    }

    @FXML
    void EDITINGcancelBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }
    
    @FXML
    public void MAINopenBASEPRODUCTS(ActionEvent event) throws IOException {
    	FXMLLoader productLoader = new FXMLLoader(getClass().getResource("BaseProductManager.fxml"));
    	productLoader.setController(this);
    	Parent addMain = productLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	BASEPRODUCTinitializeTableView();
    }
    
    public void BASEPRODUCTinitializeTableView() {

    	ObservableList<BaseProduct> BASEPRODUCTobservableList;
    	BASEPRODUCTobservableList = FXCollections.observableArrayList(restaurant.getBaseProducts());
    	
    	BASEPRODUCTMANnameCol.setCellValueFactory(new PropertyValueFactory<BaseProduct,String>("name"));
    	BASEPRODUCTMANingredientCol.setCellValueFactory(new PropertyValueFactory<BaseProduct,String>("ingredientsString"));
    	BASEPRODUCTMANtypeCol.setCellValueFactory(new PropertyValueFactory<BaseProduct,String>("typeString"));


    	BASEPRODUCTMENUtable.setItems(BASEPRODUCTobservableList);

    	
    }
    
    @FXML
    public void BASEPRODUCTMENUaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader xax = new FXMLLoader(getClass().getResource("AddBaseProductWindow.fxml"));
    	xax.setController(this);
    	Parent root = xax.load();
    	Scene e = new Scene(root);
    	popupStage = new Stage();
    	popupStage.setScene(e);
    	popupStage.show();
    	mainStage.hide();
    	ADDBASEPROlist.clear();
    	ADDBASEPROnameTxtField.setText("");
    	ADDBASEPROinitializeTableView();
    }
    
    public void ADDBASEPROinitializeTableView() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(ADDBASEPROlist);
    	
    	ADDBASEPROingCol.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
    	ADDBASEPROingTable.setItems(observableList);
    	ObservableList<Type> typeList = FXCollections.observableList(restaurant.getTypes());
    	ADDBASEPROtypeCB.itemsProperty().setValue(typeList);
    	convertTypeCB();
    	ObservableList<Ingredient> ingList = FXCollections.observableList(restaurant.getIngredients());
    	ADDBASEPROingredientCB.itemsProperty().setValue(ingList);
    	convertIngCB();
    }
    
    private void convertTypeCB() {
        ADDBASEPROtypeCB.setConverter(new StringConverter<Type>() {
            @Override
            public String toString(Type type) {
                return type.getName();
            }

            @Override
            public Type fromString(final String string) {
                return ADDBASEPROtypeCB.getItems().stream().filter(type -> type.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    private void convertIngCB() {
        ADDBASEPROingredientCB.setConverter(new StringConverter<Ingredient>() {
            @Override
            public String toString(Ingredient ing) {
                return ing.getName();
            }

            @Override
            public Ingredient fromString(final String string) {
                return ADDBASEPROingredientCB.getItems().stream().filter(ing -> ing.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    @FXML
    public void ADDBASEPROaddIngBttn(ActionEvent event) {
    	Ingredient selected = ADDBASEPROingredientCB.getSelectionModel().getSelectedItem();
    	ADDBASEPROlist.add(selected);
    	ADDBASEPROingredientCB.getSelectionModel().clearSelection();
    	ADDBASEPROingredientCB.setValue(null);
    	ObservableList<Ingredient> ingList = FXCollections.observableList(restaurant.getIngredients());
    	ADDBASEPROingredientCB.setItems(ingList);
    	ADDBASEPROinitializeTableView();
    	
    }

    @FXML
    void ADDBASEPRObackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }

    @FXML
    void ADDBASEPROdoneBttn(ActionEvent event) throws IOException {
    	if(ADDBASEPROnameTxtField.getText().equals("")) {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Missing fields");
			alertWarnings.setContentText("Please fill all the fields.");
			alertWarnings.show();
    	}
    	else {
    		if(ADDBASEPROtypeCB.getSelectionModel().getSelectedItem() == null) {
    			Alert alertWarnings = new Alert(AlertType.WARNING);
    	    	alertWarnings.setTitle("Error");
    			alertWarnings.setHeaderText("Missing fields");
    			alertWarnings.setContentText("Please fill all the fields.");
    			alertWarnings.show();
    		}
    		else {
    			if(ADDBASEPROlist.size()==0) {
    				Alert alertWarnings = new Alert(AlertType.WARNING);
        	    	alertWarnings.setTitle("Error");
        			alertWarnings.setHeaderText("Missing fields");
        			alertWarnings.setContentText("Please fill all the fields.");
        			alertWarnings.show();
    			}
    			else {
    				restaurant.addBaseProduct(ADDBASEPROnameTxtField.getText(), ADDBASEPROlist, ADDBASEPROtypeCB.getSelectionModel().getSelectedItem());
    				BASEPRODUCTinitializeTableView();
    				popupStage.close();
    		    	mainStage.show();
    			}
    		}
    	}
    	restaurant.saveData();
    }

    @FXML
    public void BASEPRODUCTMENUbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    }

    @FXML
    public void BASEPRODUCTMENUdeleteBttn(ActionEvent event) throws IOException {
    	if(BASEPRODUCTMENUtable.getSelectionModel().getSelectedItem()!=null) {
    		restaurant.deleteBaseProduct(BASEPRODUCTMENUtable.getSelectionModel().getSelectedIndex());
    		BASEPRODUCTinitializeTableView();
    	}
    	restaurant.saveData();
    }
    
    @FXML
    public void BASEPRODUCTMENUexportBttn(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.setTitle("Select the base products list");
    	File f = fc.showSaveDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Export base products");
    	
    	if(f!=null) {
    		try {
    			restaurant.exportBaseProducts(f.getAbsolutePath());
    			
    			a.setContentText("Base product data was exported succesfuly");
		    	a.show();
    			
    		} catch(IOException e) {
    			a.setContentText("Base product data wasn't exported succesfuly");
		    	a.show();
    		};
    	}
    }
    
    @FXML
    public void BASEPRODUCTMENUimportBttn(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.setTitle("Select the base products list");
    	File f = fc.showOpenDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Import base products");
    	
    	if(f!=null) {
    		try {
    			restaurant.importBaseProducts(f.getAbsolutePath());
    			
    			a.setContentText("Base product data was imported succesfuly");
		    	a.show();
    			
    		} catch(IOException e) {
    			a.setContentText("Base product data wasn't imported succesfuly");
		    	a.show();
    		};
    		
    		BASEPRODUCTinitializeTableView();
    	}
    }

    @FXML
    public void BASEPRODUCTselectedItem(MouseEvent event) throws IOException {
    	if(event.getClickCount() == 2 && BASEPRODUCTMENUtable.getSelectionModel().getSelectedItem()!=null) {
    		FXMLLoader x = new FXMLLoader(getClass().getResource("EditBaseProduct.fxml"));
    		x.setController(this);
    		Parent root = x.load();
    		Scene e = new Scene(root);
    		popupStage.setScene(e);
    		popupStage.show();
    		mainStage.hide();
    		EDITBASEPROinitializeTableView();
    		EDITBASEPROnameTxtField.setText(BASEPRODUCTMENUtable.getSelectionModel().getSelectedItem().getName());
        	EDITBASEPROtypeCB.setValue(BASEPRODUCTMENUtable.getSelectionModel().getSelectedItem().getType());
    		ADDBASEPROlist = (ArrayList<Ingredient>) BASEPRODUCTMENUtable.getSelectionModel().getSelectedItem().getIngredients();
    		
    	}
    }
    
    public void EDITBASEPROinitializeTableView() {
    	
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(ADDBASEPROlist);
    	
    	EDITBASEPROingCol.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
    	EDITBASEPROingTable.setItems(observableList);
    	ObservableList<Type> typeList = FXCollections.observableList(restaurant.getTypes());
    	EDITBASEPROtypeCB.itemsProperty().setValue(typeList);
    	convertEditTypeCB();
    	ObservableList<Ingredient> ingList = FXCollections.observableList(restaurant.getIngredients());
    	EDITBASEPROingredientCB.itemsProperty().setValue(ingList);
    	convertEditIngCB();
    }
    
    private void convertEditTypeCB() {
        EDITBASEPROtypeCB.setConverter(new StringConverter<Type>() {
            @Override
            public String toString(Type type) {
                return type.getName();
            }

            @Override
            public Type fromString(final String string) {
                return EDITBASEPROtypeCB.getItems().stream().filter(type -> type.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    private void convertEditIngCB() {
        EDITBASEPROingredientCB.setConverter(new StringConverter<Ingredient>() {
            @Override
            public String toString(Ingredient ing) {
                return ing.getName();
            }

            @Override
            public Ingredient fromString(final String string) {
                return EDITBASEPROingredientCB.getItems().stream().filter(ing -> ing.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    @FXML
    public void EDITBASEPROaddIngBttn(ActionEvent event) {
    	Ingredient selected = EDITBASEPROingredientCB.getSelectionModel().getSelectedItem();
    	ADDBASEPROlist.add(selected);
    	EDITBASEPROingredientCB.getSelectionModel().clearSelection();
    	EDITBASEPROingredientCB.setValue(null);
    	ObservableList<Ingredient> ingList = FXCollections.observableList(restaurant.getIngredients());
    	EDITBASEPROingredientCB.itemsProperty().setValue(ingList);
    	ADDBASEPROinitializeTableView();
    	convertEditIngCB();
    }

    @FXML
    public void EDITBASEPRObackBttn(ActionEvent event) {
    	ADDBASEPROlist.clear();
    	popupStage.hide();
    	mainStage.show();
    }

    @FXML
    public void EDITBASEPROdoneBttn(ActionEvent event) throws IOException {
    	int index = BASEPRODUCTMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.getBaseProducts().get(index).setIngredients(ADDBASEPROlist);
    	restaurant.getBaseProducts().get(index).setName(EDITBASEPROnameTxtField.getText());
    	restaurant.getBaseProducts().get(index).setType(EDITBASEPROtypeCB.getSelectionModel().getSelectedItem());
    	popupStage.hide();
    	mainStage.show();
    	BASEPRODUCTinitializeTableView();
    	restaurant.saveData();
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
    public void TYPEMENUaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader X = new FXMLLoader(getClass().getResource("AddTypeWindow.fxml"));
    	X.setController(this);
    	Parent root = X.load();
    	Scene e = new Scene(root);
    	popupStage = new Stage();
    	popupStage.setScene(e);
    	popupStage.show();
    	mainStage.hide();
    }
    
    @FXML
    public void TYPEMENUorderBttn(ActionEvent event) {
    	ArrayList<Type> aux = restaurant.getTypes();
    	
    	for (int i = 0; i < aux.size(); i++) {
			String minName = aux.get(i).getName();
			
			for(int j = i+1; j<aux.size(); j++) {
				if(aux.get(j).getName().compareToIgnoreCase(minName)<0) {
					String temp = aux.get(j).getName();
					aux.get(j).setName(minName);
					minName = temp;
					
				}
			}
			
			aux.get(i).setName(minName);
    	}
    	
    	restaurant.updateTypeList(aux);
    	
    	// Arreglar para que se vea ordenado apenas se le da al button.
    	
    	TYPEinitializeTableView();
    }
    
    @FXML
    void ADDTYPEaddBttn(ActionEvent event) throws IOException {
    	if(!ADDTYPEnameTxtField.getText().equals("")) {
    		String name = ADDTYPEnameTxtField.getText();
    		boolean found = false;
    		for(int i=0;i<restaurant.getTypes().size();i++) {
    			if(name.equals(restaurant.getTypes().get(i).getName())){
    				found = true;
    			}
    		}
    		if(!found) {
    			restaurant.addType(new Type(name));
    			popupStage.close();
    	    	mainStage.show();
    	    	TYPEinitializeTableView();
    		}
    		else {
    			Alert alertWarnings = new Alert(AlertType.WARNING);
    	    	alertWarnings.setTitle("Error");
    			alertWarnings.setHeaderText("Repeated name");
    			alertWarnings.setContentText("There is already a Type with that name.");
    			alertWarnings.show();
    			ADDTYPEnameTxtField.setText("");
    		}
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Empty name");
			alertWarnings.setContentText("Fill all the fields to add a type.");
			alertWarnings.show();
			ADDTYPEnameTxtField.setText("");
    	}
    	restaurant.saveData();
    }

    @FXML
    void ADDTYPEbackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }

    @FXML
    public void TYPEMENUbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    }

    @FXML
    public void TYPEMENUdeleteBttn(ActionEvent event) throws IOException {
    	if(TYPEMENUtable.getSelectionModel().getSelectedItem() != null) {
    		restaurant.deleteType(TYPEMENUtable.getSelectionModel().getSelectedIndex());
    		TYPEinitializeTableView();
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("No selected item");
			alertWarnings.setContentText("Select a item to delete.");
			alertWarnings.show();
    	}
    	restaurant.saveData();
    }

    @FXML
    public void TYPEMENUselectedType(MouseEvent event) throws IOException {
    	if(event.getClickCount()==2) {
        	FXMLLoader x = new FXMLLoader(getClass().getResource("EditTypeWindow.fxml"));
        	x.setController(this);
        	Parent root = x.load();
        	Scene e = new Scene(root);
        	popupStage.setScene(e);
        	EDITTYPEnameTxtField.setText(TYPEMENUtable.getSelectionModel().getSelectedItem().getName());
        	popupStage.show();
        	mainStage.hide();
    	}
    }
    
    @FXML
    void EDITTYPEaddBttn(ActionEvent event) throws IOException {
    	if(!EDITTYPEnameTxtField.getText().equals("")) {
    		restaurant.updateType(TYPEMENUtable.getSelectionModel().getSelectedIndex(),EDITTYPEnameTxtField.getText());
    		popupStage.close();
        	mainStage.show();
        	TYPEinitializeTableView();
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Empty name");
			alertWarnings.setContentText("Please fill all the fields.");
			alertWarnings.show();
    	}
    	restaurant.saveData();
    }

    @FXML
    void EDITTYPEbackBttn(ActionEvent event) {
    	popupStage.hide();
    	mainStage.show();
    }
    
    
    @FXML
    public void MAINlogout(ActionEvent event) throws IOException{
    	showLogin();
    	localUser = null;
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
        			if(restaurant.getEmployees().get(i).getId().equals(auxEmployee.getId())) {
        				restaurant.deleteEmployee(i);
        				leave = true;
        			}
        		}
        		EMPinitializeTableView();
    		}
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("No employee selected");
			alertWarnings.setHeaderText("You haven't selected a employee.");
			alertWarnings.setContentText("Please select an employee to use the delete button.");
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
        		EMPinitializeTableView();
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
    public void EMPMENUselectedEmp(MouseEvent event) throws IOException {
    	FXMLLoader x = new FXMLLoader(getClass().getResource("EditEmployeeWindow"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	EDITEMPnamesTxtField.setText(EMPMENUtable.getSelectionModel().getSelectedItem().getNames());
    	EDITEMPlastNamesTxtField.setText(EMPMENUtable.getSelectionModel().getSelectedItem().getLastNames());
    	EDITEMPidTxtField.setText(EMPMENUtable.getSelectionModel().getSelectedItem().getId());
    	mainStage.show();
    }
    
    @FXML
    public void EDITEMPaddBttn(ActionEvent event) throws IOException {
    	if(!EDITEMPidTxtField.getText().isEmpty() && !EDITEMPnamesTxtField.getText().isEmpty() && !EDITEMPlastNamesTxtField.getText().isEmpty()) {
    		restaurant.updateEmployee(EMPMENUtable.getSelectionModel().getSelectedIndex(), EDITEMPnamesTxtField.getText(), EDITEMPlastNamesTxtField.getText(), EDITEMPidTxtField.getText());
    		popupStage.hide();
        	mainStage.show();
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Empty fields");
			alertWarnings.setHeaderText("You haven't filled all the fields.");
			alertWarnings.setContentText("Please do it, lol.");
			alertWarnings.show();
    	}
    	restaurant.saveData();
    }

    @FXML
    public void EDITEMPbackBttn(ActionEvent event) {
    	popupStage.hide();
    	mainStage.show();
    }

    @FXML
    public void ADDEMPaddBttn(ActionEvent event) throws IOException {
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
    					
    					restaurant.addEmployee(names, lastNames, id);
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
    	restaurant.saveData();
    }


    @FXML
    public void ADDEMPbackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }
    
    @FXML
    public void ADDUSERaddBttn(ActionEvent event) throws IOException {
    	if(!ADDUSERnamesTxtField.getText().isEmpty() && !ADDUSERpasswordTxtField.getText().isEmpty() && !ADDUSERusernameTxField.getText().isEmpty() && !ADDUSERlastNamesTxtFIeld.getText().isEmpty() && !ADDUSERidTxtField.getText().isEmpty()) {
    		boolean found = false;
    		for(int i=0;i<restaurant.getUsers().size() && !found;i++) {
    			if(restaurant.getUsers().get(i).getUsername().equals(ADDUSERusernameTxField.getText())) {
    				found = true;
    			}
    		}
    		if(!found) {
    			restaurant.addUser(ADDUSERusernameTxField.getText(), ADDUSERpasswordTxtField.getText(), ADDUSERnamesTxtField.getText(), ADDUSERlastNamesTxtFIeld.getText(), ADDUSERidTxtField.getText());
    			popupStage.close();
    	    	mainStage.show();
    	    	USERinitializeTableView();
    		}
    		else {
    			Alert alertWarnings = new Alert(AlertType.WARNING);
    	    	alertWarnings.setTitle("Wrong username");
    			alertWarnings.setHeaderText("There is already a user with that username.");
    			alertWarnings.setContentText("Please change it.");
    			alertWarnings.show();
    		}
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Empty fields");
			alertWarnings.setHeaderText("You haven't filled all the fields.");
			alertWarnings.setContentText("Please do it, lol.");
			alertWarnings.show();
    	}
    	restaurant.saveData();
    }

    @FXML
    public void ADDUSERbackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }

    @FXML
    public void USERMENUaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader x = new FXMLLoader(getClass().getResource("AddUserWindow.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	popupStage.show();
    	mainStage.hide();
    }

    @FXML
    public void USERMENUbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    public void USERMENUdeleteBttn(ActionEvent event) throws IOException {
    	int index = USERMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteUser(index);
    	USERinitializeTableView();
    }

    @FXML
    public void USERMENUdisableBttn(ActionEvent event) {
    	
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
    	restaurant.saveData();
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
    public void CLMENUaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader x = new FXMLLoader(getClass().getResource("AddClientWindow.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	popupStage.show();
    	mainStage.hide();
    }
    
    @FXML
    void ADDCLaddBttn(ActionEvent event) throws IOException {
    	if(!ADDCLnameTxtField.getText().isEmpty() && !ADDCLlastNameTxtFIeld.getText().isEmpty() && !ADDCLphoneTxtField.getText().isEmpty() && !ADDCLaddressTxtField.getText().isEmpty() && !ADDCLidTxtField.getText().isEmpty()) {
    		restaurant.addClient(ADDCLnameTxtField.getText(), ADDCLlastNameTxtFIeld.getText(), ADDCLidTxtField.getText(), ADDCLaddressTxtField.getText(), ADDCLphoneTxtField.getText(), ADDCLfootnoteTxt.getText(), localUser, localUser);
    		popupStage.close();
        	mainStage.show();
        	CLinitializeTableView();
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("Empty fields");
			alertWarnings.setContentText("Please fill the all.");
			alertWarnings.show();
    	}
    	restaurant.saveData();
    }

    @FXML
    void ADDCLbackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }
    
    

    @FXML
    public void CLMENUbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    public void CLMENUdeletBttn(ActionEvent event) throws IOException {
    	if(CLMENUtable.getSelectionModel().getSelectedItem() != null) {
    		restaurant.deleteClient(CLMENUtable.getSelectionModel().getSelectedIndex());
    		CLinitializeTableView();
    	}
    	else {
    		Alert alertWarnings = new Alert(AlertType.WARNING);
	    	alertWarnings.setTitle("Error");
			alertWarnings.setHeaderText("No selected client");
			alertWarnings.setContentText("Please select a client if you want to delete it.");
			alertWarnings.show();
    	}
    	restaurant.saveData();
    }
    
    @FXML
    public void CLMENUimportBttn(ActionEvent event) throws IOException {
    	FileChooser fc = new FileChooser();
    	fc.setTitle("Select the clients list");
    	File f = fc.showOpenDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Import clients");
    	
    	try {
    		restaurant.importClients(f.getAbsolutePath());
    		
    		a.setContentText("Client data was imported succefuslly");
    		a.show();
    		
    	} catch(IOException e) {
    		a.setContentText("Client data wasn't imported succefuslly");
    		a.show();
    		
    	}
    	restaurant.saveData();
    }
    
    @FXML
    public void CLMENUexportBttn(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.setTitle("Select the clients list");
    	File f = fc.showSaveDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Export clients");
    	
    	try {
    		restaurant.exportClients(f.getAbsolutePath());
    		
    		a.setContentText("Client data was exported succefuslly");
    		a.show();
    		
    	} catch(IOException e) {
    		a.setContentText("Client data wasn't exported succefuslly");
    		a.show();
    		
    	}
    }

    @FXML
    public void CLMENUselectedClient(MouseEvent event) throws IOException {
    	if(event.getClickCount()==2) {
    		FXMLLoader x =  new FXMLLoader(getClass().getResource("EditClientWindow.fxml"));
        	x.setController(this);
        	Parent root = x.load();
        	Scene e = new Scene(root);
        	popupStage.setScene(e);
        	Client auxCl = CLMENUtable.getSelectionModel().getSelectedItem();
        	EDITCLnameTxtField.setText(auxCl.getName());
        	EDITCLlastNameTxtFIeld.setText(auxCl.getLastName());
        	EDITCLidTxtField.setText(auxCl.getId());
        	EDITCLphoneTxtField.setText(auxCl.getPhoneNumber());
        	EDITCLaddressTxtField.setText(auxCl.getAddress());
        	EDITCLfootnoteTxt.setText(auxCl.getFootNote());
        	popupStage.show();
        	mainStage.hide();
    	}
    }
    
    @FXML
    public void EDITCLaddBttn(ActionEvent event) throws IOException {
    	restaurant.updateClient(CLMENUtable.getSelectionModel().getSelectedIndex(), EDITCLnameTxtField.getText(), EDITCLlastNameTxtFIeld.getText(), EDITCLidTxtField.getText(), EDITCLaddressTxtField.getText(), EDITCLphoneTxtField.getText(), EDITCLfootnoteTxt.getText(), localUser);
    	popupStage.hide();
    	mainStage.show();
    	CLinitializeTableView();
    	restaurant.saveData();
    }

    @FXML
    public void EDITCLbackBttn(ActionEvent event) {
    	popupStage.hide();
    	mainStage.show();
    }

    private String generateDate() {
    	 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");  
    	 Date date = new Date();
    	 String dateString = formatter.format(date);
    	 return dateString;
    }
    
    @SuppressWarnings("unused")
	private String generateCode() {
    	Random rand = new Random();
    	int code = 0;
    	boolean created = false;
    	for(int i=0;!created;i++) {
    		code = rand.nextInt(10000);
    		boolean repeated = false;
    		for(int j=0;j<restaurant.getOrders().size() && !repeated;j++) {
    			if(restaurant.getOrders().get(j).getCode() == code) {
    				repeated = true;
    			}
    		}
    		if(!repeated) {
    			created = true;
    		}
    	}
    	String codeX = code + "";
    	return codeX;
    }
    
    private void convertEmployeeCB() {
        ADDORDdeliverEmployee.setConverter(new StringConverter<Employee>() {
            @Override
            public String toString(Employee e) {
                return e.getNames();
            }

            @Override
            public Employee fromString(final String string) {
            	return ADDORDdeliverEmployee.getItems().stream().filter(e -> e.getNames().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    private void convertClientsCB() {
        ADDORDclientCB.setConverter(new StringConverter<Client>() {
            @Override
            public String toString(Client cl) {
                return cl.getName();
            }

            @Override
            public Client fromString(final String string) {
            	return ADDORDclientCB.getItems().stream().filter(cl -> cl.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    private void convertProductsCB() {
        ADDORDproductCB.setConverter(new StringConverter<Product>() {
            @Override
            public String toString(Product pr) {
                return pr.getName();
            }

            @Override
            public Product fromString(final String string) {
            	return ADDORDproductCB.getItems().stream().filter(pr -> pr.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    
    private void ADDORDinitializeTable() {
    	ObservableList<Product> observableList;
    	observableList = FXCollections.observableArrayList(ADDORDproList);
		ADDORDproductsCol.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
		ADDORDproductsTable.setItems(observableList);
		
		ObservableList<Integer> oL;
    	oL = FXCollections.observableArrayList(ADDORDquantityList);
		ADDORDquantityCol.setCellValueFactory(new PropertyValueFactory<Integer,Integer>("intValue"));
		ADDORDquantityTable.setItems(oL);
    }
    
    @FXML
    public void ADDORDaddProductsBttn(ActionEvent event) throws IOException {
    	if(ADDORDproductCB.getSelectionModel().getSelectedItem()!=null && !ADDORDquantityTXtField.getText().isEmpty()) {
    		int quantity = Integer.parseInt(ADDORDquantityTXtField.getText());
    		ADDORDquantityList.add(quantity);
    		ADDORDquantityTXtField.setText(null);
    		
    		Product selected = ADDORDproductCB.getSelectionModel().getSelectedItem();
    		ADDORDproList.add(selected);
    		ADDORDproductCB.getSelectionModel().clearSelection();
    		ADDORDproductCB.setValue(null);
    		
    		ADDORDinitializeTable();
    	}
    	
    	else {
    		Alert alert = new Alert(AlertType.WARNING);
    		
    		alert.setContentText("Complete the information!");
    		alert.show();
    	}
    	restaurant.saveData();
    }
    
    @FXML
    public void ADDORDaddBttn(ActionEvent event) throws IOException{
    	if(ADDORDclientCB.getSelectionModel().getSelectedItem()!=null && ADDORDdeliverEmployee.getSelectionModel().getSelectedItem()!=null) {
    		String lblDate = ADDORDdateLabel.getText();
    		
    		String[] dParts = lblDate.split(" ");
    		String dPart1 = dParts[0];
    		String dPart2 = dParts[1];
    		
    		String[] hourNMins = dPart1.split(":");
    		int dHour = Integer.parseInt(hourNMins[0]);
    		int dMin = Integer.parseInt(hourNMins[1]);
    		
    		String[] dmy = dPart2.split("/");
    		int dDay = Integer.parseInt(dmy[0]);
    		int dMonth= Integer.parseInt(dmy[1]);
    		int dYear= Integer.parseInt(dmy[1]);
    		
    		
    		DateClass date = new DateClass(dHour,dMin,dDay,dMonth,dYear);
    		int code = Integer.parseInt(ADDORDcodeLabel.getText());
    		String footNote = "";
    		List<Product> products = ADDORDproList;
    		List<Integer> productsQuantity = ADDORDquantityList;
    		Client cl = ADDORDclientCB.getSelectionModel().getSelectedItem();
    		Employee emp = ADDORDdeliverEmployee.getSelectionModel().getSelectedItem();
    		
    		restaurant.addOrder(code, footNote, date, products, productsQuantity, cl, emp);
    		ORDERinitializeTableView();
    		
    		popupStage.close();
    		mainStage.show();
        	
    	}
    	
    	else {
    		Alert a = new Alert(AlertType.WARNING);
    		a.setContentText("Complete the information!");
    		a.show();
    	}
    	restaurant.saveData();
    }

    @FXML
    public void ADDORDbackBttn(ActionEvent event) throws IOException {
    	popupStage.close();
		mainStage.show();
    	
    }

    @FXML
    public void ORDERMANaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader x = new FXMLLoader(getClass().getResource("AddOrderWindow.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	ObservableList<Client> clList = FXCollections.observableArrayList(restaurant.getClients());
    	ADDORDclientCB.itemsProperty().setValue(clList);
    	convertClientsCB();
    	
    	ObservableList<Product> prList = FXCollections.observableArrayList(restaurant.getProducts());
    	ADDORDproductCB.itemsProperty().setValue(prList);
    	convertProductsCB();
    	
    	ObservableList<Employee> empList = FXCollections.observableArrayList(restaurant.getEmployees());
    	ADDORDdeliverEmployee.itemsProperty().setValue(empList);
    	convertEmployeeCB();
    	
    	ADDORDinitializeTable();
    	
    	ADDORDcodeLabel.setText(generateCode());
    	
    	ADDORDdateLabel.setText(generateDate());
    	popupStage.show();
    	mainStage.hide();
    	
    }

    @FXML
    public void EDITORDaddProductsBttn(ActionEvent event) {
    	if(EDITORDproductCB.getSelectionModel().getSelectedItem()!=null && !EDITORDquantityTXtField.getText().isEmpty()) {
    		int quantity = Integer.parseInt(EDITORDquantityTXtField.getText());
    		EDITORDquantityList.add(quantity);
    		EDITORDquantityTXtField.setText(null);
    		
    		Product selected = ADDORDproductCB.getSelectionModel().getSelectedItem();
    		EDITORDproList.add(selected);
    		EDITORDproductCB.getSelectionModel().clearSelection();
    		EDITORDproductCB.setValue(null);
    		
    		EDITORDinitializeTableView();
    	}
    	
    	else {
    		Alert alert = new Alert(AlertType.WARNING);
    		
    		alert.setContentText("Complete the information!");
    		alert.show();
    	}
    }

    @FXML
    public void EDITORDbackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    	
    }
    
    @FXML
    public void EDITORDupdateStatusBttn(ActionEvent event) throws IOException {
    	if(EDITORDclientCB.getSelectionModel().getSelectedItem()!=null && EDITORDdeliverEmployeeCB.getSelectionModel().getSelectedItem()!=null && !EDITORDstatusTxt.getText().equals(null)) {
    		int index = ORDERMANtable.getSelectionModel().getSelectedIndex();
    		
    		EDITORDstatusTxt.setText(ORDERMANtable.getSelectionModel().getSelectedItem().getStatus());
    		
    		restaurant.updateStatusOrder(index);
    		
    		popupStage.close();
    		mainStage.show();
    		ORDERinitializeTableView();
    	}
    	restaurant.saveData();
    }

    @FXML
    public void EDITORDdoneBttn(ActionEvent event) throws IOException {
    	if (EDITORDclientCB.getSelectionModel().getSelectedItem()!=null && EDITORDdeliverEmployeeCB.getSelectionModel().getSelectedItem()!=null) {
    		int index = ORDERMANtable.getSelectionModel().getSelectedIndex();
    		Client cl = EDITORDclientCB.getSelectionModel().getSelectedItem();
    		Employee emp = EDITORDdeliverEmployeeCB.getSelectionModel().getSelectedItem();
    		
    		restaurant.updateOrder(index, EDITORDproList, EDITORDquantityList, cl, emp);
    		
    		popupStage.close();
    		mainStage.show();
    		ORDERinitializeTableView();
		}
    	restaurant.saveData();
    }
    
    @FXML
    public void ORDERMANselectedOrder(MouseEvent event) throws IOException{
    	if(event.getClickCount()==2) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("EDITOrderWindow.fxml"));
    		loader.setController(this);
    		Parent root = loader.load();
    		Scene sc = new Scene(root);
    		popupStage = new Stage();
    		popupStage.setScene(sc);
    		popupStage.show();
    		mainStage.hide();
    		
    		EDITORDclientCB.setValue(ORDERMANtable.getSelectionModel().getSelectedItem().getOriginClient());
    		
    		EDITORDstatusTxt.setText(ORDERMANtable.getSelectionModel().getSelectedItem().getStatus());
    		
    		ObservableList<Product> productList = FXCollections.observableList(restaurant.getProducts());
    		EDITORDproductCB.itemsProperty().setValue(productList);
    		convertProCB();
    		
    		ObservableList<Employee> empList = FXCollections.observableList(restaurant.getEmployees());
    		EDITORDdeliverEmployeeCB.itemsProperty().setValue(empList);
    		convertEmployeeCB();
    		
    		EDITORDdateLabel.setText(ORDERMANtable.getSelectionModel().getSelectedItem().getStringTime());
    		EDITORDcodeLabel.setText(ORDERMANtable.getSelectionModel().getSelectedItem().getStringCode());
    		
    		EDITORDinitializeTableView();
    	}
    }
    
    public void EDITORDinitializeTableView() {
		EDITORDproList = ADDORDproList;
		ObservableList<Product> proList = FXCollections.observableArrayList(EDITORDproList);
		EDITORDproductsCol.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
		EDITORDproductsTable.setItems(proList);
		
		EDITORDquantityList = ADDORDquantityList;
		ObservableList<Integer> quantityList = FXCollections.observableArrayList(EDITORDquantityList);
		EDITORDquantityCol.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("intValue"));
		EDITORDquantityTable.setItems(quantityList);
		
    }
    
    @FXML
    public void ORDERMANbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	MAINmainPane.getChildren().setAll(root);
    
    }

    @FXML
    public void ORDERMANdeleteBttn(ActionEvent event) throws IOException {
    	int index = ORDERMANtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteOrder(index);
    	ORDERinitializeTableView();
    	restaurant.saveData();
    }

    @FXML
    public void ORDERMANimportBttn(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.setTitle("Select the order list");
    	File f = fc.showOpenDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Import orders");
    	
    	if(f!=null) {
    		try {
    			restaurant.importOrders(f.getAbsolutePath());
    			
    			a.setContentText("Order data was imported succesfuly");
    			a.show();
    			
    		} catch(IOException e) {
    			a.setContentText("Order data wasn't imported succesfuly");
    			a.show();
    			
    		};
    		
    		ORDERinitializeTableView();
    	}
    }
    
    @FXML
    public void ORDERMANexportBttn(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.setTitle("Export orders");
    	File f = fc.showSaveDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Import orders");

    	if(f!=null) {
    		try {
    			restaurant.exportOrders(f.getAbsolutePath());
    			
    			a.setContentText("Order data was exported succesfuly");
		    	a.show();
    			
    		} catch(IOException e) {
    			a.setContentText("Order data wasn't exported succesfuly");
		    	a.show();
    		};
    	}
    	
    }
        
    @FXML
    public void PROMANaddBttn(ActionEvent event) throws IOException {
    	FXMLLoader aux = new FXMLLoader(getClass().getResource("AddProductWindow.fxml"));
    	aux.setController(this);
    	Parent root = aux.load();
    	Scene sc = new Scene(root);
    	popupStage = new Stage();
    	popupStage.setScene(sc);
    	popupStage.show();
    	mainStage.hide();
    	
    	ADDPROinitializeCB();
    }
    
    public void ADDPROinitializeCB() {
    	ObservableList<Size> sizeList = FXCollections.observableList(restaurant.getSizes());
    	ADDPROsizeCB.itemsProperty().setValue(sizeList);
    	convertSizeCB();
    	
    	ObservableList<BaseProduct> bproductsList = FXCollections.observableList(restaurant.getBaseProducts());
    	ADDPRObaseProCB.itemsProperty().setValue(bproductsList);
    	convertBProductsCB();
    }
    
   private void convertBProductsCB() {
	   ADDPRObaseProCB.setConverter(new StringConverter<BaseProduct>() {
	
		   @Override
		   public String toString(BaseProduct bp) {
			   return bp.getName();
		   }
		   
		   @Override
		   public BaseProduct fromString(final String string) {
			   return ADDPRObaseProCB.getItems().stream().filter(e -> e.getName().equals(string)).findFirst().orElse(null);
		   }
	   });
   }

    @FXML
    void PROMANbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader aux = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	aux.setController(this);
    	Parent addMain = aux.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    void PROMANdeleteBttn(ActionEvent event) throws IOException {
    	int index = PROMANtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteProduct(index);
    	PROMANinitializeTable();
    	restaurant.saveData();
    }

    private void PROMANinitializeTable() {
    	ObservableList<Product> observableList;
    	observableList = FXCollections.observableArrayList(restaurant.getProducts());
		PROMANnameCol.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
		PROMANpriceCol.setCellValueFactory(new PropertyValueFactory<Product,Double>("price"));
		PROMANsizeCol.setCellValueFactory(new PropertyValueFactory<Product,String>("sizeName"));
		PROMANbaseProcol.setCellValueFactory(new PropertyValueFactory<Product,String>("baseProductName"));
		PROMANtable.setItems(observableList);
	}

	@FXML
    public void PROMANimportBttn(ActionEvent event) throws IOException {
		FileChooser fc = new FileChooser();
    	fc.setTitle("Select the products list");
    	File f = fc.showOpenDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Import products");
    	
    	if(f!=null) {
    		try {
    			restaurant.importProducts(f.getAbsolutePath());
    			
    			a.setContentText("Product data was imported succesfuly");
		    	a.show();
    			
    		} catch(IOException e) {
    			a.setContentText("Product data wasn't imported succesfuly");
		    	a.show();
    		};
    		
    		PROMANinitializeTable();
    	}
    	restaurant.saveData();
    }
	
	@FXML
    public void PROMANexportBttn(ActionEvent event) {
		FileChooser fc = new FileChooser();
    	fc.setTitle("Select the products list");
    	File f = fc.showSaveDialog(MAINmainPane.getScene().getWindow());
    	
    	Alert a = new Alert(AlertType.INFORMATION);
    	a.setTitle("Export products");
    	
    	if(f!=null) {
    		try {
    			restaurant.exportProducts(f.getAbsolutePath());
    			
    			a.setContentText("Product data was exported succesfuly");
		    	a.show();
    			
    		} catch(IOException e) {
    			a.setContentText("Product data wasn't exported succesfuly");
		    	a.show();
    		};
    	}
    }

    @FXML
    public void PROMANselectedProduct(MouseEvent event) throws IOException {
    	if(event.getClickCount() == 2) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductWindow.fxml"));
    		loader.setController(this);
    		Parent root = loader.load();
    		Scene e = new Scene(root);
    		popupStage = new Stage();
    		popupStage.setScene(e);;
    		ObservableList<Size> sizeList = FXCollections.observableList(restaurant.getSizes());
    		ADDPROsizeCB.itemsProperty().setValue(sizeList);
    		convertSizeCB();
    		ObservableList<BaseProduct> baseProList = FXCollections.observableList(restaurant.getBaseProducts());
    		ADDPRObaseProCB.itemsProperty().setValue(baseProList);
    		convertProCB();
    		popupStage.show();
    		popupStage.setResizable(false);
    		mainStage.hide();

    	}
    }
    
    private void convertSizeCB() {
        ADDPROsizeCB.setConverter(new StringConverter<Size>() {
            @Override
            public String toString(Size size) {
                return size.getName();
            }

            @Override
            public Size fromString(final String string) {
            	return ADDPROsizeCB.getItems().stream().filter(size -> size.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }
    
    private void convertProCB() {
        ADDPRObaseProCB.setConverter(new StringConverter<BaseProduct>() {
            @Override
            public String toString(BaseProduct bs) {
                return bs.getName();
            }

            @Override
            public BaseProduct fromString(final String string) {
            	return ADDPRObaseProCB.getItems().stream().filter(bs -> bs.getName().equals(string)).findFirst().orElse(null);
            }
        });
    }

    @FXML
    public void ADDPRObackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }

    @FXML
    public void ADDPROdoneBttn(ActionEvent event) throws IOException {
    	restaurant.addProduct(ADDPRObaseProCB.getSelectionModel().getSelectedItem(), ADDPROsizeCB.getSelectionModel().getSelectedItem(), Double.parseDouble(ADDPROpriceTxtField.getText()));
    	popupStage.close();
    	mainStage.show();
    	PROMANinitializeTable();
    	restaurant.saveData();
    }
    
    @FXML
    public void MAINopenSEARCHCL(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchClientWindow.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	MAINmainPane.getChildren().setAll(root);
    	
    }
      
    @FXML
    public void SEARCHCLsearchClBttn(ActionEvent event) {
    	String name = SEARCHCLnameTxtField.getText();
    	
    	if(!name.equals(null)) {
    		ArrayList<Client> aux = restaurant.getClients();
    		
    		int pos = -1;
    		int i = 0;
    		int j = aux.size()-1;
    		
    		while(i<=j && pos<0) {
    			int m = (i+j)/2;
    			
    			if(aux.get(m).getName().equalsIgnoreCase(name)) {
    				pos = m;
    				
    				SEARCHCLclientsList.add(aux.get(pos));
    		    	SEARCHCLinitializeTableView();
    			}
    			else if(name.compareToIgnoreCase(aux.get(m).getName())>0) {
    				i = m+1;	
    			}
    			else {
    				j = m-1;
    			}
    			
    		}
    	}
    }
    
    public void SEARCHCLinitializeTableView() {
    	ObservableList<Client> observableList = FXCollections.observableArrayList(SEARCHCLclientsList);
    	
    	SEARCHCLnamesCol.setCellValueFactory(new PropertyValueFactory<Client,String>("name"));
    	SEARCHCLlastnamesCol.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName"));
    	SEARCHCLidCol.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
    	SEARCHCLaddressCol.setCellValueFactory(new PropertyValueFactory<Client,String>("address"));
    	SEARCHCLphonenumberCol.setCellValueFactory(new PropertyValueFactory<Client,String>("phoneNumber"));
    	SEARCHCLfootnoteCol.setCellValueFactory(new PropertyValueFactory<Client,String>("footNote"));
    	SEARCHCLtableView.setItems(observableList);
    	
    }

    @FXML
    public void SEARCHCLbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	MAINmainPane.getChildren().setAll(root);
    	
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