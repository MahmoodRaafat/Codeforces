/*

B - Parity Alternated Deletions

Polycarp has an array a consisting of n integers. He wants to play a game with this array. 
The game consists of several moves. On the first move he chooses any element and deletes it 
(after the first move the array contains n-1 elements). For each of the next moves he chooses 
any element with the only restriction: its parity should differ from the parity of the 
element deleted on the previous move. In other words, he alternates parities of the removed 
elements. Polycarp stops if he can't make a move. Formally:
  If it is the first move, he chooses any element and deletes it;
  If it is the second or any next move:
    if the last deleted element was odd, Polycarp chooses any even element and deletes it;
    if the last deleted element was even, Polycarp chooses any odd element and deletes it. 
  If after some move Polycarp cannot make a move, the game ends. 
Polycarp's goal is to minimize the sum of non-deleted elements of the array after end of the 
game. If Polycarp can delete the whole array, then the sum of non-deleted elements is zero.
Help Polycarp find this value.

Input
The first line of the input contains one integer n (1 <= n <= 2000) — the number of elements 
of a. The second line of the input contains n integers a1, a2, ..., an (0 <= ai <= 10^6), 
where ai is the i-th element of a.

Output
Print one integer — the minimum possible sum of non-deleted elements of the array after end 
of the game.

--------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1144_ParityAlternatedDeletions {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		
		int n = in.nextInt();
		ArrayList<Integer> evens = new ArrayList<Integer>();
		ArrayList<Integer> odds = new ArrayList<Integer>();
		
		int totalSum = 0;
		for (int i=0; i<n; i++) {
			int num = in.nextInt();
			if (num%2==0)
				evens.add(num);
			else
				odds.add(num);
			totalSum += num;
		}
		
		if (Math.abs(evens.size() - odds.size()) <= 1)
			System.out.println(0);
		else {
			Collections.sort(evens);
			Collections.sort(odds);
			
			if (evens.size() > odds.size())
				totalSum = subtract(evens, odds, totalSum);
			else
				totalSum = subtract(odds, evens, totalSum);
			
			System.out.println(totalSum);
		}
	}
	
	public static int subtract(ArrayList<Integer> first, ArrayList<Integer> second, int totalSum) {
		int fSize = first.size(), sSize = second.size();
		for (int i=fSize-1; i>=fSize-sSize-1; i--)
			totalSum -= first.get(i);
		for (int num: second)
			totalSum -= num;
		return totalSum;
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