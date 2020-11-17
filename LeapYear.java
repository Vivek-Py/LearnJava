import java.util.*;

public class LeapYear {
    public static void main(String[] args) {
        int year;
        {          //create scanner object
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter year to check: ");
            year = sc.nextInt();
                    //check if its a leap year or not
            if ((year % 4 == 0) && year % 100 != 0) {
                      //printing the result
                System.out.println(year + " is a leap year.");
            } else if ((year % 4 == 0) && (year % 100 == 0)
                    && (year % 400 == 0)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }
    }
}
