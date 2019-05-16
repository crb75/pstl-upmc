package tests.gui.plan;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puck.gui.item.node.PiccoloCustomNode;
import puck.gui.plan.RefactoringCommands;

public class TestRefactoringCommands {
	
	RefactoringCommands rc;

	@Before
	public void beforeTests() {
		rc = new RefactoringCommands();
	}
	
	@After
	public void afterTests() {
		rc = null;
	}
	
	
	@Test
	public void testInit() {
		rc.init();
		assertEquals("<?xml version=\"1.0\"?>\n"+"<RefactoringCommands>\n",rc.getXmlString().toString());
	}
	
	@Test
	public void test1NodeToString() {
		PiccoloCustomNode n = new PiccoloCustomNode("test","42","class");
		n.setName("test");
		rc.init();
		rc.nodeToString(n);
		assertEquals("<?xml version=\"1.0\"?>\n"+"<RefactoringCommands>\n"+"\t<Rename id=\"42\" newName=\"test\"/>\n",rc.getXmlString().toString());
	}
	
	
	@Test
	public void test2NodeToString() {
		PiccoloCustomNode n = new PiccoloCustomNode("method()","42","method");
		n.setName("method()");
		rc.init();
		rc.nodeToString(n);
		assertEquals("<?xml version=\"1.0\"?>\n"+"<RefactoringCommands>\n"+"\t<Rename id=\"42\" newName=\"method\"/>\n",rc.getXmlString().toString());
	}
	
	
	@Test
	public void testWriteFile() {
		rc.init();
		File f = new File("test_assets/refact.xml");
		PiccoloCustomNode n = new PiccoloCustomNode("test","42","class");
		n.setName("test");
		rc.nodeToString(n);
		PiccoloCustomNode n1 = new PiccoloCustomNode("method()","15","method");
		n1.setName("methodRename()");
		rc.nodeToString(n1);
		PiccoloCustomNode n2 = new PiccoloCustomNode("rename3","16","class");
		n2.setName("methodRename()");
		rc.nodeToString(n2);
		rc.writeFile(f);
		assertEquals("<?xml version=\"1.0\"?>\n"+"<RefactoringCommands>\n"+
				"\t<Rename id=\"42\" newName=\"test\"/>\n"+
				"\t<Rename id=\"15\" newName=\"methodRename\"/>\n"+
				"</RefactoringCommands>",
				rc.getXmlString().toString());
	}

}
