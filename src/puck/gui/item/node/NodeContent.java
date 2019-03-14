package puck.gui.item.node;

import java.awt.Paint;

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
		switch (type) {
		case "package":
			Icon = new PImage("images/package.gif");
			break;
		case "class":
			Icon = new PImage("images/class.gif");
			break;
		case "interface":
			Icon = new PImage("images/interface.gif");
			break;
		case "root":
			Icon = new PImage("images/root.gif");
			break;
		case "method":
			Icon = new PImage("images/method.png");
			break;
		case "attribute":
			Icon = new PImage("images/field.png");
			break;
		default:
			Icon = new PImage("images/question-mark.gif");
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