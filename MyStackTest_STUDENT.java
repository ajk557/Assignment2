/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: MyStackTest_STUDENT
 */
/**
* This class contains the test case methods that students must implement
*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {
	private MyStack<Integer> stack;
	private ArrayList<Integer> myList = new ArrayList<Integer>();
	
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>(10);
	}

	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push(3);
		assertFalse(stack.isEmpty());
	}

	@Test
	void testIsFull() {
		stack.push(1);
		stack.push(2);
		assertFalse(stack.isFull());
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		assertTrue(stack.isFull());
	}

	@Test
	void testPop() {
		stack.push(3);
		stack.push(2);
		assertEquals(2, stack.pop());
		assertEquals(3, stack.pop());
	}

	@Test
	void testTop() {
		stack.push(3);
		stack.push(2);
		assertEquals(2, stack.pop());
		assertEquals(3, stack.pop());
	}

	@Test
	void testSize() {
		stack.push(1);
		assertEquals(1, stack.size());
	}

	@Test
	void testPush() {
		stack.push(3);
		assertEquals(1, stack.size());
		stack.push(3);
		stack.push(4);
		assertEquals(3, stack.size());
	}

	@Test
	void testToString() {
		stack.push(1);
		stack.push(3);
		assertEquals("1 3", stack.toString());
	}

	@Test
	void testToStringString() {
		stack.push(1);
		stack.push(3);
		assertEquals("1,3", stack.toString(","));
	}

	@Test
	void testFill() {
		myList.add(1);
		myList.add(2);
		myList.add(3);
		stack.fill(myList);
		assertEquals("1,2,3", stack.toString(","));
	}
}