/*

A - Sea Battle

In order to make the "Sea Battle" game more interesting, Boris decided to add a new ship type to it. The ship 
consists of two rectangles. The first rectangle has a width of w1 and a height of h1, while the second rectangle 
has a width of w2 and a height of h2, where w1 <= w2 . In this game, exactly one ship is used, made up of two 
rectangles. There are no other ships on the field. The rectangles are placed on field in the following way:
    (1) the second rectangle is on top the first rectangle;
    (2) they are aligned to the left, i.e. their left sides are on the same line;
    (3) the rectangles are adjacent to each other without a gap. 
Formally, let's introduce a coordinate system. Then, the leftmost bottom cell of the first rectangle has 
coordinates (1,1), the rightmost top cell of the first rectangle has coordinates (w1, h1), the leftmost bottom 
cell of the second rectangle has coordinates (1, h1+1) and the rightmost top cell of the second rectangle has 
coordinates (w2, h1+h2). After the ship is completely destroyed, all cells neighboring by side or a corner with 
the ship are marked. Of course, only cells, which don't belong to the ship are marked. On the pictures in the 
notes such cells are colored green. Find out how many cells should be marked after the ship is destroyed. The 
field of the game is infinite in any direction.

Input
Four lines contain integers w1, h1, w2 and h2 (1 <= w1, h1, w2, h2 <= 10^8, w1 >= w2) - the width of the first 
rectangle, the height of the first rectangle, the width of the second rectangle and the height of the second 
rectangle. You can't rotate the rectangles.

Output
Print exactly one integer — the number of cells, which should be marked after the ship is destroyed.

--------------------------------------------------------------------------------------------------------------*/

import java.util.*;
public class A1131_SeaBattle {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int w1 = sc.nextInt();
		int h1 = sc.nextInt();
		int w2 = sc.nextInt();
		int h2 = sc.nextInt();
		sc.close();
		
		long res = h1+h2+2 + w1+1 + w2+1;
		if (w1==w2)
			res += h1+h2;
		else if(w1>w2)
			res += h2+(w1-w2)+h1;
		else
			res += h1+(w2-w1)+h2;
		
		System.out.println(res);
	}
}