/*

A - Digits Sequence Dividing

You are given a sequence s consisting of n digits from 1 to 9. You have to divide it into 
at least two segments (segment — is a consecutive sequence of elements) (in other words, 
you have to place separators between some digits of the sequence) in such a way that each 
element belongs to exactly one segment and if the resulting division will be represented 
as an integer numbers sequence then each next element of this sequence will be strictly 
greater than the previous one. More formally: if the resulting division of the sequence 
is t1, t2, ..., tk, where k is the number of element in a division, then for each i from 
1 to k-1 the condition ti < ti+1 (using numerical comparing, it means that the integer 
representations of strings are compared) should be satisfied. Your task is to find any 
suitable division for each of the q independent queries.

Input
The first line of the input contains one integer q (1 <= q <= 300) — the number of 
queries. The first line of the i-th query contains one integer number ni (2 <= ni <= 300) 
— the number of digits in the i-th query. The second line of the i-th query contains one 
string si of length ni consisting only of digits from 1 to 9.

Output
If the sequence of digits in the i-th query cannot be divided into at least two parts in 
a way described in the problem statement, print the single line "NO" for this query. 
Otherwise in the first line of the answer to this query print "YES", on the second line 
print ki — the number of parts in your division of the i-th query sequence and in the 
third line print ki strings ti, 1, ti, 2, ..., ti, ki — your division. Parts should be 
printed in order of the initial string digits. It means that if you write the parts one 
after another without changing their order then you'll get the string si.

-------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A1107_DigitsSequenceDividing {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int q = in.nextInt();
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<q; i++) {
			int n = in.nextInt();
			String num = in.next();
			
			if (n < 2)
				sb.append("NO\n");
			else if (n > 2) {
				sb.append("YES\n2\n");
				sb.append(num.substring(0, 1) + " " + num.substring(1) + "\n");
			}
			else {
				int firstDigit = Integer.parseInt(num.substring(0, 1));
				int secondDigit = Integer.parseInt(num.substring(1));
				if (firstDigit >= secondDigit)
					sb.append("NO\n");
				else {
					sb.append("YES\n2\n" + firstDigit + " " + secondDigit + "\n");
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
