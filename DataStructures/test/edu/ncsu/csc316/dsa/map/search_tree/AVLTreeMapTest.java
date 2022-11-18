package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for AVLTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an AVL tree data structure 
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class AVLTreeMapTest {
	/** Tree object to be used in testing. */
    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of an AVL tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new AVLTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior for single left rotation
     */     
    @Test
    public void testPut1() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        // You should create test cases to check all the
        // trinode restructuring scenarios. The textbook has visual examples
        // that you can use to create your test cases
        
        // You should check the specific keys in each node after adding or
        // removing from the tree. For example, you might use:
        //  assertEquals(4, (int)tree.root().getElement().getKey());
        //  assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(1, tree.size());
        assertEquals(3, (int) tree.root().getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(2, tree.size());
        assertEquals(3, (int) tree.root().getElement().getKey());
        assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(3, tree.size());
        assertEquals(2, (int) tree.root().getElement().getKey());
        assertEquals(1, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.right(tree.root()).getElement().getKey());
    }
    
    /**
     * Test the output of the put(k,v) behavior for single right rotation
     */     
    @Test
    public void testPut2() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        
        assertEquals(1, tree.size());
        assertEquals(1, (int) tree.root().getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(2, tree.size());
        assertEquals(1, (int) tree.root().getElement().getKey());
        assertEquals(2, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(3, tree.size());
        assertEquals(2, (int) tree.root().getElement().getKey());
        assertEquals(1, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.right(tree.root()).getElement().getKey());
    }
    
    /**
     * Test the output of the put(k,v) behavior for a Right-Left double rotation.
     */
    @Test
    public void testPut3() {
    	assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(3, "three");
        
        assertEquals(1, tree.size());
        assertEquals(3, (int) tree.root().getElement().getKey());
        
        tree.put(5, "five");
        
        assertEquals(2, tree.size());
        assertEquals(3, (int) tree.root().getElement().getKey());
        assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(4, "four");
        
        assertEquals(3, tree.size());
        assertEquals(4, (int) tree.root().getElement().getKey());
        assertEquals(5, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
    }
    
    /**
     * Test the output of the put(k,v) behavior for a Left-Right double rotation.
     */
    @Test
    public void testPut4() {
    	assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(3, "three");
        
        assertEquals(1, tree.size());
        assertEquals(3, (int) tree.root().getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(2, tree.size());
        assertEquals(3, (int) tree.root().getElement().getKey());
        assertEquals(1, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(3, tree.size());
        assertEquals(2, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.root()).getElement().getKey());
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(tree.isEmpty());
        tree.put(1, "one");
		assertEquals(1, tree.size());
		assertEquals("one", tree.get(1));
		
		tree.put(5, "five");
		tree.put(3, "three");
		tree.put(2,  "two");
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
     * Test the output of the remove(k) behavior when a left-right rotation is needed.
     */     
    @Test
    public void testRemove1() {
        assertTrue(tree.isEmpty());
        
        // You should create test cases to check all the
        // trinode restructuring scenarios. The textbook has visual examples
        // that you can use to create your test cases
        
        // You should check the specific keys in each node after adding or
        // removing from the tree. For example, you might use:
        //  assertEquals(4, (int)tree.root().getElement().getKey());
        //  assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());     
        
        tree.put(5, "five");
        
        assertEquals(1, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        
        tree.put(6, "six");
        
        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(4, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        
        tree.put(4, "four");
        
        assertEquals(5, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        
        tree.put(7, "seven");
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(7, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        // Begin removal operations.
        assertEquals("four", tree.remove(4));
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(3, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
    }
    
    /**
     * Test the output of the remove(k) behavior when a right rotation is needed.
     */     
    @Test
    public void testRemove2() {
        assertTrue(tree.isEmpty());
        
        tree.put(5, "five");
        
        assertEquals(1, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(8, "eight");
        
        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(4, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(4, "four");
        
        assertEquals(5, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(7, "seven");
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(7, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        
        tree.put(9, "nine");
        
        assertEquals(8, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(6, "six");
        
        assertEquals(9, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(6, (int) tree.left(tree.left(tree.right(tree.root()))).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        // Begin Removal operations.
        assertEquals("nine", tree.remove(9));
        
        assertEquals(8, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(6, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
    }
    
    /**
     * Test the output of the remove(k) behavior when no rotation is needed.
     */     
    @Test
    public void testRemove3() {
        assertTrue(tree.isEmpty());
        
        tree.put(5, "five");
        
        assertEquals(1, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(8, "eight");
        
        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(4, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(4, "four");
        
        assertEquals(5, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(7, "seven");
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(7, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        
        tree.put(9, "nine");
        
        assertEquals(8, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(6, "six");
        
        assertEquals(9, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(6, (int) tree.left(tree.left(tree.right(tree.root()))).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        // Begin Removal operations.
        assertEquals("six", tree.remove(6));
        
        assertEquals(8, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
    }
    
    /**
     * Test the output of the remove(k) behavior when removing root.
     */     
    @Test
    public void testRemove4() {
        assertTrue(tree.isEmpty());
        
        tree.put(5, "five");
        
        assertEquals(1, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(8, "eight");
        
        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(4, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(4, "four");
        
        assertEquals(5, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(7, "seven");
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(7, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        
        tree.put(9, "nine");
        
        assertEquals(8, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(6, "six");
        
        assertEquals(9, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(6, (int) tree.left(tree.left(tree.right(tree.root()))).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        // Begin Removal operations.
        assertEquals("five", tree.remove(5));
        
        assertEquals(8, tree.size());
        assertEquals(6, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
    }
    
    /**
     * Test the output of the remove(k) behavior when a right-left rotation is needed.
     */     
    @Test
    public void testRemove5() {
        assertTrue(tree.isEmpty());
        
        // You should create test cases to check all the
        // trinode restructuring scenarios. The textbook has visual examples
        // that you can use to create your test cases
        
        // You should check the specific keys in each node after adding or
        // removing from the tree. For example, you might use:
        //  assertEquals(4, (int)tree.root().getElement().getKey());
        //  assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());     
        
        tree.put(5, "five");
        
        assertEquals(1, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        
        tree.put(6, "six");
        
        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(4, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        
        tree.put(4, "four");
        
        assertEquals(5, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        
        tree.put(7, "seven");
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(7, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.right(tree.left(tree.root()))).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        // Begin removal operations.
        assertEquals("one", tree.remove(1));
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(2, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());
    }
    
    /**
     * Test the output of the remove(k) behavior when a left rotation is needed.
     */     
    @Test
    public void testRemove6() {
        assertTrue(tree.isEmpty());
        
        tree.put(5, "five");
        
        assertEquals(1, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        
        tree.put(3, "three");
        
        assertEquals(2, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        
        tree.put(7, "seven");
        
        assertEquals(3, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(1, "one");
        
        assertEquals(4, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(4, "four");
        
        assertEquals(5, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        
        tree.put(8, "eight");
        
        assertEquals(6, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(2, "two");
        
        assertEquals(7, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(6, "six");
        
        assertEquals(8, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(6, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        
        tree.put(9, "nine");
        
        assertEquals(9, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(6, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.right(tree.root()))).getElement().getKey());
        
        // Begin Removal operations.
        assertEquals("six", tree.remove(6));
        
        assertEquals(8, tree.size());
        assertEquals(5, (int) tree.root().getElement().getKey());
        assertEquals(3, (int) tree.left(tree.root()).getElement().getKey());
        assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
        assertEquals(2, (int) tree.right(tree.left(tree.left(tree.root()))).getElement().getKey());
        assertEquals(4, (int) tree.right(tree.left(tree.root())).getElement().getKey());
        assertEquals(8, (int) tree.right(tree.root()).getElement().getKey());
        assertEquals(7, (int) tree.left(tree.right(tree.root())).getElement().getKey());
        assertEquals(9, (int) tree.right(tree.right(tree.root())).getElement().getKey());
    }
}