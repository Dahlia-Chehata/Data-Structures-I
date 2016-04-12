package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import java.awt.Point;



public class Polynomial_Solver implements IPolynomialSolver {

	static Singly_linkedlists A = new Singly_linkedlists();
	static Singly_linkedlists B = new Singly_linkedlists();
	static Singly_linkedlists C = new Singly_linkedlists();
	static Singly_linkedlists R = new Singly_linkedlists();
	Point[] array;
	

	@Override
	public void setPolynomial(char poly, int[][] terms) throws RuntimeException {
		// TODO Auto-generated method stub

		if (terms.length == 0)
			throw new RuntimeException();
		for(int counter = 0; counter < terms.length - 1; counter++)
		{
			if(terms[counter][1] < terms[counter + 1][1])
				throw new RuntimeException();
		}

		array = new Point[terms.length];

		for (int i = 0; i < terms.length; i++) {
			if (terms[i][1] < 0)
				throw new RuntimeException();

			array[i] = new Point(terms[i][0], terms[i][1]);

		}
		

		switch (poly) {
		case 'A': {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null)
					throw new RuntimeException();
				
				A.add(array[i]);
			}
		}
			;
			break;
		case 'B': {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null)
					throw new RuntimeException();

				
				B.add(array[i]);
			}
		}
			;
			break;
		case 'C': {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null)
					throw new RuntimeException();
				
				C.add(array[i]);
			}
		}
			;
			break;
		default:
			throw new RuntimeException();
		}

	}

	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub

		String message = new String();

		switch (poly) {
		case 'A':
			if (A.isEmpty())
				return null;     // throw exception
			for (int i = 0; i < A.size(); i++) {
				Point pt = new Point();
				pt = (Point) A.get(i);
				if (pt.x == 1)
					message += "+";
				else if (pt.x == -1)
					message += "-";
				else
					message += pt.x;
				if (pt.y != 0) {
					if (pt.y == 1)
						message += "x";
					else
						message += "x^" + pt.y;
				}
			}
			break;
		case 'B':
			if (B.isEmpty())
				return null;
			for (int i = 0; i < B.size(); i++) {
				Point pt = new Point();
				pt = (Point) B.get(i);
				if (pt.x == 1)
					message += "+";
				else if (pt.x == -1)
					message += "-";
				else
					message += pt.x;
				if (pt.y != 0) {
					if (pt.y == 0)
						message += "x";
					else
						message += "x^" + pt.y;
				}
			}
			break;
		case 'C':
			if (C.isEmpty())
				return null;
			for (int i = 0; i < C.size(); i++) {
				Point pt = new Point();
				pt = (Point) C.get(i);
				if (pt.x == 1)
					message += "+";
				else if (pt.x == -1)
					message += "-";
				else
					message += pt.x;
				if (pt.y != 0) {
					if (pt.y == 0)
						message += "x";
					else
						message += "x^" + pt.y;
				}
			}
			break;
		case 'R':
			if (R.isEmpty())
				return null;
			for (int i = 0; i < R.size(); i++) {
				Point pt = new Point();
				pt = (Point) R.get(i);
				if (pt.x == 1)
					message += "+";
				else if (pt.x == -1)
					message += "-";
				else
					message += pt.x;
				if (pt.y != 0) {
					if (pt.y == 0)
						message += "x";
					else
						message += "x^" + pt.y;
				}
			}
			break;

		default:
			throw new RuntimeException();
		}
		return message;

	}

	@Override
	public void clearPolynomial(char poly) throws RuntimeException {
		// TODO Auto-generated method stub
		switch (poly) {
		case 'A': {
			if (A.isEmpty())
				throw new RuntimeException();
			A.clear();
			break;
		}
		case 'B': {
			if (B.isEmpty())
				throw new RuntimeException();
			B.clear();
			break;
		}
		case 'C': {
			if (C.isEmpty())
				throw new RuntimeException();
			C.clear();
			break;
		}
		case 'R': {
			if (R.isEmpty())
				throw new RuntimeException();
			R.clear();
			break;
		}

		default:
			throw new RuntimeException("invalid input or operation");

		}
	}

	@Override
	public float evaluatePolynomial(char poly, float value) throws RuntimeException {
		// TODO Auto-generated method stub

		float result = 0;
		switch (poly) {
		case 'A':
			if (!A.isEmpty()) {
				for (int i = 0; i < A.size; i++) {
					Point point = new Point();
					point=(Point) A.get(i);
					result += point.getX() * Math.pow(value, point.getY());
				}
			} else
				throw new RuntimeException();
			break;
		case 'B':
			if (!B.isEmpty()) {
				for (int i = 0; i < B.size(); i++) {
					Point point = new Point();
					point=(Point) B.get(i);
					result += point.getX() * Math.pow(value, point.getY());
				}
			}

			else
				throw new RuntimeException();

			break;
		case 'C':
			if (!C.isEmpty()) {
				for (int i = 0; i < C.size(); i++) {
					Point point = new Point();
					point=(Point) C.get(i);
					result += point.getX() * Math.pow(value, point.getY());
				}
			} else
				throw new RuntimeException();
			break;
		case 'R':
			if (!R.isEmpty()) {
				for (int i = 0; i < R.size(); i++) {
					Point point = new Point();
					point=(Point) R.get(i);
					result += point.getX() * Math.pow(value, point.getY());
				}
			} else
				throw new RuntimeException();
			break;
		default:
			throw new RuntimeException("invalid input or operation");
		}

		return result;

	}

	
	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		clearPolynomial('R');
		Singly_linkedlists first = new Singly_linkedlists();
		Singly_linkedlists second = new Singly_linkedlists();
      
		switch(poly1)
		{
		case 'A':
			first = A;
			break;
		case 'B':
			first = B;
			break;
		case 'C':
			first = C;
			break;
			default :throw new RuntimeException();
		}
		switch(poly2)
		{
		case 'A':
			second = A;
			break;
		case 'B':
			second = B;
			break;
		case 'C':
			second = C;
			break;
		default :throw new RuntimeException();

		}
		int[] array = new int[1000];
		for (int i= 0; i < first.size; i++) {
			int exp =  ((Point) (first.get(i))).y;
			int coef =((Point) (first.get(i))).x;
			array[exp] += coef;
		}
		for (int i= 0; i < second.size; i++) {
			int exp =  ((Point) (second.get(i))).y;
			int coef =  ((Point) (second.get(i))).x;
			array[exp] += coef;
		}
		for (int i=0;i< array.length;i++){
			if (array[i]!=0){
			Point result=new Point ();
			result.setLocation(i,array[i]);
			     R.add(result);
		}
	}
	
			int[][] array1 = new int[R.size()][2];
			for (int i =0;i<R.size();i++) {
				Point pt=new Point();
				pt= (Point)R.get(i);
				array1[i][0] = pt.x;
				array1[i][1] = pt.y;
			}
			
			return array1;
			
		
	}

	
	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		clearPolynomial('R');
		Singly_linkedlists first = new Singly_linkedlists();
		Singly_linkedlists second = new Singly_linkedlists();
		switch(poly1)
		{
		case 'A':
			first = A;
			break;
		case 'B':
			first = B;
			break;
		case 'C':
			first = C;
			break;
			default :throw new RuntimeException();
		}
		switch(poly2)
		{
		case 'A':
			second = A;
			break;
		case 'B':
			second = B;
			break;
		case 'C':
			second = C;
			break;
		default :throw new RuntimeException();

		}
		int[] array = new int[1000];
		for (int i= 0; i < first.size; i++) {
			int exp =  ((Point) (first.get(i))).y;
			int coef =((Point) (first.get(i))).x;
			array[exp] -= coef;
		}
		for (int i= 0; i < second.size; i++) {
			int exp =  ((Point) (second.get(i))).y;
			int coef =  ((Point) (second.get(i))).x;
			array[exp] -= coef;
		}
		for (int i=0;i< array.length;i++){
			if (array[i]!=0){
			Point result=new Point ();
			result.setLocation(i,array[i]);
			     R.add(result);
		}
	}
	
			int[][] array1 = new int[R.size()][2];
			for (int i =0;i<R.size();i++) {
				Point pt=new Point();
				pt= (Point)R.get(i);
				array1[i][0] = pt.x;
				array1[i][1] = pt.y;
			}
			
			return array1;
			
		
	}
	

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		clearPolynomial('R');
		Singly_linkedlists first = new Singly_linkedlists();
		Singly_linkedlists second = new Singly_linkedlists();
		switch(poly1)
		{
		case 'A':
			first = A;
			break;
		case 'B':
			first = B;
			break;
		case 'C':
			first = C;
			break;
			default :throw new RuntimeException();
		}
		switch(poly2)
		{
		case 'A':
			second = A;
			break;
		case 'B':
			second = B;
			break;
		case 'C':
			second = C;
			break;
		default :throw new RuntimeException();

		}
		Point pta=new Point();
	     Point ptb=new Point();
			double[] array = new double[10000000];
			
			

				for (int a = 0; a < first.size(); a++) {
					for (int b = 0; b < second.size(); b++) {
						pta= (Point)first.get(a);
						ptb= (Point)second.get(b);
						array[pta.y + ptb.y] += pta.getX() * ptb.getX();
					}
				} 
				
				for (int i=0;i< array.length;i++){
					if (array[i]!=0){
					Point result=new Point ();
					result.setLocation(i,array[i]);
					     R.add(result);
				}
			}
			
					int[][] array1 = new int[R.size()][2];
					for (int i =0;i<R.size();i++) {
						Point pt=new Point();
						pt= (Point)R.get(i);
						array1[i][0] = pt.x;
						array1[i][1] = pt.y;
					}
					
					return array1;
					
	}

	public static void main(String[] args) {
		// Singly_linkedlists A =new Singly_linkedlists() ;
		int[][] terms = { { 2, 3 }, { 4, 2 }, { 5, 4 } };
		IPolynomialSolver app = new Polynomial_Solver();
		app.setPolynomial('A', terms);
		for (int i = 0; i < A.size(); i++) {
			// Point pt= new Point ();
			// pt = (Point)(A.get(i));
			System.out.print(A.get(i) + " ");
			app.print('A');
		}
		System.out.println();
	}
}
/*
/*int arr[][];


Point pta = new Point();
Point ptb = new Point();
 
	int a = 0;
	int b = 0;

	boolean finishedA = false;
	boolean finishedB = false;

	while (!finishedA && !finishedB) {
			pta=(Point) first.get(a);
			ptb=(Point) second.get(b);

		if (pta.y > ptb.y) {
			R.add(pta);
			a++;
		} 
		else if (ptb.y > pta.y) {
			R.add(ptb);
			b++;
		} else {
			Point result = new Point();
			result.setLocation(pta.getX() +  ptb.getY(), pta.y);
			R.add(result);
		
			a++;
			b++;
		}
		if (a == first.size())
			finishedA = true;

		if (b == second.size())
			finishedB = true;

	}

	if (finishedA) {
		for (int i = b; i < second.size(); i++) {
			R.add((Point) second.get(i));
			
		}
	} else {
		for (int i = a; i < first.size(); i++) {
			R.add((Point) first.get(i));
			
		}
	}
	arr = new int[R.size()][2];
	for (int i = 0; i < R.size(); i++) {
		Point pt = new Point();
		pt=(Point) R.get(i);
		arr[i][0] = pt.x;
		arr[i][1] = pt.y;
	}
	
	
	return arr;*/