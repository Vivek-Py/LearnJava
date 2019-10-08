import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int num, temp, sum = 0, k ;

        //Input from the user
        System.out.println("Enter a number to check if it is an Armstrong number or not:");
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        temp = num;
        //A positive number is called armstrong number if it is equal to the sum of cubes of its digits for example-- 153 = 1^3 + 5^3 + 3^3
        //Let us take 'num' as '153'
        while (num > 0) {                // while(153 > 0)          |  while(15 > 0)            |   while(1 > 0)
            k = num % 10;                // k = 3;                  |  k = 5;                   |   k = 1;
            sum = (k * k * k) + sum;     // sum = (3 * 3 * 3) + 0;  |  sum = (5 * 5 * 5) + 27;  |   sum = (1 * 1 * 1) + 152;
            num = num / 10;              // num = 15                |  num = 1                  |   num = 0
         }
        //After while loop value of 'sum' becomes 153.
        //Since value of 'sum' is equal to the value of 'temp',the condition for the if statement will be satisfied.
        if (temp == sum) {
            System.out.println("It is an armstrong number: ");
        } else {
            System.out.println("It is not an armstrong number: ");
        }
    }
}


