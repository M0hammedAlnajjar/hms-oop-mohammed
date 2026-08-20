package entities;

import interfaces.Displayable;

public class MedicalRecord implements Displayable {

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

        setConfidential(confidential);
        setDiagnosis(diagnosis);
        setDoctorId(doctorId);
        setNotes(notes);
        setPatientId(patientId);
        setPrescription(prescription);
        setRecordId(recordId);
        setVisitDate(visitDate);
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {

        if (recordId != null && !recordId.isBlank()) {
            this.recordId = recordId;
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {

        if (patientId != null && !patientId.isBlank()) {
            this.patientId = patientId;
        }
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {

        if (doctorId != null && !doctorId.isBlank()) {
            this.doctorId = doctorId;
        }
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {

        if (visitDate != null && !visitDate.isBlank()) {
            this.visitDate = visitDate;
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {

        if (diagnosis != null && !diagnosis.isBlank()) {
            this.diagnosis = diagnosis;
        }
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {

        if (prescription != null && !prescription.isBlank()) {
            this.prescription = prescription;
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {

        if (notes != null) {
            this.notes = notes;
        }
    }

    public boolean isConfidential() {
        return confidential;
    }

    public void setConfidential(boolean confidential) {
        this.confidential = confidential;
    }

    @Override
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

    @Override
    public void displaySummary() {

        System.out.println(
                "Record ID: " + recordId
                        + " | Patient ID: " + patientId
                        + " | Diagnosis: " + diagnosis
        );
    }

    @Override
    public boolean isAdult() {
        return false;
    }

    public void appendNote(String note) {

        if (note == null || note.isBlank()) {
            System.out.println("Invalid note");
            return;
        }

        if (notes == null || notes.isBlank()) {
            notes = note;
        } else {
            notes = notes + " " + note;
        }
    }

    public void markConfidential() {
        confidential = true;
    }
}