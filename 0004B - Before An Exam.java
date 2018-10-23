/*

B - Before An Exam

Tomorrow Peter has a Biology exam. He does not like this subject much, but d days ago he learnt that he would 
have to take this exam. Peter's strict parents made him prepare for the exam immediately, for this purpose he 
has to study not less than minTimei and not more than maxTimei hours per each i-th day. Moreover, they warned 
Peter that a day before the exam they would check how he has followed their instructions.
So, today is the day when Peter's parents ask him to show the timetable of his preparatory studies. But the 
boy has counted only the sum of hours sumTime spent him on preparation, and now he wants to know if he can 
show his parents a timetable schedule with d numbers, where each number schedulei stands for the time in hours 
spent by Peter each i-th day on biology studies, and satisfying the limitations imposed by his parents, and at 
the same time the sum total of all schedulei should equal to sumTime.

Input
The first input line contains two integer numbers d, sumTime (1 <= d <= 30, 0 <= sumTime <= 240) — the amount 
of days, during which Peter studied, and the total amount of hours, spent on preparation. Each of the following 
d lines contains two integer numbers minTimei, maxTimei (0 <= minTimei <= maxTimei <= 8), separated by a space — 
minimum and maximum amount of hours that Peter could spent in the i-th day.

Output
In the first line print YES, and in the second line print d numbers (separated by a space), each of the numbers 
— amount of hours, spent by Peter on preparation in the corresponding day, if he followed his parents' 
instructions; or print NO in the unique line. If there are many solutions, print any of them.

--------------------------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class B0004_BeforeAnExam {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numDays = sc.nextInt(), sumTime = sc.nextInt();
		int minTime = 0, maxTime = 0;
		int[][] arr = new int[numDays][2];
		
		for (int i=0; i<numDays; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			minTime += arr[i][0];
			maxTime += arr[i][1];
		}
		sc.close();
		
		if (sumTime >= minTime && sumTime <= maxTime) {
			System.out.println("YES");
			int[] ans = findTimeStudied(numDays, minTime, maxTime, sumTime, arr);
			for (int i=0; i<numDays; i++)
				System.out.print(ans[i] + " ");
		}
		else
			System.out.println("NO");
	}
	
	public static int[] findTimeStudied(int days, int min, int max, int sum, int[][] times) {
		int[] arr = new int[days];
		for (int i=0; i<days; i++) {
			min -= times[i][0];
			max -= times[i][1];
			sum -= times[i][1];
			
			if (sum <= max && sum >= min)
				arr[i] = times[i][1];
			else {
				arr[i] = times[i][1] - (min-sum);
				sum += min-sum;
			}
		}
		return arr;
	}
}
