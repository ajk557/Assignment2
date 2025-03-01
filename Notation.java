/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: Notation
 */
public class Notation {
	public Notation() {
		
	}
	
	/*
	Convert an infix expression into a postfix expression
	Parameters:
	infix - the infix expression in string format
	Returns:
	the postfix expression in string format
	Throws:
	InvalidNotationFormatException - if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyQueue<String> postfix = new MyQueue<>();
		MyStack<String> stack = new MyStack<>();
		char ch;
		boolean twoOps = false;
		int currentPriority,
		    stackPriority;
		
		for (int i = 0; i < infix.length(); i++) {
			ch = infix.charAt(i);
			
			if (Character.isWhitespace(ch)) {
				continue;
			}
			
			if (Character.isDigit(ch)) {
				postfix.enqueue(Character.toString(ch));
				twoOps = false;
			}
			else if (ch == '(') {
				stack.push(Character.toString(ch));
				twoOps = false;
			}
			else if (ch == ')') {	
				while (!stack.isEmpty() && !stack.top().equals("(")) {
					postfix.enqueue(stack.pop());
                }
				
				if (stack.isEmpty()) {
					throw new InvalidNotationFormatException("here");
				}
						
				stack.pop();
				twoOps = false;
			}
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				if (twoOps) {
					throw new InvalidNotationFormatException();
				}
				
				if (ch == '+' || ch == '-') {
					currentPriority = 1; // low priority
				}
				else { 
					currentPriority = 2; // high priority
				}
			
				if (!stack.isEmpty() && (stack.top().equals("+") || stack.top().equals("-"))) {
					stackPriority = 1; // low priority
				}
				else { 
					stackPriority = 2; // high priority
				}
		
				while (!stack.isEmpty() && !stack.top().equals("(") && !stack.top().equals("(") && stackPriority >= currentPriority) {
					postfix.enqueue(stack.pop());
					if (!stack.isEmpty() && (stack.top().equals("+") || stack.top().equals("-"))) {
						stackPriority = 1; // low priority
					}
					else { 
						stackPriority = 2; // high priority
					}
		        }
				
				stack.push(Character.toString(ch));
		        twoOps = true;
			}				
			else {
				throw new InvalidNotationFormatException();
			}

		}
		
		while (!stack.isEmpty()) {
			if (stack.top().equals("(")) {
				throw new InvalidNotationFormatException();
			}
	        postfix.enqueue(stack.pop());
	    }
		
	    return postfix.toString().trim();
	}

	/*
	Convert the Postfix expression to the Infix expression
	Parameters:
	postfix - the postfix expression in string format
	Returns:
	the infix expression in string format
	Throws:
	InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
	    MyStack<String> stack = new MyStack<>();
	    char ch;
	    String num1,
	    	   num2;
	    StringBuilder equation = new StringBuilder();
	    
	    for (int i = 0; i < postfix.length(); i++) {
	    	ch = postfix.charAt(i);
			
			if (Character.isWhitespace(ch)) {
				continue;
			}
			else if (Character.isDigit(ch)) {
	    		stack.push(String.valueOf(ch));
	    	}
	    	else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
	    		if (stack.size() <2) {
	    			throw new InvalidNotationFormatException();
	    		}
	    		
	    		num2 = stack.pop();
	            num1 = stack.pop();
	            
	            equation.setLength(0);
	            
	            equation.append("(");
	            equation.append(num1);
	            equation.append(ch);
	            equation.append(num2);
	            equation.append(")");
	            
	            stack.push(equation.toString());
	    	}
	        else {
	            throw new InvalidNotationFormatException();
	        }
	    }
	    
	    if (stack.size() > 1) {
	        throw new InvalidNotationFormatException();
	    }
	    
	    return stack.pop();
	}
	
	/*
	Evaluates a postfix expression from a string to a double
	Parameters:
	postfixExpr - the postfix expression in String format
	Returns:
	the evaluation of the postfix expression as a double
	Throws:
	InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
	    MyStack<Double> stack = new MyStack<>();
	    char ch;
	    double num1,
	    	   num2,
	    	   result = 0.0;
	    //StringBuilder equation = new StringBuilder();
	    
	    for (int i = 0; i < postfixExpr.length(); i++) {
	    	ch = postfixExpr.charAt(i);
			
			if (Character.isWhitespace(ch)) {
				continue;
			}
			else if (Character.isDigit(ch)) {
	    		stack.push(Double.parseDouble(String.valueOf(ch)));
	    	}
	    	else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
	    		if (stack.size() <2) {
	    			throw new InvalidNotationFormatException();
	    		}
	    		
	    		num2 = stack.pop();
	            num1 = stack.pop();

	            switch (ch) {
	            case '+':
	                result = num1 + num2;
	                break;
	            case '-':
	            	result = num1 - num2;
	            	break;
	            case '*':
	            	result = num1 * num2;
	            	break;
	            case '/':
	                if (num2 == 0.0) {
	                    throw new ArithmeticException("ERROR: Can't divide by zero.");
	                }
	                result = num1 / num2;
	            }

	            stack.push(result);
	    	}
	        else {
	            throw new InvalidNotationFormatException();
	        }
	    }
	    
	    if (stack.size() > 1) {
	        throw new InvalidNotationFormatException();
	    }
	    
	    return stack.pop();
	}
}
