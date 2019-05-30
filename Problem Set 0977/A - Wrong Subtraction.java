/*

A - Wrong Subtraction

Little girl Tanya is learning how to decrease a number by one, but she does it wrong with a 
number consisting of two or more digits. Tanya subtracts one from a number by the following 
algorithm: If the last digit of the number is non-zero, she decreases the number by one; If 
the last digit of the number is zero, she divides the number by 10 (i.e. removes the last 
digit). You are given an integer number n. Tanya will subtract one from it k times. Your 
task is to print the result after all k subtractions. It is guaranteed that the result will 
be positive integer number.

Input
The first line of the input contains two integer numbers n and k (2 <= n <= 10^9, 
1 <= k <= 50) — the number from which Tanya will subtract and the number of subtractions 
correspondingly.

Output
Print one integer number — the result of the decreasing n by one k times.

--------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A0977_WrongSubtraction {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int k = in.nextInt();
		
		for (int i=0; i<k; i++) {
			if (n%10 != 0)
				n -= 1;
			else
				n /= 10;
		}
		System.out.println(n);
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
