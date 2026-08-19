package entities;

public class Surgeon extends Doctor  {
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

        this.surgeriesPerformed = surgeriesPerformed;
        this.operationTheatreAccess = operationTheatreAccess;
        this.upcomingSurgeryDates = upcomingSurgeryDates;
    }
}
