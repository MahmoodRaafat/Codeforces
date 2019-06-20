/*

D1 - Coffee and Coursework

Polycarp has to write a coursework. The coursework consists of m pages. Polycarp also has n cups 
of coffee. The coffee in the i-th cup Polycarp has ai caffeine in it. Polycarp can drink some cups 
of coffee (each one no more than once). He can drink cups in any order. Polycarp drinks each cup 
instantly and completely (i.e. he cannot split any cup into several days). Surely, courseworks are 
not being written in a single day (in a perfect world of Berland, at least). Let's consider some 
day of Polycarp's work. Consider Polycarp drinks k cups of coffee during this day and caffeine 
dosages of cups Polycarp drink during this day are ai1, ai2 , ..., aik. Then the first cup he 
drinks gives him energy to write ai1 pages of coursework, the second cup gives him energy to write 
max(0, ai2-1) pages, the third cup gives him energy to write max(0,ai3-2) pages, ..., the k-th cup 
gives him energy to write max(0,aik-k+1) pages. If Polycarp doesn't drink coffee during some day, 
he cannot write coursework at all that day. Polycarp has to finish his coursework as soon as 
possible (spend the minimum number of days to do it). Your task is to find out this number of days 
or say that it is impossible.

Input
The first line of the input contains two integers n and m (1 < n < 100, 1 <= m <= 10^4) — the 
number of cups of coffee and the number of pages in the coursework. The second line of the input 
contains n integers a1, a2, ..., an (1 <= ai <= 100), where ai is the caffeine dosage of coffee 
in the i-th cup.

Output
If it is impossible to write the coursework, print -1. Otherwise print the minimum number of days 
Polycarp needs to do it.

--------------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D1118_CoffeeAndCourseworkEasy {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int m = in.nextInt();
		
		long sum = 0;
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		arr = reverseOrder(arr);
		
		if (m > sum)
			System.out.println(-1);
		else {
			for (int i=1; i<=n; i++) {
				if (isPossible(i, arr, m)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	public static boolean isPossible(int day, int[] arr, int val) {
		long total = 0;
		for (int i=0; i<arr.length; i++)
			total += Math.max(0, arr[i] - i/day);
		return total >= val;
	}
	
	public static int[] reverseOrder(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i=0; i<arr.length; i++)
			newArr[i] = arr[arr.length-1-i];
		return newArr;
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
