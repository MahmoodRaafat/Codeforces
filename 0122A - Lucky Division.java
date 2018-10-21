/*

A - Lucky Division

Petya loves lucky numbers. Everybody knows that lucky numbers are positive integers whose 
decimal representation contains only the lucky digits 4 and 7. For example, numbers 47, 744, 
4 are lucky and 5, 17, 467 are not.
Petya calls a number almost lucky if it could be evenly divided by some lucky number. Help 
him find out if the given number n is almost lucky.

Input
The single line contains an integer n (1 <= n <= 1000) — the number that needs to be checked.

Output
In the only line print "YES" (without the quotes), if number n is almost lucky. Otherwise, 
print "NO" (without the quotes).

---------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A0122_LuckyDivision {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean isNearlyLucky = false;
		sc.close();
		
		if (isLucky(n)) 
			System.out.println("YES");
		else {
			for (int i=0; i<n; i++) {
				if (n%i==0 && isLucky(i))	{
					isNearlyLucky = true;
					break;
				}
			}
			if (isNearlyLucky) 
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
	
	public static boolean isLucky(int n) {
		String num = Integer.toString(n);
		for (int i=0; i<num.length(); i++)
			if (num.charAt(i) != '4' && num.charAt(i) != '7')
				return false;
		return true;
	}
}
