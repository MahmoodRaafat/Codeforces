/*

A - Maze

Pavel loves grid mazes. A grid maze is an n*m rectangle maze where each cell is either empty, or 
is a wall. You can go from one cell to another only if both cells are empty and have a common side.
Pavel drew a grid maze with all empty cells forming a connected area. That is, you can go from any 
empty cell to any other one. Pavel doesn't like it when his maze has too little walls. He wants to 
turn exactly k empty cells into walls so that all the remaining cells still formed a connected area. 
Help him.

Input
The first line contains three integers n, m, k (1 <= n, m <= 500, 0 <= k < s), where n and m are 
the  maze's height and width, correspondingly, k is the number of walls Pavel wants to add and 
letter s represents the number of empty cells in the original maze. Each of the next n lines 
contains m characters. They describe the original maze. If a character on a line equals ".", then 
the corresponding cell is empty and if the character equals "#", then the cell is a wall.

Output
Print n lines containing m characters each: the new maze that fits Pavel's requirements. Mark the 
empty cells that you transformed into walls as "X", the other cells must be left without changes 
(that is, "." and "#"). It is guaranteed that a solution exists. If there are multiple solutions 
you can output any of them.

--------------------------------------------------------------------------------------------------*/

import java.util.*;
public class A0377_Maze {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int k = sc.nextInt();
		String[][] grid = new String[rows][cols];
		boolean[][] visited = new boolean[rows][cols];
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		int numRemaining = 0;
		for (int i=0; i<rows; i++) {
			String str = sc.next();
			for (int j=0; j<cols; j++) {
				grid[i][j] = str.substring(j, j+1);
				if (grid[i][j].equals("#"))
					visited[i][j] = true;
				else {
					visited[i][j] = false;
					numRemaining++;
				}
			}
		}
		sc.close();
		
		boolean added = false;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				if (grid[i][j].equals(".")) {
					visited[i][j] = true;
					numRemaining--;
					q.add(1000*i+j);
					added = true;
					break;
				}
			}
			if (added) break;
		}
		
		boolean done = false;
		while (!q.isEmpty() && numRemaining > k) {
			int[] x = {0, 1, 0, -1};
			int[] y = {1, 0, -1, 0};
			int next = q.poll();
			int I = next/1000, J = next%1000;
			
			for (int i=0; i<4; i++) {
				I += x[i];
				J += y[i];
				
				if (I>=0 && J>=0 && I<rows && J<cols && !visited[I][J]) {
					visited[I][J] = true;
					numRemaining--;
					if (numRemaining==k) {
						done = true;
						break;
					}
					q.add(1000*I+J);
				}
				I -= x[i];
				J -= y[i];	
			}
			if (done) break;
		}
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				if (grid[i][j].equals("#"))
					System.out.print("#");
				else {
					if (visited[i][j])
						System.out.print(".");
					else
						System.out.print("X");
				}
			}
			System.out.println();
		}
	}
}