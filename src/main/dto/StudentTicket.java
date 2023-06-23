package main.dto;


import java.io.Serializable;

public class StudentTicket implements Serializable {
    private Student student;
    private Ticket ticket;

    public StudentTicket() {
    }

    public StudentTicket(Student student, Ticket ticket) {
        this.student = student;
        this.ticket = ticket;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    @Override
    public String toString() {
        return
                "student: '" + getStudent().toString() + "'" + "\n" +
                "ticket: '" + getTicket().toString() + "'" + "\n";
    }

}