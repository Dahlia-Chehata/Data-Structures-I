package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class Singly_linkedlists implements ILinkedList {

	public SLNode head;
	public int size;

	public Singly_linkedlists() {
		head = null;
		size = 0;
	}

	@Override
	public void add(int index, Object element) throws RuntimeException {
		// TODO Auto-generated method stub
		SLNode new_node = new SLNode();
		SLNode pointer = head;
		new_node.value = element;

		if (index == 0) {
			new_node.next = head;
			head = new_node;
			size++;
		}

		else if (index == size) {
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = new_node;
			new_node.next = null;
			size++;

		} else if (index > 0 && index < size) {
			for (int i = 0; i < index - 1; i++) {
				pointer = pointer.next;
			}

			new_node.next = pointer.next;
			pointer.next = new_node;

			size++;
		}

		else {
			throw new RuntimeException();
		}
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		SLNode pointer = head;
		SLNode new_node = new SLNode();
		new_node.value = element;
		if (head == null) {
			// new_node.next=null;
			head = new_node;
		} else {
			while (pointer.next != null) {
				pointer = pointer.next;
			}

			pointer.next = new_node;
			new_node.next = null;
		}
		size++;
	}

	@Override
	public Object get(int index) throws RuntimeException {
		// TODO Auto-generated method stub
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

	@Override
	public void set(int index, Object element) throws RuntimeException {
		// TODO Auto-generated method stub
		SLNode pointer = head;
		if (index >= 0 && index < size) {
			for (int i = 0; i < index; i++){
				pointer = pointer.next;
			}
			pointer.value = element;
		} else {
			throw new RuntimeException();
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(int index) throws RuntimeException {
		// TODO Auto-generated method stub
		SLNode pointer = head;
		SLNode temp;
		if (isEmpty()) {
			throw new RuntimeException();
		}
		else if (index == 0) {
			temp = head;
			head = head.next;
			temp.next = null;
			size--;
		}

		else if (index > 0 && index < size) {
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

	@Override
	public int size() {
		// TODO Auto-generated method stub

		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) throws RuntimeException {
		// TODO Auto-generated method stub
		ILinkedList new_list = new Singly_linkedlists();
		SLNode pointer = head;
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

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
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
