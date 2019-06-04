/*

C - The Labyrinth

You are given a rectangular field of n*m cells. Each cell is either empty or 
impassable (contains an obstacle). Empty cells are marked with '.', impassable 
cells are marked with '*'. Let's call two empty cells adjacent if they share a 
side. Let's call a connected component any non-extendible set of cells such that 
any two of them are connected by the path of adjacent cells. It is a typical 
well-known definition of a connected component. For each impassable cell (x, y) 
imagine that it is an empty cell (all other cells remain unchanged) and find the 
size (the number of cells) of the connected component which contains (x, y). You 
should do it for each impassable cell independently. The answer should be printed 
as a matrix with n rows and m columns. The j-th symbol of the i-th row should be 
"." if the cell is empty at the start. Otherwise the j-th symbol of the i-th row 
should contain the only digit —- the answer modulo 10. The matrix should be 
printed without any spaces.

Input
The first line contains two integers n, m (1 <= n, m <= 1000) — the number of 
rows and columns in the field. Each of the next n lines contains m symbols: "." 
for empty cells, "*" for impassable cells.

Output
Print the answer as a matrix as described above. See the examples to precise the 
format of the output.

---------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C0616_TheLabyrinth {
	
	static int rows, cols;
	static int[][] grid;
	static final int[] x = {1, 0, -1, 0};
	static final int[] y = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		rows = in.nextInt();
		cols = in.nextInt();
		grid = new int[rows + 2][cols + 2];
		addBoundary();
		
		for (int i=1; i<=rows; i++) {
			String line = in.next();
			for (int j=1; j<=cols; j++) {
				if (line.charAt(j-1) == '*')
					grid[i][j] = -1;
			}
		}
		
		int numRegions = 0;
		ArrayList<Integer> regions = new ArrayList<>();
		regions.add(-1); // make regions 1-indexed
		
		for (int i=1; i<=rows; i++) {
			for (int j=1; j<=cols; j++) if (grid[i][j] == 0) {
				regionSize = 0;
				floodFill(i, j, ++numRegions);
				regions.add(regionSize);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=1; i<=rows; i++) {
			for (int j=1; j<=cols; j++) {
				if (grid[i][j] != -1)
					sb.append(".");
				else
					sb.append(findAdj(i, j, regions) % 10);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int regionSize;
	public static void floodFill(int i, int j, int index) {
		grid[i][j] = index;
		++regionSize;
		
		for (int a=0; a<4; a++) {
			int I = i + x[a];
			int J = j + y[a];
			
			if (grid[I][J] == 0) {
				floodFill(I, J, index);
			}
		}
	}
	
	public static int findAdj(int i, int j, ArrayList<Integer> regions) {
		ArrayList<Integer> adj = new ArrayList<>();
		for (int k=0; k<4; k++) {
			int I = i+x[k];
			int J = j+y[k];
			int group = grid[I][J];
			if (group != -1 && !adj.contains(group))
				adj.add(group);
		}
		int res = 1;
		for (int k: adj)
			res += regions.get(k);
		return res;
	}
	
	public static void addBoundary() {
		for (int i=0; i<rows+2; i++) {
			grid[i][0] = -1;
			grid[i][cols+1] = -1;
		}
		for (int j=0; j<cols+2; j++) {
			grid[0][j]= -1;
			grid[rows+1][j] = -1;
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