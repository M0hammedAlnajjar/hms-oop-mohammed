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
}
