package de.novatec.rest.clinic.domain.appointment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

@XmlRootElement(name = "appointment")
public class Appointment {

    private int id;

    private String patientId;

    private String doctorId;

    private String date;

    private String start;

    private String end;

    private URI self;

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patient) { this.patientId = patient; }

    @XmlElement
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @XmlElement
    public String getEnd() {
        return end;
    }

    public void setEnd(String specialty) {
        this.end = specialty;
    }

    @XmlElement
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @XmlElement
    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }

}
