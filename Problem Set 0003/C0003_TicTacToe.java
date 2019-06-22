/*

C - Tic Tac Toe

Certainly, everyone is familiar with tic-tac-toe game. The rules are very simple 
indeed. Two players take turns marking the cells in a 3 x 3 grid (one player 
always draws crosses, the other — noughts). The player who succeeds first in 
placing three of his marks in a horizontal, vertical or diagonal line wins, and 
the game is finished. The player who draws crosses goes first. If the grid is 
filled, but neither Xs, nor 0s form the required line, a draw is announced. You 
are given a 3 x 3 grid, each grid cell is empty, or occupied by a cross or a 
nought. You have to find the player (first or second), whose turn is next, or 
print one of the verdicts below: (1) illegal — if the given board layout can't 
appear during a valid game; (2) the first player won — if in the given board 
layout the first player has just won; (3) the second player won — if in the 
given board layout the second player has just won; (4) draw — if the given board 
layout has just let to a draw. 
    
Input
The input consists of three lines, each of the lines contains characters ".", 
"X", or "0" (a period, a capital letter X, or a digit zero).

Output
Print one of the six verdicts: first, second, illegal, the first player won, the 
second player won or draw.

--------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C0003_TicTacToe {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		char[][] board = new char[3][3];
		
		int numX = 0, numY = 0;
		for (int i=0; i<3; i++) {
			String str = in.next();
			for (int j=0; j<3; j++) {
				char cur = str.charAt(j);
				if (cur == 'X') 
					numX++;
				if (cur == '0') 
					numY++;
				board[i][j] = cur;
			}
		}
		
		System.out.println(findAns(numX, numY, board));
	}
	
	public static String findAns(int numX, int numY, char[][] arr) {
		if (Math.abs(numX-numY) > 1 || numY > numX)
			return "illegal";
		String str = checkSides(numX, numY, arr);
		if (!str.equals(""))
			return str;
		if (numX + numY == 9)
			return "draw";
		if (numX > numY)
			return "second";
		return "first";
	}
	
	public static String checkSides(int numX, int numY, char[][] arr) {
		int[][] wins = new int[3][3];
		for (int i=0; i<3; i++) {
			if (arr[i][0] != '.' && arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2])
				for (int j=0; j<3; j++)
					++wins[i][j];
			if (arr[0][i] != '.' && arr[0][i] == arr[1][i] && arr[0][i] == arr[2][i])
				for (int j=0; j<3; j++)
					++wins[j][i];
		}
		if (arr[1][1] != '.' && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2])
			for (int j=0; j<3; j++)
				++wins[j][j];
		if (arr[1][1] != '.' && arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0])
			for (int j=0; j<3; j++)
				++wins[j][2-j];
		
		int winSpots = 0, multWins = 0;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (wins[i][j] > 0)
					++winSpots;
				if (wins[i][j] > 1)
					++multWins;
			}
		}
		if (multWins > 1 || winSpots > 5)
			return "illegal";
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) if (wins[i][j] > 0) {
				if (arr[i][j] == 'X')
					return numX <= numY ? "illegal" : "the first player won";
				else
					return numX > numY ? "illegal" : "the second player won";
			}
		}
		return "";
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
	}
}