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
   public void displayInfo(){
        System.out.println("Record Id: "+recordId);
        System.out.println("Patient Id: "+patientId);
        System.out.println("Doctor Id: "+doctorId);
        System.out.println("Prescription: "+prescription);
        System.out.println("VisitDate: "+visitDate);
        System.out.println("Diagnosis: "+diagnosis);
        System.out.println("Doctor Name: "+doctorId);
        System.out.println("Prescription Name: "+prescription);
        System.out.println("Notes: "+notes);
        System.out.println("Confidential: "+confidential);

   }
//   overloading
    public String appendNote(String note){
}
public String markConfidential(){

}
public boolean isConfidential(){
        return confidential;
}
}
