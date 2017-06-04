package de.novatec.rest.clinic.persistence;

import de.novatec.rest.clinic.domain.patient.Patient;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Persistence service for {@link Patient}.
 */
public class PatientPs {

    private static final Map<String, Patient> PATIENT_MAP = new HashMap<>();

    public Patient store(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException();
        }

        if (PATIENT_MAP.get(patient.getId()) != null) {
            throw new IllegalStateException();
        }

        PATIENT_MAP.put(patient.getId(), patient);

        return patient;
    }

    public void clear() {
        PATIENT_MAP.clear();
    }

    public Patient findById(String id) {
        return PATIENT_MAP.get(id);
    }

    public void deleteById(String id) {
        PATIENT_MAP.remove(id);
    }

    public Patient merge(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException();
        }

        Patient found = PATIENT_MAP.get(patient.getId());

        if (found == null) {
            PATIENT_MAP.put(patient.getId(), patient);
            return patient;
        } else {
            found.setId(patient.getId());
            found.setName(patient.getName());
            return found;
        }
    }

    public Collection<Patient> findAll() {
        return PATIENT_MAP.values();
    }
}
