package entities;

public class MedicalRecord {

    private String recordId;
    private String patientId;
    private String doctorId;
    private String visitDate;
    private String diagnosis;
    private String prescription;
    private String notes;
    private boolean confidential;

    public MedicalRecord(
            boolean confidential,
            String diagnosis,
            String doctorId,
            String notes,
            String patientId,
            String prescription,
            String recordId,
            String visitDate
    ) {
        this.confidential = confidential;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.notes = notes;
        this.patientId = patientId;
        this.prescription = prescription;
        this.recordId = recordId;
        this.visitDate = visitDate;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isConfidential() {
        return confidential;
    }

    public void setConfidential(boolean confidential) {
        this.confidential = confidential;
    }

    public void displayInfo() {
        System.out.println("Record Id: " + recordId);
        System.out.println("Patient Id: " + patientId);
        System.out.println("Doctor Id: " + doctorId);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescription: " + prescription);
        System.out.println("Notes: " + notes);
        System.out.println("Confidential: " + confidential);
    }

    public void appendNote(String note) {
        notes = notes + " " + note;
    }

    public void markConfidential() {
        confidential = true;
    }
}