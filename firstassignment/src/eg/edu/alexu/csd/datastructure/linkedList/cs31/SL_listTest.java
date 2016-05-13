package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class SL_listTest {
	ILinkedList SL = new Singly_linkedlists();
	ILinkedList D = new doubly_linkedlists();
 final int num7=7;
 final int num3=3;
 final int num10=10;
 final int num69=69;
 final int num96=96;
 final int num15=15;
 final int num555=555;
 final int num888=888;
 final int num5=5;
 final int num=-1;
 final int num4=4;
 final int num6=6;


	@Test
	public void test1() { // test get

		SL.add(0, num7);
		D.add(0, num7);
		Object result1 = SL.get(0);
		Object result2 = D.get(0);
		assertEquals(num7, result1);
		assertEquals(num7, result2);

	}

	@Test
	public void test2() { // add test index> size
		SL.add(0, num7);
		D.add(0, num7);

		try {
			SL.add(num3, num10);
			D.add(num3, num10);
			Assert.fail("index out of bounds");
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test3() { // remove from empty list
		try {
			SL.remove(2);
			D.remove(2);
			Assert.fail( "remove from empty list");
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test4() {
		SL.add(0, num7);
		SL.add(0, 1);
		SL.add(0, num69);
		SL.add(1, num96);
		SL.add(num15);
		SL.add(num5, num555);
		SL.add(num5, num888);
		SL.set(0, "m");
		Object result1 = SL.get(0);
		Object result2 = SL.get(num5);
		assertEquals("m", result1);
		assertEquals(num888, result2);

	}

	@Test
	public void test5() {
		D.add(0, num7);
		D.add(0, 1);
		D.add(0, num69);
		D.add(1, num96);
		D.add(num15);
		D.add(num5, num555);
		D.add(num5, num888);
		D.set(0, "m");
		Object result1 = D.get(0);
		Object result2 = D.get(num5);
		assertEquals("m", result1);
		assertEquals(num888, result2);

	}

	@Test() // test add(index-ve ,Object)
	public void test6() {
		
		try {
			SL.add(num, num5);
		    D.add(num, num5);
			Assert.fail( "add in -ve index");
		} catch (Exception RuntimeException) {
		}

	}

	@Test(expected = RuntimeException.class) // get -ve index
	public void test7() {
		SL.get(num);
		D.get(num);
	}

	@Test
	public void test8() { // test clear
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, num3);
		SL.clear();
		try {
			SL.get(0);
			Assert.fail();
		} catch (Exception RuntimeException) {

		}
	}

	@Test
	public void test9() { // test clear and get 
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, num3);
		D.clear();
		try {
			D.get(0);
			Assert.fail(" the list was cleared:cannot get from an empty list");
		} catch (Exception RuntimeException) {

		}
	}

	@Test(expected = RuntimeException.class) // sublist -ve index
	public void test10() {
		SL.sublist(num, num5);
		D.sublist(num, num5);
	}

	@Test
	public void test11() { // sublist>size index
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, num3);
		try {
			SL.sublist(2, num5);
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test12() { // sublist>size index
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, num3);
		try {
			D.sublist(2, num5);
			Assert.fail("index out of bounds");
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test13() { // test isEmpty()
		SL.add(0, num7);
		SL.add(1, 2);
		SL.add(2, num5);
		D.add(0, num7);
		D.add(1, 2);
		D.add(2, num5);

		boolean result = SL.isEmpty();
		Assert.assertEquals(false, result);

	}

	@Test // contains test on an empty list
	public void test14() {
		assertEquals(false, SL.contains(num5));
		assertEquals(false, D.contains(num5));
	}

	@Test(expected = RuntimeException.class) // remove -ve index
	public void test15() { // test remove
		SL.add(num15);
		SL.remove(num);
		D.add(num15);
		D.remove(num);

	}

	@Test
	public void test16() { // test isEmpty()

		boolean result = SL.isEmpty();
		Assert.assertEquals(true, result);

	}

	@Test // contains && remove test
	public void test17() {
		SL.add(0, num3);
		SL.add(1, 2);
		SL.add(2, num3);
		SL.add(0, num5);
		SL.remove(0);
		D.add(0, num3);
		D.add(1, 2);
		D.add(2, num3);
		D.add(0, num5);
		D.remove(0);
		assertEquals(false, SL.contains(num5));
		assertEquals(false, D.contains(num5));
	}

	@Test // contains test
	public void test18() {
		SL.add(0, num5);
		SL.add(1, 2);
		SL.add(2, 0);
		SL.add(0, num3);
		assertEquals(true, SL.contains(num3));
		D.add(0, num5);
		D.add(1, 2);
		D.add(2, 0);
		D.add(0, num3);
		assertEquals(true, D.contains(num3));
	}

	@Test
	public void test19() { // test sublist
		SL.add(0, num7);
		SL.add(1, 2);
		SL.add(2, num5);
		SL.add(num3);
		SL.add(num6);
		SL.add(num4);
		ILinkedList newlist = SL.sublist(1, num3);
		Object result = newlist.get(2);

		Assert.assertEquals(num3, result);

		D.add(0, num7);
		D.add(1, 2);
		D.add(2, num5);
		D.add(num3);
		D.add(num6);
		D.add(num4);
		ILinkedList newlist2 = D.sublist(1, num3);
		Object result2 = newlist2.get(2);

		Assert.assertEquals(num3, result2);
	}

	@Test
	public void test20() { // test size
		SL.add(0, num7);
		SL.add(1, 2);
		SL.add(2, num5);
		SL.add(num3);
		SL.add(num6);
		SL.add(num4);

		Assert.assertEquals(num6, SL.size());
		D.add(0, num7);
		D.add(1, 2);
		D.add(2, num5);
		D.add(num3);
		D.add(num6);
		D.add(num4);

		Assert.assertEquals(num6, D.size());
	}

	@Test
	public void test21() {
		Assert.assertEquals(0, SL.size());
		Assert.assertEquals(0, D.size());
	}

	@Test
	public void test22() { // test size
		SL.add(0, num7);
		SL.add(1, 2);
		SL.remove(0);
		Assert.assertEquals(1, SL.size());
		D.add(0, num7);
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
		SL.add(2, num3);
		try {
			SL.set(num4, num5);
			Assert.fail("index is out of bounds");
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, num3);
		try {
			D.set(num4, num5);
			Assert.fail("index is out of bounds");
		} catch (Exception RuntimeException) {
		}
	}

	@Test(expected = RuntimeException.class) // set empty list
	public void test25() {
		SL.set(1, num5);
		D.set(1, num5);

	}

	@Test
	public void test26() { // set list test //set -ve index
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, num3);
		try {
			SL.set(num, num5);
			Assert.fail("cannot set at a -ve index");
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, num3);
		try {
			D.set(num, num5);
			Assert.fail("cannot set at a -ve index");
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
		SL.add(1);
		SL.clear();
		try {
			SL.set(0, num10);
		} catch (Exception RuntimeException) {

		}
		D.add(1);
		D.clear();
		try {
			D.set(0, num10);
		} catch (Exception RuntimeException) {

		}

	}

	@Test
	public void test29() { // test get index> size
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, num3);
		try {
			SL.get(num5);
			Assert.fail("index out of bounds");
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, num3);
		try {
			D.get(num4);
			Assert.fail("index out of bounds");
		} catch (Exception RuntimeException) {
		}
	}

	@Test
	public void test30() { // test remove index> size
		SL.add(0, 1);
		SL.add(1, 2);
		SL.add(2, num3);
		try {
			SL.remove(num5);
			Assert.fail("index out of bounds");
		} catch (Exception RuntimeException) {
		}
		D.add(0, 1);
		D.add(1, 2);
		D.add(2, num3);
		try {
			D.remove(num4);
			Assert.fail("index out of bounds");
		} catch (Exception RuntimeException) {
		}
	}
}
