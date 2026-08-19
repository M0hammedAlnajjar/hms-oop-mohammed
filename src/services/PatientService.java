package services;


import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;




public class PatientService implements Manageable, Searchable {


    // Find a patient by ID
    public Patient findPatient(String id) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getId().equals(id)) {
                return patients[i];
            }
        }

        return null;
    }

    // Find a patient by first name and last name
    public Patient findPatient(String firstName, String lastName) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getFirstName().equalsIgnoreCase(firstName)
                    && patients[i].getLastName().equalsIgnoreCase(lastName)) {

                return patients[i];
            }
        }

        return null;
    }
    @Override
    public void add(Object entity) {

        if (entity instanceof Patient) {
            patients[patientCount] = (Patient) entity;
            patientCount++;
        }
    }
    @Override
    public void removeById(String id) {

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getId().equals(id)) {

                for (int j = i; j < patientCount - 1; j++) {
                    patients[j] = patients[j + 1];
                }

                patients[patientCount - 1] = null;
                patientCount--;

                return;
            }
        }
    }
    @Override
    public Object[] getAll() {

        Patient[] allPatients = new Patient[patientCount];

        for (int i = 0; i < patientCount; i++) {
            allPatients[i] = patients[i];
        }

        return allPatients;
    }
    @Override
    public Object[] search(String keyword) {
        return null;
    }
    @Override
    public Object searchById(String id) {
        return null;
    }

    private Patient[] patients = new Patient[100];
    private int patientCount = 0;

}