/*

A - Epic Game

Simon and Antisimon play a game. Initially each player receives one fixed positive 
integer that doesn't change throughout the game. Simon receives number a and 
Antisimon receives number b. They also have a heap of n stones. The players take 
turns to make a move and Simon starts. During a move a player should take from the 
heap the number of stones equal to the greatest common divisor of the fixed number 
he has received and the number of stones left in the heap. A player loses when he 
cannot take the required number of stones (i. e. the heap has strictly less stones 
left than one needs to take).
Your task is to determine by the given a, b and n who wins the game.

Input
The only string contains space-separated integers a, b and n (1 <= a, b, n <= 100) 
— the fixed numbers Simon and Antisimon have received correspondingly and the 
initial number of stones in the pile.

Output
If Simon wins, print "0" (without the quotes), otherwise print "1" (without quotes).

-----------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A0119_EpicGame {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt();
		boolean simon = true;
		sc.close();
		
		while (n > 0) {
			// find gcd
			int gcd = gcd(a, b, n, simon);
			if (gcd == -1)
				break;
			// substract gcd from heap and change players
			else {
				n -= gcd;
				simon = !simon;
			}
		}
		
		// print player who cannot make a turn
		if (simon)
			System.out.println(1);
		else
			System.out.println(0);
	}
	
	// method to determine gcd of fixed # received and the # left in heap
	public static int gcd(int a, int b, int n, boolean simon) {
		int start = simon ? Math.min(a, n) : Math.min(b, n);
		int fixedNum = simon ? a : b;
		for (int i=start; i>=0; i--)
			if (fixedNum%i==0 && n%i==0)
				return i;
		return -1;
	}
}
