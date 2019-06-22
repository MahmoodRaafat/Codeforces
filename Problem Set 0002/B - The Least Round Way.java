/*

B - The Least Round Way

There is a square matrix nxn, consisting of non-negative integer numbers. You 
should find such a way on it that starts in the upper left cell of the matrix,
each following cell is to the right or down from the current cell, and the way 
ends in the bottom right cell. Moreover, if we multiply together all the numbers 
along the way, the result should be the least "round". In other words, it should 
end in the least possible number of zeros.

Input
The first line contains an integer number n (2 <= n <= 1000), n is the size of 
the matrix. Then follow n lines containing the matrix elements (non-negative 
integer numbers not exceeding 10^9).

Output
In the first line print the least number of trailing zeros. In the second line 
print the correspondent way itself.

------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B0002_TheLeastRoundWay {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		int[][] arr = new int[n][n];
		int[][] two = new int[n][n];
		int[][] five = new int[n][n];
		int zeroI = -1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				arr[i][j] = in.nextInt();
				if (arr[i][j] == 0) {
					zeroI = i;
					two[i][j] = 1;
					five[i][j] = 1;
				}
				else {
					two[i][j] = countDiv(arr[i][j], 2);
					five[i][j] = countDiv(arr[i][j], 5);
				}
			}
		}
		
		two = solveGrid(two, n);
		five = solveGrid(five, n);
		
		int[][] res = two[n-1][n-1] < five[n-1][n-1] ? two : five;
		
		StringBuffer sb = new StringBuffer();
		String[] path = new String[2*n-2];
		if (zeroI != -1 && res[n-1][n-1] > 0) {
			sb.append(1 + "\n");
			path = findPathWithZero(n, zeroI);
		}
		else {
			sb.append(res[n-1][n-1] + "\n");
			path = findPathWithoutZero(arr, n);
		}
		
		for (String s: path)
			sb.append(s);
		System.out.println(sb);
	}
	
	public static int countDiv(int num, int div) {
		int res = 0;
		while (num%div == 0) {
			++res;
			num /= div;
		}
		return res;
	}
	
	public static int[][] solveGrid(int[][] arr, int n) {
		int[][] dp = new int[n][n];
		dp[0][0] = arr[0][0];
		for (int i=1; i<n; i++) {
			dp[i][0] = arr[i][0] + dp[i-1][0];
			dp[0][i] = arr[0][i] + dp[0][i-1];
		}
		for (int i=1; i<n; i++)
			for (int j=1; j<n; j++)
				dp[i][j] = arr[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
		return dp;
	}
	
	public static String[] findPathWithZero(int n, int zeroI) {
		String[] path = new String[2*n-2];
		int index = 0;
		for (int i=0; i<zeroI; i++)
			path[index++] = "D";
		for (int i=0; i<n-1; i++)
			path[index++] = "R";
		for (int i=zeroI; i<n-1; i++)
			path[index++] = "D";
		return path;
	}
	
	public static String[] findPathWithoutZero(int[][] arr, int n) {
		String[] path = new String[2*n-2];
		int I = n-1;
		int J = n-1;
		for (int i=2*n-3; i>=0; i--) {
			if (I == 0)
				path[i] = "R";
			else if (J == 0) {
				path[i] = "D";
			}
			else {
				if (arr[I-1][J] < arr[I][J-1]) {
					path[i] = "D";
					--I;
				}
				else {
					path[i] = "R";
					--J;
				}
			}
		}
		return path;
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
