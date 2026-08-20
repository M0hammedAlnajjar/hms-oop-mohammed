package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;

public class DoctorService implements Manageable, Searchable {

    // Store doctors
    private Doctor[] doctors = new Doctor[10];

    private int doctorCount = 0;


    // =========================================
    // Constructor - Seed Data
    // =========================================

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


        // Seed Surgeon
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


    // =========================================
    // Seed Doctor
    // =========================================

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


    // =========================================
    // Add Doctor
    // =========================================

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Doctor)) {

            System.out.println(
                    "Invalid doctor."
            );

            return;
        }


        if (doctorCount >= doctors.length) {

            System.out.println(
                    "Doctor storage is full."
            );

            return;
        }


        doctors[doctorCount] =
                (Doctor) entity;

        doctorCount++;
    }


    // =========================================
    // Remove Doctor By ID
    // =========================================

    @Override
    public void removeById(String id) {

        if (id == null || id.isBlank()) {

            System.out.println(
                    "Invalid doctor ID."
            );

            return;
        }


        for (int i = 0; i < doctorCount; i++) {

            if (doctors[i] != null
                    && doctors[i].getId() != null
                    && doctors[i]
                    .getId()
                    .equalsIgnoreCase(id)) {


                // Shift doctors left
                for (int j = i;
                     j < doctorCount - 1;
                     j++) {

                    doctors[j] =
                            doctors[j + 1];
                }


                doctors[doctorCount - 1] =
                        null;

                doctorCount--;


                System.out.println(
                        "Doctor removed successfully."
                );

                return;
            }
        }


        System.out.println(
                "Doctor not found."
        );
    }


    // =========================================
    // Get All Doctors
    // =========================================

    @Override
    public Object[] getAll() {

        Doctor[] allDoctors =
                new Doctor[doctorCount];


        for (int i = 0;
             i < doctorCount;
             i++) {

            allDoctors[i] =
                    doctors[i];
        }


        return allDoctors;
    }


    // =========================================
    // Search Doctors
    // =========================================

    @Override
    public Object[] search(String keyword) {

        Doctor[] results =
                new Doctor[doctorCount];

        int resultCount = 0;


        if (keyword == null ||
                keyword.isBlank()) {

            return new Doctor[0];
        }


        for (int i = 0;
             i < doctorCount;
             i++) {

            if (doctors[i] == null) {
                continue;
            }


            if (doctors[i]
                    .getFirstName()
                    .equalsIgnoreCase(keyword)

                    || doctors[i]
                    .getLastName()
                    .equalsIgnoreCase(keyword)

                    || doctors[i]
                    .getSpecialization()
                    .equalsIgnoreCase(keyword)) {


                results[resultCount] =
                        doctors[i];

                resultCount++;
            }
        }


        Doctor[] finalResults =
                new Doctor[resultCount];


        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }


        return finalResults;
    }


    // =========================================
    // Search Doctor By ID
    // =========================================

    @Override
    public Object searchById(String id) {

        if (id == null || id.isBlank()) {
            return null;
        }


        for (int i = 0;
             i < doctorCount;
             i++) {

            if (doctors[i] != null
                    && doctors[i].getId() != null
                    && doctors[i]
                    .getId()
                    .equalsIgnoreCase(id)) {

                return doctors[i];
            }
        }


        return null;
    }


    // =========================================
    // Add Surgeon
    // =========================================

    public void addSurgeon(
            Surgeon surgeon
    ) {

        if (surgeon == null) {

            System.out.println(
                    "Invalid surgeon."
            );

            return;
        }


        if (doctorCount >= doctors.length) {

            System.out.println(
                    "Doctor storage is full."
            );

            return;
        }


        doctors[doctorCount] =
                surgeon;

        doctorCount++;
    }


    // =========================================
    // Assign Patient To Doctor
    // =========================================

    public void assignPatient(
            String doctorId,
            String patientId
    ) {

        // Validate doctor ID
        if (doctorId == null ||
                doctorId.isBlank()) {

            System.out.println(
                    "Invalid doctor ID."
            );

            return;
        }


        // Validate patient ID
        if (patientId == null ||
                patientId.isBlank()) {

            System.out.println(
                    "Invalid patient ID."
            );

            return;
        }


        // Find doctor
        Doctor doctor =
                (Doctor) searchById(
                        doctorId
                );


        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }


        // Assign patient
        doctor.assignPatient(
                patientId
        );


        System.out.println(
                "Patient assigned successfully."
        );
    }


    // =========================================
    // List Doctors By Specialization
    // =========================================

    public Doctor[] listBySpecialization(
            String specialization
    ) {

        Doctor[] results =
                new Doctor[doctorCount];

        int resultCount = 0;


        if (specialization == null ||
                specialization.isBlank()) {

            return new Doctor[0];
        }


        for (int i = 0;
             i < doctorCount;
             i++) {

            if (doctors[i] != null
                    && doctors[i]
                    .getSpecialization()
                    .equalsIgnoreCase(
                            specialization
                    )) {


                results[resultCount] =
                        doctors[i];

                resultCount++;
            }
        }


        Doctor[] finalResults =
                new Doctor[resultCount];


        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }


        return finalResults;
    }


    // =========================================
    // List Available Doctors
    // =========================================

    public Doctor[] availableDoctors() {

        Doctor[] results =
                new Doctor[doctorCount];

        int resultCount = 0;


        for (int i = 0;
             i < doctorCount;
             i++) {

            if (doctors[i] != null
                    && doctors[i].isOnCall()) {


                results[resultCount] =
                        doctors[i];

                resultCount++;
            }
        }


        Doctor[] finalResults =
                new Doctor[resultCount];


        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }


        return finalResults;
    }
}