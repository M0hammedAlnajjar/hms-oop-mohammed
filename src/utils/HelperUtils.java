package utils;

public class HelperUtils {

    // Format first name and last name
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

        String fullName =
                firstName + " " + lastName;

        if (upper) {
            return fullName.toUpperCase();
        }

        return fullName;
    }


    // Check if a value exists in allowed values
    public static boolean isOneOf(
            String status,
            String[] allowed
    ) {

        if (status == null || allowed == null) {
            return false;
        }

        for (String value : allowed) {

            if (value != null
                    && value.equalsIgnoreCase(status)) {

                return true;
            }
        }

        return false;
    }


    // Check if text is valid
    public static boolean isValidText(
            String text
    ) {

        return text != null
                && !text.isBlank();
    }
}