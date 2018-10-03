package A;
/*

A - Chat Room

Vasya has recently learned to type and log on to the Internet. He immediately entered a chat 
room and decided to say hello to everybody. Vasya typed the word s. It is considered that 
Vasya managed to say hello if several letters can be deleted from the typed word so that it 
resulted in the word "hello". For example, if Vasya types the word "ahhellllloou", it will 
be considered that he said hello, and if he types "hlelo", it will be considered that Vasya 
got misunderstood and he didn't manage to say hello. Determine whether Vasya managed to say 
hello by the given word s.

Input
The first and only line contains the word s, which Vasya typed. This word consisits of small 
Latin letters, its length is no less that 1 and no more than 100 letters.

Output
If Vasya managed to say hello, print "YES", otherwise print "NO".

-------------------------------------------------------------------------------------------*/

import java.util.*;
public class A058_ChatRoom {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		sc.close();
		
		int cur = 0;
		boolean spellsHello = false;
		char[] hello = {'h', 'e', 'l', 'l', 'o'};
		
		// loop through the word hello, checking the letters of the word (s) in the process
		// cur marks spot in word (s) (never goes backwards and never checks same letter twice)
		for (int i=0; i<5; i++) {
			boolean hasHello = false; // checks if letter of hello was in word after cur
			for (int j=cur; j<word.length(); j++) {
				if (word.charAt(j)==hello[i]) {
					hasHello = true;
					cur = j+1;
					if (i==4)
						spellsHello = true; // only true if has all letters of hello in order
					break;
				}
			}
			if (!hasHello)
				break;
			hasHello = false;
		}
		if (spellsHello) 
			System.out.println("YES");
		else {
			System.out.println("NO");
		}
	}
}