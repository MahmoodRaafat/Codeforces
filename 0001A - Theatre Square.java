/*

A - Theatre Square

Theatre Square in the capital city of Berland has a rectangular shape with the size n x m meters. On the occasion of the city's 
anniversary, a decision was taken to pave the Square with square granite flagstones. Each flagstone is of the size a x a.
What is the least number of flagstones needed to pave the Square? It's allowed to cover the surface larger than the Theatre 
Square, but the Square has to be covered. It's not allowed to break the flagstones. The sides of flagstones should be parallel to 
the sides of the Square.

Input
The input contains three positive integer numbers in the first line: n, m and a (1 <= n, m, a <= 10^9).

Output
Write the needed number of flagstones.

---------------------------------------------------------------------------------------------------------------------------------*/
import java.util.Scanner;
public class A0001_TheatreSquare {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// use long b/c (10^9)^2 is possible
		long n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt();
		
		// find the number of flagstones needed to cover the length of the rectangle (n direction)
		long numlength = 0;
		if (n%a==0)
			numlength = n/a;
		else
			numlength = (n/a)+1; // +1 to cover the remainder
		
		// do the same for the width (m direction)
		long numwidth = 0;
		if (m%a==0)
			numwidth = m/a;
		else
			numwidth = (m/a)+1;
		
		// total # of stones is length*width
		long numstones = numwidth*numlength;
		System.out.println(numstones);
		sc.close();
	}
}
