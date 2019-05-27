package tests.controleur.conversion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puck.controleur.conversion.XmlToStructure;

class TestXmlToStructure {

	XmlToStructure xml;
	
	
	@Before
	public void beforeTests() {
		xml = new XmlToStructure("TestFile.xml");
	}
	
	@After
	public void afterTests() {
		xml = null;
	}
	
	
	@Test
	void test() {
	
	}

}
