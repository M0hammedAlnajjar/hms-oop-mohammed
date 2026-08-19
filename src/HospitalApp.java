import entities.Person;

public class HospitalApp {

    // Print all person information
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
    }

}