/*

A - Divide It!

You are given an integer n. You can perform any of the following operations with this number an 
arbitrary (possibly, zero) number of times: (1) Replace n with n/2 if n is divisible by 2; (2)
Replace n with 2n/3 if n is divisible by 3; (3) Replace n with 4n/5 if n is divisible by 5. Your 
task is to find the minimum number of moves required to obtain 1 from n or say that it is 
impossible to do it. You have to answer q independent queries.

Input
The first line of the input contains one integer q (1 <= q <= 1000) — the number of queries. The 
next q lines contain the queries. For each query you are given the integer number n 
(1 <= n <= 10^18).

Output
Print the answer for each query on a new line. If it is impossible to obtain 1 from n, print -1. 
Otherwise, print the minimum number of moves required to do it.

------------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A1176_DivideIt {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int Q = in.nextInt();
		
		while (Q-- > 0) {
			long num = in.nextLong();
			if (num == 1) {
				System.out.println(0);
				continue;
			}
			
			int numOperations = 0;
			while (true) {
				boolean operation = true;
				if (num % 2 == 0)
					num /= 2;
				else if (num % 3 == 0)
					num = 2*num/3;
				else if (num % 5 == 0)
					num = 4*num/5;
				else
					operation = false;
				
				if (operation)
					++numOperations;
				else {
					System.out.println(-1);
					break;
				}
				
				if (num == 1) {
					System.out.println(numOperations);
					break;
				}
			}
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
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}