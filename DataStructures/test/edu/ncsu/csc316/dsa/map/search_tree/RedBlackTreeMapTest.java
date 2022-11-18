package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for RedBlackTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a red-black tree data structure 
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class RedBlackTreeMapTest {
	/** Tree object to be used for testing. */
    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a red-black tree-based map before each test case executes
     */  
    @Before
    public void setUp() {
        tree = new RedBlackTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        // You should create test cases to check all the
        // rules for red-black trees. The textbook has examples
        // that you can use to create your test cases

        // You should check the specific keys in each node after adding or
        // removing from the tree. For example, you might use:
        //  assertEquals(4, (int)tree.root().getElement().getKey());
        //  assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());     
        
        tree.put(10, "ten");
        
        assertEquals(1, tree.size());
        assertEquals(10, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        
        tree.put(20, "twenty");
        
        assertEquals(2, tree.size());
        assertEquals(10, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.root())));
        
        tree.put(15, "fifteen"); // Case 1: resolving double red
        
        assertEquals(3, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.root())));
        
        tree.put(13, "thirteen"); // Case 2: resolving double red
        
        assertEquals(4, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(13, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        
        tree.put(5, "five");
        
        assertEquals(5, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(13, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        
        tree.put(11, "eleven"); // Case 2: 
        
        assertEquals(6, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(13, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(11, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.right(tree.left(tree.root())))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
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
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        // You should create test cases to check all the
        // rules for red-black trees. The textbook has examples
        // that you can use to create your test cases
        
        // You should check the specific keys in each node after adding or
        // removing from the tree. For example, you might use:
        //  assertEquals(4, (int)tree.root().getElement().getKey());
        //  assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());   

        tree.put(10, "ten");
        
        tree.put(20, "twenty");
        
        tree.put(15, "fifteen"); // Case 1: resolving double red
        
        tree.put(13, "thirteen"); // Case 2: resolving double red
        
        tree.put(5, "five");
        
        tree.put(11, "eleven"); // Case 2: resolving double red
        
        assertEquals(6, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(13, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(11, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.right(tree.left(tree.root())))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        
        // Begin Remove Operations.
        
        assertEquals("eleven", tree.remove(11)); // Deletion of Red Node
        
        assertEquals(5, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(13, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        
        assertEquals("thirteen", tree.remove(13)); // Case 2: remedy double black
        
        assertEquals(4, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        
        tree.put(13, "thirteen"); // Adding red node for next removal case
        
        assertEquals(5, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(13, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        
        tree.put(11, "eleven"); // Adding red node for next removal case
        
        tree.put(12, "twelve"); // Adding red node for next removal case
        
        assertEquals(7, tree.size());
        assertEquals(15, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(12, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(11, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.right(tree.left(tree.root())))));
        assertEquals(13, (int) tree.right(tree.right(tree.left(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.right(tree.left(tree.root())))));
        assertEquals(20, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        
        tree.put(14, "fourteen"); // Adding red node for next removal case
        
        assertEquals(8, tree.size());
        assertEquals(12, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(11, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(13, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.right(tree.left(tree.root())))));
        assertEquals(14, (int) tree.right(tree.left(tree.right(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.right(tree.root())))));
        assertEquals(20, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.right(tree.root()))));
        
        tree.put(25, "twentyfive"); // Adding red node for next removal case
        
        assertEquals(9, tree.size());
        assertEquals(12, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(11, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(13, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.right(tree.left(tree.root())))));
        assertEquals(14, (int) tree.right(tree.left(tree.right(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.right(tree.root())))));
        assertEquals(20, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.right(tree.root()))));
        assertEquals(25, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.right(tree.right(tree.root())))));
        
        tree.put(23, "twentythree"); // Adding red node for next removal case
        
        tree.put(28, "twentyeight"); // Adding red node for next removal case
        
        assertEquals(11, tree.size());
        assertEquals(12, (int) tree.root().getElement().getKey());
        assertEquals(0, tree.getProperty(tree.root()));
        assertEquals(10, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.root())));
        assertEquals(5, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.left(tree.root()))));
        assertEquals(11, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.left(tree.root()))));
        assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.root())));
        assertEquals(13, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.right(tree.root()))));
        assertEquals(14, (int) tree.right(tree.left(tree.right(tree.root()))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.left(tree.right(tree.root())))));
        assertEquals(23, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.right(tree.root()))));
        assertEquals(20, (int) tree.left(tree.right(tree.right(tree.root()))).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.left(tree.right(tree.right(tree.root())))));
        assertEquals(25, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
        assertEquals(0, tree.getProperty(tree.right(tree.right(tree.right(tree.root())))));
        assertEquals(28, (int) tree.right(tree.right(tree.right(tree.right(tree.root())))).getElement().getKey());
        assertEquals(1, tree.getProperty(tree.right(tree.right(tree.right(tree.right(tree.root()))))));
        
        assertEquals("twenty", tree.remove(20)); // Case 1: remedy double black
    }
}