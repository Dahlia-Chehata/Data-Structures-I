package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import  eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;


import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class D_linkedlists {
  ILinkedList SL =new doubly_linkedlists ();
  @Test
	public void test1() {  //test get
		
		SL.add(0,7);
		Object result =SL.get(0);
		assertEquals(7, result);
		
	}
	@Test
	public void test2 (){   // add test index> size
		SL.add(0,7);
		try {
			SL.add(3,10);
			Assert.fail();
		}
		catch (Exception RuntimeException){
			
		}
	}
	@Test
	public void test3 (){    //remove from empty list
	 try{
		SL.remove(2);
		Assert.fail();
		}
		catch (Exception RuntimeException){
	}
}
	@Test
	public void test4 (){
		SL.add(0,7);
		SL.add(0,1);
		SL.add(0,69);
	    SL.add(1,96); 
   	SL.add(15);
   	SL.add(5,555);
   	SL.add(5,888);
   	SL.set(0,"m");
   	Object result1= SL.get(0);
   	Object result2= SL.get(5);
   	assertEquals ("m",result1);
   	assertEquals (888,result2);

	}
	@Test(expected = RuntimeException.class)     // test add(index-ve ,Object)
	public void test5() { 
		SL.add(-3, 5);

	}
	@Test(expected = RuntimeException.class)     //get -ve index
	public void test6() { 
		 SL.get(-1);
	}
	@Test
	public void test7 (){   //test clear
		SL.add(0,1);
		SL.add(1,2);
		SL.add(2,3);
     SL.clear();
     try{
     SL.get(0);
     Assert.fail();
     }
 catch (Exception RuntimeException){
	
}
	}
	@Test(expected = RuntimeException.class)  //sublist -ve index
	public void test8() { 
		SL.sublist(-3, 5);
	}
	@Test
	public void test9() {         //sublist>size index
		SL.add(0,1);
		SL.add(1,2);
		SL.add(2,3);
		try{
		SL.sublist(2, 5);
		}
		catch (Exception RuntimeException){
		}
		}
	@Test
	public void test10() {        // test isEmpty()
		SL.add(0, 7);
		SL.add(1, 2);
		SL.add(2, 5);

		boolean result = SL.isEmpty();
		Assert.assertEquals(false, result);

	}
	@Test                   //contains test on an empty list
	public void test11 (){
		assertEquals(false,SL.contains(5));
	}
	@Test(expected = RuntimeException.class) //remove -ve index
	public void test12() { // test remove
		SL.add(15);
		SL.remove(-1);

	}
	@Test                   //contains && remove test 
	public void test13(){
	SL.add(0,3);
	SL.add(1,2);
	SL.add(2,3);
	SL.add(0,5);
	SL.remove(0);
	assertEquals(false,SL.contains(5));
	}
	@Test                   //contains test 
	public void test14(){
	SL.add(0,5);
	SL.add(1,2);
	SL.add(2,0);
	SL.add(0,3);
	assertEquals(true,SL.contains(3));
	}
	@Test
	public void test15() { // test  sublist
		SL.add(0, 7);
		SL.add(1, 2);
		SL.add(2, 5);
		SL.add(3);
		SL.add(6);
		SL.add(4);
		ILinkedList newlist = SL.sublist(1, 3);
		Object result = newlist.get(2);
		
		Assert.assertEquals(3, result);

	}
	@Test
	public void test16() { // test  size
		SL.add(0, 7);
		SL.add(1, 2);
		SL.add(2, 5);
		SL.add(3);
		SL.add(6);
		SL.add(4);
		
		Assert.assertEquals(6,SL.size() );
	}
	@Test
	public void test17() { 
		Assert.assertEquals(0,SL.size() );
	}
	@Test
	public void test18() { // test  size
		SL.add(0, 7);
		SL.add(1, 2);
		SL.remove (0);
		Assert.assertEquals(1,SL.size() );
		
}
	@Test
	public void test19() {
		SL.add(0,"p");
		SL.add(1,"m");
		SL.add(1,"n");
		SL.add(1,"l");
		Assert.assertEquals("l",SL.get(1) );
	}
	@Test
	public void test20() {   //set test    index>size  
		SL.add(0,1);
		SL.add(1,2);
		SL.add(2,3);
		try{
		SL.set(4,5);
		}
		catch (Exception RuntimeException){
}
}
	@Test(expected = RuntimeException.class) //set empty list
	public void test21() {
		SL.set(1,9);

	}
	@Test
	public void test22() {   //set  list test      //set -ve index
		SL.add(0,1);
		SL.add(1,2);
		SL.add(2,3);
		try{
		SL.set(-4,5);
		}
		catch (Exception RuntimeException){
}
	}
	@Test(expected = RuntimeException.class) //get empty list
	public void test23() {
		SL.get(1);

	}
	@Test
	public void test24() {
		SL.add(12);
		SL.clear();
		try{
			SL.set(0,15);
		}
		catch(Exception RuntimeException){
			
		}

	}

}
