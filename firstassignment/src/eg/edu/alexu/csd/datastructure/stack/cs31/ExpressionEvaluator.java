package eg.edu.alexu.csd.datastructure.stack.cs31;
	import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
	import eg.edu.alexu.csd.datastructure.stack.IStack;
	public class ExpressionEvaluator implements IExpressionEvaluator {
	
		 static IStack stack =new Stack();
		@Override
		public String infixToPostfix(String expression) throws RuntimeException {
			// TODO Auto-generated method stub
			if (expression==null){
			   throw new RuntimeException("bbb");
				
			}
			String str = new String();
			
          for (int i=0;i<expression.length();i++){
				
				if (!(expression.charAt(i)=='('
						//&& expression.charAt(i)!=' '
						|| expression.charAt(i)=='*'
						|| expression.charAt(i)== '+'
						|| expression.charAt(i)=='-'
						|| expression.charAt(i)=='/'
					    || expression.charAt(i)==')'		
						||('0'>(expression.charAt(i))
						&&'9'<(expression.charAt(i))))){
			    
			      throw new RuntimeException("aaaa");
			    
				}
				
          }
          boolean flag=true;
			for (int i=0;i<expression.length()-1&&flag;i++){
				flag=false;
				
				if (expression.charAt(i)!='('
						&& expression.charAt(i)!='*'
						&& expression.charAt(i)!= '+'
						&& expression.charAt(i)!='-'
						&& expression.charAt(i)!='/'
					    && expression.charAt(i)!=')'){
					
				/*	if (expression.charAt(i+1)!='('
							&& expression.charAt(i+1)!='*'
							&& expression.charAt(i+1)!= '+'
							&& expression.charAt(i+1)!='-'
							&& expression.charAt(i+1)!='/'
						    && expression.charAt(i+1)!=')'){*/
						flag=true;
						
					
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
			if (flag)
				 throw new RuntimeException("kkkk");
				
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
			
				while (/*(char)stack.peek()!='('&& */!stack.isEmpty())
				str+=stack.pop();
		
			return str;
		}

		@Override
		public int evaluate(String expression) {
			// TODO Auto-generated method stub
			if (expression==null){
				 throw new RuntimeException("111111");
			}
			for (int i=0;i<expression.length();i++){
				if (expression.charAt(i)!='('
						//&& expression.charAt(i)!=' '
						|| expression.charAt(i)!='*'
						|| expression.charAt(i)!= '+'
						|| expression.charAt(i)!='-'
						|| expression.charAt(i)!='/'
					    || expression.charAt(i)!=')'		
						||'0'>(expression.charAt(i))
						||'9'<(expression.charAt(i))){
			    
			      throw new RuntimeException("lolololol");
			}
			}
			for (int i=0;i<expression.length();i++){
				if (expression.charAt(i)!='('
						&& expression.charAt(i)!='*'
						&& expression.charAt(i)!= '+'
						&& expression.charAt(i)!='-'
						&& expression.charAt(i)!='/'
					    && expression.charAt(i)!=')'){
					stack.push((double)expression.charAt(i));
				}
			}
			
			return 0;
		}
/*public static void main(String[]args){
	IExpressionEvaluator app=new ExpressionEvaluator();
	String str="4/5*3";
}*/
	}


