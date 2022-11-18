package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * Test class for UnorderedLinkedMap Checks the expected outputs of the Map
 * abstract data type behaviors when using an unordered link-based list data
 * structure that uses the move-to-front heuristic for self-organizing entries
 * based on access frequency
 *
 * @author Dr. King
 *
 */
public class UnorderedLinkedMapTest {
	/** Map object to be used for testing. */
	private Map<Integer, String> map;

	/**
	 * Create a new instance of an unordered link-based map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		map = new UnorderedLinkedMap<Integer, String>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals("UnorderedLinkedMap[3]", map.toString());
		assertEquals(1, map.size());

		assertNull(map.put(1, "string1"));
		assertEquals(2, map.size());

		String oldVal = map.put(1, "newString");
		assertEquals("string1", oldVal);
		assertEquals(2, map.size());
		assertEquals("UnorderedLinkedMap[1, 3]", map.toString());
	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		assertTrue(map.isEmpty());

		assertNull(map.get(2));

		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());

		assertNull(map.get(7));
		assertNull(map.get(null));

		assertEquals("string1", map.get(1));
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());

		assertEquals("string4", map.get(4));
		assertEquals("UnorderedLinkedMap[4, 1, 2, 5, 3]", map.toString());

		assertEquals("string5", map.get(5));
		assertEquals("UnorderedLinkedMap[5, 4, 1, 2, 3]", map.toString());

		assertEquals("string3", map.get(3));
		assertEquals("UnorderedLinkedMap[3, 5, 4, 1, 2]", map.toString());

		assertEquals("string2", map.get(2));
		assertEquals("UnorderedLinkedMap[2, 3, 5, 4, 1]", map.toString());

		assertNull(map.get(400));
	}

	/**
	 * Tests multiple gets and removes on a map.
	 */
	@Test
	public void testGet2() {
		assertTrue(map.isEmpty());

		for (int i = 1; i < 10; i++) {
			assertNull(map.put(i, "string" + i));
		}

		for (int i = 1; i < 10; i++) {
			assertEquals("string" + i, map.get(i));
		}

		String oldVal = map.remove(3);
		assertEquals("string3", oldVal);

		for (int i = 1; i < 10; i++) {
			if (i != 3) {
				assertEquals("string" + i, map.get(i));
			}
		}
	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		assertTrue(map.isEmpty());

		String oldVal = map.remove(3);
		assertNull(oldVal);
		assertEquals(0, map.size());
		assertNull(map.get(10));

		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());

		oldVal = map.remove(3);
		assertEquals("string3", oldVal);
		assertEquals(4, map.size());
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5]", map.toString());

		oldVal = map.remove(4);
		assertEquals("string4", oldVal);
		assertEquals(3, map.size());
		assertEquals("UnorderedLinkedMap[1, 2, 5]", map.toString());

		oldVal = map.remove(1);
		assertEquals("string1", oldVal);
		assertEquals(2, map.size());
		assertEquals("UnorderedLinkedMap[2, 5]", map.toString());

		oldVal = map.remove(2);
		assertEquals("string2", oldVal);
		assertEquals(1, map.size());
		assertEquals("UnorderedLinkedMap[5]", map.toString());

		oldVal = map.remove(5);
		assertEquals("string5", oldVal);
		assertEquals(0, map.size());
		assertEquals("UnorderedLinkedMap[]", map.toString());

		oldVal = map.remove(3);
		assertNull(oldVal);
		assertEquals(0, map.size());
		assertEquals("UnorderedLinkedMap[]", map.toString());
		assertNull(map.get(10));
	}

	/**
	 * Test the output of the iterator behavior, including expected exceptions
	 */
	@Test
	public void testIterator() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));

		Iterator<Integer> it = map.iterator();

		assertEquals(1, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(4, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(2, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(5, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(3, (int) it.next());
		assertFalse(it.hasNext());

		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> it.remove());
		assertEquals("The remove operation is not supported yet.", e1.getMessage());
	}

	/**
	 * Test the output of the entrySet() behavior, including expected exceptions
	 */
	@Test
	public void testEntrySet() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));

		Iterable<Entry<Integer, String>> iterable = map.entrySet();

		Iterator<Entry<Integer, String>> it = iterable.iterator();

		assertEquals(1, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(4, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(2, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(5, (int) it.next().getKey());
		assertTrue(it.hasNext());
		assertEquals(3, (int) it.next().getKey());
		assertFalse(it.hasNext());

		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> it.remove());
		assertEquals("The remove operation is not supported yet.", e1.getMessage());
	}

	/**
	 * Test the output of the values() behavior, including expected exceptions
	 */
	@Test
	public void testValues() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));

		Iterable<String> iterable = map.values();

		Iterator<String> it = iterable.iterator();

		assertEquals("string1", it.next());
		assertTrue(it.hasNext());
		assertEquals("string4", it.next());
		assertTrue(it.hasNext());
		assertEquals("string2", it.next());
		assertTrue(it.hasNext());
		assertEquals("string5", it.next());
		assertTrue(it.hasNext());
		assertEquals("string3", it.next());
		assertFalse(it.hasNext());

		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> it.remove());
		assertEquals("The remove operation is not supported yet.", e1.getMessage());
	}
}