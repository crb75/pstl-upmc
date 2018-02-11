package nodes.piccolo2d;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.piccolo2d.PCanvas;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

public class hardCodeTestASupprimer {

	public hardCodeTestASupprimer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ArrayList<PiccoloCustomNode> children = new ArrayList<>();
		children.add(new PiccoloCustomNode("Je suis un child 01", "01"));
		children.add(new PiccoloCustomNode("Je suis un child 02", "02"));
		children.add(new PiccoloCustomNode("Je suis un child 03", "03"));
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		testNode.setChilldren(children);
		System.out.println(testNode.getAscendency().size());
	}

}
