/*

B - Biridian Forest

You're a mikemon breeder currently in the middle of your journey to become a mikemon master. Your current obstacle is to 
go through the infamous Biridian Forest. The Biridian Forest is a two-dimensional grid consisting of r rows and c columns. 
Each cell in Biridian Forest may contain a tree or be vacant. A vacant cell may be occupied by zero or more mikemon 
breeders. Mikemon breeders (including you) cannot enter cells with trees. One of the cells is designated as the exit cell. 
You will be given the initial grid, your initial position, the exit cell, and the initial positions of all other breeders.

Breeders (including you) may move in the forest. In a single move, breeders may perform one of the following actions:
    (1) Do nothing.
    (2) Move from the current cell to one of the four adjacent cells (two cells are adjacent if they share a side).
    (3) If you are located on the exit cell, you may leave the forest. Only you can perform this move.
After each time you make a single move, each of the other breeders simultaneously make a single move (the choice of which 
move to make may be different for each of the breeders).

If you and t (t > 0) mikemon breeders are located on the same cell, exactly t mikemon battles will ensue that time (since 
you will be battling each of those t breeders once). After the battle, all of those t breeders will leave the forest to heal 
their respective mikemons. Note that the moment you leave the forest, no more mikemon battles can ensue, even if another 
mikemon breeder move to the exit cell immediately after that. Also note that a battle only happens between you and another 
breeders — there will be no battle between two other breeders (there may be multiple breeders coexisting in a single cell). 
You would like to leave the forest. In order to do so, you have to make a sequence of moves, ending with a move of the final 
type. Before you make any move, however, you post this sequence on your personal virtual idol Blog. Then, you will follow 
this sequence of moves faithfully.  Because you post the sequence in your Blog, the other breeders will all know your exact 
sequence of moves even before you make your first move. All of them will move in such way that will guarantee a mikemon battle 
with you, if possible. The breeders that couldn't battle you will do nothing. Print the minimum number of mikemon battles 
that you must participate in, assuming that you pick the sequence of moves that minimize this number. Note that you are not 
required to minimize the number of moves you make.

Input
The first line consists of two integers: r and c (1 <= r, c <= 1000), denoting the number of rows and columns in Biridian 
Forest. The next r rows will each depict a row of the map, where each character represents the content of a single cell:
    'T': A cell occupied by a tree.
    'S': An empty cell, and your starting position. There will be exactly one occurence of this in the map.
    'E': An empty cell, and where the exit is located. There will be exactly one occurence of this in the map.
    A digit (0-9): A cell represented by a digit X means that the cell is empty and is occupied by X breeders (in particular, 
    if X is zero, it means that the cell is not occupied by any breeder). 
It is guaranteed that it will be possible for you to go from your starting position to the exit cell.

Output
A single line denoted the minimum possible number of mikemon battles that you have to participate in if you pick a strategy 
that minimize this number.

---------------------------------------------------------------------------------------------------------------------------*/

import java.util.*;
public class B0329_BiridianForest {
	static Queue<Integer> q = new ArrayDeque<Integer>();
	public static int rows, cols;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		cols = sc.nextInt();
		String[][] forest = new String[rows][cols];
		boolean[][] visited = new boolean[rows][cols];
		int[][] dists = new int[rows][cols];
		
		int startpos = 0, endpos = 0;
		for (int i=0; i<rows; i++) {
			String next = sc.next();
			for (int j=0; j<cols; j++) {
				forest[i][j] = next.substring(j, j+1);
				if (forest[i][j].equals("E")) {
					endpos = 10000*i+j;
					visited[i][j] = true;
				}
				if (forest[i][j].equals("S"))
					startpos = 10000*i+j;
				if (forest[i][j].equals("T"))
					visited[i][j] = true;
				else
					visited[i][j] = false;

			}
		}
		sc.close();
		
		q.add(endpos);
		while(q.size() > 0) {
			check(visited, dists);
		}
		
		int startI = startpos/10000, startJ = startpos%10000;
		int result = 0;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				if (!forest[i][j].equals("T") && !forest[i][j].equals("S") && !forest[i][j].equals("0") && !forest[i][j].equals("E")) {
					if (dists[i][j] <= dists[startI][startJ] && dists[i][j]>0) {
						result += Integer.parseInt(forest[i][j]);
					}
				}
			}
		}
		System.out.println(result);
	}
	
	public static int check(boolean[][] visited, int[][] dists) {
		int next = q.poll();
		int I = next/10000, J = next%10000;
		int origI = I, origJ = J;
		for (int i=0; i<4; i++) {
			if (i==0) I--;
			if (i==1) J++;
			if (i==2) I++;
			if (i==3) J--;
			if (I>rows-1 || I<0 || J<0 || J>cols-1) {
				I = origI;
				J = origJ;
				continue;
			}
			if (!visited[I][J] == true)  {
				q.add(10000*I+J);
				visited[I][J] = true;
				dists[I][J] = dists[origI][origJ] + 1;
			}	
			I = origI;
			J = origJ;
		}
		return 0;
	}
}