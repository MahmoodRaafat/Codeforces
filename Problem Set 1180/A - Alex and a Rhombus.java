/*

A - Alex and a Rhombus

While playing with geometric figures, Alex has accidentally invented a concept of a 
n-th order rhombus in a cell grid. A 1-st order rhombus is just a square 1*1 (i.e 
just a cell). A n-th order rhombus for all n>=2 one obtains from a n-1 -th order 
rhombus adding all cells which have a common side with it to it. Alex asks you to 
compute the number of cells in a n-th order rhombus.

Input
The first and only input line contains integer n (1 <= n <= 100) — order of a rhombus 
whose numbers of cells should be computed.

Output
Print exactly one integer — the number of cells in a n-th order rhombus.

------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A1180_AlexAndARhombus {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		int res = 1;
		for (int i=1; i<n; i++)
			res += 4*i;
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
