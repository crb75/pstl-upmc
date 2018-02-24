package com.puck.menu.items.removing;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import org.piccolo2d.PNode;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import com.puck.arrows.ArrowNodesHolder;
import com.puck.arrows.Parrow;
import com.puck.arrows.ParrowUses;
import com.puck.menu.Menu;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.utilities.piccolo2d.XmlToStructure;

public class RemoveUsesEdges extends JMenuItem{
	private PiccoloCustomNode pnode;
	private PSwingCanvas canvas;
	private Menu menu;
	private ArrowNodesHolder ANH;

	public RemoveUsesEdges(PiccoloCustomNode pnode, PSwingCanvas canvas, HashMap<String, PiccoloCustomNode> allPNodes,Menu menu,ArrowNodesHolder ANH) {
		super();
		this.setText("hide uses");
		this.pnode = pnode;
		this.canvas = canvas;
		this.menu = menu;
		this.ANH = ANH;
		addActionListener();
	}
	public void RemoveEdges(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		  Collection<Parrow> arrows =ANH.getVisibleArrows();
		  for (Parrow parrow : arrows) {
			PNode from = parrow.getFrom();
			PNode to = parrow.getTo();
			if (parrow instanceof ParrowUses && (((PiccoloCustomNode)from).getidNode().equals(pnode.getidNode()))||
					((PiccoloCustomNode)to).getidNode().equals(pnode.getidNode()))  {
				ANH.removeArrow(parrow);
			}
		  }
		  this.menu.hideMenu();
	}
	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent arg0) {
            	RemoveEdges(pnode,canvas);
            }    
        });
	}
}
