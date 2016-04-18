package eg.edu.alexu.csd.datastructure.stack.cs31;
	import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
	import eg.edu.alexu.csd.datastructure.stack.IStack;
	public class ExpressionEvaluator implements IExpressionEvaluator {
	
		 static IStack stack =new Stack();
		@Override
		public String infixToPostfix(String expression) throws RuntimeException {
			// TODO Auto-generated method stub
			String str = new String();
			boolean flag=true;
			if (expression==null){
			   throw new RuntimeException("bbb");
				
			}
			
			
          for (int i=0;i<expression.length();i++){
				
				if (expression.charAt(i)!='('
				
						&& expression.charAt(i)!='*'
						&& expression.charAt(i)!= '+'
						&& expression.charAt(i)!='-'
						&& expression.charAt(i)!='/'
					    && expression.charAt(i)!=')'		
						&&('0'>expression.charAt(i)
						||'9'<(expression.charAt(i)))){
					
			    
			      throw new RuntimeException("aaaa");
			    
				}
				
          }
          for (int i=0;i<expression.length()-1&&flag;i++){	
		  flag=false;
		         if ( expression.charAt(i)!='*'
					&& expression.charAt(i)!= '+'
					&& expression.charAt(i)!='-'
					&& expression.charAt(i)!='/')
	     flag=true;
          }
	if (flag) {
		 throw new RuntimeException("no operator");
	}
		
			
          
			for (int i=0;i<expression.length()-1;i++){
				//test all digits
				
				/*if ('0'<=expression.charAt(i)&&expression.charAt(i)<='9'
					&&'0'<=expression.charAt(i+1)&&expression.charAt(i+1)<='9')
				
					throw new RuntimeException("xxxxx");*/
				
			
				//test all symbols
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
						if (stack.isEmpty()||(!stack.isEmpty()&&(char)stack.peek()!='('))
							throw new RuntimeException("there is no (");
						stack.pop();
					}else if(expression.charAt(i)=='*'||expression.charAt(i)=='/'){
					    if(stack.isEmpty()){
					    	stack.push(expression.charAt(i));
					    }
						else if ((char)stack.peek()=='+'||(char)stack.peek()=='-'){
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
								||(char)stack.peek()=='/'
								||(char)stack.peek()=='+'
								||(char)stack.peek()=='-')){
							str+=stack.pop();
							str+=" ";
						}
						stack.push(expression.charAt(i));
					}else{
						str+=expression.charAt(i);
						str+=" ";
					}
					
				}
			
				while (!stack.isEmpty()){
					  if ((char)stack.peek()=='(')
						  throw new RuntimeException("'(' without a ')'");
				str+=stack.pop();
				}
		      
		        	
			return str;
		}

		@Override
		public int evaluate(String expression) {
			// TODO Auto-generated method stub
		   double operand1;
		   double operand2;
			if (expression==null){
				 throw new RuntimeException();
			}
			/*for (int i=0;i<expression.length();i++){
				if (!(expression.charAt(i)=='('
						//|| expression.charAt(i)!=' '
						|| expression.charAt(i)=='*'
						|| expression.charAt(i)== '+'
						|| expression.charAt(i)=='-'
						|| expression.charAt(i)=='/'
					    || expression.charAt(i)==')'		
						//||('0'<=(expression.charAt(i))
						/*&&'9'>=(expression.charAt(i))))){
			    
			 //     throw new RuntimeException("lolololol");
		//	}
	//	}*/
		
			for (int i=0;i<expression.length();i++){
				if (expression.charAt(i)!='('
						&& expression.charAt(i)!='*'
						&& expression.charAt(i)!= '+'
						&& expression.charAt(i)!='-'
						&& expression.charAt(i)!='/'
					    && expression.charAt(i)!=')'){
					stack.push((double)expression.charAt(i));
				}else if (expression.charAt(i)!='*'){
					 if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand2=(double)stack.pop();
					 if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand1=(double)stack.pop();
					stack.push(operand1*operand2);
				}else if (expression.charAt(i)!='+'){
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand2=(double)stack.pop();
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand1=(double)stack.pop();
					stack.push(operand1+operand2);
				}else if (expression.charAt(i)!='-'){
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand2=(double)stack.pop();
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand1=(double)stack.pop();
					stack.push(operand1-operand2);
				}else if (expression.charAt(i)!='/'){
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand2=(double)stack.pop();
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand1=(double)stack.pop();
					if (operand2==0)
						throw new RuntimeException();
					else if (operand1==0)
						stack.push(0);
					else stack.push(operand1/operand2);
				}
				
			}
			if (stack.isEmpty())
				 throw new RuntimeException();
			 else 
			return (int)stack.pop();
		}
public static void main(String[]args){
	IExpressionEvaluator app=new ExpressionEvaluator();
	String str="-12/345";
	String sol= app.infixToPostfix(str);
	//int ans=app.evaluate(sol);
	System.out.println(sol);
	//System.out.println(ans);
}
	}


