package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application{
	
	private RestaurantManagerGUI rmGUI;
	private Restaurant r;
	public Main() {
		r = new Restaurant();
		rmGUI = new RestaurantManagerGUI(r);
	}
	

	public static void main(String[] args){
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		loader.setController(rmGUI);
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Login");
		rmGUI.loadLogin();
		
	}
	
	
	
}
