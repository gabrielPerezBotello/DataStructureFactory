package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Abstract class that contains common functionality between InsertionSorter and
 * SelectionSorter classes.
 * 
 * @author Gabriel Perez-Botello gperezb
 *
 * @param <E> the generic object type
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {
	/** Comparator object with generic type to aid in selecting the sorting type. */
	private Comparator<E> comparator;

	/**
	 * AbstractComparisonSorter object constructor that takes a comparator
	 * parameter. It then sets the comparator field to this given comparator.
	 * 
	 * @param comparator the comparator to be used when sorting
	 */
	public AbstractComparisonSorter(Comparator<E> comparator) {
		super();
		setComparator(comparator);
	}

	/**
	 * Sets the comparator to be used when sorting.
	 * 
	 * @param comparator the comparator to be used when sorting
	 */
	private void setComparator(Comparator<E> comparator) {
		if (comparator == null) {
			this.comparator = new NaturalOrder();
		} else {
			this.comparator = comparator;
		}
	}

	/**
	 * Private inner class to help with the default sorting referred to as the
	 * Natural Order.
	 * 
	 * @author Gabriel Perez-Botello gperezb
	 */
	private class NaturalOrder implements Comparator<E> {
		/**
		 * Compares two elements of the generic type to determine which should come
		 * before the other.
		 * 
		 * @param first  the first element to be compared
		 * @param second the second element to be compared
		 * @return int determining the order that the two elements should be sorted in
		 */
		public int compare(E first, E second) {
			return ((Comparable<E>) first).compareTo(second);
		}
	}

	/**
	 * Compares two given pieces of data and returns an integer representing in what
	 * order the two pieces of data should be in.
	 * 
	 * @param data1 the first piece of data to be used in the comparison
	 * @param data2 the second piece of data to be used in the comparison
	 * @return int determining the order that the 2 elements should be in
	 */
	public int compare(E data1, E data2) {
		return this.comparator.compare(data1, data2);
	}
}