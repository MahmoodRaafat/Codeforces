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
Print n integer numbers — rearranged (reordered) input sequence that can be the sequence 
that Polycarp could write down on the board. It is guaranteed that the answer exists.

------------------------------------------------------------------------------------------*/

import java.util.*;
public class D0977_DivideByThreeMultiplyByTwo {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		long[] ans = new long[n];
		boolean[] used = new boolean[n];
		Queue<Long> q = new ArrayDeque<Long>();
		
		for (int i=0; i<n; i++)
			arr[i] = sc.nextLong();
		sc.close();
		
		Arrays.sort(arr);
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++)
				used[j] = false;
			q.add(arr[i]);
			used[i] = true;
			ans[0] = arr[i];
			int place = 1;

			while(!q.isEmpty()) {
				long next = q.poll();
				int nextPos = -1;
				
				// check for arr[i]/3
				if (next%3==0) {
					long T = next/3;
					nextPos = binarySearch(arr, T, 0, n-1);
					if (nextPos>=0 && used[nextPos]==true)
						nextPos = -1;
				}
				
				// check for arr[i]*2
				if (nextPos == -1) {
					long T = next*2;
					nextPos = binarySearch(arr, T, 0, n-1);
					if (nextPos>=0 && used[nextPos]==true)
						nextPos = -1;
				}
				
				// if there is a next element
				if (nextPos != -1 && used[nextPos] == false) {
					q.add(arr[nextPos]);
					used[nextPos] = true;
					ans[place] = arr[nextPos];
					place++;
				}
			}
			
			boolean done = true;
			for (int j=0; j<n; j++) {
				if (used[j] == false) {
					done = false;
					break;
				}
			}
			if (done)
				break;
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(ans[i] + " ");
		}
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
}
