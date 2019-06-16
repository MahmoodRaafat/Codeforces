/*

B - Make Them Equal

You are given a sequence a1, a2, ..., an consisting of n integers. You can choose any 
non-negative integer D (i.e. D >= 0), and for each ai you can: (1) add D (only once), 
i. e. perform ai=ai+D, or (2) subtract D (only once), i. e. perform ai=ai-D, or (3) 
leave the value of ai unchanged. It is possible that after an operation the value ai
becomes negative. Your goal is to choose such minimum non-negative integer D and 
perform changes in such a way, that all ai are equal (i.e. a1=a2=...=an). Print the 
required D or, if it is impossible to choose such value D, print -1. 

Input
The first line of the input contains one integer n (1 <= n <= 100) — the number of 
elements in a. The second line of the input contains n integers a1, a2, ..., an 
(1 <= ai <= 100) — the sequence a.

Output
Print one integer — the minimum non-negative integer value D such that if you add this 
value to some ai, subtract this value from some ai and leave some ai without changes, 
all obtained values become equal. If it is impossible to choose such value D, print -1.

--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1154_MakeThemEqual {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			int num = in.nextInt();
			if (!list.contains(num)) 
				list.add(num);
		}
		
		Collections.sort(list);
		
		if (list.size() > 3)
			System.out.println(-1);
		else if (list.size() == 1)
			System.out.println(0);
		else if (list.size() == 2) {
			int diff = list.get(1) - list.get(0);
			if (diff%2 == 0)
				System.out.println(diff / 2);
			else
				System.out.println(diff);
		}
		else {
			if (list.get(2) - list.get(1) == list.get(1) - list.get(0))
				System.out.println(list.get(2) - list.get(1));
			else
				System.out.println(-1);
		}
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
