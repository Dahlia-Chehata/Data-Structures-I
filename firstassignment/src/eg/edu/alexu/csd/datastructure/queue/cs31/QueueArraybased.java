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
	int n, r, f;
/**.
 * ;
 */
	public QueueArraybased(){
		size=0;
		r=0;
		f=0;
	}
	/**.
	 * n size
	 * 
	 */
	public QueueArraybased(int n) {
		this.n=n;
		arr=new Object[n];
		
	}
/**.
 * ;
 */
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if (size>=n)
			throw new RuntimeException();
		arr[r] = item;
		if (r==n - 1)
			r=0;
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
		if (size==0)
			throw new RuntimeException();
		Object temp = arr[f];
		arr[f]=null;
		if (f==n - 1)
			f=0;
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
		return (size==0);
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
