package eg.edu.alexu.csd.datastructure.hangman.cs31;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.Random;


public class Hangman_game implements IHangman {
	static String[] temp;
	static String str = new String();
	static Character guess;
	static int counter=0, maximum;
	static String out = null;
	static boolean[] global=new boolean [20];
	 static Character[] show =new Character[20];


	@Override
	public void setDictionary(String[] words) {
     
		temp=new String[words.length];
		
		for (int j = 0; j < words.length; j++)
			temp[j] = words[j];
	}

	@Override
	public String selectRandomSecretWord() {
		str=null;
		 Random rand = new Random();
			int num = rand.nextInt(temp.length);
			str = temp[num];
		for(int i=0;i<str.length();i++)
				show[i]='-';
		return str;
	}

	@Override
	public String guess(Character c) {
		int flag = 0;
     
			for (int i = 0; i < str.length(); i++) {
				if (str.toLowerCase().charAt(i) == Character.toLowerCase(c)&& global[i] == false) {
					show[i] = c;

					global[i] = true;
					
					flag = 1;
				}
			}
			if (flag == 1) {
				
				for (int i=0;i<str.length();i++)
					show[i]=c;
			}

			if (flag == 0) {

				counter++;
				
				if (counter >= maximum)
					out = null;

			}
			out = String.valueOf(show);
		 return out;
	
		
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		maximum = max;
		if (max == null)
			maximum = 0;

	}

	/*public static void main(String[] args) {
		
		IHangman hangman = new Hangman_game(); // Here you will create an object
												// of your class
		hangman.setDictionary(temp);
		hangman.setMaxWrongGuesses(5);
		String secret = hangman.selectRandomSecretWord();
		while (secret==null)
			secret = hangman.selectRandomSecretWord();
		Scanner input = new Scanner(System.in); // Get user input
        //System.out.println("enter"); 
       guess =input.next().toUpperCase().charAt(0);
		do {
			String result = hangman.guess(guess);
			if (result == null) {
				System.out.println("Fail! correct answer = '" + secret + "'"); // fail
				return;
			}
			System.out.println(result);
			if (!result.contains("-")) {
				System.out.println("Well Done!"); // win
				return;
			}
			guess = input.next().toUpperCase().charAt(0);// scanning a character
		} while (true);
	}*/

}
