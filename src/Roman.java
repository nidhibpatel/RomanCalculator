import java.io.*;

import mp5_romanCal.RomanCalculator;

public class Roman {
	String Roman;
	public String getRoman()
	{
		return Roman;
	}
	public void setRoman(String roman)
	{
		this.Roman = roman;
	}

	//convert_Roman_To_Int("MVXXDGEDSDJSH") --
	public static int convert_Roman_To_Int(String Roman)
	{
		int result = 0;
		
		//for loop goes through each char in the roman string
		for(int i = 0; i < Roman.length(); i++)
		{
			//Adds 1000 to result if character is M at Roman[i]
			 if (Roman.charAt(i) == 'M')
			 {
				 result = result + 1000;
			 }
			//Adds 500 to result if character is D at Roman[i]
			 else if (Roman.charAt(i) == 'D')
			 {
				 result = result + 500;
			 }
			//Adds 100 to result if character is C at Roman[i]
			 else if (Roman.charAt(i) == 'C')
			 {
				 result = result + 100;
			 }
			//Adds 50 to result if character is L at Roman[i]
			 else if (Roman.charAt(i) == 'L')
			 {
				 result = result + 50;
			 }
			//Adds 10 to result if character is M at Roman[i]
			 else if (Roman.charAt(i) == 'X')
			 {
				 result = result + 10;
			 }
			//Adds 5 to result if character is M at Roman[i]
			 else if (Roman.charAt(i) == 'V')
			 {
				 result = result + 5;
			 }
			//Adds 1 to result if character is M at Roman[i]
			 else if (Roman.charAt(i) == 'I')
			 {
				 result = result + 1;
			 }
		}
		//returns the result
		return result;
	}
	//this method converts integer to roman
	public static String convert_Int_to_Roman(int number) {
		String result = ""; //fill up this roman as we run algorithm
		//int array corresponding to each roman 
		int[] denomintors = {1000, 500, 100, 50, 10, 5, 1};
		char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		
		int i = 0;
		//loops until it reaches the end of denominators or if the number becomes 0..
		while(i < denomintors.length && number > 0)
		{
			//Calculates how many of each roman is needed
			int times = number/denomintors[i];
			number = number - (denomintors[i] * times);
			//Adds that roman to result
			for(int j = 0; j < times; j++) {
				result += roman[i]; 
			}
			i++;
		}
		
		return result; //it will return a ROMAN
	}
	public void display_Roman() {
		System.out.println(Roman);
	}
	
}
