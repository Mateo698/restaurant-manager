package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application{
	private Restaurant restaurant;
	private RestaurantManagerGUI restaurantMan;
	
	public Main() {
		restaurant = new Restaurant();
		restaurantMan = new RestaurantManagerGUI(restaurant);
	
	}
	
	public static void main(String[] args){
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		fxmlloader.setController(restaurantMan);
		Parent root = fxmlloader.load();
		
		Scene sc = new Scene(root);
		primaryStage.setTitle("Restaurant Manager");
		primaryStage.setScene(sc);
		primaryStage.show();
		
		restaurantMan.showLogin();
	}
}
