/*

A - Definite Game

Chouti was doing a competitive programming competition. However, after having all the 
problems accepted, he got bored and decided to invent some small games. He came up with 
the following game. The player has a positive integer n. Initially the value of n equals 
to v and the player is able to do the following operation as many times as the player 
want (possibly zero): choose a positive integer x that x<n and x is not a divisor of n, 
then subtract x from n. The goal of the player is to minimize the value of n in the end.
Soon, Chouti found the game trivial. Can you also beat the game?

Input
The input contains only one integer in the first line: v (1 <= v <= 10^9), the initial 
value of n.

Output
Output a single integer, the minimum value of n the player can get.

----------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A1081_DefiniteGame {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		System.out.println(n == 2 ? 2 : 1);
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
