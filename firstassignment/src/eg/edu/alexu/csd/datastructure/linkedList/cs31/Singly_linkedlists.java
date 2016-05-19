package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**.
 * 
 * @author Dell
 *
 */
public class Singly_linkedlists implements ILinkedList {
/**.
 * '
 */
	public SLNode head;
	/**.
	 * ';
	 */
	public int size;
/**.
 * ;
 */
	public Singly_linkedlists() {
		head = null;
		size = 0;
	}
/**.
 * '
 */
	@Override
	public void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		/**.
		 * '
		 */
		SLNode newNode = new SLNode();
		/**.
		 * ;
		 */
		SLNode pointer = head;
		newNode.value = element;
		if (index == 0) {
			newNode.next = head;
			head = newNode;
			size++;
		} else if (index == size) {
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = newNode;
			newNode.next = null;
			size++;
		} else if (index > 0 && index < size) {
			for (int i = 0; i < index - 1; i++) {
				pointer = pointer.next;
			}
			newNode.next = pointer.next;
			pointer.next = newNode;
			size++;
		} else {
			throw new RuntimeException();
		}
	}
/**.
 * ;
 */
	@Override
	public void add(final Object element) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		SLNode pointer = head;
		/**.
		 * ;
		 */
		SLNode newNode = new SLNode();
		newNode.value = element;
		if (head == null) {
			// newNode.next=null;
			head = newNode;
		} else {
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = newNode;
			newNode.next = null;
		}
		size++;
	}
/**.
 * ;
 */
	@Override
	public Object get(final int index) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		SLNode pointer = head;
		if (index >= 0 && index < size) {
			for (int i = 0; i < index; i++) {
				pointer = pointer.next;
			}
			return pointer.value;
		} else {
			throw new RuntimeException();
		}
	}
/**.
 * ;
 */
	@Override
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		SLNode pointer = head;
		if (index >= 0 && index < size) {
			for (int i = 0; i < index; i++) {
				pointer = pointer.next;
			}
			pointer.value = element;
		} else {
			throw new RuntimeException();
		}
	}
/**.
 * ;
 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		size = 0;
	}
/**.
 * '
 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null) {
			return true;
		}
		return false;
	}
/**.
 * '
 */
	@Override
	public void remove(final int index) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		SLNode pointer = head;
		/**.
		 * '
		 */
		SLNode temp;
		if (isEmpty()) {
			throw new RuntimeException();
		} else if (index == 0) {
			temp = head;
			head = head.next;
			temp.next = null;
			size--;
		} else if (index > 0 && index < size) {
			for (int i = 0; i < index - 1; i++) {
				pointer = pointer.next;
			}
			temp = pointer.next;
			pointer.next = temp.next;
			temp.next = null;
			size--;
		} else {
			throw new RuntimeException();
		}
	}	
/**.
 * ;
 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
/**.
 * ;
 */
	@Override
	public ILinkedList sublist(final int fromIndex,
			final int toIndex) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		ILinkedList newList = new Singly_linkedlists();
		/**.
		 * ;
		 */
		SLNode pointer = head;
		if (fromIndex >= 0 && fromIndex < size 
				&& toIndex >= 0 && toIndex < size) {
			for (int i = 0; i < fromIndex; i++) {
				pointer = pointer.next;
			}
			for (int i = fromIndex; i <= toIndex; i++) {
				newList.add(pointer.value);
				pointer = pointer.next;
			}
			return newList;
		} else {
			throw new RuntimeException();
		}
	}
/**.
 * ;
 */
	@Override
	public boolean contains(final Object o) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		SLNode pointer = head;
		if (isEmpty()) {
			return false;
		}
		while (pointer != null) {
			if (pointer.value.equals(o)) {
				return true;
			}
			pointer = pointer.next;
		}
		return false;
	}
}