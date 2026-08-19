package services;
import interfaces.Manageable;
import interfaces.Searchable;
import entities.Doctor;

public class DoctorService implements Manageable, Searchable {
    @Override
    public void add(Object entity) {

        if (entity instanceof Doctor) {
            doctors[doctorCount] = (Doctor) entity;
            doctorCount++;
        }
    }

    @Override
    public void removeById(String id) {

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i].getId().equals(id)) {

                for (int j = i; j < doctorCount - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }

                doctors[doctorCount - 1] = null;
                doctorCount--;

                return;
            }
        }
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
