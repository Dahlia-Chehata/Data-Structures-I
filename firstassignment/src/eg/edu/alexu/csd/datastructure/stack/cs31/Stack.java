package eg.edu.alexu.csd.datastructure.stack.cs31;

import eg.edu.alexu.csd.datastructure.stack.IStack;
//import eg.edu.alexu.csd.datastructure.linkedList.cs31.SLNode;
import eg.edu.alexu.csd.datastructure.linkedList.cs31.Singly_linkedlists;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class Stack implements IStack {

	ILinkedList mylist = new Singly_linkedlists();

	@Override
	public void add(int index, Object element) throws RuntimeException {
		// TODO Auto-generated method stub
		mylist.add(mylist.size() - index, element);
	}

	@Override
	public Object pop() throws RuntimeException {
		// TODO Auto-generated method stub
		Object pop = mylist.get(0);
		mylist.remove(0);
		return pop;
	}

	@Override
	public Object peek() throws RuntimeException {
		// TODO Auto-generated method stub
		return mylist.get(0);
	}

	@Override
	public void push(Object element) throws RuntimeException {
		// TODO Auto-generated method stub
		mylist.add(0, element);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (mylist.isEmpty());
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mylist.size();
	}

}
