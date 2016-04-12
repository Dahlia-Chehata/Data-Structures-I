package eg.edu.alexu.csd.datastructure.calculator.cs31;
import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
public class Calculator implements ICalculator {

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public float divide(int x, int y) {
		// TODO Auto-generated method stub
		if (y == 0) {
			System.out.println("error");
			return 0;}
		

		else if (y == x)
			return 1;
		else if (x < 0 && y < 0) {
			x = -x;
			y = -y;
			return (float)x / y;
		} 
		else if (x == 0)
			return 0;
		else
			return (float)x / y;
	}

}
