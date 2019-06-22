/*

A - Theatre Square

Theatre Square in the capital city of Berland has a rectangular shape with the size 
n x m meters. On the occasion of the city's anniversary, a decision was taken to pave 
the Square with square granite flagstones. Each flagstone is of the size a x a. What 
is the least number of flagstones needed to pave the Square? It's allowed to cover 
the surface larger than the Theatre Square, but the Square has to be covered. It's 
not allowed to break the flagstones. The sides of flagstones should be parallel to 
the sides of the Square.

Input
The input contains three positive integer numbers in the first line: n, m and a 
(1 <= n, m, a <= 10^9).

Output
Write the needed number of flagstones.

------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A0001_TheatreSquare {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();
		
		int numLength = n%a == 0 ? n/a : n/a+1;
		int numWidth = m%a == 0 ? m/a : m/a+1;
		System.out.println((long) numLength*numWidth);
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
