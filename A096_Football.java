package A;
/*

A - Football

Petya loves football very much. One day, as he was watching a football match, he was writing 
the players' current positions on a piece of paper. To simplify the situation he depicted it 
as a string consisting of zeroes and ones. A zero corresponds to players of one team; a one 
corresponds to players of another team. If there are at least 7 players of some team standing 
one after another, then the situation is considered dangerous. For example, the situation 
00100110111111101 is dangerous and 11110111011101 is not. You are given the current situation. 
Determine whether it is dangerous or not.

Input
The first input line contains a non-empty string consisting of characters "0" and "1", which 
represents players. The length of the string does not exceed 100 characters. There's at least 
one player from each team present on the field.

Output
Print "YES" if the situation is dangerous. Otherwise, print "NO".

----------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A096_Football {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		
		// count the number of consecutive ints in the string that are the same
		// break once count gets to 7
		int count = 1;
		for (int i=0; i<str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				count++;
				if (count==7)
					break;
			}
			else
				count = 1;
		}
		if (count==7)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
