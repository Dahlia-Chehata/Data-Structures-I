package eg.edu.alexu.csd.datastructure.stack.cs31;
import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
import eg.edu.alexu.csd.datastructure.stack.IStack;
public class ExpressionEvaluator implements IExpressionEvaluator {

	 IStack stack =new Stack();
	@Override
	public String infixToPostfix(String expression) {
		// TODO Auto-generated method stub
		/*String str = new String();
		String operand1 = new String();
		String operand2 = new String();
		boolean valid;
		for (int i=0;i<expression.length()-1;i++){
			if (!((Character)expression.charAt(i)).equals("(")
					&&!((Character)expression.charAt(i)).equals("*")
					&&!((Character)expression.charAt(i)).equals("+")
					&&!((Character)expression.charAt(i)).equals("-")
					&&!((Character)expression.charAt(i)).equals("/")
					&&!((Character)expression.charAt(i)).equals(")")){
				if (!((Character)expression.charAt(i)).equals("(")
						&&!((Character)expression.charAt(i+1)).equals("*")
						&&!((Character)expression.charAt(i+1)).equals("+")
						&&!((Character)expression.charAt(i+1)).equals("-")
						&&!((Character)expression.charAt(i+1)).equals("/")
						&&!((Character)expression.charAt(i+1)).equals(")")){
					valid =false;
				}
			}
			
		}*/
		return null;
	}

	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
		return 0;
	}

}
