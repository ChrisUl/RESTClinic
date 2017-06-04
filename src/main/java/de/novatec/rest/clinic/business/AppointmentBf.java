package de.novatec.rest.clinic.business;

import de.novatec.rest.clinic.domain.appointment.Appointment;
import de.novatec.rest.clinic.exception.ResourceAlreadyExistsException;
import de.novatec.rest.clinic.util.IdGenerator;
import de.novatec.rest.clinic.domain.appointment.Appointments;
import de.novatec.rest.clinic.persistence.AppointmentPs;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Collection;

/**
 * Business function for {@link Appointment}.
 */
public class AppointmentBf {

    private AppointmentPs appointmentPs = new AppointmentPs();

    /**
     * Creates a new {@link Appointment} and generates an ID for it.
     *
     * @param appointment to create
     * @param baseUri from which to create self-link
     * @return created appointment
     */
    public Appointment create(Appointment appointment, URI baseUri) {
        if (appointment == null) {
            throw new IllegalArgumentException();
        }

        int id = IdGenerator.generateRandomId();

        appointment.setId(id);
        appointment.setSelf(UriBuilder.fromUri(baseUri).path(Integer.toString(id)).build());

        if (findById(id) != null) {
            throw new ResourceAlreadyExistsException();
        }

        return appointmentPs.store(appointment);
    }

    /**
     * Finds all {@link Appointment}s.
     *
     * @return {@link Appointments} containing all {@link Appointment}s
     */
    public Appointments findAll() {
        Appointments appointments = new Appointments();
        appointments.setAppointments(appointmentPs.findAll());

        return appointments;
    }

    /**
     * Finds all {@link Appointment}s that have a given doctor ID.
     *
     * @param doctorId to find by
     * @return {@link Appointments} containing all {@link Appointment}s which have the given doctor ID
     */
    public Appointments findByDoctorId(String doctorId) {
        Collection<Appointment> found = appointmentPs.findByDoctorId(doctorId);

        Appointments appointments = new Appointments();
        appointments.setAppointments(found);

        return appointments;
    }

    /**
     * Finds an {@link Appointment} by the given id.
     *
     * @param id to find by
     * @return {@link Appointment} or null if no appointment by that ID exists
     */
    public Appointment findById(int id) {
        return appointmentPs.findById(id);
    }

    /**
     * Finds all {@link Appointment}s on the given date.
     *
     * @param date to find by
     * @return all {@link Appointment}s on the given date.
     */
    public Appointments findByDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException();
        }

        Collection<Appointment> found = appointmentPs.findByDate(date);

        Appointments appointments = new Appointments();
        appointments.setAppointments(found);

        return appointments;
    }

    /**
     * Merges an {@link Appointment}.
     *
     * @param {@link Appointment} to merge
     * @return the merged appointment
     */
    public Appointment merge(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException();
        }

        return appointmentPs.merge(appointment);
    }

    /**
     * Deletes an {@link Appointment} with the given ID.
     * @param id of the {@link Appointment} to delete
     */
    public void deleteById(int id) {
        appointmentPs.deleteById(id);
    }

}
