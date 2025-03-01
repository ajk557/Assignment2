/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: InvalidNotationFormatException
 */

public class InvalidNotationFormatException extends RuntimeException{
	public InvalidNotationFormatException() {
		super("Notation format is incorrect");
	}
	
	public InvalidNotationFormatException(String message) {
		super(message);
	}
}
