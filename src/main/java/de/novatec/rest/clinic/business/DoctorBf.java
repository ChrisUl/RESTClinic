package de.novatec.rest.clinic.business;

import de.novatec.rest.clinic.exception.ResourceAlreadyExistsException;
import de.novatec.rest.clinic.domain.doctor.Doctor;
import de.novatec.rest.clinic.domain.doctor.Doctors;
import de.novatec.rest.clinic.persistence.DoctorPs;
import de.novatec.rest.clinic.util.IdGenerator;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Collection;

/**
 * Business function for {@link Doctor}.
 */
public class DoctorBf {

    private DoctorPs doctorPs = new DoctorPs();

    /**
     * Creates a {@link Doctor} and generates an ID.
     *
     * @param doctor to create
     * @param baseUri from which to create hypermedia links
     * @return the created {@link Doctor}
     */
    public Doctor create(Doctor doctor, URI baseUri) {
        if (doctor == null) {
            throw new IllegalArgumentException();
        }

        String id = IdGenerator.generateIdByName(doctor.getName());

        doctor.setId(id);
        doctor.setSelf(UriBuilder.fromUri(baseUri).path(id).build());
        doctor.setAppointments(UriBuilder.fromUri(baseUri).path("appointments").build());

        if (findById(id) != null) {
            throw new ResourceAlreadyExistsException();
        }

        return doctorPs.store(doctor);
    }

    /**
     * Finds all {@link Doctor}s.
     *
     * @return {@link Doctors} containing all {@link Doctor}s.
     */
    public Doctors findAll() {
        Doctors doctors = new Doctors();
        doctors.setDoctors(doctorPs.findAll());

        return doctors;
    }

    /**
     * Finds {@link Doctor}s by the given role.
     *
     * @param role to find by
     * @return {@link Doctors} containing the {@link Doctor}s which have the given role
     */
    public Doctors findByRole(String role) {
        Collection<Doctor> found = doctorPs.findByRole(role);

        Doctors doctors = new Doctors();
        doctors.setDoctors(found);

        return doctors;
    }

    /**
     * Finds a {@link Doctor} by an ID.
     *
     * @param id of the doctor
     * @return {@link Doctor} or null if not found
     */
    public Doctor findById(String id) {
        return doctorPs.findById(id);
    }

    /**
     * Merges a {@link Doctor}.
     *
     * @param doctor to merge
     * @return the merged {@link Doctor}
     */
    public Doctor merge(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException();
        }

        return doctorPs.merge(doctor);
    }

    /**
     * Deletes a {@link Doctor} with the given ID.
     *
     * @param id of the {@link Doctor} to delete.
     */
    public void deleteById(String id) {
        doctorPs.deleteById(id);
    }

}
