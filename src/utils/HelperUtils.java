package utils;

public class HelperUtils {
    public static String formatName(
            String firstName,
            String lastName
    ) {
        return firstName + " " + lastName;
    }

    // Format name with optional uppercase
    public static String formatName(
            String firstName,
            String lastName,
            boolean upper
    ) {

        String fullName = firstName + " " + lastName;

        if (upper) {
            return fullName.toUpperCase();
        }

        return fullName;
    }
}

