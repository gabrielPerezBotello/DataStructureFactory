package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

	/** A dummy/sentinel node representing at the front of the list **/
	private PositionalNode<E> front;

	/** A dummy/sentinel node representing at the end/tail of the list **/
	private PositionalNode<E> tail;

	/** The number of elements in the list **/
	private int size;

	/**
	 * Constructs an empty positional linked list
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}

	/**
	 * Helper method to add a new node between two nodes and returns its position.
	 * 
	 * @param element the element of the new node
	 * @param next    the next reference for new node
	 * @param prev    the previous reference for new node
	 * @return position of new node within the list
	 */
	private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> newNodePos = new PositionalNode<E>(element, next, prev);

		next.setPrevious(newNodePos);
		prev.setNext(newNodePos);
		size++;

		return newNodePos;
	}

	/**
	 * Adds a new PositionalNode after the given pos with the element as its
	 * element. Returns the position of the new node.
	 * 
	 * @param pos     the position we are adding after
	 * @param element the element we are giving the new nodes
	 * @return position of new node
	 */
	public Position<E> addAfter(Position<E> pos, E element) {
		PositionalNode<E> posNode = validate(pos);

		return addBetween(element, posNode.getNext(), posNode);
	}

	/**
	 * Adds a new PositionalNode before the given pos with the element as its
	 * element. Returns the position of the new node.
	 * 
	 * @param pos     the position we are adding before
	 * @param element the element we are giving the new node
	 * @return position of new node
	 */
	public Position<E> addBefore(Position<E> pos, E element) {
		PositionalNode<E> posNode = validate(pos);

		return addBetween(element, posNode, posNode.getPrevious());
	}

	/**
	 * Adds a new PositionalNode at the beginning of the list with the given element
	 * as its element. Returns the position of the node.
	 * 
	 * @param element the element of the new node
	 * @return position of the new node
	 */
	public Position<E> addFirst(E element) {
		return addBetween(element, front.getNext(), front);
	}

	/**
	 * Adds a new PositionalNode at the end of the list with the given element.
	 * Returns the position of the new node.
	 * 
	 * @param element the element of the new node
	 * @return position of the new node
	 */
	public Position<E> addLast(E element) {
		return addBetween(element, tail, tail.getPrevious());
	}

	/**
	 * Returns the position of the node after the given position.
	 * 
	 * @param pos the position we are starting at
	 * @return the position of the node after pos
	 */
	public Position<E> after(Position<E> pos) {
		PositionalNode<E> posNode = validate(pos);

		if (posNode.next.getElement() == null) {
			return null;
		}

		return posNode.getNext();
	}

	/**
	 * Returns the position of the node before the given position.
	 * 
	 * @param pos the position we are starting at
	 * @return the position of the node before pos
	 */
	public Position<E> before(Position<E> pos) {
		PositionalNode<E> posNode = validate(pos);

		if (posNode.previous.getElement() == null) {
			return null;
		}

		return posNode.getPrevious();
	}

	/**
	 * Returns the position of the first node in the list.
	 * 
	 * @return the first node in the list
	 */
	public Position<E> first() {
		if (size == 0) {
			return null;
		}

		return front.getNext();
	}

	/**
	 * Returns the position of the last node in the list.
	 * 
	 * @return the last node in the list
	 */
	public Position<E> last() {
		if (size == 0) {
			return null;
		}

		return tail.getPrevious();
	}

	/**
	 * Determines if the list is empty.
	 * 
	 * @return boolean determining if list is empty, true = empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the element and returns the element at position.
	 * 
	 * @param position the position at which the node is being removed
	 * @return the original element at the position
	 */
	public E remove(Position<E> position) {
		E temp = position.getElement();

		PositionalNode<E> posNode = validate(position);

		posNode.getPrevious().setNext(posNode.next);
		posNode.getNext().setPrevious(posNode.previous);

		size--;

		return temp;
	}

	/**
	 * Sets the element in the node at the given position and returns the original
	 * element.
	 * 
	 * @param pos     the position of the node being changed
	 * @param element the element replacing the old one
	 * @return original element from list
	 */
	public E set(Position<E> pos, E element) {
		E temp = pos.getElement();

		PositionalNode<E> posNode = validate(pos);

		posNode.setElement(element);

		return temp;
	}

	/**
	 * Returns the size of the list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Safely casts a Position, p, to be a PositionalNode.
	 * 
	 * @param p the position to cast to a PositionalNode
	 * @return a reference to the PositionalNode
	 * @throws IllegalArgumentException if p is null, or if p is not a valid
	 *                                  PositionalNode
	 */
	private PositionalNode<E> validate(Position<E> p) {
		if (p instanceof PositionalNode) {
			return (PositionalNode<E>) p;
		}
		throw new IllegalArgumentException("Position is not a valid positional list node.");
	}

	/**
	 * Returns an Iterator object
	 * 
	 * @return new ElementIterator object
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/**
	 * Returns new PositionIterable object.
	 * 
	 * @return PositionIterable object
	 */
	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/**
	 * Private Inner Class to manage PositionIterable objects.
	 * 
	 * @author Gabriel Perez-Botello
	 *
	 */
	private class PositionIterable implements Iterable<Position<E>> {
		/**
		 * Returns a new PositionIterator object.
		 * 
		 * @return new PositionIterator object
		 */
		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}

	/**
	 * Private inner class to create the PositionIterator object to be used to
	 * iterate within our list.
	 * 
	 * @author Gabriel Perez-Botello
	 *
	 */
	private class PositionIterator implements Iterator<Position<E>> {
		/** Current node the iterator is on. */
		private Position<E> current;
		/** Determines if it is ok to remove a node. */
		private boolean removeOK;

		/**
		 * Constructs a PositionIterator object to iterate through the list.
		 */
		public PositionIterator() {
			this.current = front;
			removeOK = false;
		}

		/**
		 * Determines if there is a next node following the current one.
		 * 
		 * @return boolean determining if there is a next node
		 */
		@Override
		public boolean hasNext() {
			PositionalNode<E> temp = (PositionalNode<E>) current;

			return temp.getNext().getElement() != null;
		}

		/**
		 * Checks if there is a next node, if there is it updates current to that node
		 * and returns the new position.
		 * 
		 * @return position of next node
		 * @throws NoSuchElementException if there is no next node
		 */
		@Override
		public Position<E> next() {
			PositionalNode<E> temp = (PositionalNode<E>) current;

			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			current = temp.getNext();
			removeOK = true;

			return current;
		}

		/**
		 * Checks if it is OK to remove node last called by next. If so it removes said
		 * node and updates list.
		 */
		@Override
		public void remove() {
			// TODO your code here
			// You should consider delegating to
			// the outer class's remove(position) method,
			// similar to:
			// PositionalLinkedList.this.remove(position);

			if (removeOK) {
				PositionalNode<E> temp = (PositionalNode<E>) current;
				temp.previous.previous.setNext(temp);
				current = temp;
				size--;
				removeOK = false;
			} else {
				throw new IllegalStateException();
			}
		}
	}

	/**
	 * ElementIterator Private inner class to iterate between elements within the
	 * list.
	 * 
	 * @author Gabriel Perez-Botello
	 *
	 */
	private class ElementIterator implements Iterator<E> {
		/** The iterator object to be used when iterating. */
		private Iterator<Position<E>> it;

		/**
		 * Constructs an ElementIterator to be used for iterations using the
		 * PositionIterator inner class.
		 */
		public ElementIterator() {
			it = new PositionIterator();
		}

		/**
		 * Determines if there is a next element within the list.
		 * 
		 * @return boolean determining if there is a next element
		 */
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		/**
		 * Moves the iterator to the next node and returns the element.
		 * 
		 * @return the next element in the list
		 */
		@Override
		public E next() {
			return it.next().getElement();
		}

		/**
		 * Removes the element last called by the next method.
		 */
		@Override
		public void remove() {
			it.remove();
		}
	}

	private static class PositionalNode<E> implements Position<E> {
		/** The element for the node. */
		private E element;
		/** The next node reference. */
		private PositionalNode<E> next;
		/** The previous node reference. */
		private PositionalNode<E> previous;

		/**
		 * Constructs a PositionalNode that has its element set to value and its next
		 * reference set to null.
		 * 
		 * @param value the value that will be contained in the new node
		 */
		public PositionalNode(E value) {
			this(value, null);
		}

		/**
		 * Constructs a PositionalNode that has its element set to value and its next
		 * reference set to next.
		 * 
		 * @param value the value that will be contained in the new node
		 * @param next  the next reference for the new node
		 */
		public PositionalNode(E value, PositionalNode<E> next) {
			this(value, next, null);
		}

		/**
		 * Constructs a PositionalNode that has its element set to value, its next
		 * reference set to next, and its previous reference set to prev.
		 * 
		 * @param value the value that will be contained in the new node
		 * @param next  the next reference for the new node
		 * @param prev  the previous reference for the new node
		 */
		public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
			setElement(value);
			setNext(next);
			setPrevious(prev);
		}

		/**
		 * Sets the previous reference to prev.
		 * 
		 * @param prev the new previous reference for the node
		 */
		public void setPrevious(PositionalNode<E> prev) {
			previous = prev;
		}

		/**
		 * Returns the previous reference node.
		 * 
		 * @return the previous reference node
		 */
		public PositionalNode<E> getPrevious() {
			return previous;
		}

		/**
		 * Sets the next reference to next.
		 * 
		 * @param next the new next reference for the node
		 */
		public void setNext(PositionalNode<E> next) {
			this.next = next;
		}

		/**
		 * Returns the next reference node.
		 * 
		 * @return the next reference node.
		 */
		public PositionalNode<E> getNext() {
			return next;
		}

		/**
		 * Returns the element of the current node.
		 * 
		 * @return the current element of the node
		 */
		@Override
		public E getElement() {
			return element;
		}

		/**
		 * Sets the element of the current node equal to element.
		 * 
		 * @param element the new element the node's element will be set to
		 */
		public void setElement(E element) {
			this.element = element;
		}
	}

}