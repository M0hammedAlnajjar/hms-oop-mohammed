package services;


import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;

public class PatientService implements Manageable, Searchable {


    // Find a patient by ID
    public Patient findPatient(String id) {
        return null;
    }

    // Find a patient by first name and last name
    public Patient findPatient(String firstName, String lastName) {
        return null;
    }
    @Override
    public void add(Object entity) {

    }
    @Override
    public void removeById(String id) {

    }
    @Override
    public Object[] getAll() {
        return null;
    }
    @Override
    public Object[] search(String keyword) {
        return null;
    }
    @Override
    public Object searchById(String id) {
        return null;
    }

}