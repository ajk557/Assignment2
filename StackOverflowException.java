/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: StackOverflowException
 */
public class StackOverflowException extends RuntimeException{
	public StackOverflowException() {
		super("Stack is full");
	}
	
	public StackOverflowException(String message) {
		super(message);
	}
}
