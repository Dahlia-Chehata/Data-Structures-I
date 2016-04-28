package eg.edu.alexu.csd.datastructure.stack.cs31;

import java.util.Scanner;

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
		if (expression.charAt(expression.length() - 1) == '/' 
				|| expression.charAt(expression.length() - 1) == '*' 
				|| expression.charAt(expression.length() - 1) == '+'
				|| expression.charAt(expression.length() - 1) == '-')
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
		if (expression == null) {
			throw new RuntimeException();
		}
		if (expression.charAt(0) == '/' || expression.charAt(0) == '*' || expression.charAt(0) == '+'
				|| expression.charAt(0) == '-')
			throw new RuntimeException("starting with operator");
		if (expression.charAt(expression.length() - 1) == '/' 
				|| expression.charAt(expression.length() - 1) == '*' 
				|| expression.charAt(expression.length() - 1) == '+'
				|| expression.charAt(expression.length() - 1) == '-')
			throw new RuntimeException("starting with operator");
		double operand1 = 0;
		double operand2 = 0;
		String str=new String();

		
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
		
		Scanner scan = new Scanner(System.in);
		String input=new String();
		String conv=new String();
		int choice;
		char ch;
	/*	String str = " 9 +10 /(5+32)";
		String sol = app.infixToPostfix(str);
		 int ans=app.evaluate(sol);
		System.out.println(sol);

		 System.out.println(ans);*/
		do{
			System.out.println("      options");
			System.out.println("-----------------------------");
			System.out.println("1- insert an expression");
			System.out.println("2-infix to postfix conversion");
			System.out.println("3-evaluate expression");
			System.out.println("------------------------------");
			choice=scan.nextInt();
			switch(choice){
		case 1:
			input=scan.next(); break;
		case 2:
			while(input==""){
				System.out.println("you should insert an expression");
				input=scan.next();
			}
				if (input.charAt(0) == '/' || input.charAt(0) == '*' || input.charAt(0) == '+'
						|| input.charAt(0) == '-')
					System.out.println("starting with operator");
			conv=app.infixToPostfix(input);
			System.out.println(conv);
			break;
		case 3:
			while(input==""){
				System.out.println("you should insert an expression");
				input=scan.next();
			}
			while(conv==""){
				System.out.println("you should convert infix expression to postfix:"
						+ " choose option 2");
				
			}	

			for (int i = 0; i < conv.length(); i++) {
				if (('a' <= (conv.charAt(i)) && 'z' >= (conv.charAt(i)))
						|| ('A' <= (conv.charAt(i)) && 'Z' >= (conv.charAt(i)))) {

					System.out.println("can't evaluate symbols");
					break;
				}

			}
			boolean flag=true;
			for (int i = 0; i < conv.length() &&flag; i++) {
				flag=false;
				if ('0' <= (conv.charAt(i)) && '9' >= (conv.charAt(i))
						||conv.charAt(i)== ' '||conv.charAt(i)=='*'
						||conv.charAt(i)=='/'||conv.charAt(i)=='+'
						||conv.charAt(i)=='-'){
						 
                 flag=true;
					
				}

			}
          if (flag)
			System.out.println(app.evaluate(conv));
			break;
			default:
			System.out.println("Wrong Entry ");
			
}
			System.out.println("========================================");
			System.out.println("\nDo you want to continue (Type y or anykey to terminate) \n");
			ch = scan.next().charAt(0);
			System.out.println("=======================================");
		}while(ch == 'Y' || ch == 'y');
		
	}
	
	
}