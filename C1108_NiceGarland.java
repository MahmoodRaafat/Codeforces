/*

You have a garland consisting of n lamps. Each lamp is colored red, green or blue. The color of the 
i-th lamp is si ('R', 'G' and 'B' — colors of lamps in the garland). You have to recolor some lamps 
in this garland (recoloring a lamp means changing its initial color to another) in such a way that 
the obtained garland is nice. A garland is called nice if any two lamps of the same color have 
distance divisible by three between them. I.e. if the obtained garland is t, then for each i,j such 
that ti=tj should be satisfied |i-j| mod 3=0. For example, the following garlands are nice: 
"RGBRGBRG", "GB", "R", "GRBGRBG", "BRGBRGB". The following garlands are not nice: "RR", "RGBG". 
Among all ways to recolor the initial garland to make it nice you have to choose one with the minimum 
number of recolored lamps. If there are multiple optimal solutions, print any of them.

Input
The first line of the input contains one integer n (1<=n<=2*10^5) — the number of lamps. The second 
line of the input contains the string s consisting of n characters 'R', 'G' and 'B' — colors of lamps 
in the garland.

Output
In the first line of the output print one integer r — the minimum number of recolors needed to obtain 
a nice garland from the given one. In the second line of the output print one string t of length n — a 
nice garland obtained from the initial one with minimum number of recolors. If there are multiple 
optimal solutions, print any of them.

--------------------------------------------------------------------------------------------------------*/

import java.util.*;
public class C1108_NiceGarland {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		sc.close();
		
		// there are 3 "positions" in the garland: when index%3==0, when index%3==1, and when index%3==2
		// the every lamp in the same "position" must be the same color
		int[][] arr = new int[3][3]; // records the number of each color lamp in each position
		for (int i=0; i<n; i++) {
			char cur = str.charAt(i);
			if (cur=='R')
				arr[i%3][0]++;
			else if (cur=='G')
				arr[i%3][1]++;
			else
				arr[i%3][2]++;
		}
		
		
		// each variable (i,j,k) is a row (color) in arr (row 0 represents red, 1 = green, 2 = blue)
		// find the largest number of lamps that don't need to be changed, store in best[]
		int[] best = new int[4];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				for (int k=0; k<3; k++) { 
					if (i!=j && i!=k && j!=k) {
						int dontChange = arr[0][i] + arr[1][j] + arr[2][k];
						if (dontChange > best[0]) {
							best[0] = dontChange;
							best[1] = i;
							best[2] = j;
							best[3] = k;
						}
					}
				}
			}
		}
		
		System.out.println(n-best[0]);
		String[] letters = {"R", "G", "B"};
		
		for (int i=0; i<n; i++) {
			if (i%3==0)
				System.out.print(letters[best[1]]);
			else if (i%3==1)
				System.out.print(letters[best[2]]);
			else
				System.out.print(letters[best[3]]);
		}
	}
}