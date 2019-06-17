/*

C - Lose It!

You are given an array a consisting of n integers. Each ai is one of the six following numbers: 
4,8,15,16,23,42. Your task is to remove the minimum number of elements to make this array good.
An array of length k is called good if k is divisible by 6 and it is possible to split it into 
k*6 subsequences 4,8,15,16,23,42. 

Input
The first line of the input contains one integer n (1 <= n <= 5*10^5) — the number of elements 
in a. The second line of the input contains n integers a1, a2, ..., an (each ai is one of the 
following numbers: 4,8,15,16,23,42), where ai is the i-th element of a.

Output
Print one integer — the minimum number of elements you have to remove to obtain a good array.

----------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C1176_LoseIt {

	static final int[] nums = {4, 8, 15, 16, 23, 42};
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		int[] arr = new int[7];
		int numToDelete = 0;
		for (int i=0; i<n; i++) {
			int num = in.nextInt();
			int pos = findPos(num);
			
			if (pos == 0)
				++arr[0];
			else {
				if (arr[pos-1] == 0)
					++numToDelete;
				else {
					--arr[pos-1];
					++arr[pos];
				}
			}
		}
		
		for (int i=0; i<5; i++)
			numToDelete += arr[i]*(i+1);
		System.out.println(numToDelete);
	}
	
	public static int findPos(int num) {
		for (int j=0; j<6; j++)
			if (nums[j] == num)
				return j;
		return -1;
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