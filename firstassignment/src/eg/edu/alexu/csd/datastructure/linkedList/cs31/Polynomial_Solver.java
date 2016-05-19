package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import java.awt.Point;
import java.util.Arrays;
/**.
 * ..
 */
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
/**.
 * @author Dell
 */
public class Polynomial_Solver implements IPolynomialSolver {
/**.
 * ;
 */
	private Singlylinkedlists aa = new Singlylinkedlists();
	/**.
	 * ;
	 */
	Singlylinkedlists bb = new Singlylinkedlists();
	/**.
	 * ;
	 */
	Singlylinkedlists cc = new Singlylinkedlists();
	/**.
	 * ;
	 */
	Singlylinkedlists rr = new Singlylinkedlists();
	/**.
	 * ;;
	 */
	Point[] array;
	/**.
	 */
	 final int bignum2 = 1000;
/**.
 * ;
 */
	@Override
	public final void setPolynomial(final char poly, final int[][] terms) {
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
				aa.add(array[i]);
			}
			break;
		case 'B':
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					throw new RuntimeException();
				}
				bb.add(array[i]);
			}
			break;
		case 'C':
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					throw new RuntimeException();
				}
				cc.add(array[i]);
			}
			break;
		default:
			throw new RuntimeException();
		}
	}
	/**.
	 * ;
	 */
	@Override
	public final String print(final char poly) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		String message = new String();
		switch (poly) {
		case 'A':
			if (aa.isEmpty()) {
				return null; 
			} // throw exception
			for (int i = 0; i < aa.size(); i++) {
				/**.
				 * \
				 */
				Point pt = new Point();
				pt = (Point) aa.get(i);
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
		case 'B':
			if (bb.isEmpty()) {
				return null;
			}
			for (int i = 0; i < bb.size(); i++) {
				/**.
				 * .
				 */
				Point pt = new Point();
				pt = (Point) bb.get(i);
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
			if (cc.isEmpty()) {
				return null;
			}
			for (int i = 0; i < cc.size(); i++) {
				Point pt = new Point();
				pt = (Point) cc.get(i);
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
		case 'R':
			if (rr.isEmpty()) {
				return null;
			}
			for (int i = 0; i < rr.size(); i++) {
				/**.
				 * ;
				 */
				Point pt = new Point();
				pt = (Point) rr.get(i);
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
		default:
			throw new RuntimeException();
		}
		System.out.println(message);
		return message;
	}
	/**.
	 * .
	 */
	@Override
	public final void clearPolynomial(final char poly) {
		// TODO Auto-generated method stub
		switch (poly) {
		case 'A':
			if (aa.isEmpty()) {
				throw new RuntimeException();
			}
			aa.clear();
			break;
		case 'B':
			if (bb.isEmpty()) {
				throw new RuntimeException();
			}
			bb.clear();
			break;
		case 'C':
			if (cc.isEmpty()) {
				throw new RuntimeException();
			}
			cc.clear();
			break;
		case 'R': 
			if (rr.isEmpty()) {
				throw new RuntimeException();
			}
			rr.clear();
			break;
		default:
			throw new RuntimeException("invalid input");
		}
	}
	/**.
	 * '
	 */
	@Override
	public final float evaluatePolynomial(final char poly,
			final float value) {
		// TODO Auto-generated method stub
		/**.
		 * ;
		 */
		float result = 0;
		switch (poly) {
		case 'A':
			if (!aa.isEmpty()) {
				for (int i = 0; i < aa.size; i++) {
					/**.
					 * ;
					 */
					Point point = new Point();
					point = (Point) aa.get(i);
					/**.
					 * ;
					 */
					double y = point.getY();
					/**.
					 * ;
					 */
					double x = point.getX();
					result += x * Math.pow(value, y);
				}
				System.out.println(result);
			} else {
				throw new RuntimeException();
			}
			break;
		case 'B':
			if (!bb.isEmpty()) {
				for (int i = 0; i < bb.size(); i++) {
					/**.
					 * ;
					 */
					Point point = new Point();
					point = (Point) bb.get(i);
					/**.
					 * ;
					 */
					double y = point.getY();
					/**.
					 * ;
					 */
					double x = point.getX();
					result += x * Math.pow(value, y);
				}
				System.out.println(result);
			} else {
				throw new RuntimeException();
			}
			break;
		case 'C':
			if (!cc.isEmpty()) {
				for (int i = 0; i < cc.size(); i++) {
					/**.
					 * ;
					 */
					Point point = new Point();
					point = (Point) cc.get(i);
					/**.
					 * '
					 */
					double y = point.getY();
					/**.
					 * '
					 */
					double x = point.getX();
					result += x * Math.pow(value, y);
				}
				System.out.println(result);
			} else {
				throw new RuntimeException();
			}
			break;
		case 'R':
			if (!rr.isEmpty()) {
				for (int i = 0; i < rr.size(); i++) {
					/**.
					 * .
					 */
					Point point = new Point();
					point = (Point) rr.get(i);
					/**.
					 * ;
					 */
					double y = point.getY();
					/**.
					 * ;
					 */
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
	/**.
	 * '
	 */
	@Override
	public final int[][] add(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		rr.clear();
		/**.
		 * '
		 */
		Singlylinkedlists first = new Singlylinkedlists();
		/**.
		 * '
		 */
		Singlylinkedlists second = new Singlylinkedlists();
		switch (poly1) {
		case 'A':
			if (aa.isEmpty()) {
				throw new RuntimeException();
			}
			first = aa;
			break;
		case 'B':
			if (bb.isEmpty()) {
				throw new RuntimeException();
			}
			first = bb;
			break;
		case 'C':
			if (cc.isEmpty()) {
				throw new RuntimeException();
			}
			first = cc;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			if (aa.isEmpty()) {
				throw new RuntimeException();
			}
			second = aa;
			break;
		case 'B':
			if (bb.isEmpty()) {
				throw new RuntimeException();
			}
			second = bb;
			break;
		case 'C':
			if (cc.isEmpty()) {
				throw new RuntimeException();
			}
			second = cc;
			break;
		default:
			throw new RuntimeException();
		}
		/**.
		 * ;
		 */
		final int numbb = 10000;
		/**.
		 * '
		 */
		int[] arrayy = new int[numbb];
		for (int i = 0; i < first.size; i++) {
			/**.
			 * '
			 */
			int exp = ((Point) (first.get(i))).y;
			/**.
			 * ;
			 */
			int coef = ((Point) (first.get(i))).x;
			arrayy[exp] += coef;
		}
		for (int i = 0; i < second.size; i++) {
			/**.
			 * ;
			 */
			int exp = ((Point) (second.get(i))).y;
			/**.
			 * ;
			 */
			int coef = ((Point) (second.get(i))).x;
			arrayy[exp] += coef;
		}
		/**.
		 * ;
		 */
		int counter = 0;
		/**.
		 * .
		 */
		int k = 0;
		/**.
		 * ;
		 */
		int[][] array1 = new int[bignum2][2];
		for (int i = 0; i < array.length; i++) {
			if (arrayy[i] != 0) {
				counter++;
				/**.
				 * ;
				 */
				Point result = new Point();
				result.setLocation(arrayy[i], i);
				rr.add(result);
				array1[k][0] = arrayy[i];
				array1[k][1] = i;
				k++;
			}
		}
		if (counter == 0) {
			return new int[][] {{0, 0}};
		}
		/**.
		 * ;
		 */
		int[][] arr = Arrays.copyOfRange(array1, 0, counter);
/**.
 * '
 */
		int[][] arrr = new int[counter][2];
		/**.
		 * .
		 */
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
	/**.
	 * ;
	 */
	@Override
	public final int[][] subtract(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		rr.clear();
		/**.
		 * ;
		 */
		Singlylinkedlists first = new Singlylinkedlists();
		/**.
		 * '
		 */
		Singlylinkedlists second = new Singlylinkedlists();
		switch (poly1) {
		case 'A':
			if (aa.isEmpty()) {
				throw new RuntimeException();
			}
			first = aa;
			break;
		case 'B':
			if (bb.isEmpty()) {
				throw new RuntimeException();
			}
			first = bb;
			break;
		case 'C':
			if (cc.isEmpty()) {
				throw new RuntimeException();
			}
			first = cc;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			if (aa.isEmpty()) {
				throw new RuntimeException();
			}
			second = aa;
			break;
		case 'B':
			if (bb.isEmpty()) {
				throw new RuntimeException();
			}
			second = bb;
			break;
		case 'C':
			if (cc.isEmpty()) {
				throw new RuntimeException();
			}
			second = cc;
			break;
		default:
			throw new RuntimeException();
		}
		/**.
		 * .
		 */
		int[] arrtay = new int[bignum2];
		for (int i = 0; i < first.size; i++) {
			/**.
			 * '
			 */
			int exp = ((Point) (first.get(i))).y;
			/**.'
			 * .
			 */
			int coef = ((Point) (first.get(i))).x;
			arrtay[exp] += coef;
		}
		for (int i = 0; i < second.size; i++) {
			/**.
			 * '
			 */
			int exp = ((Point) (second.get(i))).y;
			/**.
			 * ;
			 */
			int coef = ((Point) (second.get(i))).x;
			arrtay[exp] -= coef;
		}
		/**.
		 * ;
		 */
		int[][] array1 = new int[bignum2][2];
		/**.
		 * ';
		 */
		int counter = 0;
		/**.
		 * ;
		 */
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (arrtay[i] != 0) {
				counter++;
				/**.
				 * ;
				 */
				Point result = new Point();
				result.setLocation(arrtay[i], i);
				rr.add(result);
				array1[k][0] = arrtay[i];
				array1[k][1] = i;
				k++;
			}
		}
		if (counter == 0) {
			return new int[][] {{0, 0}};
		}
		/**.
		 * ;
		 */
		int[][] arr = Arrays.copyOfRange(array1, 0, counter);
		/**.
		 * '
		 */
		int[][] arrr = new int[counter][2];
		/**.
		 * '
		 */
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
	/**.
	 * ;
	 */
	@Override
	public final int[][] multiply(final char poly1,
			final char poly2) {
		// TODO Auto-generated method stub
		rr.clear();
		/**.
		 * '
		 */
		Singlylinkedlists first = new Singlylinkedlists();
		/**.
		 * ;
		 */
		Singlylinkedlists second = new Singlylinkedlists();
		switch (poly1) {
		case 'A':
			if (aa.isEmpty()) {
				throw new RuntimeException();
			}
			first = aa;
			break;
		case 'B':
			if (bb.isEmpty()) {
				throw new RuntimeException();
			}
			first = bb;
			break;
		case 'C':
			if (cc.isEmpty()) {
				throw new RuntimeException();
			}
			first = cc;
			break;
		default:
			throw new RuntimeException();
		}
		switch (poly2) {
		case 'A':
			if (aa.isEmpty()) {
				throw new RuntimeException();
			}
			second = aa;
			break;
		case 'B':
			if (bb.isEmpty()) {
				throw new RuntimeException();
			}
			second = bb;
			break;
		case 'C':
			if (cc.isEmpty()) {
				throw new RuntimeException();
			}
			second = cc;
			break;
		default:
			throw new RuntimeException();
		}
		/**.
		 * '
		 */
		final int bignum = 10000000;
		/**.
		 * ;
		 */
		Point pta = new Point();
		/**.
		 * ;
		 */
		Point ptb = new Point();
		/**.
		 * .
		 */
		double[] ar = new double[bignum];
		for (int a = 0; a < first.size(); a++) {
			for (int b = 0; b < second.size(); b++) {
				pta = (Point) first.get(a);
				ptb = (Point) second.get(b);
				ar[pta.y + ptb.y] += pta.getX() * ptb.getX();
			}
		}
		/**.
		 * ;
		 */
		int[][] array1 = new int[bignum2][2];
		/**.
		 * ;
		 */
		int counter = 0;
		/**.4
		 * 
		 */
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (ar[i] != 0) {
				counter++;
				/**.
				 * ;
				 */
				Point result = new Point();
				result.setLocation(ar[i], i);
				rr.add(result);
				array1[k][0] = (int) ar[i];
				array1[k][1] = i;
				k++;
			}
		}
		if (counter == 0) {
			return new int[][] {{0, 0}};
		}
		/**.
		 * '
		 */
		int[][] arr = Arrays.copyOfRange(array1, 0, counter);
		/**.
		 * ;
		 */
		int[][] arrr = new int[counter][2];
		/**.
		 *;
		 */
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
}
