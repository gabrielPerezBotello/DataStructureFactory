package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for LinkedBinaryTree Checks the expected outputs of the BinaryTree
 * abstract data type behaviors when using a linked data structure to store
 * elements
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class LinkedBinaryTreeTest {
	/** Tester LinkedBinaryTree to be used for testing. */
	private LinkedBinaryTree<String> tree;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> one;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> two;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> three;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> four;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> five;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> six;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> seven;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> eight;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> nine;
	/** Tester Position object that has String type to be used for testing. */
	private Position<String> ten;

	/**
	 * Helper class to create an invalid position to help test validate(p)
	 * 
	 * @param <E> generic type to be used in this class
	 */
	private class InvalidPosition<E> implements Position<E> {

		@Override
		public E getElement() {
			return null;
		}

	}

	/**
	 * Create a new instance of a linked binary tree before each test case executes
	 */
	@Before
	public void setUp() {
		tree = new LinkedBinaryTree<String>();
	}

	 /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */  
	private void createTree() {
		one = tree.addRoot("one");
		two = tree.addLeft(one, "two");
		three = tree.addRight(one, "three");
		six = tree.addLeft(two, "six");
		ten = tree.addRight(two, "ten");
		four = tree.addLeft(three, "four");
		seven = tree.addLeft(ten, "seven");
		five = tree.addRight(ten, "five");
		eight = tree.addLeft(four, "eight");
		nine = tree.addRight(four, "nine");
	}
	
	/**
	 * Test the output of the toString() behavior
	 */
	@Test
	public void testToString() {
		createTree();
		
		assertEquals("LinkedBinaryTree[\none\n two\n  six\n  ten\n   seven\n   five\n three\n  four\n   eight\n   nine\n]", tree.toString());
	}

	/**
	 * Test the output of the set(p,e) behavior
	 */
	@Test
	public void testSet() {
		createTree();
		
		assertEquals(10, tree.size());
		
		String oldVal = tree.set(five, "FIVE");
		
		assertEquals("five", oldVal);
		assertEquals("FIVE", five.getElement());
		assertEquals(10, tree.size());
		
		oldVal = tree.set(five, "five");
		
		assertEquals("FIVE", oldVal);
		assertEquals("five", five.getElement());
		assertEquals(10, tree.size());
		
		oldVal = tree.set(one, "abcdefghijklmnopqrstuvwxyz");
		
		assertEquals("one", oldVal);
		assertEquals("abcdefghijklmnopqrstuvwxyz", one.getElement());
		assertEquals(10, tree.size());
		
		oldVal = tree.set(two, "");
		
		assertEquals("two", oldVal);
		assertEquals("", two.getElement());
		assertEquals(10, tree.size());
		
		tree.remove(three);
		
		assertEquals(9, tree.size());
		assertEquals(four, tree.right(one));
		
		oldVal = tree.set(three, "wrong");
		
		assertEquals("three", oldVal);
		assertEquals("wrong", three.getElement());
		
		Position<String> invalidPos = new InvalidPosition<String>();
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> tree.set(invalidPos, "incorrect"));
		assertEquals("Position is not a valid linked binary tree node", e1.getMessage());
		
		oldVal = tree.set(four, "well hello there");
		
		assertEquals("four", oldVal);
		assertEquals("well hello there", tree.right(one).getElement());
	}

	/**
	 * Test the output of the size() behavior
	 */
	@Test
	public void testSize() {
		assertTrue(tree.isEmpty());
		createTree();
		
		assertEquals(10, tree.size());
		
		tree.remove(nine);
		
		assertEquals(9, tree.size());
		
		nine = tree.addRight(four, "nine");
		
		assertEquals(10, tree.size());
	}

	/**
	 * Test the output of the numChildren(p) behavior
	 */
	@Test
	public void testNumChildren() {
		createTree();

		assertEquals(2, tree.numChildren(one));
		assertEquals(2, tree.numChildren(two));
		assertEquals(1, tree.numChildren(three));
		assertEquals(2, tree.numChildren(four));
		assertEquals(0, tree.numChildren(five));
		assertEquals(0, tree.numChildren(six));
		assertEquals(0, tree.numChildren(seven));
		assertEquals(0, tree.numChildren(eight));
		assertEquals(0, tree.numChildren(nine));
		assertEquals(2, tree.numChildren(ten));
		
		tree.remove(nine);
		
		assertEquals(2, tree.numChildren(one));
		assertEquals(2, tree.numChildren(two));
		assertEquals(1, tree.numChildren(three));
		assertEquals(1, tree.numChildren(four));
		assertEquals(0, tree.numChildren(five));
		assertEquals(0, tree.numChildren(six));
		assertEquals(0, tree.numChildren(seven));
		assertEquals(0, tree.numChildren(eight));
		assertEquals(0, tree.numChildren(nine));
		assertEquals(2, tree.numChildren(ten));
		
		nine = tree.addRight(four, "nine");
		
		assertEquals(2, tree.numChildren(one));
		assertEquals(2, tree.numChildren(two));
		assertEquals(1, tree.numChildren(three));
		assertEquals(2, tree.numChildren(four));
		assertEquals(0, tree.numChildren(five));
		assertEquals(0, tree.numChildren(six));
		assertEquals(0, tree.numChildren(seven));
		assertEquals(0, tree.numChildren(eight));
		assertEquals(0, tree.numChildren(nine));
		assertEquals(2, tree.numChildren(ten));
	}

	/**
	 * Test the output of the parent(p) behavior
	 */
	@Test
	public void testParent() {
		createTree();
		
		assertEquals(one, tree.parent(two));
		assertEquals(one, tree.parent(three));
		assertEquals(two, tree.parent(ten));
		assertEquals(two, tree.parent(six));
		assertEquals(ten, tree.parent(seven));
		assertEquals(ten, tree.parent(five));
		assertEquals(three, tree.parent(four));
		assertEquals(four, tree.parent(eight));
		assertEquals(four, tree.parent(nine));
		
		tree.remove(three);
		
		assertEquals(one, tree.parent(two));
		assertEquals(two, tree.parent(ten));
		assertEquals(two, tree.parent(six));
		assertEquals(ten, tree.parent(seven));
		assertEquals(ten, tree.parent(five));
		assertEquals(one, tree.parent(four));
		assertEquals(four, tree.parent(eight));
		assertEquals(four, tree.parent(nine));
		
		three = tree.addLeft(nine, "three");
		
		assertEquals(one, tree.parent(two));
		assertEquals(two, tree.parent(ten));
		assertEquals(two, tree.parent(six));
		assertEquals(ten, tree.parent(seven));
		assertEquals(ten, tree.parent(five));
		assertEquals(one, tree.parent(four));
		assertEquals(four, tree.parent(eight));
		assertEquals(four, tree.parent(nine));
		assertEquals(nine, tree.parent(three));
	}

	/**
	 * Test the output of the sibling behavior
	 */
	@Test
	public void testSibling() {
		createTree();
		
		assertEquals(two, tree.sibling(three));
		assertEquals(three, tree.sibling(two));
		assertEquals(six, tree.sibling(ten));
		assertEquals(ten, tree.sibling(six));
		assertEquals(seven, tree.sibling(five));
		assertEquals(five, tree.sibling(seven));
		assertEquals(eight, tree.sibling(nine));
		assertEquals(nine, tree.sibling(eight));
		
		tree.remove(three);
		
		assertEquals(two, tree.sibling(four));
		assertEquals(four, tree.sibling(two));
		assertEquals(six, tree.sibling(ten));
		assertEquals(ten, tree.sibling(six));
		assertEquals(seven, tree.sibling(five));
		assertEquals(five, tree.sibling(seven));
		assertEquals(eight, tree.sibling(nine));
		assertEquals(nine, tree.sibling(eight));
	}

	/**
	 * Test the output of the isInternal behavior
	 */
	@Test
	public void testIsInternal() {
		createTree();
		
		assertTrue(tree.isInternal(one));
		assertTrue(tree.isInternal(two));
		assertTrue(tree.isInternal(three));
		assertFalse(tree.isInternal(six));
		assertTrue(tree.isInternal(ten));
		assertTrue(tree.isInternal(four));
		assertFalse(tree.isInternal(seven));
		assertFalse(tree.isInternal(five));
		assertFalse(tree.isInternal(eight));
		assertFalse(tree.isInternal(nine));
		
		tree.remove(eight);
		
		assertTrue(tree.isInternal(one));
		assertTrue(tree.isInternal(two));
		assertTrue(tree.isInternal(three));
		assertFalse(tree.isInternal(six));
		assertTrue(tree.isInternal(ten));
		assertTrue(tree.isInternal(four));
		assertFalse(tree.isInternal(seven));
		assertFalse(tree.isInternal(five));
		assertFalse(tree.isInternal(eight));
		assertFalse(tree.isInternal(nine));
		
		tree.remove(nine);
		
		assertTrue(tree.isInternal(one));
		assertTrue(tree.isInternal(two));
		assertTrue(tree.isInternal(three));
		assertFalse(tree.isInternal(six));
		assertTrue(tree.isInternal(ten));
		assertFalse(tree.isInternal(four));
		assertFalse(tree.isInternal(seven));
		assertFalse(tree.isInternal(five));
		assertFalse(tree.isInternal(eight));
		assertFalse(tree.isInternal(nine));
	}

	/**
	 * Test the output of the isLeaf behavior
	 */
	@Test
	public void isLeaf() {
		createTree();
		
		assertFalse(tree.isLeaf(one));
		assertFalse(tree.isLeaf(two));
		assertFalse(tree.isLeaf(three));
		assertTrue(tree.isLeaf(six));
		assertFalse(tree.isLeaf(ten));
		assertFalse(tree.isLeaf(four));
		assertTrue(tree.isLeaf(seven));
		assertTrue(tree.isLeaf(five));
		assertTrue(tree.isLeaf(eight));
		assertTrue(tree.isLeaf(nine));
		
		tree.remove(seven);
		tree.remove(five);
		
		assertFalse(tree.isLeaf(one));
		assertFalse(tree.isLeaf(two));
		assertFalse(tree.isLeaf(three));
		assertTrue(tree.isLeaf(six));
		assertTrue(tree.isLeaf(ten));
		assertFalse(tree.isLeaf(four));
		assertTrue(tree.isLeaf(eight));
		assertTrue(tree.isLeaf(nine));
		
		tree.remove(six);
		tree.remove(ten);
		
		assertFalse(tree.isLeaf(one));
		assertTrue(tree.isLeaf(two));
		assertFalse(tree.isLeaf(three));
		assertFalse(tree.isLeaf(four));
		assertTrue(tree.isLeaf(eight));
		assertTrue(tree.isLeaf(nine));
	}

	/**
	 * Test the output of the isRoot(p)
	 */
	@Test
	public void isRoot() {
		createTree();

		assertTrue(tree.isRoot(one));
		assertFalse(tree.isRoot(two));
		assertFalse(tree.isRoot(three));
		assertFalse(tree.isRoot(four));
		assertFalse(tree.isRoot(five));
		assertFalse(tree.isRoot(six));
		assertFalse(tree.isRoot(seven));
		assertFalse(tree.isRoot(eight));
		assertFalse(tree.isRoot(nine));
		assertFalse(tree.isRoot(ten));
		
		tree.remove(six);
		tree.remove(seven);
		tree.remove(five);
		tree.remove(ten);
		tree.remove(eight);
		tree.remove(nine);
		tree.remove(four);
		tree.remove(three);
		tree.remove(one);
		
		assertTrue(tree.isRoot(two));
	}

	/**
	 * Test the output of the preOrder traversal behavior
	 */
	@Test
	public void testPreOrder() {
		createTree();
		
		Iterable<Position<String>> it = tree.preOrder();
		
		Iterator<Position<String>> iterator = it.iterator();
		
		assertEquals(one, iterator.next());
		assertEquals(two, iterator.next());
		assertEquals(six, iterator.next());
		assertEquals(ten, iterator.next());
		assertEquals(seven, iterator.next());
		assertEquals(five, iterator.next());
		assertEquals(three, iterator.next());
		assertEquals(four, iterator.next());
		assertEquals(eight, iterator.next());
		assertEquals(nine, iterator.next());
		
	}

	/**
	 * Test the output of the postOrder traversal behavior
	 */
	@Test
	public void testPostOrder() {
		createTree();
		
		Iterable<Position<String>> it = tree.postOrder();
		
		Iterator<Position<String>> iterator = it.iterator();
		
		assertEquals(six, iterator.next());
		assertEquals(seven, iterator.next());
		assertEquals(five, iterator.next());
		assertEquals(ten, iterator.next());
		assertEquals(two, iterator.next());
		assertEquals(eight, iterator.next());
		assertEquals(nine, iterator.next());
		assertEquals(four, iterator.next());
		assertEquals(three, iterator.next());
		assertEquals(one, iterator.next());
	}

	/**
	 * Test the output of the inOrder traversal behavior
	 */
	@Test
	public void testInOrder() {
		createTree();

		Iterable<Position<String>> it = tree.inOrder();
		
		Iterator<Position<String>> iterator = it.iterator();
		
		assertEquals(six, iterator.next());
		assertEquals(two, iterator.next());
		assertEquals(seven, iterator.next());
		assertEquals(ten, iterator.next());
		assertEquals(five, iterator.next());
		assertEquals(one, iterator.next());
		assertEquals(eight, iterator.next());
		assertEquals(four, iterator.next());
		assertEquals(nine, iterator.next());
		assertEquals(three, iterator.next());
	}

	/**
	 * Test the output of the Binary Tree ADT behaviors on an empty tree
	 */
	@Test
	public void testEmptyTree() {
		assertTrue(tree.isEmpty());
		
		createTree();
		
		assertFalse(tree.isEmpty());
	}

	/**
	 * Test the output of the levelOrder traversal behavior
	 */
	@Test
	public void testLevelOrder() {
		createTree();

		Iterable<Position<String>> it = tree.levelOrder();
		
		Iterator<Position<String>> iterator = it.iterator();
		
		assertEquals(one, iterator.next());
		assertEquals(two, iterator.next());
		assertEquals(three, iterator.next());
		assertEquals(six, iterator.next());
		assertEquals(ten, iterator.next());
		assertEquals(four, iterator.next());
		assertEquals(seven, iterator.next());
		assertEquals(five, iterator.next());
		assertEquals(eight, iterator.next());
		assertEquals(nine, iterator.next());
	}

	/**
	 * Test the output of the addLeft(p,e) behavior, including expected exceptions
	 */
	@Test
	public void testAddLeft() {
		assertTrue(tree.isEmpty());
		
		one = tree.addRoot("one");
		
		two = tree.addLeft(one, "two");
		assertEquals(two, tree.left(one));
		
		three = tree.addLeft(two, "three");
		assertEquals(three, tree.left(two));
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> tree.addLeft(two, "Four"));
		assertEquals("Node already has a left child.", e1.getMessage());
		
		InvalidPosition<String> invalidPos = new InvalidPosition<String>();
		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> tree.addLeft(invalidPos, "Four"));
		assertEquals("Position is not a valid linked binary tree node", e2.getMessage());
	}

	/**
	 * Test the output of the addRight(p,e) behavior, including expected exceptions
	 */
	@Test
	public void testAddRight() {
		assertTrue(tree.isEmpty());
		
		one = tree.addRoot("one");
		
		two = tree.addRight(one, "two");
		assertEquals(two, tree.right(one));
		
		three = tree.addRight(two, "three");
		assertEquals(three, tree.right(two));
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> tree.addRight(two, "Four"));
		assertEquals("Node already has a right child.", e1.getMessage());
		
		InvalidPosition<String> invalidPos = new InvalidPosition<String>();
		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> tree.addRight(invalidPos, "Four"));
		assertEquals("Position is not a valid linked binary tree node", e2.getMessage());
	}

	/**
	 * Test the output of the remove(p) behavior, including expected exceptions
	 */
	@Test
	public void testRemove() {
		createTree();
		
		String oldVal = tree.remove(nine);
		assertEquals("nine", oldVal);
		assertEquals(9, tree.size());
		assertNull(tree.right(four));
		
		oldVal = tree.remove(four);
		assertEquals("four", oldVal);
		assertEquals(8, tree.size());
		assertEquals(eight, tree.left(three));
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> tree.remove(two));
		assertEquals("The node has two children", e1.getMessage());
	}
}