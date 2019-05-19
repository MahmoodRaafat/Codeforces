/*

C - Longest Regular Bracket Sequence

This is yet another problem dealing with regular bracket sequences. We should remind you 
that a bracket sequence is called regular, if by inserting «+» and «1» into it we can get 
a correct mathematical expression. For example, sequences <(())()>, <()> and <(()(()))> are 
regular, while <)(>, <(()> and <(()))(> are not. You are given a string of <(> and <)> 
characters. You are to find its longest substring that is a regular bracket sequence. You 
are to find the number of such substrings as well.

Input
The first line of the input file contains a non-empty string, consisting of <(> and <)> 
characters. Its length does not exceed 10^6.

Output
Print the length of the longest substring that is a regular bracket sequence, and the 
number of such substrings. If there are no such substrings, write the only line containing 
"0 1".

-----------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C0005_LongestRegularBracketSequence {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		String str = in.next();
		
		int max = 0, open = 0, close = 0, maxLength = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '(')
				++open;
			else if (str.charAt(i) == ')')
				++close;
			if (close > open) {
				close = 0;
				open = 0;
			}
			else if (open == close) {
				if (open + close == maxLength)
					++max;
				else if (open + close > maxLength) {
					maxLength = open + close;
					max = 1;
				}
			}
		}
		
		int res = max;
		max = 0;
		open = 0;
		close = 0;
		
		for (int i=str.length()-1; i>=0; i--) {
			if (str.charAt(i) == '(')
				++open;
			else if (str.charAt(i) == ')')
				++close;
			if (open > close) {
				close = 0;
				open = 0;
			}
			else if (open == close) {
				if (open + close == maxLength)
					++max;
				else if (open + close > maxLength) {
					maxLength = open + close;
					max = 1;
				}
			}
		}
		res = Math.max(Math.max(res, 1), max);
		System.out.println(maxLength + " " + res);	
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
	}
}
