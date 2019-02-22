package test.gui.item.node;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestXmlToDisplay {
	private ArrayList<String> list1 = new ArrayList<>();
	private ArrayList<String> list2 = new ArrayList<>();

	@Before
	public void BeforeTest() {
		String xml1 = XmlToString("DependecyGraph.xml", list1);
		String xml2 = XmlToString("xmlFromDisplay.xml", list2);

	}

	@Test
	public void testSize() {
		assertTrue(list1.size() == list2.size());
	}

	@Test
	public void testContent() {
		for (String entry : list1) {
			if (list2.contains(entry)) {
				list2.remove(entry);
			}else {
				System.out.println("xmlFormDisplay.xml ne contien pas :" + entry + "\n");
			}
		}
		assertTrue(list2.size() == 0);
	}

	public String XmlToString(String name, ArrayList<String> list) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));
			String line;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!line.equals("")) {
					list.add(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
