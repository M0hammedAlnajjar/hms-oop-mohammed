package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;

public class DoctorService implements Manageable, Searchable {

    private Doctor[] doctors = new Doctor[10];
    private int doctorCount = 0;


    @Override
    public void add(Object entity) {

        if (!(entity instanceof Doctor)) {
            System.out.println("Invalid doctor.");
            return;
        }

        if (doctorCount >= doctors.length) {
            System.out.println("Doctor storage is full.");
            return;
        }

        doctors[doctorCount] = (Doctor) entity;
        doctorCount++;
    }


    @Override
    public void removeById(String id) {

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] != null
                    && doctors[i].getId() != null
                    && doctors[i].getId().equals(id)) {

                for (int j = i; j < doctorCount - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }

                doctors[doctorCount - 1] = null;
                doctorCount--;

                return;
            }
        }

        System.out.println("Doctor not found.");
    }


    @Override
    public Object[] getAll() {

        Doctor[] allDoctors =
                new Doctor[doctorCount];

        for (int i = 0; i < doctorCount; i++) {
            allDoctors[i] = doctors[i];
        }

        return allDoctors;
    }


    @Override
    public Object[] search(String keyword) {

        Doctor[] results =
                new Doctor[doctorCount];

        int resultCount = 0;

        if (keyword == null || keyword.isBlank()) {
            return new Doctor[0];
        }

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] == null) {
                continue;
            }

            String firstName =
                    doctors[i].getFirstName();

            String lastName =
                    doctors[i].getLastName();

            String specialization =
                    doctors[i].getSpecialization();

            if ((firstName != null
                    && firstName.equalsIgnoreCase(keyword))
                    ||
                    (lastName != null
                            && lastName.equalsIgnoreCase(keyword))
                    ||
                    (specialization != null
                            && specialization.equalsIgnoreCase(keyword))) {

                results[resultCount] = doctors[i];
                resultCount++;
            }
        }

        Doctor[] finalResults =
                new Doctor[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }


    @Override
    public Object searchById(String id) {

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] != null
                    && doctors[i].getId() != null
                    && doctors[i].getId().equals(id)) {

                return doctors[i];
            }
        }

        return null;
    }


    // Add a surgeon
    public void addSurgeon(Surgeon surgeon) {

        if (surgeon == null) {
            System.out.println("Invalid surgeon.");
            return;
        }

        if (doctorCount >= doctors.length) {
            System.out.println("Doctor storage is full.");
            return;
        }

        doctors[doctorCount] = surgeon;
        doctorCount++;
    }


    // Assign a patient to a doctor
    public void assignPatient(
            String doctorId,
            String patientId
    ) {

        Doctor doctor =
                (Doctor) searchById(doctorId);

        if (doctor == null) {

            System.out.println("Doctor not found.");
            return;
        }

        doctor.assignPatient(patientId);
    }


    // List doctors by specialization
    public Doctor[] listBySpecialization(
            String specialization
    ) {

        Doctor[] results =
                new Doctor[doctorCount];

        int resultCount = 0;

        if (specialization == null
                || specialization.isBlank()) {

            return new Doctor[0];
        }

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] != null
                    && doctors[i].getSpecialization() != null
                    && doctors[i]
                    .getSpecialization()
                    .equalsIgnoreCase(specialization)) {

                results[resultCount] = doctors[i];
                resultCount++;
            }
        }

        Doctor[] finalResults =
                new Doctor[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }


    // List available doctors
    public Doctor[] availableDoctors() {

        Doctor[] results =
                new Doctor[doctorCount];

        int resultCount = 0;

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] != null
                    && doctors[i].isOnCall()) {

                results[resultCount] = doctors[i];
                resultCount++;
            }
        }

        Doctor[] finalResults =
                new Doctor[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }
}