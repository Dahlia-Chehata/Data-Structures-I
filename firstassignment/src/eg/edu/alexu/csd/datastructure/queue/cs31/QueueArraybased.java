package eg.edu.alexu.csd.datastructure.queue.cs31;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.IArrayBased;

public class QueueArraybased implements IArrayBased, IQueue {
	Object[] arr;
	int size;
	int n, r, f;

	public QueueArraybased(Object[] arr, int n) {
		this.arr = arr;
		this.n = n;
		arr = new Object[n];
		size = 0;
		r = 0;
		f = 0;
	}

	@Override
	public void enqueue(Object item) throws RuntimeException {
		// TODO Auto-generated method stub
		if (size >= n)
			throw new RuntimeException();
		arr[r] = item;
		if (r == n - 1)
			r = 0;
		else
			r++;
		size++;
	}

	@Override
	public Object dequeue() throws RuntimeException {
		// TODO Auto-generated method stub
		if (size == 0)
			throw new RuntimeException();
		Object temp = arr[f];
		arr[f] = null;
		if (f == n - 1)
			f = 0;
		else
			f++;
		size--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
