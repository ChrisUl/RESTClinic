package info.novatec.rest.clinic.domain.patient;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "patients")
public class Patients {

    protected Collection<Patient> patients = new ArrayList<Patient>();

    @XmlElementRef
    public Collection<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Patient> patients) {
        this.patients = patients;
    }

}
