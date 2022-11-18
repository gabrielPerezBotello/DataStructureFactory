package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * A skeletal implementation of the Binary Tree abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the binary tree abstract data type.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 *
 * @param <E> the type of elements stored in the binary tree
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

	@Override
	public Iterable<Position<E>> inOrder() {
		PositionCollection traversal = new PositionCollection();
		if (!isEmpty()) {
			inOrderHelper(root(), traversal);
		}
		return traversal;
	}

	private void inOrderHelper(Position<E> p, PositionCollection traversal) {
		if (p != null) {
			inOrderHelper(left(p), traversal);

			if (p != null) {
				traversal.add(p);
			}

			inOrderHelper(right(p), traversal);
		}
	}

	@Override
	public int numChildren(Position<E> p) {
		int numChild = 0;
		
		if (p == null || p.getElement() == null) {
			return numChild;
		}
		
		AbstractTreeNode<E> node = validate(p);

		if (left(node) != null) {
			numChild++;
		}
		if (right(node) != null) {
			numChild++;
		}

		return numChild;
	}

	@Override
	public Position<E> sibling(Position<E> p) {
		if (p == null) {
			return null;
		}
		
		AbstractTreeNode<E> node = validate(p);

		if (parent(node) != null && numChildren(parent(node)) == 2) {
			AbstractTreeNode<E> parent = validate(parent(node));

			if (left(parent).equals(node)) {
				return right(parent);
			} else {
				return left(parent);
			}
		} else {
			return null;
		}
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) {
		AbstractTreeNode<E> node = validate(p);
		PositionCollection childrenCollection = new PositionCollection();
		if (left(node) != null) {
			childrenCollection.add(left(node));
		}
		if (right(node) != null) {
			childrenCollection.add(right(node));
		}
		return childrenCollection;
	}
}