package puck.gui.startMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import puck.gui.frame.NewDisplayDG;
import puck.gui.plan.ExecuteRefactoringPlan;
import puck.gui.plan.RefactoringCommands;
import puck.gui.state.StateChanger2;

import java.awt.TextArea;
import java.awt.Button;

@SuppressWarnings("serial")
public class GenerationToDisplay extends JFrame {
	private JTextField jarPathText, projetPathText;
	private TextArea puck2StdOut;
	private String jarPath, projectPath;
	private final JFileChooser jarChoser = new JFileChooser();
	private final JFileChooser projectChooser = new JFileChooser();
	private boolean writingDone = false;
	JFrame frame;
	private RunCommand runCommand;
	private Thread display;

	public GenerationToDisplay() {
		setTitle("Display");
		getContentPane().setLayout(null);
		JScrollPane scrollPane = createScrollPane();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel_conf = new JPanel();
		JButton jarButton = createJarButton();
		JButton btnRun = createRunButton();
		JButton btnNewButton = createProjectButton();
		JButton embeddedJar = createEmbeddedJarButton();
		setJarPathText();
		setProjetPathText();
		setPuck2toStdOut();
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(tabbedPane);
		tabbedPane.addTab("Configuration", null, panel_conf, null);
		panel_conf.setLayout(null);
		panel_conf.add(jarPathText);
		panel_conf.add(jarButton);
		panel_conf.add(projetPathText);
		btnNewButton.setBounds(680, 44, 191, 33);
		panel_conf.add(btnNewButton);
		panel_conf.add(btnRun);
		panel_conf.add(puck2StdOut);
		panel_conf.add(embeddedJar);
	}
	
	public JScrollPane createScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 1024, 554);
		return scrollPane;
	}
	
	public JButton createJarButton() {
		JButton jarButton = new JButton("Jar");
		jarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileFilter filter = new FileNameExtensionFilter("jar File", "jar");
				jarChoser.showOpenDialog(GenerationToDisplay.this);
				jarChoser.addChoosableFileFilter(filter);
				jarPathText.setText(jarChoser.getSelectedFile().getAbsolutePath());
			}
		});
		jarButton.setBounds(680, 6, 68, 33);
		return jarButton;
	}
	
	public void setPuck2toStdOut() {
		puck2StdOut = new TextArea();
		puck2StdOut.setEditable(false);
		puck2StdOut.setBounds(69, 131, 846, 348);
	}

	
	public JButton createRunButton() {
		JButton btnRun = new JButton("Run");

		
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				try {
				    display = null;
					String jarPath = jarPathText.getText().replaceAll("\"", "\\\\");
					String testFile = projetPathText.getText().replaceAll("\"", "\\\\");
					
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarPath, testFile);
					System.out.println();
					pb.redirectErrorStream(true);
					runCommand = new RunCommand(pb);
					display = new Thread(runCommand);
					display.start();
					while (runCommand.getWriter() == null) {

                    } //attente active
					runCommand.sendCommand("saveGraph DependecyGraph.xml");
					while(!writingDone) {
						Thread.sleep(1000);
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
		return btnRun;
	}
	
	public JButton createProjectButton() {
		JButton btnNewButton = new JButton("Projet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				projectChooser.showOpenDialog(GenerationToDisplay.this);
				projetPathText.setText(projectChooser.getSelectedFile().getAbsolutePath());
			}
		});
		return btnNewButton;
	}
	
	public JButton createEmbeddedJarButton() {
		JButton embeddedJar = new JButton("Embedded Jar");
		embeddedJar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("puck2.jar");
				jarPathText.setText(file.getAbsolutePath());
			}
		});
		embeddedJar.setBounds(748, 6, 123, 33);
		return embeddedJar;
	}
	
	public void setJarPathText() {
		jarPathText = new JTextField();
		jarPathText.setBounds(112, 6, 571, 33);
		jarPathText.setColumns(30);
	}

	
	public void setProjetPathText() {
		projetPathText = new JTextField();
		projetPathText.setBounds(112, 44, 571, 33);
		projetPathText.setColumns(30);
	}
	
	
	
	//INIT LE FRAME POUR AFFICHER LE GRAPHE
	
	
	public JFrame init(String[] args) {
		// Component
		PSwingCanvas canvas = new PSwingCanvas();
		JButton undo = new JButton("UNDO");
		JButton redo = new JButton("REDO");
		JButton save = new JButton("SAVE-Refactoring Plan");
		JButton execute = new JButton("Execute-Refactoring Plan");
		JButton impor = new JButton("LOAD-refactoring Plan");
		JButton generate = new JButton("Generate code source");
		JTextArea textArear = new JTextArea();
		JToolBar toolBar = new JToolBar();
		JFileChooser fc = new JFileChooser();
		undo.setSize(40, 40);
		toolBar.add(undo);
		toolBar.add(redo);
		toolBar.add(save);
		toolBar.add(impor);
		toolBar.add(execute);
		toolBar.add(generate);
		fc.setMultiSelectionEnabled(false);
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
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			
			frame.addWindowListener(new WindowAdapter() {
				@Override
	            public void windowClosing(WindowEvent e)
	            {
	                System.out.println("fenetre fermee");
					display=null;
					runCommand.end();
	            }
			});

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return frame;
	}
	
	

	public class RunCommand implements Runnable {
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
				pro =  processBuilder.start();
				stdin = pro.getOutputStream();
				stdout = pro.getInputStream();
				reader = new BufferedReader(new InputStreamReader(stdout));
				writer = new BufferedWriter(new OutputStreamWriter(stdin));
				sendCommand("display\n");
				Scanner scanner = new Scanner(stdout);
				while (scanner.hasNextLine()) { //lit le fichier xml ligne par ligne
					String line = scanner.nextLine();
					puck2StdOut.append(line +"\n"); //écrit sur l'entrée de sortie (le rectangle du menu)
					//System.out.println(line);
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
			
			
		}
		

		public void end() {
			pro.destroyForcibly();
			reader = null;
			writer = null;
			stdin = null;
			stdout = null;
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
		
		public Process getPro() {
			return this.pro;
		}

		public ProcessBuilder getProcessBuilder() {
			return processBuilder;
		}

		public void setProcessBuilder(ProcessBuilder processBuilder) {
			this.processBuilder = processBuilder;
		}

		public OutputStream getStdin() {
			return stdin;
		}

		public void setStdin(OutputStream stdin) {
			this.stdin = stdin;
		}

		public InputStream getStdout() {
			return stdout;
		}

		public void setStdout(InputStream stdout) {
			this.stdout = stdout;
		}

		public void setPro(Process pro) {
			this.pro = pro;
		}

		public void setReader(BufferedReader reader) {
			this.reader = reader;
		}

		public void setWriter(BufferedWriter writer) {
			this.writer = writer;
		}

	}
}
