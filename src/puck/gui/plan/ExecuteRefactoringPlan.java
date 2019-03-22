package puck.gui.plan;

import java.util.HashMap;
import java.util.Map;


import org.piccolo2d.extras.pswing.PSwingCanvas;

import puck.gui.item.arrow.ArrowNodesHolder;
import puck.modele.Node;
import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.item.node.RenameNode;
import puck.gui.menu.Menu;

public class ExecuteRefactoringPlan {

	private String filePath = null;
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;
	private PiccoloCustomNode root;

	private ExecuteRefactoringPlan() {
		super();
	};

	private static ExecuteRefactoringPlan INSTANCE = new ExecuteRefactoringPlan();

	public static ExecuteRefactoringPlan getInstance() {
		return INSTANCE;
	}

	public void init(HashMap<String, PiccoloCustomNode> allPNodes,ArrowNodesHolder ANH,PSwingCanvas canvas,PiccoloCustomNode root,
			Map<String, Node> listNodes, Menu menu) {
		this.allPNodes = allPNodes;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		this.root = root;
	}
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void execute() {
		
		if (filePath != null) {
			PlanReader reader = new PlanReader(filePath);
			int nodeSize = reader.getNbNodesRename();
			for (int i = 1; i <= nodeSize; i++) {
				PiccoloCustomNode pnode = allPNodes.get(reader.getNodeId(i));
				RenameNode renaming = new RenameNode(pnode, canvas, allPNodes, menu, ANH, null, null);
				renaming.rename(reader.getNodeNewName(i));
				//pnode.getContent().rename(reader.getNodeNewName(i));
				//pnode.setName(reader.getNodeNewName(i));
			}
			//root.setLayout();
		}
	}
}
