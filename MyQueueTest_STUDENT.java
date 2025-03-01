/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 2/28/25
 * Class: MyQueueTest_STUDENT
 */

/**
* This class contains the test case methods that students must implement
*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {
	private MyQueue<Integer> queue;
	private ArrayList<Integer> myList = new ArrayList<Integer>();

	@BeforeEach
	void setUp() throws Exception {
		queue = new MyQueue<>(10);
	}

	@AfterEach
	void tearDown() throws Exception {
		queue = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
	}

	@Test
	void testDequeue() {
		queue.enqueue(1);
		assertEquals(1, queue.dequeue());
	}

	@Test
	void testSize() {
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(2, queue.size());
		queue.enqueue(5);
		assertEquals(3, queue.size());
	}

	@Test
	void testEnqueue() {
		queue.enqueue(4);
		queue.enqueue(3);
		assertEquals(2, queue.size());
	}

	@Test
	void testIsFull() {
		assertFalse(queue.isFull());
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		assertTrue(queue.isFull());
	}

	@Test
	void testToString() {
		queue.enqueue(2);
		queue.enqueue(4);
		assertEquals("2 4", queue.toString());
	}

	@Test
	void testToStringString() {
		queue.enqueue(2);
		queue.enqueue(4);
		assertEquals("2,4", queue.toString(","));
	}

	@Test
	void testFill() {
		myList.add(1);
		myList.add(2);
		myList.add(3);
		queue.fill(myList);
		assertEquals("1,2,3", queue.toString(","));
	}
}