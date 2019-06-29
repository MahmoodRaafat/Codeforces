/*

B - Divisors of Two Integers

Recently you have received two positive integer numbers x and y. You forgot them, but you 
remembered a shuffled list containing all divisors of x (including 1 and x) and all divisors 
of y (including 1 and y). If d is a divisor of both numbers x and y at the same time, there 
are two occurrences of d in the list. Your problem is to restore suitable positive integer 
numbers x and y that would yield the same list of divisors (possibly in a different order). 
It is guaranteed that the answer exists, i.e. the given list of divisors corresponds to 
some positive integers x and y.

Input
The first line contains one integer n (2 <= n <= 128) — the number of divisors of x and y. 
The second line of the input contains n integers d1,d2,...,dn (1 <= di <= 10^4), where di is 
either divisor of x or divisor of y. If a number is divisor of both numbers x and y then 
there are two copies of this number in the list.

Output
Print two positive integer numbers x and y — such numbers that merged list of their divisors 
is the permutation of the given list of integers. It is guaranteed that the answer exists.

--------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1108_DivisorsOfTwoIntegers {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++)
			arr[i] = in.nextInt();
		Arrays.sort(arr);
		
		int num1 = arr[n-1], num2 = 0;
		ArrayList<Integer> divisors = new ArrayList<>();
		for (int i=n-1; i>=0; i--) {
			if (num1%arr[i] != 0 || divisors.contains(arr[i])) {
				num2 = arr[i];
				break;
			}
			else
				divisors.add(arr[i]);
		}
		System.out.println(num1 + " " + num2);
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