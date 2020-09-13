import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //This method is complete. Do not change it.

        Main m = new Main();
        String number = m.getTheNumber();
        int d = m.getTheDigit();
        m.add(number, d);
    }

    private String getTheNumber() {
        //As long as the user does not enter a string of digits keep asking the
        // user to enter an unsigned integer.
        System.out.println("Enter an unsigned integer.");
        Scanner keyboard = new Scanner(System.in);
        String number = keyboard.nextLine();

        //Complete the rest of this method.
        while (!isAllDigits(number)) {
            System.out.println("Please enter an unsigned integer.");
            number = keyboard.nextLine();
        }

        //keyboard.close();
        return number;
    }

    private int getTheDigit() {
        //As long as the user does not enter a digit keep asking the user to enter
        // a digit.
        System.out.println("Enter a single digit:");
        Scanner keyboard = new Scanner(System.in);
        String number = keyboard.nextLine();

        //Complete the rest of this method.
        while (!isSingleDigit(number)) {
            System.out.println("Please enter a single digit.");
            number = keyboard.nextLine();
        }

        //keyboard.close();
        return Integer.valueOf(number);
    }

    private void add(String number, int d) {
        //Complete the this method. At the end of this method
        //print the result.

        System.out.println("The result is:");
        BigInteger bigInt = new BigInteger(number);

        BigInteger result = bigInt.add(BigInteger.valueOf(Integer.valueOf(d)));
        System.out.println(result);
    }

    private boolean isAllDigits(String s) {
        if (s.length() == 0) {
            return false;
        }

        for (var i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isSingleDigit(String s) {
        if (s.length() == 0) {
            return false;
        }

        if (s.length() > 1) {
            return false;
        }

        if (!Character.isDigit(s.charAt(0))) {
            return false;
        }

        return true;
    }
}
