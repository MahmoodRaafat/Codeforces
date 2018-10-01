/*

A - Die Roll

Yakko, Wakko and Dot, world-famous animaniacs, decided to rest from acting in cartoons, and take a leave to travel 
a bit. Yakko dreamt to go to Pennsylvania, his Motherland and the Motherland of his ancestors. Wakko thought about 
Tasmania, its beaches, sun and sea. Dot chose Transylvania as the most mysterious and unpredictable place.
But to their great regret, the leave turned to be very short, so it will be enough to visit one of the three above 
named places. That's why Yakko, as the cleverest, came up with a truly genius idea: let each of the three roll an 
ordinary six-sided die, and the one with the highest amount of points will be the winner, and will take the other 
two to the place of his/her dreams.
Yakko thrown a die and got Y points, Wakko - W points. It was Dot's turn. But she didn't hurry. Dot wanted to know 
for sure what were her chances to visit Transylvania.
It is known that Yakko and Wakko are true gentlemen, that's why if they have the same amount of points with Dot, 
they will let Dot win.

Input
The only line of the input file contains two natural numbers Y and W - the results of Yakko's and Wakko's die rolls.

Output
Output the required probability in the form of irreducible fraction in format <<A/B>> where A is the numerator, and 
B is the denominator. If the required probability equals to zero, output <<0/1>>. If the required probability equals 
to 1, output <<1/1>>. 

------------------------------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A0009_DieRoll { 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int scoreY = sc.nextInt();
		int scoreW = sc.nextInt();
		
		// We only care about the winner of the previous 2 roles (the biggest).
		// Do (7 - largest die roll) over 6 to find the fraction of numbers 1-6 that will cause Dot to win 
		// (7 b/c a tie will still win)
		int numerator = 7 - Math.max(scoreW, scoreY);
		int denominator = 6;
		
		// simplify the fraction
		if (numerator==5 || numerator==1)
			System.out.println(numerator + "/" + denominator);
		else if (numerator==2 || numerator==3 || numerator==6) {
			denominator /= numerator;
			System.out.println(1 + "/" + denominator);
		}
		else
			System.out.println(2 + "/" + 3);
		
		sc.close();
	}
}
