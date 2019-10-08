

package isLeapYear;

import java.util.Scanner;

public class isLeapYear {

	public isLeapYear(int year) {
		
		
		
	}
	public static void main(String[] args){
		
		Scanner setYear = new Scanner(System.in);
		System.out.println("Please input a year to check if it's leap:");
		int setyear = setYear.nextInt();
		
		isLeapYear(setyear);
		
		
		
	}
	private static void isLeapYear(int year) {

		if (year%400==0 || year%100!=0 &&(year%4==0))
			System.out.println("It is a leap year!");
		else
			System.out.println("It is not a leap year");
		
		
	}
	
	
}
