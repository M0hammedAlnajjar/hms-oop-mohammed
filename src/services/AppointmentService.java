package services;

import entities.Appointment;
import interfaces.Manageable;
import interfaces.Searchable;
import entities.Patient;
import entities.Doctor;
public class AppointmentService implements Manageable, Searchable {


    public Appointment schedule(
            String patientId,
            String doctorId,
            String date,
            String time
    ) {

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


    // Schedule appointment using IDs and date
    public Appointment schedule(
            String patientId,
            String doctorId,
            String date
    ) {

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
    @Override
    public void add(Object entity) {

    }

    @Override
    public void removeById(String id) {

    }

    @Override
    public Object[] getAll() {
        return new Object[0];
    }

    @Override
    public Object[] search(String keyword) {
        return new Object[0];
    }

    @Override
    public Object searchById(String id) {
        return null;
    }
    // Store appointments without generics
    private Appointment[] appointments = new Appointment[10];
    private int appointmentCount = 0;

    // Schedule appointment using full objects and reason
    public Appointment schedule(
            Patient patient,
            Doctor doctor,
            String date,
            String time,
            String reason
    ) {

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

    // Cancel appointment by ID
    public void cancel(String appointmentId) {

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i].getAppointmentId().equals(appointmentId)) {
                appointments[i].cancel();
                return;
            }
        }
    }
    // Complete appointment by ID
    public void complete(String appointmentId) {

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i].getAppointmentId().equals(appointmentId)) {
                appointments[i].complete();
                return;
            }
        }
    }
    // Reschedule appointment
    public void reschedule(
            String appointmentId,
            String newDate,
            String newTime
    ) {

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i].getAppointmentId().equals(appointmentId)) {

                appointments[i].setDate(newDate);
                appointments[i].setTime(newTime);

                return;
            }
        }
    }
    // List appointments by status
    public Appointment[] listByStatus(String status) {

        Appointment[] results = new Appointment[appointmentCount];
        int resultCount = 0;

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i].getStatus().equalsIgnoreCase(status)) {
                results[resultCount] = appointments[i];
                resultCount++;
            }
        }

        Appointment[] finalResults = new Appointment[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }
    // List appointments by patient ID
    public Appointment[] listByPatient(String patientId) {

        Appointment[] results = new Appointment[appointmentCount];
        int resultCount = 0;

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i].getPatientId().equals(patientId)) {
                results[resultCount] = appointments[i];
                resultCount++;
            }
        }

        Appointment[] finalResults = new Appointment[resultCount];

        for (int i = 0; i < resultCount; i++) {
            finalResults[i] = results[i];
        }

        return finalResults;
    }
}