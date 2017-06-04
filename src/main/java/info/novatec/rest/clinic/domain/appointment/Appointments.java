package info.novatec.rest.clinic.domain.appointment;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "appointments")
public class Appointments {

    protected Collection<Appointment> appointments = new ArrayList<Appointment>();

    @XmlElementRef
    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

}
