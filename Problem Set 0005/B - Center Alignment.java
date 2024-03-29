/*

B - Center Alignment

Almost every text editor has a built-in function of center text alignment. The developers of 
the popular in Berland text editor <Textpad> decided to introduce this functionality into the 
fourth release of the product. You are to implement the alignment in the shortest possible 
time. Good luck!

Input
The input file consists of one or more lines, each of the lines contains Latin letters, 
digits and/or spaces. The lines cannot start or end with a space. It is guaranteed that at 
least one of the lines has positive length. The length of each line and the total amount of 
the lines do not exceed 1000.

Output
Format the given text, aligning it center. Frame the whole text with characters <*> of the 
minimum size. If a line cannot be aligned perfectly (for example, the line has even length, 
while the width of the block is uneven), you should place such lines rounding down the 
distance to the left or to the right edge and bringing them closer left or right alternatively 
(you should start with bringing left).

---------------------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;
public class B0005_CenterAlignment {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> lines = readInput(in);
		int maxLength = findMax(lines);
		boolean left = true;
		
		printLine(maxLength);
		for (int i=0; i<lines.size(); i++) {
			int length = lines.get(i).length();
			int numSpaces = maxLength-length;
			if (numSpaces%2==0)
				printLine(numSpaces/2, numSpaces/2, lines.get(i));
			else {
				int fs = numSpaces/2, ss = numSpaces/2;
				if (left)
					ss++;
				else
					fs++;
				left = !left;
				printLine(fs, ss, lines.get(i));
			}
		}
		printLine(maxLength);
	}
	
	public static ArrayList<String> readInput(BufferedReader in) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		String line = in.readLine();
		while(line != null) {
			list.add(line);
			if (in.ready())
				line = in.readLine();
			else
				line = null;
		}
		return list;
	}
	
	public static int findMax(ArrayList<String> lines) {
		int max = 0;
		for (int i=0; i<lines.size(); i++)
			max = Math.max(max, lines.get(i).length());
		return max;
	}
	
	public static void printLine(int l) {
		for (int i=0; i<l+2; i++)
			System.out.print("*");
		System.out.println();
	}
	
	public static void printLine(int fs, int ss, String str) {
		String firstSpace = "", secondSpace = "";
		
		for (int i=0; i<fs; i++)
			firstSpace += " ";
		for (int i=0; i<ss; i++)
			secondSpace += " ";
		
		System.out.println("*" + firstSpace + str + secondSpace + "*");
	}
}
