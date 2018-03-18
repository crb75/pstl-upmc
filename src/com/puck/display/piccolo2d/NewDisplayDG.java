package com.puck.display.piccolo2d;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.util.PPaintContext;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.menu.Menu;
import com.puck.nodes.piccolo2d.Edge;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.reader.xml.test.TestXmlDisplay;
import com.puck.utilities.piccolo2d.PCustomInputEventHandler;
import com.puck.utilities.piccolo2d.XmlToStructure;

public class NewDisplayDG extends JFrame {
	private HashMap<String, PiccoloCustomNode> allPNodes = new HashMap<>();
	private Map<String, Node> listNodes;
	private PiccoloCustomNode root;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private MousePopupListener mp ;
	private PopupPrintListener mpp;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewDisplayDG(PSwingCanvas canvas,String args) throws InterruptedException{
	    mp = new MousePopupListener();
	    mpp = new PopupPrintListener();
		menu = new Menu();
		listNodes = new XmlToStructure(args).parseNode();
		NodeToPnodeParser nodesToPnodes = new NodeToPnodeParser(allPNodes, listNodes);
		root = nodesToPnodes.getPackageNodes();
		root.collapseAll();
		this.ANH =  new ArrowNodesHolder();
		addEvent(root, root,canvas,menu,listNodes);
		canvas.getLayer().addChild(root);
		canvas.getLayer().addChild(ANH);
		canvas.addMouseListener(mp);
		canvas.setAutoscrolls(false);
		menu.addPopupMenuListener(mpp);
		
		
		//TestXmlDisplay testXml = new TestXmlDisplay(allPNodes,root);
		
		
	}
	
	private void addEvent(PiccoloCustomNode node, PiccoloCustomNode tree,PSwingCanvas canvas,Menu menu,Map<String, Node> listNodes) {
		node.getContent().addInputEventListener(new PCustomInputEventHandler(node, tree, canvas, allPNodes,menu,ANH,listNodes));
		if (node.getAllChildren().size() != 0)
			for (PiccoloCustomNode PCN : node.getAllChildren()) {
				addEvent(PCN, tree,canvas,menu,listNodes);
			}
	}

	
	public static void main(String[] args) {
		PSwingCanvas canvas = new PSwingCanvas();
		JTextArea textArear = new JTextArea();
		textArear.setEditable(false);
		textArear.setSize(200, 40);
		textArear.setForeground(Color.RED);
		textArear.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		textArear.append("- INFO - Les menus des noeuds s'ouvrent et se ferment avec le bouton droit  ");
		JFrame frame;
		try {
			if (args.length == 0)
			{
				System.out.println("Appel de la newDisplayDG sans aucun argument");
				frame = new NewDisplayDG(canvas, "mongraph.xml");
			}
			else
			{
				frame = new NewDisplayDG(canvas,args[0]);	
			}
		canvas.setDefaultRenderQuality(PPaintContext.HIGH_QUALITY_RENDERING);
        canvas.setAnimatingRenderQuality(PPaintContext.HIGH_QUALITY_RENDERING);
        canvas.setInteractingRenderQuality(PPaintContext.HIGH_QUALITY_RENDERING);
        canvas.setZoomEventHandler(null);
        //canvas.setPanEventHandler(null);
        //canvas.addInputEventListener(new PDragEventHandler());
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(canvas, BorderLayout.CENTER);
		container.add(textArear,BorderLayout.PAGE_START);
		canvas.setPreferredSize(new Dimension(1000, 500));
		frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

	}
	class MousePopupListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	    //	System.out.println("j'ai detecte click press");
	      checkPopup(e);
	    }

	    public void mouseClicked(MouseEvent e) {
	    //	System.out.println("j'ai detecte click click");
	      checkPopup(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	      checkPopup(e);
	    }

	    private void checkPopup(MouseEvent e) {
	      if (e.isPopupTrigger()) {
	    	 if (menu.isHidden()) {
	    		 menu.show();
			 }else {
				 menu.hide();
			 }
	    		 
		
	      }
	    }
	  }
	class PopupPrintListener implements PopupMenuListener {
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			System.out.println("Popup menu will be visible!");
		}

		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			System.out.println("Popup menu will be invisible!");
		}

		public void popupMenuCanceled(PopupMenuEvent e) {
			System.out.println("Popup menu is hidden!");
		}
	}

}