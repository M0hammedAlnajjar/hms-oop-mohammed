package services;

import entities.Nurse;
import interfaces.Manageable;
import interfaces.Searchable;

public class NurseService implements Manageable, Searchable {

    private Nurse[] nurses = new Nurse[10];
    private int nurseCount = 0;


    public NurseService() {

        seed(
                "N001",
                "Aisha",
                "Salem",
                "1995-01-10",
                "Female",
                "91111111",
                "aisha@gmail.com",
                "Muscat",
                "30001",
                31,
                true,
                "DEP01",
                "Morning",
                5
        );

        seed(
                "N002",
                "Salim",
                "Ahmed",
                "1993-04-12",
                "Male",
                "92222222",
                "salim@gmail.com",
                "Seeb",
                "30002",
                33,
                true,
                "DEP02",
                "Evening",
                7
        );

        seed(
                "N003",
                "Maryam",
                "Ali",
                "1998-09-20",
                "Female",
                "93333333",
                "maryam@gmail.com",
                "Bawshar",
                "30003",
                28,
                true,
                "DEP01",
                "Night",
                3
        );
    }


    private void seed(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nationalId,
            int age,
            boolean active,
            String departmentId,
            String shift,
            int yearsOfService
    ) {

        Nurse nurse = new Nurse(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                nationalId,
                age,
                active,
                departmentId,
                shift,
                new String[0],
                yearsOfService
        );

        add(nurse);
    }


    @Override
    public void add(Object entity) {

        if (!(entity instanceof Nurse)) {
            System.out.println("Invalid nurse.");
            return;
        }

        if (nurseCount >= nurses.length) {
            System.out.println("Nurse storage is full.");
            return;
        }

        nurses[nurseCount] = (Nurse) entity;
        nurseCount++;
    }


    @Override
    public void removeById(String id) {

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i] != null
                    && nurses[i].getId().equalsIgnoreCase(id)) {

                for (int j = i; j < nurseCount - 1; j++) {
                    nurses[j] = nurses[j + 1];
                }

                nurses[nurseCount - 1] = null;
                nurseCount--;

                System.out.println("Nurse removed successfully.");
                return;
            }
        }

        System.out.println("Nurse not found.");
    }


    @Override
    public Object[] getAll() {

        Nurse[] allNurses =
                new Nurse[nurseCount];

        for (int i = 0; i < nurseCount; i++) {
            allNurses[i] = nurses[i];
        }

        return allNurses;
    }


    @Override
    public Object[] search(String keyword) {

        Nurse[] results = new Nurse[nurseCount];
        int resultCount = 0;

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i] != null
                    && (nurses[i].getFirstName()
                    .equalsIgnoreCase(keyword)

                    || nurses[i].getLastName()
                    .equalsIgnoreCase(keyword))) {

                results[resultCount] = nurses[i];
                resultCount++;
            }
        }

        Nurse[] finalResults =
                new Nurse[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }


    @Override
    public Object searchById(String id) {

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i] != null
                    && nurses[i].getId()
                    .equalsIgnoreCase(id)) {

                return nurses[i];
            }
        }

        return null;
    }


    public Nurse[] listByShift(String shift) {

        Nurse[] results = new Nurse[nurseCount];
        int resultCount = 0;

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i] != null
                    && nurses[i].getShift()
                    .equalsIgnoreCase(shift)) {

                results[resultCount] = nurses[i];
                resultCount++;
            }
        }

        Nurse[] finalResults =
                new Nurse[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }


    public void reassign(
            String nurseId,
            String newShift
    ) {

        Nurse nurse =
                (Nurse) searchById(nurseId);

        if (nurse == null) {
            System.out.println("Nurse not found.");
            return;
        }

        nurse.setShift(newShift);

        System.out.println(
                "Nurse reassigned successfully."
        );
    }
}