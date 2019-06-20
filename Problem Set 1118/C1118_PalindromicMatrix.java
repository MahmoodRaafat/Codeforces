/*

C - Palindromic Matrix

Let's call some square matrix with integer values in its cells palindromic if it doesn't change 
after the order of rows is reversed and it doesn't change after the order of columns is reversed.
You are given n^2 integers. Put them into a matrix of n rows and n columns so that each number is 
used exactly once, each cell contains exactly one number and the resulting matrix is palindromic. 
If there are multiple answers, print any. If there is no solution, print "NO".

Input
The first line contains one integer n (1 <= n <= 20). The second line contains n^2 integers a1, 
a2, ..., an^2 (1 <= ai <= 1000) — the numbers to put into a matrix of n rows and n columns.

Output
If it is possible to put all of the n^2 numbers into a matrix of n rows and n columns so that 
each number is used exactly once, each cell contains exactly one number and the resulting matrix 
is palindromic, then print "YES". Then print n lines with n space-separated numbers — the 
resulting matrix. If it's impossible to construct any matrix, then print "NO".

------------------------------------------------------------------------------------------------ */

import java.io.*;
import java.util.*;
public class C1118_PalindromicMatrix {
	
	static Map<Integer, Integer> map = new HashMap<>();
	static int[][] arr;
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		arr = new int[n][n];
		
		for (int i=0; i<n*n; i++) {
			int num = in.nextInt();
			if (!map.containsKey(num))
				map.put(num, 0);
			map.put(num, map.get(num)+1);
		}
		
		if ((n%2 == 0 && isEvenPalindrome(n)) || (n%2==1 && isOddPalindrome(n))) {
			System.out.println("YES");
			printArr(n);
		}
		else
			System.out.println("NO");
	}
	
	public static boolean isEvenPalindrome(int n) {
		int[] cornerPos = {0, 0};
		for (int k: map.keySet()) {
			if (map.get(k)%4 != 0)
				return false;
			for (int a=0; a<map.get(k)/4; a++)
				cornerPos = fillCorner(cornerPos, k, n);
		}
		return true;
	}
	
	public static boolean isOddPalindrome(int n) {
		int numCornerSpots = (n/2)*(n/2);
		int numMiddleSpots = (n/2)*2;
		boolean centerAvailable = true;
		int[] cornerPos = {0, 0};
		int[] sidePos = {0, 0};
		
		for (int k: map.keySet()) {
			int num = map.get(k);
			if (num%2 == 1) {
				if (!centerAvailable)
					return false;
				--num;
				centerAvailable = false;
				arr[n/2][n/2] = k;
			}
			if (num >= 4) {
				int numSpots = num/4;
				num %= 4;
				if (numSpots <= numCornerSpots) {
					
					numCornerSpots -= numSpots;
					for (int i=0; i<numSpots; i++)
						cornerPos = fillCorner(cornerPos, k, n);
				}
				else {
					for (int i=0; i<numCornerSpots; i++)
						cornerPos = fillCorner(cornerPos, k, n);
					numSpots -= numCornerSpots;
					numCornerSpots = 0;
					num += 4*numSpots;
				}
			}
			if (num > 0) {
				num /= 2;
				if (num > numMiddleSpots)
					return false;
				for (int i=0; i<num; i++) {
					if (sidePos[0] < n/2) {
						arr[n/2][sidePos[0]] = k;
						arr[n/2][n-1-sidePos[0]] = k;
						++sidePos[0];
					}
					else {
						arr[sidePos[1]][n/2] = k;
						arr[n-1-sidePos[1]][n/2] = k;
						++sidePos[1];
					}
				}
				numMiddleSpots -= num;
			}
		}
		return true;
	}
	
	public static int[] fillCorner(int[] cornerPos, int k, int n) {
		arr[cornerPos[0]][cornerPos[1]] = k;
		arr[cornerPos[0]][n-1-cornerPos[1]] = k;
		arr[n-1-cornerPos[0]][cornerPos[1]] = k;
		arr[n-1-cornerPos[0]][n-1-cornerPos[1]] = k;
		++cornerPos[0];
		if (cornerPos[0] == n/2) {
			cornerPos[0] = 0;
			++cornerPos[1];
		}
		return cornerPos;
	}
	
	public static void printArr(int n) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
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