/*

D - Bicolored RBS

A string is called bracket sequence if it does not contain any characters other than 
"(" and ")". A bracket sequence is called regular (shortly, RBS) if it is possible to 
obtain a correct arithmetic expression by inserting characters "+" and "1" into this 
sequence. Each opening bracket in RBS is paired with some closing bracket. We can 
define nesting depth of the RBS as maximum number of bracket pairs, such that the 2nd 
pair lies inside the 1st one, the 3rd inside the 2-nd one and so on. For example, 
nesting depth of "" is 0, "()" is 1, and "((()))" is 3. You are given RBS s of even 
length n. You should color each bracket of s into one of two colors: red or blue. 
Bracket sequence r, consisting only of red brackets, should be RBS, and bracket 
sequence b, consisting only of blue brackets, should be RBS. Any of them can be empty. 
You are not allowed to reorder characters in s, r or b. No brackets can be left 
uncolored. Among all possible variants you should choose one that minimizes maximum of 
r's and b's nesting depth. If there are multiple solutions you can print any of them.

Input
The first line contains an even integer n (2 <= n <= 2*10^5) — the length of RBS s. The 
second line contains regular bracket sequence s (length n, consisting of "(" and ")").

Output
Print single string t of length n consisting of "0"-s and "1"-s. If ti is equal to 0 
then character si belongs to RBS r, otherwise si belongs to b.

--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D1167_BicoloredRBS {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		String str = in.next();
		
		StringBuffer sb = new StringBuffer();
		int depth1 = 0, depth2 = 0;
		for (int i=0; i<n; i++) {
			if (str.charAt(i) == '(') {
				if (depth1 <= depth2) {
					++depth1;
					sb.append(0);
				}
				else {
					++depth2;
					sb.append(1);
				}
			}
			else {
				if (depth1 >= depth2) {
					--depth1;
					sb.append(0);
				}
				else {
					--depth2;
					sb.append(1);
				}
			}
		}
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
