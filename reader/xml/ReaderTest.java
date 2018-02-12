/**
 * 
 */
package reader.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;

/**
 * @author ky
 *
 */
class ReaderTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link reader.xml.Reader#Reader(java.lang.String)}.
	 */
	@Test
	final void testReader() {
		assertNotNull(new Reader("./mongraph.xml"));
	}

	/**
	 * Test method for {@link reader.xml.Reader#executeBooleanQuery(java.lang.String)}.
	 */
	@Test
	final void testExecuteBooleanQuery() {
		Reader r = new Reader("./mongraph.xml");
		assertEquals(true,r.executeBooleanQuery("//node[2]"));	
	}

	/**
	 * Test method for {@link reader.xml.Reader#getAllNodes()}.
	 */
	@Test
	final void testGetAllNodes() {
		Reader r = new Reader("./mongraph.xml");
		NodeList nl = r.getAllNodes();
		assertNotNull(nl);
		assertEquals(18,nl.getLength());	}

	/**
	 * Test method for {@link reader.xml.Reader#getNbNodes()}.
	 */
	@Test
	final void testGetNbNodes() {
		Reader r = new Reader("./mongraph.xml");
		assertEquals(22, r.getNbEdges());
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNode(int)}.
	 */
	@Test
	final void testGetNode() {
		Reader r = new Reader("./mongraph.xml");
		assertNotNull(r.getNode(1));
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNodeType(int)}.
	 */
	@Test
	final void testGetNodeType() {
		Reader r = new Reader("./mongraph.xml");
		assertEquals("package", r.getNodeType(1));
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNodeId(int)}.
	 */
	@Test
	final void testGetNodeId() {
		Reader r = new Reader("./mongraph.xml");
		assertEquals("p04", r.getNodeId(1));
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNodeName(int)}.
	 */
	@Test
	final void testGetNodeName() {
		Reader r = new Reader("./mongraph.xml");
		assertEquals("unPackageParent", r.getNodeName(1));
	}

	/**
	 * Test method for {@link reader.xml.Reader#getAllEdges()}.
	 */
	@Test
	final void testGetAllEdges() {
		Reader r = new Reader("./mongraph.xml");
		NodeList nl = r.getAllEdges();
		assertNotNull(nl);
		assertEquals(22,nl.getLength());
	}

	/**
	 * Test method for {@link reader.xml.Reader#getNbEdges()}.
	 */
	@Test
	final void testGetNbEdges() {
		Reader r = new Reader("./mongraph.xml");
		assertEquals(18, r.getNbNodes());
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdge(int)}.
	 */
	@Test
	final void testGetEdge() {
		Reader r = new Reader("./mongraph.xml");
		assertNotNull(r.getEdge(1));
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeId(int)}.
	 */
	@Test
	final void testGetEdgeId() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "e01";
	     String actual = r.getEdgeId(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeType(int)}.
	 */
	@Test
	final void testGetEdgeType() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "uses";
	     String actual = r.getEdgeType(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeSource(int)}.
	 */
	@Test
	final void testGetEdgeSource() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "c01";
	     String actual = r.getEdgeSource(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeDestination(int)}.
	 */
	@Test
	final void testGetEdgeDestination() {
	     Reader r = new Reader("./mongraph.xml");
	     String expected = "c02";
	     String actual = r.getEdgeDestination(1);
	     assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link reader.xml.Reader#getEdgeFrom(java.lang.String)}.
	 */
	@Test
	final void testGetEdgeFrom() {
		Reader r = new Reader("./mongraph.xml");
		assertNotNull(r.getEdgeFrom("c01"));
	}

}
