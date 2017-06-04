package info.novatec.rest.clinic.business;

import info.novatec.rest.clinic.domain.patient.Patient;
import info.novatec.rest.clinic.domain.patient.Patients;
import info.novatec.rest.clinic.exception.ResourceAlreadyExistsException;
import info.novatec.rest.clinic.persistence.PatientPs;
import info.novatec.rest.clinic.util.IdGenerator;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Business function for {@link Patient}.
 */
public class PatientBf {

    private PatientPs patientPs = new PatientPs();

    /**
     * Creates a {@link Patient} and generates an ID.
     *
     * @param patient to create
     * @param baseUri by which to create hypermedia links
     * @return the created {@link Patient}
     */
    public Patient create(Patient patient, URI baseUri) {
        if (patient == null) {
            throw new IllegalArgumentException();
        }

        String id = IdGenerator.generateIdByName(patient.getName());

        patient.setId(id);
        patient.setSelf(UriBuilder.fromUri(baseUri).path(id).build());

        if (findById(id) != null) {
            throw new ResourceAlreadyExistsException();
        }

        return patientPs.store(patient);
    }

    /**
     * Deletes a {@link Patient} with the given ID.
     *
     * @param id of the {@link Patient} to delete
     */
    public void deleteById(String id) {
        patientPs.deleteById(id);
    }

    /**
     * Finds a {@link Patient} by its ID.
     *
     * @param id of the {@link Patient}
     * @return {@link Patient} or null if not found
     */
    public Patient findById(String id) {
        return patientPs.findById(id);
    }

    /**
     * Merges a {@link Patient}.
     *
     * @param patient to merge
     * @return the merged {@link Patient}
     */
    public Patient merge(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException();
        }

        return patientPs.merge(patient);
    }

    /**
     * Finds all {@link Patient}s.
     *
     * @return {@link Patients} containing all {@link Patient}s
     */
    public Patients findAll() {
        Patients patients = new Patients();
        patients.setPatients(patientPs.findAll());

        return patients;
    }

}
