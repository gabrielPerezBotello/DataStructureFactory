package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
import java.util.Random;

/**
 * QuickSorter sorts arrays of comparable elements using the quicksort
 * algorithm. This implementation allows the client to specify a specific pivot
 * selection strategy: (a) use the first element as the pivot, (b) use the last
 * element as the pivot, (c) use the middle element as the pivot, or (d) use an
 * element at a random index as the pivot.
 * 
 * Using the randomized pivot selection strategy ensures O(nlogn)
 * expected/average case runtime when sorting n elements that are comparable
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class QuickSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	/**
	 * Pivot selection strategy that uses the element at the first index each time a
	 * pivot must be selected
	 */
	public static final PivotSelector FIRST_ELEMENT_SELECTOR = new FirstElementSelector();

	/**
	 * Pivot selection strategy that uses the element at the last index each time a
	 * pivot must be selected
	 */
	public static final PivotSelector LAST_ELEMENT_SELECTOR = new LastElementSelector();

	/**
	 * Pivot selection strategy that uses the element at the middle index each time
	 * a pivot must be selected
	 */
	public static final PivotSelector MIDDLE_ELEMENT_SELECTOR = new MiddleElementSelector();

	/**
	 * Pivot selection strategy that uses the element at a randomly-chosen index
	 * each time a pivot must be selected
	 */
	public static final PivotSelector RANDOM_ELEMENT_SELECTOR = new RandomElementSelector();

	/** Tracks the client's chosen PivotSelector */
	private PivotSelector selector;

	/**
	 * Constructs a new QuickSorter with a provided custom Comparator and a
	 * specified PivotSelector strategy
	 * 
	 * @param comparator a custom comparator to use when sorting
	 * @param selector   the pivot selection strategy to use when selecting pivots
	 */
	public QuickSorter(Comparator<E> comparator, PivotSelector selector) {
		super(comparator);
		setSelector(selector);
	}

	/**
	 * Constructs a new QuickSorter using the natural ordering of elements. Pivots
	 * are selected using the provided PivotSelector strategy
	 * 
	 * @param selector the pivot selection strategy to use when selecting pivots
	 */
	public QuickSorter(PivotSelector selector) {
		this(null, selector);
	}

	/**
	 * Constructs a new QuickSorter with a provided custom Comparator and the
	 * default random pivot selection strategy
	 * 
	 * @param comparator a custom comparator to use when sorting
	 */
	public QuickSorter(Comparator<E> comparator) {
		this(comparator, null);
	}

	/**
	 * Constructs a new QuickSorter that uses an element's natural ordering and uses
	 * the random pivot selection strategy
	 */
	public QuickSorter() {
		this(null, null);
	}

	/**
	 * Takes the given select and sets the selector field equal to it in order to
	 * remember which pivot selection strategy should be used while sorting.
	 * 
	 * @param selector the selector that will be used for pivot selection
	 */
	private void setSelector(PivotSelector selector) {
		if (selector == null) {
			this.selector = new RandomElementSelector();
		} else {
			this.selector = selector;
		}
	}

	/**
	 * Sorts the given data parameter using the QuickSort Algorithm
	 * 
	 * @param data the data to be sorted
	 */
	public void sort(E[] data) {
		quickSort(data, 0, data.length - 1);
	}

	/**
	 * The start of the sorting algorithm begins here, and it attempts to find a
	 * pivot with partition. Then it recursively calls itself to sort the list of
	 * elements.
	 * 
	 * @param data the list of data being sorted
	 * @param low  the lowest index of the data to sort
	 * @param high the highest index of the data to sort
	 */
	private void quickSort(E[] data, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(data, low, high);
			
			quickSort(data, low, pivotIndex - 1);
			quickSort(data, pivotIndex + 1, high);
		}
	}

	/**
	 * Takes a list of elements and two index bounds and returns the pivot element
	 * to use for quicksorting after moving value less than pivot to be before the
	 * pivot index.
	 * 
	 * @param list the list being sorted
	 * @param low  the lowest index being sorted
	 * @param high the highest index being sorted
	 * @return the index of the pivot element
	 */
	private int partition(E[] list, int low, int high) {
		int pivotIndex = selector.selectPivot(low, high);
		
		swap(list, pivotIndex, high);
		
		return partitionHelper(list, low, high);
	}

	/**
	 * Takes a list of elements and two index bounds and returns the index of the
	 * pivot element after moving values < pivot to be before the pivot index and
	 * values > pivot to be after the pivot index.
	 * 
	 * @param list the list being sorted
	 * @param low  the lowest index being sorted
	 * @param high the highest index being sorted
	 * @return the index of the pivot element
	 */
	private int partitionHelper(E[] list, int low, int high) {
		E pivot = list[high];
		
		int index = low;
		
		for (int j = low; j < high; j++) {
			if (compare(list[j], pivot) <= 0) {
				swap(list, index, j);
				
				index++;
			}
		}
		
		swap(list, index, high);
		
		return index;
	}

	/**
	 * Takes a list of elements and swaps the pivot element to be the last element
	 * in the array.
	 * 
	 * @param list       the list of elements
	 * @param pivotIndex the index of the pivot element
	 * @param high       the index of the highest element in the list
	 */
	private void swap(E[] list, int pivotIndex, int high) {
		E temp = list[pivotIndex];
		
		list[pivotIndex] = list[high];
		
		list[high] = temp;
	}

	/**
	 * Defines the behaviors of a PivotSelector
	 * 
	 * @author Dr. King
	 * @author Gabriel Perez-Botello
	 *
	 */
	private interface PivotSelector {
		/**
		 * Returns the index of the selected pivot element
		 * 
		 * @param low  - the lowest index to consider
		 * @param high - the highest index to consider
		 * @return the index of the selected pivot element
		 */
		int selectPivot(int low, int high);
	}

	/**
	 * FirstElementSelector chooses the first index of the array as the index of the
	 * pivot element that should be used when sorting
	 * 
	 * @author Dr. King
	 *
	 */
	public static class FirstElementSelector implements PivotSelector {
		/**
		 * Returns the lowest index for the pivot element to be used
		 * 
		 * @param low  the lowest index of the list
		 * @param high the highest index of the light
		 * @return int representing the index to use as the pivot element
		 */
		@Override
		public int selectPivot(int low, int high) {
			return low;
		}
	}

	/**
	 * LastElementSelector returns the highest (last) index to consider as the index
	 * of the pivot element that should be used when sorting.
	 * 
	 * @author Gabriel Perez-Botello
	 */
	public static class LastElementSelector implements PivotSelector {
		/**
		 * Returns the highest index for the pivot element to be used
		 * 
		 * @param low  the lowest index of the list
		 * @param high the highest index of the light
		 * @return int representing the index to use as the pivot element
		 */
		@Override
		public int selectPivot(int low, int high) {
			return high;
		}
	}

	/**
	 * MiddleElementSelector returns the middle index between low and high, to
	 * consider as the index of the pivot element that should be used when sorting.
	 * 
	 * @author Gabriel Perez-Botello
	 */
	public static class MiddleElementSelector implements PivotSelector {
		/**
		 * Returns the middle index for the pivot element to be used
		 * 
		 * @param low  the lowest index of the list
		 * @param high the highest index of the light
		 * @return int representing the index to use as the pivot element
		 */
		@Override
		public int selectPivot(int low, int high) {
			return (high + low) / 2;
		}
	}

	/**
	 * RandomElementSelector returns a random index between low and high (inclusive)
	 * to consider as the index of the pivot element that should be used when
	 * sorting.
	 * 
	 * @author Gabriel Perez-Botello
	 */
	public static class RandomElementSelector implements PivotSelector {
		/**
		 * Returns a random index for the pivot element to be used
		 * 
		 * @param low  the lowest index of the list
		 * @param high the highest index of the light
		 * @return int representing the index to use as the pivot element
		 */
		@Override
		public int selectPivot(int low, int high) {			
			Random rand = new Random();
			
			int randNum = -1;
			while (randNum < low) {
				randNum = rand.nextInt(high + 1);
			}
			
			return randNum;

		}
	}
}