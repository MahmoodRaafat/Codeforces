/*

B - Two-Gram

Two-gram is an ordered pair (i.e. string of length two) of capital Latin letters. For 
example, "AZ", "AA", "ZA" — three distinct two-grams. You are given a string s consisting 
of n capital Latin letters. Your task is to find any two-gram contained in the given string 
as a substring (i.e. two consecutive characters of the string) maximal number of times. For 
example, for string s = "BBAABBBA" the answer is two-gram "BB", which contained in s three 
times. In other words, find any most frequent two-gram. Note that occurrences of the 
two-gram can overlap with each other.

Input
The first line of the input contains integer number n (2 <= n <= 100) — the length of string 
s. The second line of the input contains the string s consisting of n capital Latin letters.

Output
Print the only line containing exactly two capital Latin letters — any two-gram contained in 
the given string s as a substring (i.e. two consecutive characters of the string) maximal 
number of times.

--------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B0977_TwoGram {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		String str = in.next();
		
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<n-1; i++) {
			String twoGram = str.substring(i, i+2);
			if (!map.containsKey(twoGram))
				map.put(twoGram, 0);
			map.put(twoGram, map.get(twoGram) + 1);
		}
		
		int max = 0;
		String res = "";
		for (String s: map.keySet()) {
			if (map.get(s) > max) {
				max = map.get(s);
				res = s;
			}
		}
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
