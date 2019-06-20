/*

B - Tanya and Candies

Tanya has n candies numbered from 1 to n. The i-th candy has the weight ai. She plans to eat 
exactly n-1 candies and give the remaining candy to her dad. Tanya eats candies in order of 
increasing their numbers, exactly one candy per day. Your task is to find the number of such 
candies i (let's call these candies good) that if dad gets the i-th candy then the sum of 
weights of candies Tanya eats in even days will be equal to the sum of weights of candies 
Tanya eats in odd days. Note that at first, she will give the candy, after it she will eat 
the remaining candies one by one.

Input
The first line of the input contains one integer n (1 <= n <= 2*10^5) — the number of candies.
The second line of the input contains n integers a1, a2, ..., an (1 <= ai <= 10^4), where ai 
is the weight of the i-th candy.

Output
Print one integer — the number of such candies i (good candies) that if dad gets the i-th candy 
then the sum of weights of candies Tanya eats in even days will be equal to the sum of weights 
of candies Tanya eats in odd days.

----------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1118_TanyaAndCandies {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int[] arr = new int[n];
		arr[0] = in.nextInt();
		
		boolean right = true;
		int r = 0, l = 0;
		for (int i=1; i<n; i++) {
			arr[i] = in.nextInt();
			if (right)
				r += arr[i];
			else
				l += arr[i];
			right = !right;
		}
		
		right = true;
		int res = 0;
		for (int i=1; i<n; i++) {
			if (r == l)
				++res;
			if (right) {
				r += arr[i-1];
				r -= arr[i];
			}
			else {
				l += arr[i-1];
				l -= arr[i];
			}
			right = !right;
		}
		
		if (r == l)
			++res;
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
