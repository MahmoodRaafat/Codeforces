package Over1000;
/*

A - Palindromic Twist

You are given a string s consisting of n lowercase Latin letters. n is even. For each position i 
(1 <= i <= n) in string s you are required to change the letter on this position either to the 
previous letter in alphabetic order or to the next one (letters 'a' and 'z' have only one of these 
options). Letter in every position must be changed exactly once. For example, letter 'p' should be 
changed either to 'o' or to 'q', letter 'a' should be changed to 'b' and letter 'z' should be 
changed to 'y'. String s is called a palindrome if it reads the same from left to right and from 
right to left. For example, strings "abba" and "zz" are palindromes and strings "abca" and "zy" are 
not. Your goal is to check if it's possible to make string s a palindrome by applying the 
aforementioned changes to every position. Print "YES" if string s can be transformed to a palindrome 
and "NO" otherwise. Each testcase contains several strings, for each of them you are required to 
solve the problem separately.

Input
The first line contains a single integer T (1 <= T <= 50) - the number of strings in a testcase. 
Then 2T lines follow — lines (2i-1) and 2i of them describe the i-th string. The first line of the 
pair contains a single integer n (2 <= n <= 100, n is even) — the length of the corresponding string. 
The second line of the pair contains a string s, consisting of n lowercase Latin letters.

Output
Print T lines. The i-th line should contain the answer to the i-th string of the input. Print "YES" 
if it's possible to make the i-th string a palindrome by applying the aforementioned changes to every 
position. Print "NO" otherwise.

-----------------------------------------------------------------------------------------------------*/

import java.util.*;
public class A1027_PalindromicTwist {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i=0; i<t; i++) {
			int n = sc.nextInt();
			String str = sc.next();
			boolean done = false;
			
			for (int j=0; j<(n/2); j++) {
				int a = (int) str.charAt(j);
				int b = (int) str.charAt(str.length()-1-j);
				if (Math.abs(a-b)==1 || Math.abs(a-b)>2) {
					System.out.println("NO");
					done = true;
					break;
				}
			}
			if (!done)
				System.out.println("YES");
		}
		sc.close();
	}
}