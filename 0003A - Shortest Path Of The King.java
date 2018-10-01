/*

A - Shortest Path of the King

The king is left alone on the chessboard. In spite of this loneliness, he doesn't lose heart, 
because he has business of national importance. For example, he has to pay an official visit 
to square t. As the king is not in habit of wasting his time, he wants to get from his current 
position s to square t in the least number of moves. Help him to do this.
In one move the king can get to the square that has a common side or a common vertex with the 
square the king is currently in (generally there are 8 different squares he can move to).

Input
The first line contains the chessboard coordinates of square s, the second line — of square t.
Chessboard coordinates consist of two characters, the first one is a lowercase Latin letter (from a 
to h), the second one is a digit from 1 to 8.

Output
In the first line print n — minimum number of the king's moves. Then in n lines print the moves 
themselves. Each move is described with one of the 8: L, R, U, D, LU, LD, RU or RD.
L, R, U, D stand respectively for moves left, right, up and down (according to the picture), and 
2-letter combinations stand for diagonal moves. If the answer is not unique, print any of them. 

-----------------------------------------------------------------------------------------------*/
import java.util.Scanner;
public class A0003_ShortestPathOfTheKing {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String start = sc.next();
		String end = sc.next();
		sc.close();
		
		// separate/parse out the starting and ending coordinates
		int startI = Integer.parseInt(start.substring(1));
		int endI = Integer.parseInt(end.substring(1));
		int startJ = (int) start.charAt(0); // use ascii values for chars
		int endJ = (int) end.charAt(0);
		
		// largest possible number of moves is 8
		String[] moves = new String[8];
		
		// counts the number of moves
		int res = 0;
		
		// each step of the for loop determines if the king needs to move right or left/up or down and 
		// records the move in moves[].
		boolean I = false, J = false;
		for (int i=0; i<8; i++) {
			moves[i] = "";
			if (startI == endI) I = true;
			if (startJ == endJ)J = true;
			if (I && J) { // king is at goal coordinate
				res = i;
				break;
			}
			
			if (!J) {
				if (startJ < endJ) { // move right
					moves[i] += "R";
					startJ++;
				}
				else {
					moves[i] += "L"; // move left
					startJ--;
				}
			}
			if (!I) {
				if (startI < endI) { // move up
					moves[i] += "U";
					startI++;
				}
				else {
					moves[i] += "D"; // move down
					startI--;
				}
			}
		}
		
		System.out.println(res);
		for (int i=0; i<8; i++) {
			if (!moves[i].equals(""))
				System.out.println(moves[i]);
			else
				break;
		}
		
	}
}
