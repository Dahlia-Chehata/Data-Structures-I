package eg.edu.alexu.csd.datastructure.stack.cs31;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
import eg.edu.alexu.csd.datastructure.stack.IStack;
/**.
 * @author Dell
 */
public class ExpressionEvaluator implements
/**.
 * ..
 */
IExpressionEvaluator {
/**.
 * .
 */
	static IStack stack = new Stack();
	@Override
	/**.
	 * to convert from infix to postfix
	 */
public String infixToPostfix(final String expression) { 
		// TODO Auto-generated method stub
		/**.
		 */
		StringBuffer str = new StringBuffer();
		/**.
		 */
		boolean flag = true;
		/**.
		 * check null
		 */
		if (expression == null) {
			throw new RuntimeException("bbb");
		}
		/**.
		 * check starting with operator
		 */
		if (expression.charAt(0) == '/'
				|| expression.charAt(0) == '*' 
				|| expression.charAt(0) == '+'
				|| expression.charAt(0) == '-') {
			throw new RuntimeException(""
					+ "starting with operator");
		}
		/**.
		 * check ending with operator
		 */
	if (expression.charAt(expression.length() - 1) == '/' 
	|| expression.charAt(expression.length() - 1) == '*'
	|| expression.charAt(expression.length() - 1) == '+'
	|| expression.charAt(expression.length() - 1) == '-') {
			throw new RuntimeException(""
					+ "ending  with operator");
	}
		/**.
		 * check unary
		 */
		boolean test = true;
for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ' ') {
				continue;
			} else if (expression.charAt(i) == '/'
					|| expression.charAt(i) == '*' 
					|| expression.charAt(i) == '+'
					|| expression.charAt(i) == '-') {
	if (test) {
	throw new RuntimeException(""
		+ "having unary operator");
	} else {
			test = true;
	} } else {
			test = false;
	}
		}	
		/**.
		 * no operator case
		 */
for (int i = 0; i < expression.length() - 1 
				&& flag; i++) {
			flag = false;
			if (expression.charAt(i) != '*' 
					&& expression.charAt(i) != '+' 
					&& expression.charAt(i) != '-'
					&& expression.charAt(i) != '/') {
				flag = true;
			}
		}
	if (flag) {
		throw new RuntimeException("no operator");
		}
		/**.
		 * test symbols and digits like :6k
		 */
	for (int i = 0; i < expression.length() - 1; i++) {
			// test all symbols
			if ((('A' < expression.charAt(i)
		&& expression.charAt(i) < 'Z')
		&& '0' < expression.charAt(i + 1) 
		&& expression.charAt(i + 1) < '9')
		|| (('a' < expression.charAt(i)
		&& expression.charAt(i) < 'z')
		&& '0' < expression.charAt(i + 1)
		&& expression.charAt(i + 1) < '9')) {
		throw new RuntimeException("oooo");
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ' ') {
				continue;
			}
		if (expression.charAt(i) == '(') {
				stack.push(expression.charAt(i));
		} else if (expression.charAt(i) == ')') {
		while (stack.size() != 0 
		&& (char) stack.peek() != '(') {
		str.append(stack.pop());
		str.append(" ");
			}
		if (stack.isEmpty() || (!stack.isEmpty() 
		&& (char) stack.peek() != '(')) {
		throw new RuntimeException("there is no (");
		}
		stack.pop();
		} else if (expression.charAt(i) == '*'
		|| expression.charAt(i) == '/') {
		if (stack.isEmpty()) {
		stack.push(expression.charAt(i));
		} else if ((char) stack.peek() == '+'
		|| (char) stack.peek() == '-') {
		stack.push(expression.charAt(i));
		} else {
		while (stack.size() != 0
		&& ((char) stack.peek() == '*' 
		|| (char) stack.peek() == '/')) {
		str.append(stack.pop());
		str.append(" ");
		}
		stack.push(expression.charAt(i));
		}
		} else if (expression.charAt(i) == '+'
		|| expression.charAt(i) == '-') {
		while (stack.size() != 0 
		&& ((char) stack.peek() == '*' 
		|| (char) stack.peek() == '/'
		|| (char) stack.peek() == '+'
		|| (char) stack.peek() == '-')) {
		str.append(stack.pop());
		str.append(" ");
		}
		stack.push(expression.charAt(i));
			} else if (('A' <= expression.charAt(i)
				&& expression.charAt(i) <= 'Z')
				|| ('a' <= expression.charAt(i) 
				&& expression.charAt(i) <= 'z')
				|| ('0' <= expression.charAt(i) 
			  && expression.charAt(i) <= '9')) {
				while (i < expression.length() 
			&& (('A' <= expression.charAt(i) 
			&& expression.charAt(i) <= 'Z')
		|| ('a' <= expression.charAt(i) 
			&& expression.charAt(i) <= 'z')
			|| ('0' <= expression.charAt(i) 
			&& expression.charAt(i) <= '9'))) {
		str.append(expression.charAt(i));
						i++;
					}
			i--;
			str.append(" ");
			}
		}
		while (!stack.isEmpty()) {
			if ((char) stack.peek() == '(') {
throw new RuntimeException("'(' without a ')'");
			}
			str.append(stack.pop());
			str.append(" ");
		}
 return str.toString().trim();
