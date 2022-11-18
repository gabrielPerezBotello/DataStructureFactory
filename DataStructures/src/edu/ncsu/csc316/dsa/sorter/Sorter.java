package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 * @param <E> generic object type to allow methods use with generic objects.
 */
public interface Sorter<E> {

	/**
	 * Sorts a given array of integers.
	 * 
	 * @param data the data set to be sorted
	 */
	void sort(E[] data);
}
