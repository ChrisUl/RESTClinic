package de.novatec.rest.clinic.domain.appointment;

import java.util.ArrayList;
import java.util.Collection;

public class Appointments {

    public Collection<Appointment> appointments = new ArrayList<Appointment>();

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

}
