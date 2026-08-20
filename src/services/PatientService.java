package services;

import entities.InPatient;
import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;

public class PatientService implements Manageable, Searchable {

    // Store patients
    private Patient[] patients = new Patient[100];

    private int patientCount = 0;


    // =========================================
    // Constructor - Seed Data
    // =========================================

    public PatientService() {

        // Regular Patient 1
        seed(
                "P001",
                "Ahmed",
                "Ali",
                "1995-05-15",
                "Male",
                "91234567",
                "ahmed@gmail.com",
                "Muscat",
                "10001",
                31,
                true,
                "O+",
                "92345678",
                true,
                50.0,
                "2026-08-20"
        );


        // Regular Patient 2
        seed(
                "P002",
                "Sara",
                "Khalid",
                "2000-03-10",
                "Female",
                "92345678",
                "sara@gmail.com",
                "Seeb",
                "10002",
                26,
                true,
                "A+",
                "91234567",
                false,
                20.0,
                "2026-08-20"
        );


        // Regular Patient 3
        seed(
                "P003",
                "Mohammed",
                "Salem",
                "1998-07-18",
                "Male",
                "93456789",
                "mohammed@gmail.com",
                "Bawshar",
                "10003",
                28,
                true,
                "B+",
                "94567890",
                true,
                75.0,
                "2026-08-20"
        );


        // Regular Patient 4
        seed(
                "P004",
                "Fatma",
                "Rashid",
                "1992-11-25",
                "Female",
                "94561234",
                "fatma@gmail.com",
                "Muscat",
                "10004",
                33,
                true,
                "O-",
                "95672345",
                true,
                30.0,
                "2026-08-20"
        );


        // =========================================
        // InPatient 1
        // =========================================

        InPatient inPatient1 =
                new InPatient(
                        "P005",
                        "Ali",
                        "Hassan",
                        "1990-05-10",
                        "Male",
                        "95678901",
                        "ali@gmail.com",
                        "Muscat",
                        "10005",
                        36,
                        true,

                        // Allergies
                        new String[0],

                        "AB+",
                        "96789012",
                        true,

                        // Medical records
                        new String[0],

                        100.0,
                        "2026-08-20",

                        // InPatient information
                        "2026-08-20",
                        "R101",
                        25.0,
                        3
                );

        add(inPatient1);


        // =========================================
        // InPatient 2
        // =========================================

        InPatient inPatient2 =
                new InPatient(
                        "P006",
                        "Maryam",
                        "Said",
                        "1988-09-15",
                        "Female",
                        "96781234",
                        "maryam@gmail.com",
                        "Seeb",
                        "10006",
                        37,
                        true,

                        // Allergies
                        new String[0],

                        "A-",
                        "97892345",
                        false,

                        // Medical records
                        new String[0],

                        150.0,
                        "2026-08-20",

                        // InPatient information
                        "2026-08-19",
                        "R102",
                        30.0,
                        4
                );

        add(inPatient2);
    }


