/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: QueueUnderflowException
 */
public class QueueUnderflowException extends RuntimeException{
	public QueueUnderflowException() {
		super("Queue is empty");
	}
	
	public QueueUnderflowException(String message) {
		super(message);
	}
}
