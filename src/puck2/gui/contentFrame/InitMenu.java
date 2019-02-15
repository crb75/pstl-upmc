package puck2.gui.contentFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.display.piccolo2d.NewDisplayDG;
import com.puck.refactoring.ExecuteRefactoringPlan;
import com.puck.refactoring.RefactoringCommands;
import com.puck.undoRedo.StateChanger2;

import puck2.gui.startmenu.DisplayMenu;

@SuppressWarnings("serial")
public class InitMenu extends JFrame {
	
	private DisplayMenu displayMenu;
	
	public InitMenu(DisplayMenu displayMenu) {
		this.displayMenu = displayMenu;
	}

	public JFrame init(String [] args) {
		
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
			displayMenu.getRunCommand().sendCommand("execPlan "+file.getAbsolutePath()+"\n");
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
					displayMenu.getRunCommand().sendCommand("saveCode "+file.getAbsolutePath()+"\n");
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
				displayMenu.frame = new NewDisplayDG(canvas, "DependecyGraph.xml");
			} else {
				displayMenu.frame = new NewDisplayDG(canvas, args[0]);
			}

			canvas.setPreferredSize(new Dimension(1000, 500));

			// Jframe Container
			Container container = displayMenu.frame.getContentPane();
			container.setLayout(new BorderLayout());
			container.add(canvas, BorderLayout.CENTER);
			container.add(toolBar, BorderLayout.PAGE_START);

			displayMenu.frame.pack();
			displayMenu.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			displayMenu.frame.setVisible(true);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return displayMenu.frame;
	}

	}
