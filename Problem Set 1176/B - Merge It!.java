/*

B - Merge It!

You are given an array a consisting of n integers a1, a2, ..., an. In one operation you can 
choose two elements of the array and replace them with the element equal to their sum (it does 
not matter where you insert the new element). Your task is to find the maximum possible number 
of elements divisible by 3 that are in the array after performing this operation an arbitrary 
(possibly, zero) number of times. You have to answer t independent queries.

Input
The first line contains one integer t (1 <= t <= 1000) — the number of queries. The first line 
of each query contains one integer n (1 <= n <= 100). The second line of each query contains n
integers a1, a2, ..., an (1 <= ai <= 10^9).

Output
For each query print one integer in a single line — the maximum possible number of elements 
divisible by 3 that are in the array after performing described operation an arbitrary 
(possibly, zero) number of times.

----------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1176_MergeIt {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int t = in.nextInt();
		
		while (t-- > 0) {
			int n = in.nextInt();
			int res = 0, num1 = 0, num2 = 0;
			for (int i=0; i<n; i++) {
				int num = in.nextInt();
				if (num%3 == 0)
					++res;
				else if (num%3 == 1)
					++num1;
				else
					++num2;
			}
			
			int min = Math.min(num1, num2);
			res += min;
			if (num2 == min)
				res += (num1-min)/3;
			else
				res += (num2-min)/3;
			
			System.out.println(res);
		}
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
