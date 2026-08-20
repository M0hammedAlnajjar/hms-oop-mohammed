package services;

import entities.Appointment;
import entities.Patient;
import entities.Doctor;
import interfaces.Manageable;
import interfaces.Searchable;

public class AppointmentService implements Manageable, Searchable {

    // Store appointments without generics
    private Appointment[] appointments = new Appointment[10];
    private int appointmentCount = 0;


    // Schedule appointment using IDs and date
    public Appointment schedule(
            String patientId,
            String doctorId,
            String date
    ) {

        if (appointmentCount >= appointments.length) {
            System.out.println("Appointment storage is full.");
            return null;
        }

        Appointment appointment = new Appointment(
                date,
                "A" + appointmentCount,
                "",
                doctorId,
                false,
                patientId,
                "",
                "Scheduled"
        );

        appointments[appointmentCount] = appointment;
        appointmentCount++;

        return appointment;
    }


    // Schedule appointment using IDs, date and time
    public Appointment schedule(
            String patientId,
            String doctorId,
            String date,
            String time
    ) {

        if (appointmentCount >= appointments.length) {
            System.out.println("Appointment storage is full.");
            return null;
        }

        Appointment appointment = new Appointment(
                date,
                "A" + appointmentCount,
                time,
                doctorId,
                false,
                patientId,
                "",
                "Scheduled"
        );

        appointments[appointmentCount] = appointment;
        appointmentCount++;

        return appointment;
    }


    // Schedule appointment using full objects and reason
    public Appointment schedule(
            Patient patient,
            Doctor doctor,
            String date,
            String time,
            String reason
    ) {

        if (appointmentCount >= appointments.length) {
            System.out.println("Appointment storage is full.");
            return null;
        }

        if (patient == null || doctor == null) {
            System.out.println("Patient or doctor is invalid.");
            return null;
        }

        Appointment appointment = new Appointment(
                date,
                "A" + appointmentCount,
                time,
                doctor.getId(),
                false,
                patient.getId(),
                reason,
                "Scheduled"
        );

        appointments[appointmentCount] = appointment;
        appointmentCount++;

        return appointment;
    }


    // Add appointment
    @Override
    public void add(Object entity) {

        if (!(entity instanceof Appointment)) {
            System.out.println("Invalid appointment.");
            return;
        }

        if (appointmentCount >= appointments.length) {
            System.out.println("Appointment storage is full.");
            return;
        }

        appointments[appointmentCount] =
                (Appointment) entity;

        appointmentCount++;
    }


    // Remove appointment by ID
    @Override
    public void removeById(String id) {

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i] != null
                    && appointments[i].getAppointmentId() != null
                    && appointments[i]
                    .getAppointmentId()
                    .equals(id)) {

                for (int j = i;
                     j < appointmentCount - 1;
                     j++) {

                    appointments[j] =
                            appointments[j + 1];
                }

                appointments[appointmentCount - 1] =
                        null;

                appointmentCount--;

                return;
            }
        }

        System.out.println("Appointment not found.");
    }


    // Get all appointments
    @Override
    public Object[] getAll() {

        Appointment[] allAppointments =
                new Appointment[appointmentCount];

        for (int i = 0;
             i < appointmentCount;
             i++) {

            allAppointments[i] =
                    appointments[i];
        }

        return allAppointments;
    }


    // Search appointment by keyword
    @Override
    public Object[] search(String keyword) {

        Appointment[] results =
                new Appointment[appointmentCount];

        int resultCount = 0;

        if (keyword == null || keyword.isBlank()) {
            return new Appointment[0];
        }

        for (int i = 0;
             i < appointmentCount;
             i++) {

            if (appointments[i] == null) {
                continue;
            }

            String status =
                    appointments[i].getStatus();

            String reason =
                    appointments[i].getReason();

            if ((status != null
                    && status.equalsIgnoreCase(keyword))
                    ||
                    (reason != null
                            && reason.equalsIgnoreCase(keyword))) {

                results[resultCount] =
                        appointments[i];

                resultCount++;
            }
        }

        Appointment[] finalResults =
                new Appointment[resultCount];

        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }

        return finalResults;
    }


    // Search appointment by ID
    @Override
    public Object searchById(String id) {

        for (int i = 0;
             i < appointmentCount;
             i++) {

            if (appointments[i] != null
                    && appointments[i].getAppointmentId() != null
                    && appointments[i]
                    .getAppointmentId()
                    .equals(id)) {

                return appointments[i];
            }
        }

        return null;
    }


    // Cancel appointment by ID
    public void cancel(String appointmentId) {

        for (int i = 0;
             i < appointmentCount;
             i++) {

            if (appointments[i] != null
                    && appointments[i].getAppointmentId() != null
                    && appointments[i]
                    .getAppointmentId()
                    .equals(appointmentId)) {

                appointments[i].cancel();

                return;
            }
        }

        System.out.println("Appointment not found.");
    }


    // Complete appointment by ID
    public void complete(String appointmentId) {

        for (int i = 0;
             i < appointmentCount;
             i++) {

            if (appointments[i] != null
                    && appointments[i].getAppointmentId() != null
                    && appointments[i]
                    .getAppointmentId()
                    .equals(appointmentId)) {

                appointments[i].complete();

                return;
            }
        }

        System.out.println("Appointment not found.");
    }


    // Reschedule appointment
    public void reschedule(
            String appointmentId,
            String newDate,
            String newTime
    ) {

        for (int i = 0;
             i < appointmentCount;
             i++) {

            if (appointments[i] != null
                    && appointments[i].getAppointmentId() != null
                    && appointments[i]
                    .getAppointmentId()
                    .equals(appointmentId)) {

                appointments[i].reschedule(
                        newDate,
                        newTime
                );

                return;
            }
        }

        System.out.println("Appointment not found.");
    }


    // List appointments by status
    public Appointment[] listByStatus(String status) {

        Appointment[] results =
                new Appointment[appointmentCount];

        int resultCount = 0;

        if (status == null || status.isBlank()) {
            return new Appointment[0];
        }

        for (int i = 0;
             i < appointmentCount;
             i++) {

            if (appointments[i] != null
                    && appointments[i].getStatus() != null
                    && appointments[i]
                    .getStatus()
                    .equalsIgnoreCase(status)) {

                results[resultCount] =
                        appointments[i];

                resultCount++;
            }
        }

        Appointment[] finalResults =
                new Appointment[resultCount];

        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }

        return finalResults;
    }


    // List appointments by patient ID
    public Appointment[] listByPatient(
            String patientId
    ) {

        Appointment[] results =
                new Appointment[appointmentCount];

        int resultCount = 0;

        if (patientId == null
                || patientId.isBlank()) {

            return new Appointment[0];
        }

        for (int i = 0;
             i < appointmentCount;
             i++) {

            if (appointments[i] != null
                    && appointments[i].getPatientId() != null
                    && appointments[i]
                    .getPatientId()
                    .equals(patientId)) {

                results[resultCount] =
                        appointments[i];

                resultCount++;
            }
        }

        Appointment[] finalResults =
                new Appointment[resultCount];

        for (int i = 0;
             i < resultCount;
             i++) {

            finalResults[i] =
                    results[i];
        }

        return finalResults;
    }
}