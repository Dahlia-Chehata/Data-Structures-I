package eg.edu.alexu.csd.datastructure.stack.cs31;
	import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
	import eg.edu.alexu.csd.datastructure.stack.IStack;
	public class ExpressionEvaluator implements IExpressionEvaluator {
	
		 IStack stack =new Stack();
		@Override
		public String infixToPostfix(String expression) {
			// TODO Auto-generated method stub
			String str = new String();
			String operand1 = new String();
			String operand2 = new String();
			boolean valid=true;
			for (int i=0;i<expression.length()-1;i++){
				
				if (expression.charAt(i)!='('
						&& expression.charAt(i)!='*'
						&& expression.charAt(i)!= '+'
						&& expression.charAt(i)!='-'
						&& expression.charAt(i)!='/'
					    && expression.charAt(i)!=')'		
						&&!('0'<=(expression.charAt(i))
						&&'9'>=(expression.charAt(i)))){
			      valid=false;
				}
				/*if (expression.charAt(i)!='('
						&& expression.charAt(i)!='*'
						&& expression.charAt(i)!= '+'
						&& expression.charAt(i)!='-'
						&& expression.charAt(i)!='/'
					    && expression.charAt(i)!=')'){
					
					if (expression.charAt(i+1)!='('
							&& expression.charAt(i+1)!='*'
							&& expression.charAt(i+1)!= '+'
							&& expression.charAt(i+1)!='-'
							&& expression.charAt(i+1)!='/'
						    && expression.charAt(i+1)!=')'){
						
						throw new RuntimeException();
					}
				}*/
				
				if((expression.charAt(i)!='('
						|| expression.charAt(i)=='*'
						|| expression.charAt(i)== '+'
						|| expression.charAt(i)=='-'
						|| expression.charAt(i)=='/')
						&& (expression.charAt(i+1)=='*'
						|| expression.charAt(i+1)== '+'
						|| expression.charAt(i+1)=='-'
						|| expression.charAt(i+1)=='/'
					    || expression.charAt(i+1)==')')){
						
				      valid=false;

					
				}
				   if (expression.charAt(i+1)==')'
						&& expression.charAt(i+1)=='('){
					
					      valid=false;
				}
				
			}if (!valid){
				throw new RuntimeException();
				}
			else{
				for (int i=0;i<expression.length();i++){
					if (expression.charAt(i)=='('){
						stack.push((Object)expression.charAt(i));
					}else if (expression.charAt(i)==')'){
						while ((char)stack.peek()!='('){
							str+=(char)stack.pop();
						}	
					}else if(expression.charAt(i)=='*'||expression.charAt(i)=='/'){
						if ((char)stack.peek()=='+'||(char)stack.peek()!='-'){
							stack.push(expression.charAt(i));
						}
					}else if(expression.charAt(i)=='+'||expression.charAt(i)=='-'){
						if ((char)stack.peek()=='*'
								||(char)stack.peek()!='/'
								||(char)stack.peek()!='+'
								||(char)stack.peek()!='-'){
							
						}
					}	
				}
			}
			return str;
		}

		@Override
		public int evaluate(String expression) {
			// TODO Auto-generated method stub
			return 0;
		}

	}


