package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for SeparateChainingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a separate chaining hash map data structure 
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class SeparateChainingHashMapTest {
	/** Tester map objects that has integer keys and string values. */
    private Map<Integer, String> map;
    
    /**
     * Create a new instance of a separate chaining hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are TESTING.
        // Remember that (when testing) alpha = 1, beta = 1, and prime = 7
        // based on our AbstractHashMap constructor.
        // That means you can draw the hash table by hand
        // if you use integer keys, since Integer.hashCode() = the integer value, itself
        // Finally, apply compression. For example:
        // for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
        // for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
        // for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
        // for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
        // for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
        // for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
        // etc.
        // Remember that our secondary map (an AVL tree) is a search
        // tree, which means the entries should be sorted in order within
        // that tree
        map = new SeparateChainingHashMap<Integer, String>(7, true);
        Map<Integer, String> map2 = new SeparateChainingHashMap<Integer, String>();
        Map<Integer, String> map3 = new SeparateChainingHashMap<Integer, String>(true);
        Map<Integer, String> map4 = new SeparateChainingHashMap<Integer, String>(7);
        
        map2.entrySet();
        map3.entrySet();
        map4.entrySet();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));

        // Since our entrySet method returns the entries in the table
        // from left to right, we can use the entrySet to check
        // that our values are in the correct order in the hash table.
        // Alternatively, you could implement a toString() method if you
        // want to check that the exact index/map of each bucket is correct
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        
        
        assertNull(map.put(4, "string4"));
        assertEquals(2, map.size());
        assertFalse(map.isEmpty());
        it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5

        // You should create some collisions to check that entries
        // are placed in the correct buckets
        
        assertEquals("string4", map.put(4, "string4.1"));
        
        it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5
        
        assertNull(map.put(11, "string11"));
        
        it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5
        assertEquals(11, (int)it.next().getKey()); // should be in a map in index 5
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        
        assertNull(map.put(1, "string1"));
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        
        assertEquals("string3", map.get(3));
        assertEquals("string4", map.get(4));
        assertEquals("string1", map.get(1));
        assertEquals("string11", map.get(11));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        
        assertNull(map.put(1, "string1"));
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey()); // should be in a map in index 2
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5
        assertEquals(11, (int)it.next().getKey()); // should be in a map in index 5
        
        assertEquals("string4", map.remove(4));
        
        it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey()); // should be in a map in index 2
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(11, (int)it.next().getKey()); // should be in a map in index 5
        assertEquals(3, map.size());
        
        assertEquals("string3", map.remove(3));
        
        it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey()); // should be in a map in index 2
        assertEquals(11, (int)it.next().getKey()); // should be in a map in index 5
        assertEquals(2, map.size());
        
        assertEquals("string11", map.remove(11));
        
        it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey()); // should be in a map in index 2
        assertEquals(1, map.size());
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */   
    @Test
    public void testIterator() {
        assertTrue(map.isEmpty());
        
        assertNull(map.put(1, "string1"));
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        
        Iterator<Integer> it = map.iterator();
        assertEquals(1, (int)it.next()); // should be in a map in index 2
        assertEquals(3, (int)it.next()); // should be in a map in index 4
        assertEquals(4, (int)it.next()); // should be in a map in index 5
        assertEquals(11, (int)it.next()); // should be in a map in index 5
    }
    
    /**
     * Test the output of the entrySet() behavior
     */   
    @Test
    public void testEntrySet() {
    	assertTrue(map.isEmpty());
        
        assertNull(map.put(1, "string1"));
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();        
        assertEquals(1, (int)it.next().getKey()); // should be in a map in index 2
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5
        assertEquals(11, (int)it.next().getKey()); // should be in a map in index 5
    }
    
    /**
     * Test the output of the values() behavior
     */   
    @Test
    public void testValues() {
    	assertTrue(map.isEmpty());
        
        assertNull(map.put(1, "string1"));
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        
        Iterator<String> it = map.values().iterator();
        assertEquals("string1", it.next());
        assertEquals("string3", it.next());
        assertEquals("string4", it.next());
        assertEquals("string11", it.next());
    }
}