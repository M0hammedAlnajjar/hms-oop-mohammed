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


    public Appointment schedule(
            String patientId,
            String doctorId,
            String date,
            String time,
            String reason
    ) {

        return null;
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
}