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

    public MedicalRecord(boolean confidential, String diagnosis, String doctorId, String notes, String patientId, String prescription, String recordId, String visitDate) {
        this.confidential = confidential;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.notes = notes;
        this.patientId = patientId;
        this.prescription = prescription;
        this.recordId = recordId;
        this.visitDate = visitDate;
    }
}
