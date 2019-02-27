/*

B - Draw!

You still have partial information about the score during the historic football match. You are given a set of 
pairs (ai,bi), indicating that at some point during the match the score was "ai: bi". It is known that if the 
current score is «x:y», then after the goal it will change to "x+1:y" or "x:y+1". What is the largest number 
of times a draw could appear on the scoreboard? The pairs "ai:bi" are given in chronological order (time 
increases), but you are given score only for some moments of time. The last pair corresponds to the end of 
the match.

Input
The first line contains a single integer n (1 <=n <= 10000) - the number of known moments in the match. Each of 
the next n lines contains integers ai and bi (0 <= ai, bi <= 10^9), denoting the score of the match at that 
moment (that is, the number of goals by the first team and the number of goals by the second team). All 
moments are given in chronological order, that is, sequences xi and yj are non-decreasing. The last score denotes 
the final result of the match.

Output
Print the maximum number of moments of time, during which the score was a draw. The starting moment of the match 
(with a score 0:0) is also counted.

---------------------------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class B1131_Draw {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int res = 1, prevX = 0, prevY = 0;
		for (int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if (x>prevX || y>prevY) {
				int maxOld = Math.max(prevX, prevY);
				int minNew = Math.min(x, y);
				
				if (x==y) {
					res += x-Math.max(prevX, prevY);
					if (prevX != prevY)
						res++;
				}
				else if (maxOld==minNew) {
					if (minNew==x) {
						if (prevX != x)
							res++;
						else {
							if (prevY < minNew)
								res++;
						}
					}
					else if (minNew==y) {
						if (prevY != y)
							res++;
						else {
							if (prevX < minNew)
								res++;
						}
						
					}
				}
				else if (maxOld < minNew) {
					res += minNew-maxOld;
					if (prevX != prevY)
						res++;
				}
			}
			prevX = x; 
			prevY = y;
		}
		
		System.out.println(res);
		sc.close();
	}
}