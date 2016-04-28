package eg.edu.alexu.csd.datastructure.stack.cs31;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
import eg.edu.alexu.csd.datastructure.stack.IStack;

public class ExpressionEvaluator implements IExpressionEvaluator {

	static IStack stack = new Stack();

	@Override
	public String infixToPostfix(String expression) throws RuntimeException {

		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer();
		boolean flag = true;
		if (expression == null) {
			throw new RuntimeException("bbb");

		}
		if (expression.charAt(0) == '/' || expression.charAt(0) == '*' || expression.charAt(0) == '+'
				|| expression.charAt(0) == '-')
			throw new RuntimeException("starting with operator");

		/*
		 * for (int i=0;i<expression.length();i++){
		 * 
		 * if (expression.charAt(i)!='(' && expression.charAt(i)!=' ' &&
		 * expression.charAt(i)!='*' && expression.charAt(i)!= '+' &&
		 * expression.charAt(i)!='-' && expression.charAt(i)!='/' &&
		 * expression.charAt(i)!=')' &&('0'>expression.charAt(i)
		 * ||'9'<(expression.charAt(i)))){
		 * 
		 * 
		 * throw new RuntimeException("aaaa");
		 * 
		 * }
		 * 
		 * }
		 */

		for (int i = 0; i < expression.length() - 1 && flag; i++) {
			flag = false;
			if (expression.charAt(i) != '*' && expression.charAt(i) != '+' && expression.charAt(i) != '-'
					&& expression.charAt(i) != '/')
				flag = true;
		}
		if (flag) {
			throw new RuntimeException("no operator");
		}
		for (int i = 0; i < expression.length() - 1; i++) {

			// test all symbols
			if ((('A' < expression.charAt(i) && expression.charAt(i) < 'Z')

					&& '0' < expression.charAt(i + 1) && expression.charAt(i + 1) < '9')

					|| (('a' < expression.charAt(i) && expression.charAt(i) < 'z')

							&& '0' < expression.charAt(i + 1) && expression.charAt(i + 1) < '9')) {

				throw new RuntimeException("oooo");

			}
		}

		for (int i = 0; i < expression.length() - 1; i++) {

			// test all symbols
			if ((expression.charAt(i) == '(' || expression.charAt(i) == '*' || expression.charAt(i) == '+'
					|| expression.charAt(i) == '-' || expression.charAt(i) == '/')
					&& (expression.charAt(i + 1) == '*' || expression.charAt(i + 1) == '+'
							|| expression.charAt(i + 1) == '-' || expression.charAt(i + 1) == '/'
							|| expression.charAt(i + 1) == ')')) {

				throw new RuntimeException("oooo");

			}
			if (expression.charAt(i + 1) == ')' && expression.charAt(i + 1) == '(') {

				throw new RuntimeException("ssss");
			}
		}

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ' ')
				continue;
			if (expression.charAt(i) == '(') {
				stack.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')') {

				while (stack.size() != 0 && (char) stack.peek() != '(') {
					str.append(stack.pop());
					str.append(" ");
				}
				if (stack.isEmpty() || (!stack.isEmpty() && (char) stack.peek() != '('))
					throw new RuntimeException("there is no (");
				stack.pop();
			} else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
				if (stack.isEmpty()) {
					stack.push(expression.charAt(i));
				} else if ((char) stack.peek() == '+' || (char) stack.peek() == '-') {
					stack.push(expression.charAt(i));
				} else {
					while (stack.size() != 0 && ((char) stack.peek() == '*' || (char) stack.peek() == '/')) {
						str.append(stack.pop());
						str.append(" ");
					}
					stack.push(expression.charAt(i));
				}
			} else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				while (stack.size() != 0 && ((char) stack.peek() == '*' || (char) stack.peek() == '/'
						|| (char) stack.peek() == '+' || (char) stack.peek() == '-')) {
					str.append(stack.pop());
					str.append(" ");
				}
				stack.push(expression.charAt(i));
			} else if (('A' <= expression.charAt(i) && expression.charAt(i) <= 'Z')
							|| ('a' <= expression.charAt(i) && expression.charAt(i) <= 'z')
							|| ('0' <= expression.charAt(i) && expression.charAt(i) <= '9')) {{

				
					

						while (i<expression.length()
								&&(('A' <= expression.charAt(i) && expression.charAt(i) <= 'Z')
								|| ('a' <= expression.charAt(i) && expression.charAt(i) <= 'z')
								|| ('0' <= expression.charAt(i) && expression.charAt(i) <= '9'))) {

							str.append(expression.charAt(i));

							i++;

						}
						
						i--;
					str.append(" ");

					}

				

			}

		}

		while (!stack.isEmpty()) {
			if ((char) stack.peek() == '(')
				throw new RuntimeException("'(' without a ')'");

			str.append(stack.pop());
			str.append(" ");
		}

		return str.toString().trim();// to remove space from end and start of a
										// string
	}

	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub

		double operand1 = 0;
		double operand2 = 0;
		String str=new String();

		if (expression == null) {
			throw new RuntimeException();
		}
		// expression =infixToPostfix(expression);

		for (int i = 0; i < expression.length(); i++) {
			if (('a' <= (expression.charAt(i)) && 'z' >= (expression.charAt(i)))
					|| ('A' <= (expression.charAt(i)) && 'Z' >= (expression.charAt(i)))) {

				throw new RuntimeException("lolololol");
			}

		}

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ' ')
				continue;
			if ( '0' <= expression.charAt(i) && expression.charAt(i) <= '9')  {
				
				
				while(i<expression.length()
						&&'0' <= expression.charAt(i) && expression.charAt(i) <= '9'){
					str+=expression.charAt(i);
					i++;
				}
				
				i--;
				stack.push(Double.parseDouble (str));
				str="";
			} else if (expression.charAt(i) == '*') {
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand2 = (double) stack.pop();
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand1 = (double) stack.pop();
				stack.push((double) operand1 * operand2);
			} else if (expression.charAt(i) == '+') {
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand2 = (double) stack.pop();
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand1 = (double) stack.pop();
				stack.push((double) operand1 + operand2);
			} else if (expression.charAt(i) == '-') {
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand2 = (double) stack.pop();
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand1 = (double) stack.pop();
				stack.push((double) operand1 - operand2);
			} else if (expression.charAt(i) == '/') {
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand2 = (double) stack.pop();
				if (stack.isEmpty())
					throw new RuntimeException();
				else
					operand1 = (double) stack.pop();
				if (operand2 == 0)
					throw new RuntimeException();
				else if (operand1 == 0)
					stack.push(0);
				else
					stack.push((double) operand1 / operand2);
			}

		}
		if (stack.isEmpty())
			throw new RuntimeException();

		return (int) (double) stack.pop();

	}

	public static void main(String[] args) {
		IExpressionEvaluator app = new ExpressionEvaluator();
		String str = " 9 +10 /5+32";
		String sol = app.infixToPostfix(str);
		 int ans=app.evaluate(sol);
		System.out.println(sol);

		 System.out.println(ans);
	}
}