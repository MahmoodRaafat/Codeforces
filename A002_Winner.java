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

import java.util.*;
public class A002_Winner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int rounds = sc.nextInt();
		int[] scores = new int[rounds];
		String[] names = new String[rounds];
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i=0; i<rounds; i++) {
			names[i] = sc.next();
			scores[i] = sc.nextInt();
			
			// find final score of every player using a map
			if (map.containsKey(names[i]))
				map.put(names[i], map.get(names[i]) + scores[i]);
			else
				map.put(names[i], scores[i]);
		}
		sc.close();
		
		// go through names[] to find maxScore at the end of the game
		int maxScore = 0;
		for (int i=0; i<rounds; i++)
			maxScore = Math.max(maxScore, map.get(names[i]));
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		for (int i=0; i<rounds; i++) {
			// if the player did not finish with maxScore, ignore them
			if (map.get(names[i]) < maxScore)
				continue;
			
			// use same process as above with another map, but break when maxScore is reached
			if (map2.containsKey(names[i]))
				map2.put(names[i], map2.get(names[i]) + scores[i]);
			else
				map2.put(names[i], scores[i]);
			if (map2.get(names[i]) >= maxScore) {
				System.out.println(names[i]);
				break;
			}
		}
	}
}