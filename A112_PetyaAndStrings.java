package A;
/*

A - Petya and Strings

Little Petya loves presents. His mum bought him two strings of the same size 
for his birthday. The strings consist of uppercase and lowercase Latin letters. 
Now Petya wants to compare those two strings lexicographically. The letters' 
case does not matter, that is an uppercase letter is considered equivalent to 
the corresponding lowercase letter. Help Petya perform the comparison.

Input
Each of the first two lines contains a bought string. The strings' lengths range 
from 1 to 100 inclusive. It is guaranteed that the strings are of the same length 
and also consist of uppercase and lowercase Latin letters.

Output
If the first string is less than the second one, print "-1". If the second string 
is less than the first one, print "1". If the strings are equal, print "0". Note 
that the letters' case is not taken into consideration when the strings are compared.

--------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A112_PetyaAndStrings {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String A = sc.next(), B = sc.next();
		sc.close();
		
		// case does not matter
		A = A.toLowerCase();
		B = B.toLowerCase();
		
		// gives lexicographical comparison of A to B
		int result = A.compareTo(B);
		
		if (result > 0) 
			result = 1;
		if (result < 0) 
			result = -1;
		
		System.out.println(result);
	}
}