package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello gperezb
 *
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {
	/**
	 * Sorts the data using the Counting Sort Algorithm.
	 * 
	 * @param data an array of elements to be used in sorting
	 */
	public void sort(E[] data) {
		int min = data[0].getId();
		int max = data[0].getId();

		for (int i = 0; i <= data.length - 1; i++) {
			min = Math.min(data[i].getId(), min);
			max = Math.max(data[i].getId(), max);
		}

		int range = max - min + 1;

		int[] placeHolder = new int[range];

		for (int i = 0; i <= data.length - 1; i++) {
			placeHolder[data[i].getId() - min] = placeHolder[data[i].getId() - min] + 1;
		}

		for (int i = 1; i <= range - 1; i++) {
			placeHolder[i] = placeHolder[i - 1] + placeHolder[i];
		}

		@SuppressWarnings("unchecked")
		E[] freqCount = (E[]) (new Identifiable[data.length]);

		for (int i = data.length - 1; i >= 0; i--) {
			freqCount[placeHolder[data[i].getId() - min] - 1] = data[i];
			placeHolder[data[i].getId() - min] = placeHolder[data[i].getId() - min] - 1;
		}

		for (int i = 0; i <= data.length - 1; i++) {
			data[i] = freqCount[i];
		}
	}
}
