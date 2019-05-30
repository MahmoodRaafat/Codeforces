/*

D - Divide By Three, Muliply By Two

Polycarp likes to play with numbers. He takes some integer number x, writes it down on the 
board, and then performs with it n-1 operations of the two kinds: (1) divide the number x 
by 3 (x must be divisible by 3), or (2) multiply the number x by 2. After each operation, 
Polycarp writes down the result on the board and replaces x by the result. So there will 
be n numbers on the board after all. You are given a sequence of length n - the numbers 
that Polycarp wrote down. This sequence is given in arbitrary order, i.e. the order of the 
sequence can mismatch the order of the numbers written on the board. Your problem is to 
rearrange (reorder) elements of this sequence in such a way that it can match possible 
Polycarp's game in the order of the numbers written on the board. I.e. each next number 
will be exactly two times of the previous number or exactly one third of previous number. 
It is guaranteed that the answer exists.

Input
The first line of the input contatins an integer number n (2 <= n <= 100) - the number of 
elements in the sequence. The second line of the input contains n integer numbers a1, a2, 
..., an (1 <= ai <= 3*10^18) - rearranged (reordered) sequence that Polycarp can wrote down 
on the board.

Output
Print n integer numbers - rearranged (reordered) input sequence that can be the sequence 
that Polycarp could write down on the board. It is guaranteed that the answer exists.

------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D0997_DivideByThreeMultiplyByTwo {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		long[] arr = new long[n];
		for (int i=0; i<n; i++)
			arr[i] = in.nextLong();
		
		Arrays.sort(arr);
		
		ArrayList<Long> ans = bfs(n, arr);
		for (long i: ans)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static ArrayList<Long> bfs(int n, long[] arr) {
		ArrayList<Long> ans = new ArrayList<>();
		Queue<Long> q = new ArrayDeque<>();
		
		for (int i=0; i<n; i++) {
			q.add(arr[i]);
			ans.add(arr[i]);
			
			while (!q.isEmpty()) {
				long next = q.poll();
				int pos = -1;
				if (next%3 == 0)
					pos = binarySearch(arr, next/3, 0, n-1);
				if (pos == -1)
					pos = binarySearch(arr, next*2, 0, n-1);
				if (pos != -1) {
					q.add(arr[pos]);
					ans.add(arr[pos]);
				}
			}
			
			if (ans.size() == n)
				return ans;
			ans.clear();
		}
		return ans;
	}

	public static int binarySearch(long[] arr, long T, int L, int R) {
		if (L>R)
			return -1;
		int mid = (R + L)/2;
		if (arr[mid]==T)
			return mid;
		else if (arr[mid] < T)
			return binarySearch(arr, T, mid+1, R);
		else
			return binarySearch(arr, T, L, mid-1);
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
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}