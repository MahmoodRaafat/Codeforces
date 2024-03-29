/*

A - Diagonal Walking

Mikhail walks on a 2D plane. He can go either up or right. You are given a sequence of Mikhail's 
moves. He thinks that this sequence is too long and he wants to make it as short as possible. In 
the given sequence moving up is described by character U and moving right is described by character 
R. Mikhail can replace any pair of consecutive moves RU or UR with a diagonal move (described as 
character D). After that, he can go on and do some other replacements, until there is no pair of 
consecutive moves RU or UR left. Your problem is to print the minimum possible length of the 
sequence of moves after the replacements.

Input
The first line of the input contains one integer n (1 <= n <= 100) — the length of the sequence. 
The second line contains the sequence consisting of n characters U and R.

Output
Print the minimum possible length of the sequence of moves after all replacements are done.

-------------------------------------------------------------------------------------------------*/

import java.util.*;
public class A0954_DiagonalWalking {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		sc.close();
		
		int res = n;
		for (int i=0; i<n-1; i++) {
			if (str.charAt(i) != str.charAt(i+1)) {
				res--;
				i++;
			}
		}
		System.out.println(res);
	}
}
