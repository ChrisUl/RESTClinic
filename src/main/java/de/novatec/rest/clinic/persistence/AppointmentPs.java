package de.novatec.rest.clinic.persistence;

import de.novatec.rest.clinic.domain.appointment.Appointment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Persistence service for {@link Appointment}.
 */
public class AppointmentPs {

    private static final Map<Integer, Appointment> APPOINTMENT_MAP = new HashMap<Integer, Appointment>();

    public Collection<Appointment> findAll() {
        return APPOINTMENT_MAP.values();
    }

    public Appointment findById(int id) {
        return APPOINTMENT_MAP.get(id);
    }

    public Collection<Appointment> findByDoctorId(String doctorId) {
    	return Arrays.asList(APPOINTMENT_MAP.get(doctorId));
    }

    public Collection<Appointment> findByDate(String date) {
    	Collection<Appointment> appointmentCollection = new ArrayList<Appointment>();
    	
    	for (Appointment appointment : APPOINTMENT_MAP.values()) {
    		if (appointment.getDate().equals(date)) {
    			appointmentCollection.add(appointment);
    		}
    	}

        return appointmentCollection;
    }

    public Appointment merge(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException();
        }

        Appointment found = APPOINTMENT_MAP.get(appointment.getId());

        if (found == null) {
            APPOINTMENT_MAP.put(appointment.getId(), appointment);
            return appointment;
        } else {
            found.setId(appointment.getId());
            found.setPatientId(appointment.getPatientId());
            return found;
        }
    }

    public Appointment store(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException();
        }

        if (findById(appointment.getId()) != null) {
            throw new IllegalStateException();
        }

        APPOINTMENT_MAP.put(appointment.getId(), appointment);
        return appointment;
    }

    public void deleteById(int id) {
        APPOINTMENT_MAP.remove(id);
    }

    public void clear() {
        APPOINTMENT_MAP.clear();
    }


}
