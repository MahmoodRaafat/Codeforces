/*

A - Amusing Joke

So, the New Year holidays are over. Santa Claus and his colleagues can take a rest and 
have guests at last. When two "New Year and Christmas Men" meet, thear assistants cut 
out of cardboard the letters from the guest's name and the host's name in honor of this 
event. Then the hung the letters above the main entrance. One night, when everyone went 
to bed, someone took all the letters of our characters' names. Then he may have shuffled 
the letters and put them in one pile in front of the door.
The next morning it was impossible to find the culprit who had made the disorder. But 
everybody wondered whether it is possible to restore the names of the host and his 
guests from the letters lying at the door? That is, we need to verify that there are no 
extra letters, and that nobody will need to cut more letters.
Help the "New Year and Christmas Men" and their friends to cope with this problem. You 
are given both inscriptions that hung over the front door the previous night, and a pile 
of letters that were found at the front door next morning.

Input
The input file consists of three lines: the first line contains the guest's name, the 
second line contains the name of the residence host and the third line contains letters 
in a pile that were found at the door in the morning. All lines are not empty and contain 
only uppercase Latin letters. The length of each line does not exceed 100.

Output
Print "YES" without the quotes, if the letters in the pile could be permuted to make the 
names of the "New Year and Christmas Men". Otherwise, print "NO" without the quotes.

----------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A0141_AmusingJoke {
	static String pile;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		pile = sc.next();
		sc.close();
		
		// if pile contains all letters from 2 strings and nothing is left
		if (hasLetters(str1) && hasLetters(str2) && pile.equals(""))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	// determines if all the letters of a string are in the pile
	public static boolean hasLetters(String str) {
		boolean[] used = new boolean[pile.length()];
		for (int i=0; i<str.length(); i++) {
			boolean hasLetter = false;
			for (int j=0; j<pile.length(); j++) {
				if (str.charAt(i)==pile.charAt(j) && !used[j]) {
					hasLetter = true;
					used[j] = true;
					break;
				}
			}
			if (!hasLetter)
				return false;
		}
		removeLetters(used);
		return true;
	}
	
	// if so, remove them from pile
	public static void removeLetters(boolean[] used) {
		String res = "";
		for (int i=0; i<pile.length(); i++)
			if (!used[i])
				res += pile.charAt(i);
		pile = res;
	}
}
