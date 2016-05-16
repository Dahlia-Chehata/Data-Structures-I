package eg.edu.alexu.csd.datastructure.queue.cs31;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class QueueTesting {
/**
 * .
 */
	Queue list1 = new Queue();
	private final int num5=5;
	private final int num3=3;
	private final int num8=8;
	private final int num12=12;
	private final int num10=10;
	
	@Test
	/**
	 * test enqueue
	 */
	public void test1() {
		
		list1.enqueue(num12);
		assertEquals(num12, list1.dequeue());
		
	}
	@Test
	public void test2() {

	list1.enqueue(num5);
	list1.enqueue(num3);
	list1.enqueue(num5);
	list1.dequeue();
	list1.dequeue();
	list1.dequeue();

	try {
		list1.dequeue();

	} catch (Exception RuntimeException) {
	}
}
	//test dequeue
	@Test
	public void test3() {
		
		list1.enqueue(num5);
		Assert.assertEquals(num5, list1.dequeue());
	}
	@Test
	// dequeue from empty
	public void test4() {
		try {
			list1.dequeue();

		} catch (Exception RuntimeException) {
		}
	}
	// test size1
		@Test
		public void test6() {
			Assert.assertEquals(0, list1.size());
		}
		// test size2
		@Test
		public void test7() {
			list1.enqueue(num5);
			list1.enqueue(num3);
			list1.enqueue(num5);
			list1.dequeue();
			list1.dequeue();
			Assert.assertEquals(1, list1.size());
		}
		@Test
		public void test8() {
			Assert.assertEquals(true, list1.isEmpty());
		}

		@Test
		public void test9() {
			list1.enqueue(num5);
			list1.enqueue(num3);
			list1.enqueue(num5);
			list1.dequeue();
			Assert.assertEquals(false, list1.isEmpty());
		}

		@Test
		public void test10() {
			list1.enqueue(num5);
			list1.enqueue(num3);
			list1.enqueue(num12);
			list1.enqueue(num5);
			Assert.assertEquals(num5, list1.dequeue());
			Assert.assertEquals(num3, list1.dequeue());
			Assert.assertEquals(num12, list1.dequeue());
			list1.enqueue(num10);
			Assert.assertEquals(num5, list1.dequeue());
			Assert.assertEquals(num10, list1.dequeue());
			try {
				list1.dequeue();

			} catch (Exception RuntimeException) {
			}
}
}