    // =========================================
    // Seed Regular Patient
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
            String bloodGroup,
            String emergencyContact,
            boolean insured,
            double outstandingBalance,
            String registrationDate
    ) {

        Patient patient =
                new Patient(
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

                        // No allergies initially
                        new String[0],

                        bloodGroup,
                        emergencyContact,
                        insured,

                        // No medical records initially
                        new String[0],

                        outstandingBalance,
                        registrationDate
                );

        add(patient);
    }


    // =========================================
    // Find Patient By ID
    // =========================================

    public Patient findPatient(String id) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] != null
                    && patients[i].getId() != null
                    && patients[i]
                    .getId()
                    .equalsIgnoreCase(id)) {

                return patients[i];
            }
        }

        return null;
    }


    // =========================================
    // Find Patient By Name - Overloading
    // =========================================

    public Patient findPatient(
            String firstName,
            String lastName
    ) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i]
                    .getFirstName()
                    .equalsIgnoreCase(firstName)

                    && patients[i]
                    .getLastName()
                    .equalsIgnoreCase(lastName)) {

                return patients[i];
            }
        }

        return null;
    }


    // =========================================
    // Add Patient
    // =========================================

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Patient)) {

            System.out.println(
                    "Invalid patient object."
            );

            return;
        }


        if (patientCount >= patients.length) {

            System.out.println(
                    "Patient storage is full."
            );

            return;
        }


        Patient patient =
                (Patient) entity;


        // Check duplicate ID
        if (findPatient(patient.getId()) != null) {

            System.out.println(
                    "Patient ID already exists."
            );

            return;
        }


        patients[patientCount] =
                patient;

        patientCount++;
    }


    // =========================================
    // Remove Patient
    // =========================================

    @Override
    public void removeById(String id) {

        if (id == null || id.isBlank()) {

            System.out.println(
                    "Invalid patient ID."
            );

            return;
        }


        for (int i = 0; i < patientCount; i++) {

            if (patients[i] != null
                    && patients[i].getId() != null
                    && patients[i]
                    .getId()
                    .equalsIgnoreCase(id)) {


                // Shift elements left
                for (int j = i;
                     j < patientCount - 1;
                     j++) {

                    patients[j] =
                            patients[j + 1];
                }


                patients[patientCount - 1] =
                        null;

                patientCount--;


                System.out.println(
                        "Patient removed successfully."
                );

                return;
            }
        }


        System.out.println(
                "Patient not found."
        );
    }


    // =========================================
    // Get All Patients
    // =========================================

    @Override
    public Object[] getAll() {

        Patient[] allPatients =
                new Patient[patientCount];


        for (int i = 0; i < patientCount; i++) {

            allPatients[i] =
                    patients[i];
        }


        return allPatients;
    }


    // =========================================
    // Search Patient
    // =========================================

    @Override
    public Object[] search(String keyword) {

        Patient[] results =
                new Patient[patientCount];

        int resultCount = 0;


        if (keyword == null ||
                keyword.isBlank()) {

            return new Patient[0];
        }


        for (int i = 0; i < patientCount; i++) {

            Patient patient =
                    patients[i];


            if (patient != null
                    && (

                    patient
                            .getFirstName()
                            .equalsIgnoreCase(keyword)

                            ||

                            patient
                                    .getLastName()
                                    .equalsIgnoreCase(keyword)

                            ||

                            patient
                                    .getId()
                                    .equalsIgnoreCase(keyword)

            )) {

                results[resultCount] =
                        patient;

                resultCount++;
            }
        }


        Patient[] finalResults =
                new Patient[resultCount];


        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }


        return finalResults;
    }


    // =========================================
    // Search By ID
    // =========================================

    @Override
    public Object searchById(String id) {

        return findPatient(id);
    }


    // =========================================
    // Update Contact
    // =========================================

    public void updateContact(
            String id,
            String phoneNumber,
            String email
    ) {

        Patient patient =
                findPatient(id);


        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }


        patient.updateContact(
                phoneNumber,
                email
        );


        System.out.println(
                "Patient updated successfully."
        );
    }


    // =========================================
    // List InPatients
    // Polymorphism / instanceof
    // =========================================

    public InPatient[] listInPatients() {

        InPatient[] results =
                new InPatient[patientCount];

        int count = 0;


        for (int i = 0;
             i < patientCount;
             i++) {


            if (patients[i]
                    instanceof InPatient) {


                results[count] =
                        (InPatient) patients[i];

                count++;
            }
        }


        InPatient[] finalResults =
                new InPatient[count];


        for (int i = 0;
             i < count;
             i++) {

            finalResults[i] =
                    results[i];
        }


        return finalResults;
    }


    // =========================================
    // Total Outstanding Balance
    // =========================================

    public double totalOutstanding() {

        double total = 0;


        for (int i = 0;
             i < patientCount;
             i++) {

            total +=
                    patients[i]
                            .getOutstandingBalance();
        }


        return total;
    }
}