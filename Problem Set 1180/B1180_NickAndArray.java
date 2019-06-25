/*

B - Nick and Array

ick had received an awesome array of integers a=[a1,a2,…,an] as a gift for his 5th 
birthday from his mother. He was already going to explore its various properties 
but after unpacking he was disappointed a lot because the product a1*a2*...an of 
its elements seemed to him not large enough. He was ready to throw out the array, 
but his mother reassured him. She told him, that array would not be spoiled after 
the following operation: choose any index i (1 <= i <= n) and do ai = -ai-1. For 
example, he can change array [3,-1,-4,1] to an array [-4,-1,3,1] after applying 
this operation to elements with indices i=1 and i=3. Kolya had immediately 
understood that sometimes it's possible to increase the product of integers of the 
array a lot. Now he has decided that he wants to get an array with the maximal 
possible product of integers using only this operation with its elements (possibly 
zero, one or more times, as many as he wants), it is not forbidden to do this 
operation several times for the same index. Help Kolya and print the array with 
the maximal possible product of elements a1*a2*...an which can be received using 
only this operation in some order. If there are multiple answers, print any of them.

Input
The first line contains integer n (1 <= n <= 10^5) — number of integers in the 
array. The second line contains n integers a1, a2, ..., an (-10^6 <= ai <= 10^6) — 
elements of the array

Output
Print n numbers — elements of the array with the maximal possible product of elements 
which can be received using only this operation in some order from the given array.

------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1180_NickAndArray {
	
	static class Num implements Comparable<Num> {
		int index;
		int num;

		public Num(int i, int n) {
			index = i;
			num = n;
		}
		
		public int compareTo(Num n) {
			return Integer.compare(num, n.num);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		Num[] arr = new Num[n];
		Num[] nums = new Num[n];
		for (int i=0; i<n; i++) {
			arr[i] = new Num(i, in.nextInt());
			if (arr[i].num >= 0)
				arr[i].num = -1*arr[i].num - 1;
			nums[i] = arr[i];
		}
		
		Arrays.sort(nums);
		
		if (n%2 == 1) {
			int num = nums[0].num;
			if (num == -1)
				for (Num N: arr)
					N.num = 0;
			else
				nums[0].num = -1*num - 1;
		}

		StringBuffer sb = new StringBuffer();
		for (Num N: arr)
			sb.append(N.num + " ");
		System.out.println(sb);
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