/*

C - Doors Breaking and Repairing

You are policeman and you are playing a game with Slavik. The game is turn-based and each turn 
consists of two phases. During the first phase you make your move and during the second phase 
Slavik makes his move. There are n doors, the i-th door initially has durability equal to ai. 
During your move you can try to break one of the doors. If you choose door i and its current 
durability is bi then you reduce its durability to max (0, bi-x) (the value x is given). During 
Slavik's move he tries to repair one of the doors. If he chooses door i and its current durability 
is bi then he increases its durability to bi+y (the value y is given). Slavik cannot repair doors 
with current durability equal to 0. The game lasts 10100 turns. If some player cannot make his move
then he has to skip it. Your goal is to maximize the number of doors with durability equal to 0 at
the end of the game. You can assume that Slavik wants to minimize the number of such doors. What 
is the number of such doors in the end if you both play optimally?
 
Input
The first line of the input contains three integers n, x, and y (1 <= n <= 100, 1 <= x, y <= 10^5) 
- the number of doors, value x and value y, respectively. The second line of the input contains n 
integers a1, a2, ..., an (1 <= ai <= 10^5), where ai is the initial durability of the i-th door.

Output
Print one integer — the number of doors with durability equal to 0 at the end of the game, if you 
and Slavik both play optimally.

-------------------------------------------------------------------------------------------------*/

import java.util.*;
public class C1102_DoorsBreakingAndRepairing {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int[] durability = new int[n];
		for (int i=0; i<n; i++)
			durability[i] = sc.nextInt();
		sc.close();
		
		if (x > y) {
			System.out.println(n);
			return;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			if (durability[i] <= x) {
				list.add(durability[i]); // the doors I can break in 1 move
			}
		}
		
		Collections.sort(list);
		
		int res = 0;
		while (list.size() > 0) {
			
			// my turn
			list.remove(0);
			res++;
			if (list.size()==0)
				break;
			
			// Slavik's turn
			int a = list.get(list.size()-1);
			if (a+y > x)
				list.remove(list.size()-1);
			else
				list.add(list.size()-1, a+y);
		}
		System.out.println(res);		
	}
}