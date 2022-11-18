package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for LinearProbingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a linear probing hash map data structure 
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class LinearProbingHashMapTest {
	/** tester map object to be used for testing. */
    private Map<Integer, String> map;

    /**
     * Create a new instance of a linear probing hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are testing.
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
        map = new LinearProbingHashMap<Integer, String>(7, true);
        Map<Integer, String> map2 = new LinearProbingHashMap<Integer, String>();
        Map<Integer, String> map3 = new LinearProbingHashMap<Integer, String>(true);
        Map<Integer, String> map4 = new LinearProbingHashMap<Integer, String>(7);
        
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
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        assertNull(map.put(1, "string1"));
        assertEquals("string4", map.put(4, "string4.1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey());
        assertEquals(3, (int)it.next().getKey());
        assertEquals(4, (int)it.next().getKey());
        assertEquals(11, (int)it.next().getKey());
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey());
        assertEquals(3, (int)it.next().getKey());
        assertEquals(4, (int)it.next().getKey());
        assertEquals(11, (int)it.next().getKey());
        assertEquals(4, map.size());
        
        assertEquals("string1", map.get(1));
        assertEquals("string11", map.get(11));
        assertEquals("string4", map.get(4));
        assertEquals("string3", map.get(3));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
    	assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey());
        assertEquals(3, (int)it.next().getKey());
        assertEquals(4, (int)it.next().getKey());
        assertEquals(11, (int)it.next().getKey());
        assertEquals(4, map.size());
        
        assertEquals("string4", map.remove(4));
        
        it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey());
        assertEquals(3, (int)it.next().getKey());
        assertEquals(11, (int)it.next().getKey());
        assertEquals(3, map.size());
        
        assertEquals("string3", map.remove(3));
        
        it = map.entrySet().iterator();
        assertEquals(1, (int)it.next().getKey());
        assertEquals(11, (int)it.next().getKey());
        assertEquals(2, map.size());
        
        assertEquals("string1", map.remove(1));
        
        it = map.entrySet().iterator();
        assertEquals(11, (int)it.next().getKey());
        assertEquals(1, map.size());
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */     
    @Test
    public void testIterator() {
    	assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Integer> it = map.iterator();
        assertEquals(1, (int)it.next());
        assertEquals(3, (int)it.next());
        assertEquals(4, (int)it.next());
        assertEquals(11, (int)it.next());
    }
    
    /**
     * Test the output of the entrySet() behavior
     */     
    @Test
    public void testEntrySet() {
    	assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();     
        assertEquals(1, (int)it.next().getKey());
        assertEquals(3, (int)it.next().getKey());
        assertEquals(4, (int)it.next().getKey());
        assertEquals(11, (int)it.next().getKey());
        assertEquals(4, map.size());
    }
    
    /**
     * Test the output of the values() behavior
     */  
    @Test
    public void testValues() {
    	assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        
        assertNull(map.put(3, "string3"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(11, "string11"));
        assertNull(map.put(1, "string1"));
        
        Iterator<String> it = map.values().iterator();
        assertEquals("string1", it.next());
        assertEquals("string3", it.next());
        assertEquals("string4", it.next());
        assertEquals("string11", it.next());
    }
}