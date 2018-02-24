package com.puck.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.puck.display.piccolo2d.NewDisplayDG;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private TextField generationDGLink;

	@FXML
	private Button generationDGBtn;
	@FXML
	private Button runBtn;

	@FXML
	private TextField projectDGLink;

	@FXML
	private Button projectDGBtn;

	@FXML
	private TextArea consoleArea;

	private String generationDGPath;
	private String projectDGPath;
	private String command;

	public void chooseGenerationDGDirectoryHandler(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JAR files (*.jar)", "*.jar");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null && file.isFile()) {
			generationDGLink.setText(file.getAbsolutePath());
			generationDGPath = file.getPath();
		}
	}
	public void chooseProjectDGDirectoryHandler(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JAVA files (*.java)", "*.java");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null && file.isFile()) {
		projectDGLink.setText(file.getAbsolutePath());
		projectDGPath = file.getPath();
		}
		String testFile = projectDGPath.replaceAll("\"", "\\");
		command = generationDGPath.replaceAll("\"", "\\");
		System.out.println(command);
		try {
			//command =  "java -jar "+command+" "+testFile+" DependecyGraph.xml" ;
			command =  "java -jar "+command+" DependecyGraph.xml" ;
			//System.out.println(command);
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 private  void printLines(String cmd, InputStream ins) throws Exception {
	        String line = null;
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(ins));
	        while ((line = in.readLine()) != null) {
	            System.out.println(cmd + " " + line);
	    		consoleArea.appendText(cmd + " " + line);

	        }
	      }

	      private  void runProcess(String command) throws Exception {
	        Process pro = Runtime.getRuntime().exec(command);
	        printLines(command + " stdout:", pro.getInputStream());
	        printLines(command + " stderr:", pro.getErrorStream());
	        pro.waitFor();
	        System.out.println(command + " exitValue() " + pro.exitValue());
	        NewDisplayDG.main(new String[] {"DependecyGraph.xml"});
	        consoleArea.appendText(command + " exitValue() " + pro.exitValue());
	      
	      }
	      
	      public void Run(ActionEvent event) {
	    	  try {
				runProcess(command);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
}
