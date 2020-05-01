package ui;

import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		this.primaryStage = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("application/Menu.fxml"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public Stage getStage() {
		return primaryStage;
	}
	
}
