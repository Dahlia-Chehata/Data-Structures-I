package eg.edu.alexu.csd.datastructure.linkedList.cs31;

import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class Polynomial_Solver implements IPolynomialSolver {

	Singly_linkedlists A = new Singly_linkedlists();
	Singly_linkedlists B = new Singly_linkedlists();
	Singly_linkedlists C = new Singly_linkedlists();
	Singly_linkedlists R = new Singly_linkedlists();
	Point[] array;
	 final int bignum2=1000;

	@Override
	public void setPolynomial(char poly, int[][] terms) 
	  throws RuntimeException {
		// TODO Auto-generated method stub
		if (terms.length == 0) {
			throw new RuntimeException();
		}
		for (int counter = 0; counter < terms.length - 1; counter++) {
			if (terms[counter][1] < terms[counter + 1][1]) {
				throw new RuntimeException();
			}
		}
		array = new Point[terms.length];
		for (int i = 0; i < terms.length; i++) {
			if (terms[i][1] < 0) {
				throw new RuntimeException();
			}
			array[i] = new Point(terms[i][0], terms[i][1]);
		}
		switch (poly) {
		case 'A':
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					throw new RuntimeException();
				}
				A.add(array[i]);
			};
			break;
		case 'B':
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					throw new RuntimeException();
				}
				B.add(array[i]);
			}
			;
			break;
		case 'C':
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					throw new RuntimeException();
				}

				C.add(array[i]);
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
			if (A.isEmpty()) {
				return null; 
			}// throw exception
			for (int i = 0; i < A.size(); i++) {
				Point pt = new Point();
				pt = (Point) A.get(i);
				if (pt.x == 1) {
					message += "+";
				}else if (pt.x == -1) {
					message += "";
				}else {
					message += pt.x;
				}
				if (pt.y != 0) {
					if (pt.y == 1) {
						message += "x";
					}
					else {
						message += "x^" + pt.y;
					}
				} else {
					message += pt.x;
				}
			}
			// System.out.println(message);
			break;
		case 'B':
			if (B.isEmpty()) {
				return null;
			}
			for (int i = 0; i < B.size(); i++) {
				Point pt = new Point();
				pt = (Point) B.get(i);
				if (pt.x == 1) {
					message += "+";
				} else if (pt.x == -1) {
					message += "";
				} else {
					message += pt.x;
				}
				if (pt.y != 0) {
					if (pt.y == 1) {
						message += "x";
					} else {
						message += "x^" + pt.y;
					}
				} else {
					message += pt.x;
				}
			}	
			// System.out.println(message);
			break;
		case 'C':
			if (C.isEmpty()) {
				return null;
			}
			for (int i = 0; i < C.size(); i++) {
				Point pt = new Point();
				pt = (Point) C.get(i);
				if (pt.x == 1) {
					message += "+";
				}
				else if (pt.x == -1) {
					message += "";
				}
				else {
					message += pt.x;
				}
				if (pt.y != 0) {
					if (pt.y == 1) {
						message += "x";
					}
					else {
						message += "x^" + pt.y;
					}
				} else {
					message += pt.x;
				}
			}
			// System.out.println(message);
			break;
		case 'R':
			if (R.isEmpty()) {
				return null;
			}
			for (int i = 0; i < R.size(); i++) {
				Point pt = new Point();
				pt = (Point) R.get(i);
				if (pt.x == 1){
					message += "+";
				}
				else if (pt.x == -1){
					message += "";
				}
				else {
					message += pt.x;
				}
				if (pt.y != 0) {
					if (pt.y == 1) {
						message += "x";
					}
					else {
						message += "x^" + pt.y;
					}
				} else {
					message += pt.x;
				}
			}
			// System.out.println(message);
			break;
		default:
			throw new RuntimeException();
		}
		System.out.println(message);
		return message;
	}
	@Override
	public void clearPolynomial(char poly) throws RuntimeException {
		// TODO Auto-generated method stub
		switch (poly) {
		case 'A':
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
			A.clear();
			break;
		case 'B':
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
			B.clear();
			break;
		case 'C':
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
			C.clear();
			break;
		case 'R': 
			if (R.isEmpty()) {
				throw new RuntimeException();
			}
			R.clear();
			break;
		default:
			throw new RuntimeException("invalid input");
		}
	}
	@Override
	public float evaluatePolynomial(char poly, float value) 
			throws RuntimeException {
		// TODO Auto-generated method stub
		float result = 0;
		switch (poly) {
		case 'A':
			if (!A.isEmpty()) {
				for (int i = 0; i < A.size; i++) {
					Point point = new Point();
					point = (Point) A.get(i);
					double y = point.getY();
					double x = point.getX();
					result += x * Math.pow(value, y);
				}
				System.out.println(result);
			} else {
				throw new RuntimeException();
			}
			break;
		case 'B':
			if (!B.isEmpty()) {
				for (int i = 0; i < B.size(); i++) {
					Point point = new Point();
					point = (Point) B.get(i);
					double y = point.getY();
					double x = point.getX();
					result += x * Math.pow(value, y);
				}
				System.out.println(result);
			}

			else {
				throw new RuntimeException();
			}

			break;
		case 'C':
			if (!C.isEmpty()) {
				for (int i = 0; i < C.size(); i++) {
					Point point = new Point();
					point = (Point) C.get(i);
					double y = point.getY();
					double x = point.getX();
					result += x * Math.pow(value, y);
				}
				System.out.println(result);
			} else {
				throw new RuntimeException();
			}
			break;
		case 'R':
			if (!R.isEmpty()) {
				for (int i = 0; i < R.size(); i++) {
					Point point = new Point();
					point = (Point) R.get(i);
					double y = point.getY();
					double x = point.getX();
					result += x * Math.pow(value, y);
				}
				System.out.println(result);
			} else {
				throw new RuntimeException();
			}
			break;
		default:
			throw new RuntimeException("invalid input");
		}
		return result;
	}
	@Override
	public int[][] add(char poly1, char poly2) throws RuntimeException {
		// TODO Auto-generated method stub
		R.clear();
		Singly_linkedlists first = new Singly_linkedlists();
		Singly_linkedlists second = new Singly_linkedlists();
		switch (poly1) {
		case 'A':
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
			first = A;
			break;
		case 'B':
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
			first = B;
			break;
		case 'C':
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
			first = C;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
			second = A;
			break;
		case 'B':
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
			second = B;
			break;
		case 'C':
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
			second = C;
			break;
		default:
			throw new RuntimeException();
		}
		final int numbb=10000;
		int[] array = new int[numbb];
		for (int i = 0; i < first.size; i++) {
			int exp = ((Point) (first.get(i))).y;
			int coef = ((Point) (first.get(i))).x;
			array[exp] += coef;
		}
		for (int i = 0; i < second.size; i++) {
			int exp = ((Point) (second.get(i))).y;
			int coef = ((Point) (second.get(i))).x;
			array[exp] += coef;
		}
		int counter = 0;
		int k = 0;
		int[][] array1 = new int[bignum2][2];
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				counter++;
				Point result = new Point();
				result.setLocation(array[i], i);
				R.add(result);
				array1[k][0] = array[i];
				array1[k][1] = i;
				k++;
			}
		}
		if (counter == 0) {
			return new int[][] { { 0, 0 } };
		}
		int[][] arr = Arrays.copyOfRange(array1, 0, counter);

		int[][] arrr = new int[counter][2];
		int count = counter - 1;
		for (int j = 0; j < counter; j++) {
			arrr[count][0] = arr[j][0];
			System.out.print("(" + arrr[count][0] + ",");
			arrr[count][1] = arr[j][1];
			System.out.println(arrr[count][1] + "),");
			count--;
		}
		return arrr;
	}
	@Override
	public int[][] subtract(char poly1, char poly2) 
			throws RuntimeException {
		// TODO Auto-generated method stub
		R.clear();
		Singly_linkedlists first = new Singly_linkedlists();
		Singly_linkedlists second = new Singly_linkedlists();
		switch (poly1) {
		case 'A':
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
			first = A;
			break;
		case 'B':
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
			first = B;
			break;
		case 'C':
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
			first = C;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
			second = A;
			break;
		case 'B':
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
			second = B;
			break;
		case 'C':
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
			second = C;
			break;
		default:
			throw new RuntimeException();

		}
		int[] array = new int[bignum2];
		for (int i = 0; i < first.size; i++) {
			int exp = ((Point) (first.get(i))).y;
			int coef = ((Point) (first.get(i))).x;
			array[exp] += coef;
		}
		for (int i = 0; i < second.size; i++) {
			int exp = ((Point) (second.get(i))).y;
			int coef = ((Point) (second.get(i))).x;
			array[exp] -= coef;
		}
		int[][] array1 = new int[bignum2][2];
		int counter = 0;
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				counter++;
				Point result = new Point();
				result.setLocation(array[i], i);
				R.add(result);
				array1[k][0] = array[i];
				array1[k][1] = i;
				k++;
			}
		}
		if (counter == 0) {
			return new int[][] { { 0, 0 } };
		}
		int[][] arr = Arrays.copyOfRange(array1, 0, counter);
		int[][] arrr = new int[counter][2];
		int count = counter - 1;
		for (int j = 0; j < counter; j++) {
			arrr[count][0] = arr[j][0];
			System.out.print("(" + arrr[count][0] + ",");
			arrr[count][1] = arr[j][1];
			System.out.print(arrr[count][1] + "),");
			count--;
		}
		return arrr;
	}
	@Override
	public int[][] multiply(char poly1, char poly2) 
			throws RuntimeException {
		// TODO Auto-generated method stub
		R.clear();
		Singly_linkedlists first = new Singly_linkedlists();
		Singly_linkedlists second = new Singly_linkedlists();
		switch (poly1) {
		case 'A':
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
			first = A;
			break;
		case 'B':
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
			first = B;
			break;
		case 'C':
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
			first = C;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
			second = A;
			break;
		case 'B':
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
			second = B;
			break;
		case 'C':
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
			second = C;
			break;
		default:
			throw new RuntimeException();
		}
		final int bignum=10000000;
		Point pta = new Point();
		Point ptb = new Point();
		double[] array = new double[bignum];

		for (int a = 0; a < first.size(); a++) {
			for (int b = 0; b < second.size(); b++) {
				pta = (Point) first.get(a);
				ptb = (Point) second.get(b);
				array[pta.y + ptb.y] += pta.getX() * ptb.getX();
			}
		}
		int[][] array1 = new int[bignum2][2];
		int counter = 0;
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				counter++;
				Point result = new Point();
				result.setLocation(array[i], i);
				R.add(result);
				array1[k][0] = (int) array[i];
				array1[k][1] = i;
				k++;
			}
		}
		if (counter == 0) {
			return new int[][] { { 0, 0 } };
		}
		int[][] arr = Arrays.copyOfRange(array1, 0, counter);
		int[][] arrr = new int[counter][2];
		int count = counter - 1;
		for (int j = 0; j < counter; j++) {
			arrr[count][0] = arr[j][0];
			System.out.print("(" + arrr[count][0] + ",");
			arrr[count][1] = arr[j][1];
			System.out.print(arrr[count][1] + "),");
			count--;
		}

		return arrr;
	}
	