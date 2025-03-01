/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: MyStack
 */
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private int capacity;
	private T[] stack;
	private int top;
	
	/**
	 * Provide two constructors
	 * <p>1. takes in an int as the size of the stack
	 * <p>2. default constructor - uses default as the size of the stack
	 */
	public MyStack(int size) {
		this.capacity = size;
		top = 0	;
		stack = (T[]) new Object[capacity];
	}
	
	public MyStack() {
		this(10);
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if (top == capacity) {
			return true;
		}
		return false;
	}
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		
		T topReturn = stack[top-1];
		stack[top-1] = null;
		top--;
		return topReturn;
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		
		return stack[top-1];
	}

	/**
	 * Gets the number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return top;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		
        stack[top++] = e;
        return true;
	}
	
	
	/**
	 * Returns the elements of the Stack in a String from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return a String which represent the objects in the Stack from bottom to top
	 */
	public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) {
            sb.append(stack[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
	}
	
	/**
	 * Returns the String representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * <p>Place the delimiter between all elements of the Stack
	 * @return String representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) {
            sb.append(stack[i]);
            if (i < (top-1)) {
                sb.append(delimiter);
            }
        }
		return sb.toString();
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException {
	    if (list.size() > (capacity - top)) {
	        throw new StackOverflowException();
	    }
	    
	    for (int i = 0; i < list.size(); i++) {
	        if (isFull()) {
	            throw new StackOverflowException();
	        }
	        push(list.get(i));
	    }
	}
}
