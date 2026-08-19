package entities;

public class Patient extends Person {

    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;
    private String[] allergies;
    private String[] medicalRecordIds;
    private double outstandingBalance;
    private boolean insured;

    public Patient(
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
            String[] allergies,
            String bloodGroup,
            String emergencyContact,
            boolean insured,
            String[] medicalRecordIds,
            double outstandingBalance,
            String registrationDate
    ) {

        super(
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
                active
        );

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

        if (outstandingBalance >= 0) {
            this.outstandingBalance = outstandingBalance;
        }
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {

        if (registrationDate != null &&
                !registrationDate.isBlank()) {

            this.registrationDate = registrationDate;
        }
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Outstanding Balance: " + outstandingBalance);
        System.out.println("Insured: " + insured);

        listAllergies();

        System.out.println(
                "Medical Record Count: " + getRecordCount()
        );
    }

    public void addAllergy(String allergy) {

        if (allergy == null || allergy.isBlank()) {
            System.out.println("Invalid Allergy");
            return;
        }

        if (hasAllergy(allergy)) {
            System.out.println("Allergy already exists");
            return;
        }

        if (allergies == null) {
            allergies = new String[]{allergy};
            return;
        }

        String[] newAllergies =
                new String[allergies.length + 1];

        for (int i = 0; i < allergies.length; i++) {
            newAllergies[i] = allergies[i];
        }

        newAllergies[allergies.length] = allergy;

        allergies = newAllergies;
    }

    public boolean hasAllergy(String allergy) {

        if (allergy == null || allergy.isBlank()) {
            return false;
        }

        if (allergies == null) {
            return false;
        }

        for (String currentAllergy : allergies) {

            if (currentAllergy != null &&
                    currentAllergy.equalsIgnoreCase(allergy)) {

                return true;
            }
        }

        return false;
    }

    public void listAllergies() {

        System.out.println("Allergies:");

        if (allergies == null || allergies.length == 0) {
            System.out.println("No Allergies");
            return;
        }

        for (String allergy : allergies) {

            if (allergy != null) {
                System.out.println("- " + allergy);
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

        String[] newRecordIds =
                new String[medicalRecordIds.length + 1];

        for (int i = 0; i < medicalRecordIds.length; i++) {
            newRecordIds[i] = medicalRecordIds[i];
        }

        newRecordIds[medicalRecordIds.length] = recordId;

        medicalRecordIds = newRecordIds;
    }

    public int getRecordCount() {

        if (medicalRecordIds == null) {
            return 0;
        }

        return medicalRecordIds.length;
    }

    public void addToBalance(double amount) {

        if (amount > 0) {

            outstandingBalance += amount;

        } else {

            System.out.println(
                    "Amount should be greater than 0"
            );
        }
    }

    public void clearBalance() {
        outstandingBalance = 0;
    }
}