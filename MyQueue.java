/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: MyQueue
 */
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int capacity;
	private int current;
	
	/** provide two constructors 
	 * <p>1. takes an int as the size of the queue
	 * <p>2. default constructor - uses a default as the size of the queue
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(int size) {
        this.queue = (T[]) new Object[size]; 
        this.capacity = size;
        this.current = 0;
	}
	
	public MyQueue() {
		this(10);
	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (current == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (current == capacity) {
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T remove = queue[0];

		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		for (int i = 1; i < current; i++) {
			queue[i-1] = queue[i];
		}
		queue[current-1] = null;
		
		current--;
		return remove;
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return current;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		
		queue[current] = e;
		current++;
		return true;
	}
	
	
	/**
	 * Returns the String representation of the elements in the Queue, 
	 * the beginning of the String is the front of the queue
	 * @return String representation of the Queue with elements
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < current; i++) {
			sb.append(queue[i]);
			sb.append(" ");
		}
		return sb.toString().trim();
	}
	
	/**
	 * Returns the String representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * <p>Place the delimiter between all elements of the Queue
	 * @return String representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < current; i++) {
            sb.append(queue[i]);
            if (i < (current - 1)) {
                sb.append(delimiter);
            }
        }
		return sb.toString();
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException {
	    if (list.size() > (capacity - current)) {
	        throw new QueueOverflowException();
	    }
	    
	    for (int i = 0; i <list.size(); i++) {
	    	if (isFull()) {
	    		throw new QueueOverflowException();
	    	}
	    	enqueue(list.get(i));
	    }
	}

}
