package entities;

public class Nurse extends Person{
    private String departmentId;
    private String shift;
    private String[] assignedPatientIds;
    private int yearsOfService;


    public String[] getAssignedPatientIds() {
        return assignedPatientIds;
    }

    public void setAssignedPatientIds(String[] assignedPatientIds) {
        this.assignedPatientIds = assignedPatientIds;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public Nurse(String id,
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
                 String departmentId,
                 String shift,
                 String[] assignedPatientIds,
                 int yearsOfService) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, active);
        this.departmentId = departmentId;
        this.shift = shift;
        this.assignedPatientIds = assignedPatientIds;
        this.yearsOfService = yearsOfService;


    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Years of Service: " + yearsOfService);
        System.out.println("Patient load:"+getPatientLoad());
    }


//    @overloading
    public int getPatientLoad() {
        if (assignedPatientIds == null ) {
            return 0;
        }return
                assignedPatientIds.length;
    }
    public void assignPatient(String patientId) {
        if(patientId == null || patientId.isBlank()) {
            System.out.println("Patient ID is blank");
            return;
        }
        if(assignedPatientIds == null) {
            assignedPatientIds = new String[]{patientId};
            return;
        }
        String[] newPatientIds = new String[assignedPatientIds.length+1];
        for (int i = 0; i < assignedPatientIds.length; i++) {
            newPatientIds[i] = assignedPatientIds[i];
        }
        newPatientIds[assignedPatientIds.length] = patientId;
        assignedPatientIds = newPatientIds;
    }
    public void unassignPatient(String patientId) {
        if (assignedPatientIds == null || assignedPatientIds.length == 0) {
            return;
        }
        int position = -1;
        for (int i = 0; i < assignedPatientIds.length; i++) {
            if (assignedPatientIds[i] != null && assignedPatientIds[i].equals(patientId)) {
            }
            position = i;
            break;


        }if (position >= 1) {
            System.out.println("Patient not assigned");
            return;
        }String[] newPatientIds = new String[assignedPatientIds.length-1];
        int index = 0;
        for (int i = 0; i < assignedPatientIds.length; i++) {
            if(i != position) {
                newPatientIds[index] = assignedPatientIds[i];
                index++;
            }
        }assignedPatientIds = newPatientIds;
    }
    public boolean  isNightShift(){
        return shift != null &&
        shift.equalsIgnoreCase("Night");
    }
}


