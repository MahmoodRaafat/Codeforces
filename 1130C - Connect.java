/*

C - Connect

Alice lives on a flat planet that can be modeled as a square grid of size n×n, with rows and 
columns enumerated from 1 to n. We represent the cell at the intersection of row r and column 
c with ordered pair (r, c). Each cell in the grid is either land or water. Alice resides in 
land cell (r1, c1). She wishes to travel to land cell (r2,c2). At any moment, she may move to 
one of the cells adjacent to where she is—in one of the four directions (i.e., up, down, left, 
or right). Unfortunately, Alice cannot swim, and there is no viable transportation means other 
than by foot (i.e., she can walk only on land). As a result, Alice's trip may be impossible. 
To help Alice, you plan to create at most one tunnel between some two land cells. The tunnel 
will allow Alice to freely travel between the two endpoints. Indeed, creating a tunnel is a 
lot of effort: the cost of creating a tunnel between cells (rs, cs) and (rt, ct) is 
(rs-rt)^2 + (cs-ct)^2. For now, your task is to find the minimum possible cost of creating at 
most one tunnel so that Alice could travel from (r1, c1) to (r2,c2). If no tunnel needs to be 
created, the cost is 0.

Input
The first line contains one integer n (1 <= n <= 50) — the width of the square grid. The second 
line contains two space-separated integers r1 and c1 (1 <= r1, c1 <= n) — denoting the cell 
where Alice resides. The third line contains two space-separated integers r2 and c2 (1 <= r2, 
c2 <= n) — denoting the cell to which Alice wishes to travel. Each of the following n lines 
contains a string of n characters. The j-th character of the i-th such line (1 <= i, j <= n) is 
0 if (i, j) is land or 1 if (i, j) is water.

Output
Print an integer that is the minimum possible cost of creating at most one tunnel so that Alice 
could travel from (r1, c1) to (r2, c2).

------------------------------------------------------------------------------------------------*/

import java.util.*;
public class C1130_Connect {
	static final int[] x = {0, 1, 0, -1};
	static final int[] y = {1, 0, -1, 0};
	static ArrayList<Integer> start = new ArrayList<Integer>();
	static ArrayList<Integer> finish = new ArrayList<Integer>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r1 = sc.nextInt(), c1 = sc.nextInt();
		int r2 = sc.nextInt(), c2 = sc.nextInt();
		
		int[][] grid = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			String str = sc.next();
			for (int j=0; j<n; j++) {
				if (str.substring(j, j+1).equals("0"))
					grid[i][j] = 1;
				else {
					grid[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}
		sc.close();
		
		floodFill(n, r1-1, c1-1, grid, visited, 2);
		if (grid[r1-1][c1-1] == grid[r2-1][c2-1])
			System.out.println(0);
		else {
			floodFill(n, r2-1, c2-1, grid, visited, 3);
		
			int res = Integer.MAX_VALUE;
			for (int i=0; i<start.size(); i++) {
				for (int j=0; j<finish.size(); j++) {
					int cost = (int) Math.pow(start.get(i)/1000 - finish.get(j)/1000, 2) + 
							(int) Math.pow(start.get(i)%1000 - finish.get(j)%1000, 2);
					res = Math.min(res, cost);
				}
			}
			System.out.println(res);
		}
	}
	
	public static void floodFill(int n, int i, int j, int[][] grid, boolean[][] visited, int num) {
		visited[i][j] = true;
		grid[i][j] = num;
		if (num==2) start.add((i+1)*1000+(j+1));
		else finish.add((i+1)*1000+(j+1));
		
		for (int a=0; a<4; a++) {
			int I = i+x[a];
			int J = j+y[a];
			if (I>=0 && J>=0 && J<n && I<n && !visited[I][J]) {
				floodFill(n, I, J, grid, visited, num);
			}
		}
	}
}
