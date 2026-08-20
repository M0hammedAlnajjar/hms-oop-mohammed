package entities;

import interfaces.Displayable;
import utils.HelperUtils;

public class Appointment implements Displayable {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private boolean followUp;

    public Appointment(
            String appointmentDate,
            String appointmentId,
            String appointmentTime,
            String doctorId,
            boolean followUp,
            String patientId,
            String reason,
            String status
    ) {
        this.appointmentDate = appointmentDate;
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.doctorId = doctorId;
        this.followUp = followUp;
        this.patientId = patientId;
        this.reason = reason;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String[] allowed = {"Scheduled", "Cancelled", "Complete"};
        if (HelperUtils.isOneOf(status, allowed)) {
            this.status = status;
        }
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? "" : reason;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isValidText(patientId)) {
            this.patientId = patientId;
        }
    }

    public boolean isFollowUp() {
        return followUp;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isValidText(doctorId)) {
            this.doctorId = doctorId;
        }
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        if (appointmentTime == null || HelperUtils.isValidText(appointmentTime)) {
            this.appointmentTime = appointmentTime;
        }
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if (HelperUtils.isValidText(appointmentId)) {
            this.appointmentId = appointmentId;
        }
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        if (HelperUtils.isValidText(appointmentDate)) {
            this.appointmentDate = appointmentDate;
        }
    }

    public void displayInfo() {
        System.out.println("Appointment Id: " + appointmentId);
        System.out.println("Patient Id: " + patientId);
        System.out.println("Doctor Id: " + doctorId);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Appointment Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Follow Up: " + followUp);
    }

    @Override
    public void displaySummary() {
        System.out.println("Appointment ID: " + appointmentId + " | Status: " + status);
    }


    @Override
    public boolean isAdult() {
        return false;
    }

    public void cancel() {
        status = "Cancelled";
    }

    public void complete() {
        status = "Complete";
    }

    public void reschedule(String newDate, String newTime) {
        appointmentDate = newDate;
        appointmentTime = newTime;
        status = "Scheduled";
    }

    public boolean isPast(String givenDate) {
        return appointmentDate != null && givenDate != null && appointmentDate.compareTo(givenDate) < 0;
    }

    public void addNotes(String note) {
        if (HelperUtils.isValidText(note)) {
            System.out.println("Note: " + note);
        }
    }
    public void addNotes(String note, String author) {
        if (HelperUtils.isValidText(note)) {
            System.out.println("Note: " + note);
            if (HelperUtils.isValidText(author)) {
                System.out.println("Author: " + author);
            }
        }
    }
}