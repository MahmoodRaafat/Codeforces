/*

D - Diverse Garland

You have a garland consisting of n lamps. Each lamp is colored red, green or blue. The color of 
the i-th lamp is si ('R', 'G' and 'B' — colors of lamps in the garland). You have to recolor 
some lamps in this garland (recoloring a lamp means changing its initial color to another) in 
such a way that the obtained garland is diverse. A garland is called diverse if any two adjacent 
(consecutive) lamps (i. e. such lamps that the distance between their positions is 1) have 
distinct colors. In other words, if the obtained garland is t then for each i from 1 to n-1 the 
condition ti!=ti+1 should be satisfied. Among all ways to recolor the initial garland to make it 
diverse you have to choose one with the minimum number of recolored lamps. If there are multiple 
optimal solutions, print any of them.

Input
The first line of the input contains one integer n (1 <= n <= 2*10^5) — the number of lamps. The 
second line of the input contains the string s consisting of n characters 'R', 'G' and 'B' — 
colors of lamps in the garland.

Output
In the first line of the output print one integer r — the minimum number of recolors needed to 
obtain a diverse garland from the given one. In the second line of the output print one string t
of length n — a diverse garland obtained from the initial one with minimum number of recolors. 
If there are multiple optimal solutions, print any of them.

-----------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D1108_DiverseGarland {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		char[] garland = in.next().toCharArray();
		
		char[] chars = {'R', 'G', 'B'};
		int numChanges = 0;
		for (int i=1; i<n; i++) if (garland[i] == garland[i-1]) {
			++numChanges;
			ArrayList<Character> bad = new ArrayList<>();
			bad.add(garland[i-1]);
			if (i < n-1)
				bad.add(garland[i+1]);
			for (char c: chars) if (!bad.contains(c)) {
				garland[i] = c;
				break;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(numChanges + "\n");
		for (char c: garland)
			sb.append(c);
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
