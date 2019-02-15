package puck2.gui.contentFrame;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.display.piccolo2d.NodeToPnodeParser;

import puck2.gui.listener.MousePopupListener;
import puck2.gui.listener.PopupPrintListener;

import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.refactoring.ExecuteRefactoringPlan;
import com.puck.refactoring.RefactoringCommands;
import com.puck.undoRedo.StateChanger;
import com.puck.undoRedo.StateChanger2;
import com.puck.utilities.piccolo2d.XmlToStructure;

@SuppressWarnings("serial")
public class GraphDisplay extends JFrame{

	private HashMap<String, PiccoloCustomNode> allPNodes = new HashMap<>();
	private Map<String, Node> listNodes;
	private PiccoloCustomNode root;
	private MenuList menu;
	private ArrowNodesHolder ANH;
	private MousePopupListener mp ;
	private PopupPrintListener mpp;
	private StateChanger state;
	private StateChanger2 state2;
	private ExecuteRefactoringPlan refactoringPlanExecutor;
	private PSwingCanvas canvas;
	
	public GraphDisplay(PSwingCanvas canvas,String args) throws InterruptedException{
		RefactoringCommands.getInstance().init();
		state2 = StateChanger2.getInstance();
		refactoringPlanExecutor = ExecuteRefactoringPlan.getInstance();
	    mp = new MousePopupListener(menu);
	    mpp = new PopupPrintListener();
		menu = new MenuList();
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
		
		
		
	}
	
}
