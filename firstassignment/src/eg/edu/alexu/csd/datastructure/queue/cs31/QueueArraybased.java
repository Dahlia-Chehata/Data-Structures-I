package eg.edu.alexu.csd.datastructure.queue.cs31;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
/**.
 * 
 * @author Dell
 *
 */
public class QueueArraybased implements IQueue,IArrayBased {
	/**.
	 * .
	 */
	Object[] arr;
	/**.
	 * .
	 */
	int size;
	/**.
	 * .
	 */
	int ns, r, f;
/**.
 * ;
 */
	public QueueArraybased() {
		size = 0;
		r = 0;
		f = 0;
	}
	/**.
	 * n size
	 * @param n size of array
	 */
	public QueueArraybased(final int n) {
		ns = n;
		arr = new Object[n];
		
	}
/**.
 * ;
 */
	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		if (size >= ns)
			throw new RuntimeException();
		arr[r] = item;
		if (r == ns - 1)
			r = 0;
		else
			r++;
		size++;
	}
/**.
 * .
 */
	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (size == 0)
			throw new RuntimeException();
		Object temp = arr[f];
		arr[f] = null;
		if (f == ns - 1)
			f = 0;
		else
			f++;
		size--;
		return temp;
	}
	/**.
	 * ;
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}
	/**.
	 * l
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}