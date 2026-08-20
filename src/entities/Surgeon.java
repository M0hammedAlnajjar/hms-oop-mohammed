package entities;

public class Surgeon extends Doctor {

    private int surgeriesPerformed;
    private boolean operationTheatreAccess;
    private String[] upcomingSurgeryDates;

    public Surgeon(
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
            String[] assignedPatientIds,
            String[] availableSlots,
            double consultationFee,
            int experienceYears,
            boolean onCall,
            String specialization,
            int surgeriesPerformed,
            boolean operationTheatreAccess,
            String[] upcomingSurgeryDates
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
                active,
                assignedPatientIds,
                availableSlots,
                consultationFee,
                experienceYears,
                onCall,
                specialization
        );

        setSurgeriesPerformed(surgeriesPerformed);
        setOperationTheatreAccess(operationTheatreAccess);
        setUpcomingSurgeryDates(upcomingSurgeryDates);
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {

        if (surgeriesPerformed >= 0) {
            this.surgeriesPerformed = surgeriesPerformed;
        } else {
            System.out.println("Surgeries performed cannot be negative");
        }
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public String[] getUpcomingSurgeryDates() {
        return upcomingSurgeryDates;
    }

    public void setUpcomingSurgeryDates(String[] upcomingSurgeryDates) {
        this.upcomingSurgeryDates = upcomingSurgeryDates;
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println(
                "Surgeries Performed: " + surgeriesPerformed
        );

        System.out.println(
                "Operation Theatre Access: " + operationTheatreAccess
        );

        System.out.println(
                "Upcoming Surgery Count: " + getUpcomingCount()
        );
    }

    public void performSurgery() {
        surgeriesPerformed++;
    }

    public void scheduleSurgery(String surgeryDate) {

        if (surgeryDate == null || surgeryDate.isBlank()) {

            System.out.println("Invalid surgery date");
            return;
        }

        if (upcomingSurgeryDates == null) {

            upcomingSurgeryDates =
                    new String[]{surgeryDate};

            return;
        }

        String[] newDates =
                new String[
                        upcomingSurgeryDates.length + 1
                        ];

        for (int i = 0;
             i < upcomingSurgeryDates.length;
             i++) {

            newDates[i] =
                    upcomingSurgeryDates[i];
        }

        newDates[
                upcomingSurgeryDates.length
                ] = surgeryDate;

        upcomingSurgeryDates = newDates;
    }

    public int getUpcomingCount() {

        if (upcomingSurgeryDates == null) {
            return 0;
        }

        return upcomingSurgeryDates.length;
    }
}