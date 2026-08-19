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

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("On Call: " + onCall);
        System.out.println("Patient load: "+getPatientLoad());

    }

    private int getPatientLoad() {
   if (availableSlots == null ) {
       return 0;
   }
    return assignedPatientIds.length;
    }
}
