package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	/**
	 * @author Clément RIOU L2INFOGR2
	 * @version = 1.2
	 * @
	 */
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("test_offre.fxml"));
			root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setTitle("Fenêtre Offres");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	
