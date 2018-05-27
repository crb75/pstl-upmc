package com.puck.utilities.javafx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.display.piccolo2d.NewDisplayDG;
import com.puck.refactoring.ExecuteRefactoringPlan;
import com.puck.refactoring.RefactoringCommands;
import com.puck.undoRedo.StateChanger2;
import java.awt.TextArea;
import java.awt.Button;

public class GenrationToDisplayMain extends JFrame {
	private JTextField jarPathText;
	private JTextField projetPathText;
	private TextArea puck2StdOut;
	private String jarPath;
	private String projectPath;
	private final JFileChooser jarChoser = new JFileChooser();
	private final JFileChooser projectChooser = new JFileChooser();
	private boolean writingDone = false;
	JFrame frame;
	private RunCommand runCommand;

	public GenrationToDisplayMain() {
		setTitle("Display");
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 1024, 554);
		getContentPane().add(scrollPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);

		JPanel panel_conf = new JPanel();
		tabbedPane.addTab("Configuration", null, panel_conf, null);
		panel_conf.setLayout(null);

		jarPathText = new JTextField();
		jarPathText.setBounds(112, 6, 571, 33);
		panel_conf.add(jarPathText);
		jarPathText.setColumns(30);

		JButton jarButton = new JButton("Jar");
		jarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileFilter filter = new FileNameExtensionFilter("jar File", "jar");
				jarChoser.showOpenDialog(GenrationToDisplayMain.this);
				jarChoser.addChoosableFileFilter(filter);
				jarPathText.setText(jarChoser.getSelectedFile().getAbsolutePath());
			}
		});
		jarButton.setBounds(680, 6, 68, 33);
		panel_conf.add(jarButton);

		projetPathText = new JTextField();
		projetPathText.setBounds(112, 44, 571, 33);
		panel_conf.add(projetPathText);
		projetPathText.setColumns(30);

		JButton btnNewButton = new JButton("projet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				projectChooser.showOpenDialog(GenrationToDisplayMain.this);
				projetPathText.setText(projectChooser.getSelectedFile().getAbsolutePath());
			}
		});
		btnNewButton.setBounds(680, 44, 191, 33);
		panel_conf.add(btnNewButton);

		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String jarPath = jarPathText.getText().replaceAll("\"", "\\\\");
					String testFile = projetPathText.getText().replaceAll("\"", "\\\\");
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarPath, testFile);
					pb.redirectErrorStream(true);
					runCommand = new RunCommand(pb);
					runCommand.start();
					while (runCommand.getWriter() == null) {}
					runCommand.sendCommand("saveGraph DependecyGraph.xml");
					while(writingDone == false) {
						System.out.println("Waiting DG xml File");
					}
					init(new String[] {});
					writingDone = false;

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRun.setBounds(731, 89, 90, 28);
		panel_conf.add(btnRun);
		
	    puck2StdOut = new TextArea();
		puck2StdOut.setEditable(false);
		puck2StdOut.setBounds(69, 131, 846, 348);
		panel_conf.add(puck2StdOut);
		
		JButton embeddedJar = new JButton("Embedded Jar");
		embeddedJar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("puck2.jar");
				jarPathText.setText(file.getAbsolutePath());
			}
		});
		embeddedJar.setBounds(748, 6, 123, 33);
		panel_conf.add(embeddedJar);
	}

	public JFrame init(String[] args) {
		// Component
		PSwingCanvas canvas = new PSwingCanvas();

		JButton undo = new JButton("UNDO");
		JButton redo = new JButton("REDO");
		JButton save = new JButton("SAVE-Refactoring Plan");
		JButton execute = new JButton("Execute-Refactoring Plan");
		JButton impor = new JButton("LOAD-refactoring Plan");
		JButton generate = new JButton("Generate code source");
		undo.setSize(40, 40);
		JToolBar toolBar = new JToolBar();
		toolBar.add(undo);
		toolBar.add(redo);
		toolBar.add(save);
		toolBar.add(impor);
		toolBar.add(execute);
		toolBar.add(generate);

		JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(false);

		JTextArea textArear = new JTextArea();
		textArear.setEditable(false);
		textArear.setSize(200, 40);
		textArear.setForeground(Color.RED);
		textArear.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		//textArear.append("- INFO - Les menus des noeuds s'ouvrent et se ferment avec le bouton droit  ");

		toolBar.addSeparator();
		//toolBar.add(textArear);

		// Button action listeners
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateChanger2.getInstance().undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateChanger2.getInstance().redo();
			}
		});
		execute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			File file = new File("RefactoringCommands.xml");
			System.out.println(file.getAbsolutePath());
			runCommand.sendCommand("execPlan "+file.getAbsolutePath()+"\n");
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(canvas) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					if(!file.toString().contains(".xml"))
					file = new File(file.toString() + ".xml");
					RefactoringCommands.getInstance().writeFile(file);
					System.out.println(file.getAbsolutePath());
				}
			}
		});
		
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (fileChooser.showSaveDialog(canvas) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					runCommand.sendCommand("saveCode "+file.getAbsolutePath()+"\n");
				}
			}
		});
		impor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.addChoosableFileFilter(new FileNameExtensionFilter("*.xml", "xml"));
				fc.showDialog(canvas, "select");
				System.out.println(fc.getSelectedFile().getPath());
				ExecuteRefactoringPlan.getInstance().setFilePath(fc.getSelectedFile().getPath());
				ExecuteRefactoringPlan.getInstance().execute();
			}
		});

		
		try {
			if (args.length == 0) {
				System.out.println("Appel de la newDisplayDG sans aucun argument");
				frame = new NewDisplayDG(canvas, "DependecyGraph.xml");
			} else {
				frame = new NewDisplayDG(canvas, args[0]);
			}

			canvas.setPreferredSize(new Dimension(1000, 500));

			// Jframe Container
			Container container = frame.getContentPane();
			container.setLayout(new BorderLayout());
			container.add(canvas, BorderLayout.CENTER);
			container.add(toolBar, BorderLayout.PAGE_START);

			frame.pack();
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setVisible(true);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return frame;
	}

	public static void main(String[] args) {
		JFrame frame = new GenrationToDisplayMain();
		frame.pack();
		frame.setSize(1040, 810);
		frame.setVisible(true);
	}

	public class RunCommand extends Thread {
		private ProcessBuilder processBuilder;
		private Process pro;
		private OutputStream stdin;
		private InputStream stdout;
		private BufferedReader reader;
		private BufferedWriter writer;

		public RunCommand(ProcessBuilder processBuilder) {
			super();
			this.processBuilder = processBuilder;

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
				Scanner scanner = new Scanner(stdout);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					puck2StdOut.append(line +"\n");
					System.out.println(line);
					if (line.trim().equals("DONE")) {
						writingDone = true;
					}
					if (line.trim().contains("DONE:")) {
						String sub = line.substring(line.indexOf(":")+2, line.length());
						String [] split = sub.split(" ");
						if (split.length > 0) 
						((NewDisplayDG)frame).renameNodes(split);
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
}
