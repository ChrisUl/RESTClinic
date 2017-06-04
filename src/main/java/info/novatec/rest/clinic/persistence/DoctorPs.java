package info.novatec.rest.clinic.persistence;

import info.novatec.rest.clinic.domain.doctor.Doctor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Persistence service for {@link Doctor}.
 */
public class DoctorPs {

    private static final Map<String, Doctor> DOCTOR_MAP = new HashMap<>();

    public Collection<Doctor> findAll() {
        return DOCTOR_MAP.values();
    }

    public Doctor findById(String id) {
        return DOCTOR_MAP.get(id);
    }

    public Collection<Doctor> findByRole(String role) {

        Collection<Doctor> doctors = findAll();
        
        Collection<Doctor> filteredByRole = new ArrayList<Doctor>();
        
        for(Doctor doctor : doctors) {
        	if (doctor.getRole().equalsIgnoreCase(role)) {
        		filteredByRole.add(doctor);
        	}
        }

        return filteredByRole;
    }

    public Doctor store(Doctor doctor) {
        if (doctor.getId() == null) {
            throw new IllegalArgumentException();
        }

         DOCTOR_MAP.put(doctor.getId(), doctor);
         
         return doctor;
    }

    public Doctor merge(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException();
        }

        Doctor found = DOCTOR_MAP.get(doctor.getId());

        if (found == null) {
            DOCTOR_MAP.put(doctor.getId(), doctor);
            return doctor;
        } else {
            found.setName(doctor.getName());
            found.setRole(doctor.getRole());
            return found;
        }
    }

    public void deleteById(String id) {
        DOCTOR_MAP.remove(id);
    }


    protected void clear() {
        DOCTOR_MAP.clear();
    }
}
