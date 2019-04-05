package puck.gui.item.node;

import java.awt.Paint;
import java.net.URL;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PImage;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

public class NodeContent extends PNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8440846339476909563L;
	private PText text;
	private PImage icon;
	private int margin = 10;
	private String type;

	// region getters/setters
	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public PText getText() {
		return text;
	}

	public void setText(String text) {
		removeChild(this.text);
		this.text = new PText(text);
		addChild(this.text);
		this.text.setBounds(icon.getBounds().getWidth() + margin, 0, this.text.getWidth(), this.text.getHeight());
		// this.text.setBounds(margin,0,this.text.getWidth(),this.text.getHeight());

		PBounds bounds = this.getUnionOfChildrenBounds(null);
		this.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
	}

	public PImage getIcon() {
		return icon;
	}

	// endregion
	public static NodeContent newInstance(NodeContent copy) {
		NodeContent c = new NodeContent((PText)copy.getText().clone(), copy.getType());
		c.setName(copy.getName());
		c.setText(copy.getText().getText());
		return c;
	}

	public void setIcon(PImage icon) {
		this.icon = icon;
	}

	public NodeContent(PText text, String type) {
		this.type = type;
		this.text = text;
		addChild(this.text);
		setImageIcon(type);
		text.setBounds(icon.getBounds().getWidth() + margin, 0, text.getWidth(), text.getHeight());
		PBounds bounds = this.getUnionOfChildrenBounds(null);
		this.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
		// this.text.setBounds(0,0,this.text.getWidth(),this.text.getHeight());
		// PBounds bounds=this.getUnionOfChildrenBounds(null);
		// this.setBounds(bounds.getX(),bounds.getY(),bounds.getWidth(),bounds.getHeight());
	}

	public void setImageIcon(String type) {
		PImage Icon;
		URL url;
		switch (type) {
		case "package":
			url = NodeContent.class.getResource("/package.gif");
			Icon = new PImage(url);
			break;
		case "class":
			url = NodeContent.class.getResource("/class.gif");
			Icon = new PImage(url);
			break;
		case "interface":
			url = NodeContent.class.getResource("/interface.gif");
			Icon = new PImage(url);
			break;
		case "root":
			url = NodeContent.class.getResource("/root.gif");
			Icon = new PImage(url);
			break;
		case "method":
			url = NodeContent.class.getResource("/method.png");
			Icon = new PImage(url);
			break;
		case "attribute":
			url = NodeContent.class.getResource("/field.png");
			Icon = new PImage(url);
			break;
		default:
			url = NodeContent.class.getResource("/question-mark.gif");
			Icon = new PImage(url);
			break;
		}
		this.icon = Icon;
		addChild(Icon);
	}

	public String toString() {
		return text.getText();
	}

	public void rename(String newName) {
		text.setText(newName);
		text.setBounds(icon.getBounds().getWidth() + margin, 0, text.getWidth(), text.getHeight());
		PBounds bounds = this.getUnionOfChildrenBounds(null);
		this.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}