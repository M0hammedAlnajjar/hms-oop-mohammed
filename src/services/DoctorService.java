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

        Doctor[] allDoctors = new Doctor[doctorCount];

        for (int i = 0; i < doctorCount; i++) {
            allDoctors[i] = doctors[i];
        }

        return allDoctors;
    }

    @Override
    public Object[] search(String keyword) {

        Doctor[] results = new Doctor[doctorCount];
        int resultCount = 0;

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i].getFirstName().equalsIgnoreCase(keyword)
                    || doctors[i].getLastName().equalsIgnoreCase(keyword)
                    || doctors[i].getSpecialization().equalsIgnoreCase(keyword)) {

                results[resultCount] = doctors[i];
                resultCount++;
            }
        }

        Doctor[] finalResults = new Doctor[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }
    @Override
    public Object searchById(String id) {

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }

        return null;
    }

    private Doctor[] doctors = new Doctor[10];
    private int doctorCount = 0;
}
