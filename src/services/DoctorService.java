package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;

public class DoctorService implements Manageable, Searchable {

    private Doctor[] doctors = new Doctor[10];
    private int doctorCount = 0;


    // =========================
    // Constructor - Seed Data
    // =========================

    public DoctorService() {

        seed(
                "D001",
                "Ahmed",
                "Said",
                "1985-05-10",
                "Male",
                "91230001",
                "ahmed.doctor@gmail.com",
                "Muscat",
                "20001",
                41,
                true,
                25.0,
                12,
                true,
                "Cardiology"
        );

        seed(
                "D002",
                "Sara",
                "Ali",
                "1990-08-15",
                "Female",
                "91230002",
                "sara.doctor@gmail.com",
                "Seeb",
                "20002",
                36,
                true,
                20.0,
                8,
                false,
                "Dermatology"
        );

        seed(
                "D003",
                "Khalid",
                "Nasser",
                "1982-02-20",
                "Male",
                "91230003",
                "khalid.doctor@gmail.com",
                "Bawshar",
                "20003",
                44,
                true,
                30.0,
                15,
                true,
                "Neurology"
        );


        Surgeon surgeon = new Surgeon(
                "D004",
                "Mohammed",
                "Rashid",
                "1980-10-12",
                "Male",
                "94567890",
                "surgeon@gmail.com",
                "Muscat",
                "20004",
                46,
                true,
                new String[0],
                new String[0],
                40.0,
                18,
                true,
                "Surgery",
                250,
                true,
                new String[0]
        );

        addSurgeon(surgeon);
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
            double consultationFee,
            int experienceYears,
            boolean onCall,
            String specialization
    ) {

        Doctor doctor = new Doctor(
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
                new String[0],
                new String[0],
                consultationFee,
                experienceYears,
                onCall,
                specialization
        );

        add(doctor);
    }


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
                    && doctors[i].getId().equalsIgnoreCase(id)) {

                for (int j = i; j < doctorCount - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }

                doctors[doctorCount - 1] = null;
                doctorCount--;

                System.out.println("Doctor removed successfully.");
                return;
            }
        }

        System.out.println("Doctor not found.");
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

            if (doctors[i] == null) {
                continue;
            }

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

            if (doctors[i] != null
                    && doctors[i].getId().equalsIgnoreCase(id)) {

                return doctors[i];
            }
        }

        return null;
    }


    public void addSurgeon(Surgeon surgeon) {

        if (surgeon == null) {
            return;
        }

        if (doctorCount >= doctors.length) {
            System.out.println("Doctor storage is full.");
            return;
        }

        doctors[doctorCount] = surgeon;
        doctorCount++;
    }


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


    public Doctor[] listBySpecialization(
            String specialization
    ) {

        Doctor[] results = new Doctor[doctorCount];
        int resultCount = 0;

        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] != null
                    && doctors[i].getSpecialization()
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


    public Doctor[] availableDoctors() {

        Doctor[] results = new Doctor[doctorCount];
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