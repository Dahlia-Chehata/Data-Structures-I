package eg.edu.alexu.csd.datastructure.stack.cs31;
	import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
	import eg.edu.alexu.csd.datastructure.stack.IStack;
	public class ExpressionEvaluator implements IExpressionEvaluator {
	
		 IStack stack =new Stack();
		@Override
		public String infixToPostfix(String expression) throws RuntimeException {
			// TODO Auto-generated method stub
			if (expression==null){
			   throw new RuntimeException("ffff");
				
			}
			String str = new String();
			
          for (int i=0;i<expression.length();i++){
				
				if (expression.charAt(i)!='('
						&& expression.charAt(i)!='*'
						&& expression.charAt(i)!= '+'
						&& expression.charAt(i)!='-'
						&& expression.charAt(i)!='/'
					    && expression.charAt(i)!=')'		
						&&'0'>(expression.charAt(i))
						&&'9'<(expression.charAt(i))){
			    
			      throw new RuntimeException("aaaa");
			    
				}
          }
			for (int i=0;i<expression.length()-1;i++){
				
				
				if (expression.charAt(i)!='('
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
						
						throw new RuntimeException("kkkk");
					}
				}
				
				if((expression.charAt(i)=='('
						|| expression.charAt(i)=='*'
						|| expression.charAt(i)== '+'
						|| expression.charAt(i)=='-'
						|| expression.charAt(i)=='/')
						&& ( expression.charAt(i+1)=='*'
						|| expression.charAt(i+1)== '+'
						|| expression.charAt(i+1)=='-'
						|| expression.charAt(i+1)=='/'
					    || expression.charAt(i+1)==')')){
					
					throw new RuntimeException("oooo");
					
				}
				   if (expression.charAt(i+1)==')'
						&& expression.charAt(i+1)=='('){
					
					      throw new RuntimeException("ssss");
				}
			}

				for (int i=0;i<expression.length();i++){
					if (expression.charAt(i)=='('){
						stack.push(expression.charAt(i));
					}else if (expression.charAt(i)==')'){
						while (stack.size()!=0 &&(char)stack.peek()!='('){
							str+=stack.pop();
							str+=" ";
						}	
						stack.pop();
					}else if(expression.charAt(i)=='*'||expression.charAt(i)=='/'){
						if ((char)stack.peek()=='+'||(char)stack.peek()!='-'){
							stack.push(expression.charAt(i));
						}
						else {
							while(stack.size()!=0
									&&((char)stack.peek()=='*'
									||(char)stack.peek()=='/')){
								str+=stack.pop();
								str+=" ";
							}
							stack.push(expression.charAt(i));
						}
					}else if(expression.charAt(i)=='+'||expression.charAt(i)=='-'){
						while (stack.size()!=0 
								&&((char)stack.peek()=='*'
								||(char)stack.peek()!='/'
								||(char)stack.peek()!='+'
								||(char)stack.peek()!='-')){
							str+=stack.pop();
							str+=" ";
						}
						stack.push(expression.charAt(i));
					}
				}
			
				while ((char)stack.peek()!='('&& !stack.isEmpty())
				str+=stack.pop();
		
			return str;
		}

		@Override
		public int evaluate(String expression) {
			// TODO Auto-generated method stub
			
			return 0;
		}

	}


