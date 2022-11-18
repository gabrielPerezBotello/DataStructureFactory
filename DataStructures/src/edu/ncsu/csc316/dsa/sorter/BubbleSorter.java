package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Uses the Bubble Sorter algorithm to sort through objects.
 * 
 * @author Gabriel Perez-Botello
 * @param <E> the generic type to be used for sorting
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	/**
	 * Constructor that takes a custom comparator.
	 * 
	 * @param comparator the comparator to be used for sorting
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Default parameterless constructor for BubbleSorter objects.
	 */
	public BubbleSorter() {
		super(null);
	}

	/**
	 * Sorts a given array of elements using the bubble sort algorithm.
	 * 
	 * @param data the array of elements to be sorted
	 */
	public void sort(E[] data) {
		boolean repeat = true;

		while (repeat) {
			repeat = false;

			for (int i = 1; i <= data.length - 1; i++) {
				if (compare(data[i], data[i - 1]) < 0) {
					// Swaps the elements around
					E temp = data[i - 1];
					data[i - 1] = data[i];
					data[i] = temp;
					repeat = true;
				}
			}
		}
	}
}
