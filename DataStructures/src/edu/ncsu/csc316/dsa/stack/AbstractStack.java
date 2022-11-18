package edu.ncsu.csc316.dsa.stack;

/**
 * A skeletal implementation of the Stack abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the stack abstract data type.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the stack
 */
public abstract class AbstractStack<E> implements Stack<E> {
	/**
	 * Provides a standard implementation for the isEmpty() method for other classes
	 * that will implement this abstract class.
	 * 
	 * @return boolean determining if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}