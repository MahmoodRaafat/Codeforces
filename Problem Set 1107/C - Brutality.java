/*

C - Brutality

You are playing a new famous fighting game: Kortal Mombat XII. You have to perform a 
brutality on your opponent's character. You are playing the game on the new generation 
console so your gamepad has 26 buttons. Each button has a single lowercase Latin letter 
from 'a' to 'z' written on it. All the letters on buttons are pairwise distinct. You are 
given a sequence of hits, the i-th hit deals ai units of damage to the opponent's 
character. To perform the i-th hit you have to press the button si on your gamepad. Hits 
are numbered from 1 to n. You know that if you press some button more than k times in a 
row then it'll break. You cherish your gamepad and don't want to break any of its buttons. 
To perform a brutality you have to land some of the hits of the given sequence. You are 
allowed to skip any of them, however changing the initial order of the sequence is 
prohibited. The total damage dealt is the sum of ai over all i for the hits which weren't 
skipped. Note that if you skip the hit then the counter of consecutive presses the button 
won't reset. Your task is to skip some hits to deal the maximum possible total damage to 
the opponent's character and not break your gamepad buttons.

Input
The first line of the input contains two integers n and k (1 <= k <= n <= 2*10^5) — the 
number of hits and the maximum number of times you can push the same button in a row. The 
second line of the input contains n integers a1, a2, ..., an (1 <= ai <= 10^9), where ai 
is the damage of the i-th hit. The third line of the input contains the string s 
consisting of exactly n lowercase Latin letters — the sequence of hits (each character is 
the letter on the button you need to press to perform the corresponding hit).

Output
Print one integer dmg — the maximum possible damage to the opponent's character you can 
deal without breaking your gamepad buttons.

------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C1107_Brutality {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] arr = new int[n];
		for (int i=0; i<n; i++)
			arr[i] = in.nextInt();
		
		String str = in.next();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int p1 = 0, p2 = 0;
		long res = 0;
		for (int i=0; i<n; i++) {
			long sum = 0;
			while (p2 < n && str.charAt(p1) == str.charAt(p2)) {
				sum += arr[p2];
				pq.add(arr[p2]);
				++p2;
			}
			if (pq.size() > k)
				while (pq.size() > k)
					sum -= pq.poll();
			res += sum;
			p1 = p2;
			pq.clear();
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
