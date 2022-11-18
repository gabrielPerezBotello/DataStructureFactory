package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {
	/**
	 * Sorts data using the Radix Sorting Algorithm.
	 * 
	 * @param data array of generic type containing elements to be sorted
	 */
	public void sort(E[] data) {
		int max = 0;

		for (int i = 0; i <= data.length - 1; i++) {
			max = Math.max(max, data[i].getId());
		}

		int numMaxDigit = (int) (Math.ceil(Math.log(max + 1) / Math.log(10)));

		int digit = 1;

		for (int j = 1; j <= numMaxDigit; j++) {
			int[] sorted = new int[10];

			for (int i = 0; i <= data.length - 1; i++) {
				sorted[(data[i].getId() / digit) % 10] = sorted[(data[i].getId() / digit) % 10] + 1;
			}

			for (int i = 1; i <= 9; i++) {
				sorted[i] = sorted[i - 1] + sorted[i];
			}

			@SuppressWarnings("unchecked")
			E[] sortedElements = (E[]) (new Identifiable[data.length]);

			for (int i = data.length - 1; i >= 0; i--) {
				sortedElements[sorted[(data[i].getId() / digit) % 10] - 1] = data[i];
				sorted[(data[i].getId() / digit) % 10] = sorted[(data[i].getId() / digit) % 10] - 1;
			}

			for (int i = 0; i <= data.length - 1; i++) {
				data[i] = sortedElements[i];
			}

			digit = digit * 10;
		}
	}
}
