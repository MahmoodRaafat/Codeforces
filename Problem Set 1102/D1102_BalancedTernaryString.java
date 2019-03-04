/*

D - Balanced Ternary String

You are given a string s consisting of exactly n characters, and each character is either '0',
'1' or '2'. Such strings are called ternary strings. Your task is to replace minimum number 
of characters in this string with other characters to obtain a balanced ternary string 
(balanced ternary string is a ternary string such that the number of characters '0' in this 
string is equal to the number of characters '1', and the number of characters '1' (and '0' 
obviously) is equal to the number of characters '2'). Among all possible balanced ternary 
strings you have to obtain the lexicographically (alphabetically) smallest. Note that you can
neither remove characters from the string nor add characters to the string. Also note that 
you can replace the given characters only with characters '0', '1' and '2'. It is guaranteed 
that the answer exists.

Input
The first line of the input contains one integer n (3 <= n <= 3*10^5, n is divisible by 3) — 
the number of characters in s. The second line contains the string s consisting of exactly n
characters '0', '1' and '2'.

Output
Print one string — the lexicographically (alphabetically) smallest balanced ternary string 
which can be obtained from the given one with minimum number of replacements. Because n is 
divisible by 3 it is obvious that the answer exists. And it is obvious that there is only one 
possible answer.

---------------------------------------------------------------------------------------------*/

import java.util.*;
public class D1102_BalancedTernaryString {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		sc.close();
		
		char str[] = s.toCharArray();
		int[] arr = new int[3];
		for (int i=0; i<n; i++) {
			if (str[i] == '0')
				arr[0]++;
			else if (str[i] == '1')
				arr[1]++;
			else
				arr[2]++;
		}
		
		if (arr[0] < n/3) {
			for (int i=0; i<n; i++) {
				if (arr[0] == n/3)
					break;
				if (str[i] == '1' && arr[1] > n/3) {
					str[i] = '0';
					arr[0]++;
					arr[1]--;
				}
				if (str[i] == '2' && arr[2] > n/3) {
					str[i] = '0';
					arr[0]++;
					arr[2]--;
				}
			}
		}
		
		if (arr[2] < n/3) {
			for(int i=n-1; i>=0; i--) {
				if (arr[2] == n/3) 
					break;
				if (str[i]=='1' && arr[1] > n/3) {
					str[i] = '2'; 
					arr[1]--;
					arr[2]++;
				}
				if (str[i]=='0' && arr[0] > n/3) {
					str[i] = '2'; 
					arr[0]--; 
					arr[2]++;
				}
			}
		}
		
		if(arr[1] < n/3) {
			for (int i=0; i<n; i++) {
				if (str[i]=='2' && arr[2] > n/3) {
					str[i] = '1';
					arr[2]--;
					arr[1]++;
				}
			}
			for(int i=n-1; i>=0; i--) {
				if(str[i]=='0' && arr[0] > n/3) {
					str[i] = '1';
					arr[0]--;
					arr[1]++;
				}
			}
		}
		
		System.out.println(new String(str));
	}
}