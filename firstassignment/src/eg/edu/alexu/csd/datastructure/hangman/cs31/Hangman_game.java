package eg.edu.alexu.csd.datastructure.hangman.cs31;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.Random;
/**.
 * 
 * @author Dell
 *
 */
public class Hangman_game implements IHangman {
	/**.
	 * ;
	 */
	String[] temp = null;
	/**.
	 * '
	 */
	static String str;
	/**.
	 * '
	 */
	static int counter;
	/**.
	 * ;
	 */
	static char[] show;
	/**.
	 * '
	 */
	boolean[] check;
/**.
 * ;
 */
	@Override
	public void setDictionary(String[] words) {

		temp = new String[words.length];

		for (int j = 0; j < words.length; j++) {
			temp[j] = words[j];
		}
	}
/**.
 * ;
 */
	@Override
	public String selectRandomSecretWord() {
		if (temp == null) {
			return null;
		}
		if (temp.length == 0) {
			return null;
		}
		Random rand = new Random();
		/**.
		 * '
		 */
		int num = rand.nextInt(temp.length);
		str = temp[num];
		show = new char[str.length()];
		check = new boolean[str.length()];
		for (int i = 0; i < str.length(); i++) {
			show[i] = '-';
		}

		return str;
	}
/**.
 * ;
 */
	@Override
	public String guess(Character c) {

		if (c == null) {
			return new String(show);
		}
/**.
 * '
 */
		int flag = 0;
		/**.
		 * '
		 */
		int found = 0;

		for (int i = 0; i < str.length(); i++) {
			/**.
			 * ;
			 */
           char k=str.toUpperCase().charAt(i);
           /**.
            * ;
            */
           char l=Character.toUpperCase(c);
			if (k == l && !check[i]) {
				show[i] = Character.toUpperCase(c);
				check[i] = true;
				flag = 1;
			}
		}
		if (flag == 1) {
			return new String(show);
		}
		for (int i = 0; i < str.length(); i++) {
			/**.
			 * ;
			 */
			char k=str.toUpperCase().charAt(i);
			/**.
			 * ;
			 */
	           char l=Character.toUpperCase(c);
			if (k == l && check[i]) {

				found = 1;
			}
		}
		if (found == 1) {
			return new String(show);
		}

		counter--;

		if (counter <= 0) {
			return null;
		}

		return new String(show);
	}
/**.
 * ;
 */
	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		if (max > 0) {
			counter = max;
		}
		if (max == null || max < 0) {
			counter = 0;
		}

	}

}
