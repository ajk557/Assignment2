/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: NotationTest_STUDENT
 */
/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEvaluatePostfixExpression() {
		assertEquals("2 3 4 * +", Notation.convertInfixToPostfix("2+3*4"));		
		assertEquals("2 3 * 4 +", Notation.convertInfixToPostfix("2*3+4"));
	}

	@Test
	void testConvertPostfixToInfix() {
		assertEquals("((2+3)*4)", Notation.convertPostfixToInfix("23+4*"));		
		assertEquals("(2+(3*4))", Notation.convertPostfixToInfix("234*+"));
	}

	@Test
	void testConvertInfixToPostfix() {
		assertEquals(14.0, Notation.evaluatePostfixExpression("234*+"));		
		assertEquals(20.0, Notation.evaluatePostfixExpression("23+4*"));
	}

}
