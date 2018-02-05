// Name: Brady Helkenn
// Andrewid: 915905476
// Section: CSC 220.03

import java.util.*;

public class TwoStackQueue<E> implements MyQueue<E> {

	private MyStack<E> out;
	private MyStack<E> in;

	public TwoStackQueue() {

	
	}

	/**
	 * Returns <tt>true</tt> if this queue no elements.
	 * @return <tt>true</tt> if this queue is empty, <tt>false</tt> otherwise.
	 */
	public boolean isEmpty() {
	    throw new UnsupportedOperationException("remove this line");
	}

	/**
	 * Adds the specified element to the end of the queue.
	 * @param The element to add on to the end of the queue.
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
	 * Returns a String representation of this queue. If the 
	 * queue will dequeue values  6 7 8  in that order, and
	 * the out stack contains one value, the string will have
	 * following format.   
	 * 
	 *     front [ 6 | 7 8 ] back
	 */
	public String toString() {
	    throw new UnsupportedOperationException("remove this line");
	}

}

