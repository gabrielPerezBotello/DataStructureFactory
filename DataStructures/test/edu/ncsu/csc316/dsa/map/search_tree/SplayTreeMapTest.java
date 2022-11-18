package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SplayTreeMap Checks the expected outputs of the Map abstract
 * data type behaviors when using a splay tree data structure
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class SplayTreeMapTest {
	/** Tester tree object to be used in tests. */
	private BinarySearchTreeMap<Integer, String> tree;

	/**
	 * Create a new instance of a splay tree-based map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		tree = new SplayTreeMap<Integer, String>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());

		// You should create test cases to check all the
		// splay scenarios. The textbook has examples
		// that you can use to create your test cases

		// You should check the specific keys in each node after adding or
		// removing from the tree. For example, you might use:
		// assertEquals(4, (int)tree.root().getElement().getKey());
		// assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());

		tree.put(5, "five");

		assertEquals(1, tree.size());
		assertEquals(5, (int) tree.root().getElement().getKey());

		tree.put(10, "ten"); // Zig left

		assertEquals(2, tree.size());
		assertEquals(10, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(3, "three"); // Zig-Zig right

		assertEquals(3, tree.size());
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(2, "two"); // Zig right

		assertEquals(4, tree.size());
		assertEquals(2, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());

		tree.put(4, "four"); // Zig-Zag R->L w Zig left

		assertEquals(5, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(15, "fifteen"); // Zig-Zig left w Zig left

		assertEquals(6, tree.size());
		assertEquals(15, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());

		tree.put(7, "seven"); // Zig-Zag L->R w Zig-Zag L->R

		assertEquals(7, tree.size());
		assertEquals(7, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.left(tree.right(tree.root())).getElement().getKey());
	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());

		tree.put(5, "five");

		assertEquals(1, tree.size());
		assertEquals(5, (int) tree.root().getElement().getKey());

		tree.put(10, "ten"); // Zig left

		assertEquals(2, tree.size());
		assertEquals(10, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(3, "three"); // Zig-Zig right

		assertEquals(3, tree.size());
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(2, "two"); // Zig right

		assertEquals(4, tree.size());
		assertEquals(2, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());

		tree.put(4, "four"); // Zig-Zag R->L w Zig left

		assertEquals(5, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(15, "fifteen"); // Zig-Zig left w Zig left

		assertEquals(6, tree.size());
		assertEquals(15, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());

		tree.put(7, "seven"); // Zig-Zag L->R w Zig-Zag L->R

		assertEquals(7, tree.size());
		assertEquals(7, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.left(tree.right(tree.root())).getElement().getKey());

		tree.get(3); // Zig-Zag L->R w Zig right
		
		assertEquals(7, tree.size());
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(4, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.left(tree.right(tree.root()))).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(10, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());
		
		tree.get(10); // Zig-Zag R->L w Zig left
		
		assertEquals(7, tree.size());
		assertEquals(10, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(4, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.left(tree.right(tree.left(tree.root())))).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
		
		tree.get(2); // Zig-Zig right
		
		assertEquals(7, tree.size());
		assertEquals(2, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(7, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals(4, (int) tree.left(tree.left(tree.right(tree.right(tree.root())))).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.left(tree.left(tree.right(tree.right(tree.root()))))).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
		
		tree.get(10); // Zig-Zig left
		
		assertEquals(7, tree.size());
		assertEquals(10, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(4, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.left(tree.right(tree.left(tree.root())))).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());

		// You should create test cases to check all the
		// splay scenarios. The textbook has examples
		// that you can use to create your test cases

		// You should check the specific keys in each node after adding or
		// removing from the tree. For example, you might use:
		// assertEquals(4, (int)tree.root().getElement().getKey());
		// assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());

		tree.put(5, "five");

		assertEquals(1, tree.size());
		assertEquals(5, (int) tree.root().getElement().getKey());

		tree.put(10, "ten"); // Zig left

		assertEquals(2, tree.size());
		assertEquals(10, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.left(tree.root()).getElement().getKey());

		tree.put(3, "three"); // Zig-Zig right

		assertEquals(3, tree.size());
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(2, "two"); // Zig right

		assertEquals(4, tree.size());
		assertEquals(2, (int) tree.root().getElement().getKey());
		assertEquals(3, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());

		tree.put(4, "four"); // Zig-Zag R->L w Zig left

		assertEquals(5, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(15, "fifteen"); // Zig-Zig left w Zig left

		assertEquals(6, tree.size());
		assertEquals(15, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());

		tree.put(7, "seven"); // Zig-Zag L->R w Zig-Zag L->R

		assertEquals(7, tree.size());
		assertEquals(7, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
		assertEquals(5, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		
		assertEquals("three", tree.remove(3)); // Zig-Zig right

		assertEquals(6, tree.size());
		assertEquals(2, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
		assertEquals(10, (int) tree.left(tree.right(tree.right(tree.right(tree.root())))).getElement().getKey());
		
		assertEquals("five", tree.remove(5)); // Zig-Zig left
		
		assertEquals(5, tree.size());
		assertEquals(7, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(10, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		
		assertEquals("ten", tree.remove(10)); // Zig left
		
		assertEquals(4, tree.size());
		assertEquals(15, (int) tree.root().getElement().getKey());
		assertEquals(7, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(4, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(2, (int) tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());
		
		assertEquals("four", tree.remove(4)); // Zig right
		
		assertEquals(3, tree.size());
		assertEquals(7, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
		
		assertEquals("seven", tree.remove(7));
		
		assertEquals(2, tree.size());
		assertEquals(15, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
	}
}