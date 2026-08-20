package entities;

public class InPatient extends Patient{
    private String admissionDate;
    private String roomNumber;
    private double dailyCharges;
    private int daysAdmitted;



    public InPatient(
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
            String registrationDate,
            String admissionDate,
            String roomNumber,
            double dailyCharges,
            int daysAdmitted
    ) {

        super(
                id,
                firstName,
                lastName
        );

        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.dailyCharges = dailyCharges;
        this.daysAdmitted = daysAdmitted;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Daily Charges: " + dailyCharges);
        System.out.println("Days Admitted: " + daysAdmitted);
    }
    public void admit(
            String admissionDate,
            String roomNumber,
            double dailyCharges,
            int daysAdmitted
    ) {
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.dailyCharges = dailyCharges;
        this.daysAdmitted = daysAdmitted;
    }
    public void discharge() {
        admissionDate = null;
        roomNumber = null;
        dailyCharges = 0;
        daysAdmitted = 0;
    }
    public double totalRoomCost() {
        return dailyCharges * daysAdmitted;
    }
}
