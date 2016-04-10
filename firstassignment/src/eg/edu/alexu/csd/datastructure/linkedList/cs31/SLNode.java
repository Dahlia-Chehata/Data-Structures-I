package eg.edu.alexu.csd.datastructure.linkedList.cs31;


public class SLNode {
	public Object value; 
	public SLNode next; 
	public Object exp;
	
	public SLNode (){
			value=null;
			next=null;
			exp=null;
			
	}
	public SLNode(Object coeff,Object exp){
		value=coeff;
		this.exp=exp;
	    next=null;
				
	}
}
