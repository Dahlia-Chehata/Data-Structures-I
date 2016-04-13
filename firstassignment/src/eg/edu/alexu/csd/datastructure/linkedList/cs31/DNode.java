package eg.edu.alexu.csd.datastructure.linkedList.cs31;

public class DNode {
	public Object value;
	public DNode next;
	public DNode prev;

	public DNode() {
		value = null;
		next = null;
		prev = null;
	}

	public DNode(DNode p, Object o, DNode n) {
		prev = p;
		value = o;
		next = n;
	}
}