// to remove space from 
 //end and start of a
		// string
	}
	@Override
	/**.
	 * evaluate postfix expression
	 */
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
/**.
 * .
 */
		double operand1 = 0;
		/**.
		 * .
		 */
		double operand2 = 0;
		/**.
		 * .
		 */
		String str = new String();
		/**.
		 * test null case
		 */
		if (expression == null) {
			throw new RuntimeException();
		}
		/**.
		 * test symbolic expression
		 */
		for (int i = 0; i < expression.length(); i++) {
			if (('a' <= (expression.charAt(i)) && 'z'
		>= (expression.charAt(i)))
	|| ('A' <= (expression.charAt(i)) 
	&& 'Z' >= (expression.charAt(i)))) {
  throw new RuntimeException("lolololol");
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			/**.
			 * space
			 */
			if (expression.charAt(i) == ' ') {
				continue;
			}
			/**.
			 * digits
			 */
			if ('0' <= expression.charAt(i) 
					&& expression.charAt(i) <= '9') {
			while (i < expression.length() 
			&& '0' <= expression.charAt(i) 
			&& expression.charAt(i) <= '9') {
			str += expression.charAt(i);
					i++;
				}
				i--;
				stack.push(Double.parseDouble(str));
				str = "";
				/**.
				 * signs
				 */
			} else if (expression.charAt(i) == '*') {
				if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand2 = (double) stack.pop();
				}
				if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand1 = (double) stack.pop();
				}
				stack.push((double) operand1 * operand2);
			} else if (expression.charAt(i) == '+') {
				if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand2 = (double) stack.pop();
				}
				if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand1 = (double) stack.pop();
				}
				stack.push((double) operand1 + operand2);
			} else if (expression.charAt(i) == '-') {
				if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand2 = (double) stack.pop();
				}
				if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand1 = (double) stack.pop();
				}
				stack.push((double) operand1 - operand2);
			} else if (expression.charAt(i) == '/') {
				if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand2 = (double) stack.pop();
				}if (stack.isEmpty()) {
					throw new RuntimeException();
				}else {
					operand1 = (double) stack.pop();
				}if (operand2 == 0) {
					throw new RuntimeException();
				}else if (operand1 == 0) {
					stack.push(0);
				}else {
	stack.push((double) operand1 / operand2);
				}
			}
		}
		if (stack.isEmpty()) {
			throw new RuntimeException();
		}
		return (int) (double) stack.pop();
	}
	/**.
	 * @param args main
	 */
	public static void main(final String[] args) {
		/**.
		 * .
		 */
IExpressionEvaluator app = new ExpressionEvaluator();
/**.
 * ;
 */
		 final int num3 = 3;
		 /**.
		  * ;
		  */
		Scanner scan = new Scanner(System.in);
		/**.
		 * ;
		 */
		String input = "";
		/**.
		 * ;
		 */
		String conv = "";
		/**.
		 * ;
		 */
		int choice;
		/**.
		 * ;
		 */
		char ch;
		do {
System.out.println("      options");
System.out.println("-----------------------------");
System.out.println("1- insert an expression");
System.out.println("2-infix to postfix conversion");
System.out.println("3-evaluate expression");
System.out.println("------------------------------");
/**.
 * ;
 */
		choice = scan.nextInt();
			switch (choice) {
			/**.
			 * taking input
			 */
			case 1:
				input = scan.next();
				break;
			/**.
			 * converting
			 */
			case 2:
				if (input == "") {
					System.out.println(""
+ "you should insert an expression");
		} else if (input.charAt(0) == '/' 
				|| input.charAt(0) == '*' 
				|| input.charAt(0) == '+'
				|| input.charAt(0) == '-') {
System.out.println("starting with operator");
		}
				else {
			conv = app.infixToPostfix(input);
			System.out.println(conv);
				}
				break;
			/**.
			 * evaluating
			 */
			case num3: 
			if (input == "") {
					System.out.println(""
	+ "you should insert an expression");
					break;
				} else if (conv == "") {
	System.out.println("you should convert"
	+ " infix expression to postfix:" + ""
	+ " choose option 2");
					break;
				}
				/**.
				 * .
				 */
				boolean f1 = false;
				for (int i = 0; i < conv.length(); i++) {
					if (('a' <= (conv.charAt(i)) 
			&& 'z' >= (conv.charAt(i)))
			|| ('A' <= (conv.charAt(i))
			&& 'Z' >= (conv.charAt(i)))) {

	System.out.println("can't evaluate symbols");
						f1 = true;
					}
				}
				if (f1) {
					break;
				}
				/**.
				 * '
				 */
				boolean flag = true;
				for (int i = 0; i < conv.length()
						&& flag; i++) {
					flag = false;
		if ('0' <= (conv.charAt(i))
		& '9' >= (conv.charAt(i))
		|| conv.charAt(i) == ' '
		|| conv.charAt(i) == '*' 
		|| conv.charAt(i) == '/' 
		|| conv.charAt(i) == '+'
		|| conv.charAt(i) == '-') {
		flag = true;
					}
			}
				if (flag && !f1) {
System.out.println(app.evaluate(conv));
				}
				break;
			/**.
			 * other input
			 */
			default:
System.out.println("Wrong Entry ");
			}
System.out.println("========================"
					+ "================");
System.out.println("\nDo you want to continue"
+ " (Type y or anykey to terminate) \n");
ch = scan.next().charAt(0);
System.out.println("===================="
+ "===================");
} while (ch == 'Y' || ch == 'y');
}
}