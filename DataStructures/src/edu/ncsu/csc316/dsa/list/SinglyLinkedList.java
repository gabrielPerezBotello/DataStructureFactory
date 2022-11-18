package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

	/** A reference to the dummy/sentinel node at the front of the list **/
	private LinkedListNode<E> front;

	/** A reference to the last/final node in the list **/
	private LinkedListNode<E> tail;

	/** The number of elements stored in the list **/
	private int size;

	/**
	 * Constructs an empty singly-linked list
	 */
	public SinglyLinkedList() {
		front = new LinkedListNode<E>(null);
		tail = null;
		size = 0;
	}

	/**
	 * Adds an element to the specified index in the list.
	 * 
	 * @param index   the index the element will be added to in the list
	 * @param element the element being added to the list
	 */
	@Override
	public void add(int index, E element) {
		if (size == 0) {
			tail = front;
		}

		if (index == size) {
			addLast(element);
		} else if (index < size) {
			LinkedListNode<E> current = front;

			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}

			current.next = new LinkedListNode<E>(element, current.next);

			size++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns the element at the given index but does not remove the element from
	 * the list.
	 * 
	 * @param index the index at which the element is being returned from data
	 * @return element at index
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	@Override
	public E get(int index) {
		if (index <= size) {
			LinkedListNode<E> current = front;

			for (int i = 0; i <= index; i++) {
				current = current.getNext();
			}

			return current.getElement();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Removes the element from the list at the given index and returns it.
	 * 
	 * @param index the index at which the element is removed from data
	 * @return element that was removed
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	@Override
	public E remove(int index) {
		if (index < size) {
			LinkedListNode<E> current = front;

			for (int i = 0; i <= index - 1; i++) {
				current = current.getNext();
			}

			E element = current.next.data;
			current.next = current.next.next;
			size--;
			return element;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Sets the element at index equal to the given element in the parameter.
	 * 
	 * @param index   the index of the element being changed
	 * @param element the element that is replacing the old one at index
	 * @return the element that was replaced
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	@Override
	public E set(int index, E element) {
		if (index < size) {
			LinkedListNode<E> current = front;

			for (int i = 0; i <= index; i++) {
				current = current.getNext();
			}

			E temp = current.data;
			current.setElement(element);
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns the size of the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * {@inheritDoc} For a singly-linked list, this behavior has O(1) worst-case
	 * runtime.
	 * 
	 * @throws IndexOutOfBoundsException if list is empty
	 * @return the last element in the list
	 */
	@Override
	public E last() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("The list is empty");
		}
		return tail.getElement();
	}

	/**
	 * {@inheritDoc} For this singly-linked list, addLast(element) behavior has O(1)
	 * worst-case runtime.
	 * 
	 * @param element the element being added to the end of the list
	 */
	@Override
	public void addLast(E element) {
		if (size == 0) {
			tail = front;
		}
		LinkedListNode<E> newNode = new LinkedListNode<E>(element);
		tail.setNext(newNode);
		tail = newNode;
		size++;
	}

	/**
	 * Returns a newly constructed ElementIterator to be used to traverse the list
	 * of this class.
	 * 
	 * @return Iterator an ElementIterator object that can be used to traverse the
	 *         list
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/**
	 * Inner Class for creating ElementIterators in this class. Contains methods
	 * necessary to implement previous and next traversal.
	 * 
	 * @author Gabriel Perez-Botello
	 *
	 */
	private class ElementIterator implements Iterator<E> {
		/**
		 * Keep track of the next node that will be processed
		 */
		private LinkedListNode<E> current;

		/**
		 * Keep track of the node that was processed on the last call to 'next'
		 */
		private LinkedListNode<E> previous;

		/**
		 * Keep track of the previous-previous node that was processed so that we can
		 * update 'next' links when removing
		 */
		private LinkedListNode<E> previousPrevious;

		/**
		 * Keep track of whether it's ok to remove an element (based on whether next()
		 * has been called immediately before remove())
		 */
		private boolean removeOK;

		/**
		 * Construct a new element iterator where the cursor is initialized to the
		 * beginning of the list.
		 */
		public ElementIterator() {
			removeOK = false;
			previous = front;
			previousPrevious = front;
			current = front;
		}

		/**
		 * Determines if there is a next node.
		 * 
		 * @return boolean determining if there is another node after the current one
		 */
		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		/**
		 * Moves the iterator to the next node and updates the pointers accordingly.
		 * 
		 * @return element in the new node
		 * @throws NoSuchElementException if there is no next node
		 */
		@Override
		public E next() {
			if (hasNext()) {
				previousPrevious = previous;
				previous = current;
				current = current.next;
				removeOK = true;
				return current.data;
			} else {
				throw new NoSuchElementException();
			}
		}

		/**
		 * Removes the element passed by the most recent next() call. If no next call
		 * has been made then remove cannot be done.
		 * 
		 * @throws IllegalStateException if removeOK is false
		 */
		@Override
		public void remove() {
			if (removeOK) {
				previousPrevious.next = current;
				previous = previousPrevious;
				removeOK = false;
				size--;
			} else {
				throw new IllegalStateException();
			}
		}
	}

	private static class LinkedListNode<E> {
		/** The data element in the current node. */
		private E data;
		// the generic E type is from the class header of the LinkedListNode,
		// not from the outer class

		/** The next node in the list. */
		private LinkedListNode<E> next;

		/**
		 * Constructs a LinkedListNode that has its data set to the given element and
		 * next is equal to null.
		 * 
		 * @param element the element for the new LinkedListNode
		 */
		public LinkedListNode(E element) {
			data = element;
			next = null;
		}

		/**
		 * Constructs a LinkedListNode that has its data and next reference set equal to
		 * the given ones in the parameter.
		 * 
		 * @param element the element the node contains
		 * @param next    the next reference to a node
		 */
		public LinkedListNode(E element, LinkedListNode<E> next) {
			data = element;
			this.next = next;
		}

		/**
		 * Returns the next LinkedListNode in the list.
		 * 
		 * @return the next LinkedListNode in the list
		 */
		public LinkedListNode<E> getNext() {
			return this.next;
		}

		/**
		 * Returns the element at the current list node.
		 * 
		 * @return E the element in the current list node
		 */
		public E getElement() {
			return data;
		}

		/**
		 * Sets the current next reference the one given in the parameter of this
		 * method.
		 * 
		 * @param newNext the new Next reference for the node
		 */
		public void setNext(LinkedListNode<E> newNext) {
			next = newNext;
		}

		/**
		 * Sets the current data element to the one given in the parameter of this
		 * method.
		 * 
		 * @param newData the new data element that will replace the current one.
		 */
		public void setElement(E newData) {
			data = newData;
		}

	}

}