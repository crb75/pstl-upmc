package nodes.piccolo2d;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

public class hardCodeTestASupprimer {

	public hardCodeTestASupprimer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/* On crée d'abord le PiccoloCustomNode qu'on va tester*/
		PiccoloCustomNode testNode = new PiccoloCustomNode("Test node", "124548654");
		NodeContent nc = new NodeContent(new PText("Test node"));
		double margin = 10;
        double width=margin+nc.getBounds().getWidth()+margin;
        double height=margin+nc.getBounds().getHeight()+margin;
        /* On crée séparemment un rectangle qu'on va comprer avec les rectangle de testNode */
        PPath rectTest = PPath.createRectangle(0,0,width,height);
		System.out.println(rectTest.equals(testNode.getRect()));
		System.out.println(margin == (testNode.getMargin()));
	}

}
