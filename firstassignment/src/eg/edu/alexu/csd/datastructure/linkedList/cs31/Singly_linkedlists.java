package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
public class Singly_linkedlists implements ILinkedList{
	
	class SLNode {
		private Object element; 
		private SLNode next; 
		public SLNode (Object element){
				this.element=element;
		}
	}
	
	private SLNode head=null;
	
	public void insert_first_node (Object element){
		SLNode  newnode = new SLNode (element);
		head = newnode;
		}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		SLNode new_node =new SLNode(element);
		head =new_node;
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
