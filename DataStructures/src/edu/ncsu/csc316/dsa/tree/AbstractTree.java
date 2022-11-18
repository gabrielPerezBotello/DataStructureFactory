package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;

/**
 * A skeletal implementation of the Tree abstract data type. This class provides
 * implementation for common methods that can be implemented the same no matter
 * what specific type of concrete data structure is used to implement the tree
 * abstract data type.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the tree
 */
public abstract class AbstractTree<E> implements Tree<E> {

	@Override
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	@Override
	public boolean isLeaf(Position<E> p) {
		return numChildren(p) == 0;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public E set(Position<E> p, E value) {
		AbstractTreeNode<E> tempNode = validate(p);

		E oldVal = (E) tempNode.getElement();

		tempNode.setElement(value);

		return oldVal;

	}

	@Override
	public Iterable<Position<E>> preOrder() {
		PositionCollection traversal = new PositionCollection();
		if (!isEmpty()) {
			preOrderHelper(root(), traversal);
		}
		return traversal;
	}

	private void preOrderHelper(Position<E> p, PositionCollection traversal) {
		if (p != null) {
			traversal.add(p);
		}
		for (Position<E> c : children(p)) {
			preOrderHelper(c, traversal);
		}
	}

	@Override
	public Iterable<Position<E>> postOrder() {
		PositionCollection traversal = new PositionCollection();
		if (!isEmpty()) {
			postOrderHelper(root(), traversal);
		}
		return traversal;
	}

	private void postOrderHelper(Position<E> p, PositionCollection traversal) {
		for (Position<E> c : children(p)) {
			postOrderHelper(c, traversal);
		}

		if (p != null) {
			traversal.add(p);
		}
	}

	@Override
	public Iterable<Position<E>> levelOrder() {
		PositionCollection traversal = new PositionCollection();
		if (!isEmpty()) {
			levelOrderHelper(root(), traversal);
		}
		return traversal;
	}

	private void levelOrderHelper(Position<E> p, PositionCollection traversal) {
		ArrayBasedQueue<Position<E>> queue = new ArrayBasedQueue<Position<E>>();

		queue.enqueue(p);

		Position<E> q = validate(p);

		while (!queue.isEmpty()) {
			q = queue.dequeue();

			if (q != null) {
				traversal.add(q);
			}

			for (Position<E> c : children(q)) {
				queue.enqueue(c);
			}
		}
	}

	/**
	 * Safely casts a Position, p, to be an AbstractTreeNode.
	 * 
	 * @param p the position to cast to a AbstractTreeNode
	 * @return a reference to the AbstractTreeNode
	 * @throws IllegalArgumentException if p is null, or if p is not a valid
	 *                                  AbstractTreeNode
	 */
	protected abstract AbstractTreeNode<E> validate(Position<E> p);

	/**
	 * AbstractTreeNode protected static class to be used for implementing tree adt.
	 * 
	 * @author Gabriel Perez-Botello
	 *
	 * @param <E> the generic type to be used in this class.
	 */
	protected abstract static class AbstractTreeNode<E> implements Position<E> {
		/** Element for the AbstractTreeNode object. */
		private E element;

		public AbstractTreeNode(E element) {
			setElement(element);
		}

		@Override
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[\n");
		toStringHelper(sb, "", root());
		sb.append("]");
		return sb.toString();
	}

	private void toStringHelper(StringBuilder sb, String indent, Position<E> root) {
		if (root == null) {
			return;
		}
		sb.append(indent).append(root.getElement()).append("\n");
		for (Position<E> child : children(root)) {
			toStringHelper(sb, indent + " ", child);
		}
	}

	/**
	 * PositionCollection implements the {@link Iterable} interface to allow
	 * traversing through the positions of the tree. PositionCollection does not
	 * allow removal operations
	 * 
	 * @author Dr. King
	 *
	 */
	protected class PositionCollection implements Iterable<Position<E>> {
		/** List object field to be used for this inner class. */
		private List<Position<E>> list;

		/**
		 * Construct a new PositionCollection
		 */
		public PositionCollection() {
			list = new SinglyLinkedList<Position<E>>();
		}

		/**
		 * Add a position to the collection. Null positions or positions with null
		 * elements are not added to the collection
		 * 
		 * @param position the position to add to the collection
		 */
		public void add(Position<E> position) {
			if (position != null && position.getElement() != null) {
				list.addLast(position);
			}
		}

		/**
		 * Return an iterator for the PositionCollection
		 * 
		 * @return Iterator object that iterates through Position objects with a generic
		 *         type E
		 */
		public Iterator<Position<E>> iterator() {
			return new PositionSetIterator();
		}

		private class PositionSetIterator implements Iterator<Position<E>> {
			/** Iterator object field to be used for this inner class. */
			private Iterator<Position<E>> it;

			public PositionSetIterator() {
				it = list.iterator();
			}

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public Position<E> next() {
				return it.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("The remove operation is not supported yet.");
			}
		}
	}
}