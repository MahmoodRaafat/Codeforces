/*

C - Gourmet Cat

Polycarp has a cat and his cat is a real gourmet! Dependent on a day of the week he eats 
certain type of food: on Mondays, Thursdays and Sundays he eats fish food; on Tuesdays 
and Saturdays he eats rabbit stew; on other days of week he eats chicken stake. Polycarp 
plans to go on a trip and already packed his backpack. His backpack contains: a daily 
rations of fish food; b daily rations of rabbit stew; c daily rations of chicken stakes.
Polycarp has to choose such day of the week to start his trip that his cat can eat 
without additional food purchases as long as possible. Print the maximum number of days 
the cat can eat in a trip without additional food purchases, if Polycarp chooses the day 
of the week to start his trip optimally.

Input
The first line of the input contains three positive integers a, b and c 
(1 <= a,b,c <= 7*10^8) — the number of daily rations of fish food, rabbit stew and 
chicken stakes in Polycarps backpack correspondingly.

Output
Print the maximum number of days the cat can eat in a trip without additional food 
purchases, if Polycarp chooses the day of the week to start his trip optimally.

------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C1154_GourmetCat {
	
	static final int[] week = {0, 0, 1, 2, 0, 2, 1};
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		int fullWeeks = findNumFullWeeks(a, b, c);
		int res = fullWeeks*7;
		a -= fullWeeks*3;
		b -= fullWeeks*2;
		c -= fullWeeks*2;
		
		int maxRem = 0;
		for (int i=0; i<7; i++)
			maxRem = Math.max(maxRem, findRem(i, a, b, c));
		
		System.out.println(res + maxRem);
	}
	
	public static int findRem(int day, int a, int b, int c) {
		int[] arr = {a, b, c};
		int rem = 0;
		while (true) {
			if (arr[week[day]] == 0)
				break;
			++rem;
			--arr[week[day++]];
			
			if (day > 6)
				day = 0;
		}
		
		return rem;
	}
	
	public static int findNumFullWeeks(int a, int b, int c) {
		int[] div = new int[3];
		div[0] = a/3;
		div[1] = b/2;
		div[2] = c/2;
		Arrays.sort(div);
		return div[0];
	}
	
	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}
		
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
