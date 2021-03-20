package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.BaseProduct;
import model.Client;
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
    
    private ArrayList<Ingredient> ADDBASEPROlist;
    
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

	    	
	    	restaurant.addUser(username, password, names, lastNames, ID);
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
    void MAINopenREPORTEMP(ActionEvent event) throws IOException {
    	FXMLLoader usrLoader = new FXMLLoader(getClass().getResource("EmployeeReport.fxml"));
    	usrLoader.setController(this);
    	Parent addMain = usrLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now);
    	EMPREPORTfromTxtFIeld.setText("00:00-"+date);
    	EMPREPORTtoTxtField.setText("23:59-"+date);
    }
    
    @FXML
    void EMPREPORTbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    }

    @FXML
    void EMPREPORTgenerateReport(ActionEvent event) throws FileNotFoundException {
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
    void MAINopenREPORTORDER(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("OrderReport.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	mainStage.setScene(e);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now);
    	ORDERREPORTfromTxtFIeld.setText("00:00-"+date);
    	ORDERREPORTtoTxtField.setText("29:59-"+date);
    }
    
    @FXML
    void ORDERREPORTbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	mainStage.setScene(e);
    }

    @FXML
    void ORDERREPORTgenerateReport(ActionEvent event) throws FileNotFoundException {
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
    void MAINopenREPORTPRO(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("ProductsReport.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	mainStage.setScene(e);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now);
    	ORDERREPORTfromTxtFIeld.setText("00:00-"+date);
    	ORDERREPORTtoTxtField.setText("29:59-"+date);
    }
    
    @FXML
    void PROREPORTbackBttn(ActionEvent event) throws IOException {
    	FXMLLoader  x = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	mainStage.setScene(e);
    }

    @FXML
    void PROREPORTgenerateReport(ActionEvent event) throws FileNotFoundException {
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
    void MAINopenORDERMANAGER(ActionEvent event) throws IOException {
    	FXMLLoader orderLoader = new FXMLLoader(getClass().getResource("OrderManager.fxml"));
    	orderLoader.setController(this);
    	Parent addMain = orderLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	ORDERinitializeTableView();;
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
    	ORDERMANtable.setItems(USRobservableList);
    }
    

    @FXML
    void MAINopenPRODUCTS(ActionEvent event) throws IOException {
    	FXMLLoader proLoader = new FXMLLoader(getClass().getResource("ProductManager.fxml"));
    	proLoader.setController(this);
    	Parent addMain = proLoader.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    	PROMANinitializeTable();
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
    }
    
    @FXML
    void ADDINGaddBttn(ActionEvent event) {
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
    public void INGRMENUdeleteBttn(ActionEvent event) {
    	int index = INGRMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteIngredient(index);
    	INGRinitializeTableView();
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
    }
    
    @FXML
    void EDITINGaddBttn(ActionEvent event) {
    	int index = INGRMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.updateIngredient(index,EDITINGnameTxtField.getText());
    	popupStage.close();
    	mainStage.show();
    	INGRinitializeTableView();
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
    	FXMLLoader x = new FXMLLoader(getClass().getResource("AddBaseProduct.fxml"));
    	x.setController(this);
    	Parent root = x.load();
    	Scene e = new Scene(root);
    	popupStage.setScene(e);
    	ADDBASEPROinitializeTableView();
    	popupStage.show();
    	mainStage.hide();
    	ADDBASEPROlist.clear();
    	ADDBASEPROnameTxtField.setText("");
    }
    
    public void ADDBASEPROinitializeTableView() {
    	ObservableList<Ingredient> observableList;
    	observableList = FXCollections.observableArrayList(ADDBASEPROlist);
    	
    	ADDBASEPROingCol.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
    	ADDBASEPROingTable.setItems(observableList);
    	ObservableList<Type> typeList = FXCollections.observableList(restaurant.getTypes());
    	ADDBASEPROtypeCB.setItems(typeList);
    	ObservableList<Ingredient> ingList = FXCollections.observableList(restaurant.getIngredients());
    	ADDBASEPROingredientCB.setItems(ingList);
    }
    
    @FXML
    void ADDBASEPROaddIngBttn(ActionEvent event) {
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
    void ADDBASEPROdoneBttn(ActionEvent event) {
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
    }

    @FXML
    public void BASEPRODUCTMENUbackBttn(ActionEvent event) throws IOException{
    	FXMLLoader lP = new FXMLLoader(getClass().getResource("MainPaneMain.fxml"));
    	lP.setController(this);
    	Parent addMain = lP.load();
    	MAINmainPane.getChildren().setAll(addMain);
    	
    }

    @FXML
    public void BASEPRODUCTMENUdeleteBttn(ActionEvent event) {
    	if(BASEPRODUCTMENUtable.getSelectionModel().getSelectedItem()!=null) {
    		restaurant.deleteBaseProduct(BASEPRODUCTMENUtable.getSelectionModel().getSelectedIndex());
    		BASEPRODUCTinitializeTableView();
    	}
    }

    @FXML
    public void BASEPRODUCTMENUdisableBttn(ActionEvent event) {
    	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @FXML
    void BASEPRODUCTselectedItem(MouseEvent event) throws IOException {
    	if(event.getClickCount() == 2 && BASEPRODUCTMENUtable.getSelectionModel().getSelectedItem()!=null) {
    		FXMLLoader x = new FXMLLoader(getClass().getResource("EditBaseProduct.fxml"));
    		x.setController(this);
    		Parent root = x.load();
    		Scene e = new Scene(root);
    		popupStage.setScene(e);
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
    	EDITBASEPROtypeCB.setItems(typeList);
    	ObservableList<Ingredient> ingList = FXCollections.observableList(restaurant.getIngredients());
    	EDITBASEPROingredientCB.setItems(ingList);
    }
    
    @FXML
    void EDITBASEPROaddIngBttn(ActionEvent event) {
    	Ingredient selected = ADDBASEPROingredientCB.getSelectionModel().getSelectedItem();
    	ADDBASEPROlist.add(selected);
    	EDITBASEPROingredientCB.getSelectionModel().clearSelection();
    	EDITBASEPROingredientCB.setValue(null);
    	ObservableList<Ingredient> ingList = FXCollections.observableList(restaurant.getIngredients());
    	ADDBASEPROingredientCB.setItems(ingList);
    	ADDBASEPROinitializeTableView();
    }

    @FXML
    void EDITBASEPRObackBttn(ActionEvent event) {
    	ADDBASEPROlist.clear();
    	popupStage.hide();
    	mainStage.show();
    }

    @FXML
    void EDITBASEPROdoneBttn(ActionEvent event) {
    	int index = BASEPRODUCTMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.getBaseProducts().get(index).setIngredients(ADDBASEPROlist);
    	restaurant.getBaseProducts().get(index).setName(EDITBASEPROnameTxtField.getText());
    	restaurant.getBaseProducts().get(index).setType(EDITBASEPROtypeCB.getSelectionModel().getSelectedItem());
    	popupStage.hide();
    	mainStage.show();
    	BASEPRODUCTinitializeTableView();
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
    void EMPMENUselectedEmp(MouseEvent event) {

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
    public void USERMENUdeleteBttn(ActionEvent event) throws IOException {
    	int index = USERMENUtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteUser(index);
    	USERinitializeTableView();
    	restaurant.saveData();
    }

    @FXML
    public void USERMENUdisableBttn(ActionEvent event) {
    	
    }

    @FXML
    public void USERMENUeditBttn(ActionEvent event) {
    	
    	
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
    
    @FXML
    void ORDERMANaddBttn(ActionEvent event) {

    }

    @FXML
    void ORDERMANbackBttn(ActionEvent event) {

    }

    @FXML
    void ORDERMANdeleteBttn(ActionEvent event) {

    }

    @FXML
    void ORDERMANdisableBttn(ActionEvent event) {

    }
    
    @FXML
    void PROMANaddBttn(ActionEvent event) {

    }

    @FXML
    void PROMANbackBttn(ActionEvent event) {

    }

    @FXML
    void PROMANdeleteBttn(ActionEvent event) {
    	int index = PROMANtable.getSelectionModel().getSelectedIndex();
    	restaurant.deleteProduct(index);
    	PROMANinitializeTable();
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
    void PROMANdisableBttn(ActionEvent event) {

    }
    

    @FXML
    void PROMANselectedProduct(MouseEvent event) throws IOException {
    	if(event.getClickCount() == 2) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductWindow.fxml"));
    		loader.setController(this);
    		Parent root = loader.load();
    		Scene e = new Scene(root);
    		popupStage = new Stage();
    		popupStage.setScene(e);;
    		ObservableList<Size> sizeList = FXCollections.observableList(restaurant.getSizes());
    		ADDPROsizeCB.setItems(sizeList);
    		ObservableList<BaseProduct> baseProList = FXCollections.observableList(restaurant.getBaseProducts());
    		ADDPRObaseProCB.setItems(baseProList);
    		popupStage.show();
    		popupStage.setResizable(false);
    		mainStage.hide();

    	}
    }
    
    @FXML
    void ADDPRObackBttn(ActionEvent event) {
    	popupStage.close();
    	mainStage.show();
    }

    @FXML
    void ADDPROdoneBttn(ActionEvent event) {
    	restaurant.addProduct(ADDPRObaseProCB.getSelectionModel().getSelectedItem(), ADDPROsizeCB.getSelectionModel().getSelectedItem(), Double.parseDouble(ADDPROpriceTxtField.getText()));
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
    	restaurant.saveData();
	}
  
}
