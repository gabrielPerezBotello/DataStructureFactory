package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for ArrayBasedList. Checks the expected outputs of the List
 * abstract data type behaviors when using an array-based list data structure
 *
 * @author Dr. King
 *
 */
public class ArrayBasedListTest {

	/** List object that contains string objects to be used in testing. */
	private List<String> list;

	/**
	 * Create a new instance of an array-based list before each test case executes
	 */
	@Before
	public void setUp() {
		list = new ArrayBasedList<String>();
	}

	/**
	 * Test the output of the add(index, e) behavior, including expected exceptions
	 */
	@Test
	public void testAddIndex() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());

		// Use the statements above to help guide your test cases
		// for data structures: Start with an empty data structure, then
		// add an element and check the accessor method return values.
		// Then add another element and check again. Continue to keep checking
		// for special cases. For example, for an array-based list, you should
		// continue adding until you trigger a resize operation to make sure
		// the resize operation worked as expected.

		try {
			list.add(15, "fifteen");
			fail("An IndexOutOfBoundsException should have been thrown");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

	}

	/**
	 * Test the output of the addLast behavior
	 */
	@Test
	public void testAddLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		list.addLast("one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		
		list.addLast("two");
		list.addLast("three");
		list.addLast("four");
		assertEquals(4, list.size());
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertFalse(list.isEmpty());
		
		list.addLast("21");
		assertEquals(5, list.size());
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals("21", list.get(4));
		assertFalse(list.isEmpty());
	}

	/**
	 * Test the output of the last() behavior, including expected exceptions
	 */
	@Test
	public void testLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		list.addLast("one");
		assertEquals("one", list.last());
		
		list.addLast("two");
		assertEquals("two", list.last());
		list.addLast("three");
		list.addLast("four");
		assertEquals("four", list.last());
	}

	/**
	 * Test the output of the addFirst behavior
	 */
	@Test
	public void testAddFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		list.addFirst("one");
		assertEquals("one", list.get(0));
		
		list.addFirst("two");
		list.addFirst("three");
		list.addFirst("four");
		assertEquals("four", list.get(0));
		assertEquals("three", list.get(1));
		assertEquals("two", list.get(2));
		assertEquals("one", list.get(3));
		assertEquals(4, list.size());
		assertFalse(list.isEmpty());
	}

	/**
	 * Test the output of the first() behavior, including expected exceptions
	 */
	@Test
	public void testFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		list.addLast("one");
		assertEquals("one", list.first());
		
		list.addLast("two");
		assertEquals("one", list.first());
		list.addFirst("three");
		list.addLast("four");
		assertEquals("three", list.first());
	}

	/**
	 * Test the iterator behaviors, including expected exceptions
	 */
	@Test
	public void testIterator() {
		// Start with an empty list
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		// Create an iterator for the empty list
		Iterator<String> it = list.iterator();

		// Try different operations to make sure they work
		// as expected for an empty list (at this point)
		try {
			it.remove();
			fail("An IllegalStateException should have been thrown");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		assertFalse(it.hasNext());

		// Now add an element
		list.addLast("one");

		// Use accessor methods to check that the list is correct
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("one", list.get(0));

		// Create an iterator for the list that has 1 element
		it = list.iterator();

		// Try different iterator operations to make sure they work
		// as expected for a list that contains 1 element (at this point)
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertFalse(it.hasNext());
		try {
			it.next();
			fail("A NoSuchElementException should have been thrown");
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		list.addLast("two");
		list.addLast("three");
		list.addLast("four");
		
		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertTrue(it.hasNext());
		assertEquals("two", it.next());
		assertTrue(it.hasNext());
		assertEquals("three", it.next());
		assertTrue(it.hasNext());
		assertEquals("four", it.next());
		assertFalse(it.hasNext());
		
		it.remove();
		assertEquals(3, list.size());
		try {
			it.remove();
			fail("An IllegalStateException should have been thrown");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
	}

	/**
	 * Test the output of the remove(index) behavior, including expected exceptions
	 */
	@Test
	public void testRemoveIndex() {
		list.addLast("one");
		list.addLast("two");
		list.addLast("three");
		list.addLast("four");
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals(4, list.size());
		
		String test = list.remove(1);
		assertEquals("one", list.get(0));
		assertEquals("three", list.get(1));
		assertEquals("four", list.get(2));
		assertEquals(3, list.size());
		assertEquals("two", test);
		
		try {
			list.remove(15);
			fail("An IndexOutOfBoundsException should have been thrown");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

	}

	/**
	 * Test the output of the removeFirst() behavior, including expected exceptions
	 */
	@Test
	public void testRemoveFirst() {
		list.addLast("one");
		list.addLast("two");
		list.addLast("three");
		list.addLast("four");
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals(4, list.size());
		
		list.removeFirst();
		assertEquals("two", list.get(0));
		assertEquals("three", list.get(1));
		assertEquals("four", list.get(2));
		assertEquals(3, list.size());
		
		list.removeFirst();
		assertEquals("three", list.get(0));
		assertEquals("four", list.get(1));
		assertEquals(2, list.size());
	}

	/**
	 * Test the output of the removeLast() behavior, including expected exceptions
	 */
	@Test
	public void testRemoveLast() {
		list.addLast("one");
		list.addLast("two");
		list.addLast("three");
		list.addLast("four");
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals(4, list.size());
		
		list.removeLast();
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals(3, list.size());
		
		list.removeLast();
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals(2, list.size());
	}

	/**
	 * Test the output of the set(index, e) behavior, including expected exceptions
	 */
	@Test
	public void testSet() {
		list.addLast("one");
		list.addLast("two");
		list.addLast("three");
		list.addLast("four");
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals(4, list.size());
		
		list.set(1, "2");
		assertEquals("one", list.get(0));
		assertEquals("2", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals(4, list.size());
		
		list.set(3, "4");
		assertEquals("one", list.get(0));
		assertEquals("2", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("4", list.get(3));
		assertEquals(4, list.size());
		
		try {
			list.set(15, "fifteen");
			fail("An IndexOutOfBoundsException should have been thrown");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
}