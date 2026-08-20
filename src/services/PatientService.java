package services;

import entities.InPatient;
import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;

public class PatientService implements Manageable, Searchable {

    private Patient[] patients = new Patient[100];
    private int patientCount = 0;


    // =========================
    // addPatient Overloads
    // =========================

    // Add patient using basic details
    public void addPatient(
            String id,
            String firstName,
            String lastName
    ) {

        if (patientCount >= patients.length) {
            System.out.println("Patient storage is full.");
            return;
        }

        Patient patient = new Patient(
                id,
                firstName,
                lastName
        );

        patients[patientCount] = patient;
        patientCount++;
    }


    // Add patient using basic details and blood group
    public void addPatient(
            String id,
            String firstName,
            String lastName,
            String bloodGroup
    ) {

        if (patientCount >= patients.length) {
            System.out.println("Patient storage is full.");
            return;
        }

        Patient patient = new Patient(
                id,
                firstName,
                lastName
        );

        patient.setBloodGroup(bloodGroup);

        patients[patientCount] = patient;
        patientCount++;
    }


    // Add existing Patient object
    public void addPatient(Patient patient) {

        if (patient == null) {
            System.out.println("Invalid patient.");
            return;
        }

        if (patientCount >= patients.length) {
            System.out.println("Patient storage is full.");
            return;
        }

        patients[patientCount] = patient;
        patientCount++;
    }


    // =========================
    // Find Patient
    // =========================

    public Patient findPatient(String id) {

        if (id == null || id.isBlank()) {
            return null;
        }

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] != null
                    && patients[i].getId() != null
                    && patients[i].getId().equals(id)) {

                return patients[i];
            }
        }

        return null;
    }


    // Overloaded findPatient
    public Patient findPatient(
            String firstName,
            String lastName
    ) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] == null) {
                continue;
            }

            String currentFirstName =
                    patients[i].getFirstName();

            String currentLastName =
                    patients[i].getLastName();

            if (currentFirstName != null
                    && currentLastName != null
                    && currentFirstName.equalsIgnoreCase(firstName)
                    && currentLastName.equalsIgnoreCase(lastName)) {

                return patients[i];
            }
        }

        return null;
    }


    // =========================
    // Manageable
    // =========================

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Patient)) {
            System.out.println("Invalid patient.");
            return;
        }

        if (patientCount >= patients.length) {
            System.out.println("Patient storage is full.");
            return;
        }

        patients[patientCount] = (Patient) entity;
        patientCount++;
    }


    @Override
    public void removeById(String id) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] != null
                    && patients[i].getId() != null
                    && patients[i].getId().equals(id)) {

                for (int j = i;
                     j < patientCount - 1;
                     j++) {

                    patients[j] =
                            patients[j + 1];
                }

                patients[patientCount - 1] = null;
                patientCount--;

                return;
            }
        }

        System.out.println("Patient not found.");
    }


    @Override
    public Object[] getAll() {

        Patient[] allPatients =
                new Patient[patientCount];

        for (int i = 0; i < patientCount; i++) {
            allPatients[i] = patients[i];
        }

        return allPatients;
    }


    // =========================
    // Searchable
    // =========================

    @Override
    public Object[] search(String keyword) {

        Patient[] results =
                new Patient[patientCount];

        int resultCount = 0;

        if (keyword == null || keyword.isBlank()) {
            return new Patient[0];
        }

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] == null) {
                continue;
            }

            String firstName =
                    patients[i].getFirstName();

            String lastName =
                    patients[i].getLastName();

            if ((firstName != null
                    && firstName.equalsIgnoreCase(keyword))
                    ||
                    (lastName != null
                            && lastName.equalsIgnoreCase(keyword))) {

                results[resultCount] = patients[i];
                resultCount++;
            }
        }

        Patient[] finalResults =
                new Patient[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }


    @Override
    public Object searchById(String id) {
        return findPatient(id);
    }


    // =========================
    // Update Contact
    // =========================

    public void updateContact(
            String id,
            String phoneNumber,
            String email
    ) {

        Patient patient =
                (Patient) searchById(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.updateContact(
                phoneNumber,
                email
        );
    }


    // =========================
    // List InPatients
    // =========================

    public InPatient[] listInPatients() {

        InPatient[] results =
                new InPatient[patientCount];

        int count = 0;

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] instanceof InPatient) {

                results[count] =
                        (InPatient) patients[i];

                count++;
            }
        }

        InPatient[] finalResults =
                new InPatient[count];

        for (int i = 0; i < count; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }


    // =========================
    // Total Outstanding
    // =========================

    public double totalOutstanding() {

        double total = 0;

        for (int i = 0; i < patientCount; i++) {

            if (patients[i] != null) {
                total += patients[i]
                        .getOutstandingBalance();
            }
        }

        return total;
    }
}