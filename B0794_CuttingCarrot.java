/*

B - Cutting Carrot

Igor the analyst has adopted n little bunnies. As we all know, bunnies love carrots. Thus, Igor 
has bought a carrot to be shared between his bunnies. Igor wants to treat all the bunnies 
equally, and thus he wants to cut the carrot into n pieces of equal area. Formally, the carrot 
can be viewed as an isosceles triangle with base length equal to 1 and height equal to h. Igor 
wants to make n-1 cuts parallel to the base to cut the carrot into n pieces. He wants to make 
sure that all n pieces have the same area. Can you help Igor determine where to cut the carrot 
so that each piece have equal area?

Input
The first and only line of input contains two space-separated integers, 
n and h (2 <= n <= 1000, 1 <= h <= 105).

Output
The output should contain n-1 real numbers x1, x2, ..., xn-1. The number xi denotes that the 
i-th cut must be made xi units away from the apex of the carrot. In addition, 
0 < x1 < x2 < ... < xn-1 < h must hold. Your output will be considered correct if absolute 
or relative error of every number in your output doesn't exceed 10^-6.

------------------------------------------------------------------------------------------------*/

import java.util.*;
public class B0794_CuttingCarrot {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		sc.close();

		for (int i=1; i<n; i++) {
			if (i>1)
				System.out.print(" ");
			System.out.print(Math.sqrt((double) h * h * i / n));
		}
		
	}
}

/*
 * For each cut from the top, the triangle above the cut will be similar to the while triangle
 * For similar triangles, the ratio of their areas is the square of the ratio of their sides
 * 
 * (a/A) = (xi/h)^2
 * a (area above cut) = A*i/n
 * i/n = (xi)^2 / h^2
 * xi = sqrt(h*h*i/n)
 */