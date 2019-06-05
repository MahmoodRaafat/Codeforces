/*

A - Die Roll

Yakko, Wakko and Dot, world-famous animaniacs, decided to rest from acting in cartoons, 
and take a leave to travel a bit. Yakko dreamt to go to Pennsylvania, his Motherland and 
the Motherland of his ancestors. Wakko thought about Tasmania, its beaches, sun and sea. 
Dot chose Transylvania as the most mysterious and unpredictable place. But to their great 
regret, the leave turned to be very short, so it will be enough to visit one of the three 
above named places. That's why Yakko, as the cleverest, came up with a truly genius idea: 
let each of the three roll an ordinary six-sided die, and the one with the highest amount 
of points will be the winner, and will take the other two to the place of his/her dreams.
Yakko thrown a die and got Y points, Wakko - W points. It was Dot's turn. But she didn't 
hurry. Dot wanted to know for sure what were her chances to visit Transylvania. It is 
known that Yakko and Wakko are true gentlemen, that's why if they have the same amount 
of points with Dot, they will let Dot win.

Input
The only line of the input file contains two natural numbers Y and W - the results of 
Yakko's and Wakko's die rolls.

Output
Output the required probability in the form of irreducible fraction in format <<A/B>> 
where A is the numerator, and B is the denominator. If the required probability equals 
to zero, output <<0/1>>. If the required probability equals to 1, output <<1/1>>. 

---------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A0009_DieRoll {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int numerator = 7 - Math.max(in.nextInt(), in.nextInt());
		int denominator = 6;
		
		if (numerator == 5 || numerator == 1)
			System.out.println(numerator + "/" + denominator);
		else if (6 % numerator == 0) {
			denominator /= numerator;
			System.out.println(1 + "/" + denominator);
		}
		else
			System.out.println(2 + "/" + 3);
	}
	
	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader() {
			st = null;
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st= new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
