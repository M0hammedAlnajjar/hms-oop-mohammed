
import java.util.Scanner;

public class InputHandler {

    private Scanner scanner = new Scanner(System.in);

    // Read text from the user
    public String readText(String message) {

        System.out.print(message);
        return scanner.nextLine();
    }
    // Read a whole number from the user
    public int readInt(String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }// Read a whole number within a range
    public int readIntInRange(String message, int min, int max) {

        while (true) {

            int number = readInt(message);

            if (number >= min && number <= max) {
                return number;
            }

            System.out.println("Number must be between " + min + " and " + max);
        }
    }// Read a decimal number from the user
    public double readDouble(String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal number. Try again.");
            }
        }
    }// Read yes or no confirmation
    public boolean readYesNo(String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                return true;
            }

            if (input.equalsIgnoreCase("no")) {
                return false;
            }

            System.out.println("Please enter yes or no.");
        }
    }
}