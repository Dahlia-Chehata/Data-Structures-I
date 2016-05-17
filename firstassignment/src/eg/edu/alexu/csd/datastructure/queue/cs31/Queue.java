package eg.edu.alexu.csd.datastructure.queue.cs31;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs31.*;

public class Queue implements IQueue,ILinkedBased {
 /**
  * .
  */
	ILinkedList mylist=new doubly_linkedlists();
	
	/**
	 * .
	 */
	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		mylist.add(item);
	}
/**
 * .
 */
	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		Object item=mylist.get(0);
		mylist.remove(0);
		return item;
	}
	/**
	 * .
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return mylist.isEmpty();
	}
/**
 * .
 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mylist.size();
	}

}
