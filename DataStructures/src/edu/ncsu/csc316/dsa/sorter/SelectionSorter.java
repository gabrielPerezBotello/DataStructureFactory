package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello gperezb
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructs a SelectionSorter object and sets the comparator to the provided
	 * one.
	 * 
	 * @param comparator the comparator that is to be used when sorting
	 */
	public SelectionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Constructs a SelectionSorter object and sets the comparator to be null. one.
	 * 
	 */
	public SelectionSorter() {
		super(null);
	}

	/**
	 * Sorts the given array of data using the Selection Sort Algorithm.
	 * 
	 * @param data the data to be sorted
	 */
	public void sort(E[] data) {
		// Initializes min to be used to contain the smallest element in data.
		int min = 0;
		// Initializes x to be used to contain a temporary value when performing a swap
		// later in this method.
		E x = null;

		for (int i = 0; i <= data.length - 1; i++) {
			min = i;

			for (int j = i + 1; j <= data.length - 1; j++) {
				if (compare(data[j], data[min]) < 0) {
					min = j;
				}
			}

			if (i != min) {
				x = data[i];
				data[i] = data[min];
				data[min] = x;
			}
		}
	}
}
