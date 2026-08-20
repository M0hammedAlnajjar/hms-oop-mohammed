package services;

import entities.MedicalRecord;
import interfaces.Manageable;
import interfaces.Searchable;

public class RecordService implements Manageable, Searchable {

    // Store medical records
    private MedicalRecord[] records =
            new MedicalRecord[10];

    private int recordCount = 0;


    // =========================
    // Add Record
    // =========================

    @Override
    public void add(Object entity) {

        if (!(entity instanceof MedicalRecord)) {
            System.out.println("Invalid medical record.");
            return;
        }

        if (recordCount >= records.length) {
            System.out.println("Record storage is full.");
            return;
        }

        records[recordCount] =
                (MedicalRecord) entity;

        recordCount++;
    }


    // =========================
    // Remove Record By ID
    // =========================

    @Override
    public void removeById(String id) {

        // Check if the ID is invalid
        if (id == null || id.isBlank()) {

            System.out.println(
                    "Invalid record ID."
            );

            return;
        }

        // Search for the medical record
        for (int i = 0; i < recordCount; i++) {

            if (records[i] != null
                    && records[i].getRecordId() != null
                    && records[i]
                    .getRecordId()
                    .equalsIgnoreCase(id)) {

                // Shift records to the left
                for (int j = i;
                     j < recordCount - 1;
                     j++) {

                    records[j] =
                            records[j + 1];
                }

                // Remove the last duplicate reference
                records[recordCount - 1] =
                        null;

                // Decrease record count
                recordCount--;

                System.out.println(
                        "Medical record removed successfully."
                );

                return;
            }
        }

        // Record was not found
        System.out.println(
                "Medical record not found."
        );
    }
    // =========================
    // Get All Records
    // =========================

    @Override
    public Object[] getAll() {

        MedicalRecord[] allRecords =
                new MedicalRecord[recordCount];

        for (int i = 0;
             i < recordCount;
             i++) {

            allRecords[i] =
                    records[i];
        }

        return allRecords;
    }


    // =========================
    // Search Records
    // =========================

    @Override
    public Object[] search(String keyword) {

        MedicalRecord[] results =
                new MedicalRecord[recordCount];

        int resultCount = 0;

        if (keyword == null || keyword.isBlank()) {
            return new MedicalRecord[0];
        }

        for (int i = 0;
             i < recordCount;
             i++) {

            if (records[i] == null) {
                continue;
            }

            String diagnosis =
                    records[i].getDiagnosis();

            String prescription =
                    records[i].getPrescription();

            if ((diagnosis != null
                    && diagnosis.equalsIgnoreCase(keyword))
                    ||
                    (prescription != null
                            && prescription
                            .equalsIgnoreCase(keyword))) {

                results[resultCount] =
                        records[i];

                resultCount++;
            }
        }

        MedicalRecord[] finalResults =
                new MedicalRecord[resultCount];

        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }

        return finalResults;
    }


    // =========================
    // Search Record By ID
    // =========================

    @Override
    public Object searchById(String id) {

        if (id == null || id.isBlank()) {
            return null;
        }

        for (int i = 0;
             i < recordCount;
             i++) {

            if (records[i] != null
                    && records[i].getRecordId() != null
                    && records[i]
                    .getRecordId()
                    .equals(id)) {

                return records[i];
            }
        }

        return null;
    }


    // =========================
    // List Records By Patient
    // =========================

    public MedicalRecord[] listByPatient(
            String patientId
    ) {

        MedicalRecord[] results =
                new MedicalRecord[recordCount];

        int resultCount = 0;

        if (patientId == null
                || patientId.isBlank()) {

            return new MedicalRecord[0];
        }

        for (int i = 0;
             i < recordCount;
             i++) {

            if (records[i] != null
                    && records[i].getPatientId() != null
                    && records[i]
                    .getPatientId()
                    .equals(patientId)) {

                results[resultCount] =
                        records[i];

                resultCount++;
            }
        }

        MedicalRecord[] finalResults =
                new MedicalRecord[resultCount];

        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }

        return finalResults;
    }


    // =========================
    // Count Confidential Records
    // =========================

    public int countConfidential() {

        int count = 0;

        for (int i = 0;
             i < recordCount;
             i++) {

            if (records[i] != null
                    && records[i].isConfidential()) {

                count++;
            }
        }

        return count;
    }
}