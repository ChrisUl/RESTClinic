package de.novatec.rest.clinic.domain.patient;

import java.net.URI;

public class Patient {

    private String id;

    private String name;

    private URI self;

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

    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }
}
