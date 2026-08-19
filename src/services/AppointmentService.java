package services;

import entities.Appointment;
import interfaces.Manageable;
import interfaces.Searchable;
public class AppointmentService implements Manageable, Searchable {


    public Appointment schedule(
            String patientId,
            String doctorId,
            String date,
            String time
    ) {

        return null;
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
}