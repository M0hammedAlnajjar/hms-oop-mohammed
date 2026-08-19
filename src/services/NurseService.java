package services;
import interfaces.Manageable;
import interfaces.Searchable;
import entities.Nurse;
public class NurseService implements Manageable, Searchable {
    @Override
    public void add(Object entity) {

        if (entity instanceof Nurse) {
            nurses[nurseCount] = (Nurse) entity;
            nurseCount++;
        }
    }

    @Override
    public void removeById(String id) {

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i].getId().equals(id)) {

                for (int j = i; j < nurseCount - 1; j++) {
                    nurses[j] = nurses[j + 1];
                }

                nurses[nurseCount - 1] = null;
                nurseCount--;

                return;
            }
        }
    }

    @Override
    public Object[] getAll() {

        Nurse[] allNurses = new Nurse[nurseCount];

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

            if (nurses[i].getFirstName().equalsIgnoreCase(keyword)
                    || nurses[i].getLastName().equalsIgnoreCase(keyword)) {

                results[resultCount] = nurses[i];
                resultCount++;
            }
        }

        Nurse[] finalResults = new Nurse[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }

    @Override
    public Object searchById(String id) {

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i].getId().equals(id)) {
                return nurses[i];
            }
        }

        return null;
    }
    // List nurses by shift
    public Nurse[] listByShift(String shift) {

        Nurse[] results = new Nurse[nurseCount];
        int resultCount = 0;

        for (int i = 0; i < nurseCount; i++) {

            if (nurses[i].getShift().equalsIgnoreCase(shift)) {
                results[resultCount] = nurses[i];
                resultCount++;
            }
        }

        Nurse[] finalResults = new Nurse[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }
    // Store nurses without generics
    private Nurse[] nurses = new Nurse[10];
    private int nurseCount = 0;
}
