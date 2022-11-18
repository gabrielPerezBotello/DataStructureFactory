package edu.ncsu.csc316.dsa.stack;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for LinkedStack. Checks the expected outputs of the Stack abstract
 * data type behaviors when using a singly-linked list data structure
 *
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 */
public class LinkedStackTest {
	/** Stack object with string elements to be used for testing. */
	private Stack<String> stack;

	/**
	 * Create a new instance of a linked list-based stack before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		stack = new LinkedStack<String>();
	}

	/**
	 * Test the output of the push(e) behavior
	 */
	@Test
	public void testPush() {
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());

		stack.push("one");
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());

		stack.push("two");
		stack.push("three");

		assertEquals(3, stack.size());
		assertFalse(stack.isEmpty());

		stack.push("four");
		stack.push("five");

		assertEquals(5, stack.size());
		assertFalse(stack.isEmpty());
	}

	/**
	 * Test the output of the pop() behavior, including expected exceptions
	 */
	@Test
	public void testPop() {
		assertEquals(0, stack.size());

		try {
			stack.pop();
			fail("EmptyStackException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}

		stack.push("one");
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());

		stack.push("two");
		stack.push("three");
		stack.push("four");

		assertEquals(4, stack.size());
		assertFalse(stack.isEmpty());

		String element = stack.pop();

		assertEquals(3, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals("four", element);

		stack.pop();
		element = stack.pop();

		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals("two", element);

		element = stack.pop();

		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
		assertEquals("one", element);

		try {
			stack.pop();
			fail("EmptyStackException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}
	}

	/**
	 * Test the output of the top() behavior, including expected exceptions
	 */
	@Test
	public void testTop() {
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());

		try {
			stack.top();
			fail("EmptyStackException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}

		stack.push("one");

		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());

		String element = stack.top();

		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals("one", element);

		stack.push("two");
		stack.push("three");

		element = stack.top();

		assertEquals(3, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals("three", element);

		stack.push("four");

		element = stack.top();

		assertEquals(4, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals("four", element);
	}

}