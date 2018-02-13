import java.util.Set;
import java.util.HashSet;

/*
 * Implements the BasicMap interface using a sorted linked list.
 */
public class SLLMap<K extends Comparable <K>,V> implements BasicMap<K,V>{

	public Entry head;

	public SLLMap() { 
		head = null;
	} 
	
	// O(n)
	public int size(){
		int size = 0;
		if (!isEmpty()) {
			Entry current = head;
			while (current != null) {
				size++;
				current = current.next;
			}
		}
		return size;
	}
	
	// O(1)
	public boolean isEmpty() {
		return head == null;
	}
	
	// O(n)
	@SuppressWarnings("unchecked")
	public boolean containsKey(Object key) {
		if (isEmpty())
			return false;
		else {
			Entry current = head;
			while (current != null) {
				if (((Comparable<K>) key).compareTo(current.key) == 0)
					return true;
				else if (((Comparable<K>) key).compareTo(current.key) == -1)
					current = current.next;
				else { //if not 0 or -1, must be 1, which means it's gone past the expected spot
					return false;
				}
			}	
		}
		return false;
	}

	// O(n)
	public V put(K key, V value) {
		if (isEmpty()) {
			head.key = key;
			head.value = value;
			head.next = null;
			return null;
		}
		else {
			Entry current = head;
			while (current != null) {
				if (key.compareTo(current.key) == -1)
					current = current.next;
				else if (key.compareTo(current.key) == 0) {
					V returnValue = current.value;
					current.value = value;
					return returnValue;
				}
				else {
					if (current.next == null) {
						current.next = new Entry(key, value, null);
						return null;
					}
					else {
						Entry newEntry = new Entry(key, value, current.next);
						current.next = newEntry;
					}
				}
			}
			return null;
		}
	} 

	// O(n)
	@SuppressWarnings("unchecked")
	public V get(Object key) {
		if (isEmpty())
			return null;
		else {
			Entry current = head;
			while (current != null) {
				if (((Comparable<K>) key).compareTo(current.key) == -1)
					current = current.next;
				else if (((Comparable<K>) key).compareTo(current.key) == 0)
					return current.value;
				else
					return null;
			}
		}
		return null;
	} 

	// O(n)
	@SuppressWarnings("unchecked")
	public V remove(Object key) { 
		if (isEmpty())
			return null;
		else {
			Entry current = head;
			while (current != null) {
				if (((Comparable<K>) key).compareTo(current.key) == -1)
					current = current.next;
				else if (((Comparable<K>) key).compareTo(current.key) == 0) {
					V value = current.value;
					if (current.next == null)
						current = null;
					else
						current.next = current.next.next;
					return value;
				}
				else
					return null;
			}
		}
		return null;
	}

	// O(n)
	public Set<K> keySet(){
		Set<K> set = new HashSet<K>();
		if (!isEmpty()) {
			Entry current = head;
			while (current != null) {
				set.add(current.key);
			}
		}
		
		return set;
	}

	public class Entry{ 
		public K key;
		public V value;
		public Entry next;

		public Entry(K key, V value, Entry next) { 
			this.key = key;	
			this.value = value;
			this.next = next;
		}
	}
}