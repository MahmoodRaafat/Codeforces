/*

C - Less or Equal

You are given a sequence of integers of length n and integer number k. You should print 
any integer number x in the range of [1;109] (1 <= x <= 10^9) such that exactly k elements 
of given sequence are less than or equal to x. Note that the sequence can contain equal 
elements. If there is no such x, print "-1" (without quotes).

Input
The first line of the input contains integer numbers n
and k (1 <= n <= 2*10^5, 0 <= k <= n). The second line of the input contains n integer 
numbers a1, a2, ..., an (1 <= ai <= 10^9) — the sequence itself.

Output
Print any integer number x from range [1;109] such that exactly k elements of given 
sequence is less or equal to x. If there is no such x, print "-1" (without quotes).

-----------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C0977_LessOrEqual {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int k = in.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i=0; i<n; i++)
			arr.add(in.nextInt());
		
		Collections.sort(arr);
		
		int res = -1;
		if (k == 0)
			res = 1;
		else
			res = arr.get(k-1);
		
		int count = 0;
		for (int i=0; i<n; i++)
			if (arr.get(i) <= res)
				++count;
		
		if (res < 1 || res > (int) 1e9 || count != k)
			System.out.println(-1);
		else
			System.out.println(res);
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