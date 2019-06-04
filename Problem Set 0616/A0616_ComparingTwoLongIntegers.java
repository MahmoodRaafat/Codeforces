/*

A - Comparing Two Long Integers

You are given two very long integers a, b (leading zeroes are allowed). You should 
check what number a or b is greater or determine that they are equal. The input size 
is very large so don't use the reading of symbols one by one. Instead of that use 
the reading of a whole line or token.

Input
The first line contains a non-negative integer a. The second line contains a 
non-negative integer b. The numbers a, b may contain leading zeroes. Each of them 
contains no more than 10^6 digits.

Output
Print the symbol "<" if a < b and the symbol ">" if a > b. If the numbers are equal 
print the symbol "=".

-----------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A0616_ComparingTwoLongIntegers {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		String a = shortenString(in.next());
		String b = shortenString(in.next());
		
		if (a.length() > b.length())
			System.out.println(">");
		else if (a.length() < b.length())
			System.out.println("<");
		else {
			int res = a.compareTo(b);
			if (res > 0)
				System.out.println(">");
			else if (res < 0)
				System.out.println("<");
			else
				System.out.println("=");
		}
	}
	
	public static String shortenString(String str) {
		int index = 0;
		while (index < str.length() && str.charAt(index) == '0')
			index++;
		
		if (index == str.length()) // string only contains 0
			return "";
		return str.substring(index);
	}
	
	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}
		
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
	}
}