package utilities.piccolo2d;

import java.awt.BasicStroke;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;
import org.piccolo2d.extras.nodes.PLine;
import org.piccolo2d.extras.pswing.PSwing;
import org.piccolo2d.extras.pswing.PSwingCanvas;
import org.piccolo2d.nodes.PPath;

import Menu.CreateExtendsEdges;
import Menu.CreateUsesEdges;
import Menu.Menu;
import arrows.ParrowExtends;
import arrows.ParrowUses;
import nodes.piccolo2d.Edge;
import nodes.piccolo2d.Node;
import nodes.piccolo2d.PiccoloCustomNode;
import sun.font.CreatedFontTracker;

public class PCustomInputEventHandler extends PBasicInputEventHandler {
	private PiccoloCustomNode pnode;
	private PiccoloCustomNode root;
	private PSwingCanvas canvas;
	private HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);
	private Menu menu;
	private JMenuItem createUsesEdges;
	private JMenuItem createExtendsEdges;

	public PCustomInputEventHandler(PiccoloCustomNode pnode,PiccoloCustomNode root, PSwingCanvas canvas, Map<String, PiccoloCustomNode> allPNodes,Menu menu) {
		setEventFilter(new PInputEventFilter(InputEvent.BUTTON1_MASK & InputEvent.BUTTON2_MASK));
		this.pnode = pnode;
		this.canvas = canvas;
		this.root = root;
		this.allPNodes = new HashMap<>(allPNodes);
		this.menu = menu;
		createUsesEdges = new CreateUsesEdges(pnode,canvas,this.allPNodes);
		createExtendsEdges = new CreateExtendsEdges(pnode,canvas,this.allPNodes);
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
		          root.updateContentBoundingBoxes(false,canvas);
			}
			if (aEvent.isRightMouseButton()) {
				menu.removeAll();
				menu.add(createUsesEdges);
				menu.add(createExtendsEdges);
				menu.setPoint(aEvent.getPosition());
				menu.setCanvas(canvas);
				menu.drawMenu();
//				PPath line = PPath.createLine(0, 0, 500, 500);
//		        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
//				line.setStroke(dashed);
				//canvas.getLayer().addChild(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}