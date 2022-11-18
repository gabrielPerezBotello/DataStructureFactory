package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 * @param <E> Generic object type to allow class to work with generic type
 *            objects.
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructs an InsertionSorter object.
	 */
	public InsertionSorter() {
		this(null);
	}

	/**
	 * Constructor that allows the client to specify the Comparator to be used
	 * 
	 * @param comparator the comparator being set by client
	 */
	public InsertionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Sorts a given array of integers using the Insertion Sort Algorithm. This
	 * method takes an array of integers and sorts it in ascending order.
	 * 
	 * @param data the list to be sorted
	 */
	@Override
	public void sort(E[] data) {
		for (int i = 1; i <= data.length - 1; i++) {
			E element = data[i];
			int j = i - 1;

			// Uses compareTo() method to compare the object at data[j] and element in order
			// to determine if data[j] is greater than element and if so shifts data[j] to
			// data[j+1].
			while (j >= 0 && compare(data[j], element) > 0) {
				data[j + 1] = data[j];
				j = j - 1;
			}

			data[j + 1] = element;
		}

	}

}
