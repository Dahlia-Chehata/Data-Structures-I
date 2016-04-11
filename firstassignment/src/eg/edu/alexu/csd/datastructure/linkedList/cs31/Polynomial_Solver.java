package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import java.awt.Point;
import java.util.Comparator;
import java.util.Arrays;

class myComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub

		return o2.y - o1.y;

	}
}

public class Polynomial_Solver implements IPolynomialSolver {

	static Singly_linkedlists A = new Singly_linkedlists();
	static Singly_linkedlists B = new Singly_linkedlists();
	static Singly_linkedlists C = new Singly_linkedlists();
	static Singly_linkedlists R = new Singly_linkedlists();
	Point[] array;
	SLNode temp;

	@Override
	public void setPolynomial(char poly, int[][] terms) throws RuntimeException {
		// TODO Auto-generated method stub

		if (terms.length == 0)
			throw new RuntimeException();

		array = new Point[terms.length];

		for (int i = 0; i < terms.length; i++) {
			if (terms[i][1] < 0)
				throw new RuntimeException();

			array[i] = new Point(terms[i][0], terms[i][1]);

		}
		myComparator c = new myComparator();
		Arrays.sort(array, c);

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
				
				SLNode temp = new SLNode();
				temp.value = (Object) array[i];
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

	public int[][] determine_polyadd(char poly1, char poly2) {
		int arr[][];

		clearPolynomial('R');
		Point pta = new Point();
		Point ptb = new Point();
		if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A') {
			int a = 0;
			int b = 0;

			boolean finishedA = false;
			boolean finishedB = false;

			while (!finishedA && !finishedB) {
					pta=(Point) A.get(a);
					ptb=(Point) B.get(b);

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
				if (a == A.size())
					finishedA = true;

				if (b == B.size())
					finishedB = true;

			}

			if (finishedA) {
				for (int i = b; i < B.size(); i++) {
					R.add((Point) B.get(i));
					
				}
			} else {
				for (int i = a; i < A.size(); i++) {
					R.add((Point) A.get(i));
					
				}
			}
			arr = new int[R.size()][2];
			for (int i = 0; i < R.size(); i++) {
				Point pt = new Point();
				pt=(Point) R.get(i);
				arr[i][0] = pt.x;
				arr[i][1] = pt.y;
			}
			return arr;
		}

		if (poly1 == 'A' && poly2 == 'A') {
			int a = 0;
			boolean finishedA = false;
			while (!finishedA) {
				Point pt = new Point();
				Point result = new Point();
				pt=(Point) A.get(a);
				result.setLocation((pt.getX() * 2), pt.y);
				R.add(result);
				a++;

				if (a == A.size)
					finishedA = true;
			}

			arr = new int[R.size()][2];
			for (int i = 0; i < R.size(); i++) {
				Point pt = new Point();
				pt=(Point) R.get(i);
				arr[i][0] = pt.x;
				arr[i][1] = pt.y;
			}
			return arr;

		}
		if (poly1 == 'B' && poly2 == 'B') {
			int b = 0;
			boolean finishedB = false;
			while (!finishedB) {
				Point pt = new Point();
				Point result = new Point();
				pt=(Point) B.get(b);
				result.setLocation((pt.getX() * 2), pt.y);
				R.add(result);
				b++;
				if (b == B.size)
					finishedB = true;
			}

			arr = new int[R.size()][2];
			for (int i = 0; i < R.size(); i++) {
				Point pt = new Point();
				pt=(Point) R.get(i);
				arr[i][0] = pt.x;
				arr[i][1] = pt.y;
			}
			return arr;
		}
		return null;

	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int[][] add;
		if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A')
			add = determine_polyadd('A', 'B');
		else if (poly1 == 'A' && poly2 == 'C' || poly1 == 'C' && poly2 == 'A')
			add = determine_polyadd('A', 'C');
		else if (poly1 == 'B' && poly2 == 'C' || poly1 == 'C' && poly2 == 'B')
			add = determine_polyadd('B', 'C');
		else if (poly1 == 'A' && poly2 == 'A')
			add = determine_polyadd('A', 'A');
		else if (poly1 == 'B' && poly2 == 'B')
			add = determine_polyadd('B', 'B');
		else if (poly1 == 'C' && poly2 == 'C')
			add = determine_polyadd('C', 'C');
		else
			throw new RuntimeException("invalid input or operationbbbbb");

		return add;

	}

