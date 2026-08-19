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
}