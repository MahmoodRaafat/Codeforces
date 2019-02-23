/*

A - Kalevitch and Chess

A famous Berland's painter Kalevitch likes to shock the public. One of his last 
obsessions is chess. For more than a thousand years people have been playing this 
old game on uninteresting, monotonous boards. Kalevitch decided to put an end to 
this tradition and to introduce a new attitude to chessboards.
As before, the chessboard is a square-checkered board with the squares arranged 
in a 8 x 8 grid, each square is painted black or white. Kalevitch suggests that 
chessboards should be painted in the following manner: there should be chosen a 
horizontal or a vertical line of 8 squares (i.e. a row or a column), and painted 
black. Initially the whole chessboard is white, and it can be painted in the above 
described way one or more times. It is allowed to paint a square many times, but 
after the first time it does not change its colour any more and remains black. 
Kalevitch paints chessboards neatly, and it is impossible to judge by an individual 
square if it was painted with a vertical or a horizontal stroke.

Kalevitch hopes that such chessboards will gain popularity, and he will be 
commissioned to paint chessboards, which will help him ensure a comfortable old age. 
The clients will inform him what chessboard they want to have, and the painter will 
paint a white chessboard meeting the client's requirements.
It goes without saying that in such business one should economize on everything —
for each commission he wants to know the minimum amount of strokes that he has to 
paint to fulfill the client's needs. You are asked to help Kalevitch with this task.

Input
The input file contains 8 lines, each of the lines contains 8 characters. The given 
matrix describes the client's requirements, W character stands for a white square, 
and B character — for a square painted black. It is guaranteed that client's 
requirments can be fulfilled with a sequence of allowed strokes (vertical/column 
or horizontal/row).

Output
Output the only number — the minimum amount of rows and columns that Kalevitch has 
to paint on the white chessboard to meet the client's requirements.

------------------------------------------------------------------------------------*/

import java.util.*;
public class A0007_KalevitchAndChess {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[8][8];
		String PAINTED = "BBBBBBBB";
		
		for (int i=0; i<8; i++) {
			String str = sc.next();
			for (int j=0; j<8; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		sc.close();
		
		int numStrokes = 0;
		for (int i=0; i<8; i++) { // check rows for painted strokes
			String str = "";
			for (int j=0; j<8; j++) {
				str += arr[i][j];
			}
			if (str.equals(PAINTED)) {
				numStrokes++;
			}
		}
		if (numStrokes != 8) { // if all the board is painted, stop
			for (int i=0; i<8; i++) { // check columns for paint strokes
				String str = "";
				for (int j=0; j<8; j++) {
					str += arr[j][i];
				}
				if (str.equals(PAINTED)) {
					numStrokes++;
				}
			}
		}
		System.out.println(numStrokes);
	}
}