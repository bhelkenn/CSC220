/** Interface to specify operations for a simple unbounded 
 * last-in-last-out (LIFO) stack.
 */

public interface MyStack<E> {

	/**
	 * Returns true if this stack has no elements
	 * @return <tt>true</tt> if this stack is empty, <tt>false</tt> otherwise
	 */
	public boolean isEmpty();

	/**
	 * Returns, but does not remove, the top element of this stack.
	 * @return The top element of the stack
	 * @throws <tt>NoSuchElementException</tt> if this stack is empty
	 */
	public E peek();

	/**
	 * Returns and removes the top element from this stack.
	 * @return The top element of this stack
	 * @throws <tt>NoSuchElementException</tt> if this stack is empty
	 */
	public E pop();

	/**
	 * Pushes the specified element on this stack
	 * @param <tt>element</tt> The element of type E to push on the stack.
	 */	
	public void push(E element);



}
