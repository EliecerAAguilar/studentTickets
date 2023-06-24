package main.java.dto;

import java.io.Serializable;
import java.util.UUID;

public class Ticket implements Serializable {
    private String name;
    private String lastName;
    private String id;
    private String email;
    private String degree;
    private final String ticketID = (UUID.randomUUID()).toString();

    public Ticket() {
    }

    public Ticket(String name, String lastName, String id, String email, String degree) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.degree = degree;
    }

    public String getTicketID() {
        return this.ticketID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return
                "name: '" + getName() + "'" + "\n" +
                        "lastName: '" + getLastName() + "'" + "\n" +
                        "id: '" + getId() + "'" + "\n" +
                        "email: '" + getEmail() + "'" + "\n" +
                        "degree: '" + getDegree() + "'" + "\n";
    }

}