package services;

import interfaces.Manageable;
import interfaces.Searchable;

public class RecordService implements Manageable, Searchable {
    @Override
    public void add(Object entity) {

        if (entity instanceof MedicalRecord) {
            records[recordCount] = (MedicalRecord) entity;
            recordCount++;
        }
    }

    @Override
    public void removeById(String id) {

        for (int i = 0; i < recordCount; i++) {

            if (records[i].getRecordId().equals(id)) {

                for (int j = i; j < recordCount - 1; j++) {
                    records[j] = records[j + 1];
                }

                records[recordCount - 1] = null;
                recordCount--;

                return;
            }
        }
    }

    @Override
    public Object[] getAll() {

        MedicalRecord[] allRecords = new MedicalRecord[recordCount];

        for (int i = 0; i < recordCount; i++) {
            allRecords[i] = records[i];
        }

        return allRecords;
    }
    @@Override
    public Object[] search(String keyword) {

        MedicalRecord[] results = new MedicalRecord[recordCount];
        int resultCount = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i].getDiagnosis().equalsIgnoreCase(keyword)
                    || records[i].getPrescription().equalsIgnoreCase(keyword)) {

                results[resultCount] = records[i];
                resultCount++;
            }
        }

        MedicalRecord[] finalResults = new MedicalRecord[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }

    @Override
    public Object searchById(String id) {

        for (int i = 0; i < recordCount; i++) {

            if (records[i].getRecordId().equals(id)) {
                return records[i];
            }
        }

        return null;

    }
    // List medical records by patient ID
    public MedicalRecord[] listByPatient(String patientId) {

        MedicalRecord[] results = new MedicalRecord[recordCount];
        int resultCount = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i].getPatientId().equals(patientId)) {
                results[resultCount] = records[i];
                resultCount++;
            }
        }

        MedicalRecord[] finalResults = new MedicalRecord[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }
    // Count confidential medical records
    public int countConfidential() {

        int count = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i].isConfidential()) {
                count++;
            }
        }

        return count;
    }

}