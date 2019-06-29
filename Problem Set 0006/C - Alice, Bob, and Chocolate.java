/*

C - Alice, Bob, and Chocolate

Alice and Bob like games. And now they are ready to start a new game. They have placed n chocolate 
bars in a line. Alice starts to eat chocolate bars one by one from left to right, and Bob — from 
right to left. For each chocolate bar the time, needed for the player to consume it, is known 
(Alice and Bob eat them with equal speed). When the player consumes a chocolate bar, he immediately 
starts with another. It is not allowed to eat two chocolate bars at the same time, to leave the bar 
unfinished and to make pauses. If both players start to eat the same bar simultaneously, Bob leaves 
it to Alice as a true gentleman. How many bars each of the players will consume?

Input
The first line contains one integer n (1 <= n <= 10^5) — the amount of bars on the table. The second 
line contains a sequence t1, t2, ..., tn (1 <= ti <= 1000), where ti is the time (in seconds) needed 
to consume the i-th bar (in the order from left to right).

Output
Print two numbers a and b, where a is the amount of bars consumed by Alice, and b is the amount of 
bars consumed by Bob.

---------------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C0006_AliceBobAndChocolate {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		int[] candies = new int[n];
		for (int i=0; i<n; i++)
			candies[i] = in.nextInt();
		
		int[] alice = new int[n];
		for (int i=1; i<n; i++)
			alice[i] = candies[i-1] + alice[i-1];
		
		int[] bob = new int[n];
		for (int i=n-2; i>=0; i--)
			bob[i] = candies[i+1] + bob[i+1];
		
		int eatenByAlice = 0, eatenByBob = 0;
		for (int i=0; i<n; i++) {
			if (alice[i] <= bob[i])
				++eatenByAlice;
			else
				++eatenByBob;
		}
		
		System.out.println(eatenByAlice + " " + eatenByBob);
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
