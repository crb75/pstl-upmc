package display.piccolo2d;

import modals.piccolo2d.NodeContent;
import modals.piccolo2d.edge;
import modals.piccolo2d.node;

import org.piccolo2d.extras.PFrame;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

import org.piccolo2d.PCamera;
import org.piccolo2d.PCanvas;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.PRoot;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.util.PBounds;
import org.piccolo2d.util.PPaintContext;
import org.w3c.dom.NodeList;

import com.sun.javafx.geom.Edge;

import reader.xml.Reader;
import utilities.piccolo2d.xmlToStructure;

public class displayDg extends PFrame {

	private static final long serialVersionUID = 1L;
	protected Line2D gridLine = new Line2D.Double();
	protected Stroke gridStroke = new BasicStroke(1);
	protected Color gridPaint = Color.BLACK;
	protected double gridSpacing = 20;

	public displayDg() {
		this(null);
	}

	public displayDg(final PCanvas aCanvas) {
		super("displayDg", false, aCanvas);
	}

	public ArrayList<PNode> getPNodes() {
		ArrayList<PNode> listePNode = new ArrayList<>();
//		//PNode p = new PNode();
//		Reader reader = new Reader("./mongraph.xml");
//		NodeList listNode = reader.getAllNodes();
//		for (int i = 1; i <= listNode.getLength(); i++) {
//			PNode p = PPath.createRectangle(0, (i-1)*120, 100, 50);
//			PText text = new PText(reader.getNodeName(i));
//			PText text1 = new PText(reader.getNodeName(i));
//			PText text2 = new PText(reader.getNodeName(i));
//			text.setBounds(p.getX(),p.getY()+30,50,100);
//			text1.setBounds(p.getX(),p.getY()+130,50,100);
//			text2.setBounds(p.getX(),p.getY()+230,50,100);
//			
//			p.addChild(text);
//			p.addChild(text1);
//			p.addChild(text2);
//			PBounds bounds=p.getUnionOfChildrenBounds(null);
//	        p.setBounds(bounds.getX(),bounds.getY(),bounds.getWidth(),bounds.getHeight());
//			listePNode.add(p);
//		}
		HashMap<String, node> listNodes = new xmlToStructure().parseNode();
		for (String key : listNodes.keySet()) {
		    if (listNodes.get(key).getType().equals("package")) {
		    	node packag = listNodes.get(key) ;
		    	PNode p =  PPath.createRectangle(0,0, 100,100);
		    	HashMap<String,edge> relation = packag.getRelation();
		    	for (String idEdge : relation.keySet() ) {
		    		node node = listNodes.get(relation.get(idEdge).getTo());
		    		PNode pnode = new NodeContent( new PText(node.getName())); //PPath.createRectangle(0,0, 100, 100);
		    		//PText nodeName = new PText(node.getName());
		    		//nodeName.setBounds(pnode.getX(),pnode.getY(),nodeName.getWidth(),nodeName.getHeight());
		    		//pnode.addChild(nodeName);
		    		//PBounds bounds=pnode.getUnionOfChildrenBounds(null);
			        //pnode.setBounds(bounds.getX(),bounds.getY(),bounds.getWidth(),bounds.getHeight());
		    		p.addChild(pnode);
		    		PBounds bounds=p.getUnionOfChildrenBounds(null);
			        p.setBounds(bounds.getX(),bounds.getY(),bounds.getWidth(),bounds.getHeight());
				}
		    	listePNode.add(p);
			}
		}
		
		return listePNode;
	}

	public void initialize() {
		final PRoot root = getCanvas().getRoot();
		final PCamera camera = getCanvas().getCamera();
		final PLayer gridLayer = new PLayer() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paint(final PPaintContext paintContext) {
				// make sure grid gets drawn on snap to grid boundaries. And
				// expand a little to make sure that entire view is filled.
				final double bx = getX() - getX() % gridSpacing - gridSpacing;
				final double by = getY() - getY() % gridSpacing - gridSpacing;
				final double rightBorder = getX() + getWidth() + gridSpacing;
				final double bottomBorder = getY() + getHeight() + gridSpacing;

				final Graphics2D g2 = paintContext.getGraphics();
				final Rectangle2D clip = paintContext.getLocalClip();

				g2.setStroke(gridStroke);
				g2.setPaint(gridPaint);

				for (double x = bx; x < rightBorder; x += gridSpacing) {
					gridLine.setLine(x, by, x, bottomBorder);
					if (clip.intersectsLine(gridLine)) {
						g2.draw(gridLine);
					}
				}

				for (double y = by; y < bottomBorder; y += gridSpacing) {
					gridLine.setLine(bx, y, rightBorder, y);
					if (clip.intersectsLine(gridLine)) {
						g2.draw(gridLine);
					}
				}
			}
		};

		// replace standar layer with grid layer.
		root.removeChild(camera.getLayer(0));
		camera.removeLayer(0);
		root.addChild(gridLayer);
		camera.addLayer(gridLayer);

		// add constrains so that grid layers bounds always match cameras view
		// bounds. This makes it look like an infinite grid.
		camera.addPropertyChangeListener(PNode.PROPERTY_BOUNDS, new PropertyChangeListener() {
			public void propertyChange(final PropertyChangeEvent evt) {
				gridLayer.setBounds(camera.getViewBounds());
			}
		});

		camera.addPropertyChangeListener(PCamera.PROPERTY_VIEW_TRANSFORM, new PropertyChangeListener() {
			public void propertyChange(final PropertyChangeEvent evt) {
				gridLayer.setBounds(camera.getViewBounds());
			}
		});

		gridLayer.setBounds(camera.getViewBounds());
		System.out.println(getPNodes().size());
		for (PNode node: getPNodes()) {
			getCanvas().getLayer().addChild(node);

		}
		getCanvas().removeInputEventListener(getCanvas().getPanEventHandler());

		// add a drag event handler that supports snap to grid.
		getCanvas().addInputEventListener(new PDragSequenceEventHandler() {

			protected PNode draggedNode;
			protected Point2D nodeStartPosition;

			protected boolean shouldStartDragInteraction(final PInputEvent event) {
				if (super.shouldStartDragInteraction(event)) {
					return event.getPickedNode() != event.getTopCamera() && !(event.getPickedNode() instanceof PLayer);
				}
				return false;
			}

			protected void startDrag(final PInputEvent event) {
				super.startDrag(event);
				draggedNode = event.getPickedNode();
				draggedNode.raiseToTop();
				nodeStartPosition = draggedNode.getOffset();
			}

			protected void drag(final PInputEvent event) {
				super.drag(event);

				final Point2D start = getCanvas().getCamera()
						.localToView((Point2D) getMousePressedCanvasPoint().clone());
				final Point2D current = event.getPositionRelativeTo(getCanvas().getLayer());
				final Point2D dest = new Point2D.Double();

				dest.setLocation(nodeStartPosition.getX() + current.getX() - start.getX(),
						nodeStartPosition.getY() + current.getY() - start.getY());

				dest.setLocation(dest.getX() - dest.getX() % gridSpacing, dest.getY() - dest.getY() % gridSpacing);

				draggedNode.setOffset(dest.getX(), dest.getY());
			}
		});
	}

	public static void main(final String[] args) {
		new displayDg();
	}
}
