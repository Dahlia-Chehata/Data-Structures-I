package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import  eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
public class Polynomial_Solver implements IPolynomialSolver {
     
   	ILinkedList A =new Singly_linkedlists();
     ILinkedList B =new Singly_linkedlists();
     ILinkedList C =new Singly_linkedlists();
     ILinkedList R =new Singly_linkedlists();

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub
		ILinkedList the_list =new Singly_linkedlists();
		switch (poly){
		case'A': the_list=A;break;
		case'B': the_list=B;break;
		case'C': the_list=C;break;
		}
		for (int i=0;i<terms.length;i++){
			for (int j=0;j<terms[0].length;j++){
				the_list.add(i);
				
			}
		}
	}

	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		return null;
	}

}