	public int[][] determine_polysub(char poly1, char poly2) {
		int[][] arr;
       Point pta=new Point();
       
       Point ptb=new Point();
		clearPolynomial('R');
		if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A') {
			int a = 0;
			int b = 0;
			
			pta= (Point)A.get(a);
			ptb= (Point)B.get(b);
			
			boolean finishedA = false;
			boolean finishedB = false;
			while (!finishedA && !finishedB) {
				
				if (pta.y > ptb.y) {
					R.add(pta);
					a++;
				} 
				
				else  if (pta.y<ptb.y) {
					R.add(ptb);
					b++;
				} else {
					Point result = new Point();
					result.setLocation(pta.getX() -  ptb.getY(), pta.y);
					R.add(result);
					a++;
					b++;
				}
				if (a == A.size()) {
					finishedB = true;
				}
				if (b == B.size()) {
					finishedA = true;
				}
			}
			if (finishedA) {
				for (int i = b; i < B.size(); i++) {
					R.add((Point) B.get(i));
					
				}
			} else {
				for (int i = a; i < A.size(); i++) {
					R.add((Point) A.get(i));
					
				}
			}
			arr = new int[R.size()][2];
			for (int i = 0; i < R.size(); i++) {
				Point pt = new Point();
				pt=(Point) R.get(i);
				arr[i][0] = pt.x;
				arr[i][1] = pt.y;
			}
			return arr;
		
		}

		return null;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int[][] sub;
		if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A')
			sub = determine_polysub('A', 'B');
		else if (poly1 == 'A' && poly2 == 'C' || poly1 == 'C' && poly2 == 'A')
			sub = determine_polysub('A', 'C');
		else if (poly1 == 'B' && poly2 == 'C' || poly1 == 'C' && poly2 == 'B')
			sub = determine_polysub('B', 'C');
		else if (poly1 == 'A' && poly2 == 'A' || poly1 == 'B' && poly2 == 'B' || poly1 == 'C' && poly2 == 'C') {
			sub = new int[1][2];
			sub[0][1] = 0;
			sub[1][1] = 0;

		} else
			throw new RuntimeException("invalid input or operation");

		return sub;

	}
	public int[][] multiplication(char poly1, char poly2) {
		clearPolynomial('R');
	     Point pta=new Point();
	     Point ptb=new Point();
			double[] array = new double[10000000];
			double[] arrind = new double[10000000];
	  int ind=1;
			

				for (int a = 0; a < A.size(); a++) {
					for (int b = 0; b < B.size(); b++) {
						pta= (Point)A.get(a);
						ptb= (Point)B.get(b);
						for (int k=0;k<ind;k++){
	            	    if (arrind[k]!=pta.y + ptb.y)
	            	    	arrind[ind++]=pta.y + ptb.y;
	               }
						array[pta.y + ptb.y] += pta.getX() * ptb.getX();
					}
				} 
				for (int i =0;i<ind-1;i++){
					Point result=new Point ();
					result.setLocation( arrind[i],array[i]);
					R.add(result);
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
		int arr[][];
		if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A') 
			arr=multiplication('A','B');
			else if (poly1 == 'A' && poly2 == 'C' || poly1 == 'C' && poly2 == 'A')
				arr=multiplication('A','C');
			else if (poly1 == 'B' && poly2 == 'C' || poly1 == 'C' && poly2 == 'B')
				arr=multiplication('B','C');
			else if (poly1 == 'B' && poly2 == 'B' )
				arr=multiplication('B','B');
			else if (poly1 == 'C' && poly2 == 'C' )
				arr=multiplication('C','C');
			else if (poly1 == 'A' && poly2 == 'A')
				arr=multiplication('A','A');
			else
				throw new RuntimeException("invalid input or operation");
		return arr;
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
