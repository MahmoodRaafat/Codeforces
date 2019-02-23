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

import java.util.*;
public class B0006_PresidentsOffice {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		String pres = sc.next();
		
		String[][] grid = new String[rows][cols];
		for (int i=0; i<rows; i++) {
			String str = sc.next();
			for (int j=0; j<cols; j++) {
				grid[i][j] = str.substring(j, j+1);
			}
		}
		sc.close();
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				if (grid[i][j].equals(pres)) {
					int[] x = {0, 1, 0, -1};
					int[] y = {1, 0, -1, 0};
					for (int a=0; a<4; a++) {
						int u = i + x[a];
						int v = j + y[a];
						if (u>=0 && u<rows && v>=0 && v<cols) {
							if (!grid[u][v].equals(".") && !grid[u][v].equals(pres) && !list.contains(grid[u][v])) {
								list.add(grid[u][v]);
							}
						}
					}
				}
			}
		}
		System.out.println(list.size());
	}
}
