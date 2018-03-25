/* 
 
 I have implemented the possibility of choosing what type of search algorithm the user can choose.
 
 For my Macbook Pro, this program prints approximately 200k dots in 10 seconds.
 
 Having tested it with both search algorithms multiple times, 
 I have concluded that depending on how many programs, Chrome tabs and what sites I have opened in them, 
 the number of print_loop iterations may vary.

*/

import java.util.Scanner;

public class benchMark {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i = 0; //counter
		System.out.println("First, let's see how many dots your laptop can print in 10 seconds. Type s to start and anything else to exit: ");
		String x = input.nextLine();
		if (x.equals("s")) {
			long zeroTime = System.currentTimeMillis();
			while (System.currentTimeMillis()-zeroTime !=10000) {
				System.out.println(".");
				i += 1;
			}
			System.out.printf("Your laptop can print a dot %d times in 10 seconds \n \n",i);
			while (true) {
				System.out.println("Next, what type of search algorithm would you like to use? (l for linear, b for binary)");
				String a = input.nextLine();
				if (a.equals("l")) {
					linSearch();
				}
				else if (a.equals("b")) {
					binSearch();
				}
				else {
					System.out.println("Invalid input, try again!");
				}
			}
		}
		else {
			System.exit(0);
		}
	}
	public static int print_loop(int n) {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < 100000; i++) {
				System.out.println(".");
			}
		}
		return 1;
	}
	
	public static void linSearch() {
		int nValue = 0;
		for (int n = 0; n < 30; n++) {
			long startTime = System.currentTimeMillis();
			print_loop(n);
			long endTime = System.currentTimeMillis();
			if (endTime-startTime > 10000) {
				nValue = n;
				break;
			}
		}
		System.out.printf("The print_loop method was called %d times", nValue);
		System.exit(0);
	}
	
	public static void binSearch() {
		int nValue = 0;
		int low = 0;
		int high = 30;
		int count = 0;
		while (high >= low) {
			int mid = (low+high)/2;
			long startTime = System.currentTimeMillis();
			print_loop(mid);
			long endTime = System.currentTimeMillis();
			if (endTime-startTime > 10000) {
				high = mid - 1;
			}
			else if (endTime-startTime <= 10000) {
				low = mid + 1;
			}
			nValue = mid;
			count += 1;
		}
		System.out.printf("The print_loop method was called %d times", count);
		System.exit(0);
	}
}
