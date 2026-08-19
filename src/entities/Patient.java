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

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public String[] getMedicalRecordIds() {
        return medicalRecordIds;
    }

    public void setMedicalRecordIds(String[] medicalRecordIds) {
        this.medicalRecordIds = medicalRecordIds;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    public Patient(String id, String firstName, String lastName) {
        super(id, firstName, lastName);

    }
}
