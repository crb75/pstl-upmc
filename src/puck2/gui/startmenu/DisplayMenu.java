package puck2.gui.startmenu;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import puck2.gui.contentFrame.InitMenu;

//A FAIRE : utiliser le design pattern factory pour la création de JButton
//			améliorer l'agencement des éléments dans le JFrame ( se débarasser des constantes et préférer l'adaptation à l'écran)

@SuppressWarnings("serial")
public class DisplayMenu extends JFrame{
	
	private JTextField jarPathText;
	private JTextField projetPathText;
	private TextArea puck2StdOut;
	private String jarPath;
	private String projectPath;
	public JFrame frame;
	private RunCommand runCommand;

	
	private final JFileChooser jarChoser = new JFileChooser();
	private final JFileChooser projectChooser = new JFileChooser();
	private boolean writingDone = false;

	
	public DisplayMenu() {
		setTitle("Display");
		
		JScrollPane scrollPane = createJScrollPane();
		JTabbedPane tabbedPane = createJTabbedPane(JTabbedPane.TOP);
		JPanel panel_conf = new JPanel();
		JButton jarButton = createJarButton();
		JButton btnNewButton = createNewButton();
		JButton btnRun = createRunButton();
		JButton embeddedJar = createEmbeddedButton();
		setDisplayMenu(scrollPane,tabbedPane,panel_conf,jarButton,btnNewButton,btnRun,embeddedJar);
		
	}
	
	// METHODE POUR CREER LES ELEMENTS DU JFRAME
	
	private JScrollPane createJScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 1024, 554);
		return scrollPane;
	}
	
	private JTabbedPane createJTabbedPane(int param) {
		return new JTabbedPane(param);
	}
	
	private JButton createJarButton() {
		JButton jarButton = new JButton("Jar");
			jarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FileFilter filter = new FileNameExtensionFilter("jar File", "jar");
					jarChoser.showOpenDialog(DisplayMenu.this);
					jarChoser.addChoosableFileFilter(filter);
					jarPathText.setText(jarChoser.getSelectedFile().getAbsolutePath());
				}
			});
		return jarButton;
	}
	
	private JButton createNewButton() {
		JButton btnNewButton = new JButton("projet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				projectChooser.showOpenDialog(DisplayMenu.this);
				projetPathText.setText(projectChooser.getSelectedFile().getAbsolutePath());
			}
		});
		return btnNewButton;
	}
	
	private JButton createRunButton() {
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String jarPath = jarPathText.getText().replaceAll("\"", "\\\\");
					String testFile = projetPathText.getText().replaceAll("\"", "\\\\");
					ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarPath, testFile);
					pb.redirectErrorStream(true);
					runCommand = new RunCommand(pb,DisplayMenu.this);
					runCommand.start();
					while (runCommand.getWriter() == null) {}
					runCommand.sendCommand("saveGraph DependecyGraph.xml");
					while(writingDone == false) {
						System.out.println("Waiting DG xml File");
					}
					new InitMenu(DisplayMenu.this).init(new String[] {});
					writingDone = false;

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		return btnRun;
	}
	
	private JButton createEmbeddedButton() {
		JButton embeddedJar = new JButton("Embedded Jar");
		embeddedJar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("puck2.jar");
				jarPathText.setText(file.getAbsolutePath());
			}
		});
		return embeddedJar;
	}
	
	//METHODE POUR AGENCEMENT 
	
	private void setDisplayMenu(JScrollPane scrollPane, JTabbedPane tabbedPane, JPanel panel_conf,
			JButton jarButton,JButton btnNewButton,JButton btnRun,JButton embeddedJar) {
		getContentPane().setLayout(null);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(tabbedPane);
		tabbedPane.addTab("Configuration", null, panel_conf, null);
		panel_conf.setLayout(null);
		jarPathText = new JTextField();
		jarPathText.setBounds(112, 6, 571, 33);
		panel_conf.add(jarPathText);
		jarPathText.setColumns(30);
		jarButton.setBounds(680, 6, 68, 33);
		panel_conf.add(jarButton);
		projetPathText = new JTextField();
		projetPathText.setBounds(112, 44, 571, 33);
		panel_conf.add(projetPathText);
		projetPathText.setColumns(30);
		btnNewButton.setBounds(680, 44, 191, 33);
		panel_conf.add(btnNewButton);
		btnRun.setBounds(731, 89, 90, 28);
		panel_conf.add(btnRun);
	    puck2StdOut = new TextArea();
		puck2StdOut.setEditable(false);
		puck2StdOut.setBounds(69, 131, 846, 348);
		panel_conf.add(puck2StdOut);
		embeddedJar.setBounds(748, 6, 123, 33);
		panel_conf.add(embeddedJar);
	}

	//GETTERS AND SETTERS
	
	public JTextField getJarPathText() {
		return jarPathText;
	}

	public void setJarPathText(JTextField jarPathText) {
		this.jarPathText = jarPathText;
	}

	public JTextField getProjetPathText() {
		return projetPathText;
	}

	public void setProjetPathText(JTextField projetPathText) {
		this.projetPathText = projetPathText;
	}

	public TextArea getPuck2StdOut() {
		return puck2StdOut;
	}

	public void setPuck2StdOut(TextArea puck2StdOut) {
		this.puck2StdOut = puck2StdOut;
	}

	public String getJarPath() {
		return jarPath;
	}

	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public RunCommand getRunCommand() {
		return runCommand;
	}

	public void setRunCommand(RunCommand runCommand) {
		this.runCommand = runCommand;
	}

	public boolean isWritingDone() {
		return writingDone;
	}

	public void setWritingDone(boolean writingDone) {
		this.writingDone = writingDone;
	}

	public JFileChooser getJarChoser() {
		return jarChoser;
	}

	public JFileChooser getProjectChooser() {
		return projectChooser;
	}
	
	
	
	
	
}
