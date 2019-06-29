/*

A - Winner

The winner of the card game popular in Berland "Berlogging" is determined according 
to the following rules. If at the end of the game there is only one player with the 
maximum number of points, he is the winner. The situation becomes more difficult if 
the number of such players is more than one. During each round a player gains or 
loses a particular number of points. In the course of the game the number of points 
is registered in the line "name score", where name is a player's name, and score is 
the number of points gained in this round, which is an integer number. If score is 
negative, this means that the player has lost in the round. So, if two or more 
players have the maximum number of points (say, it equals to m) at the end of the 
game, than wins the one of them who scored at least m points first. Initially each 
player has 0 points. It's guaranteed that at the end of the game at least one player 
has a positive number of points.

Input
The first line contains an integer number n (1 <= n <= 1000), n is the number of 
rounds played. Then follow n lines, containing the information about the rounds in 
"name score" format in chronological order, where name is a string of lower-case 
Latin letters with the length from 1 to 32, and score is an integer number between 
-1000 and 1000, inclusive.

Output
Print the name of the winner.

------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class A0002_Winner {
	
	static class Round {
		String player;
		int score;
		
		public Round(String p, int s) {
			player = p;
			score = s;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		Map<String, Integer> map = new HashMap<>();
		Round[] rounds = new Round[n];
		for (int i=0; i<n; i++) {
			String player = in.next();
			int score = in.nextInt();
			rounds[i] = new Round(player, score);
			if (!map.containsKey(player))
				map.put(player, 0);
			map.put(player, map.get(player) + score);
		}
		
		int maxScore = 0;
		for (String player: map.keySet())
			maxScore = Math.max(maxScore, map.get(player));
		
		Map<String, Integer> map2 = new HashMap<>();
		for (Round r: rounds) {
			if (!map2.containsKey(r.player))
				map2.put(r.player, 0);
			map2.put(r.player, map2.get(r.player) + r.score);
			if (map2.get(r.player) >= maxScore) {
				if (map.get(r.player) == maxScore) {
					System.out.println(r.player);
					System.exit(0);
				}
			}
		}
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