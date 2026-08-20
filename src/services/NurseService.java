package services;

import entities.Nurse;
import interfaces.Manageable;
import interfaces.Searchable;

public class NurseService implements Manageable, Searchable {

    // Store nurses without generics
    private Nurse[] nurses = new Nurse[10];
    private int nurseCount = 0;


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
                    && nurses[i].getId() != null
                    && nurses[i].getId().equals(id)) {

                for (int j = i;
                     j < nurseCount - 1;
                     j++) {

                    nurses[j] = nurses[j + 1];
                }

                nurses[nurseCount - 1] = null;
                nurseCount--;

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

        Nurse[] results =
                new Nurse[nurseCount];

        int resultCount = 0;

        if (keyword == null || keyword.isBlank()) {
            return new Nurse[0];
        }

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i] == null) {
                continue;
            }

            String firstName =
                    nurses[i].getFirstName();

            String lastName =
                    nurses[i].getLastName();

            if ((firstName != null
                    && firstName.equalsIgnoreCase(keyword))
                    ||
                    (lastName != null
                            && lastName.equalsIgnoreCase(keyword))) {

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
                    && nurses[i].getId() != null
                    && nurses[i].getId().equals(id)) {

                return nurses[i];
            }
        }

        return null;
    }


    // List nurses by shift
    public Nurse[] listByShift(String shift) {

        Nurse[] results =
                new Nurse[nurseCount];

        int resultCount = 0;

        if (shift == null || shift.isBlank()) {
            return new Nurse[0];
        }

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i] != null
                    && nurses[i].getShift() != null
                    && nurses[i]
                    .getShift()
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


    // Reassign nurse to another shift
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
    }
}