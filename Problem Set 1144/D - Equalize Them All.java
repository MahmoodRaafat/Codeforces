/*

D - Equalize Them All

You are given an array a consisting of n integers. You can perform the following operations 
arbitrary number of times (possibly, zero):
    (1) Choose a pair of indices (i,j) such that |i-j|=1 (indices i and j are adjacent) and 
    set ai equal to ai+|ai-aj|;
    (2) Choose a pair of indices (i,j) such that |i-j|=1 (indices i and j are adjacent) and 
    set ai equal to ai-|ai-aj|. 
Your task is to find the minimum number of operations required to obtain the array of equal 
elements and print the order of operations to do it. It is guaranteed that you always can 
obtain the array of equal elements using such operations. Note that after each operation each 
element of the current array should not exceed 10^18 by absolute value.

Input
The first line of the input contains one integer n (1 <= n <= 2*10^5) — the number of 
elements in a. The second line of the input contains n integers a1, a2, ..., an 
(0 <= ai <= 2*10^5), where ai is the i-th element of a.

Output
In the first line print one integer k — the minimum number of operations required to obtain 
the array of equal elements. In the next k lines print operations itself. The p-th operation 
should be printed as a triple of integers (tp, ip, jp), where tp is either 1 or 2 (1 means 
that you perform the operation of the first type, and 2 means that you perform the operation 
of the second type), and ip and jp are indices of adjacent elements of the array such that 
1 <= ip, jp <= n, |ip-jp|=1. If there are many possible answers, you can print any.

--------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D1144_EqualizeThemAll {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		
		int n = in.nextInt();
		int[] arr = new int[n+1];
		Map<Integer, Integer> map = new HashMap<>();
		
		int max = 1, maxNum = -1;
		for (int i=1; i<=n; i++) {
			arr[i] = in.nextInt();
			if (!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else {
				int val = map.get(arr[i]) + 1;
				map.put(arr[i], val);
				if (val > max) {
					max = val;
					maxNum = arr[i];
				}
			}
		}
		if (maxNum == -1)
			maxNum = arr[1];
		
		StringBuffer sb = new StringBuffer();
		sb.append((n-max) + "\n");
		
		int first = findFirst(arr, maxNum, n);
		for (int i=first-1; i>0; i--) {
			if (arr[i] > maxNum)
				sb.append("2 " + i + " " + (i+1) + "\n");
			else
				sb.append("1 " + i + " " + (i+1) + "\n");
		}
		for (int i=first+1; i<=n; i++) if (arr[i] != maxNum) {
			if (arr[i] > maxNum)
				sb.append("2 " + i + " " + (i-1) + "\n");
			else
				sb.append("1 " + i + " " + (i-1) + "\n");
		}
		System.out.println(sb);
	}
	
	public static int findFirst(int[] arr, int maxNum, int n) {
		for (int i=1; i<=n; i++)
			if (arr[i] == maxNum)
				return i;
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
