package puck2.gui.startmenu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import com.puck.display.piccolo2d.NewDisplayDG;

public class RunCommand extends Thread {
	private ProcessBuilder processBuilder;
	private Process pro;
	private OutputStream stdin;
	private InputStream stdout;
	private BufferedReader reader;
	private BufferedWriter writer;
	private DisplayMenu displayMenu;
	
	public RunCommand(ProcessBuilder processBuilder,DisplayMenu displayMenu) {
		super();
		this.processBuilder = processBuilder;
		this.displayMenu = displayMenu;
	}

	@Override
	public void run() {
		try {
			pro = this.processBuilder.start();
			stdin = pro.getOutputStream();
			stdout = pro.getInputStream();
			reader = new BufferedReader(new InputStreamReader(stdout));
			writer = new BufferedWriter(new OutputStreamWriter(stdin));
			sendCommand("display\n");
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(stdout);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				displayMenu.getPuck2StdOut().append(line +"\n");
				System.out.println(line);
				if (line.trim().equals("DONE")) {
					displayMenu.setWritingDone(true);
				}
				if (line.trim().contains("DONE:")) {
					String sub = line.substring(line.indexOf(":")+2, line.length());
					String [] split = sub.split(" ");
					if (split.length > 0) 
					((NewDisplayDG)displayMenu.getFrame()).renameNodes(split);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		super.run();
	}

	public void sendCommand(String commande) {
		try {
			writer.write(commande + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BufferedReader getReader() {
		return reader;
	}

	public BufferedWriter getWriter() {
		return writer;
	}

}