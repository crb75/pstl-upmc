package puck.gui.window;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.piccolo2d.PCamera;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PMouseWheelZoomEventHandler;
import org.piccolo2d.event.PZoomEventHandler;
import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.controleur.conversion.NodeToPnodeParser;
import puck.controleur.conversion.XmlToStructure;
import puck.controleur.refactoring.ExecuteRefactoringPlan;
import puck.controleur.refactoring.RefactoringCommands;
import puck.controleur.state.StateChanger;
import puck.controleur.state.StateChanger2;
import puck.controleur.user_event.PCustomInputEventHandler;
import puck.controleur.user_event.PCustomMouseWheelZoomEventHandler;
import puck.gui.item.arrow.ArrowNodesHolder;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.item.node.RenameNode;
import puck.gui.menu.Menu;
import puck.modele.Node;


public class NewDisplayDG extends JFrame {
	private HashMap<String, PiccoloCustomNode> allPNodes = new HashMap<>();
	private Map<String, Node> listNodes;
	private PiccoloCustomNode root;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private MousePopupListener mp ;
	private PopupPrintListener mpp;
	private StateChanger state;
	private StateChanger2 state2;
	private ExecuteRefactoringPlan refactoringPlanExecutor;
	private PSwingCanvas canvas;
	private double minScale = 0.5;
	private double maxScale = 5;
	
	private static final long serialVersionUID = 1L;
	   
	public NewDisplayDG(PSwingCanvas canvas,String args) throws InterruptedException{
		RefactoringCommands.getInstance().init();
		state2 = StateChanger2.getInstance();
		refactoringPlanExecutor = ExecuteRefactoringPlan.getInstance();
	    mp = new MousePopupListener();
	    mpp = new PopupPrintListener();
		menu = new Menu();
		listNodes = new XmlToStructure(args).parseNode();
		
		this.canvas = canvas;
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
		state2.init(this.allPNodes, ANH, canvas,root,listNodes,menu,RefactoringCommands.getInstance().getXmlString());
		refactoringPlanExecutor.init(this.allPNodes, ANH, canvas,root,listNodes,menu);
		setMouseWheelHandler(canvas);
		setCam(canvas);
		setScaling(canvas);
		
	}
	
	private void addEvent(PiccoloCustomNode node, PiccoloCustomNode tree,PSwingCanvas canvas,Menu menu,Map<String, Node> listNodes) {
		node.getContent().addInputEventListener(new PCustomInputEventHandler(node, tree, canvas, allPNodes,menu,ANH,listNodes));
		if (node.getAllChildren().size() != 0)
			for (PiccoloCustomNode PCN : node.getAllChildren()) {
				addEvent(PCN, tree,canvas,menu,listNodes);
			}
	}
	
	public void renameNodes(String [] ids) {
		System.out.println(allPNodes.hashCode());
		String newName = allPNodes.get(ids[0].trim()).getName();	
		for (int i = 1; i < ids.length; i++) {
			for(PiccoloCustomNode node : root.getHierarchy()) {
				if (node.getidNode().equals(ids[i].trim())) {
					RenameNode rename = new RenameNode(node, canvas, allPNodes, menu, ANH, listNodes, state);
					rename.renameWithoutStateSaving(newName);
				}
			}
		}
	}
	
	public void setScaling(PSwingCanvas canvas) {
		PZoomEventHandler zoomHandler = canvas.getZoomEventHandler();
		zoomHandler.setMinScale(minScale);
		zoomHandler.setMaxScale(maxScale);
		canvas.setZoomEventHandler(zoomHandler);
	}
	
	public void setCam(PSwingCanvas canvas) {
		PCamera cam = canvas.getCamera();
	//	cam.setViewConstraint(PCamera.VIEW_CONSTRAINT_CENTER);
        cam.scaleView(2.5);
        canvas.setCamera(cam);
	}
	
	public void setMouseWheelHandler(PSwingCanvas canvas) {
		
		PCustomMouseWheelZoomEventHandler mouseWheelHandler = new PCustomMouseWheelZoomEventHandler();

		 mouseWheelHandler.zoomAboutMouse();
		 mouseWheelHandler.setScaleFactor(0.1);
		
		 canvas.addInputEventListener(mouseWheelHandler);	
	}
	
	public void init() {
		
	}

	
	// Listener for Pnode click 
	class MousePopupListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	    	//System.out.println("j'ai detecte click press");
	    
	      checkPopup(e);
	    }

		public void mouseClicked(MouseEvent e) {
	    	//System.out.println("j'ai detecte click click");
		  checkPopup(e);
		 	if(e.getButton() == MouseEvent.BUTTON1) {
				 if(!menu.isHidden()) {
			    	  menu.hide();
			      }
			}
	    }
		
		public void mouseReleased(MouseEvent e) {
	      checkPopup(e);
		}

	    private void checkPopup(MouseEvent e) {
	    	if (e.isPopupTrigger()) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				 if(menu.isHidden()) {
			    	  menu.show();
			      }
				 else {
					 menu.hide();
				 }
			}
	      }
	    }
	    
	  }
	
	class PopupPrintListener implements PopupMenuListener {
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		//	System.out.println("Popup menu will be visible!");
		}

		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		//	System.out.println("Popup menu will be invisible!");
		}

		public void popupMenuCanceled(PopupMenuEvent e) {
		//	System.out.println("Popup menu is hidden!");
		}
	}
	

}