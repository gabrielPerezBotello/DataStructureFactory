package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * The Linked Stack is implemented as a singly-linked list data structure to
 * support efficient, O(1) worst-case Stack abstract data type behaviors.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the stack
 */
public class LinkedStack<E> extends AbstractStack<E> {

	/** Delegate to our existing singly linked list class **/
	private SinglyLinkedList<E> list;

	/**
	 * Construct a new singly-linked list to use when modeling the last-in-first-out
	 * paradigm for the stack abstract data type.
	 */
	public LinkedStack() {
		list = new SinglyLinkedList<E>();
	}

	/**
	 * Places the element at the top of our stack.
	 * 
	 * @param element the element to be added to the top of the stack
	 */
	public void push(E element) {
		list.addFirst(element);
	}

	/**
	 * Returns the current element at the top of our stack and removes it from the
	 * stack.
	 * 
	 * @return E element at top of the stack
	 * @throws EmptyStackException if there are no elements in the stack
	 */
	public E pop() {
		try {
			return list.removeFirst();
		} catch (Exception e) {
			throw new EmptyStackException();
		}
	}

	/**
	 * Returns the element at the top of the stack but does not remove it from the
	 * stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws EmptyStackException if there are no elements in the stack
	 */
	public E top() {
		try {
			return list.get(0);
		} catch (Exception e) {
			throw new EmptyStackException();
		}
	}

	/**
	 * Returns the size of the stack.
	 * 
	 * @return int representing total number of elements in the stack
	 */
	public int size() {
		return list.size();
	}
}