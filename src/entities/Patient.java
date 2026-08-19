package entities;

public class Patient extends Person{
    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;
    private String[] allergies;
    private String[] medicalRecordIds;
    private double outstandingBalance;
    private boolean insured;

    public Patient(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String nationalId, int age, boolean active, String[] allergies, String bloodGroup, String emergencyContact, boolean insured, String[] medicalRecordIds, double outstandingBalance, String registrationDate) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, active);
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.insured = insured;
        this.medicalRecordIds = medicalRecordIds;
        this.outstandingBalance = outstandingBalance;
        this.registrationDate = registrationDate;
    }
}
