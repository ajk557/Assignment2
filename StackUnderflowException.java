/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: StackUnderflowException
 */
public class StackUnderflowException extends RuntimeException{
	public StackUnderflowException() {
		super("Stack is empty");
	}
	
	public StackUnderflowException(String message) {
		super(message);
	}
}
