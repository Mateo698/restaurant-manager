package ui;

import javafx.application.Application;
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
		restaurantMan.start();
	}
	
	public void xD() {
		
	}
}
