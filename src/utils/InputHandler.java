package utils;

import java.util.Scanner;

public class InputHandler {

    private Scanner scanner = new Scanner(System.in);


    // Read text from the user
    public String readText(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            if (HelperUtils.isValidText(input)) {
                return input;
            }

            System.out.println(
                    "Text cannot be empty. Try again."
            );
        }
    }


    // Read a whole number
    public int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number. Try again."
                );
            }
        }
    }


    // Read a whole number within a range
    public int readIntInRange(
            String message,
            int min,
            int max
    ) {

        while (true) {

            int number =
                    readInt(message);

            if (number >= min
                    && number <= max) {

                return number;
            }

            System.out.println(
                    "Number must be between "
                            + min
                            + " and "
                            + max
            );
        }
    }


    // Read a decimal number
    public double readDouble(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid decimal number. Try again."
                );
            }
        }
    }


    // Read yes or no confirmation
    public boolean readYesNo(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                return true;
            }

            if (input.equalsIgnoreCase("no")) {
                return false;
            }

            System.out.println(
                    "Please enter yes or no."
            );
        }
    }


    // Read a value from allowed values
    public String readFromAllowedSet(
            String message,
            String[] allowedValues
    ) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            if (HelperUtils.isOneOf(
                    input,
                    allowedValues
            )) {

                return input;
            }

            System.out.println(
                    "Invalid value. Try again."
            );
        }

    }
    // Read and validate email
    public String readEmail(String message) {

        while (true) {

            System.out.print(message);

            String email =
                    scanner.nextLine();

            if (HelperUtils.isValidEmail(email)) {
                return email;
            }

            System.out.println(
                    "Invalid email. Example: name@gmail.com"
            );
        }
    }
}