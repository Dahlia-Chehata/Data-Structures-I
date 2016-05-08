package eg.edu.alexu.csd.datastructure.queue.cs31;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class QueueArraytest {

	QueueArraybased list2;

	// enqueue item at index > size
	@Test
	public void test1() {
		list2 = new QueueArraybased(3);
		list2.enqueue(5);
		list2.enqueue(3);
		list2.enqueue(5);

		try {
			list2.enqueue(8);

		} catch (Exception RuntimeException) {
		}

	}

	// enqueue ,dequeue
	@Test
	public void test2() {
		list2 = new QueueArraybased(3);
		list2.enqueue(5);
		list2.enqueue(3);
		list2.enqueue(5);
		list2.dequeue();
		list2.dequeue();
		list2.dequeue();

		try {
			list2.dequeue();

		} catch (Exception RuntimeException) {
		}

	}

	// test dequeue
	@Test
	public void test3() {
		list2 = new QueueArraybased(3);
		list2.enqueue(5);
		Assert.assertEquals(5, list2.dequeue());
	}

	@Test
	// dequeue from empty
	public void test4() {
		list2 = new QueueArraybased(3);
		try {
			list2.dequeue();

		} catch (Exception RuntimeException) {
		}
	}

	// test size1
	@Test
	public void test5() {
		list2 = new QueueArraybased(3);
		Assert.assertEquals(0, list2.size());
	}

	// test size2
	@Test
	public void test6() {
		list2 = new QueueArraybased(3);
		list2.enqueue(5);
		list2.enqueue(3);
		list2.enqueue(5);
		list2.dequeue();
		list2.dequeue();
		Assert.assertEquals(1, list2.size());
	}

	@Test
	public void test7() {
		list2 = new QueueArraybased(3);
		Assert.assertEquals(true, list2.isEmpty());
	}

	@Test
	public void test8() {
		list2 = new QueueArraybased(3);
		list2.enqueue(5);
		list2.enqueue(3);
		list2.enqueue(5);
		list2.dequeue();
		Assert.assertEquals(false, list2.isEmpty());
	}

	@Test
	public void test9() {
		list2 = new QueueArraybased(5);
		list2.enqueue(5);
		list2.enqueue(3);
		list2.enqueue(12);
		list2.enqueue(5);
		Assert.assertEquals(5, list2.dequeue());
		Assert.assertEquals(3, list2.dequeue());
		Assert.assertEquals(12, list2.dequeue());
		list2.enqueue(10);
		Assert.assertEquals(5, list2.dequeue());
		Assert.assertEquals(10, list2.dequeue());
		try {
			list2.enqueue(8);

		} catch (Exception RuntimeException) {
		}
		try {
			list2.dequeue();

		} catch (Exception RuntimeException) {
		}
	}
}
