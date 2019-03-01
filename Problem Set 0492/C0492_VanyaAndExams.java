/*

C - Vanya and Exams

Vanya wants to pass n exams and get the academic scholarship. He will get the scholarship 
if the average grade mark for all the exams is at least avg. The exam grade cannot exceed 
r. Vanya has passed the exams and got grade ai for the i-th exam. To increase the grade 
for the i-th exam by 1 point, Vanya must write bi essays. He can raise the exam grade 
multiple times. What is the minimum number of essays that Vanya needs to write to get 
scholarship?

Input
The first line contains three integers n, r, avg (1 <= n <= 10^5, 1 <= r <= 10^9, 
1 <= avg <= min(r, 10^6)) - the number of exams, the maximum grade and the required grade 
point average, respectively. Each of the following n lines contains space-separated integers 
ai and bi (1 <= ai <= r, 1 <= bi <= 10^6).

Output
In the first line print the minimum number of essays.

--------------------------------------------------------------------------------------------*/

import java.util.*;
public class C0492_VanyaAndExams {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long numExams = sc.nextInt();
		long maxGrade = sc.nextInt();
		long avg = sc.nextInt();
		long[][] arr = new long[(int) numExams][2];
		
		long sumScores = 0;
		for (int i=0; i<numExams; i++) {
			arr[i][1] = sc.nextLong();
			arr[i][0] = sc.nextLong();
			sumScores += arr[i][1];
		}
		sc.close();
		
		long ans = 0;
		if (avg*numExams > sumScores) {
			arr = sort(arr);
			long pointsRemaining = numExams*avg - sumScores;
			for (int i=0; i<numExams; i++) {
				if (pointsRemaining <= 0)
					break;
				if (arr[i][1] == maxGrade)
					continue;
				long pts = maxGrade - arr[i][1];
				if (pointsRemaining >= pts) {
					ans += (arr[i][0]*pts);
					pointsRemaining -= pts;
				}
				else {
					ans += (arr[i][0]*pointsRemaining);
					break;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static long[][] sort(long[][] arr) {
		int n = arr.length;
	    int mid = n/2;
	    if (n >= 2) {
	    	long[][] l = new long[mid][2];
	        long[][] r = new long[n-mid][2];
	        for(int i=0; i<mid; i++) {
	        	l[i][0] = arr[i][0];
	           	l[i][1] = arr[i][1];
	        }
	        for(int i=mid; i<n; i++) {
	        	r[i-mid][0] = arr[i][0];
	        	r[i-mid][1] = arr[i][1];
	        }
	        sort(l);
	        sort(r);
	        int leftPos = 0, rightPos = 0, pos = 0;
	       	while (leftPos < l.length && rightPos < r.length){
	    	   	if (l[leftPos][0] < r[rightPos][0]){
	    	   		arr[pos][0] = l[leftPos][0];
	    	   		arr[pos][1] = l[leftPos][1];
	    	   		leftPos++;
	    	   		pos++;
	    	   	}
	    	   	else {
	    	   		arr[pos][0] = r[rightPos][0];
	    	   		arr[pos][1] = r[rightPos][1];
	    	   		rightPos++;
	    	   		pos++;
	    	   	}
	       	}
	       	while(leftPos < l.length){
	       		arr[pos][0] = l[leftPos][0];
	       		arr[pos][1] = l[leftPos][1];
	       		leftPos++;
	       		pos++;
	       	}
	       	while(rightPos < r.length){
	       		arr[pos][0] = r[rightPos][0];
	       		arr[pos][1] = r[rightPos][1];
	       		rightPos++;
	       		pos++;
	       	} 
	    }
	    return arr;
	}
}