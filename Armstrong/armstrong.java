import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String args[]) {

        int input, store, output=0, mod;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number to check:");
        input = in.nextInt();
        store = input;
        while(input != 0) {
            mod = input % 10;
            output = output + (mod * mod * mod);
            input = input / 10;
        }
        System.out.println(output);

        if(store == output) {
            System.out.println("This is an armstrong number.");
        } else {
            System.out.println("This is not an armstrong number.");
        }
        in.close();
    }
}