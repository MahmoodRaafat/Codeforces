/*

A - The Doors

Three years have passes and nothing changed. It is still raining in London, and Mr. 
Black has to close all the doors in his home in order to not be flooded. Once, however, 
Mr. Black became so nervous that he opened one door, then another, then one more and so 
on until he opened all the doors in his house. There are exactly two exits from Mr. 
Black's house, let's name them left and right exits. There are several doors in each of 
the exits, so each door in Mr. Black's house is located either in the left or in the 
right exit. You know where each door is located. Initially all the doors are closed. Mr. 
Black can exit the house if and only if all doors in at least one of the exits is open. 
You are given a sequence in which Mr. Black opened the doors, please find the smallest 
index k such that Mr. Black can exit the house after opening the first k doors. Note 
that Mr. Black opened each door at most once, and in the end all doors became open.

Input
The first line contains integer n (2 <= n <= 200,000) — the number of doors. The next 
line contains n integers: the sequence in which Mr. Black opened the doors. The i-th of 
these integers is equal to 0 in the case that the i-th opened door is located in the 
left exit, and it is equal to 1 in the case that it is in the right exit. It is 
guaranteed that there is at least one door located in the left exit and there is at 
least one door located in the right exit.

Output
Print the smallest integer k such that after Mr. Black opened the first k doors, he was 
able to exit the house.

--------------------------------------------------------------------------------------*/

import java.util.*;
public class A1143_TheDoors {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		sc.close();
		
		int last = arr[n-1], place = n-2;
		while (place >= 0 && arr[place] == last)
			place--;
		
		System.out.println(place+1);
	}
}
