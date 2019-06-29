/*

B - President's Office

President of Berland has a very vast office-room, where, apart from him, work his subordinates. Each 
subordinate, as well as President himself, has his own desk of a unique colour. Each desk is 
rectangular, and its sides are parallel to the office walls. One day President decided to establish 
an assembly, of which all his deputies will be members. Unfortunately, he does not remember the exact 
amount of his deputies, but he remembers that the desk of each his deputy is adjacent to his own desk, 
that is to say, the two desks (President's and each deputy's) have a common side of a positive length.
The office-room plan can be viewed as a matrix with n rows and m columns. Each cell of this matrix is 
either empty, or contains a part of a desk. An uppercase Latin letter stands for each desk colour. A 
period ('.') stands for an empty cell.

Input
The first line contains two separated by a space integer numbers n, m (1 <= n, m <= 100) — the length 
and the width of the office-room, and c character — the President's desk colour. The following n lines 
contain m characters each — the office-room description. It is guaranteed that the colour of each desk 
is unique, and each desk represents a continuous subrectangle of the given matrix. All colours are 
marked by uppercase Latin letters.

Output
Print the only number — the amount of President's deputies.

------------------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B0006_PresidentsOffice {
	
	static int rows, cols;
	static ArrayList<String> list = new ArrayList<>();
	static final int[] x = {0, 1, 0, -1};
	static final int[] y = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		rows = in.nextInt();
		cols = in.nextInt();
		String pres = in.next();
		
		String[][] grid = new String[rows][cols];
		for (int i=0; i<rows; i++) {
			String str = in.next();
			for (int j=0; j<cols; j++)
				grid[i][j] = str.substring(j, j+1);
		}
		
		for (int i=0; i<rows; i++)
			for (int j=0; j<cols; j++) if (grid[i][j].equals(pres))
				searchAdj(i, j, grid, pres);
		System.out.println(list.size());
	}
	
	public static void searchAdj(int i, int j, String[][] grid, String pres) {
		for (int a=0; a<4; a++) {
			int I = i + x[a];
			int J = j + y[a];
			if (inbounds(I, J) && !grid[I][J].equals(".") && !grid[I][J].equals(pres))
				if (!list.contains(grid[I][J]))
					list.add(grid[I][J]);
		}
	}
	
	public static boolean inbounds(int i, int j) {
		return i>=0 && i<rows && j>=0 && j<cols;
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