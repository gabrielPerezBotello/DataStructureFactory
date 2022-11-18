package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * Test class for BinarySearchTreeMap Checks the expected outputs of the Map and
 * Tree abstract data type behaviors when using an linked binary tree data
 * structure
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class BinarySearchTreeMapTest {
	/**
	 * Tester field that holds the BinarySearchTree we will be using for testing.
	 */
	private BinarySearchTreeMap<Integer, String> tree;

	/**
	 * Create a new instance of a binary search tree map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		tree = new BinarySearchTreeMap<Integer, String>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		assertNull(tree.put(1, "one"));
		assertEquals(1, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals(1, (int) tree.root().getElement().getKey());
		assertEquals("one", tree.get(1));

		assertNull(tree.put(2, "two"));
		assertEquals(2, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals("two", tree.get(2));

		assertNull(tree.put(3, "three"));
		assertEquals(3, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals("three", tree.get(3));

		assertNull(tree.put(0, "zero"));
		assertEquals(4, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals("zero", tree.get(0));

		assertNull(tree.put(11, "eleven"));
		assertEquals(5, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals("eleven", tree.get(11));

		assertEquals("one", tree.put(1, "ONE"));
		assertEquals(5, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals("ONE", tree.get(1));

		assertEquals("three", tree.put(3, "THREE"));
		assertEquals(5, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals("THREE", tree.get(3));
	}

	/**
	 * Test the output of the put(k, v) behavior with a different tree.
	 */
	@Test
	public void testPut2() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());

		tree.put(3, "three");

		assertTrue(tree.isRoot(tree.root()));
		assertEquals("three", tree.root().getElement().getValue());
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(1, tree.size());
		assertNull(tree.right(tree.root()).getElement());
		assertNull(tree.left(tree.root()).getElement());

		tree.put(2, "two");

		assertEquals("three", tree.root().getElement().getValue());
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(2, tree.size());
		assertNull(tree.right(tree.root()).getElement());
		assertEquals("two", tree.left(tree.root()).getElement().getValue());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.left(tree.root())).getElement().getValue());

		tree.put(4, "four");

		assertEquals("three", tree.root().getElement().getValue()); // check root
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(3, tree.size());

		assertEquals("two", tree.left(tree.root()).getElement().getValue()); // check left child of root
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.left(tree.root())).getElement().getValue());

		assertEquals("four", tree.right(tree.root()).getElement().getValue()); // check right child of root
		assertEquals(4, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.right(tree.root())).getElement().getValue());

		tree.put(1, "one");

		assertEquals("three", tree.root().getElement().getValue()); // check root
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(4, tree.size());

		assertEquals("two", tree.left(tree.root()).getElement().getValue()); // check left child of root
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.left(tree.root())).getElement().getValue());

		assertEquals("one", tree.left(tree.left(tree.root())).getElement().getValue()); // check left child of 2
		assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals("two", tree.parent(tree.left(tree.left(tree.root()))).getElement().getValue());

		assertEquals("four", tree.right(tree.root()).getElement().getValue()); // check right child of root
		assertEquals(4, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.right(tree.root())).getElement().getValue());

		tree.put(6, "six");

		assertEquals("three", tree.root().getElement().getValue()); // check root
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(5, tree.size());

		assertEquals("two", tree.left(tree.root()).getElement().getValue()); // check left child of root
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.left(tree.root())).getElement().getValue());

		assertEquals("one", tree.left(tree.left(tree.root())).getElement().getValue()); // check left child of 2
		assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals("two", tree.parent(tree.left(tree.left(tree.root()))).getElement().getValue());

		assertEquals("four", tree.right(tree.root()).getElement().getValue()); // check right child of root
		assertEquals(4, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.right(tree.root())).getElement().getValue());

		assertEquals("six", tree.right(tree.right(tree.root())).getElement().getValue()); // check right child of 4
		assertEquals(6, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals("four", tree.parent(tree.right(tree.right(tree.root()))).getElement().getValue());

		tree.put(5, "five");

		assertEquals("three", tree.root().getElement().getValue()); // check root
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(6, tree.size());

		assertEquals("two", tree.left(tree.root()).getElement().getValue()); // check left child of root
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.left(tree.root())).getElement().getValue());

		assertEquals("one", tree.left(tree.left(tree.root())).getElement().getValue()); // check left child of 2
		assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals("two", tree.parent(tree.left(tree.left(tree.root()))).getElement().getValue());

		assertEquals("four", tree.right(tree.root()).getElement().getValue()); // check right child of root
		assertEquals(4, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.right(tree.root())).getElement().getValue());

		assertEquals("six", tree.right(tree.right(tree.root())).getElement().getValue()); // check right child of 4
		assertEquals(6, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals("four", tree.parent(tree.right(tree.right(tree.root()))).getElement().getValue());

		assertEquals("five", tree.left(tree.right(tree.right(tree.root()))).getElement().getValue()); // check left
																										// child of 6
		assertEquals(5, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals("six", tree.parent(tree.left(tree.right(tree.right(tree.root())))).getElement().getValue());

		tree.put(7, "seven");

		assertEquals("three", tree.root().getElement().getValue()); // check root
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(7, tree.size());

		assertEquals("two", tree.left(tree.root()).getElement().getValue()); // check left child of root
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.left(tree.root())).getElement().getValue());

		assertEquals("one", tree.left(tree.left(tree.root())).getElement().getValue()); // check left child of 2
		assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals("two", tree.parent(tree.left(tree.left(tree.root()))).getElement().getValue());

		assertEquals("four", tree.right(tree.root()).getElement().getValue()); // check right child of root
		assertEquals(4, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.right(tree.root())).getElement().getValue());

		assertEquals("six", tree.right(tree.right(tree.root())).getElement().getValue()); // check right child of 4
		assertEquals(6, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals("four", tree.parent(tree.right(tree.right(tree.root()))).getElement().getValue());

		assertEquals("five", tree.left(tree.right(tree.right(tree.root()))).getElement().getValue()); // check left
																										// child of 6
		assertEquals(5, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals("six", tree.parent(tree.left(tree.right(tree.right(tree.root())))).getElement().getValue());

		assertEquals("seven", tree.right(tree.right(tree.right(tree.root()))).getElement().getValue()); // check right
																										// child of 6
		assertEquals(7, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals("six", tree.parent(tree.right(tree.right(tree.right(tree.root())))).getElement().getValue());
	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		tree.put(1, "one");
		assertEquals(1, tree.size());
		assertEquals("one", tree.get(1));

		tree.put(5, "five");
		tree.put(3, "three");
		tree.put(2, "two");
		tree.put(11, "eleven");
		tree.put(12, "twelve");

		assertEquals(6, tree.size());
		assertEquals("five", tree.get(5));

		assertEquals(6, tree.size());
		assertEquals("two", tree.get(2));

		assertEquals(6, tree.size());
		assertEquals("three", tree.get(3));

		assertEquals(6, tree.size());
		assertEquals("eleven", tree.get(11));

		assertEquals(6, tree.size());
		assertEquals("twelve", tree.get(12));
	}

	/**
	 * Test the output of the remove(k) behavior when removing root.
	 */
	@Test
	public void testRemove1() {
		tree.put(4, "four");

		assertEquals(1, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());

		tree.put(3, "three");

		assertEquals(2, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(5, "five");

		assertEquals(3, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());

		assertEquals("four", tree.remove(4));

		assertEquals(2, tree.size());
		assertEquals(5, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
	}

	/**
	 * Test the output of the remove(k) behavior when removing node with one left
	 * child.
	 */
	@Test
	public void testRemove2() {
		tree.put(4, "four");

		assertEquals(1, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());

		tree.put(3, "three");

		assertEquals(2, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(6, "six");

		assertEquals(3, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());

		tree.put(5, "five");

		assertEquals(4, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.root())).getElement().getKey());

		assertEquals("six", tree.remove(6));

		assertEquals(3, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
	}

	/**
	 * Test the output of the remove(k) behavior when removing node with one right
	 * child.
	 */
	@Test
	public void testRemove3() {
		tree.put(4, "four");

		assertEquals(1, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());

		tree.put(3, "three");

		assertEquals(2, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(6, "six");

		assertEquals(3, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());

		tree.put(7, "seven");

		assertEquals(4, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		assertEquals("six", tree.remove(6));

		assertEquals(3, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
	}

	/**
	 * Test the output of the remove(k) behavior when removing node with both
	 * children.
	 */
	@Test
	public void testRemove4() {
		tree.put(4, "four");

		assertEquals(1, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());

		tree.put(3, "three");

		assertEquals(2, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(6, "six");

		assertEquals(3, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());

		tree.put(7, "seven");

		assertEquals(4, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(5, "five");

		assertEquals(5, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.root())).getElement().getKey());

		assertEquals("six", tree.remove(6));

		assertEquals(4, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.root())).getElement().getKey());
	}

	/**
	 * Test the output of the remove(k) behavior when removing node with both
	 * children and in order successor is a child of the right subtree.
	 */
	@Test
	public void testRemove5() {
		tree.put(4, "four");

		assertEquals(1, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());

		tree.put(3, "three");

		assertEquals(2, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(6, "six");

		assertEquals(3, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());

		tree.put(8, "eight");

		assertEquals(4, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(5, "five");

		assertEquals(5, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		
		tree.put(7, "seven");

		assertEquals(6, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		assertEquals(7, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());

		assertEquals("six", tree.remove(6));

		assertEquals(5, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		tree.put(1, "one");
		assertEquals(1, tree.size());

		assertNull(tree.remove(10));
		assertEquals(1, tree.size());

		assertEquals("one", tree.remove(1));
		assertEquals(0, tree.size());

		// You should create tests to ensure removing works
		// in all special cases:
		// - removing the root
		// - removing from a node that has only a left child
		// - removing from a node that has only a right child
		// - removing from a node that has both children
		// etc.

		tree.put(3, "three");
		tree.put(2, "two");
		tree.put(4, "four");
		tree.put(1, "one");
		tree.put(6, "six");
		tree.put(5, "five");
		tree.put(7, "seven");

		// Testing linkage of tree after put operations.
		assertEquals("three", tree.root().getElement().getValue()); // check root
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(7, tree.size());

		assertEquals("two", tree.left(tree.root()).getElement().getValue()); // check left child of root
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.left(tree.root())).getElement().getValue());

		assertEquals("one", tree.left(tree.left(tree.root())).getElement().getValue()); // check left child of 2
		assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals("two", tree.parent(tree.left(tree.left(tree.root()))).getElement().getValue());

		assertEquals("four", tree.right(tree.root()).getElement().getValue()); // check right child of root
		assertEquals(4, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals("three", tree.parent(tree.right(tree.root())).getElement().getValue());

		assertEquals("six", tree.right(tree.right(tree.root())).getElement().getValue()); // check right child of 4
		assertEquals(6, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals("four", tree.parent(tree.right(tree.right(tree.root()))).getElement().getValue());

		assertEquals("five", tree.left(tree.right(tree.right(tree.root()))).getElement().getValue()); // check left
																										// child of 6
		assertEquals(5, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals("six", tree.parent(tree.left(tree.right(tree.right(tree.root())))).getElement().getValue());

		assertEquals("seven", tree.right(tree.right(tree.right(tree.root()))).getElement().getValue()); // check right
																										// child of 6
		assertEquals(7, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals("six", tree.parent(tree.right(tree.right(tree.right(tree.root())))).getElement().getValue());

		// Begin testing remove operations.
		assertEquals(7, tree.size());
		assertEquals("six", tree.remove(6));
		assertEquals(6, tree.size());

		// Checking linkage of tree.
		assertEquals("seven", tree.right(tree.right(tree.root())).getElement().getValue());
		assertEquals("four", tree.right(tree.root()).getElement().getValue());
		assertEquals("four", tree.parent(tree.right(tree.right(tree.root()))).getElement().getValue());

		assertEquals("five", tree.left(tree.right(tree.right(tree.root()))).getElement().getValue()); // check left
																										// child of 7
		assertEquals("seven", tree.parent(tree.left(tree.right(tree.right(tree.root())))).getElement().getValue());

		assertNull(tree.right(tree.right(tree.right(tree.root()))).getElement()); // check right child of 7
		assertEquals("seven", tree.parent(tree.right(tree.right(tree.right(tree.root())))).getElement().getValue());

		// Next remove operation.
		assertEquals("five", tree.remove(5));
		assertEquals(5, tree.size());

		// Checking linkage of tree.
		assertEquals("seven", tree.right(tree.right(tree.root())).getElement().getValue());
		assertEquals("four", tree.right(tree.root()).getElement().getValue());
		assertEquals("four", tree.parent(tree.right(tree.right(tree.root()))).getElement().getValue());

		assertNull(tree.left(tree.right(tree.right(tree.root()))).getElement()); // check left child of 7
		// assertEquals("seven",
		// tree.parent(tree.left(tree.right(tree.right(tree.root())))).getElement().getValue());

		assertNull(tree.right(tree.right(tree.right(tree.root()))).getElement()); // check right child of 7
		assertEquals("seven", tree.parent(tree.right(tree.right(tree.right(tree.root())))).getElement().getValue());

//		// Next remove operation.
//		assertEquals("four", tree.remove(4));
//		assertEquals(4, tree.size());
//		
//		// Next remove operation.
//		assertEquals("two", tree.remove(2));
//		assertEquals(3, tree.size());
//		
//		// Next remove operation.
//		assertEquals("three", tree.remove(3));
//		assertEquals(2, tree.size());
//		
//		// Next remove operation.
//		assertEquals("seven", tree.remove(7));
//		assertEquals(1, tree.size());
//		
//		// Next remove operation.
//		assertEquals("one", tree.remove(1));
//		assertEquals(0, tree.size());
	}
	
	/**
	 * Test output of toString behavior.
	 */
	@Test
	public void testToString() {
		tree.put(1, "one");
		assertEquals(1, tree.size());
		
		assertEquals("BalanceableBinaryTree[\n" + tree.root().getElement() + "\n]", tree.toString());
	}
	
	/**
	 * Test output of entrySet() behavior.
	 */
	@Test
	public void testEntrySet() {
		tree.put(1, "one");

		tree.put(2, "two");
		
		tree.put(3, "three");
		
		tree.put(4, "four");
		
		assertEquals(4, tree.size());
		
		Iterable<Entry<Integer, String>> iterable = tree.entrySet();
		
		Iterator<Entry<Integer, String>> it = iterable.iterator();
		
		assertEquals(1, (int) it.next().getKey());
		assertEquals(2, (int) it.next().getKey());
		assertEquals(3, (int) it.next().getKey());
		assertEquals(4, (int) it.next().getKey());
	}
}