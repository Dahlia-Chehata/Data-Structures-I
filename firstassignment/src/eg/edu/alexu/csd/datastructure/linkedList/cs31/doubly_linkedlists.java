package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**.
 * ..
 * @author Dell
 *...
 */
public class doubly_linkedlists implements ILinkedList {
	/**.
	 * .
	 */
	public int size;
	/**.
	 * \
	 */
	public DNode header, tailer;
/**.
 * ;;
 */
	public doubly_linkedlists() {
		size = 0;
		header = new DNode(null, null, null);
		tailer = new DNode(header, null, null);
		header.next = tailer;
	}
/**.
 * .
 */
	@Override
	public void add(int index, Object element)
			throws RuntimeException {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		DNode new_node = new DNode();
		new_node.value = element;
		/**.
		 * .
		 */
		DNode pointer = header.next;
		if (index == 0) {
			new_node.next = pointer;
			new_node.prev = header;
			header.next = new_node;
			pointer.prev = new_node;
			size++;
		} else if (index == size) {
			/**.
			 * .
			 */
			DNode temp = tailer.prev;
			temp.next = new_node;
			new_node.next = tailer;
			tailer.prev = new_node;
			new_node.prev = temp;
			size++;
		} else if (index > 0 && index < size) {
			for (int i = 0; i < index - 1; i++) {
				pointer = pointer.next;
			}
			/**.
			 * .
			 */
			DNode temp = pointer.next;
			pointer.next = new_node;
			new_node.next = temp;
			new_node.prev = pointer;
			temp.prev = new_node;
			size++;
		} else {
			throw new RuntimeException();
		}
	}
/**.
 * ;
 */
	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		/**.
		 * .
		 */
		DNode new_node = new DNode();
		new_node.value = element;
		if (size == 0) {
			DNode temp = header.next;
			header.next = new_node;
			new_node.next = temp;
			new_node.prev = header;
			temp.prev = new_node;
		} else {
			DNode temp = tailer.prev;
			temp.next = new_node;
			new_node.next = tailer;
			tailer.prev = new_node;
			new_node.prev = temp;
		}
		size++;
	}
/**.
 * ;
 */
	@Override
	public Object get(int index) throws RuntimeException {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		DNode pointer = header.next;
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
	public void set(int index, Object element)
			throws RuntimeException {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		DNode pointer = header.next;
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
		size = 0;
		header.next = tailer;
		tailer.prev = header;
	}
	/**.
	 * ;
	 */

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}
/**.
 * ;
 */
	@Override
	public void remove(int index) throws RuntimeException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new RuntimeException();
		}else if (index == 0) {
			/**.
			 * .
			 */
			DNode removed = header.next;
			/**.
			 * .
			 */
			DNode temp = removed.next;
			temp.prev = header;
			removed.next = null;
			removed.prev = null;
			header.next = temp;
			size--;
		} else if (index > 0 && index < size - 1) {
			/**.
			 * ;
			 */
			DNode pointer = header.next;
			for (int i = 0; i < index - 1; i++) {
				pointer = pointer.next;
			}
			/**.
			 * .
			 */
			DNode removed = pointer.next;
			/**.
			 * .
			 */
			DNode temp = removed.next;
			removed.next = null;
			removed.prev = null;
			temp.prev = pointer;
			pointer.next = temp;
			size--;
		} else if (index == size - 1) {
			/**.
			 * .
			 */
			DNode removed = tailer.prev;
			/**.
			 * .
			 */
			DNode temp = removed.prev;
			removed.next = null;
			removed.prev = null;
			temp.next = tailer;
			tailer.prev = temp;
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
public ILinkedList sublist(int fromIndex, int toIndex)
		throws RuntimeException {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		ILinkedList new_list = new doubly_linkedlists();
		/**.
		 * ;
		 */
		DNode pointer = header.next;
		if (fromIndex >= 0 && fromIndex < size 
				&& toIndex >= 0 && toIndex < size) {
			for (int i = 0; i < fromIndex; i++) {
				pointer = pointer.next;
			}
			for (int i = fromIndex; i <= toIndex; i++) {
				new_list.add(pointer.value);
				pointer = pointer.next;
			}
			return new_list;
		} else {
			throw new RuntimeException();
		}
	}
/**.
 * ;
 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		DNode pointer = header.next;
		if (isEmpty()) {
			return false;
		}

		while (pointer != null && pointer != tailer) {
			if (pointer.value.equals(o)) {
				return true;
			}
			pointer = pointer.next;
		}
		return false;
	}

}
