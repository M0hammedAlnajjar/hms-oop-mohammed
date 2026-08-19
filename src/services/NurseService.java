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
    // Store nurses without generics
    private Nurse[] nurses = new Nurse[10];
    private int nurseCount = 0;
}
