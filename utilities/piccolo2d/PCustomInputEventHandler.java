package utilities.piccolo2d;

import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.piccolo2d.PCanvas;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;

import arrows.ParrowExtends;
import arrows.ParrowUses;
import nodes.piccolo2d.CustomPNode;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import nodes.piccolo2d.PiccoloCustomNode;

public class PCustomInputEventHandler extends PBasicInputEventHandler {
	private PiccoloCustomNode pnode;
	private PiccoloCustomNode root;
	private PCanvas canvas;
	HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);

	public PCustomInputEventHandler(PiccoloCustomNode pnode,PiccoloCustomNode root, PCanvas canvas, Map<String, PiccoloCustomNode> allPNodes) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;
		this.canvas = canvas;
		this.root = root;
		this.allPNodes = new HashMap<>(allPNodes);
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
				  System.out.println(pnode.getidNode());
				  root.setLayout();
		          root.updateContentBoundingBoxes(false,canvas);
				
				if (aEvent.isRightMouseButton()) {
					System.out.println("droit"+aEvent.getPickedNode().getName());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}