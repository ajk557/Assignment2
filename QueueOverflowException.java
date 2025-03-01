/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: QueueOverflowException
 */
public class QueueOverflowException extends RuntimeException{
	public QueueOverflowException() {
		super("Queue is full");
	}
	
	public QueueOverflowException(String message) {
		super(message);
	}
}