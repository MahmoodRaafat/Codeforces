package A;
/*

Petya loves lucky numbers. We all know that lucky numbers are the positive 
integers whose decimal representations contain only the lucky digits 4 and 7. 
For example, numbers 47, 744, 4 are lucky and 5, 17, 467 are not.

Unfortunately, not all numbers are lucky. Petya calls a number nearly lucky 
if the number of lucky digits in it is a lucky number. He wonders whether 
number n is a nearly lucky number.

Input

The only line contains an integer n (1 <= n <= 10^18).
Please do not use the %lld specificator to read or write 64-bit numbers in C++. 
It is preferred to use the cin, cout streams or the %I64d specificator.

Output
Print on the single line "YES" if n is a nearly lucky number. Otherwise, print 
"NO" (without the quotes).

------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A110_NearlyLuckyNumber { 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong(); // use long b/c could be 10^18
		sc.close();
		
		// turn n into a string (makes it easier to find what each digit is) 
		// count the lucky numbers
		int count = 0;
		String str = Long.toString(n);
		for (int i=0; i<str.length(); i++)
			if (str.charAt(i)=='4' || str.charAt(i)=='7')
				count++;
		
		if (count==7 || count==4) 
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}