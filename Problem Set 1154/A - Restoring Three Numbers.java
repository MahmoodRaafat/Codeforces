/*

A - Restoring Three Numbers

Polycarp has guessed three positive integers a, b and c. He keeps these numbers in secret, 
but he writes down four numbers on a board in arbitrary order — their pairwise sums (three 
numbers) and sum of all three numbers (one number). So, there are four numbers on a board 
in random order: a+b, a+c, b+c and a+b+c. You have to guess three numbers a, b and c using 
given numbers. Print three guessed integers in any order. Pay attention that some given 
numbers a, b and c can be equal (it is also possible that a=b=c).

Input
The only line of the input contains four positive integers x1, x2, x3, x4 (2 <= xi <= 10^9) 
— numbers written on a board in random order. It is guaranteed that the answer exists for 
the given number x1, x2, x3, x4.

Output
Print such positive integers a, b and c that four numbers written on a board are values 
a+b, a+c, b+c and a+b+c written in some order. Print a, b and c in any order. If there are 
several answers, you can print any. It is guaranteed that the answer exists.

------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A1154_RestoringThreeNumbers {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		
		int[] arr = new int[4];
		for (int i=0; i<4; i++)
			arr[i] = in.nextInt();
		
		Arrays.sort(arr);
		
		for (int i=2; i>=0; i--)
			System.out.print(arr[3]-arr[i] + " ");
		System.out.println();
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
