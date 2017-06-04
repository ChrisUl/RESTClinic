package de.novatec.rest.clinic.domain.doctor;

import java.net.URI;

public class Doctor {

    private String id;

    private String name;

    private String role;

    private URI self;

    private URI appointments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }

    public URI getAppointments() {
        return appointments;
    }

    public void setAppointments(URI appointments) {
        this.appointments = appointments;
    }

}
