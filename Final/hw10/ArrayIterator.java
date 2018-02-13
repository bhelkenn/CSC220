import java.util.*;
public class ArrayIterator<E> implements java.util.Iterator<E> {
	
	E[] array;
	int next;

	
	/** 
	 * Constructs an iterator for the specified array.
	 * 
	 * @param array The array over which to iterate.
	 */
	public ArrayIterator(E[] array) {
        this.array = array;
		next = 0;
	}
	
	/**
	 * Return <tt>true</tt> is the iteration has more elements.
	 * (In other words, returns <tt>true</tt> if <tt>next</tt> would
	 * return an element rather than throwing an exception.)
	 * 
	 * @return <tt>true</tt> if there is another element.
	 */
	public boolean hasNext() {
		if (next < array.length)
            return true;
        else
            return false;
	}
	
	/**
	 * Returns the next element in the iteration.
	 * @return the next element in the iteration.
	 * @throws <tt>NoSuchElementException</tt> if iteration has no more elements.
	 * 
	 */
	public E next() {
        if (hasNext()) {
            next++;
            return array[next - 1];
        }
        else
            throw new NoSuchElementException("There is no next element");
	}
	
	/** 
	 * The remove operation is not supported by this implementation 
	 * of <tt>Iterator</tt>.
	 * @throws <tt>UnsupportedOperationException</tt> if this method is invoked.
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
