/*

B - Spreadsheets 

In the popular spreadsheets systems (for example, in Excel) the following numeration of columns 
is used. The first column has number A, the second — number B, etc. till column 26 that is 
marked by Z. Then there are two-letter numbers: column 27 has number AA, 28 — AB, column 52 is 
marked by AZ. After ZZ there follow three-letter numbers, etc. The rows are marked by integer 
numbers starting with 1. The cell name is the concatenation of the column and the row numbers. 
For example, BC23 is the name for the cell that is in column 55, row 23. Sometimes another 
numeration system is used: RXCY, where X and Y are integer numbers, showing the column and the 
row numbers respectfully. For instance, R23C55 is the cell from the previous example. Your task 
is to write a program that reads the given sequence of cell coordinates and produce each item 
written according to the rules of another numeration system.

Input
The first line of the input contains integer number n (1 <= n <= 10^5), the number of coordinates 
in the test. Then there follow n lines, each of them contains coordinates. All the coordinates 
are correct, there are no cells with the column and/or the row numbers larger than 106.

Output
Write n lines, each line should contain a cell coordinates in the other numeration system.

------------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class B0001_Spreadsheets {
	public static String A = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			String str = sc.next();
			
			// for each input, determine the numeration system (either RXCY or CR)
			boolean rxcy = false;
			if (str.charAt(0)=='R' && Character.isDigit(str.charAt(1)))
				for (int j=1; j<str.length(); j++)
					if (str.charAt(j)=='C')
						rxcy = true;
			
			if (rxcy)
				System.out.println(toCR(str));
			else
				System.out.println(toRXCY(str));
		}
		sc.close();
	}
	
	// Method converts from CR to RXCY
	public static String toRXCY(String str) {
		String res = "R", col = "";
		
		// find the row number (and add to res) and the letters for col
		for (int i=1; i<str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				res += str.substring(i);
				col = str.substring(0, i);
				break;
			}
		}
		
		// convert col letters into a number
		int colNum = A.indexOf(col.charAt(col.length()-1)), pow = 1;
		for (int i=col.length()-2; i>=0; i--) {
			colNum += A.indexOf(col.charAt(i))*Math.pow(26, pow);
			pow++;
		}
		
		// add col number to res
		res += "C" + Integer.toString(colNum);
		
		return res;
	}
	
	// Method converts from RXCY to CR
	public static String toCR(String str) {
		String res = "", row = "";
		int col = 0;
		
		//find the column number (Y from RXCY) and row number (X from RXCY)
		for (int i=2; i<str.length(); i++) {
			if (str.charAt(i)=='C') {
				col = Integer.parseInt(str.substring(i+1));
				row = str.substring(1, i);
			}
		}
		
		// convert column number into letters
		String colStr = "";
		while (col > 0) {
			if (col%26==0) {
				colStr += "Z";
				col = col/26-1;
			}
			else {
				colStr += A.charAt(col%26);
				col /= 26;
			}
		}
		
		// letters are in reverse order: reverse them, add to res
		for (int i=colStr.length()-1; i>=0; i--)
			res += colStr.substring(i, i+1);
		
		// add row number
		res += row;
		
		return res;
	}
}