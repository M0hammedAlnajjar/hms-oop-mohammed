package entities;

public class Nurse extends Person {

    private String departmentId;
    private String shift;
    private String[] assignedPatientIds;
    private int yearsOfService;


    // =========================
    // Constructor
    // =========================

    public Nurse(
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
            String departmentId,
            String shift,
            String[] assignedPatientIds,
            int yearsOfService
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
                active
        );

        setDepartmentId(departmentId);
        setShift(shift);
        setAssignedPatientIds(assignedPatientIds);
        setYearsOfService(yearsOfService);
    }


    // =========================
    // Getters and Setters
    // =========================

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

        if (departmentId != null && !departmentId.isBlank()) {

            this.departmentId = departmentId;

        } else {

            System.out.println(
                    "Department ID is null or empty"
            );
        }
    }


    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {

        if (shift == null || shift.isBlank()) {

            System.out.println("Shift is null or empty");
            return;
        }

        if (
                shift.equalsIgnoreCase("Morning")
                        || shift.equalsIgnoreCase("Evening")
                        || shift.equalsIgnoreCase("Night")
        ) {

            this.shift = shift;

        } else {

            System.out.println("Shift is out of range");
        }
    }


    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {

        if (yearsOfService >= 0) {

            this.yearsOfService = yearsOfService;

        } else {

            System.out.println(
                    "Years of Service is out of range"
            );
        }
    }


    // =========================
    // Display Information
    // =========================

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println(
                "Department: " + departmentId
        );

        System.out.println(
                "Shift: " + shift
        );

        System.out.println(
                "Years of Service: " + yearsOfService
        );

        System.out.println(
                "Patient Load: " + getPatientLoad()
        );
    }


    // =========================
    // Patient Load
    // =========================

    public int getPatientLoad() {

        if (assignedPatientIds == null) {
            return 0;
        }

        return assignedPatientIds.length;
    }


    // =========================
    // Assign Patient
    // =========================

    public void assignPatient(String patientId) {

        if (patientId == null || patientId.isBlank()) {

            System.out.println("Patient ID is blank");
            return;
        }

        // Check if patient is already assigned
        for (int i = 0;
             assignedPatientIds != null
                     && i < assignedPatientIds.length;
             i++) {

            if (assignedPatientIds[i] != null
                    && assignedPatientIds[i]
                    .equals(patientId)) {

                System.out.println(
                        "Patient is already assigned"
                );

                return;
            }
        }

        // First patient
        if (assignedPatientIds == null) {

            assignedPatientIds =
                    new String[]{patientId};

            return;
        }

        // Create bigger array
        String[] newPatientIds =
                new String[
                        assignedPatientIds.length + 1
                        ];

        // Copy old patient IDs
        for (int i = 0;
             i < assignedPatientIds.length;
             i++) {

            newPatientIds[i] =
                    assignedPatientIds[i];
        }

        // Add new patient
        newPatientIds[
                assignedPatientIds.length
                ] = patientId;

        assignedPatientIds = newPatientIds;
    }


    // =========================
    // Unassign Patient
    // =========================

    public void unassignPatient(String patientId) {

        if (patientId == null || patientId.isBlank()) {

            System.out.println("Patient ID is blank");
            return;
        }

        if (assignedPatientIds == null
                || assignedPatientIds.length == 0) {

            System.out.println(
                    "No patients are assigned"
            );

            return;
        }

        int position = -1;

        // Find patient position
        for (int i = 0;
             i < assignedPatientIds.length;
             i++) {

            if (assignedPatientIds[i] != null
                    && assignedPatientIds[i]
                    .equals(patientId)) {

                position = i;
                break;
            }
        }

        // Patient not found
        if (position == -1) {

            System.out.println(
                    "Patient not assigned"
            );

            return;
        }

        // Create smaller array
        String[] newPatientIds =
                new String[
                        assignedPatientIds.length - 1
                        ];

        int index = 0;

        // Copy everything except removed patient
        for (int i = 0;
             i < assignedPatientIds.length;
             i++) {

            if (i != position) {

                newPatientIds[index] =
                        assignedPatientIds[i];

                index++;
            }
        }

        assignedPatientIds = newPatientIds;
    }


    // =========================
    // Check Night Shift
    // =========================

    public boolean isNightShift() {

        return shift != null
                && shift.equalsIgnoreCase("Night");
    }
}