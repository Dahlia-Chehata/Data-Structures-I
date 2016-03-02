package eg.edu.alexu.csd.datastructure.hangman.cs31;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;

public class Hangman_game implements IHangman {
	static String[] temp = new String[350000];
	static String str = new String();
	
	static Character guess;
	static int counter, maximum;
	static String out = null;

	static boolean[] global = new boolean[20];
	 static Character[] show = new Character[20];


	@Override
	public void setDictionary(String[] words) {

		File file = new File("C:\\dictionary.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {

				// this statement reads the line from the file and put it in the
				// array
				for (int i = 0; i < 350000; i++)
					words[i] = dis.readLine();
			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int j = 0; j < 350000; j++)
			temp[j] = words[j];
	}

	@Override
	public String selectRandomSecretWord() {
		Random rand = new Random();
		int num = rand.nextInt(temp.length);
		str = temp[num];
		return str;
	}

	@Override
	public String guess(Character c) {
		int flag = 0;
	 //boolean[] check = new boolean[str.length()];
         
		//Character[] show = new Character[str.length()];
		 
		if (c != null) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == c && global[i] == false) {
					show[i] = c;

					global[i] = true;
					
					flag = 1;
				}
			}
			if (flag == 1) {
				for (int i = 0; i < str.length(); i++) {
					if (global[i] == false)
						show[i] = '-';
				}

				out = null;
				char[] a1 = new char[str.length()];
				for (int i = 0; i < str.length(); i++) {
					a1[i] = show[i].charValue();
				}
				out = String.valueOf(a1);
			}

			if (flag == 0) {

				counter++;
				
					if(counter <maximum && out == null){
						for (int i=0;i<str.length();i++){
							show[i]='-';
						}
						char[] a1 = new char[str.length()];
						for (int i = 0; i < str.length(); i++) {
							a1[i] = show[i].charValue();
						}
						out = String.valueOf(a1);
						
					}
				
				
				
				if (counter >= maximum)
					out = null;

			}
		
		
		return out;
	}
		else 

		return out;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		maximum = max;
		if (max == null)
			maximum = 0;

	}

	public static void main(String[] args) {
		IHangman hangman = new Hangman_game(); // Here you will create an object
												// of your class
		hangman.setDictionary(temp);
		hangman.setMaxWrongGuesses(5);
		String secret = hangman.selectRandomSecretWord();
		while (secret==null)
			secret = hangman.selectRandomSecretWord();
		Scanner input = new Scanner(System.in); // Get user input
        System.out.println("enter"); 
       guess =input.next().charAt(0);
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
			guess = input.next().charAt(0);// scanning a character
		} while (true);
	}

}
