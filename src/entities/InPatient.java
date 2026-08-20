package entities;

public class InPatient extends Patient {

    private String admissionDate;
    private String roomNumber;
    private double dailyCharges;
    private int daysAdmitted;

    // Basic constructor
    public InPatient(
            String id,
            String firstName,
            String lastName,
            String admissionDate,
            double dailyCharges,
            int daysAdmitted,
            String roomNumber
    ) {

        super(id, firstName, lastName);

        setAdmissionDate(admissionDate);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);
        setRoomNumber(roomNumber);
    }

    // Full constructor
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

        // Person -> Patient -> InPatient
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
                active,
                allergies,
                bloodGroup,
                emergencyContact,
                insured,
                medicalRecordIds,
                outstandingBalance,
                registrationDate
        );

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {

        if (admissionDate != null && !admissionDate.isBlank()) {
            this.admissionDate = admissionDate;
        }
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {

        if (roomNumber != null && !roomNumber.isBlank()) {
            this.roomNumber = roomNumber;
        }
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {

        if (dailyCharges >= 0) {
            this.dailyCharges = dailyCharges;
        }
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(int daysAdmitted) {

        if (daysAdmitted >= 0) {
            this.daysAdmitted = daysAdmitted;
        }
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

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);
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

    public void PatientService() {
        super();

        InPatient inPatient = new InPatient(
                "P004",
                "Ali",
                "Hassan",
                "1990-05-10",
                "Male",
                "95678901",
                "ali@gmail.com",
                "Muscat",
                "10004",
                36,
                true,
                new String[0],
                "AB+",
                "96789012",
                true,
                new String[0],
                100.0,
                "2026-08-20",
                "2026-08-20",
                "R101",
                25.0,
                3
        );

        add(inPatient);
    }
}