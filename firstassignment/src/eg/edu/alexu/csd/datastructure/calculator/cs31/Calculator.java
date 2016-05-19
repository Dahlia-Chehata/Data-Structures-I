package eg.edu.alexu.csd.datastructure.calculator.cs31;
import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**.
 * @author Dell
 */
public class Calculator implements ICalculator {
/**.
 * ;
 */
	@Override
	public int add(final int x, final int y) {
		// TODO Auto-generated method stub
		return x + y;
	}
/**.
 * '
 */
	@Override
	public float divide(final int x, final int y) {
		// TODO Auto-generated method stub
		if (y == 0) {
			System.out.println("error");
			return 0;
		} else if (y == x) {
			return 1;
		} else if (x < 0 && y < 0) {
			int i = -x;
			int j = -y;
			return (float) i / j;
		} else if (x == 0) {
			return 0;
		} else {
			return (float) x / y;
		}
	}
}
