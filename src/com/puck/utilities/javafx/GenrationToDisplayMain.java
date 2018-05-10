package com.puck.utilities.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GenrationToDisplayMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root;
			String osName = System.getProperty("os.name").toLowerCase();
			if(osName.contains("linux") || osName.contains("unix")) {
				System.out.println(osName);
			 root = (BorderPane)FXMLLoader.load(getClass().getResource("/src/com/puck/utilities/javafx/MainInterface.fxml"));
			}else {
				System.out.println(osName);
			 root = (BorderPane)FXMLLoader.load(getClass().getResource("/com/puck/utilities/javafx/MainInterface.fxml"));
			}
			Scene scene = new Scene(root,1189.0,912.0);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
