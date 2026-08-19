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

//    overloaded
    private int getPatientLoad() {
   if (availableSlots == null ) {
       return 0;
   }
    return assignedPatientIds.length;
    }

    public void addSlot(String slot) {
        if (availableSlots == null || slot.isBlank()) {
            System.out.println("Slot is empty");
            return;

        }
        if (hasSlot(slot)) {
            System.out.println("Slot already exists");
        }
        if (availableSlots == null) {
            availableSlots = new String[]{slot};
            return;
        }
        if (assignedPatientIds == null) {
            assignedPatientIds = new String[]{slot};
            return;
        }
        String[] newSlots = new String[availableSlots.length + 1];
        for (int i = 0; i < availableSlots.length; i++) {
            newSlots[i] = availableSlots[i];
        }
        newSlots[availableSlots.length] = slot;
        availableSlots = newSlots;
    }
public void removeSlot(String slot) {
        if (availableSlots == null || availableSlots.length == 0) {
            return;
        }
        int position = -1;
        for (int i = 0; i < availableSlots.length; i++) {
           if(availableSlots[i] != null && availableSlots[i].equalsIgnoreCase(slot){
               position = i;
               break;
           }
        }
        if (position == -1) {
            System.out.println("Slot not found");
            return;
        }
        String[] newSlots = new String[availableSlots.length - 1];
        int index = 0;
        for (int i = 0; i < availableSlots.length; i++) {
            if(i == position) {
                newSlots[index] = availableSlots[i];
                index++;
            }
        }
        availableSlots = newSlots;

}
public boolean hasSlot(String slot) {
        if(availableSlots == null ) {
            return false;
        }

for(String currentSlot :availableSlots){
    if(currentSlot.equalsIgnoreCase(slot)){
    return true;}
}
return false;

}


}

