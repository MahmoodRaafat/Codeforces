/*

B - Lost Numbers

This is an interactive problem. Remember to flush your output while communicating with 
the testing program. (system.out.flush() in Java). The jury guessed some array a
consisting of 6 integers. There are 6 special numbers — 4, 8, 15, 16, 23, 42 — and each 
of these numbers occurs in a exactly once (so, a is some permutation of these numbers).
You don't know anything about their order, but you are allowed to ask up to 4
queries. In each query, you may choose two indices i and j (1 <= i,j <= 6, i and j are 
not necessarily distinct), and you will get the value of ai*aj in return.

Interaction
Before submitting the answer, you may ask up to 4 queries. To ask a query, print one 
line in the following format: ? i j, where i and j should be two integers such that 
1 <= i,j <= 6. The line should be ended with a line break character. After submitting a 
query, flush the output and read the answer to your query — one line containing one 
integer ai*aj. If you submit an incorrect query (or ask more than 4 queries), the 
answer to it will be one string 0. After receiving such an answer, your program should 
terminate immediately. To give the answer, your program should print one line - 
"! a1 a2 a3 a4 a5 a6" with a line break in the end. After that, it should flush the 
output and terminate.

---------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1167_LostNumbers {
	static final int[] nums = {4, 8, 15, 16, 23, 42};
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int[] ans = new int[6];
		
		System.out.println("? 1 2");
		System.out.flush();
		int q1 = in.nextInt();
		System.out.println("? 2 3");
		System.out.flush();
		int q2 = in.nextInt();
		int[] arr1 = findNums(q1);
		int[] arr2 = findNums(q2);
		ans[1] = (arr2[0] == arr1[0] || arr2[1] == arr1[0]) ? arr1[0] : arr1[1];
		ans[0] = ans[1] == arr1[0] ? arr1[1] : arr1[0];
		ans[2] = ans[1] == arr2[0] ? arr2[1] : arr2[0];
		
		System.out.println("? 4 5");
		System.out.flush();
		q1 = in.nextInt();
		System.out.println("? 5 6");
		System.out.flush();
		q2 = in.nextInt();
		arr1 = findNums(q1);
		arr2 = findNums(q2);
		ans[4] = (arr2[0] == arr1[0] || arr2[1] == arr1[0]) ? arr1[0] : arr1[1];
		ans[3] = ans[4] == arr1[0] ? arr1[1] : arr1[0];
		ans[5] = ans[4] == arr2[0] ? arr2[1] : arr2[0];
		
		System.out.print("! ");
		for (int i: ans)
			System.out.print(i + " ");
		System.out.println();
		System.out.flush();
		System.exit(0);
	}
	
	public static int[] findNums(int q) {
		int[] arr = new int[2];
		for (int i=0; i<5; i++) {
			for (int j=i+1; j<6; j++) if (nums[i]*nums[j] == q) {
				arr[0] = nums[i];
				arr[1] = nums[j];
			}
		}
		return arr;
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
