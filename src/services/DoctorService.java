package services;
import interfaces.Manageable;
import interfaces.Searchable;
import entities.Doctor;

public class DoctorService implements Manageable, Searchable {
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

    private Doctor[] doctors = new Doctor[10];
    private int doctorCount = 0;
}
