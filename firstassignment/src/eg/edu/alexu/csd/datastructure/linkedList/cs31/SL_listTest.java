package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class SL_listTest {
	ILinkedList SL = new Singly_linkedlists();
	ILinkedList D = new doubly_linkedlists();

	@Test
	public void test1() { // test get

		SL.add(0, 7);
		D.add(0, 7);
		Object result1 = SL.get(0);
		Object result2 = D.get(0);
		assertEquals(7, result1);
		assertEquals(7, result2);

	}

	@Test
	public void test2() { // add test index> size
		SL.add(0, 7);
		D.add(0, 7);

		try {
			SL.add(3, 10);
			D.add(3, 10);
			Assert.fail();
		} catch (Exception RuntimeException) {

		}
	}

	@Test
	public void test3() { // remove from empty list
		try {
			SL.remove(2);
			D.remove(2);
			Assert.fail();
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test4() {
		SL.add(0, 7);
		SL.add(0, 1);
		SL.add(0, 69);
		SL.add(1, 96);
		SL.add(15);
		SL.add(5, 555);
		SL.add(5, 888);
		SL.set(0, "m");
		Object result1 = SL.get(0);
		Object result2 = SL.get(5);
		assertEquals("m", result1);
		assertEquals(888, result2);

	}

	@Test
	public void test5() {
		D.add(0, 7);
		D.add(0, 1);
		D.add(0, 69);
		D.add(1, 96);
		D.add(15);
		D.add(5, 555);
		D.add(5, 888);
		D.set(0, "m");
		Object result1 = D.get(0);
		Object result2 = D.get(5);
		assertEquals("m", result1);
		assertEquals(888, result2);

	}

	@Test(expected = RuntimeException.class) // test add(index-ve ,Object)
	public void test6() {
		SL.add(-3, 5);
		D.add(-3, 5);

	}

	@Test(expected = RuntimeException.class) // get -ve index
	public void test7() {
		SL.get(-1);
		D.get(-1);
	}

	@Test
	public void test8() { // test clear
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, 3);
		SL.clear();
		try {
			SL.get(0);
			Assert.fail();
		} catch (Exception RuntimeException) {

		}
	}

	@Test
	public void test9() { // test clear
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, 3);
		D.clear();
		try {
			D.get(0);
			Assert.fail();
		} catch (Exception RuntimeException) {

		}
	}

	@Test(expected = RuntimeException.class) // sublist -ve index
	public void test10() {
		SL.sublist(-3, 5);
		D.sublist(-3, 5);
	}

	@Test
	public void test11() { // sublist>size index
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, 3);
		try {
			SL.sublist(2, 5);
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test12() { // sublist>size index
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, 3);
		try {
			D.sublist(2, 5);
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test13() { // test isEmpty()
		SL.add(0, 7);
		SL.add(1, 2);
		SL.add(2, 5);
		D.add(0, 7);
		D.add(1, 2);
		D.add(2, 5);

		boolean result = SL.isEmpty();
		Assert.assertEquals(false, result);

	}

	@Test // contains test on an empty list
	public void test14() {
		assertEquals(false, SL.contains(5));
		assertEquals(false, D.contains(5));
	}

	@Test(expected = RuntimeException.class) // remove -ve index
	public void test15() { // test remove
		SL.add(15);
		SL.remove(-1);
		D.add(15);
		D.remove(-1);

	}

	@Test
	public void test() { // test isEmpty()

		boolean result = SL.isEmpty();
		Assert.assertEquals(true, result);

	}

	@Test // contains && remove test
	public void test16() {
		SL.add(0, 3);
		SL.add(1, 2);
		SL.add(2, 3);
		SL.add(0, 5);
		SL.remove(0);
		assertEquals(false, SL.contains(5));
	}

	@Test // contains && remove test
	public void test17() {
		D.add(0, 3);
		D.add(1, 2);
		D.add(2, 3);
		D.add(0, 5);
		D.remove(0);
		assertEquals(false, D.contains(5));
	}

	@Test // contains test
	public void test18() {
		SL.add(0, 5);
		SL.add(1, 2);
		SL.add(2, 0);
		SL.add(0, 3);
		assertEquals(true, SL.contains(3));
		D.add(0, 5);
		D.add(1, 2);
		D.add(2, 0);
		D.add(0, 3);
		assertEquals(true, D.contains(3));
	}

	@Test
	public void test19() { // test sublist
		SL.add(0, 7);
		SL.add(1, 2);
		SL.add(2, 5);
		SL.add(3);
		SL.add(6);
		SL.add(4);
		ILinkedList newlist = SL.sublist(1, 3);
		Object result = newlist.get(2);

		Assert.assertEquals(3, result);

		D.add(0, 7);
		D.add(1, 2);
		D.add(2, 5);
		D.add(3);
		D.add(6);
		D.add(4);
		ILinkedList newlist2 = D.sublist(1, 3);
		Object result2 = newlist2.get(2);

		Assert.assertEquals(3, result2);
	}

	@Test
	public void test20() { // test size
		SL.add(0, 7);
		SL.add(1, 2);
		SL.add(2, 5);
		SL.add(3);
		SL.add(6);
		SL.add(4);

		Assert.assertEquals(6, SL.size());
		D.add(0, 7);
		D.add(1, 2);
		D.add(2, 5);
		D.add(3);
		D.add(6);
		D.add(4);

		Assert.assertEquals(6, D.size());
	}

	@Test
	public void test21() {
		Assert.assertEquals(0, SL.size());
		Assert.assertEquals(0, D.size());
	}

	@Test
	public void test22() { // test size
		SL.add(0, 7);
		SL.add(1, 2);
		SL.remove(0);
		Assert.assertEquals(1, SL.size());
		D.add(0, 7);
		D.add(1, 2);
		D.remove(0);
		Assert.assertEquals(1, D.size());

	}

	@Test
	public void test23() {
		SL.add(0, "p");
		SL.add(1, "m");
		SL.add(1, "n");
		SL.add(1, "l");
		Assert.assertEquals("l", SL.get(1));
		D.add(0, "p");
		D.add(1, "m");
		D.add(1, "n");
		D.add(1, "l");
		Assert.assertEquals("l", D.get(1));
	}

	@Test
	public void test24() { // set test index>size
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, 3);
		try {
			SL.set(4, 5);
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, 3);
		try {
			D.set(4, 5);
		} catch (Exception RuntimeException) {
		}
	}

	@Test(expected = RuntimeException.class) // set empty list
	public void test25() {
		SL.set(1, 9);
		D.set(1, 9);

	}

	@Test
	public void test26() { // set list test //set -ve index
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, 3);
		try {
			SL.set(-4, 5);
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, 3);
		try {
			D.set(-4, 5);
		} catch (Exception RuntimeException) {
		}
	}

	@Test(expected = RuntimeException.class) // get empty list
	public void test27() {
		SL.get(1);
		D.get(1);

	}

	@Test
	public void test28() {
		SL.add(12);
		SL.clear();
		try {
			SL.set(0, 15);
		} catch (Exception RuntimeException) {

		}
		D.add(12);
		D.clear();
		try {
			D.set(0, 15);
		} catch (Exception RuntimeException) {

		}

	}

	@Test
	public void test29() { // test get index> size
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, 3);
		try {
			SL.get(5);
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, 3);
		try {
			D.get(4);
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test30() { // test remove index> size
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, 3);
		try {
			SL.remove(5);
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, 3);
		try {
			D.remove(4);
		} catch (Exception RuntimeException) {
		}
	}
}
