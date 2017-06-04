package de.novatec.rest.clinic.domain.patient;

import java.util.ArrayList;
import java.util.Collection;

public class Patients {

    protected Collection<Patient> patients = new ArrayList<Patient>();

    public Collection<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Patient> patients) {
        this.patients = patients;
    }

}
