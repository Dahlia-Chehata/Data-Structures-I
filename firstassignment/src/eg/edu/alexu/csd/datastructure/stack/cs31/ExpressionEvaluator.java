package eg.edu.alexu.csd.datastructure.stack.cs31;
	import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
	import eg.edu.alexu.csd.datastructure.stack.IStack;
	public class ExpressionEvaluator implements IExpressionEvaluator {
	
		  IStack stack =new Stack();
		@Override
		public String infixToPostfix(String expression) throws RuntimeException {
			// TODO Auto-generated method stub
			String str = new String();
			boolean flag=true;
			if (expression==null){
			   throw new RuntimeException("bbb");
				
			}if (expression.charAt(0)=='/'
        		||expression.charAt(0)=='*'
        		||expression.charAt(0)=='+'
        		||expression.charAt(0)=='-')
				throw new RuntimeException("starting with operator");
			String[] split = expression.split("\\s+");
			
			
       /*   for (int i=0;i<split.length;i++){
        	  
				if (split[i]!="("
						&& split[i]!="*"
						&& split[i]!= "+"
						&& split[i]!="-"
						&& split[i]!="/"
					    && split[i]!=")"		
						){
					
			    
			      throw new RuntimeException("aaaa");
			    
				}
				
          }*/
         for (int i=0;i<split.length&&flag;i++){	
		  flag=false;
		         if ( !split[i].equals("*")
					&& !split[i].equals("+")
					&&!split[i].equals("-")
					&&!split[i].equals("/"))
	     flag=true;
          }
	if (flag) {
		 throw new RuntimeException("no operator");
	}
		
			
          
			for (int i=0;i<split.length-1;i++){
				
				//test all symbols
				if(
						( split[i].equals("*")
						|| split[i].equals("+") 
						|| split[i].equals("-")
						|| split[i].equals("/"))
						&& ( split[i+1].equals("*")
						|| split[i+1].equals("+")
						|| split[i+1].equals("-")
						|| split[i+1].equals("/")
					    )){
					
					throw new RuntimeException("oooo");
					
				}
				   if (split[i].equals(")")
						&& split[i+1].equals("(")){
					
					      throw new RuntimeException("ssss");
				}	
		}		
			

			
				for (int i=0;i<split.length;i++){
					if (split[i].equals("(")){
						stack.push(split[i]);
					}else if (split[i].equals(")")){
						
						while (!stack.isEmpty() && !((String)stack.peek()).equals("(")){
							
							str+=stack.pop();
							str+=" ";
							
							
						}	
						if (stack.isEmpty()||(!stack.isEmpty()
								&&!((String)stack.peek()).equals("(")))
							throw new RuntimeException("there is no (");
						stack.pop();
					}else if(split[i].equals("*")||split[i].equals("/")){
					    if(stack.isEmpty()
					    		||(!stack.isEmpty()
								&&((String)stack.peek()).equals("("))){
					    	stack.push(split[i]);
					    }
						else if (((String)stack.peek()).equals("+")
								||((String)stack.peek()).equals("-")){
							stack.push(split[i]);
						}
						else {
							while(stack.size()!=0
									&&(((String)stack.peek()).equals("*")
									||((String)stack.peek()).equals("/"))){
								str+=stack.pop();
								str+=" ";
							}
							stack.push(split[i]);
						}
					}else if(split[i].equals("+")||split[i].equals("-")){
						if(stack.isEmpty()
					    		||(!stack.isEmpty()
								&&((String)stack.peek()).equals("("))){
					    	stack.push(split[i]);
					    }
						else {
						while (stack.size()!=0 
								&&(((String)stack.peek()).equals("*")
										||((String)stack.peek()).equals("/")
										||((String)stack.peek()).equals("+")
										||((String)stack.peek()).equals("-"))){
							str+=stack.pop();
							str+=" ";
						}
						stack.push(split[i]);
						}
						
					}else{
						str+=split[i];
						str+=" ";
						
					}
					
				}
			
				while (!stack.isEmpty()){
					  if (((String)stack.peek()).equals("("))
						  throw new RuntimeException("'(' without a ')'");
				str+=stack.pop();
				}
		      
		        	
			return str;
		}

		@Override
		public int evaluate(String expression) {
			// TODO Auto-generated method stub
			if (expression==null){
				 throw new RuntimeException();
			}
			String[] split = expression.split("\\s+");
		  double operand1;
		   double operand2;
			
			/*for (int i=0;i<split.length();i++){
				if (!(split[i]=='('
						//|| split[i]!=' '
						|| split[i]=='*'
						|| split[i].equals()'+'
						|| split[i]=='-'
						|| split[i]=='/'
					    || split[i]==')'		
						//||('0'<=(split[i])
						/*&&'9'>=(split[i])))){
			    
			 //     throw new RuntimeException("lolololol");
		//	}
	//	}*/
		
			for (int i=0;i<split.length;i++){
				if (split[i]!="("
						&& split[i]!="*"
						&& split[i]!= "+"
						&& split[i]!="-"
						&& split[i]!="/"
					    && split[i]!=")"){
					stack.push(split[i]);
				}else if (split[i]!="*"){
					 if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand2=(double)stack.pop();
					 if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand1=(double)stack.pop();
					stack.push(operand1*operand2);
				}else if (split[i]!="+"){
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand2=(double)stack.pop();
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand1=(double)stack.pop();
					stack.push(operand1+operand2);
				}else if (split[i]!="-"){
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand2=(double)stack.pop();
					if (stack.isEmpty())
						 throw new RuntimeException();
					 else 
					operand1=(double)stack.pop();
					stack.push(operand1-operand2);
				}else if (split[i]!="/"){
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
	String str="( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )";
	String sol= app.infixToPostfix(str);
	//int ans=app.evaluate(sol);
	System.out.println(sol);
	//System.out.println(ans);
}
	}


