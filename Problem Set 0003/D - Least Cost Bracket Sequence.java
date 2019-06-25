/*

D - Least Cost Bracket Sequence

This is yet another problem on regular bracket sequences.

A bracket sequence is called regular, if by inserting "+" and "1" into it we get a correct 
mathematical expression. For example, sequences "(())()", "()" and "(()(()))" are regular, 
while ")(", "(()" and "(()))(" are not. You have a pattern of a bracket sequence that 
consists of characters "(", ")" and "?". You have to replace each character "?" with a 
bracket so, that you get a regular bracket sequence. For each character "?" the cost of 
its replacement with "(" and ")" is given. Among all the possible variants your should 
choose the cheapest.

Input
The first line contains a non-empty pattern of even length, consisting of characters "(",
")" and "?". Its length doesn't exceed 5*10^4. Then there follow m lines, where m is the 
number of characters "?" in the pattern. Each line contains two integer numbers ai and bi 
(1 <= ai, bi <= 10^6), where ai is the cost of replacing the i-th character "?" with an 
opening bracket, and bi — with a closing one.

Output
Print the cost of the optimal regular bracket sequence in the first line, and the required 
sequence in the second. Print -1, if there is no answer. If the answer is not unique, print 
any of them. 

-------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D0003_LeastCostBracketSequence {
	
	static class Bracket implements Comparable<Bracket> {
		int index;
		int open;
		int close;
		
		public Bracket(int i, int o, int c) {
			index = i;
			open = o;
			close = c;
		}
		
		public int compareTo(Bracket b) {
			return Integer.compare(open - close, b.open - b.close);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		char[] arr = in.next().toCharArray();
		int n = arr.length;
		
		PriorityQueue<Bracket> pq = new PriorityQueue<>();
		long balance = 0, totalCost = 0;
		for (int i=0; i<n; i++) {
			if (arr[i] == '(')
				++balance;
			else if (arr[i] == ')')
				--balance;
			else {
				Bracket b = new Bracket(i, in.nextInt(), in.nextInt());
				pq.add(b);
				totalCost += b.close;
				arr[i] = ')';
				--balance;
			}
			
			if (balance < 0) {
				if (pq.isEmpty()) 
					break;
				Bracket b = pq.poll();
				arr[b.index] = '(';
				totalCost -= b.close;
				totalCost += b.open;
				balance += 2;
			}
		}
		
		if (balance != 0)
			System.out.println(-1);
		else {
			StringBuffer sb = new StringBuffer();
			sb.append(totalCost + "\n");
			for (char c: arr)
				sb.append(c);
			System.out.println(sb);
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
