package edu.ncsu.csc316.dsa.queue;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for ArrayBasedQueue. Checks the expected outputs of the Queue
 * abstract data type behaviors when using a circular array-based data structure
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class ArrayBasedQueueTest {
	/** Queue object filled with String objects to be used for testing. */
	private Queue<String> queue;

	/**
	 * Create a new instance of a circular array-based queue before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		queue = new ArrayBasedQueue<String>();
	}

	/**
	 * Test the output of the enqueue(e) behavior
	 */
	@Test
	public void testEnqueue() {
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());

		queue.enqueue("one");
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());

		queue.enqueue("two");
		assertEquals(2, queue.size());
		assertFalse(queue.isEmpty());

		queue.enqueue("three");
		queue.enqueue("four");
		assertEquals(4, queue.size());
		assertFalse(queue.isEmpty());
	}

	/**
	 * Test the output of the dequeue(e) behavior, including expected exceptions
	 */
	@Test
	public void testDequeue() {
		assertEquals(0, queue.size());
		try {
			queue.dequeue();
			fail("NoSuchElementException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");

		String element = queue.dequeue();

		assertEquals(3, queue.size());
		assertEquals("one", element);
		assertFalse(queue.isEmpty());

		element = queue.dequeue();

		assertEquals(2, queue.size());
		assertEquals("two", element);

		element = queue.dequeue();

		assertEquals(1, queue.size());
		assertEquals("three", element);

		element = queue.dequeue();

		assertEquals(0, queue.size());
		assertEquals("four", element);
		assertTrue(queue.isEmpty());

		try {
			queue.dequeue();
			fail("NoSuchElementException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}
		
		queue.enqueue("one");
		assertEquals(1, queue.size());
		assertEquals("one", queue.front());
		assertFalse(queue.isEmpty());
		
		queue.enqueue("two");
		assertEquals(2, queue.size());
		assertEquals("one", queue.front());
		assertFalse(queue.isEmpty());
		
		queue.enqueue("three");
		assertEquals(3, queue.size());
		assertEquals("one", queue.front());
		assertFalse(queue.isEmpty());
		
		queue.enqueue("four");
		assertEquals(4, queue.size());
		assertEquals("one", queue.front());
		assertFalse(queue.isEmpty());
		
		queue.enqueue("five");
		assertEquals(5, queue.size());
		assertEquals("one", queue.front());
		assertFalse(queue.isEmpty());
	}

	/**
	 * Test the output of the front() behavior, including expected exceptions
	 */
	@Test
	public void testFront() {
		assertEquals(0, queue.size());
		try {
			queue.front();
			fail("NoSuchElementException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		queue.enqueue("one");

		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());

		String element = queue.front();

		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals("one", element);

		queue.enqueue("two");

		element = queue.front();

		assertEquals(2, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals("one", element);

		queue.enqueue("three");

		element = queue.front();

		assertEquals(3, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals("one", element);

		queue.enqueue("four");

		element = queue.front();

		assertEquals(4, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals("one", element);
	}

}