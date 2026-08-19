package entities;

import java.util.Arrays;

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
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Insured: " + insured);
        System.out.println("Medical Records: " + Arrays.toString(medicalRecordIds));

    }
//(overloaded)
    public Patient(String id, String firstName, String lastName) {
        super(id, firstName, lastName);

    }


    public void addAllergy(String allergy){
        if(this.allergies == null || allergy.isBlank()){
            System.out.println("Invalid Allergy");
            return;
        }
        if(hasAllergy(allergy)){
            System.out.println("Allergy already exists");
            return;
        }
        if(allergy==null){
            System.out.println("Invalid Allergy");
            return;
        }
        String[] newAllergies = new String[allergies.length+1];
        for(int i=0; i<allergies.length; i++){
            newAllergies[i] = allergies[i];
        }
        newAllergies[allergies.length] = allergy;
        allergies = newAllergies;

    }

    private boolean hasAllergy(String allergy) {

        return false;
    }

public void listAllergies() {
    System.out.println("Allergies:");
    if (allergies == null || allergies.length == 0) {
        System.out.println("No Allergies");
        return;
    }
    for (String allergy : allergies) {
        if (allergy == null) {
            System.out.println("Invalid Allergy" + allergy);
        }
    }
}
public void addRecordId(String recordId) {
    if (recordId == null || recordId.isBlank()) {
        System.out.println("Invalid Record Id");
        return;
    }
    if (medicalRecordIds == null) {
        medicalRecordIds = new String[]{recordId};
        return;
    }
    String[] newRecordIds = new String[medicalRecordIds.length + 1];
    for (int i = 0; i < medicalRecordIds.length; i++) {
        newRecordIds[i] = medicalRecordIds[i];
    }
    newRecordIds[medicalRecordIds.length] = recordId;
    medicalRecordIds = newRecordIds;
}
public int  getRecordCount(){
        if(medicalRecordIds == null){
            return 0;
        }
        return medicalRecordIds.length;
}

}
