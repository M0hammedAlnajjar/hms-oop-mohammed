package services;

import interfaces.Manageable;
import interfaces.Searchable;

public class RecordService implements Manageable, Searchable {

    @Override
    public void add(Object entity) {

    }

    @Override
    public void removeById(String id) {

    }

    @Override
    public Object[] getAll() {
        return new Object[0];
    }

    @Override
    public Object[] search(String keyword) {
        return new Object[0];
    }

    @Override
    public Object searchById(String id) {
        return null;
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



}