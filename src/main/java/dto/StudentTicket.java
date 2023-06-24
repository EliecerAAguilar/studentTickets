package main.java.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentTicket implements Serializable {
    private Student student;
    private List<Ticket> tickets;

    public StudentTicket() {
    }

    public StudentTicket(Student student) {
        this.student = student;
        this.tickets = new ArrayList<>();
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    @Override
    public String toString() {
        return
                "student: '" + getStudent().toString() + "'" + "\n" +
                "ticket: '" + getTickets().toString() + "'" + "\n";
    }

}