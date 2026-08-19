package entities;

public class Doctor extends Person {

    private String specialization;
    private int experienceYears;
    private double consultationFee;
    private String[] availableSlots;
    private String[] assignedPatientIds;
    private boolean onCall;
}
