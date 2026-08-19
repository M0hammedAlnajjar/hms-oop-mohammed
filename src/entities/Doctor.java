package entities;

public class Doctor extends Person {

    private String specialization;
    private int experienceYears;
    private double consultationFee;
    private String[] availableSlots;
    private String[] assignedPatientIds;
    private boolean onCall;

    public Doctor(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String nationalId, int age, boolean active, String[] assignedPatientIds, String[] availableSlots, double consultationFee, int experienceYears, boolean onCall, String specialization) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, active);
        this.assignedPatientIds = assignedPatientIds;
        this.availableSlots = availableSlots;
        this.consultationFee = consultationFee;
        this.experienceYears = experienceYears;
        this.onCall = onCall;
        this.specialization = specialization;
    }
}
