package edu.ncsu.csc316.dsa.queue;

/**
 * A skeletal implementation of the Queue abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the queue abstract data type.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the queue
 */
public abstract class AbstractQueue<E> implements Queue<E> {
	/**
	 * Provides standard implementation for other classes that extend this class for
	 * determining when the list is empty.
	 * 
	 * @return boolean determining if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}