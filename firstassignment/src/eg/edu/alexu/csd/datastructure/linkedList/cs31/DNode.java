package eg.edu.alexu.csd.datastructure.linkedList.cs31;
/**.
 * ,,
 * @author Dell
 *,,
 */
public class DNode {
	/**..
	 * ;
	 */
	public Object value;
	/**..
	 * ;
	 */
	public DNode next;
	/**..
	 * ;
	 */
	public DNode prev;
/**..
 * .
 */
	public DNode() {
		value = null;
		next = null;
		prev = null;
	}
/**..
 * ;
 * @param p node
 * @param o object
 * @param n node
 */
	public DNode(DNode p, Object o, DNode n) {
		prev = p;
		value = o;
		next = n;
	}
}