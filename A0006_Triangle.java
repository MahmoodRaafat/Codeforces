/*

A - Triangle

Johnny has a younger sister Anne, who is very clever and smart. As she came home from the kindergarten, she told 
his brother about the task that her kindergartener asked her to solve. The task was just to construct a triangle 
out of four sticks of different colors. Naturally, one of the sticks is extra. It is not allowed to break the 
sticks or use their partial length. Anne has perfectly solved this task, now she is asking Johnny to do the same.
The boy answered that he would cope with it without any difficulty. However, after a while he found out that 
different tricky things can occur. It can happen that it is impossible to construct a triangle of a positive area, 
but it is possible to construct a degenerate triangle. It can be so, that it is impossible to construct a 
degenerate triangle even. As Johnny is very lazy, he does not want to consider such a big amount of cases, he asks 
you to help him.

Input
The first line of the input contains four space-separated positive integer numbers not exceeding 100 — lengths of 
the sticks.

Output
Output TRIANGLE if it is possible to construct a non-degenerate triangle. Output SEGMENT if the first case cannot 
take place and it is possible to construct a degenerate triangle. Output IMPOSSIBLE if it is impossible to 
construct any triangle. Remember that you are to use three sticks. It is not allowed to break the sticks or use 
their partial length.

-----------------------------------------------------------------------------------------------------------------*/

import java.util.*;
public class A0006_Triangle {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] sticks = new int[4];
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> ans = new ArrayList<String>();
		
		for (int i=0; i<4; i++) {
			sticks[i] = sc.nextInt();
			list.add(Integer.toString(sticks[i]));
		}
		
		for (int i=0; i<4; i++) {
			// remove one stick, find best possible triangle with remaining three, add it back
			// change sticks[i] to string b/c list.remove() will read it as an index 
			list.remove(Integer.toString(sticks[i]));
			ans.add(bestTriangle(list));
			list.add(Integer.toString(sticks[i]));
		}
		
		printAns(ans);
		sc.close();
	}
	
	public static String bestTriangle(ArrayList<String> list) {
		// change strings back to integers
		int[] arr = {Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2))};
		
		int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
		int mid = 0;
		int min = Math.min(arr[0], Math.min(arr[1], arr[2]));
		
		// find mid
		if (arr[0]==max) mid = Math.max(arr[1], arr[2]);
		if (arr[1]==max) mid = Math.max(arr[0], arr[2]);
		if (arr[2]==max) mid = Math.max(arr[1], arr[0]);
		
		// determine the best possible triangle
		if (max < mid + min)
			return "TRIANGLE";
		else if (max == mid + min)
			return "SEGMENT";
		else
			return "IMPOSSIBLE";
	}
	
	public static void printAns(ArrayList<String> ans) {
		if (ans.contains("TRIANGLE"))
			System.out.println("TRIANGLE");
		else if (ans.contains("SEGMENT"))
			System.out.println("SEGMENT");
		else
			System.out.println("IMPOSSIBLE");
	}
}