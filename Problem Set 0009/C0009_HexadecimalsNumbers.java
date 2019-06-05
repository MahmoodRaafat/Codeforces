/*

C - Hexadecimal's Numbers

One beautiful July morning a terrible thing happened in Mainframe: a mean virus 
Megabyte somehow got access to the memory of his not less mean sister Hexadecimal. 
He loaded there a huge amount of n different natural numbers from 1 to n to obtain 
total control over her energy. But his plan failed. The reason for this was very 
simple: Hexadecimal didn't perceive any information, apart from numbers written in 
binary format. This means that if a number in a decimal representation contained 
characters apart from 0 and 1, it was not stored in the memory. Now Megabyte wants 
to know, how many numbers were loaded successfully.

Input
Input data contains the only number n (1 <= n <= 10^9).

Output
Output the only number — answer to the problem.

----------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C0009_HexadecimalsNumbers {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		int index = 1, res = 0;
		while (true) {
			String s = Integer.toBinaryString(index++);
			if (Integer.parseInt(s) <= n)
				++res;
			else 
				break;
		}
		
		System.out.println(res);
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
