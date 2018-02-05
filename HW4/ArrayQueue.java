// Name: Brady Helkenn
// Andrewid: 915905476
// Section: CSC 220.03

import java.util.*;

public class ArrayQueue<E> implements MyQueue<E> {

	private E[] dataArray;
	private int front;  // index of first item to remove
	private int back;   // index of last item to remove
	private int numElements; // for convenience

	public ArrayQueue() {

	
	}
	
	/**
	 * Returns <tt>true</tt> if this queue no elements.
	 * @return <tt>true</tt> if this queue is empty, <tt>false</tt> otherwise.
	 */
	public boolean isEmpty() {
	    throw new UnsupportedOperationException("remove this line");
	}

	/**
	 * Adds the specified element to the back of this queue.
	 * @param element to add on to the back of this queue.
	 */	
	public void enqueue(E element) {
	    throw new UnsupportedOperationException("remove this line");
	}

	/**
	 * Removes and returns the element at the front of this queue.
	 * @return The element removed from the front of this queue.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	public E dequeue() {
	    throw new UnsupportedOperationException("remove this line");
	}

	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * @return The element at the front of this queue.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	public E peek() {
	    throw new UnsupportedOperationException("remove this line");
	}
	
	/**
	 * Returns a String representation of this queue in the
	 * following format:
	 * 
	 *     front: 3 back: 1
	 *     front [ 6 7 8 ] back
	 */
	public String toString() {
	    throw new UnsupportedOperationException("remove this line");
	}

}
