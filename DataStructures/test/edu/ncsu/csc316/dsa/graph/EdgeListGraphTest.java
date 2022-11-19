package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test class for EdgeListGraph Checks the expected outputs of the Graph
 * abstract data type behaviors when using an edge list graph data structure
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class EdgeListGraphTest {
	/** The tester undirected graph for testing. */
	private Graph<String, Integer> undirectedGraph;
	/** The tester directed graph for testing. */
	private Graph<String, Integer> directedGraph;

	/**
	 * Create a new instance of an edge list graph before each test case executes
	 */
	@Before
	public void setUp() {
		undirectedGraph = new EdgeListGraph<String, Integer>();
		directedGraph = new EdgeListGraph<String, Integer>(true);
	}

	private void buildUndirectedSample() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");

		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);
	}

	private void buildDirectedSample() {
		Vertex<String> v1 = directedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = directedGraph.insertVertex("Asheville");
		Vertex<String> v3 = directedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = directedGraph.insertVertex("Durham");
		Vertex<String> v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");

		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);
	}

	/**
	 * Test the output of the numVertices() behavior
	 */
	@Test
	public void testNumVertices() {
		buildUndirectedSample();
		assertEquals(5, undirectedGraph.numVertices());

		buildDirectedSample();
		assertEquals(6, directedGraph.numVertices());
	}

	/**
	 * Test the output of the vertices() behavior
	 */
	@Test
	public void testVertices() {
		// We cannot call buildUndirectedSample() because
		// then we would not be able to reference specific edges
		// or vertices when testing
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
		
		assertEquals(v1.getElement(), it.next().getElement());
		assertEquals(v2.getElement(), it.next().getElement());
		assertEquals(v3.getElement(), it.next().getElement());
		assertEquals(v4.getElement(), it.next().getElement());
		assertEquals(v5.getElement(), it.next().getElement());

		// DIRECTED
		// We cannot call buildDirectedSample() because
		// then we would not be able to reference specific edges
		// or vertices when testing
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		Iterator<Vertex<String>> it2 = directedGraph.vertices().iterator();
		
		assertEquals(v1.getElement(), it2.next().getElement());
		assertEquals(v2.getElement(), it2.next().getElement());
		assertEquals(v3.getElement(), it2.next().getElement());
		assertEquals(v4.getElement(), it2.next().getElement());
		assertEquals(v5.getElement(), it2.next().getElement());
		assertEquals(v6.getElement(), it2.next().getElement());
	}

	/**
	 * Test the output of the numEdges() behavior
	 */
	@Test
	public void testNumEdges() {
		buildUndirectedSample();
		assertEquals(10, undirectedGraph.numEdges());

		buildDirectedSample();
		assertEquals(11, directedGraph.numEdges());
	}

	/**
	 * Test the output of the edges() behavior
	 */
	@Test
	public void testEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		
		assertEquals(e1.getElement(), it.next().getElement());
		assertEquals(e2.getElement(), it.next().getElement());
		assertEquals(e3.getElement(), it.next().getElement());
		assertEquals(e4.getElement(), it.next().getElement());
		assertEquals(e5.getElement(), it.next().getElement());
		assertEquals(e6.getElement(), it.next().getElement());
		assertEquals(e7.getElement(), it.next().getElement());
		assertEquals(e8.getElement(), it.next().getElement());
		assertEquals(e9.getElement(), it.next().getElement());
		assertEquals(e10.getElement(), it.next().getElement());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		it = directedGraph.edges().iterator();
		
		assertEquals(e1.getElement(), it.next().getElement());
		assertEquals(e2.getElement(), it.next().getElement());
		assertEquals(e3.getElement(), it.next().getElement());
		assertEquals(e4.getElement(), it.next().getElement());
		assertEquals(e5.getElement(), it.next().getElement());
		assertEquals(e6.getElement(), it.next().getElement());
		assertEquals(e7.getElement(), it.next().getElement());
		assertEquals(e8.getElement(), it.next().getElement());
		assertEquals(e9.getElement(), it.next().getElement());
		assertEquals(e10.getElement(), it.next().getElement());
		assertEquals(e11.getElement(), it.next().getElement());
	}

	/**
	 * Test the output of the getEdge(v1,v2) behavior
	 */
	@Test
	public void testGetEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(e1, undirectedGraph.getEdge(v1, v2));
		assertEquals(e2, undirectedGraph.getEdge(v1, v3));
		assertEquals(e3, undirectedGraph.getEdge(v1, v4));
		assertEquals(e4, undirectedGraph.getEdge(v1, v5));
		assertEquals(e5, undirectedGraph.getEdge(v2, v3));
		assertEquals(e6, undirectedGraph.getEdge(v2, v4));
		assertEquals(e7, undirectedGraph.getEdge(v2, v5));
		assertEquals(e8, undirectedGraph.getEdge(v3, v4));
		assertEquals(e9, undirectedGraph.getEdge(v3, v5));
		assertEquals(e10, undirectedGraph.getEdge(v4, v5));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(e1, directedGraph.getEdge(v1, v2));
		assertEquals(e2, directedGraph.getEdge(v1, v3));
		assertEquals(e3, directedGraph.getEdge(v1, v4));
		assertEquals(e4, directedGraph.getEdge(v1, v5));
		assertEquals(e5, directedGraph.getEdge(v2, v3));
		assertEquals(e6, directedGraph.getEdge(v2, v4));
		assertEquals(e7, directedGraph.getEdge(v2, v5));
		assertEquals(e8, directedGraph.getEdge(v3, v4));
		assertEquals(e9, directedGraph.getEdge(v3, v5));
		assertEquals(e10, directedGraph.getEdge(v4, v5));
		assertEquals(e11, directedGraph.getEdge(v5, v6));
	}

	/**
	 * Test the output of the endVertices(e) behavior
	 */
	@Test
	public void testEndVertices() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		Vertex<String>[] va = undirectedGraph.endVertices(e1);
		assertEquals(v1, va[0]);
		assertEquals(v2, va[1]);
		
		va = undirectedGraph.endVertices(e2);
		assertEquals(v1, va[0]);
		assertEquals(v3, va[1]);
		
		va = undirectedGraph.endVertices(e3);
		assertEquals(v1, va[0]);
		assertEquals(v4, va[1]);
		
		va = undirectedGraph.endVertices(e4);
		assertEquals(v1, va[0]);
		assertEquals(v5, va[1]);
		
		va = undirectedGraph.endVertices(e5);
		assertEquals(v2, va[0]);
		assertEquals(v3, va[1]);
		
		va = undirectedGraph.endVertices(e6);
		assertEquals(v2, va[0]);
		assertEquals(v4, va[1]);
		
		va = undirectedGraph.endVertices(e7);
		assertEquals(v2, va[0]);
		assertEquals(v5, va[1]);
		
		va = undirectedGraph.endVertices(e8);
		assertEquals(v3, va[0]);
		assertEquals(v4, va[1]);
		
		va = undirectedGraph.endVertices(e9);
		assertEquals(v3, va[0]);
		assertEquals(v5, va[1]);
		
		va = undirectedGraph.endVertices(e10);
		assertEquals(v4, va[0]);
		assertEquals(v5, va[1]);

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		va = directedGraph.endVertices(e1);
		assertEquals(v1, va[0]);
		assertEquals(v2, va[1]);
		
		va = directedGraph.endVertices(e2);
		assertEquals(v1, va[0]);
		assertEquals(v3, va[1]);
		
		va = directedGraph.endVertices(e3);
		assertEquals(v1, va[0]);
		assertEquals(v4, va[1]);
		
		va = directedGraph.endVertices(e4);
		assertEquals(v1, va[0]);
		assertEquals(v5, va[1]);
		
		va = directedGraph.endVertices(e5);
		assertEquals(v2, va[0]);
		assertEquals(v3, va[1]);
		
		va = directedGraph.endVertices(e6);
		assertEquals(v2, va[0]);
		assertEquals(v4, va[1]);
		
		va = directedGraph.endVertices(e7);
		assertEquals(v2, va[0]);
		assertEquals(v5, va[1]);
		
		va = directedGraph.endVertices(e8);
		assertEquals(v3, va[0]);
		assertEquals(v4, va[1]);
		
		va = directedGraph.endVertices(e9);
		assertEquals(v3, va[0]);
		assertEquals(v5, va[1]);
		
		va = directedGraph.endVertices(e10);
		assertEquals(v4, va[0]);
		assertEquals(v5, va[1]);
		
		va = directedGraph.endVertices(e11);
		assertEquals(v5, va[0]);
		assertEquals(v6, va[1]);
	}

	/**
	 * Test the output of the opposite(v, e) behavior
	 */
	@Test
	public void testOpposite() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(v2, undirectedGraph.opposite(v1, e1));
		assertEquals(v3, undirectedGraph.opposite(v1, e2));
		assertEquals(v4, undirectedGraph.opposite(v1, e3));
		assertEquals(v5, undirectedGraph.opposite(v1, e4));
		assertEquals(v3, undirectedGraph.opposite(v2, e5));
		assertEquals(v4, undirectedGraph.opposite(v2, e6));
		assertEquals(v5, undirectedGraph.opposite(v2, e7));
		assertEquals(v4, undirectedGraph.opposite(v3, e8));
		assertEquals(v5, undirectedGraph.opposite(v3, e9));
		assertEquals(v5, undirectedGraph.opposite(v4, e10));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(v2, directedGraph.opposite(v1, e1));
		assertEquals(v3, directedGraph.opposite(v1, e2));
		assertEquals(v4, directedGraph.opposite(v1, e3));
		assertEquals(v5, directedGraph.opposite(v1, e4));
		assertEquals(v3, directedGraph.opposite(v2, e5));
		assertEquals(v4, directedGraph.opposite(v2, e6));
		assertEquals(v5, directedGraph.opposite(v2, e7));
		assertEquals(v4, directedGraph.opposite(v3, e8));
		assertEquals(v5, directedGraph.opposite(v3, e9));
		assertEquals(v5, directedGraph.opposite(v4, e10));
		assertEquals(v5, directedGraph.opposite(v6, e11));
	}

	/**
	 * Test the output of the outDegree(v) behavior
	 */
	@Test
	public void testOutDegree() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(4, undirectedGraph.outDegree(v1));
		assertEquals(4, undirectedGraph.outDegree(v2));
		assertEquals(4, undirectedGraph.outDegree(v3));
		assertEquals(4, undirectedGraph.outDegree(v4));
		assertEquals(4, undirectedGraph.outDegree(v5));
		assertEquals(0, undirectedGraph.outDegree(v6));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		assertEquals(4, directedGraph.outDegree(v1));
		assertEquals(3, directedGraph.outDegree(v2));
		assertEquals(2, directedGraph.outDegree(v3));
		assertEquals(1, directedGraph.outDegree(v4));
		assertEquals(1, directedGraph.outDegree(v5));
		assertEquals(0, directedGraph.outDegree(v6));
	}

	/**
	 * Test the output of the inDegree(v) behavior
	 */
	@Test
	public void testInDegree() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(4, undirectedGraph.inDegree(v1));
		assertEquals(4, undirectedGraph.inDegree(v2));
		assertEquals(4, undirectedGraph.inDegree(v3));
		assertEquals(4, undirectedGraph.inDegree(v4));
		assertEquals(4, undirectedGraph.inDegree(v5));
		assertEquals(0, undirectedGraph.inDegree(v6));

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		assertEquals(0, directedGraph.inDegree(v1));
		assertEquals(1, directedGraph.inDegree(v2));
		assertEquals(2, directedGraph.inDegree(v3));
		assertEquals(3, directedGraph.inDegree(v4));
		assertEquals(4, directedGraph.inDegree(v5));
		assertEquals(1, directedGraph.inDegree(v6));
	}

	/**
	 * Test the output of the outgoingEdges(v) behavior
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testOutgoingEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		// We can use a custom arrayContains() helper method to check that
		// an array *contains* a certain target edge.
		// This is helpful for testing graph ADT behaviors where an order
		// of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges
		// in adjacencyMaps, etc.)
		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[4]);
		int count = 0;
		Iterator<Edge<Integer>> it = undirectedGraph.outgoingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));
		
		count = 0;
		it = undirectedGraph.outgoingEdges(v2).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e7));

		count = 0;
		it = undirectedGraph.outgoingEdges(v3).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e9));
		assertTrue(arrayContains(temp, e5));
		
		count = 0;
		it = undirectedGraph.outgoingEdges(v4).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e10));
		
		count = 0;
		it = undirectedGraph.outgoingEdges(v5).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e4));
		assertTrue(arrayContains(temp, e7));
		assertTrue(arrayContains(temp, e9));
		assertTrue(arrayContains(temp, e10));
		
		count = 0;
		it = undirectedGraph.outgoingEdges(v6).iterator();
		assertFalse(it.hasNext());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
		
		count = 0;
		it = directedGraph.outgoingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));
		
		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.outgoingEdges(v2).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e7));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.outgoingEdges(v3).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e9));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.outgoingEdges(v4).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e10));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.outgoingEdges(v5).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e11));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.outgoingEdges(v6).iterator();
		assertFalse(it.hasNext());
	}

	// Helper method to check that an array contains a certain target.
	// This is helpful for testing graph ADT behaviors where an order
	// of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges)
	private boolean arrayContains(Edge<Integer>[] temp, Edge<Integer> target) {
		for (Edge<Integer> e : temp) {
			if (e == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Test the output of the incomingEdges(v) behavior
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIncomingEdges() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		Edge<Integer>[] temp = (Edge<Integer>[]) (new Edge[4]);
		int count = 0;
		Iterator<Edge<Integer>> it = undirectedGraph.incomingEdges(v1).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e4));
		
		count = 0;
		it = undirectedGraph.incomingEdges(v2).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));
		assertTrue(arrayContains(temp, e5));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e7));

		count = 0;
		it = undirectedGraph.incomingEdges(v3).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e9));
		assertTrue(arrayContains(temp, e5));
		
		count = 0;
		it = undirectedGraph.incomingEdges(v4).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e8));
		assertTrue(arrayContains(temp, e10));
		
		count = 0;
		it = undirectedGraph.incomingEdges(v5).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e4));
		assertTrue(arrayContains(temp, e7));
		assertTrue(arrayContains(temp, e9));
		assertTrue(arrayContains(temp, e10));
		
		count = 0;
		it = undirectedGraph.incomingEdges(v6).iterator();
		assertFalse(it.hasNext());


		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		count = 0;
		it = directedGraph.incomingEdges(v1).iterator();
		assertFalse(it.hasNext());
		
		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.incomingEdges(v2).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e1));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.incomingEdges(v3).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e2));
		assertTrue(arrayContains(temp, e5));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.incomingEdges(v4).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e3));
		assertTrue(arrayContains(temp, e6));
		assertTrue(arrayContains(temp, e8));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.incomingEdges(v5).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e4));
		assertTrue(arrayContains(temp, e7));
		assertTrue(arrayContains(temp, e9));
		assertTrue(arrayContains(temp, e10));

		// Empty Temp array.
		for (int i = 0; i < 4; i++) {
			temp[i] = null;
		}
		
		count = 0;
		it = directedGraph.incomingEdges(v6).iterator();
		assertTrue(it.hasNext());
		temp[count] = it.next();
		count++;
		assertFalse(it.hasNext());
		assertTrue(arrayContains(temp, e11));
	}

	/**
	 * Test the output of the insertVertex(x) behavior
	 */
	@Test
	public void testInsertVertex() {
		// Undirected Graph:
		assertEquals(0, undirectedGraph.numVertices());
		Vertex<String> v1 = undirectedGraph.insertVertex("Fayetteville");
		assertEquals(1, undirectedGraph.numVertices());

		Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertFalse(it.hasNext());
		
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		assertEquals(2, undirectedGraph.numVertices());
		
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		assertEquals(3, undirectedGraph.numVertices());
		
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		assertEquals(4, undirectedGraph.numVertices());
		
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		assertEquals(5, undirectedGraph.numVertices());
		
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		assertEquals(6, undirectedGraph.numVertices());
		
		it = undirectedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertEquals(v2, it.next());
		assertEquals(v3, it.next());
		assertEquals(v4, it.next());
		assertEquals(v5, it.next());
		assertEquals(v6, it.next());
		assertFalse(it.hasNext());
		
		// Directed Graph:
		assertEquals(0, directedGraph.numVertices());
		v1 = directedGraph.insertVertex("Fayetteville");
		assertEquals(1, directedGraph.numVertices());

		it = directedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertFalse(it.hasNext());
		
		v2 = directedGraph.insertVertex("Asheville");
		assertEquals(2, directedGraph.numVertices());
		
		v3 = directedGraph.insertVertex("Wilmington");
		assertEquals(3, directedGraph.numVertices());
		
		v4 = directedGraph.insertVertex("Durham");
		assertEquals(4, directedGraph.numVertices());
		
		v5 = directedGraph.insertVertex("Greenville");
		assertEquals(5, directedGraph.numVertices());
		
		v6 = directedGraph.insertVertex("Boone");
		assertEquals(6, directedGraph.numVertices());
		
		it = directedGraph.vertices().iterator();
		assertTrue(it.hasNext());
		assertEquals(v1, it.next());
		assertEquals(v2, it.next());
		assertEquals(v3, it.next());
		assertEquals(v4, it.next());
		assertEquals(v5, it.next());
		assertEquals(v6, it.next());
		assertFalse(it.hasNext());
	}

	/**
	 * Test the output of the insertEdge(v1, v2, x) behavior
	 */
	@Test
	public void testInsertEdge() {
		// Undirected graph:
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");

		assertEquals(0, undirectedGraph.numEdges());
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 99);
		assertEquals(1, undirectedGraph.numEdges());
		Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertFalse(it.hasNext());
		
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		assertEquals(2, undirectedGraph.numEdges());
		
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		assertEquals(3, undirectedGraph.numEdges());
		
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		assertEquals(4, undirectedGraph.numEdges());
		
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		assertEquals(5, undirectedGraph.numEdges());
		
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		assertEquals(6, undirectedGraph.numEdges());
		
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		assertEquals(7, undirectedGraph.numEdges());
		
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		assertEquals(8, undirectedGraph.numEdges());
		
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		assertEquals(9, undirectedGraph.numEdges());
		
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
		assertEquals(10, undirectedGraph.numEdges());

		it = undirectedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertEquals(e2, it.next());
		assertEquals(e3, it.next());
		assertEquals(e4, it.next());
		assertEquals(e5, it.next());
		assertEquals(e6, it.next());
		assertEquals(e7, it.next());
		assertEquals(e8, it.next());
		assertEquals(e9, it.next());
		assertEquals(e10, it.next());
		assertFalse(it.hasNext());
		
		// Directed graph:
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");

		assertEquals(0, directedGraph.numEdges());
		e1 = directedGraph.insertEdge(v1, v2, 99);
		assertEquals(1, directedGraph.numEdges());
		it = directedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertFalse(it.hasNext());
		
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e2 = directedGraph.insertEdge(v1, v3, 10);
		assertEquals(2, directedGraph.numEdges());
		
		e3 = directedGraph.insertEdge(v1, v4, 15);
		assertEquals(3, directedGraph.numEdges());
		
		e4 = directedGraph.insertEdge(v1, v5, 20);
		assertEquals(4, directedGraph.numEdges());
		
		e5 = directedGraph.insertEdge(v2, v3, 25);
		assertEquals(5, directedGraph.numEdges());
		
		e6 = directedGraph.insertEdge(v2, v4, 30);
		assertEquals(6, directedGraph.numEdges());
		
		e7 = directedGraph.insertEdge(v2, v5, 35);
		assertEquals(7, directedGraph.numEdges());
		
		e8 = directedGraph.insertEdge(v3, v4, 40);
		assertEquals(8, directedGraph.numEdges());
		
		e9 = directedGraph.insertEdge(v3, v5, 45);
		assertEquals(9, directedGraph.numEdges());
		
		e10 = directedGraph.insertEdge(v4, v5, 50);
		assertEquals(10, directedGraph.numEdges());
		
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 50);
		assertEquals(11, directedGraph.numEdges());

		it = directedGraph.edges().iterator();
		assertTrue(it.hasNext());
		assertEquals(e1, it.next());
		assertEquals(e2, it.next());
		assertEquals(e3, it.next());
		assertEquals(e4, it.next());
		assertEquals(e5, it.next());
		assertEquals(e6, it.next());
		assertEquals(e7, it.next());
		assertEquals(e8, it.next());
		assertEquals(e9, it.next());
		assertEquals(e10, it.next());
		assertEquals(e11, it.next());
		assertFalse(it.hasNext());
	}

	/**
	 * Test the output of the removeVertex(v) behavior
	 */
	@Test
	public void testRemoveVertex() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		undirectedGraph.insertEdge(v1, v2, 5);
		undirectedGraph.insertEdge(v1, v3, 10);
		undirectedGraph.insertEdge(v1, v4, 15);
		undirectedGraph.insertEdge(v1, v5, 20);
		undirectedGraph.insertEdge(v2, v3, 25);
		undirectedGraph.insertEdge(v2, v4, 30);
		undirectedGraph.insertEdge(v2, v5, 35);
		undirectedGraph.insertEdge(v3, v4, 40);
		undirectedGraph.insertEdge(v3, v5, 45);
		undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(5, undirectedGraph.numVertices());
		assertEquals(10, undirectedGraph.numEdges());
		undirectedGraph.removeVertex(v5);
		assertEquals(4, undirectedGraph.numVertices());
		assertEquals(6, undirectedGraph.numEdges());
		
		undirectedGraph.removeVertex(v4);
		assertEquals(3, undirectedGraph.numVertices());
		assertEquals(3, undirectedGraph.numEdges());
		
		undirectedGraph.removeVertex(v3);
		assertEquals(2, undirectedGraph.numVertices());
		assertEquals(1, undirectedGraph.numEdges());
		
		undirectedGraph.removeVertex(v2);
		assertEquals(1, undirectedGraph.numVertices());
		assertEquals(0, undirectedGraph.numEdges());
		
		undirectedGraph.removeVertex(v1);
		assertEquals(0, undirectedGraph.numVertices());
		assertEquals(0, undirectedGraph.numEdges());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		Vertex<String> v6 = directedGraph.insertVertex("Boone");
		directedGraph.insertEdge(v1, v2, 5);
		directedGraph.insertEdge(v1, v3, 10);
		directedGraph.insertEdge(v1, v4, 15);
		directedGraph.insertEdge(v1, v5, 20);
		directedGraph.insertEdge(v2, v3, 25);
		directedGraph.insertEdge(v2, v4, 30);
		directedGraph.insertEdge(v2, v5, 35);
		directedGraph.insertEdge(v3, v4, 40);
		directedGraph.insertEdge(v3, v5, 45);
		directedGraph.insertEdge(v4, v5, 50);
		directedGraph.insertEdge(v5, v6, 55);

		assertEquals(6, directedGraph.numVertices());
		assertEquals(11, directedGraph.numEdges());
		directedGraph.removeVertex(v6);
		assertEquals(5, directedGraph.numVertices());
		assertEquals(10, directedGraph.numEdges());

		assertEquals(5, directedGraph.numVertices());
		assertEquals(10, directedGraph.numEdges());
		directedGraph.removeVertex(v5);
		assertEquals(4, directedGraph.numVertices());
		assertEquals(6, directedGraph.numEdges());
		
		directedGraph.removeVertex(v4);
		assertEquals(3, directedGraph.numVertices());
		assertEquals(3, directedGraph.numEdges());
		
		directedGraph.removeVertex(v3);
		assertEquals(2, directedGraph.numVertices());
		assertEquals(1, directedGraph.numEdges());
		
		directedGraph.removeVertex(v2);
		assertEquals(1, directedGraph.numVertices());
		assertEquals(0, directedGraph.numEdges());
		
		directedGraph.removeVertex(v1);
		assertEquals(0, directedGraph.numVertices());
		assertEquals(0, directedGraph.numEdges());
	}

	/**
	 * Test the output of the removeEdge(e) behavior
	 */
	@Test
	public void testRemoveEdge() {
		Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
		Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
		Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
		Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
		Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
		Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
		Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
		Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
		Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
		Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
		Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
		Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
		Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
		Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
		Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
		Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);

		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(10, undirectedGraph.numEdges());
		undirectedGraph.removeEdge(e1);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(9, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e2);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(8, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e3);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(7, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e4);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(6, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e5);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(5, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e6);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(4, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e7);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(3, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e8);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(2, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e9);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(1, undirectedGraph.numEdges());
		
		undirectedGraph.removeEdge(e10);
		assertEquals(6, undirectedGraph.numVertices());
		assertEquals(0, undirectedGraph.numEdges());

		// DIRECTED
		v1 = directedGraph.insertVertex("Raleigh");
		v2 = directedGraph.insertVertex("Asheville");
		v3 = directedGraph.insertVertex("Wilmington");
		v4 = directedGraph.insertVertex("Durham");
		v5 = directedGraph.insertVertex("Greenville");
		v6 = directedGraph.insertVertex("Boone");
		e1 = directedGraph.insertEdge(v1, v2, 5);
		e2 = directedGraph.insertEdge(v1, v3, 10);
		e3 = directedGraph.insertEdge(v1, v4, 15);
		e4 = directedGraph.insertEdge(v1, v5, 20);
		e5 = directedGraph.insertEdge(v2, v3, 25);
		e6 = directedGraph.insertEdge(v2, v4, 30);
		e7 = directedGraph.insertEdge(v2, v5, 35);
		e8 = directedGraph.insertEdge(v3, v4, 40);
		e9 = directedGraph.insertEdge(v3, v5, 45);
		e10 = directedGraph.insertEdge(v4, v5, 50);
		Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);

		assertEquals(6, directedGraph.numVertices());
		assertEquals(11, directedGraph.numEdges());
		directedGraph.removeEdge(e1);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(10, directedGraph.numEdges());
		
		directedGraph.removeEdge(e2);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(9, directedGraph.numEdges());
		
		directedGraph.removeEdge(e3);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(8, directedGraph.numEdges());
		
		directedGraph.removeEdge(e4);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(7, directedGraph.numEdges());
		
		directedGraph.removeEdge(e5);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(6, directedGraph.numEdges());
		
		directedGraph.removeEdge(e6);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(5, directedGraph.numEdges());
		
		directedGraph.removeEdge(e7);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(4, directedGraph.numEdges());
		
		directedGraph.removeEdge(e8);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(3, directedGraph.numEdges());
		
		directedGraph.removeEdge(e9);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(2, directedGraph.numEdges());
		
		directedGraph.removeEdge(e10);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(1, directedGraph.numEdges());
		
		directedGraph.removeEdge(e11);
		assertEquals(6, directedGraph.numVertices());
		assertEquals(0, directedGraph.numEdges());
	}

}