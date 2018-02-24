package com.puck.utilities.piccolo2d;




import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;

import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.util.PBounds;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.arrows.Parrow;
import com.puck.menu.Menu;
import com.puck.menu.items.ingoing.CreateEdgesBy;
import com.puck.menu.items.ingoing.CreateEgdesHierarchyBy;
import com.puck.menu.items.ingoing.CreateISAEdgesBy;
import com.puck.menu.items.ingoing.CreateUsesEdgesBy;
import com.puck.menu.items.outgoing.CreateEdgesOf;
import com.puck.menu.items.outgoing.CreateEgdesHierarchyOf;
import com.puck.menu.items.outgoing.CreateISAEdgesOf;
import com.puck.menu.items.outgoing.CreateUsesEdgesOf;
import com.puck.menu.items.removing.RemoveEdgesOf;
import com.puck.menu.items.removing.RemoveISAEdges;
import com.puck.menu.items.removing.RemoveUsesEdges;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;

public class PCustomInputEventHandler extends PBasicInputEventHandler {
	private PiccoloCustomNode pnode;
	private PiccoloCustomNode root;
	private PSwingCanvas canvas;
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Menu menu;
	private JMenuItem createEdgesOf;
	private JMenuItem createEdgesBy;
	private JMenuItem removeEdgesOf;
	private JMenuItem createEgdesHierarchyBy;
	private JMenuItem createEgdesHierarchyOf;
	private Map<String, Node> listNodes;
	private ArrowNodesHolder ANH;

	public PCustomInputEventHandler(PiccoloCustomNode pnode, PiccoloCustomNode root, PSwingCanvas canvas,
			Map<String, PiccoloCustomNode> allPNodes, Menu menu, ArrowNodesHolder ANH, Map<String, Node> listNodes) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;
		this.canvas = canvas;
		this.root = root;
		this.allPNodes = new HashMap<>(allPNodes);
		this.menu = menu;
		this.ANH = ANH;
		this.listNodes = listNodes;
		createEdgesOf = new CreateEdgesOf(pnode, canvas, this.allPNodes, menu,ANH,this.listNodes);
		removeEdgesOf = new RemoveEdgesOf(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		createEdgesBy = new CreateEdgesBy(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		createEgdesHierarchyBy = new CreateEgdesHierarchyBy(pnode, canvas, this.allPNodes, menu,ANH,listNodes);
		createEgdesHierarchyOf = new CreateEgdesHierarchyOf(pnode, canvas, this.allPNodes, menu,ANH,listNodes);

	}

	public PCustomInputEventHandler(PiccoloCustomNode pnode) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;

	}

	@Override
	public void mousePressed(PInputEvent aEvent) {

		try {
			if (aEvent.isLeftMouseButton()) {
				pnode.toggleChildren();
				root.setLayout();
				root.updateContentBoundingBoxes(false, canvas);
				for (Parrow arrow : ANH.getVisibleArrows()) {
					//System.out.println((PiccoloCustomNode) arrow.getTo());
					ANH.updatePosition(arrow);
				}
//				ANH.clearCounters();
//				for (Parrow ar : ANH.getVisibleArrows())
//					if (ar instanceof ParrowDottedFat)
//						ANH.updateCount((ParrowDottedFat) ar);
				//ANH.hide_show_arrows(pnode);
			}
			if (aEvent.isRightMouseButton()) {
					generateMenu(menu,aEvent);				
					canvas.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							if (!menu.getP().getGlobalFullBounds().contains(e.getPoint().getX()+5,e.getPoint().getY()+5))
								menu.hideMenu();	
						}
					});

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void generateMenu(Menu menu,PInputEvent aEvent) {
		menu.removeAll();
		menu.add(createEdgesOf);
		menu.add(createEgdesHierarchyOf);
		menu.addSeparator();
		menu.add(createEdgesBy);
		menu.add(createEgdesHierarchyBy);
		menu.addSeparator();
		menu.add(removeEdgesOf);
		menu.setPoint(aEvent.getPosition());
		menu.setCanvas(canvas);
		menu.drawMenu();
	}
}