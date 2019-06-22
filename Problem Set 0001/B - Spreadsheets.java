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

import java.io.*;
import java.util.*;
public class B0001_Spreadsheets {
	
	static final String A = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<n; i++) {
			String str = in.next();
			
			boolean rxcy = false;
			if (str.charAt(0) == 'R' && Character.isDigit(str.charAt(1)))
				for (int j=2; j<str.length(); j++)
					if (str.charAt(j) == 'C')
						rxcy = true;
			
			if (rxcy)
				sb.append(toCR(str) + "\n");
			else
				sb.append(toRXCY(str) + "\n");
		}
		System.out.println(sb);
	}
	
	public static String toRXCY(String str) {
		String row = "", col = "";
		for (int i=1; i<str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				row += str.substring(i);
				col = str.substring(0, i);
				break;
			}
		}
		
		int colNum = A.indexOf(col.charAt(col.length()-1)), pow = 1;
		for (int i=col.length()-2; i>=0; i--)
			colNum += A.indexOf(col.charAt(i))*Math.pow(26, pow++);
		return "R" + row + "C" + Integer.toString(colNum);
	}
	
	public static String toCR(String str) {
		String row = "";
		int colNum = 0;
		for (int i=2; i<str.length(); i++) {
			if (str.charAt(i) == 'C') {
				colNum = Integer.parseInt(str.substring(i+1));
				row = str.substring(1, i);
				break;
			}
		}
		
		String col = "";
		while (colNum > 0) {
			if (colNum%26 == 0) {
				col += "Z";
				colNum = colNum/26 - 1;
			}
			else {
				col += A.charAt(colNum%26);
				colNum /= 26;
			}
		}
		
		col = reverseOrder(col);
		return col + row;
	}
	
	public static String reverseOrder(String str) {
		String res = "";
		for (int i=str.length()-1; i>=0; i--)
			res += str.substring(i, i+1);
		return res;
	}
	
	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}
		
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
