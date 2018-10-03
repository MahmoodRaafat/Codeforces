package A;
/*

A - Domino Piling

You are given a rectangular board of M x N squares. Also you are given an unlimited 
number of standard domino pieces of 2 x 1 squares. You are allowed to rotate the pieces. 
You are asked to place as many dominoes as possible on the board so as to meet the 
following conditions:
1. Each domino completely covers two squares.
2. No two dominoes overlap.
3. Each domino lies entirely inside the board. It is allowed to touch the edges of the board.
Find the maximum number of dominoes, which can be placed under these restrictions.

Input
In a single line you are given two integers M and N - board sizes in squares (1 <= M <= N <= 16).

Output
Output one number - the maximal number of dominoes, which can be placed.

-----------------------------------------------------------------------------------------------*/

import java.util.*;
public class A050_DominoPiling {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		// if one of the side lengths (n) is even, n/2 dominoes can lay flat
		// multiply by the other dimension for total # of dominoes
		int result = 0;
		if (n%2==0)
			result = (n/2)*m;
		else if (m%2==0)
			result = (m/2)*n;
			
		// if both sides have an odd side length
		// do same calculation as above but add (m/2) for the row not covered
		else
			result = (n/2)*m + (m/2);
		
		System.out.println(result);
	}
}
