package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	/**
	 * The initial capacity of the list if the client does not provide a capacity
	 * when constructing an instance of the array-based list
	 **/
	private final static int DEFAULT_CAPACITY = 0;

	/** The array in which elements will be stored **/
	private E[] data;

	/** The number of elements stored in the array-based list data structure **/
	private int size;

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * default initial capacity of the internal array
	 */
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * provided initial capacity
	 * 
	 * @param capacity the initial capacity of the internal array used to store the
	 *                 list elements
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	/**
	 * To ensure amortized O(1) cost for adding to the end of the array-based list,
	 * use the doubling strategy on each resize. Here, we add +1 after doubling to
	 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
	 * still produce a capacity of 0).
	 * 
	 * @param minCapacity the minimum capacity that must be supported by the
	 *                    internal array
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = oldCapacity * 2 + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	/**
	 * Adds an element to the specified index in the array.
	 * 
	 * @param index   the index the element will be added to in the array
	 * @param element the element being added to the array
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	@Override
	public void add(int index, E element) {
		checkIndexForAdd(index);
		ensureCapacity(size + 1);

		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}

		data[index] = element;

		size++;

	}

	/**
	 * Returns the element at the given index but does not remove the element from
	 * the array.
	 * 
	 * @param index the index at which the element is being returned from data
	 * @return element at index
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	@Override
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	/**
	 * Removes the element from the list at the given index and returns it.
	 * 
	 * @param index the index at which the element is removed from data
	 * @return element that was removed
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	@Override
	public E remove(int index) {
		checkIndex(index);
		E element = get(index);

		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}

		size--;

		return element;
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
		checkIndex(index);
		E oldElement = get(index);

		data[index] = element;

		return oldElement;
	}

	/**
	 * Returns the size of the array
	 */
	@Override
	public int size() {
		return size;
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
	 * An inner class of ArrayBasedList that creates an ElementIterator in order to
	 * iterate through the ArrayBasedList in a more efficient runtime.
	 */
	private class ElementIterator implements Iterator<E> {
		/** The position within the list. */
		private int position;
		/** Determines if it is okay to remove. */
		private boolean removeOK;

		/**
		 * Construct a new element iterator where the cursor is initialized to the
		 * beginning of the list.
		 */
		public ElementIterator() {
			this.position = 0;
			removeOK = false;
		}

		/**
		 * Checks to see if there is a next element to traverse too within the list.
		 * 
		 * @return boolean determining if there is another element to go to
		 */
		@Override
		public boolean hasNext() {
			return position < size;
		}

		/**
		 * Goes to the next position in the list and returns the element at that
		 * position. Throws NoSuch
		 * 
		 * @throws NoSuchElementException if there is no next element to traverse to
		 * @return E element in the next position
		 */
		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			position++;
			removeOK = true;
			return get(position - 1);
		}

		/**
		 * Removes the element last returned by next from the list.
		 */
		@Override
		public void remove() {
			if (removeOK) {
				ArrayBasedList.this.remove(position - 1);
				position--;
				removeOK = false;
			} else {
				throw new IllegalStateException();
			}
		}
	}
}