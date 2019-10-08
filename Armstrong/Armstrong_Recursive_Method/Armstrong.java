// Java program to determine whether the number is Armstrong number or not 
import java.util.Scanner;
class Armstrong 
{ 
	/* Function to calculate x raised to the power y */
	/* Using Recursion */
	int power(int x, long y) 
	{ 
		if( y == 0) 
			return 1; 
		if (y%2 == 0) 
			return power(x, y/2)*power(x, y/2); 
		return x*power(x, y/2)*power(x, y/2); 
	} 

	/* Function to calculate order of the number */
	int order(int x) 
	{ 
		int n = 0; 
		while (x != 0) 
		{ 
			n++; 
			x = x/10; 
		} 
		return n; 
	} 

	// Function to check whether the given number is 
	// Armstrong number or not 
	boolean isArmstrong (int x) 
	{ 
		// Calling order function 
		int n = order(x); 
		int temp=x, sum=0; 
		while (temp!=0) 
		{ 
			int r = temp%10; 
			sum = sum + power(r,n); 
			temp = temp/10; 
		} 

		// If satisfies Armstrong condition 
		return (sum == x); 
	} 

	// Driver Program 
	public static void main(String[] args) 
	{ 
		Armstrong ob = new Armstrong(); 
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a number to check if it is an Armstrong Number = ");
		int x = s.nextInt();
		if(ob.isArmstrong(x)) System.out.println("The number is an Armstrong Number !");
		else System.out.println("The number is NOT an Armstrong Number !");
	} 
} 