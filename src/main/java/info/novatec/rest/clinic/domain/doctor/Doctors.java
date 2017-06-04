package info.novatec.rest.clinic.domain.doctor;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "doctors")
public class Doctors {

    protected Collection<Doctor> doctors = new ArrayList<Doctor>();

    @XmlElementRef
    public Collection<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Collection<Doctor> doctors) {
        this.doctors = doctors;
    }

}
