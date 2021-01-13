package main.java;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.util.HttpConnectionMethods;
import main.java.view.MainScreenController;

public class App extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("INTEGRATION PROJECT");
		
		loadMainScreen();
	}
	
	public void loadMainScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/MainScreen.fxml"));
			rootLayout = (AnchorPane) loader.load();
			
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			MainScreenController controller = loader.getController();
			controller.setMain(this);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
//		HttpConnectionMethods httpConn;
		launch(args);
		System.exit(0);
	}
}
