/*

B - Dinner With Emma

Jack decides to invite Emma out for a dinner. Jack is a modest student, he doesn't 
want to go to an expensive restaurant. Emma is a girl with high taste, she prefers 
elite places. Munhattan consists of n streets and m avenues. There is exactly one 
restaurant on the intersection of each street and avenue. The streets are numbered 
with integers from 1 to n and the avenues are numbered with integers from 1 to m. 
The cost of dinner in the restaurant at the intersection of the i-th street and the 
j-th avenue is cij. Jack and Emma decide to choose the restaurant in the following 
way. Firstly Emma chooses the street to dinner and then Jack chooses the avenue. 
Emma and Jack makes their choice optimally: Emma wants to maximize the cost of the 
dinner, Jack wants to minimize it. Emma takes into account that Jack wants to 
minimize the cost of the dinner. Find the cost of the dinner for the couple in love.

Input
The first line contains two integers n, m (1 <= n, m <= 100) - the number of 
streets and avenues in Munhattan. Each of the next n lines contains m integers cij 
(1 <= cij <= 10^9) — the cost of the dinner in the restaurant on the intersection 
of the i-th street and the j-th avenue.

Output
Print the only integer a — the cost of the dinner for Jack and Emma.

----------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B0616_DinnerWithEmma {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int m = in.nextInt();
		
		int max = 0;
		for (int i=0; i<n; i++) {
			int minInRow = Integer.MAX_VALUE;
			for (int j=0; j<m; j++)
				minInRow = Math.min(minInRow, in.nextInt());
			max = Math.max(max, minInRow);
		}
		
		System.out.println(max);
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
