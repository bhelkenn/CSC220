
/** Interface to specify operations for a simple unbounded 
 * first-in-first-out (FIFO) queue.
 */

public interface MyQueue<E> {
	
	/**
	 * Removes and returns the element at the front of this queue.
	 * @return The element removed from the front of this queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	public E dequeue();
	
	/**
	 * Adds the specified element to the back of this queue.
	 * @param element to add on to the back of this queue.
	 */	
	public void enqueue(E element);
	
	/**
	 * Returns <tt>true</tt> if this queue no elements.
	 * @return <tt>true</tt> if this queue is empty, <tt>false</tt> otherwise.
	 */
	public boolean isEmpty();
		
	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * @return The element at the front of this queue.
	 * @throws <tt>NoSuchElementException</tt> if the queue is empty.
	 */
	public E peek();
	    

}
