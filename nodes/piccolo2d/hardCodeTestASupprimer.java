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
		String nct1 = "Test";
		NodeContent nc = new NodeContent(new PText(nct1));
		System.out.println(nc.toString());
		String nct2 = "Test 1";
		nc.setText(nct2);
		System.out.println(nc.toString());
	}

}
