package eg.edu.alexu.csd.datastructure.calculator;

public class Mycalculator implements ICalculator {

	/**
	 * Adds given two numbers
	  
	 * @param x first number
	 * @param y second number
	 * @return sum of the two numbers
	 */
	public int add(int x, int y) {

		return x + y;
	}

	/**
	 * Divids two numbers
	
	 * @param x  first number
	 * @param y  second number
	 * @return the division result
	 */
	public float divide(int x, int y) {
		if (y == 0) {
			System.out.println("error");
			return 0;
		}

		else if (y == x)
			return 1;
		else if (x < 0 && y < 0) {
			x = -x;
			y = -y;
			return x / y;
		} 
		else if (x == 0)
			return 0;
		else
			return x / y;
	}

}
