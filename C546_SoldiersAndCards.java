package C;

/*

C - Soldiers and Cards

Two bored soldiers are playing card war. Their card deck consists of exactly n cards, numbered 
from 1 to n, all values are different. They divide cards between them in some manner, it's 
possible that they have different number of cards. Then they play a "war"-like card game. The 
rules are following. On each turn a fight happens. Each of them picks card from the top of his 
stack and puts on the table. The one whose card value is bigger wins this fight and takes both 
cards from the table to the bottom of his stack. More precisely, he first takes his opponent's 
card and puts to the bottom of his stack, and then he puts his card to the bottom of his stack. 
If after some turn one of the player's stack becomes empty, he loses and the other one wins. 
You have to calculate how many fights will happen and who will win the game, or state that game 
won't end.

Input
First line contains a single integer n (2 <= n <= 10), the number of cards. Second line contains 
integer k1 (1 <= k1 <= n-1), the number of the first soldier's cards. Then follow k1 integers 
that are the values on the first soldier's cards, from top to bottom of his stack. The third 
line contains integer k2 (k1 + k2 = n), the number of the second soldier's cards. Then follow 
k2 integers that are the values on the second soldier's cards, from top to bottom of his stack.
All card values are different.

Output
If somebody wins in this game, print 2 integers where the first one stands for the number of 
fights before end of game and the second one is 1 or 2 showing which player has won. If the 
game won't end and will continue forever output -1.

----------------------------------------------------------------------------------------------*/

import java.util.*;
public class C546_SoldiersAndCards {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q1 = new ArrayDeque<Integer>();
		Queue<Integer> q2 = new ArrayDeque<Integer>();
		sc.nextInt(); // n not needed;
		
		int player1 = sc.nextInt();
		for (int i=0; i<player1; i++)
			q1.add(sc.nextInt());
		
		int player2 = sc.nextInt();
		for (int i=0; i<player2; i++)
			q2.add(sc.nextInt());
		sc.close();
		
		int count = 0; // unlikely to end after 100000 rounds
		while(count<100000 && !q1.isEmpty() && !q2.isEmpty()) {
			int firstPlayersCard = q1.poll();
			int secondPlayersCard = q2.poll();
			
			if (firstPlayersCard > secondPlayersCard) {
				q1.add(secondPlayersCard);
				q1.add(firstPlayersCard);
			}
			else {
				q2.add(firstPlayersCard);
				q2.add(secondPlayersCard);
			}
			count++;
		}
		if (count>=100000)
			System.out.print(-1);
		else {
			System.out.print(count);
			if (q1.isEmpty())
				System.out.println(" " + 2);
			else
				System.out.println(" " + 1);
			}
	}
}