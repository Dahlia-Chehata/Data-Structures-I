package eg.edu.alexu.csd.datastructure.hangman.cs31;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import java.util.Random;


public class Hangman_game implements IHangman {
	static String[] temp;
	 String str ;
	 int counter=0, maximum;
	 String out = new String();
	 static char[] show ;


	@Override
	public void setDictionary(String[] words) {
     
		temp=new String[words.length];
		
		for (int j = 0; j < words.length; j++)
			temp[j] = words[j];
	}

	@Override
	public String selectRandomSecretWord() {
		
		 Random rand = new Random();
			int num = rand.nextInt(temp.length);
			str = temp[num];
			
			show=new char[str.length()] ;
			for(int i=0;i<str.length();i++)
				show[i]='-';
		
		return str;
	}

	@Override
	public String guess(Character c) {
		
		out = String.valueOf(show);
		if (c==null)
			return out;
		if(temp==null)
			return null;
		if (temp.length==0)
		   return null;
		int flag = 0;
     
			for (int i = 0; i < str.length(); i++) {
				if (str.toLowerCase().charAt(i) == Character.toLowerCase(c)) {
					show[i] = c;
					flag = 1;
				}
			}

			if (flag == 0) {

				counter--;
				
				if (counter == 0)
					return null;

			}
			
		 return out;
	
		
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		counter= max;
		if (max == null)
			maximum = 0;

	}

	
}
