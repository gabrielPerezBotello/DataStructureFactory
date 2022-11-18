package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * MergeSorter sorts arrays of comparable elements using the merge sort
 * algorithm. This implementation ensures O(nlogn) worst-case runtime to sort an
 * array of n elements that are comparable.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello (gperezb)
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructs a new MergeSorter with a specified custom Comparator
	 * 
	 * @param comparator a custom Comparator to use when sorting
	 */
	public MergeSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Constructs a new MergeSorter with comparisons based on the element's natural
	 * ordering
	 */
	public MergeSorter() {
		this(null);
	}

	/**
	 * Takes an array of E elements and sorts them using the MergeSort Algorithm.
	 * 
	 * @param data the array of elements to be sorted
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sort(E[] data) {
		if (data.length >= 2) {
			int mid = data.length / 2;
			
			E[] left = (E[]) new Comparable[mid];
			E[] right = (E[]) new Comparable[data.length - 1 - (mid - 1)];
			
			// Copies elements from 0 to mid - 1 of data into left array
			for (int i = 0; i < left.length; i++) {
				left[i] = data[i];
			}
			
			// Copies elements from mid to n - 1 of data into right array
			for (int i = 0; i < right.length; i++) {
				right[i] = data[i + mid];
			}
			
			sort(left);
			sort(right);
			
			merge(left, right, data);
		}
	}

	/**
	 * Merges the left and right arrays into the newly sorted data array.
	 * 
	 * @param left  the sorted left half array to be combined
	 * @param right the sorted right half array to be combined
	 * @param data  the original list of element
	 */
	private void merge(E[] left, E[] right, E[] data) {
		int leftIndex = 0;
		int rightIndex = 0;
		
		while (leftIndex + rightIndex < data.length) {
			if (rightIndex == right.length || leftIndex < left.length && compare(left[leftIndex], right[rightIndex]) <= 0) {
				data[leftIndex + rightIndex] = left[leftIndex];
				leftIndex++;
			} else {
				data[leftIndex + rightIndex] = right[rightIndex];
				rightIndex++;
			}
		}
	}

}