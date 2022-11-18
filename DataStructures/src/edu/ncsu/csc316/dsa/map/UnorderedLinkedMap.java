package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;
import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * An unordered link-based map is an unordered (meaning keys are not used to
 * order entries) linked-memory representation of the Map abstract data type.
 * This link-based map delegates to an existing doubly-linked positional list.
 * To help self-organizing entries to improve efficiency of lookUps, the
 * unordered link-based map implements the move-to-front heuristic: each time an
 * entry is accessed, it is shifted to the front of the internal list.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello
 * @author Andrew Roe
 *
 * @param <K> the type of keys stored in the map
 * @param <V> the type of values that are associated with keys in the map
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {
	/** PositionalList of Entry objects. */
	private PositionalList<Entry<K, V>> list;

	/**
	 * Constructor of an UnorderedLinkedMap object, creates it using
	 * PositionalLinkedList.
	 */
	public UnorderedLinkedMap() {
		this.list = new PositionalLinkedList<Entry<K, V>>();
	}

	/**
	 * Looks up if an entry with the matching key exists in UnorderedLinkedMap and
	 * returns its position.
	 * 
	 * @param key the key being looked for in the map
	 * @return the position of the entry within the list
	 */
	private Position<Entry<K, V>> lookUp(K key) {
		Position<Entry<K, V>> p = list.first();
		
		while (p != null && !p.getElement().getKey().equals(key)) {
			p = list.after(p);
		}

		return p;
	}

	/**
	 * Use the move-to-front heuristic: Returns the value V associated with the key
	 * K. If the key does not exist, returns null
	 * 
	 * @param key the key for the entry being looked into
	 * @return V value that is at the entry with given key
	 */
	@Override
	public V get(K key) {
		Position<Entry<K, V>> p = lookUp(key);

		if (p == null) {
			return null;
		}

		V val = null;

		if (p != null) {
			val = p.getElement().getValue();
			
			moveToFront(p);
		}

		return val;
	}

	/**
	 * Implements the Move-to-Front heuristic for our map to improve average run
	 * time for searching.
	 * 
	 * @param position the position of the entry being moved
	 */
	private void moveToFront(Position<Entry<K, V>> position) {
		list.addFirst(list.remove(position));
	}

	/**
	 * If the key already exists in the map, update the entry with the given key to
	 * have the new value. To facilitate efficient lookUps, apply the move-to-front
	 * heuristic on the updated entry, then return the original value that was
	 * replaced. Otherwise, if the key does not already exist, insert the new
	 * key-value pair at the front of the list (to help facilitate efficient
	 * lookUps).
	 * 
	 * @param key   the key for the entry
	 * @param value the value for the entry
	 * @return V value that was originally at that key position
	 */
	@Override
	public V put(K key, V value) {
		Position<Entry<K, V>> p = lookUp(key);

		if (p != null) {
			V oldVal = p.getElement().getValue();

			moveToFront(p);

			return oldVal;
		} else {
			Entry<K, V> entry = new MapEntry<K, V>(key, value);

			list.addFirst(entry);

			return null;
		}
	}

	/**
	 * Firsts looks up to find the entry with the given key. If the key does not
	 * exist, returns null
	 * 
	 * @param key the key for the entry being looked up
	 * @return value associated with entry that has key
	 */
	@Override
	public V remove(K key) {
		Position<Entry<K, V>> p = lookUp(key);

		return p == null ? null : list.remove(p).getValue();
	}

	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Iterable object that uses for each loop to add entry objects to collection
	 * 
	 * @return Iterable object filled with entry objects
	 */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		EntryCollection collection = new EntryCollection();
		for (Entry<K, V> entry : list) {
			collection.add(entry);
		}
		return collection;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("UnorderedLinkedMap[");
		Iterator<Entry<K, V>> it = list.iterator();
		while (it.hasNext()) {
			sb.append(it.next().getKey());
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}