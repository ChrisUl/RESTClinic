package info.novatec.rest.clinic.domain.doctor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

@XmlRootElement(name = "doctor")
public class Doctor {

    private String id;

    private String name;

    private String role;

    private URI self;

    private URI appointments;

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getRole() {
        return role;
    }

    public void setRole(String specialty) {
        this.role = specialty;
    }

    @XmlElement
    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }

    @XmlElement
    public URI getAppointments() {
        return appointments;
    }

    public void setAppointments(URI appointments) {
        this.appointments = appointments;
    }

}
