package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
/**.
 * @author Dell
 */
public class SLlistTest {
	/**..
	 * 
	 */
	ILinkedList list = new Singlylinkedlists();
	/**.
	 * .
	 */
	ILinkedList liste = new Doublylinkedlists();
	/**.
	 * .
	 */
 final int num7 = 7;
 /**.
  * .
  */
 final int num3 = 3;
 /**.
  * .
  */
 final int num10 = 10;
 /**.
  * .
  */
 final int num69 = 69;
 /**.
  * .
  */
 final int num96 = 96;
 /**.
  * .
  */
 final int num15 = 15;
 /**.
  * .
  */
 final int num555 = 555;
 /**.
  * .
  */
 final int num888 = 888;
 /**.
  * .
  */
 final int num5 = 5;
 /**.
  * .
  */
 final int num = -1;
 /**.
  * .
  */
 final int num4 = 4;
 /**.
  * .
  */
 final int num6 = 6;

/**.
 * ;
 */
	@Test
	public void test1() { // test get
		list.add(0, num7);
		liste.add(0, num7);
		Object result1 = list.get(0);
		Object result2 = liste.get(0);
		assertEquals(num7, result1);
		assertEquals(num7, result2);
	}
/**.
 * ;
 */
	@Test
	public void test2() { // add test index> size
		list.add(0, num7);
		liste.add(0, num7);
		try {
			list.add(num3, num10);
			liste.add(num3, num10);
			Assert.fail("index out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * '
 */
	@Test
	public void test3() { // remove from empty list
		try {
			list.remove(2);
			liste.remove(2);
			Assert.fail("remove from empty list");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test
	public void test4() {
		list.add(0, num7);
		list.add(0, 1);
		list.add(0, num69);
		list.add(1, num96);
		list.add(num15);
		list.add(num5, num555);
		list.add(num5, num888);
		list.set(0, "m");
		Object result1 = list.get(0);
		Object result2 = list.get(num5);
		assertEquals("m", result1);
		assertEquals(num888, result2);
	}
/**.
 * ;
 */
	@Test
	public void test5() {
		liste.add(0, num7);
		liste.add(0, 1);
		liste.add(0, num69);
		liste.add(1, num96);
		liste.add(num15);
		liste.add(num5, num555);
		liste.add(num5, num888);
		liste.set(0, "m");
		Object result1 = liste.get(0);
		Object result2 = liste.get(num5);
		assertEquals("m", result1);
		assertEquals(num888, result2);
	}
/**.
 * ;
 */
	@Test() // test add(index-ve ,Object)
	public void test6() {
		try {
			list.add(num, num5);
			liste.add(num, num5);
			Assert.fail("add in -ve index");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test(expected = RuntimeException.class) // get -ve index
	public void test7() {
		list.get(num);
		liste.get(num);
	}
/**.
 * ;
 */
	@Test
	public void test8() { // test clear
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, num3);
		list.clear();
		try {
			list.get(0);
			Assert.fail();
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test
	public void test9() { // test clear and get 
		liste.add(0, 1);
		liste.add(1, 2);
		liste.add(2, num3);
		liste.clear();
		try {
			liste.get(0);
			Assert.fail(" the list was cleared:"
					+ "cannot get from an empty list");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * l
 */
	@Test(expected = RuntimeException.class) // sublist -ve index
	public void test10() {
		list.sublist(num, num5);
		liste.sublist(num, num5);
	}
/**.
 * ;
 */
	@Test
	public void test11() { // sublist>size index
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, num3);
		try {
			list.sublist(2, num5);
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * '
 */
	@Test
	public void test12() { // sublist>size index
		liste.add(0, 1);
		liste.add(1, 2);
		liste.add(2, num3);
		try {
			liste.sublist(2, num5);
			Assert.fail("index out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test
	public void test13() { // test isEmpty()
		list.add(0, num7);
		list.add(1, 2);
		list.add(2, num5);
		liste.add(0, num7);
		liste.add(1, 2);
		liste.add(2, num5);
		boolean result = list.isEmpty();
		Assert.assertEquals(false, result);
	}
/**.
 * ;
 */
	@Test // contains test on an empty list
	public void test14() {
		assertEquals(false, list.contains(num5));
		assertEquals(false, liste.contains(num5));
	}
/**.
 * ;
 */
	@Test(expected = RuntimeException.class) // remove -ve index
	public void test15() { // test remove
		list.add(num15);
		list.remove(num);
		liste.add(num15);
		liste.remove(num);

	}
/**.
 * ;
 */
	@Test
	public void test16() { // test isEmpty()
		boolean result = list.isEmpty();
		Assert.assertEquals(true, result);
	}
/**.
 * ;
 */
	@Test // contains && remove test
	public void test17() {
		list.add(0, num3);
		list.add(1, 2);
		list.add(2, num3);
		list.add(0, num5);
		list.remove(0);
		liste.add(0, num3);
		liste.add(1, 2);
		liste.add(2, num3);
		liste.add(0, num5);
		liste.remove(0);
		assertEquals(false, list.contains(num5));
		assertEquals(false, liste.contains(num5));
	}
/**.
 * ;
 */
	@Test // contains test
	public void test18() {
		list.add(0, num5);
		list.add(1, 2);
		list.add(2, 0);
		list.add(0, num3);
		assertEquals(true, list.contains(num3));
		liste.add(0, num5);
		liste.add(1, 2);
		liste.add(2, 0);
		liste.add(0, num3);
		assertEquals(true, liste.contains(num3));
	}
/**.
 * ;
 */
	@Test
	public void test19() { // test sublist
		list.add(0, num7);
		list.add(1, 2);
		list.add(2, num5);
		list.add(num3);
		list.add(num6);
		list.add(num4);
		ILinkedList newlist = list.sublist(1, num3);
		Object result = newlist.get(2);
		Assert.assertEquals(num3, result);
		liste.add(0, num7);
		liste.add(1, 2);
		liste.add(2, num5);
		liste.add(num3);
		liste.add(num6);
		liste.add(num4);
		ILinkedList newlist2 = liste.sublist(1, num3);
		Object result2 = newlist2.get(2);
		Assert.assertEquals(num3, result2);
	}
/**.
 * '
 */
	@Test
	public void test20() { // test size
		list.add(0, num7);
		list.add(1, 2);
		list.add(2, num5);
		list.add(num3);
		list.add(num6);
		list.add(num4);
		Assert.assertEquals(num6, list.size());
		liste.add(0, num7);
		liste.add(1, 2);
		liste.add(2, num5);
		liste.add(num3);
		liste.add(num6);
		liste.add(num4);
		Assert.assertEquals(num6, liste.size());
	}
/**.
 * '
 */
	@Test
	public void test21() {
		Assert.assertEquals(0, list.size());
		Assert.assertEquals(0, liste.size());
	}
/**.
 * '
 */
	@Test
	public void test22() { // test size
		list.add(0, num7);
		list.add(1, 2);
		list.remove(0);
		Assert.assertEquals(1, list.size());
		liste.add(0, num7);
		liste.add(1, 2);
		liste.remove(0);
		Assert.assertEquals(1, liste.size());
	}
/**.
 * '
 */
	@Test
	public void test23() {
		list.add(0, "p");
		list.add(1, "m");
		list.add(1, "n");
		list.add(1, "l");
		Assert.assertEquals("l", list.get(1));
		liste.add(0, "p");
		liste.add(1, "m");
		liste.add(1, "n");
		liste.add(1, "l");
		Assert.assertEquals("l", liste.get(1));
	}
/**.
 * '
 */
	@Test
	public void test24() { // set test index>size
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, num3);
		try {
			list.set(num4, num5);
			Assert.fail("index is out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
		liste.add(0, 1);
		liste.add(1, 2);
		liste.add(2, num3);
		try {
			liste.set(num4, num5);
			Assert.fail("index is out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test(expected = RuntimeException.class) // set empty list
	public void test25() {
		list.set(1, num5);
		liste.set(1, num5);
	}
/**.
 * ;
 */
	@Test
	public void test26() { // set list test //set -ve index
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, num3);
		try {
			list.set(num, num5);
			Assert.fail("cannot set at a -ve index");
		} catch (Exception e) {
			System.out.println(" ");
		}
		liste.add(0, 1);
		liste.add(1, 2);
		liste.add(2, num3);
		try {
			liste.set(num, num5);
			Assert.fail("cannot set at a -ve index");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test(expected = RuntimeException.class) // get empty list
	public void test27() {
		list.get(1);
		liste.get(1);
	}
/**.
 * ;
 */
	@Test
	public void test28() {
		list.add(1);
		list.clear();
		try {
			list.set(0, num10);
		} catch (Exception e) {
			System.out.println(" ");
		}
		liste.add(1);
		liste.clear();
		try {
			liste.set(0, num10);
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test
	public void test29() { // test get index> size
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, num3);
		try {
			list.get(num5);
			Assert.fail("index out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
		liste.add(0, 1);
		liste.add(1, 2);
		liste.add(2, num3);
		try {
			liste.get(num4);
			Assert.fail("index out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
/**.
 * ;
 */
	@Test
	public void test30() { // test remove index> size
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, num3);
		try {
			list.remove(num5);
			Assert.fail("index out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
		liste.add(0, 1);
		liste.add(1, 2);
		liste.add(2, num3);
		try {
			liste.remove(num4);
			Assert.fail("index out of bounds");
		} catch (Exception e) {
			System.out.println(" ");
		}
	}
}
