package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for PositionalLinkedList. Checks the expected outputs of the
 * Positional List abstract data type behaviors when using an doubly-linked
 * positional list data structure
 *
 * @author Dr. King
 *
 */
public class PositionalLinkedListTest {
	/** Makes a PositionalList object containing String objects for testing. */
	private PositionalList<String> list;

	/**
	 * Create a new instance of an positional linked list before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		list = new PositionalLinkedList<String>();
	}

	/**
	 * Test the output of the first() behavior, including expected exceptions
	 */
	@Test
	public void testFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		assertNull(list.first());

		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertEquals("one", list.first().getElement());
		assertEquals(first, list.first());

		Position<String> f2 = list.addFirst("two");
		assertEquals(2, list.size());
		assertEquals("two", list.first().getElement());
		assertEquals(f2, list.first());

		Position<String> f3 = list.addFirst("three");
		assertEquals(3, list.size());
		assertEquals("three", list.first().getElement());
		assertEquals(f3, list.first());

		Position<String> f4 = list.addFirst("four");
		assertEquals(4, list.size());
		assertEquals("four", list.first().getElement());
		assertEquals(f4, list.first());
	}

	/**
	 * Test the output of the last() behavior, including expected exceptions
	 */
	@Test
	public void testLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		assertNull(list.first());

		Position<String> last = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals("one", list.last().getElement());
		assertEquals(last, list.last());

		Position<String> l2 = list.addLast("two");
		assertEquals(2, list.size());
		assertEquals("two", list.last().getElement());
		assertEquals(l2, list.last());

		Position<String> l3 = list.addLast("three");
		assertEquals(3, list.size());
		assertEquals("three", list.last().getElement());
		assertEquals(l3, list.last());

		Position<String> l4 = list.addLast("four");
		assertEquals(4, list.size());
		assertEquals("four", list.last().getElement());
		assertEquals(l4, list.last());
	}

	/**
	 * Test the output of the addFirst(element) behavior
	 */
	@Test
	public void testAddFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		list.addFirst("one");
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());

		list.addFirst("two");
		assertEquals(2, list.size());
		assertFalse(list.isEmpty());

		list.addFirst("two");
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());

		list.addFirst("two");
		assertEquals(4, list.size());
		assertFalse(list.isEmpty());
	}

	/**
	 * Test the output of the addLast(element) behavior
	 */
	@Test
	public void testAddLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		list.addLast("one");
		assertEquals(1, list.size());

		list.addLast("two");
		assertEquals(2, list.size());

		list.addLast("three");
		assertEquals(3, list.size());

		list.addLast("four");
		assertEquals(4, list.size());
	}

	/**
	 * Test the output of the before(position) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testBefore() {
		Position<String> first = list.addLast("one");
		assertEquals(null, list.before(first));

		Position<String> f2 = list.addLast("two");
		assertEquals(first, list.before(f2));

		Position<String> f3 = list.addLast("two");
		assertEquals(f2, list.before(f3));

		Position<String> f4 = list.addLast("two");
		assertEquals(f3, list.before(f4));

	}

	/**
	 * Test the output of the after(position) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testAfter() {
		Position<String> first = list.addLast("one");
		assertEquals(null, list.after(first));

		Position<String> f2 = list.addLast("two");
		assertEquals(f2, list.after(first));

		Position<String> f3 = list.addLast("two");
		assertEquals(f3, list.after(f2));

		Position<String> f4 = list.addLast("two");
		assertEquals(f4, list.after(f3));
	}

	/**
	 * Test the output of the addBefore(position, element) behavior, including
	 * expected exceptions
	 */
	@Test
	public void testAddBefore() {
		Position<String> first = list.addLast("one");
		assertEquals(null, list.before(first));

		Position<String> f2 = list.addBefore(first, "two");
		assertEquals(first, list.after(f2));

		Position<String> f3 = list.addBefore(f2, "two");
		assertEquals(f2, list.after(f3));

		Position<String> f4 = list.addBefore(f3, "two");
		assertEquals(f3, list.after(f4));
	}

	/**
	 * Test the output of the addAfter(position, element) behavior, including
	 * expected exceptions
	 */
	@Test
	public void testAddAfter() {
		Position<String> first = list.addLast("one");
		assertEquals(null, list.after(first));

		Position<String> f2 = list.addAfter(first, "two");
		assertEquals(f2, list.after(first));

		Position<String> f3 = list.addAfter(f2, "three");
		assertEquals(f3, list.after(f2));

		Position<String> f4 = list.addAfter(f3, "four");
		assertEquals(f4, list.after(f3));
	}

	/**
	 * Test the output of the set(position, element) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testSet() {
		Position<String> first = list.addLast("one");
		assertEquals(null, list.after(first));

		Position<String> f2 = list.addAfter(first, "two");
		assertEquals(f2, list.after(first));

		Position<String> f3 = list.addAfter(f2, "three");
		assertEquals(f3, list.after(f2));

		Position<String> f4 = list.addAfter(f3, "four");
		assertEquals(f4, list.after(f3));
		
		String element = list.set(f2, "hello");
		assertEquals("two", element);
		assertEquals(4, list.size());
	}

	/**
	 * Test the output of the remove(position) behavior, including expected
	 * exceptions
	 */
	@Test
	public void testRemove() {
		Position<String> first = list.addLast("one");
		assertEquals(null, list.after(first));

		Position<String> f2 = list.addAfter(first, "two");
		assertEquals(f2, list.after(first));

		Position<String> f3 = list.addAfter(f2, "three");
		assertEquals(f3, list.after(f2));

		Position<String> f4 = list.addAfter(f3, "four");
		assertEquals(f4, list.after(f3));
		
		String element = list.remove(f2);
		assertEquals(3, list.size());
		assertEquals("two", element);
		
		element = list.remove(f4);
		assertEquals(2, list.size());
		assertEquals("four", element);
		assertEquals(f3.getElement(), list.last().getElement());
	}

	/**
	 * Test the output of the iterator behavior for elements in the list, including
	 * expected exceptions
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
		Position<String> first = list.addLast("one");

		// Use accessor methods to check that the list is correct
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("one", first.getElement());

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
		// Use your ArrayBasedList and SinglyLinkedList test cases as a guide
	}

	/**
	 * Test the output of the positions() behavior to iterate through positions in
	 * the list, including expected exceptions
	 */
	@Test
	public void testPositions() {
		assertEquals(0, list.size());
		Position<String> first = list.addFirst("one");
		Position<String> second = list.addLast("two");
		Position<String> third = list.addLast("three");
		assertEquals(3, list.size());

		Iterator<Position<String>> it = list.positions().iterator();
		assertTrue(it.hasNext());
		assertEquals(first, it.next());
		assertEquals(second, it.next());
		assertEquals(third, it.next());
	}

}