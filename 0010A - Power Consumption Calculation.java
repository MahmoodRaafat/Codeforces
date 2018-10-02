/*

A - Power Consumption Calculation

Tom is interested in power consumption of his favourite laptop. His laptop has three modes. In 
normal mode laptop consumes P1 watt per minute. T1 minutes after Tom moved the mouse or touched 
the keyboard for the last time, a screensaver starts and power consumption changes to P2 watt 
per minute. Finally, after T2 minutes from the start of the screensaver, laptop switches to the 
"sleep" mode and consumes P3 watt per minute. If Tom moves the mouse or touches the keyboard 
when the laptop is in the second or in the third mode, it switches to the first (normal) mode. 
Tom's work with the laptop can be divided into n time periods [l1, r1], [l2, r2], ..., [ln, rn]. 
During each interval Tom continuously moves the mouse and presses buttons on the keyboard. 
Between the periods Tom stays away from the laptop. Find out the total amount of power consumed 
by the laptop during the period [l1, rn].

Input
The first line contains 6 integer numbers n, P1, P2, P3, T1, T2 (1 <= n <= 100,
0 <= P1, P2, P3 <= 100, 1 <= T1, T2 <= 60). The following n lines contain description of Tom's 
work. Each i-th of these lines contains two space-separated integers li & ri (0 <= li < ri <= 1440, 
ri < li + 1 for i < n), which stand for the start and the end of the i-th period of work.

Output
Output the answer to the problem.

-----------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A0010_PowerConsumptionCalc {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int P1 = sc.nextInt();
		int P2 = sc.nextInt();
		int P3 = sc.nextInt();
		int T1 = sc.nextInt();
		int T2 = sc.nextInt();
		
		// create and fill array to hold time values
		int[][] arr = new int[n][2];
		for (int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();

		// find time that Tom is using computer and multiply by P1
		// take time during Tom's breaks and find how much power is used with P2, P3, T1, and T2 
		int totPower = 0;		
		for (int i=0; i<n-1; i++) { // to n-1 b/c there is no break after last usage
			// multiply time on computer by P1
			totPower += (arr[i][1]-arr[i][0])*P1;
			
//			if (n==1 || i>=n-1)
//				break;
			
			// find length of break (start time of next usage - end time of last usage)
			int a = arr[i+1][0]-arr[i][1];
			
			if (a<=T1) { // if screensavor is not reached
				totPower += a*P1;
				continue;
			}
			
			// if screensavor is reached
			totPower += T1*P1;
			a -= T1; // total time on screensavor (or sleep mode)
			
			if (a<=T2) {// if sleep mode is not reached
				totPower += a*P2;
				continue;
			}
			
			// if sleep mode is reached
			totPower += T2*P2;
			a -= T2;
			
			// the remaining time will run on P3
			totPower += a*P3;
		}
		
		// add power used during final usage
		totPower += P1*(arr[n-1][1] - arr[n-1][0]);
		System.out.println(totPower);
	}
}
