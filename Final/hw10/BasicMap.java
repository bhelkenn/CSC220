import java.util.Set;
public interface BasicMap<K,V> {
	
	/**
	 * Returns the number of key-value mappings in this map
	 * @return the number of key-value mappings in this map
	 */
	int size();
	
	/**
	 * Returns <tt>true</tt> if this map contains no key-value mappings.
	 * @return <tt>true</tt> if this map contains no key-value mappings.
	 */
	boolean isEmpty();
	
	/**
	 * Returns <tt>true</tt> if this map contains a 
	 * mapping for the specified key.
	 * 
	 * @param key key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping 
	 * for the specified key
	 * @throws <tt>NullPointerException</tt> if the specified key 
	 * is <tt>null</tt>
	 */
	boolean containsKey(Object key);
	
	/**
	 * Returns the value associated with specified key, 
	 * or <tt> null if this map contains no mapping for the key..
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return the value associated with specified key, 
	 * or <tt> null if this map contains no mapping for the key.
	 * @throws <tt>NullPointerException</tt> if the specified key 
	 * is <tt>null</tt>
	 */
	V get(Object key);
	
	/**
	 * Associates the specified value with the specified key in this map.
	 * If the map previously contained a mapping for the key, the old value 
	 * is replaced by the specified value.
	 * @param key key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with key, or <tt>null</tt> 
	 * if there was no mapping for key. 
	 * @throws <tt>NullPointerException</tt> if the specified key 
	 * is <tt>null</tt>
	 */
	V put(K key, V value);
	
	/**
	 * Removes the mapping for the specified key from this map if it is present.
	 * Returns the value previously associated the key, 
	 * or <tt>null</tt> if the map contained no mapping for the key.
	 * @param key key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or <tt>null</tt> if 
	 * there was no mapping for key.
	 * @throws <tt>NullPointerException</tt> if the specified key 
	 * is <tt>null</tt>
	 */
	V remove(Object key);
	
	/**
	 * Returns a Set of the keys contained in this map.
	 * @return a set of the keys contained in this map.
	 */
	Set<K> keySet();
	

}
