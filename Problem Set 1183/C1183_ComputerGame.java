/*

C - Computer Game

Vova is playing a computer game. There are in total n turns in the game and Vova really 
wants to play all of them. The initial charge of his laptop battery (i.e. the charge 
before the start of the game) is k. During each turn Vova can choose what to do: (1) If 
the current charge of his laptop battery is strictly greater than a, Vova can just play, 
and then the charge of his laptop battery will decrease by a; (2) if the current charge 
of his laptop battery is strictly greater than b (b<a), Vova can play and charge his 
laptop, and then the charge of his laptop battery will decrease by b; (3) if the current 
charge of his laptop battery is less than or equal to a and b at the same time then Vova 
cannot do anything and loses the game. Regardless of Vova's turns the charge of the 
laptop battery is always decreases. Vova wants to complete the game (Vova can complete 
the game if after each of n turns the charge of the laptop battery is strictly greater 
than 0). Vova has to play exactly n turns. Among all possible ways to complete the game, 
Vova wants to choose the one where the number of turns when he just plays (first type 
turn) is the maximum possible. It is possible that Vova cannot complete the game at all.
Your task is to find out the maximum possible number of turns Vova can just play (make 
the first type turn) or report that Vova cannot complete the game. You have to answer q
independent queries.

Input
The first line of the input contains one integer q (1 <= q <= 10^5) — the number of 
queries. Each query is presented by a single line. The only line of the query contains 
four integers k, n, a and b (1 <= k, n <= 10^9, 1 <= b < a <= 10^9) — the initial charge 
of Vova's laptop battery, the number of turns in the game and values a and b, 
correspondingly.

Output
For each query print one integer: -1 if Vova cannot complete the game or the maximum 
number of turns Vova can just play (make the first type turn) otherwise.

---------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C1183_ComputerGame {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int T = in.nextInt();
		while (T-- > 0) {
			long k = in.nextInt();
			long n = in.nextInt();
			long a = in.nextInt();
			long b = in.nextInt();
			
			if (b*n >= k)
				System.out.println(-1);
			else
				System.out.println(binarySearch(k, n, a, b));
		}
	}
	
	public static long binarySearch(long k, long n, long a, long b) {
		long l = 0, r = n;
		while (l < r) {
			if (l+1 == r)
				return r*a + (n-r)*b < k ? r : l;
			long mid = (l+r)/2;
			if ((mid*a + (n-mid)*b) >= k)
				r = mid-1;
			else
				l = mid;
		}
		return l;
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