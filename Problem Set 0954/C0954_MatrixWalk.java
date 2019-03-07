/*

C - Matrix Walk

There is a matrix A of size x*y filled with integers. For every i [1...x] and j [1...y], 
Aij = y(i-1)+j. Obviously, every integer from [1...xy] occurs exactly once in this matrix. You have 
traversed some path in this matrix. Your path can be described as a sequence of visited cells a1, 
a2, ..., an, denoting that you started in the cell containing the number a1, then moved to the cell 
with the number a2, and so on. From the cell located in i-th line and j-th column (we denote this 
cell as (i, j)) you can move into one of the following cells:
    (i + 1, j) — only if i < x;
    (i, j + 1) — only if j < y;
    (i - 1, j) — only if i > 1;
    (i, j - 1) — only if j > 1.
Notice that making a move requires you to go to an adjacent cell. It is not allowed to stay in the 
same cell. You don't know x and y exactly, but you have to find any possible values for these 
numbers such that you could start in the cell containing the integer a1, then move to the cell 
containing a2 (in one step), then move to the cell containing a3 (also in one step) and so on. 
Can you choose x and y so that they don't contradict with your sequence of moves?

Input
The first line contains one integer number n (1 <= n <= 200000) — the number of cells you visited 
on your path (if some cell is visited twice, then it's listed twice). The second line contains n 
integers a1, a2, ..., an (1 <= ai <= 10^9) — the integers in the cells on your path.

Output
If all possible values of x and y such that 1 <= x, y <= 10^9 contradict with the information about 
your path, print NO. Otherwise, print YES in the first line, and in the second line print the 
values x and y such that your path was possible with such number of lines and columns in the
matrix. Remember that they must be positive integers not exceeding 10^9.

--------------------------------------------------------------------------------------------------*/

import java.util.*;
public class C0954_MatrixWalk {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int dist = 1;
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if (i>0) {
				int diff = Math.abs(arr[i]-arr[i-1]);
				if (diff == 0) {
					System.out.println("NO");
					sc.close();
					return;
				}
				dist = Math.max(dist, diff);
			}
		}
		sc.close();

		int[] distX = new int[n];
		int[] distY = new int[n];
		for (int i=0; i<n; i++) {
			distX[i] = (arr[i]-1)/dist + 1;
			distY[i] = (arr[i]-1)%dist + 1;
			if (i>0) {
				if (Math.abs(distX[i]-distX[i-1]) + Math.abs(distY[i]-distY[i-1]) != 1) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
		System.out.println(1000000000 + " " + dist);
	}
}