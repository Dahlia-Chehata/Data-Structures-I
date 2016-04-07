package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs31.SLNode;

public class Singly_linkedlists implements ILinkedList{
	
	public SLNode head; 
	public int size; 
	
	public Singly_linkedlists() {
		head = null;
		size = 0;
		}

	@Override
	public void add(int index, Object element) throws RuntimeException{
		// TODO Auto-generated method stub
		SLNode new_node =new SLNode( );
		SLNode pointer=head;
		new_node.value=element;
		
		if (index==0){
			new_node.next=head;
			head=new_node;
			size++;
		}
		
		if (index==size){
	    while (pointer!=null)
	    	pointer=pointer.next;
			 pointer.next = new_node;
			 new_node.next=null;
			size++;

		}
	   if (index> 0 && index < size){
		   for (int i=0;i<index-1;i++){
			   pointer=pointer.next;
		   }
			
			new_node.next=pointer.next;
		    pointer.next=new_node;
		    
		    size++;
	   }
	    
	    else
	    	throw new RuntimeException();
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		SLNode pointer=head;
		SLNode new_node=new SLNode();
		new_node.value=element;
		while (pointer !=null)
			pointer=pointer.next;
	
	   pointer.next = new_node;
	   new_node.next=null;
	   size++;
	}
	   

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		SLNode pointer=head;
		for (int i=0;i<index;i++)
			pointer =pointer.next;
		
		return pointer.value;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		SLNode pointer=head;
		for (int i=0;i<index;i++)
			pointer =pointer.next;
		
		pointer.value=element;
		
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		 head=null;
		 size=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head==null &&size==0)
			return true;
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		SLNode pointer=head;
		SLNode temp;
		for (int i=0;i<index-1;i++){
			pointer=pointer.next;
		}
		temp=pointer.next;
		pointer.next=temp.next;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		SLNode pointer =head;
		while (pointer!=null){
			pointer=pointer.next;
			size++;
		}
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		SLNode pointer=head;
		while (pointer!=null){
			if (pointer.value==o)
				return true;
			pointer=pointer.next;
		}
		return false;
	}

}
