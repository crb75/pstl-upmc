package utilities.piccolo2d;

import java.awt.Point;
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
import org.piccolo2d.extras.pswing.PSwing;
import org.piccolo2d.extras.pswing.PSwingCanvas;

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
	HashMap<String, PiccoloCustomNode> allPNodes;
	private Map<String, Node> m = new XmlToStructure().parseNode();
	private HashMap<String, Node> listNodes = new HashMap<>(m);

	public PCustomInputEventHandler(PiccoloCustomNode pnode,PiccoloCustomNode root, PSwingCanvas canvas, Map<String, PiccoloCustomNode> allPNodes) {
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

			}
			if (aEvent.isRightMouseButton()) {
//				System.out.println(pnode.getidNode());
//				createUsesEdges(pnode, canvas);
//				createExtendsEdges(pnode, canvas);
				buildTestButton(pnode, canvas,aEvent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void createExtendsEdges(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		ParrowExtends arrow = null;
		Node node = listNodes.get(pnode.getidNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		System.out.println(node.getId());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("isa")) {
				PiccoloCustomNode dest = allPNodes.get(e.getTo());
				Point2D point = new Point((int) pnode.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (pnode.getRect().getGlobalBounds().getCenter2D().getY()
								+ pnode.getRect().getHeight() / 2));
				Point2D point2 = new Point((int) dest.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (dest.getRect().getGlobalBounds().getCenter2D().getY() + dest.getRect().getHeight() / 2));

				arrow = new ParrowExtends(point, point2);
				canvas.getLayer().addChild(arrow);
				createExtendsEdges(dest, canvas);
			}
		}
	}

	public void createUsesEdges(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		ParrowUses arrow = null;
		Node node = listNodes.get(pnode.getidNode());
		HashMap<String, Edge> relation = new HashMap<>(node.getRelation());
		System.out.println(node.getId());
		for (Entry<String, Edge> edgeEntry : relation.entrySet()) {
			Edge e = edgeEntry.getValue();
			if (e.getType().equals("uses")) {
				PiccoloCustomNode dest = allPNodes.get(e.getTo());
				Point2D point = new Point((int) pnode.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (pnode.getRect().getGlobalBounds().getCenter2D().getY()
								+ pnode.getRect().getHeight() / 2));
				Point2D point2 = new Point((int) dest.getRect().getGlobalBounds().getCenter2D().getX(),
						(int) (dest.getRect().getGlobalBounds().getCenter2D().getY() + dest.getRect().getHeight() / 2));

				arrow = new ParrowUses(point, point2);
				canvas.getLayer().addChild(arrow);
				createUsesEdges(dest, canvas);
			}
		}
	}
	private  void buildTestButton(PiccoloCustomNode pnode, PSwingCanvas canvas,PInputEvent aEvent) {
        final JPopupMenu menu = new JPopupMenu("menu");
        final JMenuItem item = new JMenuItem("uses outgoing ");
        final JMenuItem item2 = new JMenuItem("extends outgoing");
        menu.add(item);
        menu.add(item2);
        
        item.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent arg0) {
            	createUsesEdges(pnode,canvas);
            }
            
        });
        item2.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent arg0) {
            	createExtendsEdges(pnode,canvas);
            }
            
        });
        
        PNode p = new PNode();
        p.addChild(new PSwing(menu));
        p.setOffset(aEvent.getPosition());       
        canvas.getLayer().addChild(p);
    }

}