package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test class for SearchTableMap Checks the expected outputs of the Map abstract
 * data type behaviors when using a sorted array-based data structure that uses
 * binary search to locate entries based on the key of the entry
 *
 * @author Dr. King
 *
 */
public class SearchTableMapTest {
	/** Tester Map object using Integer for keys and Strings for values. */
	private Map<Integer, String> map;
	/** Tester Map object using Students for keys and Integers for values. */
	private Map<Student, Integer> studentMap;

	/**
	 * Create a new instance of a search table map before each test case executes
	 */
	@Before
	public void setUp() {
		map = new SearchTableMap<Integer, String>();
		studentMap = new SearchTableMap<Student, Integer>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals("SearchTableMap[3]", map.toString());
		assertEquals(1, map.size());

		assertNull(map.put(1, "string1"));
		assertEquals("SearchTableMap[1, 3]", map.toString());
		assertEquals(2, map.size());
		
		assertNull(map.put(4, "string4"));
		assertEquals("SearchTableMap[1, 3, 4]", map.toString());
		assertEquals(3, map.size());
		
		assertEquals("string4", map.put(4, "newString"));
		assertEquals("SearchTableMap[1, 3, 4]", map.toString());
		assertEquals(3, map.size());
		assertEquals("newString", map.get(4));
	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());

		assertEquals("string1", map.get(1));
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());

		assertEquals("string5", map.get(5));
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());
		
		assertEquals("string3", map.get(3));
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());
		
		assertEquals("string2", map.get(2));
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());
		
		assertEquals("string4", map.get(4));
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());
	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());

		assertEquals("string5", map.remove(5));
		assertEquals(4, map.size());
		assertNull(map.get(5));
		assertEquals("SearchTableMap[1, 2, 3, 4]", map.toString());
		
		assertEquals("string1", map.remove(1));
		assertEquals(3, map.size());
		assertNull(map.get(1));
		assertEquals("SearchTableMap[2, 3, 4]", map.toString());
		
		assertEquals("string3", map.remove(3));
		assertEquals(2, map.size());
		assertNull(map.get(3));
		assertEquals("SearchTableMap[2, 4]", map.toString());
	}

	/**
	 * Tests Map abstract data type behaviors to ensure the behaviors work as
	 * expected when using arbitrary objects as keys
	 */
	@Test
	public void testStudentMap() {
		Student s1 = new Student("J", "K", 1, 0, 0, "jk");
		Student s2 = new Student("J", "S", 2, 0, 0, "js");
		Student s3 = new Student("S", "H", 3, 0, 0, "sh");
		Student s4 = new Student("J", "J", 4, 0, 0, "jj");
		Student s5 = new Student("L", "B", 5, 0, 0, "lb");
		
		String s1String = "Student: first = J, last = K, id = 1, creditHours = 0, gpa = 0.0, unityID = jk./n";
		String s2String = "Student: first = J, last = S, id = 2, creditHours = 0, gpa = 0.0, unityID = js./n";
		String s3String = "Student: first = S, last = H, id = 3, creditHours = 0, gpa = 0.0, unityID = sh./n";
		String s4String = "Student: first = J, last = J, id = 4, creditHours = 0, gpa = 0.0, unityID = jj./n";
		String s5String = "Student: first = L, last = B, id = 5, creditHours = 0, gpa = 0.0, unityID = lb./n";
		
		// Suggestions: since search table map keys are Comparable,
		// make sure the search table works with Comparable objects like Students
		
		studentMap.put(s5, s5.getId());
		studentMap.put(s1, s1.getId());
		studentMap.put(s3, s3.getId());
		studentMap.put(s4, s4.getId());
		studentMap.put(s2, s2.getId());
		assertEquals("SearchTableMap[" + s5String + ", " + s3String + ", " + s4String + ", " + s1String + ", " + s2String + "]", studentMap.toString());
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
		assertEquals(2, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(3, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(4, (int) it.next());
		assertTrue(it.hasNext());
		assertEquals(5, (int) it.next());
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

		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		assertTrue(it.hasNext());
		Map.Entry<Integer, String> entry = it.next();
		assertEquals(1, (int) (entry.getKey()));
		assertEquals("string1", (String) (entry.getValue()));
		
		assertTrue(it.hasNext());
		Map.Entry<Integer, String> entry1 = it.next();
		assertEquals(2, (int) (entry1.getKey()));
		assertEquals("string2", (String) (entry1.getValue()));
		
		assertTrue(it.hasNext());
		Map.Entry<Integer, String> entry2 = it.next();
		assertEquals(3, (int) (entry2.getKey()));
		assertEquals("string3", (String) (entry2.getValue()));
		
		assertTrue(it.hasNext());
		Map.Entry<Integer, String> entry3 = it.next();
		assertEquals(4, (int) (entry3.getKey()));
		assertEquals("string4", (String) (entry3.getValue()));
		
		assertTrue(it.hasNext());
		Map.Entry<Integer, String> entry4 = it.next();
		assertEquals(5, (int) (entry4.getKey()));
		assertEquals("string5", (String) (entry4.getValue()));
		
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

		Iterator<String> it = map.values().iterator();
		assertTrue(it.hasNext());
		assertEquals("string1", it.next());
		assertTrue(it.hasNext());
		assertEquals("string2", it.next());
		assertTrue(it.hasNext());
		assertEquals("string3", it.next());
		assertTrue(it.hasNext());
		assertEquals("string4", it.next());
		assertTrue(it.hasNext());
		assertEquals("string5", it.next());
		assertFalse(it.hasNext());
	}
}