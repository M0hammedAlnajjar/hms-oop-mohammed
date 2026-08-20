package utils;

import entities.Person;

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

    }// Read a value from an allowed set
    public String readFromAllowedSet(String message, String[] allowedValues) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            for (String value : allowedValues) {

                if (value.equalsIgnoreCase(input)) {
                    return input;
                }
            }

            System.out.println("Invalid value. Try again.");
        }
    }// Print all person information
    public static void printAll(Person[] people) {

        for (Person person : people) {
            person.displayInfo();
        }
    }

    // Count persons by type
    public static int countByType(
            Person[] people,
            String type
    ) {

        int count = 0;

        for (Person person : people) {

            if (person.getClass()
                    .getSimpleName()
                    .equalsIgnoreCase(type)) {

                count++;
            }
        }

        return count;
    }

    // Find the oldest person
    public static Person findOldest(Person[] people) {

        if (people == null || people.length == 0) {
            return null;
        }

        Person oldest = people[0];

        for (Person person : people) {

            if (person.getAge() > oldest.getAge()) {
                oldest = person;
            }
        }

        return oldest;
    }
    // Check if email is valid
    public static boolean isValidEmail(String email) {

        return email != null
                && email.contains("@")
                && email.contains(".");
    }
    // Check if phone number is valid
    public static boolean isValidPhone(String phone) {

        return phone != null
                && !phone.isBlank();
    }
    // Check if date is valid
    public static boolean isValidDate(String date) {

        return date != null
                && !date.isBlank();
    }
    // Calculate age from birth year
    public static int calculateAge(int birthYear, int currentYear) {

        return currentYear - birthYear;
    }
    // Format a date
    public static String formatDate(String date) {
        return date;
    }
    // Generate an ID
    public static String generateId(String prefix, int number) {
        return prefix + number;
    }
    // Calculate BMI
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    // Check if password is strong
    public static boolean isStrongPassword(String password) {

        return password != null
                && password.length() >= 8;
    }

    // Mask national ID
    public static String maskNationalId(String nationalId) {

        if (nationalId == null) {
            return null;
        }

        return "****" + nationalId.substring(nationalId.length() - 4);
    }
    // Check if the day is a working day
    public static boolean isWorkingDay(String day) {

        return day != null
                && !day.equalsIgnoreCase("Friday")
                && !day.equalsIgnoreCase("Saturday");
    }

    // Calculate discount
    public static double calculateDiscount(double amount, double discountPercentage) {
        return amount * discountPercentage / 100;
    }
    // Calculate days between two days
    public static int daysBetween(int startDay, int endDay) {
        return endDay - startDay;
    }
    // Capitalize words
    public static String capitalizeWords(String text) {

        if (text == null || text.isBlank()) {
            return text;
        }

        String[] words = text.split(" ");
        String result = "";

        for (String word : words) {
            result += word.substring(0, 1).toUpperCase()
                    + word.substring(1).toLowerCase()
                    + " ";
        }

        return result.trim();
    }
    // Safely convert String to int
    public static int safeParseInt(String value) {

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }

    }// Safely convert String to double
    public static double safeParseDouble(String value) {

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }

    }}