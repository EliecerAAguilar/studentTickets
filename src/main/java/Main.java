package main.java;
import java.util.Scanner;

import main.java.dto.Student;
import main.java.dto.StudentTicket;
import main.java.dto.Ticket;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentTicket[] studentTickets;
        studentTickets = data();
        login(studentTickets);
    }

    private static StudentTicket[] data(){
        StudentTicket[] studentTickets = new StudentTicket[3];
        Student st01 = new Student("Juan", "pass",true,true);
        Student st02 = new Student("Pedro", "pass",true,false);
        Student st03 = new Student("Maria", "hello",true,true);
        Ticket tk01 = new Ticket("Juan","Perez","8-444-2222","juan@mail.com","Lic. Desarrollo");
        Ticket tk02 = new Ticket("Pedro","Ramos","2-000-111","pedro@mail.com","Lic. comunicacion");
        studentTickets[0].setStudent(st01);
        studentTickets[0].setTicket(tk01);
        studentTickets[1].setStudent(st02);
        studentTickets[1].setTicket(tk02);
        studentTickets[2].setStudent(st03);
        return studentTickets;
    }

    private static void login(StudentTicket[] estudiantes){
        String user;
        String password;
        System.out.println("===== Login Page =====");
        System.out.print("User: ");
        user = scanner.nextLine();
        System.out.println("");
        System.out.print("password: ");
        password = scanner.nextLine();
        System.out.println("");
        Student student = findStudent(user, estudiantes);
        if(student == null){return;}
        if(!student.getFirstLogin()){
            menu();
        }else{
            changePass(student.getPass());
        }


    }
    private static Student findStudent(String user, StudentTicket[] estudiantes){
        for (StudentTicket estudiante : estudiantes) {
            if(estudiante.getStudent().getUser().equals(user)){
                return estudiante.getStudent();
            }
        }
        System.out.println("! ESTUDIANTE NO ENCONTRADO!");
        return null;
    }

    private static Boolean changePass(String pasString){
        String old;
        String newPass1;
        String newPass2;
        System.out.println("===== Change Password Page =====");
        System.out.print("Old Password: ");
        old = scanner.nextLine();
        System.out.println("");
        System.out.print("New Password: ");
        newPass1 = scanner.nextLine();
        System.out.println("");
        System.out.print("New Password: ");
        newPass2 = scanner.nextLine();
        if(!pasString.equals(old)){return false;}
        if (!newPass1.equals(newPass2)) {return false;}
        System.out.println("You have change your password");
        return true;

    }

    private static void menu(){
        // switch case, 1 "subir ticket" 2 "ver tickets" 3 "salir"
        int opcion;
        System.out.println("===== Menu Page =====");
        System.out.println("1. Subir Ticket");
        System.out.println("2. Ver Tickets");
        System.out.println("3. Salir");
        System.out.print("Opcion: ");
        opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                subirTicket();
                break;
            case 2:
                verTickets();
                break;
            case 3:
                System.out.println("saliendo");
                main();
                break;
            default:
                System.out.println("Opcion no valida");
                break;

    }
}
