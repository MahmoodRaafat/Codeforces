/*

B - String Typing

You are given a string s consisting of n lowercase Latin letters. You have to type this string 
using your keyboard. Initially, you have an empty string. Until you type the whole string, you may 
perform the following operation: add a character to the end of the string. Besides that, at most 
once you may perform one additional operation: copy the string and append it to itself. For 
example, if you have to type string "abcabca", you can type it in 7 operations if you type all the 
characters one by one. However, you can type it in 5 operations if you type the string "abc" first 
and then copy it and type the last character. If you have to type string aaaaaaaaa, the best option 
is to type 4 characters one by one, then copy the string, and then type the remaining character. 
Print the minimum number of operations you need to type the given string.

Input
The first line of the input containing only one integer number n (1 <= n <= 100) — the length of 
the string you have to type. The second line containing the string s consisting of n lowercase 
Latin letters.

Output
Print one integer number — the minimum number of operations you need to type the given string.

-------------------------------------------------------------------------------------------------*/

import java.util.*;
public class B0954_StringTyping {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		sc.close();
		
		int res = n;
		for (int i=0; i<n/2; i++) {
			String sub = str.substring(0, i+1);
			String copy = str.substring(i+1, 2*(i+1));
			if (sub.equals(copy))
				res = Math.min(res, n-sub.length()+1);
		}
		System.out.println(res);
	}
}
