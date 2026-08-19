package entities;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private boolean followUp;

    public Appointment(String appointmentDate, String appointmentId, String appointmentTime, String doctorId, boolean followUp, String patientId, String reason, String status) {
        this.appointmentDate = appointmentDate;
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.doctorId = doctorId;
        this.followUp = followUp;
        this.patientId = patientId;
        this.reason = reason;
        this.status = status;
    }
}
