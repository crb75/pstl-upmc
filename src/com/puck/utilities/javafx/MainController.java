package com.puck.utilities.javafx;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.puck.display.piccolo2d.NewDisplayDG;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private TextField generationDGLink;
	@FXML
	private TextField xmlFileText;
	@FXML
	private Button generationDGBtn;
	@FXML
	private Button runBtn;

	@FXML
	private TextField projectDGLink;
	@FXML
	private TextField projectDGLinkDir;

	@FXML
	private Button projectDGBtn;
	@FXML
	private Button projectDGBtn1;
	@FXML
	private Button xmlFileBtn;
	@FXML
	private Button runBtnXML;
	@FXML
	private TextArea consoleArea;

	private String generationDGPath;
	private String projectDGPath;
	private String command;
	private String testFile;
	private String xmlFile;


	public void chooseGenerationDGDirectoryyHandler(ActionEvent event) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File file = directoryChooser.showDialog(new Stage());
		if (file != null && file.isDirectory()) {
			projectDGLinkDir.setText(file.getAbsolutePath());
			projectDGPath = file.getPath();
			testFile = projectDGPath.replaceAll("\"", "\\");
			command = generationDGPath.replaceAll("\"", "\\");
			System.out.println(command);
			try {
				// command = "java -jar "+command+" "+testFile+" DependecyGraph.xml" ;
				command = "java -jar " + command + " " + testFile + " DependecyGraph.xml";
				// System.out.println(command);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void chooseGenerationDGDirectoryHandler(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JAR files (*.jar)", "*.jar");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null && file.isFile()) {
			generationDGLink.setText(file.getAbsolutePath());
			generationDGPath = file.getPath();
			projectDGLinkDir.setDisable(false);
			projectDGLink.setDisable(false);

		}
	}
	
	public void chooseXmlFileDGDirectoryHandler(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null && file.isFile()) {
			xmlFileText.setText(file.getAbsolutePath());
			xmlFile = file.getPath();

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

			testFile = projectDGPath.replaceAll("\"", "\\");
			command = generationDGPath.replaceAll("\"", "\\");
			System.out.println(command);
			try {
				// command = "java -jar "+command+" "+testFile+" DependecyGraph.xml" ;
				command = "java -jar " + command + " " + testFile + " DependecyGraph.xml";
				// System.out.println(command);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void printLines(String cmd, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(cmd + " " + line);
			consoleArea.appendText(cmd + " " + line);

		}
	}

	private void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		displaySuccess();
		System.out.println(command + " exitValue() " + pro.exitValue());
		NewDisplayDG.main(new String[] { "DependecyGraph.xml" });
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
	
	public void RunXml(ActionEvent event) {
		try {
			if (xmlFile != null && xmlFile != "") {
				NewDisplayDG.main(new String[] { xmlFile });
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 private void displaySuccess() {
		        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        alert.setTitle("Success");
		        alert.setHeaderText("Sucess");
		        alert.showAndWait();
		    }
}
