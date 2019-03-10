/*

B - PolandBall and Game

PolandBall is playing a game with EnemyBall. The rules are simple. Players have to say words 
in turns. You cannot say a word which was already said. PolandBall starts. The Ball which 
can't say a new word loses. You're given two lists of words familiar to PolandBall and 
EnemyBall. Can you determine who wins the game, if both play optimally?

Input
The first input line contains two integers n and m (1 <= n, m <= 10^3) — number of words 
PolandBall and EnemyBall know, respectively. Then n strings follow, one per line — words 
familiar to PolandBall. Then m strings follow, one per line — words familiar to EnemyBall. 
Note that one Ball cannot know a word more than once (strings are unique), but some words 
can be known by both players. Each word is non-empty and consists of no more than 500 
lowercase English alphabet letters. 

Output
In a single line of print the answer — "YES" if PolandBall wins and "NO" otherwise. Both 
Balls play optimally.

-------------------------------------------------------------------------------------------*/

import java.util.*;
public class B755_PolandBallAndGame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<String> PB = new ArrayList<String>();
		int same = 0;
		
		for (int i=0; i<n; i++)
			PB.add(sc.next());

		for (int i=0; i<m; i++) {
			String str = sc.next();
			if (PB.contains(str))
				same++;
		}
		sc.close();
		
		if (same%2==0) {
			if (n > m)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else {
			if (n >= m)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}