package com.puck.refactoring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.puck.nodes.piccolo2d.PiccoloCustomNode;

public class RefactoringCommands {

	private static RefactoringCommands INSTANCE = new RefactoringCommands();
	private BufferedWriter br;
	private StringBuilder xmlString;
	
	private RefactoringCommands() {
		super();
	};


	public static RefactoringCommands getInstance() {
		return INSTANCE;
	}

	public void init() {
		try {
			PrintWriter pw = new PrintWriter("RefactoringCommands.xml");
			pw.close();
			xmlString = new StringBuilder();
			xmlString.append("<?xml version=\"1.0\"?>\n");
			xmlString.append("<RefactoringCommands>\n");	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void nodeToString(PiccoloCustomNode node) {
		String formatString = "\t<Rename id=\"%s\" newName=\"%s\"/>\n";
		String id = node.getidNode();
		String newName = node.getName();
		xmlString.append(String.format(formatString, id, newName));
	}

	public void writeFile(File savingFile) {
		if (!xmlString.toString().contains("</RefactoringCommands>")) 
		xmlString.append("</RefactoringCommands>");
		try {
			br = new BufferedWriter(new FileWriter(new File("RefactoringCommands.xml")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(savingFile));
			bw.write(xmlString.toString());
			bw.flush();
			bw.close();
			System.out.println(xmlString.toString());
			br.write(xmlString.toString());
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public StringBuilder getXmlString() {
		return xmlString;
	}
	public void setXmlString(StringBuilder xmlString) {
		this.xmlString = xmlString;
	}
	
}
