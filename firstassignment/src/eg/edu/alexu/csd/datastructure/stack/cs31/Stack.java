package eg.edu.alexu.csd.datastructure.stack.cs31;
import eg.edu.alexu.csd.datastructure.stack.IStack;
//import eg.edu.alexu.csd.datastructure.linkedList.cs31.SLNode;
import eg.edu.alexu.csd.datastructure.linkedList.cs31.Singly_linkedlists;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**.
 * @author Dell
 */
public class Stack implements IStack {
	/**..
	 * .
	 */
	ILinkedList mylist = new Singly_linkedlists();
	/**..
	 * .
	 */
	int size = mylist.size();
	/**..
	 * add in stack
	 */
	@Override
	public void add(int index, Object element) throws RuntimeException {
		// TODO Auto-generated method stub
		mylist.add(mylist.size() - index, element);
	}
	/**..
	 * popping
	 */
	@Override
	public Object pop() throws RuntimeException {
		// TODO Auto-generated method stub
		/**..
		 * .
		 */
		Object pop = mylist.get(0);
		mylist.remove(0);
		return pop;
	}
	/**..
	 * peeking
	 */
	@Override
	public Object peek() throws RuntimeException {
		// TODO Auto-generated method stub
		return mylist.get(0);
	}
	/**..
	 * pushing
	 */
	@Override
	public void push(Object element) throws RuntimeException {
		// TODO Auto-generated method stub
		mylist.add(0, element);
	}
	/**..
	 * checking if empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (mylist.isEmpty());
	}
	/**..
	 * size of stack
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mylist.size();
	}
	/**..
	 * @param args main
	 */
	public static void main(String[] args) {
		 /**..
		  * .
		  */
		final int num3=3;
		/**..
		 * .
		 */
		 final int num4=4;
		 /**..
		  * ;
		  */
	      final int num5=5;
/**..
 * .
 */
		IStack stack = new Stack();
		/**..
		 * ;
		 */
		char ch;
		/**..
		 * .
		 */
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("choose an option");
			System.out.println("--------------------");
			System.out.println("1-Push");
			System.out.println("2-Pop");
			System.out.println("3-Peek");
			System.out.println("4-Get size");
			System.out.println("5-check if empty");
			System.out.println("-------"
					+ "-------------");
			/**..
			 * .
			 */
			int choice = scan.nextInt();
			/**..
			 * choice:for the 5 options
			 */
			switch (choice) {
			case 1:
				System.out.println(""
						+ "insert an input");
				/**.
				 * .
				 */
				Object element = scan.next();
				stack.push(element);
				break;
			case 2:
				if (stack.isEmpty())
					System.out.println(""
							+ "stack is empty");
				else
					System.out.println(stack.pop());
				break;
			case num3:
				if (stack.isEmpty())
					System.out.println(""
							+ "stack is empty");
				else
					System.out.println(stack.peek());
				break;
			case num4:
				System.out.println(stack.size());
				break;
			case num5:
				if (stack.isEmpty())
					System.out.println(""
							+ "stack is empty");
				else
					System.out.println("stack"
							+ " is not empty");
				break;
			default:
				System.out.println(""
						+ "Wrong Entry ");
			}
			System.out.println("======="
					+ "=============="
					+ "===================");
			System.out.println("\nDo you "
					+ "want to continue"
					+ "(Type y or anykey"
					+ " to terminate) \n");
			ch = scan.next().charAt(0);
			System.out.println("===================="
					+ "===================");
		} while (ch == 'Y' || ch == 'y');
	}
}
