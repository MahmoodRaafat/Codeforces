/*

A - Nearest Interesting Number

Polycarp knows that if the sum of the digits of a number is divisible by 3, then the number 
itself is divisible by 3. He assumes that the numbers, the sum of the digits of which is 
divisible by 4, are also somewhat interesting. Thus, he considers a positive integer n 
interesting if its sum of digits is divisible by 4. Help Polycarp find the nearest larger 
or equal interesting number for the given number a. That is, find the interesting number n 
such that n >= a and n is minimal.

Input
The only line in the input contains an integer a (1 <= a <= 1000).

Output
Print the nearest greater or equal interesting number for the given number a. In other 
words, print the interesting number n such that n >= a and n is minimal.

-----------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A1183_NearestInterestingNumber {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		while (sumOfDigits(n)%4 != 0)
			++n;
		System.out.println(n);
	}
	
	public static int sumOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n%10;
			n/=10;
		}
		return sum;
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
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
