// Name: Brady Helkenn
// Andrewid: 915905476
// Section: CSC 220.03

import java.util.*;

public class ArrayStack<E> implements MyStack<E> {

	private E[] dataArray;
	private int top;

	/**
	 * Creates an empty stack.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		top = -1;
		dataArray = (E[])new Object[100];
	}

	/**
	 * Determines if the stack is empty or not.
	 * @return true if the stack is empty or false otherwise
	 */
	public boolean isEmpty() {
	    if (top == -1)
	    	return true;
	    else
	    	return false;
	}

	/**
	 * Pushes the given element on this stack
	 * @param element The element of type E to push on the stack.
	 */
	public void push(E element) {
	    top++;
	    dataArray[top] = element;
	}
	
	/**
	 * Returns but does not remove the top element of the stack if the stack is not empty.
	 * @return The top element of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	public E peek() {
	    if (isEmpty())
	    	throw new NoSuchElementException("The stack is empty");
	    else
	    	return dataArray[top];
	}

	/**
	 * Returns and removes the top element of the stack if the stack is not empty.
	 * @return The top element of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	public E pop() {
		if (isEmpty())
			throw new NoSuchElementException("The stack is empty");
		else {
			top--;
			return dataArray[top + 1];
		}
	}
	
	/**
	 * Returns a String representation of the stack in the
	 * following format 
	 *     top [ 1 3 ] bottom
	 */	
	public String toString() {
	    String representation = "top [ ";
	    int count = top;
	    while (count >= 0) {
	    	representation += dataArray[count] + " ";
	    }
	    representation += "] bottom";
	    return representation;
	}
	
}
